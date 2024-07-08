package net.pythonbear.tead.init;

import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.recipe.AlloyCookingRecipe;
import net.pythonbear.tead.recipe.AlloyRecipeSerializer;

import static net.pythonbear.tead.Tead.MOD_ID;

public class TeadRecipeSerializers {
    public static final RecipeSerializer<AlloyCookingRecipe> ALLOY_RECIPE_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, new Identifier(MOD_ID, "alloy_smelting"),
            new AlloyRecipeSerializer<>(AlloyCookingRecipe::new, 200));

    public static void registerRecipeSerializers() {
        Tead.LOGGER.info("Registering mod recipe serializers for " + Tead.MOD_ID);
    }

}
