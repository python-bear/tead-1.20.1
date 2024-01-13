package net.pythonbear.tead.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
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
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, TeadItems.GALENA,
                RecipeCategory.MISC, TeadBlocks.BLOCK_OF_GALENA);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, TeadItems.OBSIDIAN_SHARD,
                RecipeCategory.MISC, Blocks.OBSIDIAN);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, TeadItems.LEAD_NUGGET, RecipeCategory.MISC,
                TeadItems.LEAD_INGOT);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.LEAD_BULLET, 3)
                .pattern(" $ ")
                .pattern("#%#")
                .pattern(" # ")
                .input('%', Items.GUNPOWDER)
                .input('#', TeadItems.LEAD_INGOT)
                .input('$', Items.REDSTONE)
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.AMETHYST_ARROW, 1)
                .pattern("  $")
                .pattern(" # ")
                .pattern("%  ")
                .input('%', Items.FEATHER)
                .input('#', Items.STICK)
                .input('$', Items.AMETHYST_SHARD)
                .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.EXPLOSIVE_ARROW, 1)
                .pattern("  $")
                .pattern(" # ")
                .pattern("%  ")
                .input('%', Items.FEATHER)
                .input('#', Items.STICK)
                .input('$', Items.TNT)
                .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.TNT), conditionsFromItem(Items.TNT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.LIGHTNING_ARROW, 1)
                .pattern("  $")
                .pattern(" # ")
                .pattern("%  ")
                .input('%', Items.FEATHER)
                .input('#', Items.STICK)
                .input('$', Items.LIGHTNING_ROD)
                .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.LIGHTNING_ROD), conditionsFromItem(Items.LIGHTNING_ROD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.OBSIDIAN_ARROW, 1)
                .pattern("  $")
                .pattern(" # ")
                .pattern("%  ")
                .input('%', Items.FEATHER)
                .input('#', Items.STICK)
                .input('$', TeadItems.OBSIDIAN_SHARD)
                .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(TeadItems.OBSIDIAN_SHARD), conditionsFromItem(TeadItems.OBSIDIAN_SHARD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.RUBY_ARROW, 1)
                .pattern("  $")
                .pattern(" # ")
                .pattern("%  ")
                .input('%', Items.FEATHER)
                .input('#', Items.STICK)
                .input('$', TeadItems.RUBY)
                .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(TeadItems.RUBY), conditionsFromItem(TeadItems.RUBY))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LIGHTNING_STAFF, 1)
                .pattern("  %")
                .pattern(" # ")
                .pattern("#  ")
                .input('%', Items.AMETHYST_SHARD)
                .input('#', Items.LIGHTNING_ROD)
                .criterion(hasItem(Items.LIGHTNING_ROD), conditionsFromItem(Items.LIGHTNING_ROD))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, TeadItems.LEAD_APPLE, 1)
                .pattern("###")
                .pattern("#%#")
                .pattern("###")
                .input('%', Items.APPLE)
                .input('#', TeadItems.LEAD_INGOT)
                .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LEAD_PICKAXE, 1)
                .pattern("###")
                .pattern(" % ")
                .pattern(" % ")
                .input('%', Items.STICK)
                .input('#', TeadItems.LEAD_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LEAD_SHOVEL, 1)
                .pattern("#")
                .pattern("%")
                .pattern("%")
                .input('%', Items.STICK)
                .input('#', TeadItems.LEAD_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LEAD_SWORD, 1)
                .pattern("#")
                .pattern("#")
                .pattern("%")
                .input('%', Items.STICK)
                .input('#', TeadItems.LEAD_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LEAD_AXE, 1)
                .pattern("##")
                .pattern("#%")
                .pattern(" %")
                .input('%', Items.STICK)
                .input('#', TeadItems.LEAD_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LEAD_HOE, 1)
                .pattern("##")
                .pattern(" %")
                .pattern(" %")
                .input('%', Items.STICK)
                .input('#', TeadItems.LEAD_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SADDLE, 1)
                .pattern("###")
                .pattern(" % ")
                .pattern(" $ ")
                .input('#', Items.LEATHER)
                .input('%', Items.LEAD)
                .input('$', Items.TRIPWIRE_HOOK)
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .criterion(hasItem(Items.LEAD), conditionsFromItem(Items.LEAD))
                .criterion(hasItem(Items.TRIPWIRE_HOOK), conditionsFromItem(Items.TRIPWIRE_HOOK))
                .offerTo(exporter);
    }
}
