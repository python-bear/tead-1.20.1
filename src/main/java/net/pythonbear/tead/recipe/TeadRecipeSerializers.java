package net.pythonbear.tead.recipe;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;

import static net.pythonbear.tead.Tead.MOD_ID;

public class TeadRecipeSerializers {
    public static final RecipeSerializer<AlloyCookingRecipe> ALLOY_RECIPE_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, new Identifier(MOD_ID, "alloy_smelting"),
            new AlloySmeltingRecipeSerializer<>(AlloyCookingRecipe::new, 200));

    public static void registerRecipeSerializers() {
        Tead.LOGGER.info("Registering mod recipe serializers for " + Tead.MOD_ID);
    }

}
