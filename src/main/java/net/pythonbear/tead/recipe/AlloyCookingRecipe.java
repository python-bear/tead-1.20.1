/*
 * Decompiled with CFR 0.2.1 (FabricMC 53fa44c9).
 */
package net.pythonbear.tead.recipe;

import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import net.minecraft.util.Identifier;

public class AlloyCookingRecipe implements Recipe<Inventory> {
    protected final Identifier id;
    protected final String group;
    final DefaultedList<Ingredient> input;
    protected final ItemStack output;
    protected final float experience;
    protected final int cookTime;

    public AlloyCookingRecipe(Identifier id, String group, DefaultedList<Ingredient> input, ItemStack output,
                              float experience, int cookTime) {
        this.id = id;
        this.group = group;
        this.input = input;
        this.output = output;
        this.experience = experience;
        this.cookTime = cookTime;
    }

    @Override
    public boolean matches(Inventory inventory, World world) {
        return (this.input.get(0).test(inventory.getStack(0)) && this.input.get(1).test(inventory.getStack(1)))
                || (this.input.get(1).test(inventory.getStack(0)) && this.input.get(0).test(inventory.getStack(1)));
    }

    public boolean matches(RecipeInputInventory recipeInputInventory, World world) {
        RecipeMatcher recipeMatcher = new RecipeMatcher();
        int i = 0;
        for (int j = 0; j < recipeInputInventory.size(); ++j) {
            ItemStack itemStack = recipeInputInventory.getStack(j);
            if (itemStack.isEmpty()) continue;
            ++i;
            recipeMatcher.addInput(itemStack, 1);
        }
        return i == this.input.size() && recipeMatcher.match(this, null);
    }

    @Override
    public ItemStack craft(Inventory inventory, DynamicRegistryManager registryManager) {
        return this.output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        return this.input;
    }

    public float getExperience() {
        return this.experience;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return this.output;
    }

    public ItemStack getOutputEasy() {
        return this.output;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    public int getCookTime() {
        return this.cookTime;
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return TeadRecipeSerializers.ALLOY_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return TeadRecipeTypes.ALLOYING;
    }
}