package net.pythonbear.tead.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LEAD_DOUBLE_AXE, 1)
                .pattern("#%#")
                .pattern("#%#")
                .pattern(" % ")
                .input('%', Items.STICK)
                .input('#', TeadItems.LEAD_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.WOOD_DOUBLE_AXE, 1)
                .pattern("#%#")
                .pattern("#%#")
                .pattern(" % ")
                .input('%', Items.STICK)
                .input('#', ItemTags.PLANKS)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.ACACIA_PLANKS), conditionsFromItem(Items.ACACIA_PLANKS))
                .criterion(hasItem(Items.BAMBOO_PLANKS), conditionsFromItem(Items.BAMBOO_PLANKS))
                .criterion(hasItem(Items.BIRCH_PLANKS), conditionsFromItem(Items.BIRCH_PLANKS))
                .criterion(hasItem(Items.CHERRY_PLANKS), conditionsFromItem(Items.CHERRY_PLANKS))
                .criterion(hasItem(Items.CRIMSON_PLANKS), conditionsFromItem(Items.CRIMSON_PLANKS))
                .criterion(hasItem(Items.JUNGLE_PLANKS), conditionsFromItem(Items.JUNGLE_PLANKS))
                .criterion(hasItem(Items.DARK_OAK_PLANKS), conditionsFromItem(Items.DARK_OAK_PLANKS))
                .criterion(hasItem(Items.MANGROVE_PLANKS), conditionsFromItem(Items.MANGROVE_PLANKS))
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .criterion(hasItem(Items.SPRUCE_PLANKS), conditionsFromItem(Items.SPRUCE_PLANKS))
                .criterion(hasItem(Items.WARPED_PLANKS), conditionsFromItem(Items.WARPED_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.STONE_DOUBLE_AXE, 1)
                .pattern("#%#")
                .pattern("#%#")
                .pattern(" % ")
                .input('%', Items.STICK)
                .input('#', ItemTags.STONE_TOOL_MATERIALS)
                .criterion(hasItem(Items.COBBLED_DEEPSLATE), conditionsFromItem(Items.COBBLED_DEEPSLATE))
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .criterion(hasItem(Items.BLACKSTONE), conditionsFromItem(Items.BLACKSTONE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.STONE_HAMMER, 1)
                .pattern(" # ")
                .pattern(" %#")
                .pattern("%  ")
                .input('%', Items.STICK)
                .input('#', ItemTags.STONE_TOOL_MATERIALS)
                .criterion(hasItem(Items.COBBLED_DEEPSLATE), conditionsFromItem(Items.COBBLED_DEEPSLATE))
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .criterion(hasItem(Items.BLACKSTONE), conditionsFromItem(Items.BLACKSTONE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.STONE_SICKLE, 1)
                .pattern(" # ")
                .pattern("  #")
                .pattern("%# ")
                .input('%', Items.STICK)
                .input('#', ItemTags.STONE_TOOL_MATERIALS)
                .criterion(hasItem(Items.COBBLED_DEEPSLATE), conditionsFromItem(Items.COBBLED_DEEPSLATE))
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .criterion(hasItem(Items.BLACKSTONE), conditionsFromItem(Items.BLACKSTONE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.STONE_DAGGER, 1)
                .pattern(" #")
                .pattern("% ")
                .input('%', Items.STICK)
                .input('#', ItemTags.STONE_TOOL_MATERIALS)
                .criterion(hasItem(Items.COBBLED_DEEPSLATE), conditionsFromItem(Items.COBBLED_DEEPSLATE))
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .criterion(hasItem(Items.BLACKSTONE), conditionsFromItem(Items.BLACKSTONE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_DOUBLE_AXE, 1)
                .pattern("#%#")
                .pattern("#%#")
                .pattern(" % ")
                .input('%', Items.STICK)
                .input('#', Items.GOLD_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_HAMMER, 1)
                .pattern(" # ")
                .pattern("  #")
                .pattern("%# ")
                .input('%', Items.STICK)
                .input('#', Items.GOLD_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_SICKLE, 1)
                .pattern(" # ")
                .pattern("  #")
                .pattern("%# ")
                .input('%', Items.STICK)
                .input('#', Items.GOLD_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_DAGGER, 1)
                .pattern(" #")
                .pattern("% ")
                .input('%', Items.STICK)
                .input('#', Items.GOLD_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.IRON_DOUBLE_AXE, 1)
                .pattern("#%#")
                .pattern("#%#")
                .pattern(" % ")
                .input('%', Items.STICK)
                .input('#', Items.IRON_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.IRON_HAMMER, 1)
                .pattern(" # ")
                .pattern("  #")
                .pattern("%# ")
                .input('%', Items.STICK)
                .input('#', Items.IRON_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.IRON_SICKLE, 1)
                .pattern(" # ")
                .pattern("  #")
                .pattern("%# ")
                .input('%', Items.STICK)
                .input('#', Items.IRON_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.IRON_DAGGER, 1)
                .pattern(" #")
                .pattern("% ")
                .input('%', Items.STICK)
                .input('#', Items.IRON_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.DIAMOND_DOUBLE_AXE, 1)
                .pattern("#%#")
                .pattern("#%#")
                .pattern(" % ")
                .input('%', Items.STICK)
                .input('#', Items.DIAMOND)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.DIAMOND_HAMMER, 1)
                .pattern(" # ")
                .pattern("  #")
                .pattern("%# ")
                .input('%', Items.STICK)
                .input('#', Items.DIAMOND)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.DIAMOND_SICKLE, 1)
                .pattern(" # ")
                .pattern("  #")
                .pattern("%# ")
                .input('%', Items.STICK)
                .input('#', Items.DIAMOND)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.DIAMOND_DAGGER, 1)
                .pattern(" #")
                .pattern("% ")
                .input('%', Items.STICK)
                .input('#', Items.DIAMOND)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.NETHERITE_DOUBLE_AXE, 1)
                .pattern("#%#")
                .pattern("#%#")
                .pattern(" % ")
                .input('%', Items.STICK)
                .input('#', Items.NETHERITE_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.NETHERITE_HAMMER, 1)
                .pattern(" # ")
                .pattern("  #")
                .pattern("%# ")
                .input('%', Items.STICK)
                .input('#', Items.NETHERITE_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.NETHERITE_SICKLE, 1)
                .pattern(" # ")
                .pattern("  #")
                .pattern("%# ")
                .input('%', Items.STICK)
                .input('#', Items.NETHERITE_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.NETHERITE_DAGGER, 1)
                .pattern(" #")
                .pattern("% ")
                .input('%', Items.STICK)
                .input('#', Items.NETHERITE_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.OBSIDIAN_SWORD, 1)
                .pattern("  #")
                .pattern("$# ")
                .pattern("%$ ")
                .input('%', Items.STICK)
                .input('#', Items.OBSIDIAN)
                .input('$', TeadItems.OBSIDIAN_SHARD)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.OBSIDIAN), conditionsFromItem(Items.OBSIDIAN))
                .criterion(hasItem(TeadItems.OBSIDIAN_SHARD), conditionsFromItem(TeadItems.OBSIDIAN_SHARD))
                .offerTo(exporter);
    }
}
