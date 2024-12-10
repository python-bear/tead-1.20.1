package net.pythonbear.tead.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
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
import net.pythonbear.tead.init.TeadBlocks;
import net.pythonbear.tead.init.TeadItems;
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
        offerSmelting(exporter, BLOCK_OF_COPPER_SMELTABLES, RecipeCategory.MISC, Items.COPPER_BLOCK, 6.3f,
                1800, "copper_block");
        offerBlasting(exporter, BLOCK_OF_COPPER_SMELTABLES, RecipeCategory.MISC, Items.COPPER_BLOCK, 6.3f,
                900, "copper_block");
        offerSmelting(exporter, BLOCK_OF_IRON_SMELTABLES, RecipeCategory.MISC, Items.IRON_BLOCK, 6.3f,
                1800, "iron_block");
        offerBlasting(exporter, BLOCK_OF_IRON_SMELTABLES, RecipeCategory.MISC, Items.IRON_BLOCK, 6.3f,
                900, "iron_block");
        offerSmelting(exporter, BLOCK_OF_GOLD_SMELTABLES, RecipeCategory.MISC, Items.GOLD_BLOCK, 9f,
                1800, "gold_block");
        offerBlasting(exporter, BLOCK_OF_GOLD_SMELTABLES, RecipeCategory.MISC, Items.GOLD_BLOCK, 9f,
                900, "gold_block");
        offerSmelting(exporter, BLOCK_OF_LEAD_SMELTABLES, RecipeCategory.MISC, TeadBlocks.LEAD_BLOCK, 7.2f,
                1620, "lead_block");
        offerBlasting(exporter, BLOCK_OF_LEAD_SMELTABLES, RecipeCategory.MISC, TeadBlocks.LEAD_BLOCK, 7.2f,
                720, "lead_block");
        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, TeadItems.RUBY, 2, 300,
                "ruby");
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, TeadItems.RUBY, 2, 150,
                "ruby");
        offerSmelting(exporter, LEAD_SMELTABLES, RecipeCategory.MISC, TeadItems.LEAD_INGOT, 0.8f,
                180, "lead_ingot");
        offerBlasting(exporter, LEAD_SMELTABLES, RecipeCategory.MISC, TeadItems.LEAD_INGOT, 0.8f,
                80, "lead_ingot");
        offerSmelting(exporter, DARK_BRICK_SMELTABLES, RecipeCategory.MISC, TeadItems.DARK_BRICK, 0,
                150, "dark_brick");
        offerBlasting(exporter, DARK_BRICK_SMELTABLES, RecipeCategory.MISC, TeadItems.DARK_BRICK, 0,
                80,  "dark_brick");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, TeadItems.RUBY, RecipeCategory.MISC,
                TeadBlocks.RUBY_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, TeadItems.GALENA,
                RecipeCategory.MISC, TeadBlocks.RAW_LEAD_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, TeadItems.OBSIDIAN_SHARD,
                RecipeCategory.MISC, Blocks.OBSIDIAN);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, TeadItems.LEAD_NUGGET, RecipeCategory.MISC,
                TeadItems.LEAD_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, TeadItems.STEEL_NUGGET, RecipeCategory.MISC,
                TeadItems.STEEL_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, TeadItems.ROSE_GOLD_NUGGET, RecipeCategory.MISC,
                TeadItems.ROSE_GOLD_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, TeadItems.BRONZE_NUGGET, RecipeCategory.MISC,
                TeadItems.BRONZE_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, TeadItems.COPPER_NUGGET, RecipeCategory.MISC,
                Items.COPPER_INGOT);
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
                .input(Items.WHITE_WOOL)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .group("fabric")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "fabric_2"));
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
                .input('$', Items.IRON_PICKAXE)
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LEAD_PICKAXE, 1)
                .pattern("###")
                .pattern(" $ ")
                .pattern(" % ")
                .input('%', Items.STICK)
                .input('#', TeadItems.LEAD_INGOT)
                .input('$', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LEAD_SHOVEL, 1)
                .pattern("#")
                .pattern("%")
                .pattern("%")
                .input('%', Items.STICK)
                .input('#', TeadItems.LEAD_INGOT)
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LEAD_SWORD, 1)
                .pattern("#")
                .pattern("#")
                .pattern("%")
                .input('%', TeadItems.HANDLE)
                .input('#', TeadItems.LEAD_INGOT)
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LEAD_AXE, 1)
                .pattern("##")
                .pattern("#%")
                .pattern(" $")
                .input('%', Items.STICK)
                .input('#', TeadItems.LEAD_INGOT)
                .input('$', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LEAD_HOE, 1)
                .pattern("##")
                .pattern(" %")
                .pattern(" $")
                .input('%', Items.STICK)
                .input('#', TeadItems.LEAD_INGOT)
                .input('$', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LEAD_DOUBLE_AXE, 1)
                .pattern("#%#")
                .pattern("#%#")
                .pattern(" $ ")
                .input('%', Items.STICK)
                .input('#', TeadItems.LEAD_INGOT)
                .input('$', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LEAD_HAMMER, 1)
                .pattern(" ##")
                .pattern(" ##")
                .pattern("%  ")
                .input('#', TeadItems.LEAD_INGOT)
                .input('%', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LEAD_SICKLE, 1)
                .pattern(" # ")
                .pattern("  #")
                .pattern("%# ")
                .input('#', TeadItems.LEAD_INGOT)
                .input('%', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LEAD_CLAYMORE, 1)
                .pattern("  #")
                .pattern("## ")
                .pattern("%# ")
                .input('#', TeadItems.LEAD_INGOT)
                .input('%', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.LEAD_DAGGER, 1)
                .pattern(" #")
                .pattern("% ")
                .input('#', TeadItems.LEAD_INGOT)
                .input('%', Items.STICK)
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_CHAINMAIL_BOOTS, 1)
                .pattern("# #")
                .pattern("# #")
                .input('#',TeadBlocks.GOLD_CHAIN)
                .criterion(hasItem(TeadBlocks.GOLD_CHAIN), conditionsFromItem(TeadBlocks.GOLD_CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_CHAINMAIL_HELMET, 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TeadBlocks.GOLD_CHAIN)
                .criterion(hasItem(TeadBlocks.GOLD_CHAIN), conditionsFromItem(TeadBlocks.GOLD_CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_CHAINMAIL_LEGGINGS, 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TeadBlocks.GOLD_CHAIN)
                .criterion(hasItem(TeadBlocks.GOLD_CHAIN), conditionsFromItem(TeadBlocks.GOLD_CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_CHAINMAIL_CHESTPLATE, 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TeadBlocks.GOLD_CHAIN)
                .criterion(hasItem(TeadBlocks.GOLD_CHAIN), conditionsFromItem(TeadBlocks.GOLD_CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_WOOLEN_BOOTS, 1)
                .pattern("% %")
                .pattern("# #")
                .input('#', Items.GOLD_NUGGET)
                .input('%', ItemTags.WOOL)
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_WOOLEN_HELMET, 1)
                .pattern("###")
                .pattern("#$#")
                .input('#', ItemTags.WOOL)
                .input('$', Items.GOLD_NUGGET)
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_WOOLEN_LEGGINGS, 1)
                .pattern("#$#")
                .pattern("# #")
                .pattern("# #")
                .input('#', TeadBlocks.GOLD_CHAIN)
                .input('$', Items.GOLD_NUGGET)
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_WOOLEN_CHESTPLATE, 1)
                .pattern("# #")
                .pattern("$#$")
                .pattern("#@#")
                .input('#', TeadBlocks.GOLD_CHAIN)
                .input('$', Items.GOLD_NUGGET)
                .input('@', TeadItems.GOLD_GARMENT_CHESTPLATE)
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_REINFORCED_MAIL_HELMET, 1)
                .pattern("###")
                .pattern("% %")
                .input('#', Items.GOLD_INGOT)
                .input('%', TeadBlocks.GOLD_CHAIN)
                .criterion(hasItem(TeadBlocks.GOLD_CHAIN), conditionsFromItem(TeadBlocks.GOLD_CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_REINFORCED_MAIL_CHESTPLATE, 1)
                .pattern("# #")
                .pattern("%#%")
                .pattern("%#%")
                .input('#', Items.GOLD_INGOT)
                .input('%', TeadBlocks.GOLD_CHAIN)
                .criterion(hasItem(TeadBlocks.GOLD_CHAIN), conditionsFromItem(TeadBlocks.GOLD_CHAIN))
                .offerTo(exporter);
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(TeadItems.SMITHING_GUIDE_STURDY),
                        Ingredient.ofItems(Items.GOLDEN_HELMET), Ingredient.ofItems(Items.GOLD_INGOT),
                        RecipeCategory.TOOLS, TeadItems.GOLD_STALWART_HELMET)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "gold_stalwart_helmet"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(TeadItems.SMITHING_GUIDE_STURDY),
                        Ingredient.ofItems(Items.GOLDEN_CHESTPLATE), Ingredient.ofItems(Items.GOLD_INGOT),
                        RecipeCategory.TOOLS, TeadItems.GOLD_STALWART_CHESTPLATE)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "gold_stalwart_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_PLATE_HELMET, 1)
                .pattern("#%#")
                .pattern("###")
                .input('#', Items.GOLD_INGOT)
                .input('%', Items.LEATHER)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_PLATE_CHESTPLATE, 1)
                .pattern("$$$")
                .pattern("%$%")
                .pattern("$ $")
                .input('%', Items.LEATHER)
                .input('$', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_PLATE_BOOTS, 1)
                .pattern("% %")
                .pattern("$ $")
                .input('%', Items.LEATHER)
                .input('$', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(TeadItems.SMITHING_GUIDE_HIGHLAND),
                        Ingredient.ofItems(Items.GOLDEN_HELMET), Ingredient.ofItems(Items.GOLD_INGOT),
                        RecipeCategory.TOOLS, TeadItems.GOLD_HIGHLAND_HELMET)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "gold_highland_helmet"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(TeadItems.SMITHING_GUIDE_HIGHLAND),
                        Ingredient.ofItems(Items.GOLDEN_CHESTPLATE), Ingredient.ofItems(Items.GOLD_INGOT),
                        RecipeCategory.TOOLS, TeadItems.GOLD_HIGHLAND_CHESTPLATE)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "gold_highland_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_ROYAL_HELMET, 1)
                .pattern("# #")
                .pattern("###")
                .input('#', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_THIEF_HELMET, 1)
                .pattern("%%%")
                .pattern("$^$")
                .pattern(" & ")
                .input('^', Items.GOLD_INGOT)
                .input('%', TeadItems.FABRIC)
                .input('$', Items.LEATHER)
                .input('&', Items.BLACK_DYE)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(TeadItems.FABRIC), conditionsFromItem(TeadItems.FABRIC))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_THIEF_CHESTPLATE, 1)
                .pattern("%&%")
                .pattern("$%%")
                .pattern("%%$")
                .input('%', TeadItems.FABRIC)
                .input('$', TeadItems.GOLD_GARMENT_CHESTPLATE)
                .input('&', Items.BLACK_DYE)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(TeadItems.FABRIC), conditionsFromItem(TeadItems.FABRIC))
                .offerTo(exporter);
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(TeadItems.SMITHING_GUIDE_MERCENARY),
                        Ingredient.ofItems(Items.GOLDEN_HELMET), Ingredient.ofItems(Items.GOLD_INGOT),
                        RecipeCategory.TOOLS, TeadItems.GOLD_MERCENARY_HELMET)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "gold_mercenary_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_SPANGENHELM_HELMET, 1)
                .pattern(" % ")
                .pattern("%$%")
                .pattern(" # ")
                .input('#', Items.GOLD_INGOT)
                .input('%', Items.GOLD_NUGGET)
                .input('$', Items.GOLDEN_HELMET)
                .criterion(hasItem(Items.GOLDEN_HELMET), conditionsFromItem(Items.GOLDEN_HELMET))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_GUARD_HELMET, 1)
                .pattern("%#%")
                .pattern("# #")
                .input('#', Items.GOLD_INGOT)
                .input('%', Items.LEATHER)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_GUARD_CHESTPLATE, 1)
                .pattern("# #")
                .pattern("%#%")
                .pattern("%$%")
                .input('#', Items.GOLD_INGOT)
                .input('%', Items.LEATHER)
                .input('$', TeadItems.GOLD_GARMENT_CHESTPLATE)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_GARMENT_BOOTS, 1)
                .pattern("% %")
                .pattern("# #")
                .input('#', Items.GOLD_NUGGET)
                .input('%', Items.BAMBOO)
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.GOLD_GARMENT_CHESTPLATE, 1)
                .pattern("%#%")
                .input('#', Items.GOLD_INGOT)
                .input('%', Items.LEATHER)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(TeadItems.SMITHING_GUIDE_SPOOKY),
                        Ingredient.ofItems(Items.GOLDEN_HELMET), Ingredient.ofItems(Items.GOLD_INGOT),
                        RecipeCategory.TOOLS, TeadItems.GOLD_GHOSTLY_HELMET)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "gold_ghostly_helmet"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(TeadItems.SMITHING_GUIDE_SPOOKY),
                        Ingredient.ofItems(Items.GOLDEN_CHESTPLATE), Ingredient.ofItems(Items.GOLD_INGOT),
                        RecipeCategory.TOOLS, TeadItems.GOLD_GHOSTLY_CHESTPLATE)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "gold_ghostly_chestplate"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(TeadItems.SMITHING_GUIDE_SPOOKY),
                        Ingredient.ofItems(Items.GOLDEN_BOOTS), Ingredient.ofItems(Items.GOLD_INGOT),
                        RecipeCategory.TOOLS, TeadItems.GOLD_GHOSTLY_BOOTS)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "gold_ghostly_boots"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.ROSE_GOLD_PICKAXE, 1)
                .pattern("###")
                .pattern(" $ ")
                .pattern(" % ")
                .input('%', Items.STICK)
                .input('#', TeadItems.ROSE_GOLD_INGOT)
                .input('$', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.ROSE_GOLD_INGOT), conditionsFromItem(TeadItems.ROSE_GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.ROSE_GOLD_SHOVEL, 1)
                .pattern("#")
                .pattern("%")
                .pattern("%")
                .input('%', Items.STICK)
                .input('#', TeadItems.ROSE_GOLD_INGOT)
                .criterion(hasItem(TeadItems.ROSE_GOLD_INGOT), conditionsFromItem(TeadItems.ROSE_GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.ROSE_GOLD_SWORD, 1)
                .pattern("#")
                .pattern("#")
                .pattern("%")
                .input('%', TeadItems.HANDLE)
                .input('#', TeadItems.ROSE_GOLD_INGOT)
                .criterion(hasItem(TeadItems.ROSE_GOLD_INGOT), conditionsFromItem(TeadItems.ROSE_GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.ROSE_GOLD_AXE, 1)
                .pattern("##")
                .pattern("#%")
                .pattern(" $")
                .input('%', Items.STICK)
                .input('#', TeadItems.ROSE_GOLD_INGOT)
                .input('$', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.ROSE_GOLD_INGOT), conditionsFromItem(TeadItems.ROSE_GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.ROSE_GOLD_HOE, 1)
                .pattern("##")
                .pattern(" %")
                .pattern(" $")
                .input('%', Items.STICK)
                .input('#', TeadItems.ROSE_GOLD_INGOT)
                .input('$', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.ROSE_GOLD_INGOT), conditionsFromItem(TeadItems.ROSE_GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.ROSE_GOLD_DOUBLE_AXE, 1)
                .pattern("#%#")
                .pattern("#%#")
                .pattern(" $ ")
                .input('%', Items.STICK)
                .input('#', TeadItems.ROSE_GOLD_INGOT)
                .input('$', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.ROSE_GOLD_INGOT), conditionsFromItem(TeadItems.ROSE_GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.ROSE_GOLD_HAMMER, 1)
                .pattern(" ##")
                .pattern(" ##")
                .pattern("%  ")
                .input('#', TeadItems.ROSE_GOLD_INGOT)
                .input('%', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.ROSE_GOLD_INGOT), conditionsFromItem(TeadItems.ROSE_GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.ROSE_GOLD_SICKLE, 1)
                .pattern(" # ")
                .pattern("  #")
                .pattern("%# ")
                .input('#', TeadItems.ROSE_GOLD_INGOT)
                .input('%', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.ROSE_GOLD_INGOT), conditionsFromItem(TeadItems.ROSE_GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.ROSE_GOLD_CLAYMORE, 1)
                .pattern("  #")
                .pattern("## ")
                .pattern("%# ")
                .input('#', TeadItems.ROSE_GOLD_INGOT)
                .input('%', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.ROSE_GOLD_INGOT), conditionsFromItem(TeadItems.ROSE_GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.ROSE_GOLD_DAGGER, 1)
                .pattern(" #")
                .pattern("% ")
                .input('#', TeadItems.ROSE_GOLD_INGOT)
                .input('%', Items.STICK)
                .criterion(hasItem(TeadItems.ROSE_GOLD_INGOT), conditionsFromItem(TeadItems.ROSE_GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.BRONZE_PICKAXE, 1)
                .pattern("###")
                .pattern(" $ ")
                .pattern(" % ")
                .input('%', Items.STICK)
                .input('#', TeadItems.BRONZE_INGOT)
                .input('$', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.BRONZE_INGOT), conditionsFromItem(TeadItems.BRONZE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.BRONZE_SHOVEL, 1)
                .pattern("#")
                .pattern("%")
                .pattern("%")
                .input('%', Items.STICK)
                .input('#', TeadItems.BRONZE_INGOT)
                .criterion(hasItem(TeadItems.BRONZE_INGOT), conditionsFromItem(TeadItems.BRONZE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.BRONZE_SWORD, 1)
                .pattern("#")
                .pattern("#")
                .pattern("%")
                .input('%', TeadItems.HANDLE)
                .input('#', TeadItems.BRONZE_INGOT)
                .criterion(hasItem(TeadItems.BRONZE_INGOT), conditionsFromItem(TeadItems.BRONZE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.BRONZE_AXE, 1)
                .pattern("##")
                .pattern("#%")
                .pattern(" $")
                .input('%', Items.STICK)
                .input('#', TeadItems.BRONZE_INGOT)
                .input('$', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.BRONZE_INGOT), conditionsFromItem(TeadItems.BRONZE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.BRONZE_HOE, 1)
                .pattern("##")
                .pattern(" %")
                .pattern(" $")
                .input('%', Items.STICK)
                .input('#', TeadItems.BRONZE_INGOT)
                .input('$', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.BRONZE_INGOT), conditionsFromItem(TeadItems.BRONZE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.BRONZE_DOUBLE_AXE, 1)
                .pattern("#%#")
                .pattern("#%#")
                .pattern(" $ ")
                .input('%', Items.STICK)
                .input('#', TeadItems.BRONZE_INGOT)
                .input('$', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.BRONZE_INGOT), conditionsFromItem(TeadItems.BRONZE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.BRONZE_HAMMER, 1)
                .pattern(" ##")
                .pattern(" ##")
                .pattern("%  ")
                .input('#', TeadItems.BRONZE_INGOT)
                .input('%', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.BRONZE_INGOT), conditionsFromItem(TeadItems.BRONZE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.BRONZE_SICKLE, 1)
                .pattern(" # ")
                .pattern("  #")
                .pattern("%# ")
                .input('#', TeadItems.BRONZE_INGOT)
                .input('%', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.BRONZE_INGOT), conditionsFromItem(TeadItems.BRONZE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.BRONZE_CLAYMORE, 1)
                .pattern("  #")
                .pattern("## ")
                .pattern("%# ")
                .input('#', TeadItems.BRONZE_INGOT)
                .input('%', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.BRONZE_INGOT), conditionsFromItem(TeadItems.BRONZE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.BRONZE_DAGGER, 1)
                .pattern(" #")
                .pattern("% ")
                .input('#', TeadItems.BRONZE_INGOT)
                .input('%', Items.STICK)
                .criterion(hasItem(TeadItems.BRONZE_INGOT), conditionsFromItem(TeadItems.BRONZE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.STEEL_PICKAXE, 1)
                .pattern("###")
                .pattern(" $ ")
                .pattern(" % ")
                .input('%', Items.STICK)
                .input('#', TeadItems.STEEL_INGOT)
                .input('$', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.STEEL_INGOT), conditionsFromItem(TeadItems.STEEL_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.STEEL_SHOVEL, 1)
                .pattern("#")
                .pattern("%")
                .pattern("%")
                .input('%', Items.STICK)
                .input('#', TeadItems.STEEL_INGOT)
                .criterion(hasItem(TeadItems.STEEL_INGOT), conditionsFromItem(TeadItems.STEEL_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.STEEL_SWORD, 1)
                .pattern("#")
                .pattern("#")
                .pattern("%")
                .input('%', TeadItems.HANDLE)
                .input('#', TeadItems.STEEL_INGOT)
                .criterion(hasItem(TeadItems.STEEL_INGOT), conditionsFromItem(TeadItems.STEEL_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.STEEL_AXE, 1)
                .pattern("##")
                .pattern("#%")
                .pattern(" $")
                .input('%', Items.STICK)
                .input('#', TeadItems.STEEL_INGOT)
                .input('$', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.STEEL_INGOT), conditionsFromItem(TeadItems.STEEL_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.STEEL_HOE, 1)
                .pattern("##")
                .pattern(" %")
                .pattern(" $")
                .input('%', Items.STICK)
                .input('#', TeadItems.STEEL_INGOT)
                .input('$', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.STEEL_INGOT), conditionsFromItem(TeadItems.STEEL_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.STEEL_DOUBLE_AXE, 1)
                .pattern("#%#")
                .pattern("#%#")
                .pattern(" $ ")
                .input('%', Items.STICK)
                .input('#', TeadItems.STEEL_INGOT)
                .input('$', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.STEEL_INGOT), conditionsFromItem(TeadItems.STEEL_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.STEEL_HAMMER, 1)
                .pattern(" ##")
                .pattern(" ##")
                .pattern("%  ")
                .input('#', TeadItems.STEEL_INGOT)
                .input('%', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.STEEL_INGOT), conditionsFromItem(TeadItems.STEEL_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.STEEL_SICKLE, 1)
                .pattern(" # ")
                .pattern("  #")
                .pattern("%# ")
                .input('#', TeadItems.STEEL_INGOT)
                .input('%', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.STEEL_INGOT), conditionsFromItem(TeadItems.STEEL_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.STEEL_CLAYMORE, 1)
                .pattern("  #")
                .pattern("## ")
                .pattern("%# ")
                .input('#', TeadItems.STEEL_INGOT)
                .input('%', TeadItems.HANDLE)
                .criterion(hasItem(TeadItems.STEEL_INGOT), conditionsFromItem(TeadItems.STEEL_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.STEEL_DAGGER, 1)
                .pattern(" #")
                .pattern("% ")
                .input('#', TeadItems.STEEL_INGOT)
                .input('%', Items.STICK)
                .criterion(hasItem(TeadItems.STEEL_INGOT), conditionsFromItem(TeadItems.STEEL_INGOT))
                .offerTo(exporter);
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.FIREBOLT_THROWER, 1)
                .pattern("&$&")
                .pattern("%#%")
                .pattern("%%%")
                .input('#', Items.CROSSBOW)
                .input('%', Items.STRING)
                .input('$', Items.FLINT_AND_STEEL)
                .input('&', Items.RED_DYE)
                .criterion(hasItem(Items.FLINT_AND_STEEL), conditionsFromItem(Items.FLINT_AND_STEEL))
                .criterion(hasItem(Items.CROSSBOW), conditionsFromItem(Items.CROSSBOW))
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
                .input('#', TeadItems.STEEL_INGOT)
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
                .input('#', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .group("shuriken")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "shuriken_0"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.SHURIKEN, 6)
                .pattern(" # ")
                .pattern("# #")
                .pattern(" # ")
                .input('#', TeadItems.LEAD_INGOT)
                .criterion(hasItem(TeadItems.LEAD_INGOT), conditionsFromItem(TeadItems.LEAD_INGOT))
                .group("shuriken")
                .offerTo(exporter, new Identifier(Tead.MOD_ID, "shuriken_1"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadBlocks.STEEL_CHAIN, 1)
                .pattern("%")
                .pattern("#")
                .pattern("%")
                .input('#', TeadItems.STEEL_INGOT)
                .input('%', TeadItems.STEEL_NUGGET)
                .criterion(hasItem(TeadItems.STEEL_INGOT), conditionsFromItem(TeadItems.STEEL_INGOT))
                .criterion(hasItem(TeadItems.STEEL_NUGGET), conditionsFromItem(TeadItems.STEEL_NUGGET))
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadBlocks.BRONZE_CHAIN, 1)
                .pattern("%")
                .pattern("#")
                .pattern("%")
                .input('#', TeadItems.BRONZE_INGOT)
                .input('%', TeadItems.BRONZE_NUGGET)
                .criterion(hasItem(TeadItems.BRONZE_INGOT), conditionsFromItem(TeadItems.BRONZE_INGOT))
                .criterion(hasItem(TeadItems.BRONZE_NUGGET), conditionsFromItem(TeadItems.BRONZE_NUGGET))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadBlocks.GOLD_CHAIN, 1)
                .pattern("%")
                .pattern("#")
                .pattern("%")
                .input('#', Items.GOLD_INGOT)
                .input('%', Items.GOLD_NUGGET)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .offerTo(exporter);
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.STEEL_CHAINMAIL_BOOTS, 1)
                .pattern("# #")
                .pattern("# #")
                .input('#',TeadBlocks.STEEL_CHAIN)
                .criterion(hasItem(TeadBlocks.STEEL_CHAIN), conditionsFromItem(TeadBlocks.STEEL_CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.STEEL_CHAINMAIL_HELMET, 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TeadBlocks.STEEL_CHAIN)
                .criterion(hasItem(TeadBlocks.STEEL_CHAIN), conditionsFromItem(TeadBlocks.STEEL_CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.STEEL_CHAINMAIL_LEGGINGS, 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TeadBlocks.STEEL_CHAIN)
                .criterion(hasItem(TeadBlocks.STEEL_CHAIN), conditionsFromItem(TeadBlocks.STEEL_CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.STEEL_CHAINMAIL_CHESTPLATE, 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TeadBlocks.STEEL_CHAIN)
                .criterion(hasItem(TeadBlocks.STEEL_CHAIN), conditionsFromItem(TeadBlocks.STEEL_CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.ROSE_GOLD_CHAINMAIL_BOOTS, 1)
                .pattern("# #")
                .pattern("# #")
                .input('#',TeadBlocks.ROSE_GOLD_CHAIN)
                .criterion(hasItem(TeadBlocks.ROSE_GOLD_CHAIN), conditionsFromItem(TeadBlocks.ROSE_GOLD_CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.ROSE_GOLD_CHAINMAIL_HELMET, 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TeadBlocks.ROSE_GOLD_CHAIN)
                .criterion(hasItem(TeadBlocks.ROSE_GOLD_CHAIN), conditionsFromItem(TeadBlocks.ROSE_GOLD_CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.ROSE_GOLD_CHAINMAIL_LEGGINGS, 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TeadBlocks.ROSE_GOLD_CHAIN)
                .criterion(hasItem(TeadBlocks.ROSE_GOLD_CHAIN), conditionsFromItem(TeadBlocks.ROSE_GOLD_CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.ROSE_GOLD_CHAINMAIL_CHESTPLATE, 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TeadBlocks.ROSE_GOLD_CHAIN)
                .criterion(hasItem(TeadBlocks.ROSE_GOLD_CHAIN), conditionsFromItem(TeadBlocks.ROSE_GOLD_CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.BRONZE_CHAINMAIL_BOOTS, 1)
                .pattern("# #")
                .pattern("# #")
                .input('#',TeadBlocks.BRONZE_CHAIN)
                .criterion(hasItem(TeadBlocks.BRONZE_CHAIN), conditionsFromItem(TeadBlocks.BRONZE_CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.BRONZE_CHAINMAIL_HELMET, 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TeadBlocks.BRONZE_CHAIN)
                .criterion(hasItem(TeadBlocks.BRONZE_CHAIN), conditionsFromItem(TeadBlocks.BRONZE_CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.BRONZE_CHAINMAIL_LEGGINGS, 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TeadBlocks.BRONZE_CHAIN)
                .criterion(hasItem(TeadBlocks.BRONZE_CHAIN), conditionsFromItem(TeadBlocks.BRONZE_CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TeadItems.BRONZE_CHAINMAIL_CHESTPLATE, 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TeadBlocks.BRONZE_CHAIN)
                .criterion(hasItem(TeadBlocks.BRONZE_CHAIN), conditionsFromItem(TeadBlocks.BRONZE_CHAIN))
                .offerTo(exporter);
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
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_STALWART_HELMET, RecipeCategory.COMBAT,
                TeadItems.NETHERITE_STALWART_HELMET);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_STALWART_CHESTPLATE, RecipeCategory.COMBAT,
                TeadItems.NETHERITE_STALWART_CHESTPLATE);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_PLATE_HELMET, RecipeCategory.COMBAT,
                TeadItems.NETHERITE_PLATE_HELMET);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_PLATE_BOOTS, RecipeCategory.COMBAT,
                TeadItems.NETHERITE_PLATE_BOOTS);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_HIGHLAND_HELMET, RecipeCategory.COMBAT,
                TeadItems.NETHERITE_HIGHLAND_HELMET);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_HIGHLAND_CHESTPLATE, RecipeCategory.COMBAT,
                TeadItems.NETHERITE_HIGHLAND_CHESTPLATE);
        offerNetheriteUpgradeRecipe(exporter, TeadItems.DIAMOND_ROYAL_HELMET, RecipeCategory.COMBAT,
                TeadItems.NETHERITE_ROYAL_HELMET);
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
        offerSmithingGuideRecipe(outputItem, inputItem, ingot, TeadItems.SMITHING_GUIDE_TEMPEST_KNIFE,
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
}
