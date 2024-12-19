package net.pythonbear.tead.block.entity;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.SharedConstants;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.LockableContainerBlockEntity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.pythonbear.tead.block.SmelterBlock;
import net.pythonbear.tead.init.TeadTags;
import net.pythonbear.tead.recipe.TeadRecipeTypes;
import net.pythonbear.tead.recipe.AlloyCookingRecipe;
import net.pythonbear.tead.screen.SmelterScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SmelterBlockEntity extends LockableContainerBlockEntity implements ExtendedScreenHandlerFactory,
        ImplementedInventory, SidedInventory, RecipeUnlocker, RecipeInputProvider {
    protected DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);
    private static final int INPUT_SLOT_ONE = 0;
    private static final int INPUT_SLOT_TWO = 1;
    private static final int INPUT_FUEL_SLOT = 2;
    private static final int OUTPUT_SLOT = 3;
    private static final int[] FUEL_SLOTS = new int[]{2};
    private static final int[] BOTTOM_SLOTS = new int[]{3};
    private static final int[] TOP_SLOTS = new int[]{0, 1};
    private static final int[] RIGHT_SLOTS = new int[]{0};
    private static final int[] LEFT_SLOTS = new int[]{1};
    int burnTime;
    int fuelTime;
    int cookTime;
    int cookTimeTotal;
    private final RecipeManager.MatchGetter<Inventory, ? extends AlloyCookingRecipe> matchGetter;
    protected final PropertyDelegate propertyDelegate = new PropertyDelegate(){
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> SmelterBlockEntity.this.burnTime;
                case 1 -> SmelterBlockEntity.this.fuelTime;
                case 2 -> SmelterBlockEntity.this.cookTime;
                case 3 -> SmelterBlockEntity.this.cookTimeTotal;
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0: {
                    SmelterBlockEntity.this.burnTime = value;
                    break;
                }
                case 1: {
                    SmelterBlockEntity.this.fuelTime = value;
                    break;
                }
                case 2: {
                    SmelterBlockEntity.this.cookTime = value;
                    break;
                }
                case 3: {
                    SmelterBlockEntity.this.cookTimeTotal = value;
                    break;
                }
            }
        }

        @Override
        public int size() {
            return 4;
        }
    };
    private final Object2IntOpenHashMap<Identifier> recipesUsed = new Object2IntOpenHashMap();

    public SmelterBlockEntity(BlockPos pos, BlockState state) {
        super(TeadBlockEntities.SMELTER_BLOCK_ENTITY, pos, state);
        this.matchGetter = RecipeManager.createCachedMatchGetter(TeadRecipeTypes.ALLOY_SMELTING);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("container.tead.smelter");
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.tead.smelter");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new SmelterScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public static Map<Item, Integer> createFuelTimeMap() {
        return AbstractFurnaceBlockEntity.createFuelTimeMap();
    }

    /**
     * {@return whether the provided {@code item} is in the {@link
     * net.minecraft.registry.tag.ItemTags#NON_FLAMMABLE_WOOD non_flammable_wood} tag}
     */
    private static boolean isNonFlammableWood(Item item) {
        return item.getRegistryEntry().isIn(ItemTags.NON_FLAMMABLE_WOOD);
    }

    private static void addFuel(Map<Item, Integer> fuelTimes, TagKey<Item> tag, int fuelTime) {
        for (RegistryEntry<Item> registryEntry : Registries.ITEM.iterateEntries(tag)) {
            if (SmelterBlockEntity.isNonFlammableWood(registryEntry.value())) continue;
            fuelTimes.put(registryEntry.value(), fuelTime);
        }
    }

    private static void addFuel(Map<Item, Integer> fuelTimes, ItemConvertible item, int fuelTime) {
        Item item2 = item.asItem();
        if (SmelterBlockEntity.isNonFlammableWood(item2)) {
            if (SharedConstants.isDevelopment) {
                throw Util.throwOrPause(new IllegalStateException("A developer tried to explicitly make fire resistant item " + item2.getName(null).getString() + " a furnace fuel. That will not work!"));
            }
            return;
        }
        fuelTimes.put(item2, fuelTime);
    }

    private boolean isBurning() {
        return this.burnTime > 0;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        Inventories.readNbt(nbt, this.inventory);
        this.burnTime = nbt.getShort("BurnTime");
        this.cookTime = nbt.getShort("CookTime");
        this.cookTimeTotal = nbt.getShort("CookTimeTotal");
        this.fuelTime = this.getFuelTime(this.inventory.get(1));
        NbtCompound nbtCompound = nbt.getCompound("RecipesUsed");
        for (String string : nbtCompound.getKeys()) {
            this.recipesUsed.put(new Identifier(string), nbtCompound.getInt(string));
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putShort("BurnTime", (short)this.burnTime);
        nbt.putShort("CookTime", (short)this.cookTime);
        nbt.putShort("CookTimeTotal", (short)this.cookTimeTotal);
        Inventories.writeNbt(nbt, this.inventory);
        NbtCompound nbtCompound = new NbtCompound();
        this.recipesUsed.forEach((identifier, count) -> nbtCompound.putInt(identifier.toString(), count));
        nbt.put("RecipesUsed", nbtCompound);
    }

    public static void tick(World world, BlockPos pos, BlockState state, SmelterBlockEntity blockEntity) {
        boolean blockIsBurning = blockEntity.isBurning();
        boolean bl2 = false;
        if (blockEntity.isBurning()) {
            --blockEntity.burnTime;
        }
        ItemStack fuelItemStack = blockEntity.inventory.get(INPUT_FUEL_SLOT);
        boolean inputIsNotEmpty = !blockEntity.inventory.get(INPUT_SLOT_ONE).isEmpty()
                && !blockEntity.inventory.get(INPUT_SLOT_TWO).isEmpty();
        boolean fuelNotEmpty = !fuelItemStack.isEmpty();
        if (blockEntity.isBurning() || fuelNotEmpty && inputIsNotEmpty) {
            Recipe recipe = inputIsNotEmpty
                    ? blockEntity.matchGetter.getFirstMatch(blockEntity, world).orElse(null) : null;
            int i = blockEntity.getMaxCountPerStack();
            if (!blockEntity.isBurning() &&
                    SmelterBlockEntity.canAcceptRecipeOutput(world.getRegistryManager(), recipe, blockEntity.inventory, i)) {
                blockEntity.fuelTime = blockEntity.burnTime = blockEntity.getFuelTime(fuelItemStack);
                if (blockEntity.isBurning()) {
                    bl2 = true;
                    if (fuelNotEmpty) {
                        Item item = fuelItemStack.getItem();
                        fuelItemStack.decrement(1);
                        if (fuelItemStack.isEmpty()) {
                            Item item2 = item.getRecipeRemainder();
                            blockEntity.inventory.set(INPUT_FUEL_SLOT, item2 == null
                                    ? ItemStack.EMPTY : new ItemStack(item2));
                        }
                    }
                }
            }
            if (blockEntity.isBurning() && SmelterBlockEntity.canAcceptRecipeOutput(world.getRegistryManager(),
                    recipe, blockEntity.inventory, i)) {
                ++blockEntity.cookTime;
                if (blockEntity.cookTime == blockEntity.cookTimeTotal) {
                    blockEntity.cookTime = 0;
                    blockEntity.cookTimeTotal = SmelterBlockEntity.getCookTime(world, blockEntity);
                    if (SmelterBlockEntity.craftRecipe(world.getRegistryManager(), recipe, blockEntity.inventory, i)) {
                        blockEntity.setLastRecipe(recipe);
                    }
                    bl2 = true;
                }
            } else {
                blockEntity.cookTime = 0;
            }
        } else if (!blockEntity.isBurning() && blockEntity.cookTime > 0) {
            blockEntity.cookTime = MathHelper.clamp(blockEntity.cookTime - 2, 0, blockEntity.cookTimeTotal);
        }
        if (blockIsBurning != blockEntity.isBurning()) {
            bl2 = true;
            state = state.with(SmelterBlock.LIT, blockEntity.isBurning());
            world.setBlockState(pos, state, Block.NOTIFY_ALL);
        }
        if (bl2) {
            SmelterBlockEntity.markDirty(world, pos, state);
        }
    }

    private static boolean canAcceptRecipeOutput(DynamicRegistryManager registryManager, @Nullable Recipe<?> recipe,
                                                 DefaultedList<ItemStack> slots, int count) {
        if (slots.get(INPUT_SLOT_ONE).isEmpty() || slots.get(INPUT_SLOT_TWO).isEmpty() || recipe == null) {
            return false;
        }
        ItemStack itemStack = recipe.getOutput(registryManager);
        if (itemStack.isEmpty()) {
            return false;
        }
        ItemStack itemStack2 = slots.get(OUTPUT_SLOT);
        if (itemStack2.isEmpty()) {
            return true;
        }
        if (!ItemStack.areItemsEqual(itemStack2, itemStack)) {
            return false;
        }
        if (itemStack2.getCount() < count && itemStack2.getCount() < itemStack2.getMaxCount()) {
            return true;
        }
        return itemStack2.getCount() < itemStack.getMaxCount();
    }

    private static boolean craftRecipe(DynamicRegistryManager registryManager, @Nullable Recipe<?> recipe,
                                       DefaultedList<ItemStack> slots, int count) {
        if (recipe == null || !SmelterBlockEntity.canAcceptRecipeOutput(registryManager, recipe, slots, count)) {
            return false;
        }
        ItemStack inputItemStack1 = slots.get(INPUT_SLOT_ONE);
        ItemStack inputItemStack2 = slots.get(INPUT_SLOT_TWO);
        ItemStack recipeOutputItemStack = recipe.getOutput(registryManager);
        ItemStack outputItemStack = slots.get(OUTPUT_SLOT);
        if (outputItemStack.isEmpty()) {
            slots.set(OUTPUT_SLOT, recipeOutputItemStack.copy());
        } else if (outputItemStack.isOf(recipeOutputItemStack.getItem())) {
            outputItemStack.increment(1);
        }
        inputItemStack1.decrement(1);
        inputItemStack2.decrement(1);
        return true;
    }

    protected int getFuelTime(ItemStack fuel) {
        if (fuel.isEmpty()) {
            return 0;
        }
        Item item = fuel.getItem();
        return SmelterBlockEntity.createFuelTimeMap().getOrDefault(item, 0);
    }

    private static int getCookTime(World world, SmelterBlockEntity furnace) {
        return furnace.matchGetter.getFirstMatch(furnace, world).map(AlloyCookingRecipe::getCookTime).orElse(200);
    }

    public static boolean canUseAsFuel(ItemStack stack) {
        return SmelterBlockEntity.createFuelTimeMap().containsKey(stack.getItem());
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        Direction facing = this.getCachedState().get(Properties.HORIZONTAL_FACING);
        Direction right = facing.rotateYClockwise();
        Direction left = facing.rotateYCounterclockwise();

        if (side == Direction.DOWN) {
            return BOTTOM_SLOTS;
        }
        if (side == Direction.UP) {
            return TOP_SLOTS;
        }
        if (side == right) {
            return RIGHT_SLOTS;
        }
        if (side == left) {
            return LEFT_SLOTS;
        }
        return FUEL_SLOTS;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return this.isValid(slot, stack);
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return true;
    }

    @Override
    public int size() {
        return this.inventory.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemStack : this.inventory) {
            if (itemStack.isEmpty()) continue;
            return false;
        }
        return true;
    }

    @Override
    public ItemStack getStack(int slot) {
        return this.inventory.get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        return Inventories.splitStack(this.inventory, slot, amount);
    }

    @Override
    public ItemStack removeStack(int slot) {
        return Inventories.removeStack(this.inventory, slot);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        ItemStack itemStack = this.inventory.get(slot);
        boolean stackIsNotEmptyAndCanCombine = !stack.isEmpty() && ItemStack.canCombine(itemStack, stack);
        this.inventory.set(slot, stack);
        if (stack.getCount() > this.getMaxCountPerStack()) {
            stack.setCount(this.getMaxCountPerStack());
        }
        if ((slot == INPUT_SLOT_ONE || slot == INPUT_SLOT_TWO) && !stackIsNotEmptyAndCanCombine) {
            this.cookTimeTotal = SmelterBlockEntity.getCookTime(this.world, this);
            this.cookTime = 0;
            this.markDirty();
        }
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return Inventory.canPlayerUse(this, player);
    }

    @Override
    public boolean isValid(int slot, ItemStack stack) {
        if (slot == OUTPUT_SLOT) {
            return false;
        }
        if (slot == INPUT_SLOT_ONE) {
            ItemStack itemStack = this.inventory.get(INPUT_SLOT_ONE);
            return (stack.isIn(TeadTags.Items.ALLOYABLE_ITEMS) && itemStack.isEmpty()) || stack.isOf(itemStack.getItem());
        } else if (slot == INPUT_SLOT_TWO) {
            ItemStack itemStack = this.inventory.get(INPUT_SLOT_TWO);
            return (stack.isIn(TeadTags.Items.ALLOYABLE_ITEMS) && itemStack.isEmpty()) || stack.isOf(itemStack.getItem());
        } else if (slot == INPUT_FUEL_SLOT) {
            ItemStack itemStack = this.inventory.get(INPUT_FUEL_SLOT);
            return (SmelterBlockEntity.canUseAsFuel(stack) && itemStack.isEmpty()) || stack.isOf(itemStack.getItem());
        }
        return true;
    }

    @Override
    public void clear() {
        this.inventory.clear();
    }

    @Override
    public void setLastRecipe(@Nullable Recipe<?> recipe) {
        if (recipe != null) {
            Identifier identifier = recipe.getId();
            this.recipesUsed.addTo(identifier, 1);
        }
    }

    @Override
    @Nullable
    public Recipe<?> getLastRecipe() {
        return null;
    }

    @Override
    public void unlockLastRecipe(PlayerEntity player, List<ItemStack> ingredients) {
    }

    public void dropExperienceForRecipesUsed(ServerPlayerEntity player) {
        List<Recipe<?>> list = this.getRecipesUsedAndDropExperience(player.getServerWorld(), player.getPos());
        player.unlockRecipes(list);
        for (Recipe<?> recipe : list) {
            if (recipe == null) continue;
            player.onRecipeCrafted(recipe, this.inventory);
        }
        this.recipesUsed.clear();
    }

    public List<Recipe<?>> getRecipesUsedAndDropExperience(ServerWorld world, Vec3d pos) {
        ArrayList<Recipe<?>> list = Lists.newArrayList();
        for (Object2IntMap.Entry entry : this.recipesUsed.object2IntEntrySet()) {
            world.getRecipeManager().get((Identifier)entry.getKey()).ifPresent(recipe -> {
                list.add((Recipe<?>)recipe);
                SmelterBlockEntity.dropExperience(world, pos, entry.getIntValue(), ((AbstractCookingRecipe)recipe).getExperience());
            });
        }
        return list;
    }

    private static void dropExperience(ServerWorld world, Vec3d pos, int multiplier, float experience) {
        int i = MathHelper.floor((float)multiplier * experience);
        float f = MathHelper.fractionalPart((float)multiplier * experience);
        if (f != 0.0f && Math.random() < (double)f) {
            ++i;
        }
        ExperienceOrbEntity.spawn(world, pos, i);
    }

    @Override
    public void provideRecipeInputs(RecipeMatcher finder) {
        for (ItemStack itemStack : this.inventory) {
            finder.addInput(itemStack);
        }
    }
}
