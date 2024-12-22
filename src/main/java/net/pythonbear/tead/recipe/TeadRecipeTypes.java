package net.pythonbear.tead.recipe;

import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;

public class TeadRecipeTypes {
    public static final RecipeType<AlloyCookingRecipe> ALLOY_SMELTING = Registry.register(Registries.RECIPE_TYPE,
            new Identifier(Tead.MOD_ID, "alloy_smelting"), new RecipeType<AlloyCookingRecipe>() {
                @Override
                public String toString() {return "alloy_smelting";}
    });

    public static void registerRecipeTypes() {
        Tead.LOGGER.info("Registering mod recipe types for " + Tead.MOD_ID);
    }
}
