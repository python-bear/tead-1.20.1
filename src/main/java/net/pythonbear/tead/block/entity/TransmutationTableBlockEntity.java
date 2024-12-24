package net.pythonbear.tead.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.JukeboxBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.enchantments.TeadEnchantments;
import net.pythonbear.tead.item.TeadItems;
import net.pythonbear.tead.item.ruby.RubyToolTransmuting;
import net.pythonbear.tead.item.ruby.TransmutableTool;
import net.pythonbear.tead.screen.TransmutationTableScreenHandler;
import net.pythonbear.tead.sound.TeadSounds;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransmutationTableBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private static final int RUBY_INGOT_SLOT = 0;
    private static final int LAPIS_LAZULI_SLOT = 1;
    private static final int INPUT_SLOT_ONE = 2;
    private static final int INPUT_SLOT_TWO = 3;
    private static final int INPUT_SLOT_THREE = 4;
    private static final int INPUT_SLOT_FOUR = 5;
    private static final int OUTPUT_SLOT = 6;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(7, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 124;
    public int ticks;
    public float nextPageAngle;
    public float pageAngle;
    public float flipRandom;
    public float flipTurn;
    public float nextPageTurningSpeed;
    public float pageTurningSpeed;
    public float bookRotation;
    public float lastBookRotation;
    public float targetBookRotation;
    private static final Random RANDOM = Random.create();

    public TransmutationTableBlockEntity(BlockPos pos, BlockState state) {
        super(TeadBlockEntities.TRANSMUTATION_TABLE_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> TransmutationTableBlockEntity.this.progress;
                    case 1 -> TransmutationTableBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> TransmutationTableBlockEntity.this.progress = value;
                    case 1 -> TransmutationTableBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("container.tead.transmutation_table");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new TransmutationTableScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, this.inventory);
        nbt.putInt("gemcutter.progress", this.progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, this.inventory);
        this.progress = nbt.getInt("gemcutter.progress");
    }

    private int lapisAmount() {
        return this.inventory.get(LAPIS_LAZULI_SLOT).getCount();
    }

    private int rubyIngotAmount() {
        return this.inventory.get(RUBY_INGOT_SLOT).getCount();
    }

    private boolean hasFullItem(Item item) {
        return this.inventory.get(INPUT_SLOT_ONE).getItem() == item &&
                this.inventory.get(INPUT_SLOT_TWO).getItem() == item &&
                this.inventory.get(INPUT_SLOT_THREE).getItem() == item &&
                this.inventory.get(INPUT_SLOT_FOUR).getItem() == item;
    }

    private boolean hasFullRubyTools() {
        List<ItemStack> rubyTools = new ArrayList<>();

        rubyTools.add(this.inventory.get(INPUT_SLOT_ONE));
        rubyTools.add(this.inventory.get(INPUT_SLOT_TWO));
        rubyTools.add(this.inventory.get(INPUT_SLOT_THREE));
        rubyTools.add(this.inventory.get(INPUT_SLOT_FOUR));

        rubyTools = rubyTools.stream()
                .filter(itemStack -> !itemStack.isEmpty())
                .filter(itemStack -> itemStack.getItem() instanceof TransmutableTool)
                .collect(Collectors.toList());

        for (ItemStack stack : rubyTools) {
            for (NbtElement enchantment : stack.getEnchantments()){
                if (enchantment instanceof NbtCompound) {
                    if ("tead:transmorphing".equals(((NbtCompound) enchantment).getString("id"))) {
                        return false;
                    }
                }
            }
        }

        return rubyTools.size() > 1;
    }

    public static void tick(World world, BlockPos pos, BlockState state, TransmutationTableBlockEntity blockEntity) {
        updateBook(world, pos, blockEntity);
        blockEntity.tick(world, pos, state);
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient) return;
        if (isOutputSlotEmptyOrReceivable()) {
            if (this.hasRecipe()) {
                this.progress++;
                markDirty(world, pos, state);

                if (hasCraftingFinished()) {
                    this.craftItem();
                    world.playSound(null, pos, TeadSounds.TRANSMUTATION, SoundCategory.BLOCKS, 1.0f, world.random.nextFloat() * 0.1f + 0.9f);
                    this.progress = 0;
                }
            } else {
                this.progress = 0;
            }
        } else {
            this.progress = 0;
            markDirty(world, pos, state);
        }
    }

    private void craftItem() {
        ItemStack inputOne = this.inventory.get(INPUT_SLOT_ONE);
        ItemStack inputTwo = this.inventory.get(INPUT_SLOT_TWO);
        ItemStack inputThree = this.inventory.get(INPUT_SLOT_THREE);
        ItemStack inputFour = this.inventory.get(INPUT_SLOT_FOUR);

        if (this.hasFullRubyTools()) {
            List<ItemStack> rubyTools = new ArrayList<>();

            rubyTools.add(inputOne.copy());
            rubyTools.add(inputTwo.copy());
            rubyTools.add(inputThree.copy());
            rubyTools.add(inputFour.copy());

            rubyTools = rubyTools.stream()
                    .filter(itemStack -> !itemStack.isEmpty())
                    .collect(Collectors.toList());

            for (ItemStack stack : rubyTools) {
                stack.addEnchantment(TeadEnchantments.TRANSMORPHING, rubyTools.size() - 1);
            }

            ItemStack finalRubyTool = rubyTools.remove(0).copy();

            RubyToolTransmuting.addToRubyTool(finalRubyTool, rubyTools);

            this.inventory.set(INPUT_SLOT_ONE, ItemStack.EMPTY);
            this.inventory.set(INPUT_SLOT_TWO, ItemStack.EMPTY);
            this.inventory.set(INPUT_SLOT_THREE, ItemStack.EMPTY);
            this.inventory.set(INPUT_SLOT_FOUR, ItemStack.EMPTY);
            this.markDirty();
            this.removeStack(LAPIS_LAZULI_SLOT, 4);
            this.setStack(OUTPUT_SLOT, finalRubyTool);
        } else {
            this.removeStack(INPUT_SLOT_ONE, 1);
            this.removeStack(INPUT_SLOT_TWO, 1);
            this.removeStack(INPUT_SLOT_THREE, 1);
            this.removeStack(INPUT_SLOT_FOUR, 1);
            this.removeStack(LAPIS_LAZULI_SLOT, 4);

            ItemStack result = ItemStack.EMPTY;
            if (this.lapisAmount() > 0) {
                if (this.hasFullItem(TeadItems.RUBY)) {
                    result = TeadItems.RUBY_INGOT.getDefaultStack();
                } else if (this.rubyIngotAmount() > 0) {
                    if (this.hasFullItem(TeadItems.RUBY_ARROW)) {
                        result = TeadItems.TRANSMORPHING_ARROW.getDefaultStack();
                        result.setCount(4);
                    } else if (this.hasFullItem(Items.ARROW)) {
                        result = TeadItems.RUBY_ARROW.getDefaultStack();
                        result.setCount(4);
                    } else if (this.hasFullItem(TeadItems.LEAD_INGOT)) {
                        result = Items.GOLD_INGOT.getDefaultStack();
                        result.setCount(4);
                    } else if (this.hasFullItem(TeadItems.LEAD_NUGGET)) {
                        result = Items.GOLD_NUGGET.getDefaultStack();
                        result.setCount(4);
                    } else if (this.hasFullItem(TeadItems.BRONZE_INGOT)) {
                        result = TeadItems.ROSE_GOLD_INGOT.getDefaultStack();
                        result.setCount(4);
                    } else if (this.hasFullItem(TeadItems.BRONZE_NUGGET)) {
                        result = TeadItems.ROSE_GOLD_NUGGET.getDefaultStack();
                        result.setCount(4);
                    } else if (this.hasFullItem(TeadItems.LEAD_APPLE)) {
                        result = Items.GOLDEN_APPLE.getDefaultStack();
                        result.setCount(4);
                    }
                }
            }

            this.setStack(OUTPUT_SLOT, new ItemStack(result.getItem(), getStack(OUTPUT_SLOT).getCount() + result.getCount()));
        }
    }

    private boolean hasRecipe() {
        if (this.lapisAmount() > 0) {
            if (this.hasFullItem(TeadItems.RUBY)) {
                return true;
            } else if (this.rubyIngotAmount() > 0) {
                if (this.hasFullItem(TeadItems.RUBY_ARROW) || this.hasFullItem(Items.ARROW) || this.hasFullItem(TeadItems.LEAD_INGOT) || this.hasFullItem(TeadItems.LEAD_NUGGET) || this.hasFullItem(TeadItems.BRONZE_INGOT) || this.hasFullItem(TeadItems.BRONZE_NUGGET) || this.hasFullItem(TeadItems.LEAD_APPLE)) {
                    return true;
                } else if (this.hasFullRubyTools()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemStack : this.inventory) {
            if (itemStack.isEmpty()) continue;
            return false;
        }
        return true;
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
    }

    public static void updateBook(World world, BlockPos pos, TransmutationTableBlockEntity blockEntity) {
        float g;
        blockEntity.pageTurningSpeed = blockEntity.nextPageTurningSpeed;
        blockEntity.lastBookRotation = blockEntity.bookRotation;
        PlayerEntity playerEntity = world.getClosestPlayer((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, 3.0, false);
        if (playerEntity != null) {
            double d = playerEntity.getX() - ((double)pos.getX() + 0.5);
            double e = playerEntity.getZ() - ((double)pos.getZ() + 0.5);
            blockEntity.targetBookRotation = (float) MathHelper.atan2(e, d);
            blockEntity.nextPageTurningSpeed += 0.1f;
            if (blockEntity.nextPageTurningSpeed < 0.5f || RANDOM.nextInt(40) == 0) {
                float f = blockEntity.flipRandom;
                do {
                    blockEntity.flipRandom += (float)(RANDOM.nextInt(4) - RANDOM.nextInt(4));
                } while (f == blockEntity.flipRandom);
            }
        } else {
            blockEntity.targetBookRotation += 0.02f;
            blockEntity.nextPageTurningSpeed -= 0.1f;
        }
        while (blockEntity.bookRotation >= (float)Math.PI) {
            blockEntity.bookRotation -= (float)Math.PI * 2;
        }
        while (blockEntity.bookRotation < (float)(-Math.PI)) {
            blockEntity.bookRotation += (float)Math.PI * 2;
        }
        while (blockEntity.targetBookRotation >= (float)Math.PI) {
            blockEntity.targetBookRotation -= (float)Math.PI * 2;
        }
        while (blockEntity.targetBookRotation < (float)(-Math.PI)) {
            blockEntity.targetBookRotation += (float)Math.PI * 2;
        }
        for (g = blockEntity.targetBookRotation - blockEntity.bookRotation; g >= (float)Math.PI; g -= (float)Math.PI * 2) {
        }
        while (g < (float)(-Math.PI)) {
            g += (float)Math.PI * 2;
        }
        blockEntity.bookRotation += g * 0.4f;
        blockEntity.nextPageTurningSpeed = MathHelper.clamp(blockEntity.nextPageTurningSpeed, 0.0f, 1.0f);
        ++blockEntity.ticks;
        blockEntity.pageAngle = blockEntity.nextPageAngle;
        float h = (blockEntity.flipRandom - blockEntity.nextPageAngle) * 0.4f;
        h = MathHelper.clamp(h, -0.2f, 0.2f);
        blockEntity.flipTurn += (h - blockEntity.flipTurn) * 0.9f;
        blockEntity.nextPageAngle += blockEntity.flipTurn;
    }
}
