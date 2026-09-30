package net.pythonbear.tead.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pythonbear.tead.block.TeadBlocks;
import net.pythonbear.tead.block.entity.TransmutationTableBlockEntity;
import net.pythonbear.tead.item.TeadItems;
import net.pythonbear.tead.recipe.TransmutationRecipes;
import net.pythonbear.tead.sound.TeadSounds;

/**
 * Like a crafting table, every player gets their own slots, which are handed back when the screen is closed.
 * Crafting progress is ticked by the table's block entity while the screen is open.
 */
public class TransmutationTableScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    private final ScreenHandlerContext context;
    private final PlayerEntity player;
    private boolean closed = false;

    /** Client side. */
    public TransmutationTableScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
        buf.readBlockPos();
    }

    public TransmutationTableScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(TeadScreenHandlers.TRANSMUTATION_TABLE_SCREEN_HANDLER, syncId);
        this.inventory = new SimpleInventory(TransmutationRecipes.SIZE) {
            @Override
            public void markDirty() {
                super.markDirty();
                TransmutationTableScreenHandler.this.onContentChanged(this);
            }
        };
        this.propertyDelegate = new ArrayPropertyDelegate(2);
        this.propertyDelegate.set(1, TransmutationRecipes.CRAFT_TIME);
        this.context = context;
        this.player = playerInventory.player;

        this.addSlot(new Slot(this.inventory, TransmutationRecipes.RUBY_INGOT_SLOT, 29, 25));
        this.addSlot(new Slot(this.inventory, TransmutationRecipes.LAPIS_LAZULI_SLOT, 29, 45));
        this.addSlot(new Slot(this.inventory, 2, 51, 26));
        this.addSlot(new Slot(this.inventory, 3, 69, 26));
        this.addSlot(new Slot(this.inventory, 4, 51, 44));
        this.addSlot(new Slot(this.inventory, 5, 69, 44));
        this.addSlot(new Slot(this.inventory, TransmutationRecipes.OUTPUT_SLOT, 127, 35) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }
        });
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
        this.addProperties(this.propertyDelegate);
    }

    /** Called every tick by the table's block entity while this screen is open (server only). */
    public void tickCrafting(World world, BlockPos pos) {
        int progress = this.propertyDelegate.get(0);
        ItemStack result = TransmutationRecipes.getResult(this.inventory);

        if (!result.isEmpty() && TransmutationRecipes.canAcceptOutput(this.inventory, result)) {
            progress++;
            if (progress >= TransmutationRecipes.CRAFT_TIME) {
                TransmutationRecipes.craft(this.inventory);
                world.playSound(null, pos, TeadSounds.TRANSMUTATION, SoundCategory.BLOCKS, 1.0f,
                        world.random.nextFloat() * 0.1f + 0.9f);
                progress = 0;
            }
        } else {
            progress = 0;
        }
        this.propertyDelegate.set(0, progress);
    }

    public boolean isStillOpen() {
        return !this.closed && this.player.currentScreenHandler == this && !this.player.isRemoved();
    }

    public boolean isCrafting() {
        return this.propertyDelegate.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);
        int progressArrowSize = 23;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (originalStack.getItem() == TeadItems.RUBY_INGOT) {
                if (!this.insertItem(originalStack, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (originalStack.getItem() == Items.LAPIS_LAZULI) {
                if (!this.insertItem(originalStack, 1, 2, false)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (!this.insertItem(originalStack, 2, 6, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(this.context, player, TeadBlocks.TRANSMUTATION_TABLE);
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.closed = true;
        // Same as a crafting table: hand everything back (or drop it if the inventory is full).
        this.context.run((world, pos) -> {
            this.dropInventory(player, this.inventory);
            if (world.getBlockEntity(pos) instanceof TransmutationTableBlockEntity table) {
                table.onHandlerClosed(this);
            }
        });
    }
}
