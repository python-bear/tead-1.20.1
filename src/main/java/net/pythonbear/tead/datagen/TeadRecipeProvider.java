package net.pythonbear.tead.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.pythonbear.tead.init.TeadBlocks;
import net.pythonbear.tead.init.TeadItems;

import java.util.List;
import java.util.function.Consumer;

public class TeadRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(
            TeadBlocks.RUBY_ORE,
            TeadBlocks.DEEPSLATE_RUBY_ORE
    );

    public TeadRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, TeadItems.RUBY, 2, 300,
                "ruby");
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, TeadItems.RUBY, 2, 150,
                "ruby");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, TeadItems.RUBY, RecipeCategory.MISC,
                TeadBlocks.BLOCK_OF_RUBY);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LIGHTNING_STAFF, 1)
                .pattern("  %")
                .pattern(" # ")
                .pattern("#  ")
                .input('%', Items.AMETHYST_SHARD)
                .input('#', Items.LIGHTNING_ROD)
                .criterion(hasItem(Items.LIGHTNING_ROD), conditionsFromItem(Items.LIGHTNING_ROD))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LEAD_APPLE, 1)
                .pattern("###")
                .pattern("#%#")
                .pattern("###")
                .input('%', Items.APPLE)
                .input('#', TeadItems.LEAD_INGOT)
                .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .offerTo(exporter);
    }
}
