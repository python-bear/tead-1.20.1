package net.pythonbear.tead.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.block.entity.SmelterBlockEntity;
import net.pythonbear.tead.recipe.TeadRecipeBookCategory;
import net.pythonbear.tead.recipe.TeadRecipeTypes;
import net.pythonbear.tead.recipe.AlloyCookingRecipe;

import java.util.List;
import java.util.Optional;

public class SmelterScreenHandler extends AbstractRecipeScreenHandler<Inventory> {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    protected final World world;
    private final RecipeType<? extends AlloyCookingRecipe> recipeType;

    public SmelterScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        this(syncId, playerInventory, ((Inventory) playerInventory.player.getWorld().getBlockEntity(buf.readBlockPos())),
                new ArrayPropertyDelegate(4));
    }

    public SmelterScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(4), new ArrayPropertyDelegate(4));
    }

    public SmelterScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(TeadScreenHandlers.SMELTER_SCREEN_HANDLER, syncId);
        int i;
        this.recipeType = TeadRecipeTypes.ALLOY_SMELTING;
        AbstractFurnaceScreenHandler.checkSize(inventory, 4);
        AbstractFurnaceScreenHandler.checkDataCount(propertyDelegate, 4);
        this.inventory = inventory;
        this.propertyDelegate = propertyDelegate;
        this.world = playerInventory.player.getWorld();
        this.addSlot(new Slot(inventory, 0, 42, 17));
        this.addSlot(new Slot(inventory, 1, 68, 17));
        this.addSlot(new SmelterFuelSlot(this, inventory, 2, 55, 53));
        this.addSlot(new SmelterOutputSlot(playerInventory.player, inventory, 3, 117, 35));
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
        return 4;
    }

    @Override
    public RecipeBookCategory getCategory() {
        return null;
    }

//    @Override
//    public TeadRecipeBookCategory getCategory() {
//        return TeadRecipeBookCategory.ALLOY_SMELTING;
//    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotIndex);
        if (slot != null && slot.hasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2.copy();

            if (slotIndex == 3) {
                if (!this.insertItem(itemStack2, 4, 40, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (slotIndex == 2 || slotIndex == 1 || slotIndex == 0) {
                if (!this.insertItem(itemStack2, 4, 40, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.isFuel(itemStack2)) {
                if (!this.insertItem(itemStack2, 2, 3, false)) {
                    if (this.isSmeltable(itemStack2)) {
                        if (!this.insertItem(itemStack2, 0, 2, false)) {
                            return ItemStack.EMPTY;
                        }
                    }
                    return ItemStack.EMPTY;
                }
            } else if (this.isSmeltable(itemStack2)) {
                if (!this.insertItem(itemStack2, 0, 2, false)) {
                    if (this.isFuel(itemStack2)) {
                        if (!this.insertItem(itemStack2, 0, 2, false)) {
                            return ItemStack.EMPTY;
                        }
                    }
                    return ItemStack.EMPTY;
                }
            }

            if (slotIndex >= 4 && slotIndex < 31) {
                if (!this.insertItem(itemStack2, 31, 40, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slotIndex >= 31 && slotIndex < 40) {
                if (!this.insertItem(itemStack2, 4, 31, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (itemStack2.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTakeItem(player, itemStack2);
        }
        return itemStack;
    }

    protected boolean isSmeltable(ItemStack itemStack) {
        List<? extends AlloyCookingRecipe> allRecipes = this.world.getRecipeManager().listAllOfType(this.recipeType);

        for (Recipe<?> recipe : allRecipes) {
            if (recipe instanceof AlloyCookingRecipe alloyRecipe) {
                Ingredient ingredientOne = alloyRecipe.getIngredients().get(0);
                Ingredient ingredientTwo = alloyRecipe.getIngredients().get(1);
                boolean matches = ingredientOne.test(itemStack) || ingredientTwo.test(itemStack);

                if (matches) return true;
            }
        }
        return false;
    }



    protected boolean isFuel(ItemStack itemStack) {
        return SmelterBlockEntity.canUseAsFuel(itemStack);
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
