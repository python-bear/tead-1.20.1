package net.pythonbear.tead.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.pythonbear.tead.block.entity.SmelterBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Environment(value=EnvType.CLIENT)
public class SmelterRecipeBookScreen extends RecipeBookWidget {
    private static final Text TOGGLE_ALLOY_SMELTABLE_RECIPES_TEXT = Text.translatable("gui.recipebook.toggleRecipes.alloyable");

    @Nullable
    private Ingredient fuels;

    @Override
    protected void setBookButtonTexture() {
        this.toggleCraftableButton.setTextureUV(152, 182, 28, 18, TEXTURE);
    }

    @Override
    public void slotClicked(@Nullable Slot slot) {
        super.slotClicked(slot);
        if (slot != null && slot.id < this.craftingScreenHandler.getCraftingSlotCount()) {
            this.ghostSlots.reset();
        }
    }

    @Override
    protected Text getToggleCraftableButtonText() {
        return TOGGLE_ALLOY_SMELTABLE_RECIPES_TEXT;
    }

    protected Set<Item> getAllowedFuels() {
        return SmelterBlockEntity.createFuelTimeMap().keySet();
    }

    @Override
    public void showGhostRecipe(Recipe<?> recipe, List<Slot> slots) {
        if (this.client.world == null) return;

        ItemStack itemStack = recipe.getOutput(this.client.world.getRegistryManager());
        this.ghostSlots.setRecipe(recipe);
        this.ghostSlots.addSlot(Ingredient.ofStacks(itemStack), slots.get(3).x, slots.get(3).y);
        DefaultedList<Ingredient> defaultedList = recipe.getIngredients();
        Slot fuelSlot = slots.get(2);
        if (fuelSlot.getStack().isEmpty()) {
            if (this.fuels == null) {
                this.fuels = Ingredient.ofStacks(this.getAllowedFuels().stream().filter(item
                        -> item.isEnabled(this.client.world.getEnabledFeatures())).map(ItemStack::new));
            }
            this.ghostSlots.addSlot(this.fuels, fuelSlot.x, fuelSlot.y);
        }
        Iterator iterator = defaultedList.iterator();
        for (int i = 0; i < 3; ++i) {
            if (!iterator.hasNext()) {
                return;
            }
            Ingredient ingredient = (Ingredient)iterator.next();
            if (ingredient.isEmpty()) continue;
            Slot slot2 = slots.get(i);
            this.ghostSlots.addSlot(ingredient, slot2.x, slot2.y);
        }
    }
}