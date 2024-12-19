package net.pythonbear.tead.screen;

import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.InputSlotFiller;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.pythonbear.tead.recipe.TeadRecipeBookCategory;

public abstract class TeadAbstractRecipeScreenHandler<C extends Inventory> extends ScreenHandler {
    public TeadAbstractRecipeScreenHandler(ScreenHandlerType<?> screenHandlerType, int i) {
        super(screenHandlerType, i);
    }

    public void fillInputSlots(boolean craftAll, Recipe<?> recipe, ServerPlayerEntity player) {
        new TeadInputSlotFiller(this).fillInputSlots(player, recipe, craftAll);
    }

    public abstract void populateRecipeFinder(RecipeMatcher var1);

    public abstract void clearCraftingSlots();

    public abstract boolean matches(Recipe<? super C> var1);

    public abstract int getCraftingResultSlotIndex();

    public abstract int getCraftingWidth();

    public abstract int getCraftingHeight();

    public abstract int getCraftingSlotCount();

    public abstract TeadRecipeBookCategory getCategory();

    public abstract boolean canInsertIntoSlot(int var1);
}

