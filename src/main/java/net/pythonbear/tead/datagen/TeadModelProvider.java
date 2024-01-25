package net.pythonbear.tead.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.init.TeadBlocks;
import net.pythonbear.tead.init.TeadItems;

public class TeadModelProvider extends FabricModelProvider {
    public TeadModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.LEAD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.BLOCK_OF_LEAD);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.BLOCK_OF_RUBY);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.BLOCK_OF_GALENA);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.DEEPSLATE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.DRY_DIRT);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.DARK_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.DARK_COBBLESTONE);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.DIRTY_COBBLESTONE);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.DIRTY_STONE_PLAQUE);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.STONE_PLAQUE);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.SLUDGE);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.SANDY_COBBLESTONE);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.VERY_SANDY_COBBLESTONE);

        blockStateModelGenerator.registerCubeWithCustomTextures(TeadBlocks.SPARSE_GRASS, TeadBlocks.DRY_DIRT,
                (block, block2) -> {
                    TextureMap textureMap = new TextureMap();

                    textureMap.put(TextureKey.UP, new Identifier("tead:block/sparse_grass_top"));
                    textureMap.put(TextureKey.DOWN, new Identifier("tead:block/dry_dirt"));
                    textureMap.put(TextureKey.NORTH, new Identifier("tead:block/dry_dirt"));
                    textureMap.put(TextureKey.EAST, new Identifier("tead:block/dry_dirt"));
                    textureMap.put(TextureKey.SOUTH, new Identifier("tead:block/dry_dirt"));
                    textureMap.put(TextureKey.WEST, new Identifier("tead:block/dry_dirt"));
                    textureMap.put(TextureKey.PARTICLE, new Identifier("tead:block/dry_dirt"));

                    return textureMap;
                });
        blockStateModelGenerator.registerCubeWithCustomTextures(TeadBlocks.VERY_SPARSE_GRASS, TeadBlocks.DRY_DIRT,
                (block, block2) -> {
                    TextureMap textureMap = new TextureMap();

                    textureMap.put(TextureKey.UP, new Identifier("tead:block/very_sparse_grass_top"));
                    textureMap.put(TextureKey.DOWN, new Identifier("tead:block/dry_dirt"));
                    textureMap.put(TextureKey.NORTH, new Identifier("tead:block/dry_dirt"));
                    textureMap.put(TextureKey.EAST, new Identifier("tead:block/dry_dirt"));
                    textureMap.put(TextureKey.SOUTH, new Identifier("tead:block/dry_dirt"));
                    textureMap.put(TextureKey.WEST, new Identifier("tead:block/dry_dirt"));
                    textureMap.put(TextureKey.PARTICLE, new Identifier("tead:block/dry_dirt"));

                    return textureMap;
                });
        blockStateModelGenerator.registerCubeWithCustomTextures(TeadBlocks.DRY_GRASS, TeadBlocks.DRY_DIRT,
                (block, block2) -> {
                    TextureMap textureMap = new TextureMap();

                    textureMap.put(TextureKey.UP, new Identifier("tead:block/dry_grass_top"));
                    textureMap.put(TextureKey.DOWN, new Identifier("tead:block/dry_dirt"));
                    textureMap.put(TextureKey.NORTH, new Identifier("tead:block/dry_grass_side"));
                    textureMap.put(TextureKey.EAST, new Identifier("tead:block/dry_grass_side"));
                    textureMap.put(TextureKey.SOUTH, new Identifier("tead:block/dry_grass_side"));
                    textureMap.put(TextureKey.WEST, new Identifier("tead:block/dry_grass_side"));
                    textureMap.put(TextureKey.PARTICLE, new Identifier("tead:block/dry_grass_side"));

                    return textureMap;
                });
        blockStateModelGenerator.registerCubeWithCustomTextures(TeadBlocks.BROWN_DRY_GRASS, TeadBlocks.DRY_DIRT,
                (block, block2) -> {
                    TextureMap textureMap = new TextureMap();

                    textureMap.put(TextureKey.UP, new Identifier("tead:block/brown_dry_grass_top"));
                    textureMap.put(TextureKey.DOWN, new Identifier("tead:block/dry_dirt"));
                    textureMap.put(TextureKey.NORTH, new Identifier("tead:block/brown_dry_grass_side"));
                    textureMap.put(TextureKey.EAST, new Identifier("tead:block/brown_dry_grass_side"));
                    textureMap.put(TextureKey.SOUTH, new Identifier("tead:block/brown_dry_grass_side"));
                    textureMap.put(TextureKey.WEST, new Identifier("tead:block/brown_dry_grass_side"));
                    textureMap.put(TextureKey.PARTICLE, new Identifier("tead:block/brown_dry_grass_side"));

                    return textureMap;
                });
        blockStateModelGenerator.registerCubeWithCustomTextures(TeadBlocks.SICK_PUMPKIN, TeadBlocks.SICK_PUMPKIN,
                (block, block2) -> {
                    TextureMap textureMap = new TextureMap();

                    textureMap.put(TextureKey.UP, new Identifier("tead:block/sick_pumpkin_top"));
                    textureMap.put(TextureKey.DOWN, new Identifier("tead:block/sick_pumpkin_top"));
                    textureMap.put(TextureKey.NORTH, new Identifier("tead:block/sick_pumpkin_side"));
                    textureMap.put(TextureKey.EAST, new Identifier("tead:block/sick_pumpkin_side"));
                    textureMap.put(TextureKey.SOUTH, new Identifier("tead:block/sick_pumpkin_side"));
                    textureMap.put(TextureKey.WEST, new Identifier("tead:block/sick_pumpkin_side"));
                    textureMap.put(TextureKey.PARTICLE, new Identifier("tead:block/sick_pumpkin_side"));

                    return textureMap;
                });
        blockStateModelGenerator.registerCubeWithCustomTextures(TeadBlocks.EMPTY_BOOKSHELF, Blocks.OAK_PLANKS,
                (block, block2) -> {
                    TextureMap textureMap = new TextureMap();

                    textureMap.put(TextureKey.UP, new Identifier("block/oak_planks"));
                    textureMap.put(TextureKey.DOWN, new Identifier("block/oak_planks"));
                    textureMap.put(TextureKey.NORTH, new Identifier("tead:block/empty_bookshelf"));
                    textureMap.put(TextureKey.EAST, new Identifier("tead:block/empty_bookshelf"));
                    textureMap.put(TextureKey.SOUTH, new Identifier("tead:block/empty_bookshelf"));
                    textureMap.put(TextureKey.WEST, new Identifier("tead:block/empty_bookshelf"));
                    textureMap.put(TextureKey.PARTICLE, new Identifier("tead:block/empty_bookshelf"));

                    return textureMap;
                });
        blockStateModelGenerator.registerCubeWithCustomTextures(TeadBlocks.OLD_BOOKSHELF, Blocks.OAK_PLANKS,
                (block, block2) -> {
                    TextureMap textureMap = new TextureMap();

                    textureMap.put(TextureKey.UP, new Identifier("block/oak_planks"));
                    textureMap.put(TextureKey.DOWN, new Identifier("block/oak_planks"));
                    textureMap.put(TextureKey.NORTH, new Identifier("tead:block/old_bookshelf"));
                    textureMap.put(TextureKey.EAST, new Identifier("tead:block/old_bookshelf"));
                    textureMap.put(TextureKey.SOUTH, new Identifier("tead:block/old_bookshelf"));
                    textureMap.put(TextureKey.WEST, new Identifier("tead:block/old_bookshelf"));
                    textureMap.put(TextureKey.PARTICLE, new Identifier("tead:block/old_bookshelf"));

                    return textureMap;
                });
        blockStateModelGenerator.registerCubeWithCustomTextures(TeadBlocks.CLAYISH_MUD, TeadBlocks.CLAYISH_MUD,
                (block, block2) -> {
                    TextureMap textureMap = new TextureMap();

                    textureMap.put(TextureKey.UP, new Identifier("tead:block/clayish_mud_top"));
                    textureMap.put(TextureKey.DOWN, new Identifier("tead:block/clayish_mud_top"));
                    textureMap.put(TextureKey.NORTH, new Identifier("tead:block/clayish_mud_side"));
                    textureMap.put(TextureKey.EAST, new Identifier("tead:block/clayish_mud_side"));
                    textureMap.put(TextureKey.SOUTH, new Identifier("tead:block/clayish_mud_side"));
                    textureMap.put(TextureKey.WEST, new Identifier("tead:block/clayish_mud_side"));
                    textureMap.put(TextureKey.PARTICLE, new Identifier("tead:block/clayish_mud_side"));

                    return textureMap;
                });
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(TeadItems.FABRIC, Models.GENERATED);
        itemModelGenerator.register(TeadItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(TeadItems.OBSIDIAN_SHARD, Models.GENERATED);
        itemModelGenerator.register(TeadItems.LEAD_INGOT, Models.GENERATED);
        itemModelGenerator.register(TeadItems.LEAD_NUGGET, Models.GENERATED);
        itemModelGenerator.register(TeadItems.LEAD_BULLET, Models.GENERATED);
        itemModelGenerator.register(TeadItems.JERKY, Models.GENERATED);
        itemModelGenerator.register(TeadItems.HANDLE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.TNT_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.BORING_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.COPPER_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.OBSIDIAN_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.RUBY_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.AMETHYST_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.ENDER_PEARL_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.GALENA, Models.GENERATED);
        itemModelGenerator.register(TeadItems.LEAD_APPLE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.MUDDY_CLAY_BALL, Models.GENERATED);
        itemModelGenerator.register(TeadItems.DARK_BRICK, Models.GENERATED);

        itemModelGenerator.register(TeadItems.GRENADE, Models.GENERATED);

        itemModelGenerator.register(TeadItems.LIGHTNING_STAFF, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_HOE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_SWORD, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.WOOD_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STONE_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.GOLD_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.IRON_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.DIAMOND_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.NETHERITE_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.WOOD_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STONE_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.GOLD_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.IRON_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.IRON_TEMPEST_KNIFE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.DIAMOND_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.NETHERITE_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.WOOD_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STONE_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.GOLD_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.IRON_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.DIAMOND_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.NETHERITE_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.CORAL_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.WOOD_DOUBLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STONE_DOUBLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.GOLD_DOUBLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_DOUBLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.IRON_DOUBLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.DIAMOND_DOUBLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.NETHERITE_DOUBLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_CLAYMORE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.GOLD_CLAYMORE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.IRON_CLAYMORE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.DIAMOND_CLAYMORE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.NETHERITE_CLAYMORE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.OBSIDIAN_CLAYMORE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.OBSIDIAN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BATTLE_STAFF, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.QUARTERSTAFF, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BONE_CLUB, Models.HANDHELD);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.SWIFTNESS_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_CHAINMAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_CHAINMAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_CHAINMAIL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_CHAINMAIL_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_HIGHLAND_HELMET));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_HIGHLAND_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_HIGHLAND_HELMET));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_HIGHLAND_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_HIGHLAND_HELMET));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_HIGHLAND_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_HIGHLAND_HELMET));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_HIGHLAND_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_ROYAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_ROYAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_ROYAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_ROYAL_HELMET));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_PLATE_HELMET));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_PLATE_CHESTPLATE));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_PLATE_BOOTS));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_PLATE_HELMET));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_PLATE_CHESTPLATE));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_PLATE_BOOTS));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_PLATE_HELMET));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_PLATE_CHESTPLATE));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_PLATE_BOOTS));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_PLATE_HELMET));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_PLATE_CHESTPLATE));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_PLATE_BOOTS));

        itemModelGenerator.register(TeadItems.MUSIC_DISC_BATTLE_HYMN, Models.GENERATED);
        itemModelGenerator.register(TeadItems.MUSIC_DISC_DAY_ONE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.MUSIC_DISC_HAIL_AND_KILL, Models.GENERATED);
        itemModelGenerator.register(TeadItems.MUSIC_DISC_HOMELAND, Models.GENERATED);
        itemModelGenerator.register(TeadItems.MUSIC_DISC_LORD_GIVE_ME_A_SIGN, Models.GENERATED);
        itemModelGenerator.register(TeadItems.MUSIC_DISC_LOSE_YOURSELF, Models.GENERATED);
        itemModelGenerator.register(TeadItems.MUSIC_DISC_MUTINY, Models.GENERATED);
        itemModelGenerator.register(TeadItems.MUSIC_DISC_NEVER_GONNA_GIVE_YOU_UP, Models.GENERATED);
        itemModelGenerator.register(TeadItems.MUSIC_DISC_NEVER_GONNA_STOP, Models.GENERATED);
        itemModelGenerator.register(TeadItems.MUSIC_DISC_SWORDS_IN_THE_WIND, Models.GENERATED);
        itemModelGenerator.register(TeadItems.MUSIC_DISC_THE_GODFATHER, Models.GENERATED);
        itemModelGenerator.register(TeadItems.MUSIC_DISC_THE_HEART_ASKS_PLEASURE_FIRST, Models.GENERATED);
        itemModelGenerator.register(TeadItems.MUSIC_DISC_THE_PHANTOM_OF_THE_OPERA, Models.GENERATED);
        itemModelGenerator.register(TeadItems.MUSIC_DISC_TILL_I_COLLAPSE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.MUSIC_DISC_TIME, Models.GENERATED);
        itemModelGenerator.register(TeadItems.MUSIC_DISC_UNTOUCHABLE, Models.GENERATED);
    }
}
