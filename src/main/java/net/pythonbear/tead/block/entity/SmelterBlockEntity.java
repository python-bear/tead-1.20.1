package net.pythonbear.tead.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.pythonbear.tead.init.TeadBlockEntities;
import org.jetbrains.annotations.Nullable;

public class SmelterBlockEntity extends AbstractFurnaceBlockEntity implements ExtendedScreenHandlerFactory,
        ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);
    private static final int INPUT_SLOT_ONE = 0;
    private static final int INPUT_SLOT_TWO = 1;
    private static final int INPUT_FUEL_SLOT = 2;
    private static final int OUTPUT_SLOT = 3;
    int burnTime;
    int fuelTime;
    int cookTime;
    int cookTimeTotal;
    private final RecipeManager.MatchGetter<Inventory, ? extends AbstractCookingRecipe> matchGetter;
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

    public SmelterBlockEntity(BlockPos pos, BlockState state, RecipeType<? extends AbstractCookingRecipe> recipeType) {
        super(TeadBlockEntities.SMELTER_BLOCK_ENTITY, pos, state, RecipeType.SMELTING);
        this.matchGetter = RecipeManager.createCachedMatchGetter(recipeType);
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

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return null;
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return null;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
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
        ItemStack outputStack = slots.get(OUTPUT_SLOT);
        if (outputStack.isEmpty()) {
            return true;
        }
        if (!ItemStack.areItemsEqual(outputStack, itemStack)) {
            return false;
        }
        if (outputStack.getCount() < count && outputStack.getCount() < outputStack.getMaxCount()) {
            return true;
        }
        return outputStack.getCount() < itemStack.getMaxCount();
    }

    private static int getCookTime(World world, SmelterBlockEntity furnace) {
        return furnace.matchGetter.getFirstMatch(furnace, world).map(AbstractCookingRecipe::getCookTime)
                .orElse(200);
    }

    private static boolean craftRecipe(DynamicRegistryManager registryManager, @Nullable Recipe<?> recipe,
                                       DefaultedList<ItemStack> slots, int count) {
        if (recipe == null || !SmelterBlockEntity.canAcceptRecipeOutput(registryManager, recipe, slots, count)) {
            return false;
        }
        ItemStack inputStackOne = slots.get(INPUT_SLOT_ONE);
        ItemStack inputStackTwo = slots.get(INPUT_SLOT_TWO);
        ItemStack itemStack2 = recipe.getOutput(registryManager);
        ItemStack outputStack = slots.get(OUTPUT_SLOT);
        if (outputStack.isEmpty()) {
            slots.set(OUTPUT_SLOT, itemStack2.copy());
        } else if (outputStack.isOf(itemStack2.getItem())) {
            outputStack.increment(1);
        }
        inputStackOne.decrement(1);
        inputStackTwo.decrement(1);
        return true;
    }

    private boolean isBurning() {
        return this.burnTime > 0;
    }

    public static void tick(World world, BlockPos pos, BlockState state, SmelterBlockEntity blockEntity) {
        boolean fuelIsNotEmpty;
        boolean blockIsBurning = blockEntity.isBurning();
        boolean bl2 = false;
        if (blockEntity.isBurning()) {
            --blockEntity.burnTime;
        }
        ItemStack fuelStack = blockEntity.inventory.get(INPUT_FUEL_SLOT);
        boolean inputNotEmpty = !blockEntity.inventory.get(INPUT_SLOT_ONE).isEmpty() &
                !blockEntity.inventory.get(INPUT_SLOT_TWO).isEmpty();
        boolean bl5 = fuelIsNotEmpty = !fuelStack.isEmpty();
        if (blockEntity.isBurning() || fuelIsNotEmpty && inputNotEmpty) {
            Recipe recipe = inputNotEmpty ? blockEntity.matchGetter.getFirstMatch(blockEntity,
                    world).orElse(null) : null;
            int i = blockEntity.getMaxCountPerStack();
            if (!blockEntity.isBurning() && SmelterBlockEntity.canAcceptRecipeOutput(world.getRegistryManager(), recipe,
                    blockEntity.inventory, i)) {
                blockEntity.fuelTime = blockEntity.burnTime = blockEntity.getFuelTime(fuelStack);
                if (blockEntity.isBurning()) {
                    bl2 = true;
                    if (fuelIsNotEmpty) {
                        Item fuelItem = fuelStack.getItem();
                        fuelStack.decrement(1);
                        if (fuelStack.isEmpty()) {
                            Item item2 = fuelItem.getRecipeRemainder();
                            blockEntity.inventory.set(INPUT_FUEL_SLOT,
                                    item2 == null ? ItemStack.EMPTY : new ItemStack(item2));
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
            state = state.with(AbstractFurnaceBlock.LIT, blockEntity.isBurning());
            world.setBlockState(pos, state, Block.NOTIFY_ALL);
        }
        if (bl2) {
            AbstractFurnaceBlockEntity.markDirty(world, pos, state);
        }
    }
}
