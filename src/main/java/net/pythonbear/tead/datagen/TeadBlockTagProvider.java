package net.pythonbear.tead.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.init.TeadBlocks;
import net.pythonbear.tead.init.TeadTags;

import java.util.concurrent.CompletableFuture;

public class TeadBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public TeadBlockTagProvider(FabricDataOutput output,
                                CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(TeadBlocks.BLOCK_OF_LEAD)
                .add(TeadBlocks.BLOCK_OF_GALENA)
                .add(TeadBlocks.RUBY_ORE)
                .add(TeadBlocks.DEEPSLATE_RUBY_ORE)
                .add(TeadBlocks.LEAD_ORE)
                .add(TeadBlocks.BLOCK_OF_RUBY)
                .add(TeadBlocks.DARK_BRICKS)
                .add(TeadBlocks.DARK_COBBLESTONE)
                .add(TeadBlocks.DIRTY_COBBLESTONE)
                .add(TeadBlocks.DIRTY_STONE_PLAQUE)
                .add(TeadBlocks.STONE_PLAQUE)
                .add(TeadBlocks.SANDY_COBBLESTONE)
                .add(TeadBlocks.VERY_SANDY_COBBLESTONE)

                .add(TeadBlocks.GOLD_CHAIN)
                .add(TeadBlocks.STEEL_CHAIN)
                .add(TeadBlocks.ROSE_GOLD_CHAIN)
                .add(TeadBlocks.BRONZE_CHAIN);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(TeadBlocks.CLAYISH_MUD)
                .add(TeadBlocks.SLUDGE)
                .add(TeadBlocks.SPARSE_GRASS)
                .add(TeadBlocks.DRY_GRASS)
                .add(TeadBlocks.BROWN_DRY_GRASS)
                .add(TeadBlocks.VERY_SPARSE_GRASS)
                .add(TeadBlocks.DRY_DIRT);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(TeadBlocks.EMPTY_BOOKSHELF)
                .add(TeadBlocks.OLD_BOOKSHELF)
                .add(TeadBlocks.SICK_PUMPKIN);

        getOrCreateTagBuilder(TeadTags.Blocks.SCYTHE_BLOCKS)
                .forceAddTag(BlockTags.FLOWERS)
                .add(Blocks.SWEET_BERRY_BUSH)
                .add(Blocks.NETHER_SPROUTS)
                .add(Blocks.WARPED_ROOTS)
                .add(Blocks.CRIMSON_ROOTS)
                .add(Blocks.DEAD_BUSH)
                .add(Blocks.LARGE_FERN)
                .add(Blocks.FERN)
                .add(Blocks.TALL_GRASS)
                .add(Blocks.GRASS);

        getOrCreateTagBuilder(TeadTags.Blocks.REFINED_BUILDING_BLOCKS)
                .add(TeadBlocks.BLOCK_OF_LEAD)
                .add(TeadBlocks.BLOCK_OF_GALENA)
                .add(TeadBlocks.RUBY_ORE)
                .add(TeadBlocks.DEEPSLATE_RUBY_ORE)
                .add(TeadBlocks.LEAD_ORE)
                .add(TeadBlocks.BLOCK_OF_RUBY)
                .add(TeadBlocks.DARK_BRICKS)
                .add(TeadBlocks.DARK_COBBLESTONE)
                .add(TeadBlocks.DIRTY_COBBLESTONE)
                .add(TeadBlocks.DIRTY_STONE_PLAQUE)
                .add(TeadBlocks.STONE_PLAQUE)
                .add(TeadBlocks.SANDY_COBBLESTONE)
                .add(TeadBlocks.VERY_SANDY_COBBLESTONE)
                .add(TeadBlocks.GOLD_CHAIN)
                .add(TeadBlocks.STEEL_CHAIN)
                .add(TeadBlocks.ROSE_GOLD_CHAIN)
                .add(TeadBlocks.BRONZE_CHAIN)

                .add(Blocks.STONECUTTER)
                .add(Blocks.ANVIL)
                .add(Blocks.CHIPPED_ANVIL)
                .add(Blocks.DAMAGED_ANVIL)
                .add(Blocks.BEACON)
                .add(Blocks.ENDER_CHEST)
                .add(Blocks.ENCHANTING_TABLE)
                .add(Blocks.FURNACE)
                .add(Blocks.BLAST_FURNACE)
                .add(Blocks.SMOKER)
                .add(Blocks.GRINDSTONE)
                .add(Blocks.SMITHING_TABLE)
                .add(Blocks.BELL)
                .add(Blocks.CHAIN)
                .add(Blocks.CAULDRON)
                .add(Blocks.LAVA_CAULDRON)
                .add(Blocks.WATER_CAULDRON)
                .add(Blocks.POWDER_SNOW_CAULDRON)
                .add(Blocks.LODESTONE)
                .add(Blocks.SPAWNER)
                .add(Blocks.RESPAWN_ANCHOR)
                .add(Blocks.DISPENSER)
                .add(Blocks.DROPPER)
                .add(Blocks.IRON_DOOR)
                .add(Blocks.IRON_TRAPDOOR)
                .add(Blocks.HOPPER)
                .add(Blocks.LEVER)
                .add(Blocks.LIGHTNING_ROD)
                .add(Blocks.END_ROD)
                .add(Blocks.OBSERVER)
                .add(Blocks.PISTON)
                .add(Blocks.STICKY_PISTON)
                .add(Blocks.RAIL)
                .add(Blocks.ACTIVATOR_RAIL)
                .add(Blocks.DETECTOR_RAIL)
                .add(Blocks.POWERED_RAIL)
                .add(Blocks.COMPARATOR)
                .add(Blocks.REPEATER)
                .add(Blocks.REDSTONE_LAMP)
                .add(Blocks.REDSTONE_BLOCK)
                .add(Blocks.REDSTONE_TORCH)
                .add(Blocks.REDSTONE_WALL_TORCH)
                .add(Blocks.TORCH)
                .add(Blocks.WALL_TORCH)
                .add(Blocks.SOUL_TORCH)
                .add(Blocks.SOUL_WALL_TORCH)
                .add(Blocks.LANTERN)
                .add(Blocks.SOUL_LANTERN)
                .add(Blocks.SEA_LANTERN)
                .add(Blocks.FLETCHING_TABLE)
                .add(Blocks.CRAFTING_TABLE)
                .add(Blocks.BARREL)
                .add(Blocks.CHEST)
                .add(Blocks.TRAPPED_CHEST)

                .add(Blocks.BAMBOO_MOSAIC)
                .add(Blocks.BAMBOO_MOSAIC_SLAB)
                .add(Blocks.BAMBOO_MOSAIC_STAIRS)

                .add(Blocks.COBBLESTONE)
                .add(Blocks.COBBLESTONE_SLAB)
                .add(Blocks.COBBLESTONE_STAIRS)
                .add(Blocks.COBBLESTONE_WALL)

                .add(Blocks.STONE_BRICKS)
                .add(Blocks.STONE_BRICK_SLAB)
                .add(Blocks.STONE_BRICK_STAIRS)
                .add(Blocks.STONE_BRICK_WALL)
                .add(Blocks.MOSSY_STONE_BRICKS)
                .add(Blocks.MOSSY_STONE_BRICK_SLAB)
                .add(Blocks.MOSSY_STONE_BRICK_STAIRS)
                .add(Blocks.MOSSY_STONE_BRICK_WALL)

                .add(Blocks.MOSSY_COBBLESTONE)
                .add(Blocks.MOSSY_COBBLESTONE_SLAB)
                .add(Blocks.MOSSY_COBBLESTONE_STAIRS)
                .add(Blocks.MOSSY_COBBLESTONE_WALL)

                .add(Blocks.DEEPSLATE_BRICK_SLAB)
                .add(Blocks.DEEPSLATE_BRICKS)
                .add(Blocks.DEEPSLATE_BRICK_STAIRS)
                .add(Blocks.DEEPSLATE_BRICK_WALL)
                .add(Blocks.DEEPSLATE_TILE_SLAB)
                .add(Blocks.DEEPSLATE_TILE_STAIRS)
                .add(Blocks.DEEPSLATE_TILE_WALL)
                .add(Blocks.DEEPSLATE_TILES)

                .add(Blocks.END_STONE_BRICKS)
                .add(Blocks.END_STONE_BRICK_SLAB)
                .add(Blocks.END_STONE_BRICK_STAIRS)
                .add(Blocks.END_STONE_BRICK_WALL)

                .add(Blocks.NETHER_BRICKS)
                .add(Blocks.NETHER_BRICK_FENCE)
                .add(Blocks.NETHER_BRICK_SLAB)
                .add(Blocks.NETHER_BRICK_STAIRS)
                .add(Blocks.NETHER_BRICK_WALL)
                .add(Blocks.RED_NETHER_BRICKS)
                .add(Blocks.RED_NETHER_BRICK_SLAB)
                .add(Blocks.RED_NETHER_BRICK_STAIRS)
                .add(Blocks.RED_NETHER_BRICK_WALL)

                .add(Blocks.MUD_BRICKS)
                .add(Blocks.MUD_BRICK_SLAB)
                .add(Blocks.MUD_BRICK_STAIRS)
                .add(Blocks.MUD_BRICK_WALL)

                .add(Blocks.PRISMARINE_BRICKS)
                .add(Blocks.PRISMARINE_BRICK_SLAB)
                .add(Blocks.PRISMARINE_BRICK_STAIRS)

                .add(Blocks.PURPUR_BLOCK)
                .add(Blocks.PURPUR_PILLAR)
                .add(Blocks.PURPUR_SLAB)
                .add(Blocks.PURPUR_STAIRS)

                .add(Blocks.COBBLED_DEEPSLATE_WALL)
                .add(Blocks.COBBLED_DEEPSLATE_SLAB)
                .add(Blocks.COBBLED_DEEPSLATE_STAIRS)
                .add(Blocks.COBBLED_DEEPSLATE)

                .add(Blocks.CRACKED_DEEPSLATE_BRICKS)
                .add(Blocks.CRACKED_DEEPSLATE_TILES)
                .add(Blocks.CRACKED_NETHER_BRICKS)
                .add(Blocks.CRACKED_STONE_BRICKS)
                .add(Blocks.INFESTED_CRACKED_STONE_BRICKS)

                .add(Blocks.POLISHED_DEEPSLATE)
                .add(Blocks.POLISHED_DEEPSLATE_SLAB)
                .add(Blocks.POLISHED_DEEPSLATE_STAIRS)
                .add(Blocks.POLISHED_DEEPSLATE_WALL)
                .add(Blocks.POLISHED_ANDESITE)
                .add(Blocks.POLISHED_ANDESITE_SLAB)
                .add(Blocks.POLISHED_ANDESITE_STAIRS)
                .add(Blocks.POLISHED_BASALT)
                .add(Blocks.POLISHED_BLACKSTONE)
                .add(Blocks.POLISHED_BLACKSTONE_SLAB)
                .add(Blocks.POLISHED_BLACKSTONE_STAIRS)
                .add(Blocks.POLISHED_BLACKSTONE_WALL)
                .add(Blocks.POLISHED_BLACKSTONE_BRICKS)
                .add(Blocks.POLISHED_BLACKSTONE_BRICK_SLAB)
                .add(Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS)
                .add(Blocks.POLISHED_BLACKSTONE_BRICK_WALL)
                .add(Blocks.POLISHED_DIORITE)
                .add(Blocks.POLISHED_DIORITE_STAIRS)
                .add(Blocks.POLISHED_DIORITE_SLAB)
                .add(Blocks.POLISHED_GRANITE)
                .add(Blocks.POLISHED_GRANITE_STAIRS)
                .add(Blocks.POLISHED_GRANITE_SLAB)

                .add(Blocks.POLISHED_BLACKSTONE_BUTTON)
                .add(Blocks.STONE_BUTTON)
                .add(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE)
                .add(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE)
                .add(Blocks.POLISHED_BLACKSTONE_PRESSURE_PLATE)
                .add(Blocks.STONE_PRESSURE_PLATE)

                .add(Blocks.SANDSTONE_SLAB)
                .add(Blocks.SANDSTONE_STAIRS)
                .add(Blocks.SANDSTONE_WALL)
                .add(Blocks.QUARTZ_BRICKS)
                .add(Blocks.QUARTZ_PILLAR)
                .add(Blocks.QUARTZ_SLAB)
                .add(Blocks.QUARTZ_STAIRS)

                .add(Blocks.CUT_SANDSTONE)
                .add(Blocks.CUT_RED_SANDSTONE)
                .add(Blocks.CUT_RED_SANDSTONE_SLAB)
                .add(Blocks.CUT_SANDSTONE_SLAB)

                .add(Blocks.CHISELED_QUARTZ_BLOCK)
                .add(Blocks.CHISELED_RED_SANDSTONE)
                .add(Blocks.CHISELED_DEEPSLATE)
                .add(Blocks.CHISELED_SANDSTONE)
                .add(Blocks.CHISELED_NETHER_BRICKS)
                .add(Blocks.CHISELED_POLISHED_BLACKSTONE)
                .add(Blocks.CHISELED_STONE_BRICKS)
                .add(Blocks.INFESTED_CHISELED_STONE_BRICKS)
                .add(Blocks.CHISELED_BOOKSHELF)

                .add(Blocks.SMOOTH_QUARTZ)
                .add(Blocks.SMOOTH_QUARTZ_SLAB)
                .add(Blocks.SMOOTH_QUARTZ_STAIRS)
                .add(Blocks.SMOOTH_RED_SANDSTONE)
                .add(Blocks.SMOOTH_RED_SANDSTONE_SLAB)
                .add(Blocks.SMOOTH_RED_SANDSTONE_STAIRS)
                .add(Blocks.SMOOTH_BASALT)
                .add(Blocks.SMOOTH_SANDSTONE)
                .add(Blocks.SMOOTH_SANDSTONE_SLAB)
                .add(Blocks.SMOOTH_SANDSTONE_STAIRS)
                .add(Blocks.SMOOTH_STONE)
                .add(Blocks.SMOOTH_STONE_SLAB)

                .add(Blocks.WHITE_GLAZED_TERRACOTTA)
                .add(Blocks.ORANGE_GLAZED_TERRACOTTA)
                .add(Blocks.MAGENTA_GLAZED_TERRACOTTA)
                .add(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA)
                .add(Blocks.YELLOW_GLAZED_TERRACOTTA)
                .add(Blocks.LIME_GLAZED_TERRACOTTA)
                .add(Blocks.PINK_GLAZED_TERRACOTTA)
                .add(Blocks.GRAY_GLAZED_TERRACOTTA)
                .add(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA)
                .add(Blocks.CYAN_GLAZED_TERRACOTTA)
                .add(Blocks.PURPLE_GLAZED_TERRACOTTA)
                .add(Blocks.BLUE_GLAZED_TERRACOTTA)
                .add(Blocks.BROWN_GLAZED_TERRACOTTA)
                .add(Blocks.GREEN_GLAZED_TERRACOTTA)
                .add(Blocks.RED_GLAZED_TERRACOTTA)
                .add(Blocks.BLACK_GLAZED_TERRACOTTA);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK,
                new Identifier("fabric", "needs_tool_level_4")));

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(TeadBlocks.RUBY_ORE)
                .add(TeadBlocks.DEEPSLATE_RUBY_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(TeadBlocks.BLOCK_OF_RUBY)
                .add(TeadBlocks.GOLD_CHAIN)
                .add(TeadBlocks.ROSE_GOLD_CHAIN);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(TeadBlocks.LEAD_ORE)
                .add(TeadBlocks.BLOCK_OF_GALENA);

        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(TeadBlocks.BLOCK_OF_RUBY)
                .add(TeadBlocks.BLOCK_OF_LEAD)
                .add(Blocks.COPPER_BLOCK)
                .add(Blocks.WAXED_COPPER_BLOCK)
                .add(Blocks.CUT_COPPER)
                .add(Blocks.WAXED_CUT_COPPER)
                .add(Blocks.EXPOSED_COPPER)
                .add(Blocks.WAXED_EXPOSED_COPPER)
                .add(Blocks.EXPOSED_CUT_COPPER)
                .add(Blocks.WAXED_EXPOSED_CUT_COPPER)
                .add(Blocks.WEATHERED_COPPER)
                .add(Blocks.WAXED_WEATHERED_COPPER)
                .add(Blocks.WEATHERED_CUT_COPPER)
                .add(Blocks.WAXED_WEATHERED_CUT_COPPER)
                .add(Blocks.OXIDIZED_COPPER)
                .add(Blocks.WAXED_OXIDIZED_COPPER)
                .add(Blocks.OXIDIZED_CUT_COPPER)
                .add(Blocks.WAXED_OXIDIZED_CUT_COPPER);
    }
}
