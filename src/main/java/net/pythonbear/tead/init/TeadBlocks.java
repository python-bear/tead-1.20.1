package net.pythonbear.tead.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.block.custom.SmelterBlock;

public class TeadBlocks {
    public static final Block BLOCK_OF_RUBY = registerBlock("block_of_ruby",
            new Block(FabricBlockSettings.create().mapColor(MapColor.BRIGHT_RED).instrument(Instrument.PLING)
                    .requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block BLOCK_OF_LEAD = registerBlock("block_of_lead",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(MapColor.STONE_GRAY)
                    .sounds(BlockSoundGroup.CHAIN)));
    public static final Block BLOCK_OF_GALENA = registerBlock("block_of_galena",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.IRON_GRAY)));
    public static final Block LEAD_ORE = registerBlock("lead_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE), UniformIntProvider.create(0, 1)));
    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.EMERALD_ORE),
                    UniformIntProvider.create(4, 8)));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_EMERALD_ORE),
                    UniformIntProvider.create(4, 8)));
    public static final Block GOLD_CHAIN = registerBlock("gold_chain",
            new ChainBlock(FabricBlockSettings.copyOf(Blocks.CHAIN).mapColor(MapColor.GOLD)
                    .strength(4.0f, 5.0f).nonOpaque().solid().requiresTool().dynamicBounds()));
    public static final Block STEEL_CHAIN = registerBlock("steel_chain",
            new ChainBlock(FabricBlockSettings.copyOf(Blocks.CHAIN).mapColor(MapColor.GOLD)
                    .strength(6.0f, 7.0f).nonOpaque().solid().requiresTool().dynamicBounds()));
    public static final Block ROSE_GOLD_CHAIN = registerBlock("rose_gold_chain",
            new ChainBlock(FabricBlockSettings.copyOf(Blocks.CHAIN).mapColor(MapColor.BRIGHT_RED)
                    .strength(5.0f, 6.0f).nonOpaque().solid().requiresTool().dynamicBounds()));
    public static final Block BRONZE_CHAIN = registerBlock("bronze_chain",
            new ChainBlock(FabricBlockSettings.copyOf(Blocks.CHAIN).mapColor(MapColor.ORANGE)
                    .strength(5.0f, 6.0f).nonOpaque().solid().requiresTool().dynamicBounds()));
    public static final Block COPPER_CHAIN = registerBlock("copper_chain",
            new ChainBlock(FabricBlockSettings.copyOf(Blocks.CHAIN).mapColor(MapColor.ORANGE)
                    .strength(4.0f, 5.0f).nonOpaque().solid().requiresTool().dynamicBounds()));
    public static final Block DRY_GRASS = registerBlock("dry_grass",
            new GrassBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK)));
    public static final Block BROWN_DRY_GRASS = registerBlock("brown_dry_grass",
            new GrassBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK)));
    public static final Block SPARSE_GRASS = registerBlock("sparse_grass",
            new GrassBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK)));
    public static final Block VERY_SPARSE_GRASS = registerBlock("very_sparse_grass",
            new GrassBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK)));
    public static final Block DRY_DIRT = registerBlock("dry_dirt",
            new GrassBlock(FabricBlockSettings.copyOf(Blocks.COARSE_DIRT)));
    public static final Block DARK_BRICKS = registerBlock("dark_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.BRICKS)));
    public static final Block DARK_COBBLESTONE = registerBlock("dark_cobblestone",
            new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));
    public static final Block SANDY_COBBLESTONE = registerBlock("sandy_cobblestone",
            new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));
    public static final Block VERY_SANDY_COBBLESTONE = registerBlock("very_sandy_cobblestone",
            new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));
    public static final Block DIRTY_COBBLESTONE = registerBlock("dirty_cobblestone",
            new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));
    public static final Block DIRTY_STONE_PLAQUE = registerBlock("dirty_stone_plaque",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block STONE_PLAQUE = registerBlock("stone_plaque",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block SLUDGE = registerBlock("sludge",
            new Block(FabricBlockSettings.copyOf(Blocks.MUD)));
    public static final Block CLAYISH_MUD = registerBlock("clayish_mud",
            new Block(FabricBlockSettings.copyOf(Blocks.MUD)));
    public static final Block SICK_PUMPKIN = registerBlock("sick_pumpkin",
            new PumpkinBlock(FabricBlockSettings.copyOf(Blocks.PUMPKIN)));
    public static final Block EMPTY_BOOKSHELF = registerBlock("empty_bookshelf",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block OLD_BOOKSHELF = registerBlock("old_bookshelf",
            new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF)));
    public static final Block SMELTER = registerBlock("smelter",
            new SmelterBlock(FabricBlockSettings.copyOf(Blocks.BLAST_FURNACE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
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
