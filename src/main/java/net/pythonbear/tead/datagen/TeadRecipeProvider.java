package net.pythonbear.tead.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.block.TeadBlocks;
import net.pythonbear.tead.item.TeadItems;
import net.pythonbear.tead.init.TeadTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class TeadRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(
            TeadBlocks.RUBY_ORE,
            TeadBlocks.DEEPSLATE_RUBY_ORE
    );
    private static final List<ItemConvertible> LEAD_SMELTABLES = List.of(
            TeadBlocks.LEAD_ORE,
            TeadItems.GALENA
    );
    private static final List<ItemConvertible> DARK_BRICK_SMELTABLES = List.of(
            TeadBlocks.CLAYISH_MUD,
            TeadItems.MUDDY_CLAY_BALL
    );
    private static final List<ItemConvertible> BLOCK_OF_COPPER_SMELTABLES = List.of(
            Blocks.RAW_COPPER_BLOCK
    );
    private static final List<ItemConvertible> BLOCK_OF_IRON_SMELTABLES = List.of(
            Blocks.RAW_IRON_BLOCK
    );
    private static final List<ItemConvertible> BLOCK_OF_GOLD_SMELTABLES = List.of(
            Blocks.RAW_GOLD_BLOCK
    );
    private static final List<ItemConvertible> BLOCK_OF_LEAD_SMELTABLES = List.of(
            TeadBlocks.RAW_LEAD_BLOCK
    );

    public TeadRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, BLOCK_OF_COPPER_SMELTABLES, RecipeCategory.MISC, Items.COPPER_BLOCK, 6.3f, 1800, "copper_block");
        offerBlasting(exporter, BLOCK_OF_COPPER_SMELTABLES, RecipeCategory.MISC, Items.COPPER_BLOCK, 6.3f, 900, "copper_block");
        offerSmelting(exporter, BLOCK_OF_IRON_SMELTABLES, RecipeCategory.MISC, Items.IRON_BLOCK, 6.3f, 1800, "iron_block");
        offerBlasting(exporter, BLOCK_OF_IRON_SMELTABLES, RecipeCategory.MISC, Items.IRON_BLOCK, 6.3f, 900, "iron_block");
        offerSmelting(exporter, BLOCK_OF_GOLD_SMELTABLES, RecipeCategory.MISC, Items.GOLD_BLOCK, 9f, 1800, "gold_block");
        offerBlasting(exporter, BLOCK_OF_GOLD_SMELTABLES, RecipeCategory.MISC, Items.GOLD_BLOCK, 9f, 900, "gold_block");
        offerSmelting(exporter, BLOCK_OF_LEAD_SMELTABLES, RecipeCategory.MISC, TeadBlocks.LEAD_BLOCK, 7.2f, 1620, "lead_block");
        offerBlasting(exporter, BLOCK_OF_LEAD_SMELTABLES, RecipeCategory.MISC, TeadBlocks.LEAD_BLOCK, 7.2f, 720, "lead_block");
        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, TeadItems.RUBY, 2, 300, "ruby");
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, TeadItems.RUBY, 2, 150, "ruby");
        offerSmelting(exporter, LEAD_SMELTABLES, RecipeCategory.MISC, TeadItems.LEAD_INGOT, 0.8f, 180, "lead_ingot");
        offerBlasting(exporter, LEAD_SMELTABLES, RecipeCategory.MISC, TeadItems.LEAD_INGOT, 0.8f, 80, "lead_ingot");
        offerSmelting(exporter, DARK_BRICK_SMELTABLES, RecipeCategory.MISC, TeadItems.DARK_BRICK, 0, 150, "dark_brick");
        offerBlasting(exporter, DARK_BRICK_SMELTABLES, RecipeCategory.MISC, TeadItems.DARK_BRICK, 0, 80,  "dark_brick");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, TeadItems.RUBY, RecipeCategory.MISC, TeadBlocks.RUBY_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, TeadItems.GALENA, RecipeCategory.MISC, TeadBlocks.RAW_LEAD_BLOCK);
        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.BUILDING_BLOCKS, TeadItems.PIG_IRON_INGOT, RecipeCategory.BUILDING_BLOCKS, TeadBlocks.PIG_IRON_BLOCK, "pig_iron_ingot_from_block", "pig_iron_ingot");
        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, TeadItems.LEAD_INGOT, RecipeCategory.BUILDING_BLOCKS, TeadBlocks.LEAD_BLOCK, "lead_ingot_from_block", "lead_ingot");
        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, TeadItems.ROSE_GOLD_INGOT, RecipeCategory.BUILDING_BLOCKS, TeadBlocks.ROSE_GOLD_BLOCK, "rose_gold_ingot_from_block", "rose_gold_ingot");
        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, TeadItems.WHITE_GOLD_INGOT, RecipeCategory.BUILDING_BLOCKS, TeadBlocks.WHITE_GOLD_BLOCK, "white_gold_ingot_from_block", "white_gold_ingot");
        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, TeadItems.BRASS_INGOT, RecipeCategory.BUILDING_BLOCKS, TeadBlocks.BRASS_BLOCK, "brass_ingot_from_block", "brass_ingot");
        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, TeadItems.BRONZE_INGOT, RecipeCategory.BUILDING_BLOCKS, TeadBlocks.BRONZE_BLOCK, "bronze_ingot_from_block", "bronze_ingot");
        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, TeadItems.STEEL_INGOT, RecipeCategory.BUILDING_BLOCKS, TeadBlocks.STEEL_BLOCK, "steel_ingot_from_block", "steel_ingot");
        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, TeadItems.ROSE_NETHERITE_INGOT, RecipeCategory.BUILDING_BLOCKS, TeadBlocks.ROSE_NETHERITE_BLOCK, "rose_netherite_from_block", "rose_netherite_ingot");
        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, TeadItems.WHITE_NETHERITE_INGOT, RecipeCategory.BUILDING_BLOCKS, TeadBlocks.WHITE_NETHERITE_BLOCK, "white_netherite_from_block", "white_netherite_ingot");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, TeadItems.OBSIDIAN_SHARD, RecipeCategory.MISC, Blocks.OBSIDIAN);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, TeadItems.DIAMOND_CHIP, RecipeCategory.MISC, Items.DIAMOND);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, TeadItems.PIG_IRON_NUGGET, RecipeCategory.MISC, TeadItems.PIG_IRON_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, TeadItems.LEAD_NUGGET, RecipeCategory.MISC, TeadItems.LEAD_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, TeadItems.COPPER_NUGGET, RecipeCategory.MISC, Items.COPPER_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, TeadItems.ROSE_GOLD_NUGGET, RecipeCategory.MISC, TeadItems.ROSE_GOLD_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, TeadItems.WHITE_GOLD_NUGGET, RecipeCategory.MISC, TeadItems.WHITE_GOLD_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, TeadItems.BRASS_NUGGET, RecipeCategory.MISC, TeadItems.BRASS_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, TeadItems.BRONZE_NUGGET, RecipeCategory.MISC, TeadItems.BRONZE_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, TeadItems.STEEL_NUGGET, RecipeCategory.MISC, TeadItems.STEEL_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, TeadItems.NETHERITE_NUGGET, RecipeCategory.MISC, Items.NETHERITE_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, TeadItems.ROSE_NETHERITE_NUGGET, RecipeCategory.MISC, TeadItems.ROSE_NETHERITE_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, TeadItems.WHITE_NETHERITE_NUGGET, RecipeCategory.MISC, TeadItems.WHITE_NETHERITE_INGOT);

        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TeadBlocks.LEAD_CUT_SLAB, TeadBlocks.LEAD_CUT_BLOCK);
        createStairsRecipe(TeadBlocks.LEAD_CUT_STAIRS, Ingredient.ofItems(TeadBlocks.LEAD_CUT_BLOCK))
                .criterion(hasItem(TeadBlocks.LEAD_CUT_BLOCK), conditionsFromItem(TeadBlocks.LEAD_CUT_BLOCK))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "lead_cut_stairs"));
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TeadBlocks.BRASS_CUT_SLAB, TeadBlocks.BRASS_CUT_BLOCK);
        createStairsRecipe(TeadBlocks.BRASS_CUT_STAIRS, Ingredient.ofItems(TeadBlocks.BRASS_CUT_BLOCK))
                .criterion(hasItem(TeadBlocks.BRASS_CUT_BLOCK), conditionsFromItem(TeadBlocks.BRASS_CUT_BLOCK))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "brass_cut_stairs"));
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TeadBlocks.BRONZE_CUT_SLAB, TeadBlocks.BRONZE_CUT_BLOCK);
        createStairsRecipe(TeadBlocks.BRONZE_CUT_STAIRS, Ingredient.ofItems(TeadBlocks.BRONZE_CUT_BLOCK))
                .criterion(hasItem(TeadBlocks.BRONZE_CUT_BLOCK), conditionsFromItem(TeadBlocks.BRONZE_CUT_BLOCK))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "bronze_cut_stairs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, TeadItems.GRAVITY_PEARL)
                .input(Items.BLAZE_POWDER)
                .input(Items.ENDER_PEARL)
                .input(Items.CHORUS_FRUIT)
                .criterion(hasItem(Items.CHORUS_FRUIT), conditionsFromItem(Items.CHORUS_FRUIT))
                .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "gravity_pearl"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.HANDLE)
                .input(Items.STICK)
                .input(Items.LEATHER)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .group("handle")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "handle_1"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.HANDLE)
                .input(Items.STICK)
                .input(TeadItems.FABRIC)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(TeadItems.FABRIC), conditionsFromItem(TeadItems.FABRIC))
                .group("handle")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "handle_2"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.FABRIC)
                .input(Items.BAMBOO)
                .input(Items.BAMBOO)
                .input(ItemTags.FLOWERS)
                .input(ItemTags.FLOWERS)
                .input(ItemTags.FLOWERS)
                .input(ItemTags.FLOWERS)
                .criterion(hasItem(Items.BAMBOO), conditionsFromItem(Items.BAMBOO))
                .group("fabric")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "fabric_1"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.FABRIC)
                .input(Items.WHITE_WOOL)
                .input(Items.BROWN_WOOL)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.BROWN_WOOL), conditionsFromItem(Items.BROWN_WOOL))
                .group("fabric")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "fabric_3"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.FABRIC)
                .input(Items.WHITE_WOOL)
                .input(Items.STRING)
                .input(Items.STRING)
                .input(Items.STRING)
                .input(Items.STRING)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .group("fabric")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "fabric_4"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.FABRIC)
                .input(Items.BROWN_WOOL)
                .input(Items.STRING)
                .input(Items.STRING)
                .input(Items.STRING)
                .input(Items.STRING)
                .criterion(hasItem(Items.BROWN_WOOL), conditionsFromItem(Items.BROWN_WOOL))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .group("fabric")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "fabric_5"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.FABRIC)
                .input(Items.HANGING_ROOTS)
                .input(Items.HANGING_ROOTS)
                .input(Items.HANGING_ROOTS)
                .input(Items.HANGING_ROOTS)
                .input(Items.HANGING_ROOTS)
                .input(Items.HANGING_ROOTS)
                .criterion(hasItem(Items.HANGING_ROOTS), conditionsFromItem(Items.HANGING_ROOTS))
                .group("fabric")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "fabric_6"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.FABRIC)
                .input(Items.WHEAT)
                .input(Items.WHEAT)
                .input(Items.WHEAT)
                .input(Items.BAMBOO)
                .input(Items.BAMBOO)
                .criterion(hasItem(Items.BAMBOO), conditionsFromItem(Items.BAMBOO))
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .group("fabric")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "fabric_7"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.FABRIC)
                .input(Items.WHEAT)
                .input(Items.WHEAT)
                .input(Items.WHEAT)
                .input(Items.STRING)
                .input(Items.STRING)
                .input(Items.STRING)
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .group("fabric")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "fabric_8"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.FABRIC)
                .input(Items.TWISTING_VINES)
                .input(Items.TWISTING_VINES)
                .input(Items.TWISTING_VINES)
                .input(Items.NETHER_SPROUTS)
                .input(Items.NETHER_SPROUTS)
                .input(Items.NETHER_SPROUTS)
                .criterion(hasItem(Items.NETHER_SPROUTS), conditionsFromItem(Items.NETHER_SPROUTS))
                .criterion(hasItem(Items.TWISTING_VINES), conditionsFromItem(Items.TWISTING_VINES))
                .group("fabric")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "fabric_9"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.FABRIC)
                .input(Items.CRIMSON_FUNGUS)
                .input(Items.CRIMSON_FUNGUS)
                .input(Items.STRING)
                .input(Items.STRING)
                .input(Items.STRING)
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .criterion(hasItem(Items.CRIMSON_FUNGUS), conditionsFromItem(Items.CRIMSON_FUNGUS))
                .group("fabric")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "fabric_0"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.JERKY, 3)
                .input(ItemTags.FISHES)
                .input(Items.SUGAR)
                .input(Items.COCOA_BEANS)
                .criterion(hasItem(Items.TROPICAL_FISH), conditionsFromItem(Items.TROPICAL_FISH))
                .criterion(hasItem(Items.SALMON), conditionsFromItem(Items.SALMON))
                .criterion(hasItem(Items.COD), conditionsFromItem(Items.COD))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .group("jerky")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "jerky_0"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.JERKY, 3)
                .input(Items.ROTTEN_FLESH)
                .input(Items.SUGAR)
                .input(Items.COCOA_BEANS)
                .criterion(hasItem(Items.ROTTEN_FLESH), conditionsFromItem(Items.ROTTEN_FLESH))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .group("jerky")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "jerky_1"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.JERKY, 3)
                .input(Items.BEEF)
                .input(Items.SUGAR)
                .input(Items.COCOA_BEANS)
                .criterion(hasItem(Items.BEEF), conditionsFromItem(Items.BEEF))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .group("jerky")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "jerky_2"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.JERKY, 3)
                .input(Items.PORKCHOP)
                .input(Items.SUGAR)
                .input(Items.COCOA_BEANS)
                .criterion(hasItem(Items.PORKCHOP), conditionsFromItem(Items.PORKCHOP))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .group("jerky")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "jerky_3"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.JERKY, 2)
                .input(Items.CHICKEN)
                .input(Items.SUGAR)
                .input(Items.COCOA_BEANS)
                .criterion(hasItem(Items.CHICKEN), conditionsFromItem(Items.CHICKEN))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .group("jerky")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "jerky_4"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.JERKY, 3)
                .input(Items.RABBIT)
                .input(Items.SUGAR)
                .input(Items.COCOA_BEANS)
                .criterion(hasItem(Items.RABBIT), conditionsFromItem(Items.RABBIT))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .group("jerky")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "jerky_5"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.JERKY, 3)
                .input(Items.MUTTON)
                .input(Items.SUGAR)
                .input(Items.COCOA_BEANS)
                .criterion(hasItem(Items.MUTTON), conditionsFromItem(Items.MUTTON))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .group("jerky")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "jerky_6"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.JERKY, 3)
                .input(Items.ROTTEN_FLESH)
                .input(Items.SUGAR)
                .input(Items.GUNPOWDER)
                .criterion(hasItem(Items.ROTTEN_FLESH), conditionsFromItem(Items.ROTTEN_FLESH))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .group("jerky")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "jerky_7"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.JERKY, 3)
                .input(ItemTags.FISHES)
                .input(Items.SUGAR)
                .input(Items.GUNPOWDER)
                .criterion(hasItem(Items.TROPICAL_FISH), conditionsFromItem(Items.TROPICAL_FISH))
                .criterion(hasItem(Items.SALMON), conditionsFromItem(Items.SALMON))
                .criterion(hasItem(Items.COD), conditionsFromItem(Items.COD))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .group("jerky")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "jerky_8"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.JERKY, 3)
                .input(Items.PORKCHOP)
                .input(Items.SUGAR)
                .input(Items.GUNPOWDER)
                .criterion(hasItem(Items.PORKCHOP), conditionsFromItem(Items.PORKCHOP))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .group("jerky")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "jerky_9"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.JERKY, 3)
                .input(Items.BEEF)
                .input(Items.SUGAR)
                .input(Items.GUNPOWDER)
                .criterion(hasItem(Items.BEEF), conditionsFromItem(Items.BEEF))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .group("jerky")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "jerky_10"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.JERKY, 2)
                .input(Items.CHICKEN)
                .input(Items.SUGAR)
                .input(Items.GUNPOWDER)
                .criterion(hasItem(Items.CHICKEN), conditionsFromItem(Items.CHICKEN))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .group("jerky")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "jerky_11"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.JERKY, 3)
                .input(Items.RABBIT)
                .input(Items.SUGAR)
                .input(Items.GUNPOWDER)
                .criterion(hasItem(Items.RABBIT), conditionsFromItem(Items.RABBIT))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .group("jerky")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "jerky_12"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.JERKY, 3)
                .input(Items.MUTTON)
                .input(Items.SUGAR)
                .input(Items.GUNPOWDER)
                .criterion(hasItem(Items.MUTTON), conditionsFromItem(Items.MUTTON))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .group("jerky")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "jerky_13"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.BOOK)
                .input(Items.PAPER)
                .input(Items.PAPER)
                .input(Items.PAPER)
                .input(TeadItems.FABRIC)
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .criterion(hasItem(TeadItems.FABRIC), conditionsFromItem(TeadItems.FABRIC))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TeadBlocks.GEMCUTTER, 1)
                .pattern(" # ")
                .pattern("$%$")
                .input('%', Items.STRIPPED_DARK_OAK_LOG)
                .input('#', TeadItems.STEEL_INGOT)
                .input('$', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.STRIPPED_DARK_OAK_LOG), conditionsFromItem(Items.STRIPPED_DARK_OAK_LOG))
                .criterion(hasItem(TeadItems.STEEL_INGOT), conditionsFromItem(TeadItems.STEEL_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TeadBlocks.TRANSMUTATION_TABLE, 1)
                .pattern(" # ")
                .pattern("$%$")
                .pattern("%%%")
                .input('%', Items.OBSIDIAN)
                .input('#', TeadItems.TRANSMUTATION_GRIMOIRE)
                .input('$', Items.AMETHYST_SHARD)
                .criterion(hasItem(Items.OBSIDIAN), conditionsFromItem(Items.OBSIDIAN))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .criterion(hasItem(TeadItems.TRANSMUTATION_GRIMOIRE), conditionsFromItem(TeadItems.TRANSMUTATION_GRIMOIRE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.BUFFERED_PEARL, 1)
                .pattern("$%$")
                .pattern("%#%")
                .pattern("$%$")
                .input('%', TeadItems.WHITE_GOLD_INGOT)
                .input('#', Items.ENDER_PEARL)
                .input('$', Items.GLOWSTONE_DUST)
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                .criterion(hasItem(TeadItems.WHITE_GOLD_INGOT), conditionsFromItem(TeadItems.WHITE_GOLD_INGOT))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "buffered_pearl"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.AMETHYST_ARROW, 4)
                .pattern("$")
                .pattern("#")
                .pattern("%")
                .input('%', Items.FEATHER)
                .input('#', Items.STICK)
                .input('$', Items.AMETHYST_SHARD)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "amethyst_arrow"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.TNT_ARROW, 4)
                .pattern("$")
                .pattern("#")
                .pattern("%")
                .input('%', Items.FEATHER)
                .input('#', Items.STICK)
                .input('$', Items.TNT)
                .criterion(hasItem(Items.TNT), conditionsFromItem(Items.TNT))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "tnt_arrow"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.TORCH_ARROW, 4)
                .pattern("$")
                .pattern("#")
                .pattern("%")
                .input('%', Items.FEATHER)
                .input('#', Items.STICK)
                .input('$', Items.COAL)
                .criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))
                .group("torch_arrow")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "torch_arrow_1"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.TORCH_ARROW, 4)
                .pattern("$")
                .pattern("#")
                .pattern("%")
                .input('%', Items.FEATHER)
                .input('#', Items.STICK)
                .input('$', Items.CHARCOAL)
                .criterion(hasItem(Items.CHARCOAL), conditionsFromItem(Items.CHARCOAL))
                .group("torch_arrow")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "torch_arrow_2"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.SOUL_TORCH_ARROW, 4)
                .pattern("$")
                .pattern("#")
                .pattern("%")
                .input('%', Items.FEATHER)
                .input('#', Items.STICK)
                .input('$', Items.SOUL_SAND)
                .criterion(hasItem(Items.SOUL_SAND), conditionsFromItem(Items.SOUL_SAND))
                .group("soul_torch_arrow")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "soul_torch_arrow_1"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.SOUL_TORCH_ARROW, 4)
                .pattern("$")
                .pattern("#")
                .pattern("%")
                .input('%', Items.FEATHER)
                .input('#', Items.STICK)
                .input('$', Items.SOUL_SOIL)
                .criterion(hasItem(Items.SOUL_SOIL), conditionsFromItem(Items.SOUL_SOIL))
                .group("soul_torch_arrow")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "soul_torch_arrow_2"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.REDSTONE_TORCH_ARROW, 4)
                .pattern("$")
                .pattern("#")
                .pattern("%")
                .input('%', Items.FEATHER)
                .input('#', Items.STICK)
                .input('$', Items.REDSTONE)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "redstone_torch_arrow"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.BORING_ARROW, 1)
                .pattern("%$%")
                .pattern("%#%")
                .pattern("%%%")
                .input('%', Items.TNT)
                .input('#', TeadItems.TNT_ARROW)
                .input('$', TeadItems.STEEL_PICKAXE)
                .criterion(hasItem(TeadItems.TNT_ARROW), conditionsFromItem(TeadItems.TNT_ARROW))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "boring_arrow"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.COPPER_ARROW, 3)
                .pattern("$")
                .pattern("#")
                .pattern("%")
                .input('%', Items.FEATHER)
                .input('#', Items.STICK)
                .input('$', Items.LIGHTNING_ROD)
                .criterion(hasItem(Items.LIGHTNING_ROD), conditionsFromItem(Items.LIGHTNING_ROD))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "cooper_arrow"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.ENDER_PEARL_ARROW, 1)
                .pattern("$")
                .pattern("#")
                .pattern("%")
                .input('%', Items.FEATHER)
                .input('#', Items.STICK)
                .input('$', Items.ENDER_PEARL)
                .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "ender_pearl_arrow"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.OBSIDIAN_ARROW, 4)
                .pattern("$")
                .pattern("#")
                .pattern("%")
                .input('%', Items.FEATHER)
                .input('#', Items.STICK)
                .input('$', TeadItems.OBSIDIAN_SHARD)
                .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                .criterion(hasItem(TeadItems.OBSIDIAN_SHARD), conditionsFromItem(TeadItems.OBSIDIAN_SHARD))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "obsidian_arrow"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.RUBY_ARROW, 4)
                .pattern("$")
                .pattern("#")
                .pattern("%")
                .input('%', Items.FEATHER)
                .input('#', Items.STICK)
                .input('$', TeadItems.RUBY)
                .criterion(hasItem(TeadItems.RUBY), conditionsFromItem(TeadItems.RUBY))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "ruby_arrow"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, TeadItems.TRANSMORPHING_ARROW)
                .input(Items.ARROW)
                .input(TeadItems.RUBY_INGOT)
                .criterion(hasItem(TeadItems.RUBY_INGOT), conditionsFromItem(TeadItems.RUBY_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.ARROW, 4)
                .pattern("$")
                .pattern("#")
                .pattern("%")
                .input('%', Items.FEATHER)
                .input('#', Items.STICK)
                .input('$', Items.FLINT)
                .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                .criterion(hasItem(Items.FLINT), conditionsFromItem(Items.FLINT))
                .group("arrow")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "arrow_1"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.ARROW, 4)
                .pattern("$")
                .pattern("#")
                .pattern("%")
                .input('%', Items.FEATHER)
                .input('#', Items.STICK)
                .input('$', Items.IRON_INGOT)
                .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .group("arrow")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "arrow"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LIGHTNING_STAFF, 1)
                .pattern("  %")
                .pattern(" # ")
                .pattern("#  ")
                .input('%', Items.AMETHYST_SHARD)
                .input('#', Items.LIGHTNING_ROD)
                .criterion(hasItem(Items.LIGHTNING_ROD), conditionsFromItem(Items.LIGHTNING_ROD))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, TeadItems.WHITE_GOLD_POTATO, 1)
                .pattern("###")
                .pattern("#%#")
                .pattern("###")
                .input('%', Items.POTATO)
                .input('#', TeadItems.WHITE_GOLD_INGOT)
                .criterion(hasItem(TeadItems.WHITE_GOLD_INGOT), conditionsFromItem(TeadItems.WHITE_GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, TeadItems.ROSE_GOLD_BEETROOT, 1)
                .pattern("###")
                .pattern("#%#")
                .pattern("###")
                .input('%', Items.BEETROOT)
                .input('#', TeadItems.ROSE_GOLD_INGOT)
                .criterion(hasItem(TeadItems.ROSE_GOLD_INGOT), conditionsFromItem(TeadItems.ROSE_GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, TeadItems.LEAD_APPLE, 1)
                .pattern("###")
                .pattern("#%#")
                .pattern("###")
                .input('%', Items.APPLE)
                .input('#', TeadItems.LEAD_INGOT)
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .offerTo(exporter);

        // Wooden Tools
//        offerPickaxeRecipe(Items.WOODEN_PICKAXE, ItemTags.PLANKS, "wooden", true, exporter, Tead.MINECRAFT_ID);
//        offerAxeRecipe(Items.WOODEN_AXE, ItemTags.PLANKS, "wooden", true, exporter, Tead.MINECRAFT_ID);

        offerHatchetRecipe(TeadItems.WOOD_HATCHET, ItemTags.PLANKS, "wood", true, exporter, null);
        offerHammerRecipe(TeadItems.WOOD_HAMMER, ItemTags.PLANKS, "wood", true, exporter, null);
        offerMaceRecipe(TeadItems.WOOD_MACE, ItemTags.PLANKS, "wood", true, exporter, null);
        offerDaggerRecipe(TeadItems.WOOD_DAGGER, ItemTags.PLANKS, "wood", false, exporter, null);
        offerHollowDaggerRecipe(TeadItems.WOOD_HOLLOW_DAGGER, TeadItems.WOOD_DAGGER, ItemTags.PLANKS, "wood", exporter);
        offerRiteDaggerRecipe(TeadItems.WOOD_RITE_DAGGER, TeadItems.WOOD_DAGGER, ItemTags.PLANKS, "wood", exporter);
        offerCrescentDaggerRecipe(TeadItems.WOOD_CRESCENT_DAGGER, TeadItems.WOOD_DAGGER, ItemTags.PLANKS, "wood", exporter);
        offerTruthseekerRecipe(TeadItems.WOOD_TRUTHSEEKER, Items.WOODEN_SWORD, ItemTags.PLANKS, "wood", exporter);
        offerTempestKnifeRecipe(TeadItems.WOOD_TEMPEST_KNIFE, Items.WOODEN_SWORD, ItemTags.PLANKS, "wood", exporter);
        offerCutlassRecipe(TeadItems.WOOD_CUTLASS, Items.WOODEN_SWORD, ItemTags.PLANKS, "wood", exporter);
        offerRapierRecipe(TeadItems.WOOD_RAPIER, Items.WOODEN_SWORD, ItemTags.PLANKS, "wood", exporter);
        offerKatanaRecipe(TeadItems.WOOD_KATANA, Items.WOODEN_SWORD, ItemTags.PLANKS, "wood", exporter);
        offerHighlandAxeRecipe(TeadItems.WOOD_HIGHLAND_AXE, Items.WOODEN_AXE, ItemTags.PLANKS, "wood", exporter);
        offerDoubleAxeRecipe(TeadItems.WOOD_DOUBLE_AXE, ItemTags.PLANKS, "wood", true, exporter, null);
        offerDoubleHighlandAxeRecipe(TeadItems.WOOD_DOUBLE_HIGHLAND_AXE, TeadItems.WOOD_DOUBLE_AXE, ItemTags.PLANKS, "wood", exporter);
        offerSickleRecipe(TeadItems.WOOD_SICKLE, ItemTags.PLANKS, "wood", true, exporter, null);
        offerScytheRecipe(TeadItems.WOOD_SCYTHE, ItemTags.PLANKS, "wood", false, exporter, null);
        offerGreatswordRecipe(TeadItems.WOOD_GREATSWORD, Items.WOODEN_SWORD, ItemTags.PLANKS, "wood", exporter);
        offerLongswordRecipe(TeadItems.WOOD_LONGSWORD, ItemTags.PLANKS, "wood", true, exporter, null);
        offerBroadswordRecipe(TeadItems.WOOD_BROADSWORD, TeadItems.WOOD_LONGSWORD, ItemTags.PLANKS, "wood", exporter);
        offerClaymoreRecipe(TeadItems.WOOD_CLAYMORE, ItemTags.PLANKS, "wood", true, exporter, null);
        offerSpearRecipe(TeadItems.WOOD_SPEAR, ItemTags.PLANKS, "wood", true, exporter, null);
        offerRanseurRecipe(TeadItems.WOOD_RANSEUR, TeadItems.WOOD_SPEAR, ItemTags.PLANKS, "wood", exporter);
        offerGlaiveRecipe(TeadItems.WOOD_GLAIVE, TeadItems.WOOD_SPEAR, ItemTags.PLANKS, "wood", exporter);

        // Stone Tools
//        offerShovelRecipe(Items.STONE_SHOVEL, TeadTags.Items.ROCKS, "stone", false, exporter, Tead.MINECRAFT_ID);
//        offerHoeRecipe(Items.STONE_HOE, TeadTags.Items.ROCKS, "stone", false, exporter, Tead.MINECRAFT_ID);
//        offerPickaxeRecipe(Items.STONE_PICKAXE, TeadTags.Items.ROCKS, "stone", true, exporter, Tead.MINECRAFT_ID);
//        offerAxeRecipe(Items.STONE_AXE, TeadTags.Items.ROCKS, "stone", true, exporter, Tead.MINECRAFT_ID);
//        offerSwordRecipe(Items.STONE_SWORD, TeadTags.Items.ROCKS, "stone", true, exporter, Tead.MINECRAFT_ID);

        offerHatchetRecipe(TeadItems.STONE_HATCHET, TeadTags.Items.ROCKS, "stone", true, exporter, null);
        offerHammerRecipe(TeadItems.STONE_HAMMER, TeadTags.Items.ROCKS, "stone", true, exporter, null);
        offerMattockRecipe(TeadItems.STONE_MATTOCK, TeadTags.Items.ROCKS, "stone", true, exporter, null);
        offerMaceRecipe(TeadItems.STONE_MACE, TeadTags.Items.ROCKS, "stone", true, exporter, null);
        offerDaggerRecipe(TeadItems.STONE_DAGGER, TeadTags.Items.ROCKS, "stone", false, exporter, null);
        offerHollowDaggerRecipe(TeadItems.STONE_HOLLOW_DAGGER, TeadItems.STONE_DAGGER, ItemTags.STONE_TOOL_MATERIALS, "stone", exporter);
        offerRiteDaggerRecipe(TeadItems.STONE_RITE_DAGGER, TeadItems.STONE_DAGGER, TeadTags.Items.ROCKS, "stone", exporter);
        offerCrescentDaggerRecipe(TeadItems.STONE_CRESCENT_DAGGER, TeadItems.STONE_DAGGER, TeadTags.Items.ROCKS, "stone", exporter);
        offerTruthseekerRecipe(TeadItems.STONE_TRUTHSEEKER, Items.STONE_SWORD, TeadTags.Items.ROCKS, "stone", exporter);
        offerTempestKnifeRecipe(TeadItems.STONE_TEMPEST_KNIFE, Items.STONE_SWORD, TeadTags.Items.ROCKS, "stone", exporter);
        offerCutlassRecipe(TeadItems.STONE_CUTLASS, Items.STONE_SWORD, TeadTags.Items.ROCKS, "stone", exporter);
        offerRapierRecipe(TeadItems.STONE_RAPIER, Items.STONE_SWORD, TeadTags.Items.ROCKS, "stone", exporter);
        offerKatanaRecipe(TeadItems.STONE_KATANA, Items.STONE_SWORD, TeadTags.Items.ROCKS, "stone", exporter);
        offerHighlandAxeRecipe(TeadItems.STONE_HIGHLAND_AXE, Items.STONE_AXE, TeadTags.Items.ROCKS, "stone", exporter);
        offerDoubleAxeRecipe(TeadItems.STONE_DOUBLE_AXE, TeadTags.Items.ROCKS, "stone", true, exporter, null);
        offerDoubleHighlandAxeRecipe(TeadItems.STONE_DOUBLE_HIGHLAND_AXE, TeadItems.STONE_DOUBLE_AXE, TeadTags.Items.ROCKS, "stone", exporter);
        offerSickleRecipe(TeadItems.STONE_SICKLE, TeadTags.Items.ROCKS, "stone", true, exporter, null);
        offerScytheRecipe(TeadItems.STONE_SCYTHE, TeadTags.Items.ROCKS, "stone", false, exporter, null);
        offerGreatswordRecipe(TeadItems.STONE_GREATSWORD, Items.STONE_SWORD, TeadTags.Items.ROCKS, "stone", exporter);
        offerLongswordRecipe(TeadItems.STONE_LONGSWORD, TeadTags.Items.ROCKS, "stone", true, exporter, null);
        offerBroadswordRecipe(TeadItems.STONE_BROADSWORD, TeadItems.STONE_LONGSWORD, TeadTags.Items.ROCKS, "stone", exporter);
        offerClaymoreRecipe(TeadItems.STONE_CLAYMORE, TeadTags.Items.ROCKS, "stone", true, exporter, null);
        offerSpearRecipe(TeadItems.STONE_SPEAR, TeadTags.Items.ROCKS, "stone", true, exporter, null);
        offerRanseurRecipe(TeadItems.STONE_RANSEUR, TeadItems.STONE_SPEAR, TeadTags.Items.ROCKS, "stone", exporter);
        offerGlaiveRecipe(TeadItems.STONE_GLAIVE, TeadItems.STONE_SPEAR, TeadTags.Items.ROCKS, "stone", exporter);

        // Gold Tools
//        offerShovelRecipe(Items.GOLDEN_SHOVEL, Items.GOLD_INGOT, "golden", true, exporter, Tead.MINECRAFT_ID);
//        offerHoeRecipe(Items.GOLDEN_HOE, Items.GOLD_INGOT, "golden", true, exporter, Tead.MINECRAFT_ID);
//        offerPickaxeRecipe(Items.GOLDEN_PICKAXE, Items.GOLD_INGOT, "golden", true, exporter, Tead.MINECRAFT_ID);
//        offerAxeRecipe(Items.GOLDEN_AXE, Items.GOLD_INGOT, "golden", true, exporter, Tead.MINECRAFT_ID);
//        offerSwordRecipe(Items.GOLDEN_SWORD, Items.GOLD_INGOT, "golden", true, exporter, Tead.MINECRAFT_ID);

        offerHatchetRecipe(TeadItems.GOLD_HATCHET, Items.GOLD_INGOT, "gold", true, exporter, null);
        offerHammerRecipe(TeadItems.GOLD_HAMMER, Items.GOLD_INGOT, "gold", true, exporter, null);
        offerMountaineerPickRecipe(TeadItems.GOLD_MOUNTAINEER_PICK, Items.GOLDEN_PICKAXE, Items.GOLD_INGOT, "gold", exporter);
        offerMattockRecipe(TeadItems.GOLD_MATTOCK, Items.GOLD_INGOT, "gold", true, exporter, null);
        offerMaceRecipe(TeadItems.GOLD_MACE, Items.GOLD_INGOT, "gold", true, exporter, null);
        offerDaggerRecipe(TeadItems.GOLD_DAGGER, Items.GOLD_INGOT, "gold", true, exporter, null);
        offerHollowDaggerRecipe(TeadItems.GOLD_HOLLOW_DAGGER, TeadItems.GOLD_DAGGER, Items.GOLD_INGOT, "gold", exporter);
        offerRiteDaggerRecipe(TeadItems.GOLD_RITE_DAGGER, TeadItems.GOLD_DAGGER, Items.GOLD_INGOT, "gold", exporter);
        offerCrescentDaggerRecipe(TeadItems.GOLD_CRESCENT_DAGGER, TeadItems.GOLD_DAGGER, Items.GOLD_INGOT, "gold", exporter);
        offerTruthseekerRecipe(TeadItems.GOLD_TRUTHSEEKER, Items.GOLDEN_SWORD, Items.GOLD_INGOT, "gold", exporter);
        offerTempestKnifeRecipe(TeadItems.GOLD_TEMPEST_KNIFE, Items.GOLDEN_SWORD, Items.GOLD_INGOT, "gold", exporter);
        offerCutlassRecipe(TeadItems.GOLD_CUTLASS, Items.GOLDEN_SWORD, Items.GOLD_INGOT, "gold", exporter);
        offerRapierRecipe(TeadItems.GOLD_RAPIER, Items.GOLDEN_SWORD, Items.GOLD_INGOT, "gold", exporter);
        offerKatanaRecipe(TeadItems.GOLD_KATANA, Items.GOLDEN_SWORD, Items.GOLD_INGOT, "gold", exporter);
        offerHighlandAxeRecipe(TeadItems.GOLD_HIGHLAND_AXE, Items.GOLDEN_AXE, Items.GOLD_INGOT, "gold", exporter);
        offerDoubleAxeRecipe(TeadItems.GOLD_DOUBLE_AXE, Items.GOLD_INGOT, "gold", true, exporter, null);
        offerDoubleHighlandAxeRecipe(TeadItems.GOLD_DOUBLE_HIGHLAND_AXE, TeadItems.GOLD_DOUBLE_AXE, Items.GOLD_INGOT, "gold", exporter);
        offerSickleRecipe(TeadItems.GOLD_SICKLE, Items.GOLD_INGOT, "gold", true, exporter, null);
        offerScytheRecipe(TeadItems.GOLD_SCYTHE, Items.GOLD_INGOT, "gold", true, exporter, null);
        offerGreatswordRecipe(TeadItems.GOLD_GREATSWORD, Items.GOLDEN_SWORD, Items.GOLD_INGOT, "gold", exporter);
        offerLongswordRecipe(TeadItems.GOLD_LONGSWORD, Items.GOLD_INGOT, "gold", true, exporter, null);
        offerBroadswordRecipe(TeadItems.GOLD_BROADSWORD, TeadItems.GOLD_LONGSWORD, Items.GOLD_INGOT, "gold", exporter);
        offerClaymoreRecipe(TeadItems.GOLD_CLAYMORE, Items.GOLD_INGOT, "gold", true, exporter, null);
        offerSpearRecipe(TeadItems.GOLD_SPEAR, Items.GOLD_INGOT, "gold", true, exporter, null);
        offerRanseurRecipe(TeadItems.GOLD_RANSEUR, TeadItems.GOLD_SPEAR, Items.GOLD_INGOT, "gold", exporter);
        offerGlaiveRecipe(TeadItems.GOLD_GLAIVE, TeadItems.GOLD_SPEAR, Items.GOLD_INGOT, "gold", exporter);

        // Lead Tools
        offerShovelRecipe(TeadItems.LEAD_SHOVEL, TeadItems.LEAD_INGOT, "lead", true, exporter, null);
        offerHoeRecipe(TeadItems.LEAD_HOE, TeadItems.LEAD_INGOT, "lead", true, exporter, null);
        offerPickaxeRecipe(TeadItems.LEAD_PICKAXE, TeadItems.LEAD_INGOT, "lead", true, exporter, null);
        offerAxeRecipe(TeadItems.LEAD_AXE, TeadItems.LEAD_INGOT, "lead", true, exporter, null);
        offerSwordRecipe(TeadItems.LEAD_SWORD, TeadItems.LEAD_INGOT, "lead", true, exporter, null);

        offerHatchetRecipe(TeadItems.LEAD_HATCHET, TeadItems.LEAD_INGOT, "lead", true, exporter, null);
        offerHammerRecipe(TeadItems.LEAD_HAMMER, TeadItems.LEAD_INGOT, "lead", true, exporter, null);
        offerMountaineerPickRecipe(TeadItems.LEAD_MOUNTAINEER_PICK, TeadItems.LEAD_PICKAXE, TeadItems.LEAD_INGOT, "lead", exporter);
        offerMattockRecipe(TeadItems.LEAD_MATTOCK, TeadItems.LEAD_INGOT, "lead", true, exporter, null);
        offerMaceRecipe(TeadItems.LEAD_MACE, TeadItems.LEAD_INGOT, "lead", true, exporter, null);
        offerDaggerRecipe(TeadItems.LEAD_DAGGER, TeadItems.LEAD_INGOT, "lead", true, exporter, null);
        offerHollowDaggerRecipe(TeadItems.LEAD_HOLLOW_DAGGER, TeadItems.LEAD_DAGGER, TeadItems.LEAD_INGOT, "lead", exporter);
        offerRiteDaggerRecipe(TeadItems.LEAD_RITE_DAGGER, TeadItems.LEAD_DAGGER, TeadItems.LEAD_INGOT, "lead", exporter);
        offerCrescentDaggerRecipe(TeadItems.LEAD_CRESCENT_DAGGER, TeadItems.LEAD_DAGGER, TeadItems.LEAD_INGOT, "lead", exporter);
        offerTruthseekerRecipe(TeadItems.LEAD_TRUTHSEEKER, TeadItems.LEAD_SWORD, TeadItems.LEAD_INGOT, "lead", exporter);
        offerTempestKnifeRecipe(TeadItems.LEAD_TEMPEST_KNIFE, TeadItems.LEAD_SWORD, TeadItems.LEAD_INGOT, "lead", exporter);
        offerCutlassRecipe(TeadItems.LEAD_CUTLASS, TeadItems.LEAD_SWORD, TeadItems.LEAD_INGOT, "lead", exporter);
        offerRapierRecipe(TeadItems.LEAD_RAPIER, TeadItems.LEAD_SWORD, TeadItems.LEAD_INGOT, "lead", exporter);
        offerKatanaRecipe(TeadItems.LEAD_KATANA, TeadItems.LEAD_SWORD, TeadItems.LEAD_INGOT, "lead", exporter);
        offerHighlandAxeRecipe(TeadItems.LEAD_HIGHLAND_AXE, TeadItems.LEAD_AXE, TeadItems.LEAD_INGOT, "lead", exporter);
        offerDoubleAxeRecipe(TeadItems.LEAD_DOUBLE_AXE, TeadItems.LEAD_INGOT, "lead", true, exporter, null);
        offerDoubleHighlandAxeRecipe(TeadItems.LEAD_DOUBLE_HIGHLAND_AXE, TeadItems.LEAD_DOUBLE_AXE, TeadItems.LEAD_INGOT, "lead", exporter);
        offerSickleRecipe(TeadItems.LEAD_SICKLE, TeadItems.LEAD_INGOT, "lead", true, exporter, null);
        offerScytheRecipe(TeadItems.LEAD_SCYTHE, TeadItems.LEAD_INGOT, "lead", true, exporter, null);
        offerGreatswordRecipe(TeadItems.LEAD_GREATSWORD, TeadItems.LEAD_SWORD, TeadItems.LEAD_INGOT, "lead", exporter);
        offerLongswordRecipe(TeadItems.LEAD_LONGSWORD, TeadItems.LEAD_INGOT, "lead", true, exporter, null);
        offerBroadswordRecipe(TeadItems.LEAD_BROADSWORD, TeadItems.LEAD_LONGSWORD, TeadItems.LEAD_INGOT, "lead", exporter);
        offerClaymoreRecipe(TeadItems.LEAD_CLAYMORE, TeadItems.LEAD_INGOT, "lead", true, exporter, null);
        offerSpearRecipe(TeadItems.LEAD_SPEAR, TeadItems.LEAD_INGOT, "lead", true, exporter, null);
        offerRanseurRecipe(TeadItems.LEAD_RANSEUR, TeadItems.LEAD_SPEAR, TeadItems.LEAD_INGOT, "lead", exporter);
        offerGlaiveRecipe(TeadItems.LEAD_GLAIVE, TeadItems.LEAD_SPEAR, TeadItems.LEAD_INGOT, "lead", exporter);

        // Copper Tools
        offerShovelRecipe(TeadItems.COPPER_SHOVEL, Items.COPPER_INGOT, "copper", true, exporter, null);
        offerHoeRecipe(TeadItems.COPPER_HOE, Items.COPPER_INGOT, "copper", true, exporter, null);
        offerPickaxeRecipe(TeadItems.COPPER_PICKAXE, Items.COPPER_INGOT, "copper", true, exporter, null);
        offerAxeRecipe(TeadItems.COPPER_AXE, Items.COPPER_INGOT, "copper", true, exporter, null);
        offerSwordRecipe(TeadItems.COPPER_SWORD, Items.COPPER_INGOT, "copper", true, exporter, null);

        offerHatchetRecipe(TeadItems.COPPER_HATCHET, Items.COPPER_INGOT, "copper", true, exporter, null);
        offerHammerRecipe(TeadItems.COPPER_HAMMER, Items.COPPER_INGOT, "copper", true, exporter, null);
        offerMountaineerPickRecipe(TeadItems.COPPER_MOUNTAINEER_PICK, TeadItems.COPPER_PICKAXE, Items.COPPER_INGOT, "copper", exporter);
        offerMattockRecipe(TeadItems.COPPER_MATTOCK, Items.COPPER_INGOT, "copper", true, exporter, null);
        offerMaceRecipe(TeadItems.COPPER_MACE, Items.COPPER_INGOT, "copper", true, exporter, null);
        offerDaggerRecipe(TeadItems.COPPER_DAGGER, Items.COPPER_INGOT, "copper", true, exporter, null);
        offerHollowDaggerRecipe(TeadItems.COPPER_HOLLOW_DAGGER, TeadItems.COPPER_DAGGER, Items.COPPER_INGOT, "copper", exporter);
        offerRiteDaggerRecipe(TeadItems.COPPER_RITE_DAGGER, TeadItems.COPPER_DAGGER, Items.COPPER_INGOT, "copper", exporter);
        offerCrescentDaggerRecipe(TeadItems.COPPER_CRESCENT_DAGGER, TeadItems.COPPER_DAGGER, Items.COPPER_INGOT, "copper", exporter);
        offerTruthseekerRecipe(TeadItems.COPPER_TRUTHSEEKER, TeadItems.COPPER_SWORD, Items.COPPER_INGOT, "copper", exporter);
        offerTempestKnifeRecipe(TeadItems.COPPER_TEMPEST_KNIFE, TeadItems.COPPER_SWORD, Items.COPPER_INGOT, "copper", exporter);
        offerCutlassRecipe(TeadItems.COPPER_CUTLASS, TeadItems.COPPER_SWORD, Items.COPPER_INGOT, "copper", exporter);
        offerRapierRecipe(TeadItems.COPPER_RAPIER, TeadItems.COPPER_SWORD, Items.COPPER_INGOT, "copper", exporter);
        offerKatanaRecipe(TeadItems.COPPER_KATANA, TeadItems.COPPER_SWORD, Items.COPPER_INGOT, "copper", exporter);
        offerHighlandAxeRecipe(TeadItems.COPPER_HIGHLAND_AXE, TeadItems.COPPER_AXE, Items.COPPER_INGOT, "copper", exporter);
        offerDoubleAxeRecipe(TeadItems.COPPER_DOUBLE_AXE, Items.COPPER_INGOT, "copper", true, exporter, null);
        offerDoubleHighlandAxeRecipe(TeadItems.COPPER_DOUBLE_HIGHLAND_AXE, TeadItems.COPPER_DOUBLE_AXE, Items.COPPER_INGOT, "copper", exporter);
        offerSickleRecipe(TeadItems.COPPER_SICKLE, Items.COPPER_INGOT, "copper", true, exporter, null);
        offerScytheRecipe(TeadItems.COPPER_SCYTHE, Items.COPPER_INGOT, "copper", true, exporter, null);
        offerGreatswordRecipe(TeadItems.COPPER_GREATSWORD, TeadItems.COPPER_SWORD, Items.COPPER_INGOT, "copper", exporter);
        offerLongswordRecipe(TeadItems.COPPER_LONGSWORD, Items.COPPER_INGOT, "copper", true, exporter, null);
        offerBroadswordRecipe(TeadItems.COPPER_BROADSWORD, TeadItems.COPPER_LONGSWORD, Items.COPPER_INGOT, "copper", exporter);
        offerClaymoreRecipe(TeadItems.COPPER_CLAYMORE, Items.COPPER_INGOT, "copper", true, exporter, null);
        offerSpearRecipe(TeadItems.COPPER_SPEAR, Items.COPPER_INGOT, "copper", true, exporter, null);
        offerRanseurRecipe(TeadItems.COPPER_RANSEUR, TeadItems.COPPER_SPEAR, Items.COPPER_INGOT, "copper", exporter);
        offerGlaiveRecipe(TeadItems.COPPER_GLAIVE, TeadItems.COPPER_SPEAR, Items.COPPER_INGOT, "copper", exporter);

        // Rose Gold Tools
        offerShovelRecipe(TeadItems.ROSE_GOLD_SHOVEL, TeadItems.ROSE_GOLD_INGOT, "rose_gold", true, exporter, null);
        offerHoeRecipe(TeadItems.ROSE_GOLD_HOE, TeadItems.ROSE_GOLD_INGOT, "rose_gold", true, exporter, null);
        offerPickaxeRecipe(TeadItems.ROSE_GOLD_PICKAXE, TeadItems.ROSE_GOLD_INGOT, "rose_gold", true, exporter, null);
        offerAxeRecipe(TeadItems.ROSE_GOLD_AXE, TeadItems.ROSE_GOLD_INGOT, "rose_gold", true, exporter, null);
        offerSwordRecipe(TeadItems.ROSE_GOLD_SWORD, TeadItems.ROSE_GOLD_INGOT, "rose_gold", true, exporter, null);

        offerHatchetRecipe(TeadItems.ROSE_GOLD_HATCHET, TeadItems.ROSE_GOLD_INGOT, "rose_gold", true, exporter, null);
        offerHammerRecipe(TeadItems.ROSE_GOLD_HAMMER, TeadItems.ROSE_GOLD_INGOT, "rose_gold", true, exporter, null);
        offerMountaineerPickRecipe(TeadItems.ROSE_GOLD_MOUNTAINEER_PICK, TeadItems.ROSE_GOLD_PICKAXE, TeadItems.ROSE_GOLD_INGOT, "rose_gold", exporter);
        offerMattockRecipe(TeadItems.ROSE_GOLD_MATTOCK, TeadItems.ROSE_GOLD_INGOT, "rose_gold", true, exporter, null);
        offerMaceRecipe(TeadItems.ROSE_GOLD_MACE, TeadItems.ROSE_GOLD_INGOT, "rose_gold", true, exporter, null);
        offerDaggerRecipe(TeadItems.ROSE_GOLD_DAGGER, TeadItems.ROSE_GOLD_INGOT, "rose_gold", true, exporter, null);
        offerHollowDaggerRecipe(TeadItems.ROSE_GOLD_HOLLOW_DAGGER, TeadItems.ROSE_GOLD_DAGGER, TeadItems.ROSE_GOLD_INGOT, "rose_gold", exporter);
        offerRiteDaggerRecipe(TeadItems.ROSE_GOLD_RITE_DAGGER, TeadItems.ROSE_GOLD_DAGGER, TeadItems.ROSE_GOLD_INGOT, "rose_gold", exporter);
        offerCrescentDaggerRecipe(TeadItems.ROSE_GOLD_CRESCENT_DAGGER, TeadItems.ROSE_GOLD_DAGGER, TeadItems.ROSE_GOLD_INGOT, "rose_gold", exporter);
        offerTruthseekerRecipe(TeadItems.ROSE_GOLD_TRUTHSEEKER, TeadItems.ROSE_GOLD_SWORD, TeadItems.ROSE_GOLD_INGOT, "rose_gold", exporter);
        offerTempestKnifeRecipe(TeadItems.ROSE_GOLD_TEMPEST_KNIFE, TeadItems.ROSE_GOLD_SWORD, TeadItems.ROSE_GOLD_INGOT, "rose_gold", exporter);
        offerCutlassRecipe(TeadItems.ROSE_GOLD_CUTLASS, TeadItems.ROSE_GOLD_SWORD, TeadItems.ROSE_GOLD_INGOT, "rose_gold", exporter);
        offerRapierRecipe(TeadItems.ROSE_GOLD_RAPIER, TeadItems.ROSE_GOLD_SWORD, TeadItems.ROSE_GOLD_INGOT, "rose_gold", exporter);
        offerKatanaRecipe(TeadItems.ROSE_GOLD_KATANA, TeadItems.ROSE_GOLD_SWORD, TeadItems.ROSE_GOLD_INGOT, "rose_gold", exporter);
        offerHighlandAxeRecipe(TeadItems.ROSE_GOLD_HIGHLAND_AXE, TeadItems.ROSE_GOLD_AXE, TeadItems.ROSE_GOLD_INGOT, "rose_gold", exporter);
        offerDoubleAxeRecipe(TeadItems.ROSE_GOLD_DOUBLE_AXE, TeadItems.ROSE_GOLD_INGOT, "rose_gold", true, exporter, null);
        offerDoubleHighlandAxeRecipe(TeadItems.ROSE_GOLD_DOUBLE_HIGHLAND_AXE, TeadItems.ROSE_GOLD_DOUBLE_AXE, TeadItems.ROSE_GOLD_INGOT, "rose_gold", exporter);
        offerSickleRecipe(TeadItems.ROSE_GOLD_SICKLE, TeadItems.ROSE_GOLD_INGOT, "rose_gold", true, exporter, null);
        offerScytheRecipe(TeadItems.ROSE_GOLD_SCYTHE, TeadItems.ROSE_GOLD_INGOT, "rose_gold", true, exporter, null);
        offerGreatswordRecipe(TeadItems.ROSE_GOLD_GREATSWORD, TeadItems.ROSE_GOLD_SWORD, TeadItems.ROSE_GOLD_INGOT, "rose_gold", exporter);
        offerLongswordRecipe(TeadItems.ROSE_GOLD_LONGSWORD, TeadItems.ROSE_GOLD_INGOT, "rose_gold", true, exporter, null);
        offerBroadswordRecipe(TeadItems.ROSE_GOLD_BROADSWORD, TeadItems.ROSE_GOLD_LONGSWORD, TeadItems.ROSE_GOLD_INGOT, "rose_gold", exporter);
        offerClaymoreRecipe(TeadItems.ROSE_GOLD_CLAYMORE, TeadItems.ROSE_GOLD_INGOT, "rose_gold", true, exporter, null);
        offerSpearRecipe(TeadItems.ROSE_GOLD_SPEAR, TeadItems.ROSE_GOLD_INGOT, "rose_gold", true, exporter, null);
        offerRanseurRecipe(TeadItems.ROSE_GOLD_RANSEUR, TeadItems.ROSE_GOLD_SPEAR, TeadItems.ROSE_GOLD_INGOT, "rose_gold", exporter);
        offerGlaiveRecipe(TeadItems.ROSE_GOLD_GLAIVE, TeadItems.ROSE_GOLD_SPEAR, TeadItems.ROSE_GOLD_INGOT, "rose_gold", exporter);

        // White Gold Tools
        offerShovelRecipe(TeadItems.WHITE_GOLD_SHOVEL, TeadItems.WHITE_GOLD_INGOT, "white_gold", true, exporter, null);
        offerHoeRecipe(TeadItems.WHITE_GOLD_HOE, TeadItems.WHITE_GOLD_INGOT, "white_gold", true, exporter, null);
        offerPickaxeRecipe(TeadItems.WHITE_GOLD_PICKAXE, TeadItems.WHITE_GOLD_INGOT, "white_gold", true, exporter, null);
        offerAxeRecipe(TeadItems.WHITE_GOLD_AXE, TeadItems.WHITE_GOLD_INGOT, "white_gold", true, exporter, null);
        offerSwordRecipe(TeadItems.WHITE_GOLD_SWORD, TeadItems.WHITE_GOLD_INGOT, "white_gold", true, exporter, null);

        offerHatchetRecipe(TeadItems.WHITE_GOLD_HATCHET, TeadItems.WHITE_GOLD_INGOT, "white_gold", true, exporter, null);
        offerHammerRecipe(TeadItems.WHITE_GOLD_HAMMER, TeadItems.WHITE_GOLD_INGOT, "white_gold", true, exporter, null);
        offerMountaineerPickRecipe(TeadItems.WHITE_GOLD_MOUNTAINEER_PICK, TeadItems.WHITE_GOLD_PICKAXE, TeadItems.WHITE_GOLD_INGOT, "white_gold", exporter);
        offerMattockRecipe(TeadItems.WHITE_GOLD_MATTOCK, TeadItems.WHITE_GOLD_INGOT, "white_gold", true, exporter, null);
        offerMaceRecipe(TeadItems.WHITE_GOLD_MACE, TeadItems.WHITE_GOLD_INGOT, "white_gold", true, exporter, null);
        offerDaggerRecipe(TeadItems.WHITE_GOLD_DAGGER, TeadItems.WHITE_GOLD_INGOT, "white_gold", true, exporter, null);
        offerHollowDaggerRecipe(TeadItems.WHITE_GOLD_HOLLOW_DAGGER, TeadItems.WHITE_GOLD_DAGGER, TeadItems.WHITE_GOLD_INGOT, "white_gold", exporter);
        offerRiteDaggerRecipe(TeadItems.WHITE_GOLD_RITE_DAGGER, TeadItems.WHITE_GOLD_DAGGER, TeadItems.WHITE_GOLD_INGOT, "white_gold", exporter);
        offerCrescentDaggerRecipe(TeadItems.WHITE_GOLD_CRESCENT_DAGGER, TeadItems.WHITE_GOLD_DAGGER, TeadItems.WHITE_GOLD_INGOT, "white_gold", exporter);
        offerTruthseekerRecipe(TeadItems.WHITE_GOLD_TRUTHSEEKER, TeadItems.WHITE_GOLD_SWORD, TeadItems.WHITE_GOLD_INGOT, "white_gold", exporter);
        offerTempestKnifeRecipe(TeadItems.WHITE_GOLD_TEMPEST_KNIFE, TeadItems.WHITE_GOLD_SWORD, TeadItems.WHITE_GOLD_INGOT, "white_gold", exporter);
        offerCutlassRecipe(TeadItems.WHITE_GOLD_CUTLASS, TeadItems.WHITE_GOLD_SWORD, TeadItems.WHITE_GOLD_INGOT, "white_gold", exporter);
        offerRapierRecipe(TeadItems.WHITE_GOLD_RAPIER, TeadItems.WHITE_GOLD_SWORD, TeadItems.WHITE_GOLD_INGOT, "white_gold", exporter);
        offerKatanaRecipe(TeadItems.WHITE_GOLD_KATANA, TeadItems.WHITE_GOLD_SWORD, TeadItems.WHITE_GOLD_INGOT, "white_gold", exporter);
        offerHighlandAxeRecipe(TeadItems.WHITE_GOLD_HIGHLAND_AXE, TeadItems.WHITE_GOLD_AXE, TeadItems.WHITE_GOLD_INGOT, "white_gold", exporter);
        offerDoubleAxeRecipe(TeadItems.WHITE_GOLD_DOUBLE_AXE, TeadItems.WHITE_GOLD_INGOT, "white_gold", true, exporter, null);
        offerDoubleHighlandAxeRecipe(TeadItems.WHITE_GOLD_DOUBLE_HIGHLAND_AXE, TeadItems.WHITE_GOLD_DOUBLE_AXE, TeadItems.WHITE_GOLD_INGOT, "white_gold", exporter);
        offerSickleRecipe(TeadItems.WHITE_GOLD_SICKLE, TeadItems.WHITE_GOLD_INGOT, "white_gold", true, exporter, null);
        offerScytheRecipe(TeadItems.WHITE_GOLD_SCYTHE, TeadItems.WHITE_GOLD_INGOT, "white_gold", true, exporter, null);
        offerGreatswordRecipe(TeadItems.WHITE_GOLD_GREATSWORD, TeadItems.WHITE_GOLD_SWORD, TeadItems.WHITE_GOLD_INGOT, "white_gold", exporter);
        offerLongswordRecipe(TeadItems.WHITE_GOLD_LONGSWORD, TeadItems.WHITE_GOLD_INGOT, "white_gold", true, exporter, null);
        offerBroadswordRecipe(TeadItems.WHITE_GOLD_BROADSWORD, TeadItems.WHITE_GOLD_LONGSWORD, TeadItems.WHITE_GOLD_INGOT, "white_gold", exporter);
        offerClaymoreRecipe(TeadItems.WHITE_GOLD_CLAYMORE, TeadItems.WHITE_GOLD_INGOT, "white_gold", true, exporter, null);
        offerSpearRecipe(TeadItems.WHITE_GOLD_SPEAR, TeadItems.WHITE_GOLD_INGOT, "white_gold", true, exporter, null);
        offerRanseurRecipe(TeadItems.WHITE_GOLD_RANSEUR, TeadItems.WHITE_GOLD_SPEAR, TeadItems.WHITE_GOLD_INGOT, "white_gold", exporter);
        offerGlaiveRecipe(TeadItems.WHITE_GOLD_GLAIVE, TeadItems.WHITE_GOLD_SPEAR, TeadItems.WHITE_GOLD_INGOT, "white_gold", exporter);

        // Iron Tools
//        offerShovelRecipe(Items.IRON_SHOVEL, Items.IRON_INGOT, "iron", true, exporter, Tead.MINECRAFT_ID);
//        offerHoeRecipe(Items.IRON_HOE, Items.IRON_INGOT, "iron", true, exporter, Tead.MINECRAFT_ID);
//        offerPickaxeRecipe(Items.IRON_PICKAXE, Items.IRON_INGOT, "iron", true, exporter, Tead.MINECRAFT_ID);
//        offerAxeRecipe(Items.IRON_AXE, Items.IRON_INGOT, "iron", true, exporter, Tead.MINECRAFT_ID);
//        offerSwordRecipe(Items.IRON_SWORD, Items.IRON_INGOT, "iron", true, exporter, Tead.MINECRAFT_ID);

        offerHatchetRecipe(TeadItems.IRON_HATCHET, Items.IRON_INGOT, "iron", true, exporter, null);
        offerHammerRecipe(TeadItems.IRON_HAMMER, Items.IRON_INGOT, "iron", true, exporter, null);
        offerMountaineerPickRecipe(TeadItems.IRON_MOUNTAINEER_PICK, Items.IRON_PICKAXE, Items.IRON_INGOT, "iron", exporter);
        offerMattockRecipe(TeadItems.IRON_MATTOCK, Items.IRON_INGOT, "iron", true, exporter, null);
        offerMaceRecipe(TeadItems.IRON_MACE, Items.IRON_INGOT, "iron", true, exporter, null);
        offerDaggerRecipe(TeadItems.IRON_DAGGER, Items.IRON_INGOT, "iron", true, exporter, null);
        offerHollowDaggerRecipe(TeadItems.IRON_HOLLOW_DAGGER, TeadItems.IRON_DAGGER, Items.IRON_INGOT, "iron", exporter);
        offerRiteDaggerRecipe(TeadItems.IRON_RITE_DAGGER, TeadItems.IRON_DAGGER, Items.IRON_INGOT, "iron", exporter);
        offerCrescentDaggerRecipe(TeadItems.IRON_CRESCENT_DAGGER, TeadItems.IRON_DAGGER, Items.IRON_INGOT, "iron", exporter);
        offerTruthseekerRecipe(TeadItems.IRON_TRUTHSEEKER, Items.IRON_SWORD, Items.IRON_INGOT, "iron", exporter);
        offerTempestKnifeRecipe(TeadItems.IRON_TEMPEST_KNIFE, Items.IRON_SWORD, Items.IRON_INGOT, "iron", exporter);
        offerCutlassRecipe(TeadItems.IRON_CUTLASS, Items.IRON_SWORD, Items.IRON_INGOT, "iron", exporter);
        offerRapierRecipe(TeadItems.IRON_RAPIER, Items.IRON_SWORD, Items.IRON_INGOT, "iron", exporter);
        offerKatanaRecipe(TeadItems.IRON_KATANA, Items.IRON_SWORD, Items.IRON_INGOT, "iron", exporter);
        offerHighlandAxeRecipe(TeadItems.IRON_HIGHLAND_AXE, Items.IRON_AXE, Items.IRON_INGOT, "iron", exporter);
        offerDoubleAxeRecipe(TeadItems.IRON_DOUBLE_AXE, Items.IRON_INGOT, "iron", true, exporter, null);
        offerDoubleHighlandAxeRecipe(TeadItems.IRON_DOUBLE_HIGHLAND_AXE, TeadItems.IRON_DOUBLE_AXE, Items.IRON_INGOT, "iron", exporter);
        offerSickleRecipe(TeadItems.IRON_SICKLE, Items.IRON_INGOT, "iron", true, exporter, null);
        offerScytheRecipe(TeadItems.IRON_SCYTHE, Items.IRON_INGOT, "iron", true, exporter, null);
        offerGreatswordRecipe(TeadItems.IRON_GREATSWORD, Items.IRON_SWORD, Items.IRON_INGOT, "iron", exporter);
        offerLongswordRecipe(TeadItems.IRON_LONGSWORD, Items.IRON_INGOT, "iron", true, exporter, null);
        offerBroadswordRecipe(TeadItems.IRON_BROADSWORD, TeadItems.IRON_LONGSWORD, Items.IRON_INGOT, "iron", exporter);
        offerClaymoreRecipe(TeadItems.IRON_CLAYMORE, Items.IRON_INGOT, "iron", true, exporter, null);
        offerSpearRecipe(TeadItems.IRON_SPEAR, Items.IRON_INGOT, "iron", true, exporter, null);
        offerRanseurRecipe(TeadItems.IRON_RANSEUR, TeadItems.IRON_SPEAR, Items.IRON_INGOT, "iron", exporter);
        offerGlaiveRecipe(TeadItems.IRON_GLAIVE, TeadItems.IRON_SPEAR, Items.IRON_INGOT, "iron", exporter);

        // Brass Tools
        offerShovelRecipe(TeadItems.BRASS_SHOVEL, TeadItems.BRASS_INGOT, "brass", true, exporter, null);
        offerHoeRecipe(TeadItems.BRASS_HOE, TeadItems.BRASS_INGOT, "brass", true, exporter, null);
        offerPickaxeRecipe(TeadItems.BRASS_PICKAXE, TeadItems.BRASS_INGOT, "brass", true, exporter, null);
        offerAxeRecipe(TeadItems.BRASS_AXE, TeadItems.BRASS_INGOT, "brass", true, exporter, null);
        offerSwordRecipe(TeadItems.BRASS_SWORD, TeadItems.BRASS_INGOT, "brass", true, exporter, null);

        offerHatchetRecipe(TeadItems.BRASS_HATCHET, TeadItems.BRASS_INGOT, "brass", true, exporter, null);
        offerHammerRecipe(TeadItems.BRASS_HAMMER, TeadItems.BRASS_INGOT, "brass", true, exporter, null);
        offerMountaineerPickRecipe(TeadItems.BRASS_MOUNTAINEER_PICK, TeadItems.BRASS_PICKAXE, TeadItems.BRASS_INGOT, "brass", exporter);
        offerMattockRecipe(TeadItems.BRASS_MATTOCK, TeadItems.BRASS_INGOT, "brass", true, exporter, null);
        offerMaceRecipe(TeadItems.BRASS_MACE, TeadItems.BRASS_INGOT, "brass", true, exporter, null);
        offerDaggerRecipe(TeadItems.BRASS_DAGGER, TeadItems.BRASS_INGOT, "brass", true, exporter, null);
        offerHollowDaggerRecipe(TeadItems.BRASS_HOLLOW_DAGGER, TeadItems.BRASS_DAGGER, TeadItems.BRASS_INGOT, "brass", exporter);
        offerRiteDaggerRecipe(TeadItems.BRASS_RITE_DAGGER, TeadItems.BRASS_DAGGER, TeadItems.BRASS_INGOT, "brass", exporter);
        offerCrescentDaggerRecipe(TeadItems.BRASS_CRESCENT_DAGGER, TeadItems.BRASS_DAGGER, TeadItems.BRASS_INGOT, "brass", exporter);
        offerTruthseekerRecipe(TeadItems.BRASS_TRUTHSEEKER, TeadItems.BRASS_SWORD, TeadItems.BRASS_INGOT, "brass", exporter);
        offerTempestKnifeRecipe(TeadItems.BRASS_TEMPEST_KNIFE, TeadItems.BRASS_SWORD, TeadItems.BRASS_INGOT, "brass", exporter);
        offerCutlassRecipe(TeadItems.BRASS_CUTLASS, TeadItems.BRASS_SWORD, TeadItems.BRASS_INGOT, "brass", exporter);
        offerRapierRecipe(TeadItems.BRASS_RAPIER, TeadItems.BRASS_SWORD, TeadItems.BRASS_INGOT, "brass", exporter);
        offerKatanaRecipe(TeadItems.BRASS_KATANA, TeadItems.BRASS_SWORD, TeadItems.BRASS_INGOT, "brass", exporter);
        offerHighlandAxeRecipe(TeadItems.BRASS_HIGHLAND_AXE, TeadItems.BRASS_AXE, TeadItems.BRASS_INGOT, "brass", exporter);
        offerDoubleAxeRecipe(TeadItems.BRASS_DOUBLE_AXE, TeadItems.BRASS_INGOT, "brass", true, exporter, null);
        offerDoubleHighlandAxeRecipe(TeadItems.BRASS_DOUBLE_HIGHLAND_AXE, TeadItems.BRASS_DOUBLE_AXE, TeadItems.BRASS_INGOT, "brass", exporter);
        offerSickleRecipe(TeadItems.BRASS_SICKLE, TeadItems.BRASS_INGOT, "brass", true, exporter, null);
        offerScytheRecipe(TeadItems.BRASS_SCYTHE, TeadItems.BRASS_INGOT, "brass", true, exporter, null);
        offerGreatswordRecipe(TeadItems.BRASS_GREATSWORD, TeadItems.BRASS_SWORD, TeadItems.BRASS_INGOT, "brass", exporter);
        offerLongswordRecipe(TeadItems.BRASS_LONGSWORD, TeadItems.BRASS_INGOT, "brass", true, exporter, null);
        offerBroadswordRecipe(TeadItems.BRASS_BROADSWORD, TeadItems.BRASS_LONGSWORD, TeadItems.BRASS_INGOT, "brass", exporter);
        offerClaymoreRecipe(TeadItems.BRASS_CLAYMORE, TeadItems.BRASS_INGOT, "brass", true, exporter, null);
        offerSpearRecipe(TeadItems.BRASS_SPEAR, TeadItems.BRASS_INGOT, "brass", true, exporter, null);
        offerRanseurRecipe(TeadItems.BRASS_RANSEUR, TeadItems.BRASS_SPEAR, TeadItems.BRASS_INGOT, "brass", exporter);
        offerGlaiveRecipe(TeadItems.BRASS_GLAIVE, TeadItems.BRASS_SPEAR, TeadItems.BRASS_INGOT, "brass", exporter);

        // Bronze Tools
        offerShovelRecipe(TeadItems.BRONZE_SHOVEL, TeadItems.BRONZE_INGOT, "bronze", true, exporter, null);
        offerHoeRecipe(TeadItems.BRONZE_HOE, TeadItems.BRONZE_INGOT, "bronze", true, exporter, null);
        offerPickaxeRecipe(TeadItems.BRONZE_PICKAXE, TeadItems.BRONZE_INGOT, "bronze", true, exporter, null);
        offerAxeRecipe(TeadItems.BRONZE_AXE, TeadItems.BRONZE_INGOT, "bronze", true, exporter, null);
        offerSwordRecipe(TeadItems.BRONZE_SWORD, TeadItems.BRONZE_INGOT, "bronze", true, exporter, null);

        offerHatchetRecipe(TeadItems.BRONZE_HATCHET, TeadItems.BRONZE_INGOT, "bronze", true, exporter, null);
        offerHammerRecipe(TeadItems.BRONZE_HAMMER, TeadItems.BRONZE_INGOT, "bronze", true, exporter, null);
        offerMountaineerPickRecipe(TeadItems.BRONZE_MOUNTAINEER_PICK, TeadItems.BRONZE_PICKAXE, TeadItems.BRONZE_INGOT, "bronze", exporter);
        offerMattockRecipe(TeadItems.BRONZE_MATTOCK, TeadItems.BRONZE_INGOT, "bronze", true, exporter, null);
        offerMaceRecipe(TeadItems.BRONZE_MACE, TeadItems.BRONZE_INGOT, "bronze", true, exporter, null);
        offerDaggerRecipe(TeadItems.BRONZE_DAGGER, TeadItems.BRONZE_INGOT, "bronze", true, exporter, null);
        offerHollowDaggerRecipe(TeadItems.BRONZE_HOLLOW_DAGGER, TeadItems.BRONZE_DAGGER, TeadItems.BRONZE_INGOT, "bronze", exporter);
        offerRiteDaggerRecipe(TeadItems.BRONZE_RITE_DAGGER, TeadItems.BRONZE_DAGGER, TeadItems.BRONZE_INGOT, "bronze", exporter);
        offerCrescentDaggerRecipe(TeadItems.BRONZE_CRESCENT_DAGGER, TeadItems.BRONZE_DAGGER, TeadItems.BRONZE_INGOT, "bronze", exporter);
        offerTruthseekerRecipe(TeadItems.BRONZE_TRUTHSEEKER, TeadItems.BRONZE_SWORD, TeadItems.BRONZE_INGOT, "bronze", exporter);
        offerTempestKnifeRecipe(TeadItems.BRONZE_TEMPEST_KNIFE, TeadItems.BRONZE_SWORD, TeadItems.BRONZE_INGOT, "bronze", exporter);
        offerCutlassRecipe(TeadItems.BRONZE_CUTLASS, TeadItems.BRONZE_SWORD, TeadItems.BRONZE_INGOT, "bronze", exporter);
        offerRapierRecipe(TeadItems.BRONZE_RAPIER, TeadItems.BRONZE_SWORD, TeadItems.BRONZE_INGOT, "bronze", exporter);
        offerKatanaRecipe(TeadItems.BRONZE_KATANA, TeadItems.BRONZE_SWORD, TeadItems.BRONZE_INGOT, "bronze", exporter);
        offerHighlandAxeRecipe(TeadItems.BRONZE_HIGHLAND_AXE, TeadItems.BRONZE_AXE, TeadItems.BRONZE_INGOT, "bronze", exporter);
        offerDoubleAxeRecipe(TeadItems.BRONZE_DOUBLE_AXE, TeadItems.BRONZE_INGOT, "bronze", true, exporter, null);
        offerDoubleHighlandAxeRecipe(TeadItems.BRONZE_DOUBLE_HIGHLAND_AXE, TeadItems.BRONZE_DOUBLE_AXE, TeadItems.BRONZE_INGOT, "bronze", exporter);
        offerSickleRecipe(TeadItems.BRONZE_SICKLE, TeadItems.BRONZE_INGOT, "bronze", true, exporter, null);
        offerScytheRecipe(TeadItems.BRONZE_SCYTHE, TeadItems.BRONZE_INGOT, "bronze", true, exporter, null);
        offerGreatswordRecipe(TeadItems.BRONZE_GREATSWORD, TeadItems.BRONZE_SWORD, TeadItems.BRONZE_INGOT, "bronze", exporter);
        offerLongswordRecipe(TeadItems.BRONZE_LONGSWORD, TeadItems.BRONZE_INGOT, "bronze", true, exporter, null);
        offerBroadswordRecipe(TeadItems.BRONZE_BROADSWORD, TeadItems.BRONZE_LONGSWORD, TeadItems.BRONZE_INGOT, "bronze", exporter);
        offerClaymoreRecipe(TeadItems.BRONZE_CLAYMORE, TeadItems.BRONZE_INGOT, "bronze", true, exporter, null);
        offerSpearRecipe(TeadItems.BRONZE_SPEAR, TeadItems.BRONZE_INGOT, "bronze", true, exporter, null);
        offerRanseurRecipe(TeadItems.BRONZE_RANSEUR, TeadItems.BRONZE_SPEAR, TeadItems.BRONZE_INGOT, "bronze", exporter);
        offerGlaiveRecipe(TeadItems.BRONZE_GLAIVE, TeadItems.BRONZE_SPEAR, TeadItems.BRONZE_INGOT, "bronze", exporter);

        // Steel Tools
        offerShovelRecipe(TeadItems.STEEL_SHOVEL, TeadItems.STEEL_INGOT, "steel", true, exporter, null);
        offerHoeRecipe(TeadItems.STEEL_HOE, TeadItems.STEEL_INGOT, "steel", true, exporter, null);
        offerPickaxeRecipe(TeadItems.STEEL_PICKAXE, TeadItems.STEEL_INGOT, "steel", true, exporter, null);
        offerAxeRecipe(TeadItems.STEEL_AXE, TeadItems.STEEL_INGOT, "steel", true, exporter, null);
        offerSwordRecipe(TeadItems.STEEL_SWORD, TeadItems.STEEL_INGOT, "steel", true, exporter, null);

        offerHatchetRecipe(TeadItems.STEEL_HATCHET, TeadItems.STEEL_INGOT, "steel", true, exporter, null);
        offerHammerRecipe(TeadItems.STEEL_HAMMER, TeadItems.STEEL_INGOT, "steel", true, exporter, null);
        offerMountaineerPickRecipe(TeadItems.STEEL_MOUNTAINEER_PICK, TeadItems.STEEL_PICKAXE, TeadItems.STEEL_INGOT, "steel", exporter);
        offerMattockRecipe(TeadItems.STEEL_MATTOCK, TeadItems.STEEL_INGOT, "steel", true, exporter, null);
        offerMaceRecipe(TeadItems.STEEL_MACE, TeadItems.STEEL_INGOT, "steel", true, exporter, null);
        offerDaggerRecipe(TeadItems.STEEL_DAGGER, TeadItems.STEEL_INGOT, "steel", true, exporter, null);
        offerHollowDaggerRecipe(TeadItems.STEEL_HOLLOW_DAGGER, TeadItems.STEEL_DAGGER, TeadItems.STEEL_INGOT, "steel", exporter);
        offerRiteDaggerRecipe(TeadItems.STEEL_RITE_DAGGER, TeadItems.STEEL_DAGGER, TeadItems.STEEL_INGOT, "steel", exporter);
        offerCrescentDaggerRecipe(TeadItems.STEEL_CRESCENT_DAGGER, TeadItems.STEEL_DAGGER, TeadItems.STEEL_INGOT, "steel", exporter);
        offerTruthseekerRecipe(TeadItems.STEEL_TRUTHSEEKER, TeadItems.STEEL_SWORD, TeadItems.STEEL_INGOT, "steel", exporter);
        offerTempestKnifeRecipe(TeadItems.STEEL_TEMPEST_KNIFE, TeadItems.STEEL_SWORD, TeadItems.STEEL_INGOT, "steel", exporter);
        offerCutlassRecipe(TeadItems.STEEL_CUTLASS, TeadItems.STEEL_SWORD, TeadItems.STEEL_INGOT, "steel", exporter);
        offerRapierRecipe(TeadItems.STEEL_RAPIER, TeadItems.STEEL_SWORD, TeadItems.STEEL_INGOT, "steel", exporter);
        offerKatanaRecipe(TeadItems.STEEL_KATANA, TeadItems.STEEL_SWORD, TeadItems.STEEL_INGOT, "steel", exporter);
        offerHighlandAxeRecipe(TeadItems.STEEL_HIGHLAND_AXE, TeadItems.STEEL_AXE, TeadItems.STEEL_INGOT, "steel", exporter);
        offerDoubleAxeRecipe(TeadItems.STEEL_DOUBLE_AXE, TeadItems.STEEL_INGOT, "steel", true, exporter, null);
        offerDoubleHighlandAxeRecipe(TeadItems.STEEL_DOUBLE_HIGHLAND_AXE, TeadItems.STEEL_DOUBLE_AXE, TeadItems.STEEL_INGOT, "steel", exporter);
        offerSickleRecipe(TeadItems.STEEL_SICKLE, TeadItems.STEEL_INGOT, "steel", true, exporter, null);
        offerScytheRecipe(TeadItems.STEEL_SCYTHE, TeadItems.STEEL_INGOT, "steel", true, exporter, null);
        offerGreatswordRecipe(TeadItems.STEEL_GREATSWORD, TeadItems.STEEL_SWORD, TeadItems.STEEL_INGOT, "steel", exporter);
        offerLongswordRecipe(TeadItems.STEEL_LONGSWORD, TeadItems.STEEL_INGOT, "steel", true, exporter, null);
        offerBroadswordRecipe(TeadItems.STEEL_BROADSWORD, TeadItems.STEEL_LONGSWORD, TeadItems.STEEL_INGOT, "steel", exporter);
        offerClaymoreRecipe(TeadItems.STEEL_CLAYMORE, TeadItems.STEEL_INGOT, "steel", true, exporter, null);
        offerSpearRecipe(TeadItems.STEEL_SPEAR, TeadItems.STEEL_INGOT, "steel", true, exporter, null);
        offerRanseurRecipe(TeadItems.STEEL_RANSEUR, TeadItems.STEEL_SPEAR, TeadItems.STEEL_INGOT, "steel", exporter);
        offerGlaiveRecipe(TeadItems.STEEL_GLAIVE, TeadItems.STEEL_SPEAR, TeadItems.STEEL_INGOT, "steel", exporter);

        // Diamond Tools
//        offerShovelRecipe(Items.DIAMOND_SHOVEL, Items.DIAMOND, "diamond", true, exporter, Tead.MINECRAFT_ID);
//        offerHoeRecipe(Items.DIAMOND_HOE, Items.DIAMOND, "diamond", true, exporter, Tead.MINECRAFT_ID);
//        offerPickaxeRecipe(Items.DIAMOND_PICKAXE, Items.DIAMOND, "diamond", true, exporter, Tead.MINECRAFT_ID);
//        offerAxeRecipe(Items.DIAMOND_AXE, Items.DIAMOND, "diamond", true, exporter, Tead.MINECRAFT_ID);
//        offerSwordRecipe(Items.DIAMOND_SWORD, Items.DIAMOND, "diamond", true, exporter, Tead.MINECRAFT_ID);

        offerHatchetRecipe(TeadItems.DIAMOND_HATCHET, Items.DIAMOND, "diamond", true, exporter, null);
        offerHammerRecipe(TeadItems.DIAMOND_HAMMER, Items.DIAMOND, "diamond", true, exporter, null);
        offerMountaineerPickRecipe(TeadItems.DIAMOND_MOUNTAINEER_PICK, Items.DIAMOND_PICKAXE, Items.DIAMOND, "diamond", exporter);
        offerMattockRecipe(TeadItems.DIAMOND_MATTOCK, Items.DIAMOND, "diamond", true, exporter, null);
        offerMaceRecipe(TeadItems.DIAMOND_MACE, Items.DIAMOND, "diamond", true, exporter, null);
        offerDaggerRecipe(TeadItems.DIAMOND_DAGGER, Items.DIAMOND, "diamond", true, exporter, null);
        offerHollowDaggerRecipe(TeadItems.DIAMOND_HOLLOW_DAGGER, TeadItems.DIAMOND_DAGGER, Items.DIAMOND, "diamond", exporter);
        offerRiteDaggerRecipe(TeadItems.DIAMOND_RITE_DAGGER, TeadItems.DIAMOND_DAGGER, Items.DIAMOND, "diamond", exporter);
        offerCrescentDaggerRecipe(TeadItems.DIAMOND_CRESCENT_DAGGER, TeadItems.DIAMOND_DAGGER, Items.DIAMOND, "diamond", exporter);
        offerTruthseekerRecipe(TeadItems.DIAMOND_TRUTHSEEKER, Items.DIAMOND_SWORD, Items.DIAMOND, "diamond", exporter);
        offerTempestKnifeRecipe(TeadItems.DIAMOND_TEMPEST_KNIFE, Items.DIAMOND_SWORD, Items.DIAMOND, "diamond", exporter);
        offerCutlassRecipe(TeadItems.DIAMOND_CUTLASS, Items.DIAMOND_SWORD, Items.DIAMOND, "diamond", exporter);
        offerRapierRecipe(TeadItems.DIAMOND_RAPIER, Items.DIAMOND_SWORD, Items.DIAMOND, "diamond", exporter);
        offerKatanaRecipe(TeadItems.DIAMOND_KATANA, Items.DIAMOND_SWORD, Items.DIAMOND, "diamond", exporter);
        offerHighlandAxeRecipe(TeadItems.DIAMOND_HIGHLAND_AXE, Items.DIAMOND_AXE, Items.DIAMOND, "diamond", exporter);
        offerDoubleAxeRecipe(TeadItems.DIAMOND_DOUBLE_AXE, Items.DIAMOND, "diamond", true, exporter, null);
        offerDoubleHighlandAxeRecipe(TeadItems.DIAMOND_DOUBLE_HIGHLAND_AXE, TeadItems.DIAMOND_DOUBLE_AXE, Items.DIAMOND, "diamond", exporter);
        offerSickleRecipe(TeadItems.DIAMOND_SICKLE, Items.DIAMOND, "diamond", true, exporter, null);
        offerScytheRecipe(TeadItems.DIAMOND_SCYTHE, Items.DIAMOND, "diamond", true, exporter, null);
        offerGreatswordRecipe(TeadItems.DIAMOND_GREATSWORD, Items.DIAMOND_SWORD, Items.DIAMOND, "diamond", exporter);
        offerLongswordRecipe(TeadItems.DIAMOND_LONGSWORD, Items.DIAMOND, "diamond", true, exporter, null);
        offerBroadswordRecipe(TeadItems.DIAMOND_BROADSWORD, TeadItems.DIAMOND_LONGSWORD, Items.DIAMOND, "diamond", exporter);
        offerClaymoreRecipe(TeadItems.DIAMOND_CLAYMORE, Items.DIAMOND, "diamond", true, exporter, null);
        offerSpearRecipe(TeadItems.DIAMOND_SPEAR, Items.DIAMOND, "diamond", true, exporter, null);
        offerRanseurRecipe(TeadItems.DIAMOND_RANSEUR, TeadItems.DIAMOND_SPEAR, Items.DIAMOND, "diamond", exporter);
        offerGlaiveRecipe(TeadItems.DIAMOND_GLAIVE, TeadItems.DIAMOND_SPEAR, Items.DIAMOND, "diamond", exporter);

        // Netherite Tools
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_HATCHET, RecipeCategory.TOOLS, TeadItems.NETHERITE_HATCHET);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_HAMMER, RecipeCategory.TOOLS, TeadItems.NETHERITE_HAMMER);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_MOUNTAINEER_PICK, RecipeCategory.TOOLS, TeadItems.NETHERITE_MOUNTAINEER_PICK);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_MATTOCK, RecipeCategory.TOOLS, TeadItems.NETHERITE_MATTOCK);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_MACE, RecipeCategory.COMBAT, TeadItems.NETHERITE_MACE);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_DAGGER, RecipeCategory.COMBAT, TeadItems.NETHERITE_DAGGER);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_HOLLOW_DAGGER, RecipeCategory.COMBAT, TeadItems.NETHERITE_HOLLOW_DAGGER);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_RITE_DAGGER, RecipeCategory.COMBAT, TeadItems.NETHERITE_RITE_DAGGER);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_CRESCENT_DAGGER, RecipeCategory.COMBAT, TeadItems.NETHERITE_CRESCENT_DAGGER);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_TRUTHSEEKER, RecipeCategory.COMBAT, TeadItems.NETHERITE_TRUTHSEEKER);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_TEMPEST_KNIFE, RecipeCategory.COMBAT, TeadItems.NETHERITE_TEMPEST_KNIFE);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_CUTLASS, RecipeCategory.COMBAT, TeadItems.NETHERITE_CUTLASS);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_RAPIER, RecipeCategory.COMBAT, TeadItems.NETHERITE_RAPIER);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_KATANA, RecipeCategory.COMBAT, TeadItems.NETHERITE_KATANA);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_HIGHLAND_AXE, RecipeCategory.TOOLS, TeadItems.NETHERITE_HIGHLAND_AXE);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_DOUBLE_AXE, RecipeCategory.TOOLS, TeadItems.NETHERITE_DOUBLE_AXE);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_DOUBLE_HIGHLAND_AXE, RecipeCategory.TOOLS, TeadItems.NETHERITE_DOUBLE_HIGHLAND_AXE);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_SICKLE, RecipeCategory.TOOLS, TeadItems.NETHERITE_SICKLE);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_SCYTHE, RecipeCategory.TOOLS, TeadItems.NETHERITE_SCYTHE);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_GREATSWORD, RecipeCategory.COMBAT, TeadItems.NETHERITE_GREATSWORD);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_LONGSWORD, RecipeCategory.COMBAT, TeadItems.NETHERITE_LONGSWORD);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_BROADSWORD, RecipeCategory.COMBAT, TeadItems.NETHERITE_BROADSWORD);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_CLAYMORE, RecipeCategory.COMBAT, TeadItems.NETHERITE_CLAYMORE);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_SPEAR, RecipeCategory.COMBAT, TeadItems.NETHERITE_SPEAR);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_RANSEUR, RecipeCategory.COMBAT, TeadItems.NETHERITE_RANSEUR);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_GLAIVE, RecipeCategory.COMBAT, TeadItems.NETHERITE_GLAIVE);

        // Rose Netherite Tools
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_HATCHET, TeadItems.DIAMOND_HATCHET, "hatchet", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_HAMMER, TeadItems.DIAMOND_HAMMER, "hammer", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_MOUNTAINEER_PICK, TeadItems.DIAMOND_MOUNTAINEER_PICK, "mountaineer_pick", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_MATTOCK, TeadItems.DIAMOND_MATTOCK, "mattock", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_MACE, TeadItems.DIAMOND_MACE, "mace", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_DAGGER, TeadItems.DIAMOND_DAGGER, "dagger", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_HOLLOW_DAGGER, TeadItems.DIAMOND_HOLLOW_DAGGER, "hollow_dagger", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_RITE_DAGGER, TeadItems.DIAMOND_RITE_DAGGER, "rite_dagger", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_CRESCENT_DAGGER, TeadItems.DIAMOND_CRESCENT_DAGGER, "crescent_dagger", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_TRUTHSEEKER, TeadItems.DIAMOND_TRUTHSEEKER, "truthseeker", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_TEMPEST_KNIFE, TeadItems.DIAMOND_TEMPEST_KNIFE, "tempest_knife", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_CUTLASS, TeadItems.DIAMOND_CUTLASS, "cutlass", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_RAPIER, TeadItems.DIAMOND_RAPIER, "rapier", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_KATANA, TeadItems.DIAMOND_KATANA, "katana", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_HIGHLAND_AXE, TeadItems.DIAMOND_HIGHLAND_AXE, "highland_axe", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_DOUBLE_AXE, TeadItems.DIAMOND_DOUBLE_AXE, "double_axe", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_DOUBLE_HIGHLAND_AXE, TeadItems.DIAMOND_DOUBLE_HIGHLAND_AXE, "double_highland_axe", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_SICKLE, TeadItems.DIAMOND_SICKLE, "sickle", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_SCYTHE, TeadItems.DIAMOND_SCYTHE, "scythe", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_GREATSWORD, TeadItems.DIAMOND_GREATSWORD, "greatsword", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_LONGSWORD, TeadItems.DIAMOND_LONGSWORD, "longsword", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_BROADSWORD, TeadItems.DIAMOND_BROADSWORD, "broadsword", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_CLAYMORE, TeadItems.DIAMOND_CLAYMORE, "claymore", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_SPEAR, TeadItems.DIAMOND_SPEAR, "spear", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_RANSEUR, TeadItems.DIAMOND_RANSEUR, "ranseur", exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_GLAIVE, TeadItems.DIAMOND_GLAIVE, "glaive", exporter);

        // White Netherite Tools
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_HATCHET, TeadItems.DIAMOND_HATCHET, "hatchet", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_HAMMER, TeadItems.DIAMOND_HAMMER, "hammer", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_MOUNTAINEER_PICK, TeadItems.DIAMOND_MOUNTAINEER_PICK, "mountaineer_pick", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_MATTOCK, TeadItems.DIAMOND_MATTOCK, "mattock", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_MACE, TeadItems.DIAMOND_MACE, "mace", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_DAGGER, TeadItems.DIAMOND_DAGGER, "dagger", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_HOLLOW_DAGGER, TeadItems.DIAMOND_HOLLOW_DAGGER, "hollow_dagger", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_RITE_DAGGER, TeadItems.DIAMOND_RITE_DAGGER, "rite_dagger", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_CRESCENT_DAGGER, TeadItems.DIAMOND_CRESCENT_DAGGER, "crescent_dagger", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_TRUTHSEEKER, TeadItems.DIAMOND_TRUTHSEEKER, "truthseeker", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_TEMPEST_KNIFE, TeadItems.DIAMOND_TEMPEST_KNIFE, "tempest_knife", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_CUTLASS, TeadItems.DIAMOND_CUTLASS, "cutlass", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_RAPIER, TeadItems.DIAMOND_RAPIER, "rapier", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_KATANA, TeadItems.DIAMOND_KATANA, "katana", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_HIGHLAND_AXE, TeadItems.DIAMOND_HIGHLAND_AXE, "highland_axe", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_DOUBLE_AXE, TeadItems.DIAMOND_DOUBLE_AXE, "double_axe", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_DOUBLE_HIGHLAND_AXE, TeadItems.DIAMOND_DOUBLE_HIGHLAND_AXE, "double_highland_axe", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_SICKLE, TeadItems.DIAMOND_SICKLE, "sickle", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_SCYTHE, TeadItems.DIAMOND_SCYTHE, "scythe", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_GREATSWORD, TeadItems.DIAMOND_GREATSWORD, "greatsword", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_LONGSWORD, TeadItems.DIAMOND_LONGSWORD, "longsword", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_BROADSWORD, TeadItems.DIAMOND_BROADSWORD, "broadsword", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_CLAYMORE, TeadItems.DIAMOND_CLAYMORE, "claymore", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_SPEAR, TeadItems.DIAMOND_SPEAR, "spear", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_RANSEUR, TeadItems.DIAMOND_RANSEUR, "ranseur", exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_GLAIVE, TeadItems.DIAMOND_GLAIVE, "glaive", exporter);

        // Misc Armor
        offerGarmentChestplateRecipe(TeadItems.GARMENT_CHESTPLATE, TeadTags.Items.METAL_INGOTS, exporter);
        offerGarmentBootsRecipe(TeadItems.GARMENT_BOOTS, TeadTags.Items.METAL_NUGGETS, exporter);

        // Gold Armor
        offerChainmailHelmetRecipe(TeadItems.GOLD_CHAINMAIL_HELMET, TeadBlocks.GOLD_CHAIN, exporter);
        offerChainmailChestplateRecipe(TeadItems.GOLD_CHAINMAIL_CHESTPLATE, TeadBlocks.GOLD_CHAIN, exporter);
        offerChainmailLeggingsRecipe(TeadItems.GOLD_CHAINMAIL_LEGGINGS, TeadBlocks.GOLD_CHAIN, exporter);
        offerChainmailBootsRecipe(TeadItems.GOLD_CHAINMAIL_BOOTS, TeadBlocks.GOLD_CHAIN, exporter);
        offerGuardHelmetRecipe(TeadItems.GOLD_GUARD_HELMET, Items.GOLD_INGOT, exporter);
        offerGuardChestplateRecipe(TeadItems.GOLD_GUARD_CHESTPLATE, Items.GOLD_INGOT, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerWoolenHelmetRecipe(TeadItems.GOLD_WOOLEN_HELMET, Items.GOLD_NUGGET, exporter);
        offerWoolenChestplateRecipe(TeadItems.GOLD_WOOLEN_CHESTPLATE, Items.GOLD_NUGGET, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerWoolenLeggingsRecipe(TeadItems.GOLD_WOOLEN_LEGGINGS, Items.GOLD_NUGGET, exporter);
        offerWoolenBootsRecipe(TeadItems.GOLD_WOOLEN_BOOTS, Items.GOLD_NUGGET, exporter);
        offerThiefHelmetRecipe(TeadItems.GOLD_THIEF_HELMET, Items.GOLD_INGOT, exporter);
        offerThiefChestplateRecipe(TeadItems.GOLD_THIEF_CHESTPLATE, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerReinforcedMailHelmetRecipe(TeadItems.GOLD_REINFORCED_MAIL_HELMET, Items.GOLD_INGOT, TeadBlocks.GOLD_CHAIN, exporter);
        offerReinforcedMailChestplateRecipe(TeadItems.GOLD_REINFORCED_MAIL_CHESTPLATE, Items.GOLD_INGOT, TeadBlocks.GOLD_CHAIN, exporter);
        offerStalwartRecipe(TeadItems.GOLD_STALWART_HELMET, Items.GOLDEN_HELMET, Items.GOLD_INGOT, exporter);
        offerStalwartRecipe(TeadItems.GOLD_STALWART_CHESTPLATE, Items.GOLDEN_CHESTPLATE, Items.GOLD_INGOT, exporter);
        offerSpangenhelmRecipe(TeadItems.GOLD_SPANGENHELM_HELMET, Items.GOLDEN_HELMET, Items.GOLD_INGOT, exporter);
        offerHighlandRecipe(TeadItems.GOLD_HIGHLAND_HELMET, Items.GOLDEN_HELMET, Items.GOLD_INGOT, exporter);
        offerHighlandRecipe(TeadItems.GOLD_HIGHLAND_CHESTPLATE, Items.GOLDEN_CHESTPLATE, Items.GOLD_INGOT, exporter);
        offerRoyalHelmetRecipe(TeadItems.GOLD_ROYAL_HELMET, Items.GOLD_INGOT, Items.GOLD_NUGGET, exporter);
        offerMercenaryRecipe(TeadItems.GOLD_MERCENARY_HELMET, Items.GOLDEN_HELMET, Items.GOLD_INGOT, exporter);
        offerPlateHelmetRecipe(TeadItems.GOLD_PLATE_HELMET, Items.GOLD_INGOT, Items.GOLD_NUGGET, exporter);
        offerPlateChestplateRecipe(TeadItems.GOLD_PLATE_CHESTPLATE, Items.GOLD_INGOT, exporter);
        offerPlateBootsRecipe(TeadItems.GOLD_PLATE_BOOTS, Items.GOLD_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.GOLD_GHOSTLY_HELMET, Items.GOLDEN_HELMET, Items.GOLD_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.GOLD_GHOSTLY_CHESTPLATE, Items.GOLDEN_CHESTPLATE, Items.GOLD_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.GOLD_GHOSTLY_BOOTS, Items.GOLDEN_BOOTS, Items.GOLD_INGOT, exporter);

        // Lead Armor
        offerHelmetRecipe(TeadItems.LEAD_HELMET, TeadItems.LEAD_INGOT, exporter);
        offerChestplateRecipe(TeadItems.LEAD_CHESTPLATE, TeadItems.LEAD_INGOT, exporter);
        offerLeggingsRecipe(TeadItems.LEAD_LEGGINGS, TeadItems.LEAD_INGOT, exporter);
        offerBootsRecipe(TeadItems.LEAD_BOOTS, TeadItems.LEAD_INGOT, exporter);
        offerChainmailHelmetRecipe(TeadItems.LEAD_CHAINMAIL_HELMET, TeadBlocks.LEAD_CHAIN, exporter);
        offerChainmailChestplateRecipe(TeadItems.LEAD_CHAINMAIL_CHESTPLATE, TeadBlocks.LEAD_CHAIN, exporter);
        offerChainmailLeggingsRecipe(TeadItems.LEAD_CHAINMAIL_LEGGINGS, TeadBlocks.LEAD_CHAIN, exporter);
        offerChainmailBootsRecipe(TeadItems.LEAD_CHAINMAIL_BOOTS, TeadBlocks.LEAD_CHAIN, exporter);
        offerGuardHelmetRecipe(TeadItems.LEAD_GUARD_HELMET, TeadItems.LEAD_INGOT, exporter);
        offerGuardChestplateRecipe(TeadItems.LEAD_GUARD_CHESTPLATE, TeadItems.LEAD_INGOT, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerWoolenHelmetRecipe(TeadItems.LEAD_WOOLEN_HELMET, TeadItems.LEAD_NUGGET, exporter);
        offerWoolenChestplateRecipe(TeadItems.LEAD_WOOLEN_CHESTPLATE, TeadItems.LEAD_NUGGET, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerWoolenLeggingsRecipe(TeadItems.LEAD_WOOLEN_LEGGINGS, TeadItems.LEAD_NUGGET, exporter);
        offerWoolenBootsRecipe(TeadItems.LEAD_WOOLEN_BOOTS, TeadItems.LEAD_NUGGET, exporter);
        offerThiefHelmetRecipe(TeadItems.LEAD_THIEF_HELMET, TeadItems.LEAD_INGOT, exporter);
        offerThiefChestplateRecipe(TeadItems.LEAD_THIEF_CHESTPLATE, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerReinforcedMailHelmetRecipe(TeadItems.LEAD_REINFORCED_MAIL_HELMET, TeadItems.LEAD_INGOT, TeadBlocks.LEAD_CHAIN, exporter);
        offerReinforcedMailChestplateRecipe(TeadItems.LEAD_REINFORCED_MAIL_CHESTPLATE, TeadItems.LEAD_INGOT, TeadBlocks.LEAD_CHAIN, exporter);
        offerStalwartRecipe(TeadItems.LEAD_STALWART_HELMET, TeadItems.LEAD_HELMET, TeadItems.LEAD_INGOT, exporter);
        offerStalwartRecipe(TeadItems.LEAD_STALWART_CHESTPLATE, TeadItems.LEAD_CHESTPLATE, TeadItems.LEAD_INGOT, exporter);
        offerSpangenhelmRecipe(TeadItems.LEAD_SPANGENHELM_HELMET, TeadItems.LEAD_HELMET, TeadItems.LEAD_INGOT, exporter);
        offerHighlandRecipe(TeadItems.LEAD_HIGHLAND_HELMET, TeadItems.LEAD_HELMET, TeadItems.LEAD_INGOT, exporter);
        offerHighlandRecipe(TeadItems.LEAD_HIGHLAND_CHESTPLATE, TeadItems.LEAD_CHESTPLATE, TeadItems.LEAD_INGOT, exporter);
        offerRoyalHelmetRecipe(TeadItems.LEAD_ROYAL_HELMET, TeadItems.LEAD_INGOT, TeadItems.LEAD_NUGGET, exporter);
        offerMercenaryRecipe(TeadItems.LEAD_MERCENARY_HELMET, TeadItems.LEAD_HELMET, TeadItems.LEAD_INGOT, exporter);
        offerPlateHelmetRecipe(TeadItems.LEAD_PLATE_HELMET, TeadItems.LEAD_INGOT, TeadItems.LEAD_NUGGET, exporter);
        offerPlateChestplateRecipe(TeadItems.LEAD_PLATE_CHESTPLATE, TeadItems.LEAD_INGOT, exporter);
        offerPlateBootsRecipe(TeadItems.LEAD_PLATE_BOOTS, TeadItems.LEAD_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.LEAD_GHOSTLY_HELMET, TeadItems.LEAD_HELMET, TeadItems.LEAD_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.LEAD_GHOSTLY_CHESTPLATE, TeadItems.LEAD_CHESTPLATE, TeadItems.LEAD_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.LEAD_GHOSTLY_BOOTS, TeadItems.LEAD_BOOTS, TeadItems.LEAD_INGOT, exporter);

        // Copper Armor
        offerHelmetRecipe(TeadItems.COPPER_HELMET, Items.COPPER_INGOT, exporter);
        offerChestplateRecipe(TeadItems.COPPER_CHESTPLATE, Items.COPPER_INGOT, exporter);
        offerLeggingsRecipe(TeadItems.COPPER_LEGGINGS, Items.COPPER_INGOT, exporter);
        offerBootsRecipe(TeadItems.COPPER_BOOTS, Items.COPPER_INGOT, exporter);
        offerChainmailHelmetRecipe(TeadItems.COPPER_CHAINMAIL_HELMET, TeadBlocks.COPPER_CHAIN, exporter);
        offerChainmailChestplateRecipe(TeadItems.COPPER_CHAINMAIL_CHESTPLATE, TeadBlocks.COPPER_CHAIN, exporter);
        offerChainmailLeggingsRecipe(TeadItems.COPPER_CHAINMAIL_LEGGINGS, TeadBlocks.COPPER_CHAIN, exporter);
        offerChainmailBootsRecipe(TeadItems.COPPER_CHAINMAIL_BOOTS, TeadBlocks.COPPER_CHAIN, exporter);
        offerGuardHelmetRecipe(TeadItems.COPPER_GUARD_HELMET, Items.COPPER_INGOT, exporter);
        offerGuardChestplateRecipe(TeadItems.COPPER_GUARD_CHESTPLATE, Items.COPPER_INGOT, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerWoolenHelmetRecipe(TeadItems.COPPER_WOOLEN_HELMET, TeadItems.COPPER_NUGGET, exporter);
        offerWoolenChestplateRecipe(TeadItems.COPPER_WOOLEN_CHESTPLATE, TeadItems.COPPER_NUGGET, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerWoolenLeggingsRecipe(TeadItems.COPPER_WOOLEN_LEGGINGS, TeadItems.COPPER_NUGGET, exporter);
        offerWoolenBootsRecipe(TeadItems.COPPER_WOOLEN_BOOTS, TeadItems.COPPER_NUGGET, exporter);
        offerThiefHelmetRecipe(TeadItems.COPPER_THIEF_HELMET, Items.COPPER_INGOT, exporter);
        offerThiefChestplateRecipe(TeadItems.COPPER_THIEF_CHESTPLATE, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerReinforcedMailHelmetRecipe(TeadItems.COPPER_REINFORCED_MAIL_HELMET, Items.COPPER_INGOT, TeadBlocks.COPPER_CHAIN, exporter);
        offerReinforcedMailChestplateRecipe(TeadItems.COPPER_REINFORCED_MAIL_CHESTPLATE, Items.COPPER_INGOT, TeadBlocks.COPPER_CHAIN, exporter);
        offerStalwartRecipe(TeadItems.COPPER_STALWART_HELMET, TeadItems.COPPER_HELMET, Items.COPPER_INGOT, exporter);
        offerStalwartRecipe(TeadItems.COPPER_STALWART_CHESTPLATE, TeadItems.COPPER_CHESTPLATE, Items.COPPER_INGOT, exporter);
        offerSpangenhelmRecipe(TeadItems.COPPER_SPANGENHELM_HELMET, TeadItems.COPPER_HELMET, Items.COPPER_INGOT, exporter);
        offerHighlandRecipe(TeadItems.COPPER_HIGHLAND_HELMET, TeadItems.COPPER_HELMET, Items.COPPER_INGOT, exporter);
        offerHighlandRecipe(TeadItems.COPPER_HIGHLAND_CHESTPLATE, TeadItems.COPPER_CHESTPLATE, Items.COPPER_INGOT, exporter);
        offerRoyalHelmetRecipe(TeadItems.COPPER_ROYAL_HELMET, Items.COPPER_INGOT, TeadItems.COPPER_NUGGET, exporter);
        offerMercenaryRecipe(TeadItems.COPPER_MERCENARY_HELMET, TeadItems.COPPER_HELMET, Items.COPPER_INGOT, exporter);
        offerPlateHelmetRecipe(TeadItems.COPPER_PLATE_HELMET, Items.COPPER_INGOT, TeadItems.COPPER_NUGGET, exporter);
        offerPlateChestplateRecipe(TeadItems.COPPER_PLATE_CHESTPLATE, Items.COPPER_INGOT, exporter);
        offerPlateBootsRecipe(TeadItems.COPPER_PLATE_BOOTS, Items.COPPER_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.COPPER_GHOSTLY_HELMET, TeadItems.COPPER_HELMET, Items.COPPER_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.COPPER_GHOSTLY_CHESTPLATE, TeadItems.COPPER_CHESTPLATE, Items.COPPER_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.COPPER_GHOSTLY_BOOTS, TeadItems.COPPER_BOOTS, Items.COPPER_INGOT, exporter);

        // Rose Gold Armor
        offerHelmetRecipe(TeadItems.ROSE_GOLD_HELMET, TeadItems.ROSE_GOLD_INGOT, exporter);
        offerChestplateRecipe(TeadItems.ROSE_GOLD_CHESTPLATE, TeadItems.ROSE_GOLD_INGOT, exporter);
        offerLeggingsRecipe(TeadItems.ROSE_GOLD_LEGGINGS, TeadItems.ROSE_GOLD_INGOT, exporter);
        offerBootsRecipe(TeadItems.ROSE_GOLD_BOOTS, TeadItems.ROSE_GOLD_INGOT, exporter);
        offerChainmailHelmetRecipe(TeadItems.ROSE_GOLD_CHAINMAIL_HELMET, TeadBlocks.ROSE_GOLD_CHAIN, exporter);
        offerChainmailChestplateRecipe(TeadItems.ROSE_GOLD_CHAINMAIL_CHESTPLATE, TeadBlocks.ROSE_GOLD_CHAIN, exporter);
        offerChainmailLeggingsRecipe(TeadItems.ROSE_GOLD_CHAINMAIL_LEGGINGS, TeadBlocks.ROSE_GOLD_CHAIN, exporter);
        offerChainmailBootsRecipe(TeadItems.ROSE_GOLD_CHAINMAIL_BOOTS, TeadBlocks.ROSE_GOLD_CHAIN, exporter);
        offerGuardHelmetRecipe(TeadItems.ROSE_GOLD_GUARD_HELMET, TeadItems.ROSE_GOLD_INGOT, exporter);
        offerGuardChestplateRecipe(TeadItems.ROSE_GOLD_GUARD_CHESTPLATE, TeadItems.ROSE_GOLD_INGOT, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerWoolenHelmetRecipe(TeadItems.ROSE_GOLD_WOOLEN_HELMET, TeadItems.ROSE_GOLD_NUGGET, exporter);
        offerWoolenChestplateRecipe(TeadItems.ROSE_GOLD_WOOLEN_CHESTPLATE, TeadItems.ROSE_GOLD_NUGGET, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerWoolenLeggingsRecipe(TeadItems.ROSE_GOLD_WOOLEN_LEGGINGS, TeadItems.ROSE_GOLD_NUGGET, exporter);
        offerWoolenBootsRecipe(TeadItems.ROSE_GOLD_WOOLEN_BOOTS, TeadItems.ROSE_GOLD_NUGGET, exporter);
        offerThiefHelmetRecipe(TeadItems.ROSE_GOLD_THIEF_HELMET, TeadItems.ROSE_GOLD_INGOT, exporter);
        offerThiefChestplateRecipe(TeadItems.ROSE_GOLD_THIEF_CHESTPLATE, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerReinforcedMailHelmetRecipe(TeadItems.ROSE_GOLD_REINFORCED_MAIL_HELMET, TeadItems.ROSE_GOLD_INGOT, TeadBlocks.ROSE_GOLD_CHAIN, exporter);
        offerReinforcedMailChestplateRecipe(TeadItems.ROSE_GOLD_REINFORCED_MAIL_CHESTPLATE, TeadItems.ROSE_GOLD_INGOT, TeadBlocks.ROSE_GOLD_CHAIN, exporter);
        offerStalwartRecipe(TeadItems.ROSE_GOLD_STALWART_HELMET, TeadItems.ROSE_GOLD_HELMET, TeadItems.ROSE_GOLD_INGOT, exporter);
        offerStalwartRecipe(TeadItems.ROSE_GOLD_STALWART_CHESTPLATE, TeadItems.ROSE_GOLD_CHESTPLATE, TeadItems.ROSE_GOLD_INGOT, exporter);
        offerSpangenhelmRecipe(TeadItems.ROSE_GOLD_SPANGENHELM_HELMET, TeadItems.ROSE_GOLD_HELMET, TeadItems.ROSE_GOLD_INGOT, exporter);
        offerHighlandRecipe(TeadItems.ROSE_GOLD_HIGHLAND_HELMET, TeadItems.ROSE_GOLD_HELMET, TeadItems.ROSE_GOLD_INGOT, exporter);
        offerHighlandRecipe(TeadItems.ROSE_GOLD_HIGHLAND_CHESTPLATE, TeadItems.ROSE_GOLD_CHESTPLATE, TeadItems.ROSE_GOLD_INGOT, exporter);
        offerRoyalHelmetRecipe(TeadItems.ROSE_GOLD_ROYAL_HELMET, TeadItems.ROSE_GOLD_INGOT, TeadItems.ROSE_GOLD_NUGGET, exporter);
        offerMercenaryRecipe(TeadItems.ROSE_GOLD_MERCENARY_HELMET, TeadItems.ROSE_GOLD_HELMET, TeadItems.ROSE_GOLD_INGOT, exporter);
        offerPlateHelmetRecipe(TeadItems.ROSE_GOLD_PLATE_HELMET, TeadItems.ROSE_GOLD_INGOT, TeadItems.ROSE_GOLD_NUGGET, exporter);
        offerPlateChestplateRecipe(TeadItems.ROSE_GOLD_PLATE_CHESTPLATE, TeadItems.ROSE_GOLD_INGOT, exporter);
        offerPlateBootsRecipe(TeadItems.ROSE_GOLD_PLATE_BOOTS, TeadItems.ROSE_GOLD_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.ROSE_GOLD_GHOSTLY_HELMET, TeadItems.ROSE_GOLD_HELMET, TeadItems.ROSE_GOLD_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.ROSE_GOLD_GHOSTLY_CHESTPLATE, TeadItems.ROSE_GOLD_CHESTPLATE, TeadItems.ROSE_GOLD_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.ROSE_GOLD_GHOSTLY_BOOTS, TeadItems.ROSE_GOLD_BOOTS, TeadItems.ROSE_GOLD_INGOT, exporter);

        // White Gold Armor
        offerHelmetRecipe(TeadItems.WHITE_GOLD_HELMET, TeadItems.WHITE_GOLD_INGOT, exporter);
        offerChestplateRecipe(TeadItems.WHITE_GOLD_CHESTPLATE, TeadItems.WHITE_GOLD_INGOT, exporter);
        offerLeggingsRecipe(TeadItems.WHITE_GOLD_LEGGINGS, TeadItems.WHITE_GOLD_INGOT, exporter);
        offerBootsRecipe(TeadItems.WHITE_GOLD_BOOTS, TeadItems.WHITE_GOLD_INGOT, exporter);
        offerChainmailHelmetRecipe(TeadItems.WHITE_GOLD_CHAINMAIL_HELMET, TeadBlocks.WHITE_GOLD_CHAIN, exporter);
        offerChainmailChestplateRecipe(TeadItems.WHITE_GOLD_CHAINMAIL_CHESTPLATE, TeadBlocks.WHITE_GOLD_CHAIN, exporter);
        offerChainmailLeggingsRecipe(TeadItems.WHITE_GOLD_CHAINMAIL_LEGGINGS, TeadBlocks.WHITE_GOLD_CHAIN, exporter);
        offerChainmailBootsRecipe(TeadItems.WHITE_GOLD_CHAINMAIL_BOOTS, TeadBlocks.WHITE_GOLD_CHAIN, exporter);
        offerGuardHelmetRecipe(TeadItems.WHITE_GOLD_GUARD_HELMET, TeadItems.WHITE_GOLD_INGOT, exporter);
        offerGuardChestplateRecipe(TeadItems.WHITE_GOLD_GUARD_CHESTPLATE, TeadItems.WHITE_GOLD_INGOT, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerWoolenHelmetRecipe(TeadItems.WHITE_GOLD_WOOLEN_HELMET, TeadItems.WHITE_GOLD_NUGGET, exporter);
        offerWoolenChestplateRecipe(TeadItems.WHITE_GOLD_WOOLEN_CHESTPLATE, TeadItems.WHITE_GOLD_NUGGET, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerWoolenLeggingsRecipe(TeadItems.WHITE_GOLD_WOOLEN_LEGGINGS, TeadItems.WHITE_GOLD_NUGGET, exporter);
        offerWoolenBootsRecipe(TeadItems.WHITE_GOLD_WOOLEN_BOOTS, TeadItems.WHITE_GOLD_NUGGET, exporter);
        offerThiefHelmetRecipe(TeadItems.WHITE_GOLD_THIEF_HELMET, TeadItems.WHITE_GOLD_INGOT, exporter);
        offerThiefChestplateRecipe(TeadItems.WHITE_GOLD_THIEF_CHESTPLATE, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerReinforcedMailHelmetRecipe(TeadItems.WHITE_GOLD_REINFORCED_MAIL_HELMET, TeadItems.WHITE_GOLD_INGOT, TeadBlocks.WHITE_GOLD_CHAIN, exporter);
        offerReinforcedMailChestplateRecipe(TeadItems.WHITE_GOLD_REINFORCED_MAIL_CHESTPLATE, TeadItems.WHITE_GOLD_INGOT, TeadBlocks.WHITE_GOLD_CHAIN, exporter);
        offerStalwartRecipe(TeadItems.WHITE_GOLD_STALWART_HELMET, TeadItems.WHITE_GOLD_HELMET, TeadItems.WHITE_GOLD_INGOT, exporter);
        offerStalwartRecipe(TeadItems.WHITE_GOLD_STALWART_CHESTPLATE, TeadItems.WHITE_GOLD_CHESTPLATE, TeadItems.WHITE_GOLD_INGOT, exporter);
        offerSpangenhelmRecipe(TeadItems.WHITE_GOLD_SPANGENHELM_HELMET, TeadItems.WHITE_GOLD_HELMET, TeadItems.WHITE_GOLD_INGOT, exporter);
        offerHighlandRecipe(TeadItems.WHITE_GOLD_HIGHLAND_HELMET, TeadItems.WHITE_GOLD_HELMET, TeadItems.WHITE_GOLD_INGOT, exporter);
        offerHighlandRecipe(TeadItems.WHITE_GOLD_HIGHLAND_CHESTPLATE, TeadItems.WHITE_GOLD_CHESTPLATE, TeadItems.WHITE_GOLD_INGOT, exporter);
        offerRoyalHelmetRecipe(TeadItems.WHITE_GOLD_ROYAL_HELMET, TeadItems.WHITE_GOLD_INGOT, TeadItems.WHITE_GOLD_NUGGET, exporter);
        offerMercenaryRecipe(TeadItems.WHITE_GOLD_MERCENARY_HELMET, TeadItems.WHITE_GOLD_HELMET, TeadItems.WHITE_GOLD_INGOT, exporter);
        offerPlateHelmetRecipe(TeadItems.WHITE_GOLD_PLATE_HELMET, TeadItems.WHITE_GOLD_INGOT, TeadItems.WHITE_GOLD_NUGGET, exporter);
        offerPlateChestplateRecipe(TeadItems.WHITE_GOLD_PLATE_CHESTPLATE, TeadItems.WHITE_GOLD_INGOT, exporter);
        offerPlateBootsRecipe(TeadItems.WHITE_GOLD_PLATE_BOOTS, TeadItems.WHITE_GOLD_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.WHITE_GOLD_GHOSTLY_HELMET, TeadItems.WHITE_GOLD_HELMET, TeadItems.WHITE_GOLD_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.WHITE_GOLD_GHOSTLY_CHESTPLATE, TeadItems.WHITE_GOLD_CHESTPLATE, TeadItems.WHITE_GOLD_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.WHITE_GOLD_GHOSTLY_BOOTS, TeadItems.WHITE_GOLD_BOOTS, TeadItems.WHITE_GOLD_INGOT, exporter);

        // Iron Armor
        offerGuardHelmetRecipe(TeadItems.IRON_GUARD_HELMET, Items.IRON_INGOT, exporter);
        offerGuardChestplateRecipe(TeadItems.IRON_GUARD_CHESTPLATE, Items.IRON_INGOT, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerWoolenHelmetRecipe(TeadItems.IRON_WOOLEN_HELMET, Items.IRON_NUGGET, exporter);
        offerWoolenChestplateRecipe(TeadItems.IRON_WOOLEN_CHESTPLATE, Items.IRON_NUGGET, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerWoolenLeggingsRecipe(TeadItems.IRON_WOOLEN_LEGGINGS, Items.IRON_NUGGET, exporter);
        offerWoolenBootsRecipe(TeadItems.IRON_WOOLEN_BOOTS, Items.IRON_NUGGET, exporter);
        offerThiefHelmetRecipe(TeadItems.IRON_THIEF_HELMET, Items.IRON_INGOT, exporter);
        offerThiefChestplateRecipe(TeadItems.IRON_THIEF_CHESTPLATE, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerReinforcedMailHelmetRecipe(TeadItems.IRON_REINFORCED_MAIL_HELMET, Items.IRON_INGOT, Blocks.CHAIN, exporter);
        offerReinforcedMailChestplateRecipe(TeadItems.IRON_REINFORCED_MAIL_CHESTPLATE, Items.IRON_INGOT, Blocks.CHAIN, exporter);
        offerStalwartRecipe(TeadItems.IRON_STALWART_HELMET, Items.IRON_HELMET, Items.IRON_INGOT, exporter);
        offerStalwartRecipe(TeadItems.IRON_STALWART_CHESTPLATE, Items.IRON_CHESTPLATE, Items.IRON_INGOT, exporter);
        offerSpangenhelmRecipe(TeadItems.IRON_SPANGENHELM_HELMET, Items.IRON_HELMET, Items.IRON_INGOT, exporter);
        offerHighlandRecipe(TeadItems.IRON_HIGHLAND_HELMET, Items.IRON_HELMET, Items.IRON_INGOT, exporter);
        offerHighlandRecipe(TeadItems.IRON_HIGHLAND_CHESTPLATE, Items.IRON_CHESTPLATE, Items.IRON_INGOT, exporter);
        offerRoyalHelmetRecipe(TeadItems.IRON_ROYAL_HELMET, Items.IRON_INGOT, Items.IRON_NUGGET, exporter);
        offerMercenaryRecipe(TeadItems.IRON_MERCENARY_HELMET, Items.IRON_HELMET, Items.IRON_INGOT, exporter);
        offerPlateHelmetRecipe(TeadItems.IRON_PLATE_HELMET, Items.IRON_INGOT, Items.IRON_NUGGET, exporter);
        offerPlateChestplateRecipe(TeadItems.IRON_PLATE_CHESTPLATE, Items.IRON_INGOT, exporter);
        offerPlateBootsRecipe(TeadItems.IRON_PLATE_BOOTS, Items.IRON_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.IRON_GHOSTLY_HELMET, Items.IRON_HELMET, Items.IRON_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.IRON_GHOSTLY_CHESTPLATE, Items.IRON_CHESTPLATE, Items.IRON_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.IRON_GHOSTLY_BOOTS, Items.IRON_BOOTS, Items.IRON_INGOT, exporter);

        // Brass Armor
        offerHelmetRecipe(TeadItems.BRASS_HELMET, TeadItems.BRASS_INGOT, exporter);
        offerChestplateRecipe(TeadItems.BRASS_CHESTPLATE, TeadItems.BRASS_INGOT, exporter);
        offerLeggingsRecipe(TeadItems.BRASS_LEGGINGS, TeadItems.BRASS_INGOT, exporter);
        offerBootsRecipe(TeadItems.BRASS_BOOTS, TeadItems.BRASS_INGOT, exporter);
        offerChainmailHelmetRecipe(TeadItems.BRASS_CHAINMAIL_HELMET, TeadBlocks.BRASS_CHAIN, exporter);
        offerChainmailChestplateRecipe(TeadItems.BRASS_CHAINMAIL_CHESTPLATE, TeadBlocks.BRASS_CHAIN, exporter);
        offerChainmailLeggingsRecipe(TeadItems.BRASS_CHAINMAIL_LEGGINGS, TeadBlocks.BRASS_CHAIN, exporter);
        offerChainmailBootsRecipe(TeadItems.BRASS_CHAINMAIL_BOOTS, TeadBlocks.BRASS_CHAIN, exporter);
        offerGuardHelmetRecipe(TeadItems.BRASS_GUARD_HELMET, TeadItems.BRASS_INGOT, exporter);
        offerGuardChestplateRecipe(TeadItems.BRASS_GUARD_CHESTPLATE, TeadItems.BRASS_INGOT, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerWoolenHelmetRecipe(TeadItems.BRASS_WOOLEN_HELMET, TeadItems.BRASS_NUGGET, exporter);
        offerWoolenChestplateRecipe(TeadItems.BRASS_WOOLEN_CHESTPLATE, TeadItems.BRASS_NUGGET, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerWoolenLeggingsRecipe(TeadItems.BRASS_WOOLEN_LEGGINGS, TeadItems.BRASS_NUGGET, exporter);
        offerWoolenBootsRecipe(TeadItems.BRASS_WOOLEN_BOOTS, TeadItems.BRASS_NUGGET, exporter);
        offerThiefHelmetRecipe(TeadItems.BRASS_THIEF_HELMET, TeadItems.BRASS_INGOT, exporter);
        offerThiefChestplateRecipe(TeadItems.BRASS_THIEF_CHESTPLATE, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerReinforcedMailHelmetRecipe(TeadItems.BRASS_REINFORCED_MAIL_HELMET, TeadItems.BRASS_INGOT, TeadBlocks.BRASS_CHAIN, exporter);
        offerReinforcedMailChestplateRecipe(TeadItems.BRASS_REINFORCED_MAIL_CHESTPLATE, TeadItems.BRASS_INGOT, TeadBlocks.BRASS_CHAIN, exporter);
        offerStalwartRecipe(TeadItems.BRASS_STALWART_HELMET, TeadItems.BRASS_HELMET, TeadItems.BRASS_INGOT, exporter);
        offerStalwartRecipe(TeadItems.BRASS_STALWART_CHESTPLATE, TeadItems.BRASS_CHESTPLATE, TeadItems.BRASS_INGOT, exporter);
        offerSpangenhelmRecipe(TeadItems.BRASS_SPANGENHELM_HELMET, TeadItems.BRASS_HELMET, TeadItems.BRASS_INGOT, exporter);
        offerHighlandRecipe(TeadItems.BRASS_HIGHLAND_HELMET, TeadItems.BRASS_HELMET, TeadItems.BRASS_INGOT, exporter);
        offerHighlandRecipe(TeadItems.BRASS_HIGHLAND_CHESTPLATE, TeadItems.BRASS_CHESTPLATE, TeadItems.BRASS_INGOT, exporter);
        offerRoyalHelmetRecipe(TeadItems.BRASS_ROYAL_HELMET, TeadItems.BRASS_INGOT, TeadItems.BRASS_NUGGET, exporter);
        offerMercenaryRecipe(TeadItems.BRASS_MERCENARY_HELMET, TeadItems.BRASS_HELMET, TeadItems.BRASS_INGOT, exporter);
        offerPlateHelmetRecipe(TeadItems.BRASS_PLATE_HELMET, TeadItems.BRASS_INGOT, TeadItems.BRASS_NUGGET, exporter);
        offerPlateChestplateRecipe(TeadItems.BRASS_PLATE_CHESTPLATE, TeadItems.BRASS_INGOT, exporter);
        offerPlateBootsRecipe(TeadItems.BRASS_PLATE_BOOTS, TeadItems.BRASS_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.BRASS_GHOSTLY_HELMET, TeadItems.BRASS_HELMET, TeadItems.BRASS_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.BRASS_GHOSTLY_CHESTPLATE, TeadItems.BRASS_CHESTPLATE, TeadItems.BRASS_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.BRASS_GHOSTLY_BOOTS, TeadItems.BRASS_BOOTS, TeadItems.BRASS_INGOT, exporter);

        // Bronze Armor
        offerHelmetRecipe(TeadItems.BRONZE_HELMET, TeadItems.BRONZE_INGOT, exporter);
        offerChestplateRecipe(TeadItems.BRONZE_CHESTPLATE, TeadItems.BRONZE_INGOT, exporter);
        offerLeggingsRecipe(TeadItems.BRONZE_LEGGINGS, TeadItems.BRONZE_INGOT, exporter);
        offerBootsRecipe(TeadItems.BRONZE_BOOTS, TeadItems.BRONZE_INGOT, exporter);
        offerChainmailHelmetRecipe(TeadItems.BRONZE_CHAINMAIL_HELMET, TeadBlocks.BRONZE_CHAIN, exporter);
        offerChainmailChestplateRecipe(TeadItems.BRONZE_CHAINMAIL_CHESTPLATE, TeadBlocks.BRONZE_CHAIN, exporter);
        offerChainmailLeggingsRecipe(TeadItems.BRONZE_CHAINMAIL_LEGGINGS, TeadBlocks.BRONZE_CHAIN, exporter);
        offerChainmailBootsRecipe(TeadItems.BRONZE_CHAINMAIL_BOOTS, TeadBlocks.BRONZE_CHAIN, exporter);
        offerGuardHelmetRecipe(TeadItems.BRONZE_GUARD_HELMET, TeadItems.BRONZE_INGOT, exporter);
        offerGuardChestplateRecipe(TeadItems.BRONZE_GUARD_CHESTPLATE, TeadItems.BRONZE_INGOT, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerWoolenHelmetRecipe(TeadItems.BRONZE_WOOLEN_HELMET, TeadItems.BRONZE_NUGGET, exporter);
        offerWoolenChestplateRecipe(TeadItems.BRONZE_WOOLEN_CHESTPLATE, TeadItems.BRONZE_NUGGET, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerWoolenLeggingsRecipe(TeadItems.BRONZE_WOOLEN_LEGGINGS, TeadItems.BRONZE_NUGGET, exporter);
        offerWoolenBootsRecipe(TeadItems.BRONZE_WOOLEN_BOOTS, TeadItems.BRONZE_NUGGET, exporter);
        offerThiefHelmetRecipe(TeadItems.BRONZE_THIEF_HELMET, TeadItems.BRONZE_INGOT, exporter);
        offerThiefChestplateRecipe(TeadItems.BRONZE_THIEF_CHESTPLATE, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerReinforcedMailHelmetRecipe(TeadItems.BRONZE_REINFORCED_MAIL_HELMET, TeadItems.BRONZE_INGOT, TeadBlocks.BRONZE_CHAIN, exporter);
        offerReinforcedMailChestplateRecipe(TeadItems.BRONZE_REINFORCED_MAIL_CHESTPLATE, TeadItems.BRONZE_INGOT, TeadBlocks.BRONZE_CHAIN, exporter);
        offerStalwartRecipe(TeadItems.BRONZE_STALWART_HELMET, TeadItems.BRONZE_HELMET, TeadItems.BRONZE_INGOT, exporter);
        offerStalwartRecipe(TeadItems.BRONZE_STALWART_CHESTPLATE, TeadItems.BRONZE_CHESTPLATE, TeadItems.BRONZE_INGOT, exporter);
        offerSpangenhelmRecipe(TeadItems.BRONZE_SPANGENHELM_HELMET, TeadItems.BRONZE_HELMET, TeadItems.BRONZE_INGOT, exporter);
        offerHighlandRecipe(TeadItems.BRONZE_HIGHLAND_HELMET, TeadItems.BRONZE_HELMET, TeadItems.BRONZE_INGOT, exporter);
        offerHighlandRecipe(TeadItems.BRONZE_HIGHLAND_CHESTPLATE, TeadItems.BRONZE_CHESTPLATE, TeadItems.BRONZE_INGOT, exporter);
        offerRoyalHelmetRecipe(TeadItems.BRONZE_ROYAL_HELMET, TeadItems.BRONZE_INGOT, TeadItems.BRONZE_NUGGET, exporter);
        offerMercenaryRecipe(TeadItems.BRONZE_MERCENARY_HELMET, TeadItems.BRONZE_HELMET, TeadItems.BRONZE_INGOT, exporter);
        offerPlateHelmetRecipe(TeadItems.BRONZE_PLATE_HELMET, TeadItems.BRONZE_INGOT, TeadItems.BRONZE_NUGGET, exporter);
        offerPlateChestplateRecipe(TeadItems.BRONZE_PLATE_CHESTPLATE, TeadItems.BRONZE_INGOT, exporter);
        offerPlateBootsRecipe(TeadItems.BRONZE_PLATE_BOOTS, TeadItems.BRONZE_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.BRONZE_GHOSTLY_HELMET, TeadItems.BRONZE_HELMET, TeadItems.BRONZE_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.BRONZE_GHOSTLY_CHESTPLATE, TeadItems.BRONZE_CHESTPLATE, TeadItems.BRONZE_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.BRONZE_GHOSTLY_BOOTS, TeadItems.BRONZE_BOOTS, TeadItems.BRONZE_INGOT, exporter);

        // Steel Armor
        offerHelmetRecipe(TeadItems.STEEL_HELMET, TeadItems.STEEL_INGOT, exporter);
        offerChestplateRecipe(TeadItems.STEEL_CHESTPLATE, TeadItems.STEEL_INGOT, exporter);
        offerLeggingsRecipe(TeadItems.STEEL_LEGGINGS, TeadItems.STEEL_INGOT, exporter);
        offerBootsRecipe(TeadItems.STEEL_BOOTS, TeadItems.STEEL_INGOT, exporter);
        offerChainmailHelmetRecipe(TeadItems.STEEL_CHAINMAIL_HELMET, TeadBlocks.STEEL_CHAIN, exporter);
        offerChainmailChestplateRecipe(TeadItems.STEEL_CHAINMAIL_CHESTPLATE, TeadBlocks.STEEL_CHAIN, exporter);
        offerChainmailLeggingsRecipe(TeadItems.STEEL_CHAINMAIL_LEGGINGS, TeadBlocks.STEEL_CHAIN, exporter);
        offerChainmailBootsRecipe(TeadItems.STEEL_CHAINMAIL_BOOTS, TeadBlocks.STEEL_CHAIN, exporter);
        offerGuardHelmetRecipe(TeadItems.STEEL_GUARD_HELMET, TeadItems.STEEL_INGOT, exporter);
        offerGuardChestplateRecipe(TeadItems.STEEL_GUARD_CHESTPLATE, TeadItems.STEEL_INGOT, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerWoolenHelmetRecipe(TeadItems.STEEL_WOOLEN_HELMET, TeadItems.STEEL_NUGGET, exporter);
        offerWoolenChestplateRecipe(TeadItems.STEEL_WOOLEN_CHESTPLATE, TeadItems.STEEL_NUGGET, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerWoolenLeggingsRecipe(TeadItems.STEEL_WOOLEN_LEGGINGS, TeadItems.STEEL_NUGGET, exporter);
        offerWoolenBootsRecipe(TeadItems.STEEL_WOOLEN_BOOTS, TeadItems.STEEL_NUGGET, exporter);
        offerThiefHelmetRecipe(TeadItems.STEEL_THIEF_HELMET, TeadItems.STEEL_INGOT, exporter);
        offerThiefChestplateRecipe(TeadItems.STEEL_THIEF_CHESTPLATE, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerReinforcedMailHelmetRecipe(TeadItems.STEEL_REINFORCED_MAIL_HELMET, TeadItems.STEEL_INGOT, TeadBlocks.STEEL_CHAIN, exporter);
        offerReinforcedMailChestplateRecipe(TeadItems.STEEL_REINFORCED_MAIL_CHESTPLATE, TeadItems.STEEL_INGOT, TeadBlocks.STEEL_CHAIN, exporter);
        offerStalwartRecipe(TeadItems.STEEL_STALWART_HELMET, TeadItems.STEEL_HELMET, TeadItems.STEEL_INGOT, exporter);
        offerStalwartRecipe(TeadItems.STEEL_STALWART_CHESTPLATE, TeadItems.STEEL_CHESTPLATE, TeadItems.STEEL_INGOT, exporter);
        offerSpangenhelmRecipe(TeadItems.STEEL_SPANGENHELM_HELMET, TeadItems.STEEL_HELMET, TeadItems.STEEL_INGOT, exporter);
        offerHighlandRecipe(TeadItems.STEEL_HIGHLAND_HELMET, TeadItems.STEEL_HELMET, TeadItems.STEEL_INGOT, exporter);
        offerHighlandRecipe(TeadItems.STEEL_HIGHLAND_CHESTPLATE, TeadItems.STEEL_CHESTPLATE, TeadItems.STEEL_INGOT, exporter);
        offerRoyalHelmetRecipe(TeadItems.STEEL_ROYAL_HELMET, TeadItems.STEEL_INGOT, TeadItems.STEEL_NUGGET, exporter);
        offerMercenaryRecipe(TeadItems.STEEL_MERCENARY_HELMET, TeadItems.STEEL_HELMET, TeadItems.STEEL_INGOT, exporter);
        offerPlateHelmetRecipe(TeadItems.STEEL_PLATE_HELMET, TeadItems.STEEL_INGOT, TeadItems.STEEL_NUGGET, exporter);
        offerPlateChestplateRecipe(TeadItems.STEEL_PLATE_CHESTPLATE, TeadItems.STEEL_INGOT, exporter);
        offerPlateBootsRecipe(TeadItems.STEEL_PLATE_BOOTS, TeadItems.STEEL_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.STEEL_GHOSTLY_HELMET, TeadItems.STEEL_HELMET, TeadItems.STEEL_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.STEEL_GHOSTLY_CHESTPLATE, TeadItems.STEEL_CHESTPLATE, TeadItems.STEEL_INGOT, exporter);
        offerGhostlyRecipe(TeadItems.STEEL_GHOSTLY_BOOTS, TeadItems.STEEL_BOOTS, TeadItems.STEEL_INGOT, exporter);

        // Diamond Armor
        offerGuardHelmetRecipe(TeadItems.DIAMOND_GUARD_HELMET, Items.DIAMOND, exporter);
        offerGuardChestplateRecipe(TeadItems.DIAMOND_GUARD_CHESTPLATE, Items.DIAMOND, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerWoolenHelmetRecipe(TeadItems.DIAMOND_WOOLEN_HELMET, TeadItems.DIAMOND_CHIP, exporter);
        offerWoolenChestplateRecipe(TeadItems.DIAMOND_WOOLEN_CHESTPLATE, TeadItems.DIAMOND_CHIP, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerWoolenLeggingsRecipe(TeadItems.DIAMOND_WOOLEN_LEGGINGS, TeadItems.DIAMOND_CHIP, exporter);
        offerWoolenBootsRecipe(TeadItems.DIAMOND_WOOLEN_BOOTS, TeadItems.DIAMOND_CHIP, exporter);
        offerThiefHelmetRecipe(TeadItems.DIAMOND_THIEF_HELMET, Items.DIAMOND, exporter);
        offerThiefChestplateRecipe(TeadItems.DIAMOND_THIEF_CHESTPLATE, TeadItems.GARMENT_CHESTPLATE, exporter);
        offerReinforcedMailHelmetRecipe(TeadItems.DIAMOND_REINFORCED_MAIL_HELMET, Items.DIAMOND, Blocks.CHAIN, exporter);
        offerReinforcedMailChestplateRecipe(TeadItems.DIAMOND_REINFORCED_MAIL_CHESTPLATE, Items.DIAMOND, Blocks.CHAIN, exporter);
        offerStalwartRecipe(TeadItems.DIAMOND_STALWART_HELMET, Items.DIAMOND_HELMET, Items.DIAMOND, exporter);
        offerStalwartRecipe(TeadItems.DIAMOND_STALWART_CHESTPLATE, Items.DIAMOND_CHESTPLATE, Items.DIAMOND, exporter);
        offerSpangenhelmRecipe(TeadItems.DIAMOND_SPANGENHELM_HELMET, Items.DIAMOND_HELMET, Items.DIAMOND, exporter);
        offerHighlandRecipe(TeadItems.DIAMOND_HIGHLAND_HELMET, Items.DIAMOND_HELMET, Items.DIAMOND, exporter);
        offerHighlandRecipe(TeadItems.DIAMOND_HIGHLAND_CHESTPLATE, Items.DIAMOND_CHESTPLATE, Items.DIAMOND, exporter);
        offerRoyalHelmetRecipe(TeadItems.DIAMOND_ROYAL_HELMET, Items.DIAMOND, TeadItems.DIAMOND_CHIP, exporter);
        offerMercenaryRecipe(TeadItems.DIAMOND_MERCENARY_HELMET, Items.DIAMOND_HELMET, Items.DIAMOND, exporter);
        offerPlateHelmetRecipe(TeadItems.DIAMOND_PLATE_HELMET, Items.DIAMOND, TeadItems.DIAMOND_CHIP, exporter);
        offerPlateChestplateRecipe(TeadItems.DIAMOND_PLATE_CHESTPLATE, Items.DIAMOND, exporter);
        offerPlateBootsRecipe(TeadItems.DIAMOND_PLATE_BOOTS, Items.DIAMOND, exporter);
        offerGhostlyRecipe(TeadItems.DIAMOND_GHOSTLY_HELMET, Items.DIAMOND_HELMET, Items.DIAMOND, exporter);
        offerGhostlyRecipe(TeadItems.DIAMOND_GHOSTLY_CHESTPLATE, Items.DIAMOND_CHESTPLATE, Items.DIAMOND, exporter);
        offerGhostlyRecipe(TeadItems.DIAMOND_GHOSTLY_BOOTS, Items.DIAMOND_BOOTS, Items.DIAMOND, exporter);

        // Netherite Armor
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_GUARD_HELMET, RecipeCategory.COMBAT, TeadItems.NETHERITE_GUARD_HELMET);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_GUARD_CHESTPLATE, RecipeCategory.COMBAT, TeadItems.NETHERITE_GUARD_CHESTPLATE);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_WOOLEN_HELMET, RecipeCategory.COMBAT, TeadItems.NETHERITE_WOOLEN_HELMET);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_WOOLEN_CHESTPLATE, RecipeCategory.COMBAT, TeadItems.NETHERITE_WOOLEN_CHESTPLATE);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_WOOLEN_LEGGINGS, RecipeCategory.COMBAT, TeadItems.NETHERITE_WOOLEN_LEGGINGS);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_WOOLEN_BOOTS, RecipeCategory.COMBAT, TeadItems.NETHERITE_WOOLEN_BOOTS);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_THIEF_HELMET, RecipeCategory.COMBAT, TeadItems.NETHERITE_THIEF_HELMET);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_THIEF_CHESTPLATE, RecipeCategory.COMBAT, TeadItems.NETHERITE_THIEF_CHESTPLATE);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_REINFORCED_MAIL_HELMET, RecipeCategory.COMBAT, TeadItems.NETHERITE_REINFORCED_MAIL_HELMET);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_REINFORCED_MAIL_CHESTPLATE, RecipeCategory.COMBAT, TeadItems.NETHERITE_REINFORCED_MAIL_CHESTPLATE);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_STALWART_HELMET, RecipeCategory.COMBAT, TeadItems.NETHERITE_STALWART_HELMET);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_STALWART_CHESTPLATE, RecipeCategory.COMBAT, TeadItems.NETHERITE_STALWART_CHESTPLATE);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_SPANGENHELM_HELMET, RecipeCategory.COMBAT, TeadItems.NETHERITE_SPANGENHELM_HELMET);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_HIGHLAND_HELMET, RecipeCategory.COMBAT, TeadItems.NETHERITE_HIGHLAND_HELMET);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_HIGHLAND_CHESTPLATE, RecipeCategory.COMBAT, TeadItems.NETHERITE_HIGHLAND_CHESTPLATE);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_ROYAL_HELMET, RecipeCategory.COMBAT, TeadItems.NETHERITE_ROYAL_HELMET);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_MERCENARY_HELMET, RecipeCategory.COMBAT, TeadItems.NETHERITE_MERCENARY_HELMET);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_PLATE_HELMET, RecipeCategory.COMBAT, TeadItems.NETHERITE_PLATE_HELMET);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_PLATE_CHESTPLATE, RecipeCategory.COMBAT, TeadItems.NETHERITE_PLATE_CHESTPLATE);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_PLATE_BOOTS, RecipeCategory.COMBAT, TeadItems.NETHERITE_PLATE_BOOTS);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_GHOSTLY_HELMET, RecipeCategory.COMBAT, TeadItems.NETHERITE_GHOSTLY_HELMET);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_GHOSTLY_CHESTPLATE, RecipeCategory.COMBAT, TeadItems.NETHERITE_GHOSTLY_CHESTPLATE);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_GHOSTLY_BOOTS, RecipeCategory.COMBAT, TeadItems.NETHERITE_GHOSTLY_BOOTS);

        // Rose Netherite Armor
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_HELMET, Items.DIAMOND_HELMET, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_CHESTPLATE, Items.DIAMOND_CHESTPLATE, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_LEGGINGS, Items.DIAMOND_LEGGINGS, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_BOOTS, Items.DIAMOND_BOOTS, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_GUARD_HELMET, TeadItems.DIAMOND_GUARD_HELMET, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_GUARD_CHESTPLATE, TeadItems.DIAMOND_GUARD_CHESTPLATE, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_WOOLEN_HELMET, TeadItems.DIAMOND_WOOLEN_HELMET, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_WOOLEN_CHESTPLATE, TeadItems.DIAMOND_WOOLEN_CHESTPLATE, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_WOOLEN_LEGGINGS, TeadItems.DIAMOND_WOOLEN_LEGGINGS, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_WOOLEN_BOOTS, TeadItems.DIAMOND_WOOLEN_BOOTS, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_THIEF_HELMET, TeadItems.DIAMOND_THIEF_HELMET, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_THIEF_CHESTPLATE, TeadItems.DIAMOND_THIEF_CHESTPLATE, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_REINFORCED_MAIL_HELMET, TeadItems.DIAMOND_REINFORCED_MAIL_HELMET, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_REINFORCED_MAIL_CHESTPLATE, TeadItems.DIAMOND_REINFORCED_MAIL_CHESTPLATE, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_STALWART_HELMET, TeadItems.DIAMOND_STALWART_HELMET, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_STALWART_CHESTPLATE, TeadItems.DIAMOND_STALWART_CHESTPLATE, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_SPANGENHELM_HELMET, TeadItems.DIAMOND_SPANGENHELM_HELMET, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_HIGHLAND_HELMET, TeadItems.DIAMOND_HIGHLAND_HELMET, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_HIGHLAND_CHESTPLATE, TeadItems.DIAMOND_HIGHLAND_CHESTPLATE, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_ROYAL_HELMET, TeadItems.DIAMOND_ROYAL_HELMET, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_MERCENARY_HELMET, TeadItems.DIAMOND_MERCENARY_HELMET, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_PLATE_HELMET, TeadItems.DIAMOND_PLATE_HELMET, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_PLATE_CHESTPLATE, TeadItems.DIAMOND_PLATE_CHESTPLATE, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_PLATE_BOOTS, TeadItems.DIAMOND_PLATE_BOOTS, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_GHOSTLY_HELMET, TeadItems.DIAMOND_GHOSTLY_HELMET, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_GHOSTLY_CHESTPLATE, TeadItems.DIAMOND_GHOSTLY_CHESTPLATE, exporter);
        offerRoseNetheriteUpgrade(TeadItems.ROSE_NETHERITE_GHOSTLY_BOOTS, TeadItems.DIAMOND_GHOSTLY_BOOTS, exporter);

        // White Netherite Armor
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_HELMET, Items.DIAMOND_HELMET, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_CHESTPLATE, Items.DIAMOND_CHESTPLATE, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_LEGGINGS, Items.DIAMOND_LEGGINGS, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_BOOTS, Items.DIAMOND_BOOTS, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_GUARD_HELMET, TeadItems.DIAMOND_GUARD_HELMET, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_GUARD_CHESTPLATE, TeadItems.DIAMOND_GUARD_CHESTPLATE, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_WOOLEN_HELMET, TeadItems.DIAMOND_WOOLEN_HELMET, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_WOOLEN_CHESTPLATE, TeadItems.DIAMOND_WOOLEN_CHESTPLATE, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_WOOLEN_LEGGINGS, TeadItems.DIAMOND_WOOLEN_LEGGINGS, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_WOOLEN_BOOTS, TeadItems.DIAMOND_WOOLEN_BOOTS, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_THIEF_HELMET, TeadItems.DIAMOND_THIEF_HELMET, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_THIEF_CHESTPLATE, TeadItems.DIAMOND_THIEF_CHESTPLATE, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_REINFORCED_MAIL_HELMET, TeadItems.DIAMOND_REINFORCED_MAIL_HELMET, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_REINFORCED_MAIL_CHESTPLATE, TeadItems.DIAMOND_REINFORCED_MAIL_CHESTPLATE, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_STALWART_HELMET, TeadItems.DIAMOND_STALWART_HELMET, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_STALWART_CHESTPLATE, TeadItems.DIAMOND_STALWART_CHESTPLATE, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_SPANGENHELM_HELMET, TeadItems.DIAMOND_SPANGENHELM_HELMET, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_HIGHLAND_HELMET, TeadItems.DIAMOND_HIGHLAND_HELMET, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_HIGHLAND_CHESTPLATE, TeadItems.DIAMOND_HIGHLAND_CHESTPLATE, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_ROYAL_HELMET, TeadItems.DIAMOND_ROYAL_HELMET, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_MERCENARY_HELMET, TeadItems.DIAMOND_MERCENARY_HELMET, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_PLATE_HELMET, TeadItems.DIAMOND_PLATE_HELMET, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_PLATE_CHESTPLATE, TeadItems.DIAMOND_PLATE_CHESTPLATE, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_PLATE_BOOTS, TeadItems.DIAMOND_PLATE_BOOTS, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_GHOSTLY_HELMET, TeadItems.DIAMOND_GHOSTLY_HELMET, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_GHOSTLY_CHESTPLATE, TeadItems.DIAMOND_GHOSTLY_CHESTPLATE, exporter);
        offerWhiteNetheriteUpgrade(TeadItems.WHITE_NETHERITE_GHOSTLY_BOOTS, TeadItems.DIAMOND_GHOSTLY_BOOTS, exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.RUBY_POWER_BOW, 1)
                .pattern(" #$")
                .pattern("# $")
                .pattern(" #$")
                .input('#', TeadItems.RUBY_INGOT)
                .input('$', Items.STRING)
                .criterion(hasItem(TeadItems.RUBY_INGOT), conditionsFromItem(TeadItems.RUBY_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.SOUL_BOTTLE, 1)
                .pattern("#@#")
                .pattern("#%#")
                .pattern("###")
                .input('@', TeadItems.SOUL)
                .input('%', Items.EXPERIENCE_BOTTLE)
                .input('#', Items.SOUL_SAND)
                .criterion(hasItem(TeadItems.SOUL), conditionsFromItem(TeadItems.SOUL))
                .criterion(hasItem(Items.EXPERIENCE_BOTTLE), conditionsFromItem(Items.EXPERIENCE_BOTTLE))
                .criterion(hasItem(Items.SOUL_SAND), conditionsFromItem(Items.SOUL_SAND))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.EXCALIBUR_TOTEM, 1)
                .pattern("@#@")
                .pattern("#%#")
                .pattern(" # ")
                .input('@', Items.ENDER_PEARL)
                .input('%', TeadItems.SOUL_BOTTLE)
                .input('#', TeadItems.STEEL_INGOT)
                .criterion(hasItem(TeadItems.SOUL_BOTTLE), conditionsFromItem(TeadItems.SOUL_BOTTLE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.TOTEM_OF_UNDYING, 1)
                .pattern("@#@")
                .pattern("#%#")
                .pattern(" # ")
                .input('@', Items.EMERALD)
                .input('%', TeadItems.SOUL_BOTTLE)
                .input('#', Items.GOLD_INGOT)
                .criterion(hasItem(TeadItems.SOUL_BOTTLE), conditionsFromItem(TeadItems.SOUL_BOTTLE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.OBSIDIAN_INGOT, 1)
                .pattern("###")
                .pattern("#%#")
                .pattern("###")
                .input('%', TeadItems.STEEL_INGOT)
                .input('#', TeadItems.OBSIDIAN_SHARD)
                .criterion(hasItem(TeadItems.OBSIDIAN_INGOT), conditionsFromItem(TeadItems.OBSIDIAN_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.OBSIDIAN_BLADE, 1)
                .pattern(" $#")
                .pattern("##$")
                .pattern("%# ")
                .input('%', TeadItems.HANDLE)
                .input('#', TeadItems.OBSIDIAN_INGOT)
                .input('$', TeadItems.OBSIDIAN_SHARD)
                .criterion(hasItem(TeadItems.OBSIDIAN_INGOT), conditionsFromItem(TeadItems.OBSIDIAN_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.STARLESS_NIGHT, 1)
                .pattern(" ##")
                .pattern("#%#")
                .pattern(" # ")
                .input('%', TeadItems.OBSIDIAN_BLADE)
                .input('#', Items.ENDER_PEARL)
                .criterion(hasItem(TeadItems.OBSIDIAN_INGOT), conditionsFromItem(TeadItems.OBSIDIAN_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.BATTLE_STAFF, 1)
                .pattern("  #")
                .pattern(" % ")
                .pattern("#  ")
                .input('%', TeadItems.HANDLE)
                .input('#', Items.STICK)
                .criterion(hasItem(TeadItems.HANDLE), conditionsFromItem(TeadItems.HANDLE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.QUARTERSTAFF, 1)
                .pattern("  #")
                .pattern(" # ")
                .pattern("#  ")
                .input('#', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.BONE_CLUB, 1)
                .pattern("  %")
                .pattern(" % ")
                .pattern("#  ")
                .input('#', Items.STICK)
                .input('%', Items.BONE_BLOCK)
                .criterion(hasItem(Items.BONE), conditionsFromItem(Items.BONE))
                .criterion(hasItem(Items.BONE_BLOCK), conditionsFromItem(Items.BONE_BLOCK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.BONE_BOW, 1)
                .pattern(" #%")
                .pattern("# %")
                .pattern(" #%")
                .input('#', Items.BONE)
                .input('%', Items.STRING)
                .criterion(hasItem(Items.BONE), conditionsFromItem(Items.BONE))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.SHORT_BOW, 1)
                .pattern(" #%")
                .pattern("#% ")
                .input('#', Items.STICK)
                .input('%', Items.STRING)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LONG_BOW, 1)
                .pattern(" ##")
                .pattern("# %")
                .pattern("#%%")
                .input('#', Items.STICK)
                .input('%', Items.STRING)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.CROSSBOW, 1)
                .pattern("!$!")
                .pattern("%#%")
                .pattern(" ! ")
                .input('#', Items.TRIPWIRE_HOOK)
                .input('%', Items.STRING)
                .input('!', Items.STICK)
                .input('$', TeadTags.Items.REFINED_METAL_INGOTS)
                .criterion(hasItem(Items.TRIPWIRE_HOOK), conditionsFromItem(Items.TRIPWIRE_HOOK))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .criterion("has_" + TeadTags.Items.REFINED_METAL_INGOTS.id().getPath(), conditionsFromTag(TeadTags.Items.REFINED_METAL_INGOTS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.ITEM_FRAME, 1)
                .pattern("%%%")
                .pattern("%#%")
                .pattern("%%%")
                .input('#', TeadItems.FABRIC)
                .input('%', Items.STICK)
                .criterion(hasItem(TeadItems.FABRIC), conditionsFromItem(TeadItems.FABRIC))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GRENADE, 1)
                .pattern("$& ")
                .pattern("#%#")
                .pattern(" # ")
                .input('#', TeadTags.Items.METAL_INGOTS)
                .input('%', Items.TNT)
                .input('&', Items.REDSTONE)
                .input('$', Items.FLINT_AND_STEEL)
                .criterion(hasItem(Items.FLINT_AND_STEEL), conditionsFromItem(Items.FLINT_AND_STEEL))
                .criterion(hasItem(Items.TNT), conditionsFromItem(Items.TNT))
                .group("grenade")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "grenade"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.SHURIKEN, 6)
                .pattern(" # ")
                .pattern("# #")
                .pattern(" # ")
                .input('#', TeadTags.Items.METAL_INGOTS)
                .criterion("has_" + TeadTags.Items.METAL_INGOTS.id().getPath(), conditionsFromTag(TeadTags.Items.METAL_INGOTS))
                .group("shuriken")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "shuriken"));

        // Chains
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadBlocks.GOLD_CHAIN, 1)
                .pattern("%")
                .pattern("#")
                .pattern("%")
                .input('#', Items.GOLD_INGOT)
                .input('%', Items.GOLD_NUGGET)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadBlocks.LEAD_CHAIN, 1)
                .pattern("%")
                .pattern("#")
                .pattern("%")
                .input('#', TeadItems.LEAD_INGOT)
                .input('%', TeadItems.LEAD_NUGGET)
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .criterion(hasItem(TeadItems.LEAD_NUGGET), conditionsFromItem(TeadItems.LEAD_NUGGET))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadBlocks.COPPER_CHAIN, 1)
                .pattern("%")
                .pattern("#")
                .pattern("%")
                .input('#', Items.COPPER_INGOT)
                .input('%', TeadItems.COPPER_NUGGET)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(TeadItems.COPPER_NUGGET), conditionsFromItem(TeadItems.COPPER_NUGGET))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadBlocks.ROSE_GOLD_CHAIN, 1)
                .pattern("%")
                .pattern("#")
                .pattern("%")
                .input('#', TeadItems.ROSE_GOLD_INGOT)
                .input('%', TeadItems.ROSE_GOLD_NUGGET)
                .criterion(hasItem(TeadItems.ROSE_GOLD_INGOT), conditionsFromItem(TeadItems.ROSE_GOLD_INGOT))
                .criterion(hasItem(TeadItems.ROSE_GOLD_NUGGET), conditionsFromItem(TeadItems.ROSE_GOLD_NUGGET))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadBlocks.WHITE_GOLD_CHAIN, 1)
                .pattern("%")
                .pattern("#")
                .pattern("%")
                .input('#', TeadItems.WHITE_GOLD_INGOT)
                .input('%', TeadItems.WHITE_GOLD_NUGGET)
                .criterion(hasItem(TeadItems.WHITE_GOLD_INGOT), conditionsFromItem(TeadItems.WHITE_GOLD_INGOT))
                .criterion(hasItem(TeadItems.WHITE_GOLD_NUGGET), conditionsFromItem(TeadItems.WHITE_GOLD_NUGGET))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadBlocks.BRASS_CHAIN, 1)
                .pattern("%")
                .pattern("#")
                .pattern("%")
                .input('#', TeadItems.BRASS_INGOT)
                .input('%', TeadItems.BRASS_NUGGET)
                .criterion(hasItem(TeadItems.BRASS_INGOT), conditionsFromItem(TeadItems.BRASS_INGOT))
                .criterion(hasItem(TeadItems.BRASS_NUGGET), conditionsFromItem(TeadItems.BRASS_NUGGET))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadBlocks.BRONZE_CHAIN, 1)
                .pattern("%")
                .pattern("#")
                .pattern("%")
                .input('#', TeadItems.BRONZE_INGOT)
                .input('%', TeadItems.BRONZE_NUGGET)
                .criterion(hasItem(TeadItems.BRONZE_INGOT), conditionsFromItem(TeadItems.BRONZE_INGOT))
                .criterion(hasItem(TeadItems.BRONZE_NUGGET), conditionsFromItem(TeadItems.BRONZE_NUGGET))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadBlocks.STEEL_CHAIN, 1)
                .pattern("%")
                .pattern("#")
                .pattern("%")
                .input('#', TeadItems.STEEL_INGOT)
                .input('%', TeadItems.STEEL_NUGGET)
                .criterion(hasItem(TeadItems.STEEL_INGOT), conditionsFromItem(TeadItems.STEEL_INGOT))
                .criterion(hasItem(TeadItems.STEEL_NUGGET), conditionsFromItem(TeadItems.STEEL_NUGGET))
                .offerTo(exporter);

        // Misc Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.CHAINMAIL_BOOTS, 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', Items.CHAIN)
                .criterion(hasItem(Items.CHAIN), conditionsFromItem(Items.CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.CHAINMAIL_HELMET, 1)
                .pattern("###")
                .pattern("# #")
                .input('#', Items.CHAIN)
                .criterion(hasItem(Items.CHAIN), conditionsFromItem(Items.CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.CHAINMAIL_LEGGINGS, 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', Items.CHAIN)
                .criterion(hasItem(Items.CHAIN), conditionsFromItem(Items.CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.CHAINMAIL_CHESTPLATE, 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', Items.CHAIN)
                .criterion(hasItem(Items.CHAIN), conditionsFromItem(Items.CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.ROBE_HELMET, 1)
                .pattern("%#%")
                .pattern("# #")
                .input('#', Items.LEATHER)
                .input('%', TeadItems.FABRIC)
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .criterion(hasItem(TeadItems.FABRIC), conditionsFromItem(TeadItems.FABRIC))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.ROBE_CHESTPLATE, 1)
                .pattern("# #")
                .pattern("%#%")
                .pattern("%#%")
                .input('#', Items.LEATHER)
                .input('%', TeadItems.FABRIC)
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .criterion(hasItem(TeadItems.FABRIC), conditionsFromItem(TeadItems.FABRIC))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.ROBE_BOOTS, 1)
                .pattern("% %")
                .pattern("# #")
                .input('#', Items.LEATHER)
                .input('%', TeadItems.FABRIC)
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .criterion(hasItem(TeadItems.FABRIC), conditionsFromItem(TeadItems.FABRIC))
                .offerTo(exporter);

        // Blocks
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, TeadBlocks.DARK_BRICKS, 1)
                .pattern("##")
                .pattern("##")
                .input('#', TeadItems.DARK_BRICK)
                .criterion(hasItem(TeadItems.DARK_BRICK), conditionsFromItem(TeadItems.DARK_BRICK))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, TeadItems.DARK_BRICK, 4)
                .input(TeadBlocks.DARK_BRICKS)
                .criterion(hasItem(TeadBlocks.DARK_BRICKS), conditionsFromItem(TeadBlocks.DARK_BRICKS))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, TeadBlocks.CLAYISH_MUD, 2)
                .input(Blocks.MUD)
                .input(Blocks.CLAY)
                .criterion(hasItem(Blocks.MUD), conditionsFromItem(Blocks.MUD))
                .criterion(hasItem(Blocks.CLAY), conditionsFromItem(Blocks.CLAY))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, TeadItems.MUDDY_CLAY_BALL, 4)
                .input(Blocks.MUD)
                .input(Items.CLAY_BALL)
                .input(Items.CLAY_BALL)
                .input(Items.CLAY_BALL)
                .input(Items.CLAY_BALL)
                .criterion(hasItem(Blocks.MUD), conditionsFromItem(Blocks.MUD))
                .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, TeadBlocks.EMPTY_BOOKSHELF, 1)
                .pattern("###")
                .pattern("%%%")
                .pattern("###")
                .input('#', ItemTags.PLANKS)
                .input('%', ItemTags.WOODEN_SLABS)
                .criterion(hasItem(Items.ACACIA_SLAB), conditionsFromItem(Items.ACACIA_SLAB))
                .criterion(hasItem(Items.BAMBOO_SLAB), conditionsFromItem(Items.BAMBOO_SLAB))
                .criterion(hasItem(Items.BIRCH_SLAB), conditionsFromItem(Items.BIRCH_SLAB))
                .criterion(hasItem(Items.CHERRY_SLAB), conditionsFromItem(Items.CHERRY_SLAB))
                .criterion(hasItem(Items.CRIMSON_SLAB), conditionsFromItem(Items.CRIMSON_SLAB))
                .criterion(hasItem(Items.JUNGLE_SLAB), conditionsFromItem(Items.JUNGLE_SLAB))
                .criterion(hasItem(Items.DARK_OAK_SLAB), conditionsFromItem(Items.DARK_OAK_SLAB))
                .criterion(hasItem(Items.MANGROVE_SLAB), conditionsFromItem(Items.MANGROVE_SLAB))
                .criterion(hasItem(Items.OAK_SLAB), conditionsFromItem(Items.OAK_SLAB))
                .criterion(hasItem(Items.SPRUCE_SLAB), conditionsFromItem(Items.SPRUCE_SLAB))
                .criterion(hasItem(Items.WARPED_SLAB), conditionsFromItem(Items.WARPED_SLAB))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, TeadBlocks.OLD_BOOKSHELF, 1)
                .pattern("###")
                .pattern("%$%")
                .pattern("###")
                .input('#', ItemTags.PLANKS)
                .input('%', Items.BOOK)
                .input('$', Items.COBWEB)
                .criterion(hasItem(Items.BOOK), conditionsFromItem(Items.BOOK))
                .criterion(hasItem(Items.COBWEB), conditionsFromItem(Items.COBWEB))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, TeadBlocks.SLUDGE, 2)
                .input(Blocks.MUD)
                .input(Blocks.COBBLESTONE)
                .criterion(hasItem(Blocks.MUD), conditionsFromItem(Blocks.MUD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.ROOTED_DIRT, 2)
                .pattern("%#")
                .pattern("#%")
                .input('#', Items.DIRT)
                .input('%', Items.HANGING_ROOTS)
                .criterion(hasItem(Items.HANGING_ROOTS), conditionsFromItem(Items.HANGING_ROOTS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.COBBLESTONE, 1)
                .pattern("##")
                .pattern("##")
                .input('#', TeadItems.ROCK)
                .criterion(hasItem(TeadItems.ROCK), conditionsFromItem(TeadItems.ROCK))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, TeadItems.ROCK, 4)
                .input(Items.COBBLESTONE)
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.COBBLED_DEEPSLATE, 1)
                .pattern("##")
                .pattern("##")
                .input('#', TeadItems.SLATE)
                .criterion(hasItem(TeadItems.SLATE), conditionsFromItem(TeadItems.SLATE))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, TeadItems.SLATE, 4)
                .input(Items.COBBLED_DEEPSLATE)
                .criterion(hasItem(Items.COBBLED_DEEPSLATE), conditionsFromItem(Items.COBBLED_DEEPSLATE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.BLACKSTONE, 1)
                .pattern("##")
                .pattern("##")
                .input('#', TeadItems.BLACK_ROCK)
                .criterion(hasItem(TeadItems.BLACK_ROCK), conditionsFromItem(TeadItems.BLACK_ROCK))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, TeadItems.BLACK_ROCK, 4)
                .input(Items.BLACKSTONE)
                .criterion(hasItem(Items.BLACKSTONE), conditionsFromItem(Items.BLACKSTONE))
                .offerTo(exporter);
    }

    private void offerEquipmentRecipeTaggable(ShapedRecipeJsonBuilder builder, Object ingot, String itemName,
                                              Consumer<RecipeJsonProvider> exporter, @Nullable String namespace) {
        if (namespace == null) {
            namespace = Tead.MOD_ID;
        }

        if (ingot instanceof Item item) {
            builder.input('#', item)
                    .criterion(hasItem(item), conditionsFromItem(item))
                    .offerTo(exporter, new Identifier(namespace, itemName));
        } else if (ingot instanceof TagKey<?>) {
            @SuppressWarnings("unchecked")
            TagKey<Item> tagKey = (TagKey<Item>) ingot;
            builder.input('#', tagKey)
                    .criterion("has_" + tagKey.id().getPath(), conditionsFromTag(tagKey))
                    .offerTo(exporter, new Identifier(namespace, itemName));
        } else {
            throw new IllegalArgumentException("Ingot must be an Item or TagKey<Item>");
        }
    }

    private void offerSmithingGuideRecipe(Item outputItem, Item inputItem, Object ingot, Item smithingGuide,
                                          String equipmentName, Consumer<RecipeJsonProvider> exporter) {
        Ingredient ingotIngredient;
        if (ingot instanceof Item) {
            ingotIngredient = Ingredient.ofItems((Item) ingot);
        } else if (ingot instanceof TagKey<?>) {
            ingotIngredient = Ingredient.fromTag((TagKey<Item>) ingot);
        } else {
            throw new IllegalArgumentException("Ingot must be an Item or TagKey<Item>");
        }

        SmithingTransformRecipeJsonBuilder
                .create(Ingredient.ofItems(smithingGuide), Ingredient.ofItems(inputItem), ingotIngredient,
                        RecipeCategory.TOOLS, outputItem)
                .criterion(hasItem(smithingGuide), conditionsFromItem(smithingGuide))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, equipmentName));
    }

    // Armor Generators
    private void offerHelmetRecipe(Item outputItem, Item ingot, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("###")
                .pattern("# #")
                .input('#', ingot)
                .criterion(hasItem(ingot), conditionsFromItem(ingot))
                .offerTo(exporter);
    }

    private void offerChestplateRecipe(Item outputItem, Item ingot, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', ingot)
                .criterion(hasItem(ingot), conditionsFromItem(ingot))
                .offerTo(exporter);
    }

    private void offerLeggingsRecipe(Item outputItem, Item ingot, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', ingot)
                .criterion(hasItem(ingot), conditionsFromItem(ingot))
                .offerTo(exporter);
    }

    private void offerBootsRecipe(Item outputItem, Item ingot, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', ingot)
                .criterion(hasItem(ingot), conditionsFromItem(ingot))
                .offerTo(exporter);
    }

    private void offerChainmailHelmetRecipe(Item outputItem, Block chainItem, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("###")
                .pattern("# #")
                .input('#', chainItem)
                .criterion(hasItem(chainItem), conditionsFromItem(chainItem))
                .offerTo(exporter);
    }

    private void offerChainmailChestplateRecipe(Item outputItem, Block chainItem, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', chainItem)
                .criterion(hasItem(chainItem), conditionsFromItem(chainItem))
                .offerTo(exporter);
    }

    private void offerChainmailLeggingsRecipe(Item outputItem, Block chainItem, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', chainItem)
                .criterion(hasItem(chainItem), conditionsFromItem(chainItem))
                .offerTo(exporter);
    }

    private void offerChainmailBootsRecipe(Item outputItem, Block chainItem, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', chainItem)
                .criterion(hasItem(chainItem), conditionsFromItem(chainItem))
                .offerTo(exporter);
    }

    private void offerGuardHelmetRecipe(Item outputItem, Item ingot, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("%#%")
                .pattern("# #")
                .input('#', ingot)
                .input('%', Items.LEATHER)
                .criterion(hasItem(ingot), conditionsFromItem(ingot))
                .offerTo(exporter);
    }

    private void offerGuardChestplateRecipe(Item outputItem, Item ingot, Item garmentChestplate, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("# #")
                .pattern("%#%")
                .pattern("%$%")
                .input('#', ingot)
                .input('%', Items.LEATHER)
                .input('$', garmentChestplate)
                .criterion(hasItem(ingot), conditionsFromItem(ingot))
                .criterion(hasItem(garmentChestplate), conditionsFromItem(garmentChestplate))
                .offerTo(exporter);
    }

    private void offerWoolenHelmetRecipe(Item outputItem, Item nugget, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("###")
                .pattern("#$#")
                .input('$', nugget)
                .input('#', ItemTags.WOOL)
                .criterion(hasItem(nugget), conditionsFromItem(nugget))
                .offerTo(exporter);
    }

    private void offerWoolenChestplateRecipe(Item outputItem, Item nugget, Item garmentChestplate, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("# #")
                .pattern("$#$")
                .pattern("#@#")
                .input('#', ItemTags.WOOL)
                .input('$', nugget)
                .input('@', garmentChestplate)
                .criterion(hasItem(nugget), conditionsFromItem(nugget))
                .criterion(hasItem(garmentChestplate), conditionsFromItem(garmentChestplate))
                .offerTo(exporter);
    }

    private void offerWoolenLeggingsRecipe(Item outputItem, Item nugget, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("#$#")
                .pattern("# #")
                .pattern("# #")
                .input('#', ItemTags.WOOL)
                .input('$', nugget)
                .criterion(hasItem(nugget), conditionsFromItem(nugget))
                .offerTo(exporter);
    }

    private void offerWoolenBootsRecipe(Item outputItem, Item nugget, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("# #")
                .pattern("% %")
                .input('#', nugget)
                .input('%', ItemTags.WOOL)
                .criterion(hasItem(nugget), conditionsFromItem(nugget))
                .offerTo(exporter);
    }

    private void offerThiefHelmetRecipe(Item outputItem, Item ingot, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("%^%")
                .pattern("$&$")
                .input('^', ingot)
                .input('%', TeadItems.FABRIC)
                .input('$', Items.LEATHER)
                .input('&', Items.BLACK_DYE)
                .criterion(hasItem(ingot), conditionsFromItem(ingot))
                .offerTo(exporter);
    }

    private void offerThiefChestplateRecipe(Item outputItem, Item garmentChestplate, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("%&%")
                .pattern("$%%")
                .pattern("%%$")
                .input('%', TeadItems.FABRIC)
                .input('$', garmentChestplate)
                .input('&', Items.BLACK_DYE)
                .criterion(hasItem(garmentChestplate), conditionsFromItem(garmentChestplate))
                .offerTo(exporter);
    }

    private void offerReinforcedMailHelmetRecipe(Item outputItem, Item ingot, Block chainItem, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("###")
                .pattern("% %")
                .input('#', ingot)
                .input('%', chainItem)
                .criterion(hasItem(chainItem), conditionsFromItem(chainItem))
                .offerTo(exporter);
    }

    private void offerReinforcedMailChestplateRecipe(Item outputItem, Item ingot, Block chainItem, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("# #")
                .pattern("%#%")
                .pattern("%#%")
                .input('#', ingot)
                .input('%', chainItem)
                .criterion(hasItem(chainItem), conditionsFromItem(chainItem))
                .offerTo(exporter);
    }

    private void offerRoyalHelmetRecipe(Item outputItem, Item ingot, Item nugget, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("% %")
                .pattern("###")
                .input('%', nugget)
                .input('#', ingot)
                .criterion(hasItem(ingot), conditionsFromItem(ingot))
                .criterion(hasItem(nugget), conditionsFromItem(nugget))
                .offerTo(exporter);
    }

    private void offerPlateHelmetRecipe(Item outputItem, Item ingot, Item nugget, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("#%#")
                .pattern("#$#")
                .input('$', nugget)
                .input('#', ingot)
                .input('%', Items.LEATHER)
                .criterion(hasItem(nugget), conditionsFromItem(nugget))
                .criterion(hasItem(ingot), conditionsFromItem(ingot))
                .offerTo(exporter);
    }

    private void offerPlateChestplateRecipe(Item outputItem, Item ingot, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("$$$")
                .pattern("%$%")
                .pattern("$ $")
                .input('%', Items.LEATHER)
                .input('$', ingot)
                .criterion(hasItem(ingot), conditionsFromItem(ingot))
                .offerTo(exporter);
    }

    private void offerPlateBootsRecipe(Item outputItem, Item ingot, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("% %")
                .pattern("$ $")
                .input('%', Items.LEATHER)
                .input('$', ingot)
                .criterion(hasItem(ingot), conditionsFromItem(ingot))
                .offerTo(exporter);
    }

    private void offerGarmentChestplateRecipe(Item outputItem, TagKey<Item> ingot, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("%#%")
                .input('#', Ingredient.fromTag(ingot))
                .input('%', Items.LEATHER)
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .offerTo(exporter);
    }

    private void offerGarmentBootsRecipe(Item outputItem, TagKey<Item> nugget, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                .pattern("% %")
                .pattern("# #")
                .input('#', Ingredient.fromTag(nugget))
                .input('%', Items.BAMBOO)
                .criterion(hasItem(Items.BAMBOO), conditionsFromItem(Items.BAMBOO))
                .offerTo(exporter);
    }

    private void offerArmorGuideRecipe(Item outputItem, Item inputItem, Object ingot, Item smithingGuide,
                                       Consumer<RecipeJsonProvider> exporter) {
        String fullName = outputItem.toString().toLowerCase();
        int colonIndex = fullName.indexOf(':');
        String equipmentName = colonIndex != -1 ? fullName.substring(colonIndex + 1) : fullName;

        offerSmithingGuideRecipe(outputItem, inputItem, ingot, smithingGuide, equipmentName, exporter);
    }

    private void offerStalwartRecipe(Item outputItem, Item inputItem, Object ingot,
                                   Consumer<RecipeJsonProvider> exporter) {
        offerArmorGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_STURDY, exporter);
    }

    private void offerSpangenhelmRecipe(Item outputItem, Item inputItem, Object ingot,
                                     Consumer<RecipeJsonProvider> exporter) {
        offerArmorGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_TEMPEST, exporter);
    }

    private void offerHighlandRecipe(Item outputItem, Item inputItem, Object ingot,
                                        Consumer<RecipeJsonProvider> exporter) {
        offerArmorGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_HIGHLAND, exporter);
    }

    private void offerMercenaryRecipe(Item outputItem, Item inputItem, Object ingot,
                                     Consumer<RecipeJsonProvider> exporter) {
        offerArmorGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_MERCENARY, exporter);
    }

    private void offerGhostlyRecipe(Item outputItem, Item inputItem, Object ingot,
                                      Consumer<RecipeJsonProvider> exporter) {
        offerArmorGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_SPOOKY, exporter);
    }


    // Tool And Weapon Generators
    private void offerShovelRecipe(Item outputItem, Object ingot, String materialName, Boolean needsHandle,
                                    Consumer<RecipeJsonProvider> exporter, @Nullable String namespace) {
        offerEquipmentRecipeTaggable(
                ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                        .pattern("#")
                        .pattern("!")
                        .pattern("$")
                        .input('$', (needsHandle) ? TeadItems.HANDLE : Items.STICK)
                        .input('!', Items.STICK),
                ingot, materialName + "_shovel", exporter, namespace
        );
    }

    private void offerHoeRecipe(Item outputItem, Object ingot, String materialName, Boolean needsHandle,
                                   Consumer<RecipeJsonProvider> exporter, @Nullable String namespace) {
        offerEquipmentRecipeTaggable(
                ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                        .pattern("##")
                        .pattern(" !")
                        .pattern(" $")
                        .input('$', (needsHandle) ? TeadItems.HANDLE : Items.STICK)
                        .input('!', Items.STICK),
                ingot, materialName + "_hoe", exporter, namespace
        );
    }

    private void offerPickaxeRecipe(Item outputItem, Object ingot, String materialName, Boolean needsHandle,
                                Consumer<RecipeJsonProvider> exporter, @Nullable String namespace) {
        offerEquipmentRecipeTaggable(
                ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                        .pattern("###")
                        .pattern(" $ ")
                        .pattern(" ! ")
                        .input('$', (needsHandle) ? TeadItems.HANDLE : Items.STICK)
                        .input('!', Items.STICK),
                ingot, materialName + "_pickaxe", exporter, namespace
        );
    }

    private void offerAxeRecipe(Item outputItem, Object ingot, String materialName, Boolean needsHandle,
                                    Consumer<RecipeJsonProvider> exporter, @Nullable String namespace) {
        offerEquipmentRecipeTaggable(
                ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                        .pattern("##")
                        .pattern("#$")
                        .pattern(" !")
                        .input('$', (needsHandle) ? TeadItems.HANDLE : Items.STICK)
                        .input('!', Items.STICK),
                ingot, materialName + "_axe", exporter, namespace
        );
    }

    private void offerSwordRecipe(Item outputItem, Object ingot, String materialName, Boolean needsHandle,
                                Consumer<RecipeJsonProvider> exporter, @Nullable String namespace) {
        offerEquipmentRecipeTaggable(
                ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                        .pattern("#")
                        .pattern("#")
                        .pattern("$")
                        .input('$', (needsHandle) ? TeadItems.HANDLE : Items.STICK),
                ingot, materialName + "_sword", exporter, namespace
        );
    }

    private void offerHatchetRecipe(Item outputItem, Object ingot, String materialName, Boolean needsHandle,
                                    Consumer<RecipeJsonProvider> exporter, @Nullable String namespace) {
        offerEquipmentRecipeTaggable(
                ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                        .pattern("##")
                        .pattern("#$")
                        .input('$', (needsHandle) ? TeadItems.HANDLE : Items.STICK),
                ingot, materialName + "_hatchet", exporter, namespace
        );
    }

    private void offerHammerRecipe(Item outputItem, Object ingot, String materialName, Boolean needsHandle,
                                   Consumer<RecipeJsonProvider> exporter, @Nullable String namespace) {
        offerEquipmentRecipeTaggable(
            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                    .pattern("###")
                    .pattern("#!#")
                    .pattern(" $ ")
                    .input('$', (needsHandle) ? TeadItems.HANDLE : Items.STICK)
                    .input('!', Items.STICK), ingot, materialName + "_hammer", exporter, namespace
        );
    }

    private void offerMattockRecipe(Item outputItem, Object ingot, String materialName, Boolean needsHandle,
                                    Consumer<RecipeJsonProvider> exporter, @Nullable String namespace) {
        offerEquipmentRecipeTaggable(
            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                    .pattern("###")
                    .pattern(" !#")
                    .pattern(" $ ")
                    .input('$', (needsHandle) ? TeadItems.HANDLE : Items.STICK)
                    .input('!', Items.STICK), ingot, materialName + "_mattock", exporter, namespace
        );
    }

    private void offerMaceRecipe(Item outputItem, Object ingot, String materialName, Boolean needsHandle,
                                 Consumer<RecipeJsonProvider> exporter, @Nullable String namespace) {
        offerEquipmentRecipeTaggable(
            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                    .pattern(" ##")
                    .pattern(" ##")
                    .pattern("$  ")
                    .input('$', (needsHandle) ? TeadItems.HANDLE : Items.STICK),
                ingot, materialName + "_mace", exporter, namespace
        );
    }

    private void offerDaggerRecipe(Item outputItem, Object ingot, String materialName, Boolean needsHandle,
                                   Consumer<RecipeJsonProvider> exporter, @Nullable String namespace) {
        offerEquipmentRecipeTaggable(
            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                    .pattern(" #")
                    .pattern("$ ")
                    .input('$', (needsHandle) ? TeadItems.HANDLE : Items.STICK), ingot,
                materialName + "_dagger", exporter, namespace
        );
    }

    private void offerDoubleAxeRecipe(Item outputItem, Object ingot, String materialName, Boolean needsHandle,
                                      Consumer<RecipeJsonProvider> exporter, @Nullable String namespace) {
        offerEquipmentRecipeTaggable(
            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                    .pattern("#!#")
                    .pattern("#!#")
                    .pattern(" $ ")
                    .input('$', (needsHandle) ? TeadItems.HANDLE : Items.STICK)
                    .input('!', Items.STICK), ingot, materialName + "_double_axe", exporter, namespace
        );
    }

    private void offerSickleRecipe(Item outputItem, Object ingot, String materialName, Boolean needsHandle,
                                   Consumer<RecipeJsonProvider> exporter, @Nullable String namespace) {
        offerEquipmentRecipeTaggable(
            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                    .pattern(" # ")
                    .pattern("  #")
                    .pattern("$# ")
                    .input('$', (needsHandle) ? TeadItems.HANDLE : Items.STICK),
                ingot, materialName + "_sickle", exporter, namespace
        );
    }

    private void offerScytheRecipe(Item outputItem, Object ingot, String materialName, Boolean needsHandle,
                                   Consumer<RecipeJsonProvider> exporter, @Nullable String namespace) {
        offerEquipmentRecipeTaggable(
            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                    .pattern("###")
                    .pattern(" $$")
                    .pattern("!  ")
                    .input('$', (needsHandle) ? TeadItems.HANDLE : Items.STICK)
                    .input('!', Items.STICK), ingot, materialName + "_scythe", exporter, namespace
        );
    }

    private void offerLongswordRecipe(Item outputItem, Object ingot, String materialName, Boolean needsHandle,
                                      Consumer<RecipeJsonProvider> exporter, @Nullable String namespace) {
        offerEquipmentRecipeTaggable(
            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                    .pattern(" # ")
                    .pattern(" # ")
                    .pattern("#$#")
                    .input('$', (needsHandle) ? TeadItems.HANDLE : Items.STICK),
                ingot, materialName + "_longsword", exporter, namespace
        );
    }

    private void offerClaymoreRecipe(Item outputItem, Object ingot, String materialName, Boolean needsHandle,
                                     Consumer<RecipeJsonProvider> exporter, @Nullable String namespace) {
        offerEquipmentRecipeTaggable(
            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                    .pattern("  #")
                    .pattern("## ")
                    .pattern("$# ")
                    .input('$', (needsHandle) ? TeadItems.HANDLE : Items.STICK),
                ingot, materialName + "_claymore", exporter, namespace
        );
    }

    private void offerSpearRecipe(Item outputItem, Object ingot, String materialName, Boolean needsHandle,
                                  Consumer<RecipeJsonProvider> exporter, @Nullable String namespace) {
        offerEquipmentRecipeTaggable(
            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, outputItem, 1)
                    .pattern("  #")
                    .pattern(" $ ")
                    .pattern("!  ")
                    .input('$', (needsHandle) ? TeadItems.HANDLE : Items.STICK)
                    .input('!', Items.STICK),
                ingot, materialName + "_spear", exporter, namespace
        );
    }

    private void offerMountaineerPickRecipe(Item outputItem, Item inputItem, Object ingot, String materialName,
                                            Consumer<RecipeJsonProvider> exporter) {
        offerSmithingGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_MOUNTAINEER_PICK,
                materialName + "_mountaineer_pick", exporter);
    }

    private void offerHollowDaggerRecipe(Item outputItem, Item inputItem, Object ingot, String materialName,
                                         Consumer<RecipeJsonProvider> exporter) {
        offerSmithingGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_HOLLOW_DAGGER,
                materialName + "_hollow_dagger", exporter);
    }

    private void offerRiteDaggerRecipe(Item outputItem, Item inputItem, Object ingot, String materialName,
                                         Consumer<RecipeJsonProvider> exporter) {
        offerSmithingGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_RITE_DAGGER,
                materialName + "_rite_dagger", exporter);
    }

    private void offerCrescentDaggerRecipe(Item outputItem, Item inputItem, Object ingot, String materialName,
                                           Consumer<RecipeJsonProvider> exporter) {
        offerSmithingGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_SPOOKY,
                materialName + "_crescent_dagger", exporter);
    }

    private void offerTruthseekerRecipe(Item outputItem, Item inputItem, Object ingot, String materialName,
                                        Consumer<RecipeJsonProvider> exporter) {
        offerSmithingGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_TRUTHSEEKER,
                materialName + "_truthseeker", exporter);
    }

    private void offerTempestKnifeRecipe(Item outputItem, Item inputItem, Object ingot, String materialName,
                                         Consumer<RecipeJsonProvider> exporter) {
        offerSmithingGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_TEMPEST,
                materialName + "_tempest_knife", exporter);
    }

    private void offerCutlassRecipe(Item outputItem, Item inputItem, Object ingot, String materialName,
                                    Consumer<RecipeJsonProvider> exporter) {
        offerSmithingGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_MERCENARY,
                materialName + "_cutlass", exporter);
    }

    private void offerRapierRecipe(Item outputItem, Item inputItem, Object ingot, String materialName,
                                   Consumer<RecipeJsonProvider> exporter) {
        offerSmithingGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_RAPIER,
                materialName + "_rapier", exporter);
    }

    private void offerKatanaRecipe(Item outputItem, Item inputItem, Object ingot, String materialName,
                                   Consumer<RecipeJsonProvider> exporter) {
        offerSmithingGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_KATANA,
                materialName + "_katana", exporter);
    }

    private void offerHighlandAxeRecipe(Item outputItem, Item inputItem, Object ingot, String materialName,
                                        Consumer<RecipeJsonProvider> exporter) {
        offerSmithingGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_HIGHLAND,
                materialName + "_highland_axe", exporter);
    }

    private void offerDoubleHighlandAxeRecipe(Item outputItem, Item inputItem, Object ingot, String materialName,
                                              Consumer<RecipeJsonProvider> exporter) {
        offerSmithingGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_HIGHLAND,
                materialName + "_double_highland_axe", exporter);
    }

    private void offerGreatswordRecipe(Item outputItem, Item inputItem, Object ingot, String materialName,
                                       Consumer<RecipeJsonProvider> exporter) {
        offerSmithingGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_STURDY,
                materialName + "_greatsword", exporter);
    }

    private void offerBroadswordRecipe(Item outputItem, Item inputItem, Object ingot, String materialName,
                                       Consumer<RecipeJsonProvider> exporter) {
        offerSmithingGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_STURDY,
                materialName + "_broadsword", exporter);
    }

    private void offerRanseurRecipe(Item outputItem, Item inputItem, Object ingot, String materialName,
                                    Consumer<RecipeJsonProvider> exporter) {
        offerSmithingGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_RANSEUR,
                materialName + "_ranseur", exporter);
    }

    private void offerGlaiveRecipe(Item outputItem, Item inputItem, Object ingot, String materialName,
                                   Consumer<RecipeJsonProvider> exporter) {
        offerSmithingGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_GLAIVE,
                materialName + "_glaive", exporter);
    }

    private void offerRoseNetheriteUpgrade(Item outputItem, Item inputItem, String equipmentName,
                                           Consumer<RecipeJsonProvider> exporter) {
        offerSmithingGuideRecipe(outputItem, inputItem, TeadItems.ROSE_NETHERITE_INGOT,
                Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, "rose_netherite_" + equipmentName, exporter);
    }

    private void offerWhiteNetheriteUpgrade(Item outputItem, Item inputItem, String equipmentName,
                                           Consumer<RecipeJsonProvider> exporter) {
        offerSmithingGuideRecipe(outputItem, inputItem, TeadItems.WHITE_NETHERITE_INGOT,
                Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, "white_netherite_" + equipmentName, exporter);
    }

    private void offerRoseNetheriteUpgrade(Item outputItem, Item inputItem, Consumer<RecipeJsonProvider> exporter) {
        String fullName = outputItem.toString().toLowerCase();
        int colonIndex = fullName.indexOf(':');
        String equipmentName = colonIndex != -1 ? fullName.substring(colonIndex + 1) : fullName;

        offerSmithingGuideRecipe(outputItem, inputItem, TeadItems.ROSE_NETHERITE_INGOT,
                Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, "rose_netherite_" + equipmentName, exporter);
    }

    private void offerWhiteNetheriteUpgrade(Item outputItem, Item inputItem, Consumer<RecipeJsonProvider> exporter) {
        String fullName = outputItem.toString().toLowerCase();
        int colonIndex = fullName.indexOf(':');
        String equipmentName = colonIndex != -1 ? fullName.substring(colonIndex + 1) : fullName;

        offerSmithingGuideRecipe(outputItem, inputItem, TeadItems.WHITE_NETHERITE_INGOT,
                Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, "white_netherite_" + equipmentName, exporter);
    }
}
