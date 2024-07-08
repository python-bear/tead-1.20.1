package net.pythonbear.tead.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.recipebook.AbstractFurnaceRecipeBookScreen;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.pythonbear.tead.block.entity.SmelterBlockEntity;

import java.util.Set;

@Environment(value=EnvType.CLIENT)
public class SmelterRecipeBookScreen extends AbstractFurnaceRecipeBookScreen {
    private static final Text TOGGLE_BLASTABLE_RECIPES_TEXT =
            Text.translatable("gui.recipebook.toggleRecipes.smeltable");

    @Override
    protected Text getToggleCraftableButtonText() {
        return TOGGLE_BLASTABLE_RECIPES_TEXT;
    }

    @Override
    protected Set<Item> getAllowedFuels() {
        return SmelterBlockEntity.createFuelTimeMap().keySet();
    }
}