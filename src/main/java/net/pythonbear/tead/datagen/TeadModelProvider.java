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
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.LEAD_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.RAW_LEAD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.LEAD_BLOCK);
        BlockStateModelGenerator.BlockTexturePool leadCutPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(TeadBlocks.LEAD_CUT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.LEAD_TILED_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.ROSE_GOLD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.WHITE_GOLD_NETHER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.WHITE_GOLD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.BRASS_BLOCK);
        BlockStateModelGenerator.BlockTexturePool brassCutPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(TeadBlocks.BRASS_CUT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.BRONZE_BLOCK);
        BlockStateModelGenerator.BlockTexturePool bronzeCutPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(TeadBlocks.BRONZE_CUT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.STEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.DEEPSLATE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.ROSE_NETHERITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.WHITE_NETHERITE_BLOCK);

        leadCutPool.slab(TeadBlocks.LEAD_CUT_SLAB);
        leadCutPool.stairs(TeadBlocks.LEAD_CUT_STAIRS);
        brassCutPool.slab(TeadBlocks.BRASS_CUT_SLAB);
        brassCutPool.stairs(TeadBlocks.BRASS_CUT_STAIRS);
        bronzeCutPool.slab(TeadBlocks.BRONZE_CUT_SLAB);
        bronzeCutPool.stairs(TeadBlocks.BRONZE_CUT_STAIRS);

        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.SLUDGE);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.DARK_BRICKS);

        blockStateModelGenerator.registerCubeWithCustomTextures(TeadBlocks.LEAD_CHISELED_BLOCK, TeadBlocks.LEAD_BLOCK,
                (block, block2) -> {
                    TextureMap textureMap = new TextureMap();

                    textureMap.put(TextureKey.UP, new Identifier("tead:block/lead_block"));
                    textureMap.put(TextureKey.DOWN, new Identifier("tead:block/lead_block"));
                    textureMap.put(TextureKey.NORTH, new Identifier("tead:block/lead_chiseled_block"));
                    textureMap.put(TextureKey.EAST, new Identifier("tead:block/lead_chiseled_block"));
                    textureMap.put(TextureKey.SOUTH, new Identifier("tead:block/lead_chiseled_block"));
                    textureMap.put(TextureKey.WEST, new Identifier("tead:block/lead_chiseled_block"));
                    textureMap.put(TextureKey.PARTICLE, new Identifier("tead:block/lead_chiseled_block"));

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
        blockStateModelGenerator.registerCubeWithCustomTextures(TeadBlocks.SMELTER, TeadBlocks.SMELTER,
                (block, block2) -> {
                    TextureMap textureMap = new TextureMap();

                    textureMap.put(TextureKey.UP, new Identifier("tead:block/smelter_top"));
                    textureMap.put(TextureKey.DOWN, new Identifier("block/copper_block"));
                    textureMap.put(TextureKey.NORTH, new Identifier("tead:block/smelter_front_off"));
                    textureMap.put(TextureKey.EAST, new Identifier("tead:block/smelter_side"));
                    textureMap.put(TextureKey.SOUTH, new Identifier("tead:block/smelter_side"));
                    textureMap.put(TextureKey.WEST, new Identifier("tead:block/smelter_side"));
                    textureMap.put(TextureKey.PARTICLE, new Identifier("tead:block/smelter_side"));

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
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_BROADSWORD, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_CRESCENT_DAGGER, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_GLAIVE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_GREAT_SWORD, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_HIGHLAND_AXE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_HIGHLAND_DOUBLE_AXE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_HOLLOW_DAGGER, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_MOUNTAINEER_PICK, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_RANSEUR, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_RAPIER, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_RITE_DAGGER, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_TEMPEST_KNIFE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_TRUTHSEEKER, Models.GENERATED);
        itemModelGenerator.register(TeadItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(TeadItems.RUBY_INGOT, Models.GENERATED);
        itemModelGenerator.register(TeadItems.OBSIDIAN_SHARD, Models.GENERATED);
        itemModelGenerator.register(TeadItems.OBSIDIAN_INGOT, Models.GENERATED);
        itemModelGenerator.register(TeadItems.LEAD_INGOT, Models.GENERATED);
        itemModelGenerator.register(TeadItems.LEAD_NUGGET, Models.GENERATED);
        itemModelGenerator.register(TeadItems.COPPER_NUGGET, Models.GENERATED);
        itemModelGenerator.register(TeadItems.ROSE_GOLD_INGOT, Models.GENERATED);
        itemModelGenerator.register(TeadItems.ROSE_GOLD_NUGGET, Models.GENERATED);
        itemModelGenerator.register(TeadItems.WHITE_GOLD_INGOT, Models.GENERATED);
        itemModelGenerator.register(TeadItems.WHITE_GOLD_NUGGET, Models.GENERATED);
        itemModelGenerator.register(TeadItems.BRASS_INGOT, Models.GENERATED);
        itemModelGenerator.register(TeadItems.BRASS_NUGGET, Models.GENERATED);
        itemModelGenerator.register(TeadItems.BRONZE_INGOT, Models.GENERATED);
        itemModelGenerator.register(TeadItems.BRONZE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(TeadItems.STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(TeadItems.STEEL_NUGGET, Models.GENERATED);
        itemModelGenerator.register(TeadItems.ROSE_NETHERITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(TeadItems.WHITE_NETHERITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(TeadItems.LEAD_BULLET, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SHOTGUN_PROJECTILE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.JERKY, Models.GENERATED);
        itemModelGenerator.register(TeadItems.HANDLE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.TNT_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.TORCH_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.REDSTONE_TORCH_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SOUL_TORCH_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.BORING_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.COPPER_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.OBSIDIAN_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.RUBY_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.AMETHYST_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.ENDER_PEARL_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.GALENA, Models.GENERATED);
        itemModelGenerator.register(TeadItems.LEAD_APPLE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.ROCK, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SLATE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.BLACK_ROCK, Models.GENERATED);
        itemModelGenerator.register(TeadItems.MUDDY_CLAY_BALL, Models.GENERATED);
        itemModelGenerator.register(TeadItems.DARK_BRICK, Models.GENERATED);

        itemModelGenerator.register(TeadItems.GRENADE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SHURIKEN, Models.GENERATED);

//        itemModelGenerator.register(TeadItems.LIGHTNING_STAFF, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.FROST_CLAYMORE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.SINISTER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.GRAVITY_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STARLESS_NIGHT, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BONE_CLUB, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRONZE_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRONZE_CLAYMORE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRONZE_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRONZE_DOUBLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRONZE_GREATSWORD, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRONZE_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRONZE_HOE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRONZE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRONZE_RAPIER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRONZE_SCYTHE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRONZE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRONZE_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRONZE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.DIAMOND_DOUBLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.DIAMOND_GREATSWORD, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.DIAMOND_SICKLE, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_BROADSWORD, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_CRESCENT_DAGGER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_CUTLASS, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_DOUBLE_AXE, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_DOUBLE_HIGHLAND_AXE, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_GLAIVE, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_GREATSWORD, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_HATCHET, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_HIGHLAND_AXE, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_HOLLOW_DAGGER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_KATANA, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_LONGSWORD, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_MATTOCK, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_MOUNTAINEER_PICK, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_RANSEUR, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_RITE_DAGGER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_SICKLE, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_SPEAR, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_TEMPEST_KNIFE, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_TRUTHSEEKER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.IRON_DOUBLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.IRON_GREATSWORD, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.IRON_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.IRON_TEMPEST_KNIFE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_DOUBLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_GREATSWORD, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_HOE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_SWORD, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.NETHERITE_DOUBLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.NETHERITE_GREATSWORD, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.NETHERITE_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_GOLD_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_GOLD_CLAYMORE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_GOLD_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_GOLD_DOUBLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_GOLD_GREATSWORD, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_GOLD_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_GOLD_HOE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_GOLD_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_GOLD_RAPIER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_GOLD_SCYTHE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_GOLD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_GOLD_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_GOLD_SWORD, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.SHOTGUN, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STEEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STEEL_CLAYMORE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STEEL_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STEEL_DOUBLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STEEL_GREATSWORD, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STEEL_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STEEL_HOE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STEEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STEEL_RAPIER, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STEEL_SCYTHE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STEEL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STEEL_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STEEL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STONE_DOUBLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STONE_GREATSWORD, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STONE_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.WOOD_DOUBLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.WOOD_SICKLE, Models.HANDHELD);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRONZE_CHAINMAIL_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRONZE_CHAINMAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRONZE_CHAINMAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRONZE_CHAINMAIL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_HIGHLAND_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_ROYAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_CHAINMAIL_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_CHAINMAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_CHAINMAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_CHAINMAIL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_GARMENT_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_GARMENT_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_HIGHLAND_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_ROYAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_REINFORCED_MAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_SPANGENHELM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_MERCENARY_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_REINFORCED_MAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_HIGHLAND_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_ROYAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_HIGHLAND_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_ROYAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_GOLD_CHAINMAIL_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_GOLD_CHAINMAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_GOLD_CHAINMAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_GOLD_CHAINMAIL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.STEEL_CHAINMAIL_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.STEEL_CHAINMAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.STEEL_CHAINMAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.STEEL_CHAINMAIL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.SWIFTNESS_BOOTS));
//        itemModelGenerator.register(TeadItems.BATTLE_STAFF, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.CORAL_DAGGER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.DIAMOND_CLAYMORE, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.DIAMOND_DAGGER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.DIAMOND_HAMMER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.DIAMOND_RAPIER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.DIAMOND_SCYTHE, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_CLAYMORE, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_DAGGER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_HAMMER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_RAPIER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.GOLD_SCYTHE, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.IRON_CLAYMORE, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.IRON_DAGGER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.IRON_HAMMER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.IRON_RAPIER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.IRON_SCYTHE, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.LEAD_CLAYMORE, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.LEAD_DAGGER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.LEAD_HAMMER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.LEAD_RAPIER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.LEAD_SCYTHE, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.NETHERITE_CLAYMORE, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.NETHERITE_DAGGER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.NETHERITE_HAMMER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.NETHERITE_RAPIER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.NETHERITE_SCYTHE, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.OBSIDIAN_CLAYMORE, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.QUARTERSTAFF, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.STONE_DAGGER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.STONE_HAMMER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.STONE_RAPIER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.STONE_SCYTHE, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.WOOD_DAGGER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.WOOD_HAMMER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.WOOD_RAPIER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.WOOD_SCYTHE, Models.HANDHELD);
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_HIGHLAND_CHESTPLATE));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_PLATE_BOOTS));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_PLATE_CHESTPLATE));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_PLATE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_GHOSTLY_BOOTS));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_GHOSTLY_CHESTPLATE));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_GHOSTLY_HELMET));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_GUARD_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_GUARD_HELMET));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_HIGHLAND_CHESTPLATE));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_PLATE_BOOTS));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_PLATE_CHESTPLATE));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_PLATE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_THIEF_CHESTPLATE));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_THIEF_HELMET));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_WOOLEN_BOOTS));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_WOOLEN_CHESTPLATE));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_WOOLEN_HELMET));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_WOOLEN_LEGGINGS));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_HIGHLAND_CHESTPLATE));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_PLATE_BOOTS));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_PLATE_CHESTPLATE));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_PLATE_HELMET));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_HIGHLAND_CHESTPLATE));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_PLATE_BOOTS));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_PLATE_CHESTPLATE));
//        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_PLATE_HELMET));

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
