/*
 * Decompiled with CFR 0.2.1 (FabricMC 53fa44c9).
 */
package net.pythonbear.tead.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.pythonbear.tead.init.TeadRecipeTypes;
import net.pythonbear.tead.init.TeadRecipeSerializers;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.init.TeadBlocks;

public class AlloyCookingRecipe extends AbstractCookingRecipe {
    public AlloyCookingRecipe(Identifier id, String group, CookingRecipeCategory category, Ingredient input,
                              ItemStack output, float experience, int cookTime) {
        super(TeadRecipeTypes.ALLOYING, id, group, category, input, output, experience, cookTime);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(TeadBlocks.SMELTER);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return TeadRecipeSerializers.ALLOY_RECIPE_SERIALIZER;
    }
}

