package net.pythonbear.tead.screen;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.FurnaceOutputSlot;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.recipe.TeadRecipeTypes;
import net.pythonbear.tead.recipe.AlloyCookingRecipe;

public class SmelterScreenHandler extends AbstractRecipeScreenHandler<Inventory> {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    protected final World world;
    private final RecipeType<? extends AlloyCookingRecipe> recipeType;

    public SmelterScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf) {
        this(syncId, inventory, ((Inventory) inventory.player.getWorld().getBlockEntity(buf.readBlockPos())),
                new ArrayPropertyDelegate(4));
        Tead.LOGGER.info("Called SmelterScreenHandler using PacketByteBuf");
    }

    public SmelterScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory,
                                PropertyDelegate propertyDelegate) {
        super(TeadScreenHandlers.SMELTER_SCREEN_HANDLER, syncId);
        Tead.LOGGER.info("Init SmelterScreenHandler");
        int i;
        this.recipeType = TeadRecipeTypes.ALLOYING;
        AbstractFurnaceScreenHandler.checkSize(inventory, 4);
        AbstractFurnaceScreenHandler.checkDataCount(propertyDelegate, 4);
        this.inventory = inventory;
        this.propertyDelegate = propertyDelegate;
        this.world = playerInventory.player.getWorld();
        this.addSlot(new Slot(inventory, 0, 42, 17));
        this.addSlot(new Slot(inventory, 1, 68, 17));
        this.addSlot(new SmelterFuelSlot(this, inventory, 2, 55, 53));
        this.addSlot(new FurnaceOutputSlot(playerInventory.player, inventory, 3, 117, 35));
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
        this.addProperties(propertyDelegate);
    }

    @Override
    public void populateRecipeFinder(RecipeMatcher finder) {
        if (this.inventory instanceof RecipeInputProvider) {
            ((RecipeInputProvider) this.inventory).provideRecipeInputs(finder);
        }
    }

    @Override
    public void clearCraftingSlots() {
        this.getSlot(0).setStackNoCallbacks(ItemStack.EMPTY);
        this.getSlot(1).setStackNoCallbacks(ItemStack.EMPTY);
        this.getSlot(3).setStackNoCallbacks(ItemStack.EMPTY);
    }

    @Override
    public boolean matches(Recipe<? super Inventory> recipe) {
        return recipe.matches(this.inventory, this.world);
    }

    @Override
    public int getCraftingResultSlotIndex() {
        return 3;
    }

    @Override
    public int getCraftingWidth() {
        return 2;
    }

    @Override
    public int getCraftingHeight() {
        return 1;
    }

    @Override
    public int getCraftingSlotCount() {
        return 2;
    }

    @Override
    public RecipeBookCategory getCategory() {
        return RecipeBookCategory.CRAFTING; // this is wrong
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotIndex);
        if (slot != null && slot.hasStack()) {
            ItemStack slotsItemStack = slot.getStack();
            itemStack = slotsItemStack.copy();
            // Output slot (index 3)
            if (slotIndex == 3) {
                if (!this.insertItem(slotsItemStack, 4, 40, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickTransfer(slotsItemStack, itemStack);
            }
            // Smelter input slots (indexes 0 and 1) and fuel slot (index 2)
            else if (slotIndex == 0 || slotIndex == 1 || slotIndex == 2) {
                if (!this.insertItem(slotsItemStack, 4, 40, false)) {
                    return ItemStack.EMPTY;
                }
            }
            // Player inventory slots
            else if (slotIndex >= 4) {
                if (this.isFuel(slotsItemStack) && this.insertItem(slotsItemStack, 2, 3, false)) {
                    return itemStack;
                } else if (this.insertItem(slotsItemStack, 0, 2, false)) {
                    return itemStack;
                } else if (slotIndex < 31 && this.insertItem(slotsItemStack, 31, 40, false)) {
                    return itemStack;
                } else if (slotIndex < 40 && this.insertItem(slotsItemStack, 4, 31, false)) {
                    return itemStack;
                }
            }

            if (slotsItemStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }

            if (slotsItemStack.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTakeItem(player, slotsItemStack);
        }

        return itemStack;
    }

    protected boolean isFuel(ItemStack itemStack) {
        return AbstractFurnaceBlockEntity.canUseAsFuel(itemStack);
    }

    public int getCookProgress() {
        int i = this.propertyDelegate.get(2);
        int j = this.propertyDelegate.get(3);
        if (j == 0 || i == 0) {
            return 0;
        }
        return i * 24 / j;
    }

    public int getFuelProgress() {
        int i = this.propertyDelegate.get(1);
        if (i == 0) {
            i = 200;
        }
        return this.propertyDelegate.get(0) * 13 / i;
    }

    public boolean isBurning() {
        return this.propertyDelegate.get(0) > 0;
    }

    @Override
    public boolean canInsertIntoSlot(int index) {
        return index != 2;
    }
}
