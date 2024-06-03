package net.pythonbear.tead.init;

import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.recipe.AlloyCookingRecipe;

public class TeadRecipeTypes {
    public static final RecipeType<AlloyCookingRecipe> ALLOYING  = Registry.register(Registries.RECIPE_TYPE,
            new Identifier(Tead.MOD_ID, "smelter"), new RecipeType<AlloyCookingRecipe>() {
                @Override
                public String toString() {return "smelter";}
    });

    public static void registerRecipeTypes() {
        Tead.LOGGER.info("Registering mod recipe types for " + Tead.MOD_ID);
    }
}
