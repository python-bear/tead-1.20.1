package net.pythonbear.tead.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;
import net.pythonbear.tead.init.TeadRecipeTypes;
import net.pythonbear.tead.init.TeadScreenHandlers;

public class SmelterScreenHandler extends AbstractFurnaceScreenHandler {
    public SmelterScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(TeadScreenHandlers.SMELTER_SCREEN_HANDLER, TeadRecipeTypes.ALLOYING, RecipeBookCategory.BLAST_FURNACE,
                syncId, playerInventory);
    }

    public SmelterScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory,
                                PropertyDelegate propertyDelegate) {
        super(TeadScreenHandlers.SMELTER_SCREEN_HANDLER, TeadRecipeTypes.ALLOYING, RecipeBookCategory.BLAST_FURNACE,
                syncId, playerInventory, inventory, propertyDelegate);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return false;
    }
}
