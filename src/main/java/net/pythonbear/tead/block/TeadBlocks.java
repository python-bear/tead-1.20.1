package net.pythonbear.tead.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.block.entity.SmelterBlockEntity;

public class TeadBlocks {
    public static final Block WEAK_COBWEB = registerBlockWithoutItem("weak_cobweb",
            new WeakCobwebBlock(AbstractBlock.Settings.create().mapColor(MapColor.WHITE_GRAY).solid().noCollision().requiresTool().strength(2.0f).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PIG_IRON_BLOCK = registerBlock("pig_iron_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final Block LEAD_ORE = registerBlock("lead_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE), UniformIntProvider.create(0, 1)));
    public static final Block LEAD_DEEPSLATE_ORE = registerBlock("lead_deepslate_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE),
                    UniformIntProvider.create(0, 1)));
    public static final Block RAW_LEAD_BLOCK = registerBlock("raw_lead_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block LEAD_BLOCK = registerBlock("lead_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block LEAD_CHISELED_BLOCK = registerBlock("lead_chiseled_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block LEAD_CUT_BLOCK = registerBlock("lead_cut_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block LEAD_CUT_SLAB = registerBlock("lead_cut_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.CUT_COPPER_SLAB).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block LEAD_CUT_STAIRS = registerBlock("lead_cut_stairs",
            new StairsBlock(TeadBlocks.LEAD_CUT_BLOCK.getDefaultState(),
                    FabricBlockSettings.copyOf(Blocks.CUT_COPPER_STAIRS).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block LEAD_TILED_BLOCK = registerBlock("lead_tiled_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block ROSE_GOLD_BLOCK = registerBlock("rose_gold_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).mapColor(MapColor.PINK)));
    public static final Block WHITE_GOLD_NETHER_ORE = registerBlock("white_gold_nether_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE)));
    public static final Block WHITE_GOLD_BLOCK = registerBlock("white_gold_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).mapColor(MapColor.WHITE)));
    public static final Block BRASS_BLOCK = registerBlock("brass_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).mapColor(MapColor.YELLOW)));
    public static final Block BRASS_CUT_BLOCK = registerBlock("brass_cut_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).mapColor(MapColor.YELLOW)));
    public static final Block BRASS_CUT_SLAB = registerBlock("brass_cut_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.CUT_COPPER_SLAB).mapColor(MapColor.YELLOW)));
    public static final Block BRASS_CUT_STAIRS = registerBlock("brass_cut_stairs",
            new StairsBlock(TeadBlocks.BRASS_CUT_BLOCK.getDefaultState(),
                    FabricBlockSettings.copyOf(Blocks.CUT_COPPER_STAIRS).mapColor(MapColor.YELLOW)));
    public static final Block BRONZE_BLOCK = registerBlock("bronze_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).mapColor(MapColor.BROWN)));
    public static final Block BRONZE_CUT_BLOCK = registerBlock("bronze_cut_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).mapColor(MapColor.BROWN)));
    public static final Block BRONZE_CUT_SLAB = registerBlock("bronze_cut_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.CUT_COPPER_SLAB).mapColor(MapColor.BROWN)));
    public static final Block BRONZE_CUT_STAIRS = registerBlock("bronze_cut_stairs",
            new StairsBlock(TeadBlocks.BRASS_CUT_BLOCK.getDefaultState(),
                    FabricBlockSettings.copyOf(Blocks.CUT_COPPER_STAIRS).mapColor(MapColor.BROWN)));
    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(MapColor.LIGHT_BLUE_GRAY)));
    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.EMERALD_ORE),
                    UniformIntProvider.create(4, 8)));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_EMERALD_ORE),
                    UniformIntProvider.create(4, 8)));
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.BRIGHT_RED).instrument(Instrument.PLING)
                    .requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block ROSE_NETHERITE_BLOCK = registerBlock("rose_netherite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK).mapColor(MapColor.DARK_DULL_PINK)));
    public static final Block WHITE_NETHERITE_BLOCK = registerBlock("white_netherite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block GOLD_CHAIN = registerBlock("gold_chain",
            new ChainBlock(FabricBlockSettings.copyOf(Blocks.CHAIN).mapColor(MapColor.GOLD)
                    .strength(4.0f, 5.0f).nonOpaque().solid().requiresTool().dynamicBounds()));
    public static final Block LEAD_CHAIN = registerBlock("lead_chain",
            new ChainBlock(FabricBlockSettings.copyOf(Blocks.CHAIN).mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(5.0f, 6.0f).nonOpaque().solid().requiresTool().dynamicBounds()));
    public static final Block COPPER_CHAIN = registerBlock("copper_chain",
            new ChainBlock(FabricBlockSettings.copyOf(Blocks.CHAIN).mapColor(MapColor.ORANGE)
                    .strength(4.0f, 5.0f).nonOpaque().solid().requiresTool().dynamicBounds()));
    public static final Block ROSE_GOLD_CHAIN = registerBlock("rose_gold_chain",
            new ChainBlock(FabricBlockSettings.copyOf(Blocks.CHAIN).mapColor(MapColor.BRIGHT_RED)
                    .strength(5.0f, 6.0f).nonOpaque().solid().requiresTool().dynamicBounds()));
    public static final Block WHITE_GOLD_CHAIN = registerBlock("white_gold_chain",
            new ChainBlock(FabricBlockSettings.copyOf(Blocks.CHAIN).mapColor(MapColor.WHITE)
                    .strength(6.0f, 6.0f).nonOpaque().solid().requiresTool().dynamicBounds()));
    public static final Block BRONZE_CHAIN = registerBlock("bronze_chain",
            new ChainBlock(FabricBlockSettings.copyOf(Blocks.CHAIN).mapColor(MapColor.BROWN)
                    .strength(5.0f, 6.0f).nonOpaque().solid().requiresTool().dynamicBounds()));
    public static final Block BRASS_CHAIN = registerBlock("brass_chain",
            new ChainBlock(FabricBlockSettings.copyOf(Blocks.CHAIN).mapColor(MapColor.YELLOW)
                    .strength(5.0f, 6.0f).nonOpaque().solid().requiresTool().dynamicBounds()));
    public static final Block STEEL_CHAIN = registerBlock("steel_chain",
            new ChainBlock(FabricBlockSettings.copyOf(Blocks.CHAIN).mapColor(MapColor.GOLD)
                    .strength(6.0f, 7.0f).nonOpaque().solid().requiresTool().dynamicBounds()));
    public static final Block SLUDGE = registerBlock("sludge",
            new Block(FabricBlockSettings.copyOf(Blocks.MUD)));
    public static final Block CLAYISH_MUD = registerBlock("clayish_mud",
            new Block(FabricBlockSettings.copyOf(Blocks.MUD)));
    public static final Block DARK_BRICKS = registerBlock("dark_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.BRICKS)));
    public static final Block SICK_PUMPKIN = registerBlock("sick_pumpkin",
            new PumpkinBlock(FabricBlockSettings.copyOf(Blocks.PUMPKIN)));
    public static final Block EMPTY_BOOKSHELF = registerBlock("empty_bookshelf",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block OLD_BOOKSHELF = registerBlock("old_bookshelf",
            new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF)));
    public static final Block SMELTER = registerBlock("smelter",
            new SmelterBlock(FabricBlockSettings.copyOf(Blocks.BLAST_FURNACE)));
    public static final BlockEntityType<SmelterBlockEntity> SMELTER_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(Tead.MOD_ID, "smelter"),
            BlockEntityType.Builder.create(SmelterBlockEntity::new, SMELTER).build(null)
    );

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Tead.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Tead.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(Tead.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerBlocks() {
        Tead.LOGGER.info("Registering mod blocks for " + Tead.MOD_ID);
    }
}
