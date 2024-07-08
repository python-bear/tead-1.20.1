package net.pythonbear.tead.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;

public class AlloyRecipeSerializer<T extends AlloyCookingRecipe> implements RecipeSerializer<T> {
    private final int cookingTime;
    private final RecipeFactory<T> recipeFactory;

    public AlloyRecipeSerializer(RecipeFactory<T> recipeFactory, int cookingTime) {
        this.cookingTime = cookingTime;
        this.recipeFactory = recipeFactory;
    }

    private static DefaultedList<Ingredient> getIngredients(JsonArray json) {
        DefaultedList<Ingredient> defaultedList = DefaultedList.of();
        for (int i = 0; i < json.size(); ++i) {
            Ingredient ingredient = Ingredient.fromJson(json.get(i), false);
            if (ingredient.isEmpty()) continue;
            defaultedList.add(ingredient);
        }
        return defaultedList;
    }

    @Override
    public T read(Identifier identifier, JsonObject jsonObject) {
        String group = JsonHelper.getString(jsonObject, "group", "");
        JsonArray ingredientsArray = JsonHelper.getArray(jsonObject, "ingredients");
        DefaultedList<Ingredient> ingredients = getIngredients(ingredientsArray);

        if (ingredients.size() != 2) {
            throw new JsonParseException("Alloying recipe requires exactly two ingredients");
        }

        ItemStack result = ShapedRecipe.outputFromJson(JsonHelper.getObject(jsonObject, "result"));
        float experience = JsonHelper.getFloat(jsonObject, "experience", 0.0F);
        int cookingTime = JsonHelper.getInt(jsonObject, "cookingtime", this.cookingTime);

        return this.recipeFactory.create(identifier, group, ingredients, result, experience, cookingTime);
    }

    @Override
    public T read(Identifier identifier, PacketByteBuf packetByteBuf) {
        String group = packetByteBuf.readString(32767);
        int ingredientCount = packetByteBuf.readVarInt();
        DefaultedList<Ingredient> ingredients = DefaultedList.ofSize(ingredientCount, Ingredient.EMPTY);

        for (int i = 0; i < ingredientCount; i++) {
            ingredients.set(i, Ingredient.fromPacket(packetByteBuf));
        }

        ItemStack result = packetByteBuf.readItemStack();
        float experience = packetByteBuf.readFloat();
        int cookingTime = packetByteBuf.readVarInt();

        return this.recipeFactory.create(identifier, group, ingredients, result, experience, cookingTime);
    }

    @Override
    public void write(PacketByteBuf packetByteBuf, T recipe) {
        packetByteBuf.writeString(recipe.getGroup());
        packetByteBuf.writeVarInt(recipe.getIngredients().size());

        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredient.write(packetByteBuf);
        }

        packetByteBuf.writeItemStack(recipe.getOutputEasy());
        packetByteBuf.writeFloat(recipe.getExperience());
        packetByteBuf.writeVarInt(recipe.getCookTime());
    }

    public interface RecipeFactory<T extends AlloyCookingRecipe> {
        T create(Identifier id, String group, DefaultedList<Ingredient> ingredients, ItemStack result, float experience,
                 int cookTime);
    }
}
