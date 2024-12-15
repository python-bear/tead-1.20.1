package net.pythonbear.tead.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import net.pythonbear.tead.block.TeadBlocks;
import net.pythonbear.tead.item.TeadItems;

import java.util.List;
import java.util.Map;

public class TeadModelProvider extends FabricModelProvider {
    public TeadModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(TeadBlocks.WEAK_COBWEB, BlockStateModelGenerator.TintType.NOT_TINTED, Properties.AGE_3, 0, 1, 2, 3);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.LEAD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.LEAD_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.RAW_LEAD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.LEAD_BLOCK);
        BlockStateModelGenerator.BlockTexturePool leadCutPool = blockStateModelGenerator.registerCubeAllModelTexturePool(TeadBlocks.LEAD_CUT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.LEAD_TILED_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.ROSE_GOLD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.WHITE_GOLD_NETHER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.WHITE_GOLD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.BRASS_BLOCK);
        BlockStateModelGenerator.BlockTexturePool brassCutPool = blockStateModelGenerator.registerCubeAllModelTexturePool(TeadBlocks.BRASS_CUT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.BRONZE_BLOCK);
        BlockStateModelGenerator.BlockTexturePool bronzeCutPool = blockStateModelGenerator.registerCubeAllModelTexturePool(TeadBlocks.BRONZE_CUT_BLOCK);
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
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_STURDY, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_SPOOKY, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_GLAIVE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_HIGHLAND, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_HOLLOW_DAGGER, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_MOUNTAINEER_PICK, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_RANSEUR, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_RAPIER, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_RITE_DAGGER, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_TEMPEST, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_TRUTHSEEKER, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_MERCENARY, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SMITHING_GUIDE_KATANA, Models.GENERATED);

        itemModelGenerator.register(TeadItems.FABRIC, Models.GENERATED);
        itemModelGenerator.register(TeadItems.DIAMOND_CHIP, Models.GENERATED);
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
        itemModelGenerator.register(TeadItems.NETHERITE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(TeadItems.ROSE_NETHERITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(TeadItems.ROSE_NETHERITE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(TeadItems.WHITE_NETHERITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(TeadItems.WHITE_NETHERITE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(TeadItems.JERKY, Models.GENERATED);
        itemModelGenerator.register(TeadItems.BUFFERED_PEARL, Models.GENERATED);
        itemModelGenerator.register(TeadItems.GRAVITY_PEARL, Models.GENERATED);
        itemModelGenerator.register(TeadItems.TRANSMUTATION_GRIMOIRE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.HANDLE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.GALENA, Models.GENERATED);
        itemModelGenerator.register(TeadItems.WHITE_GOLD_POTATO, Models.GENERATED);
        itemModelGenerator.register(TeadItems.ROSE_GOLD_BEETROOT, Models.GENERATED);
        itemModelGenerator.register(TeadItems.LEAD_APPLE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.ROCK, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SLATE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.BLACK_ROCK, Models.GENERATED);
        itemModelGenerator.register(TeadItems.MUDDY_CLAY_BALL, Models.GENERATED);
        itemModelGenerator.register(TeadItems.DARK_BRICK, Models.GENERATED);

        itemModelGenerator.register(TeadItems.TNT_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.TORCH_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.REDSTONE_TORCH_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SOUL_TORCH_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.BORING_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.COPPER_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.OBSIDIAN_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.RUBY_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.TRANSMORPHING_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.AMETHYST_ARROW, Models.GENERATED);
        itemModelGenerator.register(TeadItems.ENDER_PEARL_ARROW, Models.GENERATED);

        itemModelGenerator.register(TeadItems.GRENADE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SHURIKEN, Models.GENERATED);

        itemModelGenerator.register(TeadItems.FRIGID_HILT, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SOUL, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SOUL_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.EXCALIBUR_TOTEM, Models.GENERATED);
        itemModelGenerator.register(TeadItems.SINISTER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STARLESS_NIGHT, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BONE_CLUB, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.BATTLE_STAFF, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.CORAL_DAGGER, Models.HANDHELD);
//        itemModelGenerator.register(TeadItems.QUARTERSTAFF, Models.HANDHELD);

        itemModelGenerator.register(TeadItems.LEAD_HOE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_SWORD, Models.HANDHELD);

        itemModelGenerator.register(TeadItems.COPPER_HOE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.COPPER_SWORD, Models.HANDHELD);

        itemModelGenerator.register(TeadItems.WHITE_GOLD_HOE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.WHITE_GOLD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.WHITE_GOLD_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.WHITE_GOLD_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.WHITE_GOLD_SWORD, Models.HANDHELD);

        itemModelGenerator.register(TeadItems.ROSE_GOLD_HOE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_GOLD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_GOLD_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_GOLD_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_GOLD_SWORD, Models.HANDHELD);

        itemModelGenerator.register(TeadItems.BRASS_HOE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRASS_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRASS_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRASS_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRASS_SWORD, Models.HANDHELD);

        itemModelGenerator.register(TeadItems.BRONZE_HOE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRONZE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRONZE_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRONZE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.BRONZE_SWORD, Models.HANDHELD);

        itemModelGenerator.register(TeadItems.STEEL_HOE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STEEL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STEEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STEEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.STEEL_SWORD, Models.HANDHELD);

        itemModelGenerator.register(TeadItems.WHITE_NETHERITE_HOE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.WHITE_NETHERITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.WHITE_NETHERITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.WHITE_NETHERITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.WHITE_NETHERITE_SWORD, Models.HANDHELD);

        itemModelGenerator.register(TeadItems.ROSE_NETHERITE_HOE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_NETHERITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_NETHERITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_NETHERITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.ROSE_NETHERITE_SWORD, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.SWIFTNESS_BOOTS));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROBE_HELMET), TeadItems.ROBE_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROBE_CHESTPLATE), TeadItems.ROBE_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROBE_BOOTS), TeadItems.ROBE_BOOTS);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GARMENT_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GARMENT_BOOTS));

        itemModelGenerator.register(TeadItems.PLATE_BOOTS, Models.GENERATED);
        itemModelGenerator.register(TeadItems.GHOSTLY_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.PLATE_HELMET, Models.GENERATED);
        itemModelGenerator.register(TeadItems.GUARD_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.THIEF_HELMET, Models.GENERATED);
        itemModelGenerator.register(TeadItems.PLATE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.WOOLEN_HELMET, Models.GENERATED);
        itemModelGenerator.register(TeadItems.HIGHLAND_HELMET, Models.GENERATED);
        itemModelGenerator.register(TeadItems.WOOLEN_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(TeadItems.HIGHLAND_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.THIEF_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.GUARD_HELMET, Models.GENERATED);
        itemModelGenerator.register(TeadItems.WOOLEN_BOOTS, Models.GENERATED);
        itemModelGenerator.register(TeadItems.GHOSTLY_HELMET, Models.GENERATED);
        itemModelGenerator.register(TeadItems.WOOLEN_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(TeadItems.GHOSTLY_BOOTS, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_CHAINMAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_CHAINMAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_CHAINMAIL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_CHAINMAIL_BOOTS));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.GOLD_GUARD_HELMET), TeadItems.GUARD_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.GOLD_GUARD_CHESTPLATE), TeadItems.GUARD_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.GOLD_WOOLEN_HELMET), TeadItems.WOOLEN_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.GOLD_WOOLEN_CHESTPLATE), TeadItems.WOOLEN_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.GOLD_WOOLEN_LEGGINGS), TeadItems.WOOLEN_LEGGINGS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.GOLD_WOOLEN_BOOTS), TeadItems.WOOLEN_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.GOLD_THIEF_HELMET), TeadItems.THIEF_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.GOLD_THIEF_CHESTPLATE), TeadItems.THIEF_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_REINFORCED_MAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_REINFORCED_MAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_SPANGENHELM_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.GOLD_HIGHLAND_HELMET), TeadItems.HIGHLAND_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.GOLD_HIGHLAND_CHESTPLATE), TeadItems.HIGHLAND_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_ROYAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.GOLD_MERCENARY_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.GOLD_PLATE_HELMET), TeadItems.PLATE_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.GOLD_PLATE_CHESTPLATE), TeadItems.PLATE_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.GOLD_PLATE_BOOTS), TeadItems.PLATE_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.GOLD_GHOSTLY_HELMET), TeadItems.GHOSTLY_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.GOLD_GHOSTLY_CHESTPLATE), TeadItems.GHOSTLY_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.GOLD_GHOSTLY_BOOTS), TeadItems.GHOSTLY_BOOTS);

        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.LEAD_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.LEAD_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.LEAD_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.LEAD_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.LEAD_CHAINMAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.LEAD_CHAINMAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.LEAD_CHAINMAIL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.LEAD_CHAINMAIL_BOOTS));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.LEAD_GUARD_HELMET), TeadItems.GUARD_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.LEAD_GUARD_CHESTPLATE), TeadItems.GUARD_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.LEAD_WOOLEN_HELMET), TeadItems.WOOLEN_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.LEAD_WOOLEN_CHESTPLATE), TeadItems.WOOLEN_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.LEAD_WOOLEN_LEGGINGS), TeadItems.WOOLEN_LEGGINGS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.LEAD_WOOLEN_BOOTS), TeadItems.WOOLEN_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.LEAD_THIEF_HELMET), TeadItems.THIEF_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.LEAD_THIEF_CHESTPLATE), TeadItems.THIEF_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.LEAD_REINFORCED_MAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.LEAD_REINFORCED_MAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.LEAD_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.LEAD_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.LEAD_SPANGENHELM_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.LEAD_HIGHLAND_HELMET), TeadItems.HIGHLAND_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.LEAD_HIGHLAND_CHESTPLATE), TeadItems.HIGHLAND_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.LEAD_ROYAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.LEAD_MERCENARY_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.LEAD_PLATE_HELMET), TeadItems.PLATE_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.LEAD_PLATE_CHESTPLATE), TeadItems.PLATE_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.LEAD_PLATE_BOOTS), TeadItems.PLATE_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.LEAD_GHOSTLY_HELMET), TeadItems.GHOSTLY_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.LEAD_GHOSTLY_CHESTPLATE), TeadItems.GHOSTLY_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.LEAD_GHOSTLY_BOOTS), TeadItems.GHOSTLY_BOOTS);

        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.COPPER_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.COPPER_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.COPPER_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.COPPER_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.COPPER_CHAINMAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.COPPER_CHAINMAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.COPPER_CHAINMAIL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.COPPER_CHAINMAIL_BOOTS));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.COPPER_GUARD_HELMET), TeadItems.GUARD_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.COPPER_GUARD_CHESTPLATE), TeadItems.GUARD_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.COPPER_WOOLEN_HELMET), TeadItems.WOOLEN_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.COPPER_WOOLEN_CHESTPLATE), TeadItems.WOOLEN_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.COPPER_WOOLEN_LEGGINGS), TeadItems.WOOLEN_LEGGINGS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.COPPER_WOOLEN_BOOTS), TeadItems.WOOLEN_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.COPPER_THIEF_HELMET), TeadItems.THIEF_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.COPPER_THIEF_CHESTPLATE), TeadItems.THIEF_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.COPPER_REINFORCED_MAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.COPPER_REINFORCED_MAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.COPPER_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.COPPER_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.COPPER_SPANGENHELM_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.COPPER_HIGHLAND_HELMET), TeadItems.HIGHLAND_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.COPPER_HIGHLAND_CHESTPLATE), TeadItems.HIGHLAND_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.COPPER_ROYAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.COPPER_MERCENARY_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.COPPER_PLATE_HELMET), TeadItems.PLATE_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.COPPER_PLATE_CHESTPLATE), TeadItems.PLATE_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.COPPER_PLATE_BOOTS), TeadItems.PLATE_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.COPPER_GHOSTLY_HELMET), TeadItems.GHOSTLY_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.COPPER_GHOSTLY_CHESTPLATE), TeadItems.GHOSTLY_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.COPPER_GHOSTLY_BOOTS), TeadItems.GHOSTLY_BOOTS);

        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_GOLD_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_GOLD_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_GOLD_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_GOLD_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_GOLD_CHAINMAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_GOLD_CHAINMAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_GOLD_CHAINMAIL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_GOLD_CHAINMAIL_BOOTS));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_GOLD_GUARD_HELMET), TeadItems.GUARD_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_GOLD_GUARD_CHESTPLATE), TeadItems.GUARD_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_GOLD_WOOLEN_HELMET), TeadItems.WOOLEN_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_GOLD_WOOLEN_CHESTPLATE), TeadItems.WOOLEN_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_GOLD_WOOLEN_LEGGINGS), TeadItems.WOOLEN_LEGGINGS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_GOLD_WOOLEN_BOOTS), TeadItems.WOOLEN_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_GOLD_THIEF_HELMET), TeadItems.THIEF_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_GOLD_THIEF_CHESTPLATE), TeadItems.THIEF_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_GOLD_REINFORCED_MAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_GOLD_REINFORCED_MAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_GOLD_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_GOLD_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_GOLD_SPANGENHELM_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_GOLD_HIGHLAND_HELMET), TeadItems.HIGHLAND_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_GOLD_HIGHLAND_CHESTPLATE), TeadItems.HIGHLAND_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_GOLD_ROYAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_GOLD_MERCENARY_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_GOLD_PLATE_HELMET), TeadItems.PLATE_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_GOLD_PLATE_CHESTPLATE), TeadItems.PLATE_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_GOLD_PLATE_BOOTS), TeadItems.PLATE_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_GOLD_GHOSTLY_HELMET), TeadItems.GHOSTLY_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_GOLD_GHOSTLY_CHESTPLATE), TeadItems.GHOSTLY_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_GOLD_GHOSTLY_BOOTS), TeadItems.GHOSTLY_BOOTS);

        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_GOLD_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_GOLD_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_GOLD_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_GOLD_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_GOLD_CHAINMAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_GOLD_CHAINMAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_GOLD_CHAINMAIL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_GOLD_CHAINMAIL_BOOTS));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_GOLD_GUARD_HELMET), TeadItems.GUARD_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_GOLD_GUARD_CHESTPLATE), TeadItems.GUARD_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_GOLD_WOOLEN_HELMET), TeadItems.WOOLEN_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_GOLD_WOOLEN_CHESTPLATE), TeadItems.WOOLEN_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_GOLD_WOOLEN_LEGGINGS), TeadItems.WOOLEN_LEGGINGS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_GOLD_WOOLEN_BOOTS), TeadItems.WOOLEN_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_GOLD_THIEF_HELMET), TeadItems.THIEF_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_GOLD_THIEF_CHESTPLATE), TeadItems.THIEF_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_GOLD_REINFORCED_MAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_GOLD_REINFORCED_MAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_GOLD_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_GOLD_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_GOLD_SPANGENHELM_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_GOLD_HIGHLAND_HELMET), TeadItems.HIGHLAND_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_GOLD_HIGHLAND_CHESTPLATE), TeadItems.HIGHLAND_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_GOLD_ROYAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_GOLD_MERCENARY_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_GOLD_PLATE_HELMET), TeadItems.PLATE_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_GOLD_PLATE_CHESTPLATE), TeadItems.PLATE_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_GOLD_PLATE_BOOTS), TeadItems.PLATE_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_GOLD_GHOSTLY_HELMET), TeadItems.GHOSTLY_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_GOLD_GHOSTLY_CHESTPLATE), TeadItems.GHOSTLY_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_GOLD_GHOSTLY_BOOTS), TeadItems.GHOSTLY_BOOTS);

        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.IRON_GUARD_HELMET), TeadItems.GUARD_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.IRON_GUARD_CHESTPLATE), TeadItems.GUARD_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.IRON_WOOLEN_HELMET), TeadItems.WOOLEN_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.IRON_WOOLEN_CHESTPLATE), TeadItems.WOOLEN_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.IRON_WOOLEN_LEGGINGS), TeadItems.WOOLEN_LEGGINGS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.IRON_WOOLEN_BOOTS), TeadItems.WOOLEN_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.IRON_THIEF_HELMET), TeadItems.THIEF_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.IRON_THIEF_CHESTPLATE), TeadItems.THIEF_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_REINFORCED_MAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_REINFORCED_MAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_SPANGENHELM_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.IRON_HIGHLAND_HELMET), TeadItems.HIGHLAND_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.IRON_HIGHLAND_CHESTPLATE), TeadItems.HIGHLAND_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_ROYAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.IRON_MERCENARY_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.IRON_PLATE_HELMET), TeadItems.PLATE_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.IRON_PLATE_CHESTPLATE), TeadItems.PLATE_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.IRON_PLATE_BOOTS), TeadItems.PLATE_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.IRON_GHOSTLY_HELMET), TeadItems.GHOSTLY_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.IRON_GHOSTLY_CHESTPLATE), TeadItems.GHOSTLY_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.IRON_GHOSTLY_BOOTS), TeadItems.GHOSTLY_BOOTS);

        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRASS_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRASS_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRASS_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRASS_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRASS_CHAINMAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRASS_CHAINMAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRASS_CHAINMAIL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRASS_CHAINMAIL_BOOTS));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRASS_GUARD_HELMET), TeadItems.GUARD_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRASS_GUARD_CHESTPLATE), TeadItems.GUARD_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRASS_WOOLEN_HELMET), TeadItems.WOOLEN_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRASS_WOOLEN_CHESTPLATE), TeadItems.WOOLEN_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRASS_WOOLEN_LEGGINGS), TeadItems.WOOLEN_LEGGINGS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRASS_WOOLEN_BOOTS), TeadItems.WOOLEN_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRASS_THIEF_HELMET), TeadItems.THIEF_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRASS_THIEF_CHESTPLATE), TeadItems.THIEF_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRASS_REINFORCED_MAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRASS_REINFORCED_MAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRASS_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRASS_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRASS_SPANGENHELM_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRASS_HIGHLAND_HELMET), TeadItems.HIGHLAND_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRASS_HIGHLAND_CHESTPLATE), TeadItems.HIGHLAND_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRASS_ROYAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRASS_MERCENARY_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRASS_PLATE_HELMET), TeadItems.PLATE_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRASS_PLATE_CHESTPLATE), TeadItems.PLATE_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRASS_PLATE_BOOTS), TeadItems.PLATE_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRASS_GHOSTLY_HELMET), TeadItems.GHOSTLY_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRASS_GHOSTLY_CHESTPLATE), TeadItems.GHOSTLY_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRASS_GHOSTLY_BOOTS), TeadItems.GHOSTLY_BOOTS);

        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRONZE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRONZE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRONZE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRONZE_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRONZE_CHAINMAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRONZE_CHAINMAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRONZE_CHAINMAIL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRONZE_CHAINMAIL_BOOTS));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRONZE_GUARD_HELMET), TeadItems.GUARD_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRONZE_GUARD_CHESTPLATE), TeadItems.GUARD_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRONZE_WOOLEN_HELMET), TeadItems.WOOLEN_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRONZE_WOOLEN_CHESTPLATE), TeadItems.WOOLEN_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRONZE_WOOLEN_LEGGINGS), TeadItems.WOOLEN_LEGGINGS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRONZE_WOOLEN_BOOTS), TeadItems.WOOLEN_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRONZE_THIEF_HELMET), TeadItems.THIEF_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRONZE_THIEF_CHESTPLATE), TeadItems.THIEF_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRONZE_REINFORCED_MAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRONZE_REINFORCED_MAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRONZE_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRONZE_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRONZE_SPANGENHELM_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRONZE_HIGHLAND_HELMET), TeadItems.HIGHLAND_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRONZE_HIGHLAND_CHESTPLATE), TeadItems.HIGHLAND_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRONZE_ROYAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.BRONZE_MERCENARY_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRONZE_PLATE_HELMET), TeadItems.PLATE_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRONZE_PLATE_CHESTPLATE), TeadItems.PLATE_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRONZE_PLATE_BOOTS), TeadItems.PLATE_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRONZE_GHOSTLY_HELMET), TeadItems.GHOSTLY_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRONZE_GHOSTLY_CHESTPLATE), TeadItems.GHOSTLY_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.BRONZE_GHOSTLY_BOOTS), TeadItems.GHOSTLY_BOOTS);

        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.STEEL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.STEEL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.STEEL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.STEEL_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.STEEL_CHAINMAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.STEEL_CHAINMAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.STEEL_CHAINMAIL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.STEEL_CHAINMAIL_BOOTS));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.STEEL_GUARD_HELMET), TeadItems.GUARD_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.STEEL_GUARD_CHESTPLATE), TeadItems.GUARD_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.STEEL_WOOLEN_HELMET), TeadItems.WOOLEN_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.STEEL_WOOLEN_CHESTPLATE), TeadItems.WOOLEN_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.STEEL_WOOLEN_LEGGINGS), TeadItems.WOOLEN_LEGGINGS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.STEEL_WOOLEN_BOOTS), TeadItems.WOOLEN_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.STEEL_THIEF_HELMET), TeadItems.THIEF_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.STEEL_THIEF_CHESTPLATE), TeadItems.THIEF_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.STEEL_REINFORCED_MAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.STEEL_REINFORCED_MAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.STEEL_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.STEEL_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.STEEL_SPANGENHELM_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.STEEL_HIGHLAND_HELMET), TeadItems.HIGHLAND_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.STEEL_HIGHLAND_CHESTPLATE), TeadItems.HIGHLAND_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.STEEL_ROYAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.STEEL_MERCENARY_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.STEEL_PLATE_HELMET), TeadItems.PLATE_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.STEEL_PLATE_CHESTPLATE), TeadItems.PLATE_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.STEEL_PLATE_BOOTS), TeadItems.PLATE_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.STEEL_GHOSTLY_HELMET), TeadItems.GHOSTLY_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.STEEL_GHOSTLY_CHESTPLATE), TeadItems.GHOSTLY_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.STEEL_GHOSTLY_BOOTS), TeadItems.GHOSTLY_BOOTS);

        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.DIAMOND_GUARD_HELMET), TeadItems.GUARD_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.DIAMOND_GUARD_CHESTPLATE), TeadItems.GUARD_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.DIAMOND_WOOLEN_HELMET), TeadItems.WOOLEN_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.DIAMOND_WOOLEN_CHESTPLATE), TeadItems.WOOLEN_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.DIAMOND_WOOLEN_LEGGINGS), TeadItems.WOOLEN_LEGGINGS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.DIAMOND_WOOLEN_BOOTS), TeadItems.WOOLEN_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.DIAMOND_THIEF_HELMET), TeadItems.THIEF_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.DIAMOND_THIEF_CHESTPLATE), TeadItems.THIEF_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_REINFORCED_MAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_REINFORCED_MAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_SPANGENHELM_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.DIAMOND_HIGHLAND_HELMET), TeadItems.HIGHLAND_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.DIAMOND_HIGHLAND_CHESTPLATE), TeadItems.HIGHLAND_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_ROYAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.DIAMOND_MERCENARY_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.DIAMOND_PLATE_HELMET), TeadItems.PLATE_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.DIAMOND_PLATE_CHESTPLATE), TeadItems.PLATE_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.DIAMOND_PLATE_BOOTS), TeadItems.PLATE_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.DIAMOND_GHOSTLY_HELMET), TeadItems.GHOSTLY_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.DIAMOND_GHOSTLY_CHESTPLATE), TeadItems.GHOSTLY_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.DIAMOND_GHOSTLY_BOOTS), TeadItems.GHOSTLY_BOOTS);

        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.NETHERITE_GUARD_HELMET), TeadItems.GUARD_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.NETHERITE_GUARD_CHESTPLATE), TeadItems.GUARD_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.NETHERITE_WOOLEN_HELMET), TeadItems.WOOLEN_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.NETHERITE_WOOLEN_CHESTPLATE), TeadItems.WOOLEN_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.NETHERITE_WOOLEN_LEGGINGS), TeadItems.WOOLEN_LEGGINGS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.NETHERITE_WOOLEN_BOOTS), TeadItems.WOOLEN_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.NETHERITE_THIEF_HELMET), TeadItems.THIEF_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.NETHERITE_THIEF_CHESTPLATE), TeadItems.THIEF_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_REINFORCED_MAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_REINFORCED_MAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_SPANGENHELM_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.NETHERITE_HIGHLAND_HELMET), TeadItems.HIGHLAND_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.NETHERITE_HIGHLAND_CHESTPLATE), TeadItems.HIGHLAND_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_ROYAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.NETHERITE_MERCENARY_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.NETHERITE_PLATE_HELMET), TeadItems.PLATE_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.NETHERITE_PLATE_CHESTPLATE), TeadItems.PLATE_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.NETHERITE_PLATE_BOOTS), TeadItems.PLATE_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.NETHERITE_GHOSTLY_HELMET), TeadItems.GHOSTLY_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.NETHERITE_GHOSTLY_CHESTPLATE), TeadItems.GHOSTLY_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.NETHERITE_GHOSTLY_BOOTS), TeadItems.GHOSTLY_BOOTS);

        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_NETHERITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_NETHERITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_NETHERITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_NETHERITE_BOOTS));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_NETHERITE_GUARD_HELMET), TeadItems.GUARD_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_NETHERITE_GUARD_CHESTPLATE), TeadItems.GUARD_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_NETHERITE_WOOLEN_HELMET), TeadItems.WOOLEN_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_NETHERITE_WOOLEN_CHESTPLATE), TeadItems.WOOLEN_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_NETHERITE_WOOLEN_LEGGINGS), TeadItems.WOOLEN_LEGGINGS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_NETHERITE_WOOLEN_BOOTS), TeadItems.WOOLEN_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_NETHERITE_THIEF_HELMET), TeadItems.THIEF_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_NETHERITE_THIEF_CHESTPLATE), TeadItems.THIEF_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_NETHERITE_REINFORCED_MAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_NETHERITE_REINFORCED_MAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_NETHERITE_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_NETHERITE_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_NETHERITE_SPANGENHELM_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_NETHERITE_HIGHLAND_HELMET), TeadItems.HIGHLAND_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_NETHERITE_HIGHLAND_CHESTPLATE), TeadItems.HIGHLAND_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_NETHERITE_ROYAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.ROSE_NETHERITE_MERCENARY_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_NETHERITE_PLATE_HELMET), TeadItems.PLATE_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_NETHERITE_PLATE_CHESTPLATE), TeadItems.PLATE_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_NETHERITE_PLATE_BOOTS), TeadItems.PLATE_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_NETHERITE_GHOSTLY_HELMET), TeadItems.GHOSTLY_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_NETHERITE_GHOSTLY_CHESTPLATE), TeadItems.GHOSTLY_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.ROSE_NETHERITE_GHOSTLY_BOOTS), TeadItems.GHOSTLY_BOOTS);

        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_NETHERITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_NETHERITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_NETHERITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_NETHERITE_BOOTS));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_NETHERITE_GUARD_HELMET), TeadItems.GUARD_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_NETHERITE_GUARD_CHESTPLATE), TeadItems.GUARD_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_NETHERITE_WOOLEN_HELMET), TeadItems.WOOLEN_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_NETHERITE_WOOLEN_CHESTPLATE), TeadItems.WOOLEN_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_NETHERITE_WOOLEN_LEGGINGS), TeadItems.WOOLEN_LEGGINGS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_NETHERITE_WOOLEN_BOOTS), TeadItems.WOOLEN_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_NETHERITE_THIEF_HELMET), TeadItems.THIEF_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_NETHERITE_THIEF_CHESTPLATE), TeadItems.THIEF_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_NETHERITE_REINFORCED_MAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_NETHERITE_REINFORCED_MAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_NETHERITE_STALWART_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_NETHERITE_STALWART_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_NETHERITE_SPANGENHELM_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_NETHERITE_HIGHLAND_HELMET), TeadItems.HIGHLAND_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_NETHERITE_HIGHLAND_CHESTPLATE), TeadItems.HIGHLAND_CHESTPLATE);
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_NETHERITE_ROYAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) TeadItems.WHITE_NETHERITE_MERCENARY_HELMET));
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_NETHERITE_PLATE_HELMET), TeadItems.PLATE_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_NETHERITE_PLATE_CHESTPLATE), TeadItems.PLATE_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_NETHERITE_PLATE_BOOTS), TeadItems.PLATE_BOOTS);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_NETHERITE_GHOSTLY_HELMET), TeadItems.GHOSTLY_HELMET);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_NETHERITE_GHOSTLY_CHESTPLATE), TeadItems.GHOSTLY_CHESTPLATE);
        registerDyeableArmor(itemModelGenerator, ((ArmorItem) TeadItems.WHITE_NETHERITE_GHOSTLY_BOOTS), TeadItems.GHOSTLY_BOOTS);
    }

    public final void registerDyeableArmor(ItemModelGenerator itemModelGenerator, ArmorItem armor, Item baseArmor) {
        Identifier identifier = ModelIds.getItemModelId(armor);
        Identifier identifier2 = TextureMap.getId(baseArmor);
        Identifier identifier3 = TextureMap.getSubId(armor, "_overlay");
        Models.GENERATED_TWO_LAYERS.upload(identifier, TextureMap.layered(identifier2, identifier3), itemModelGenerator.writer, (id, textures) -> itemModelGenerator.createArmorJson(id, textures, armor.getMaterial()));

        for (TrimMaterial trimMaterial : TRIM_MATERIALS) {
            String string = trimMaterial.getAppliedName(armor.getMaterial());
            Identifier identifier4 = itemModelGenerator.suffixTrim(identifier, string);
            String string2 = armor.getType().getName() + "_trim_" + string;
            Identifier identifier5 = new Identifier(string2).withPrefixedPath("trims/items/");
            itemModelGenerator.uploadArmor(identifier4, identifier2, identifier3, identifier5);
        }
    }

    private static final List<TrimMaterial> TRIM_MATERIALS = List.of(new TrimMaterial("quartz", 0.1f, Map.of()), new TrimMaterial("iron", 0.2f, Map.of(ArmorMaterials.IRON, "iron_darker")), new TrimMaterial("netherite", 0.3f, Map.of(ArmorMaterials.NETHERITE, "netherite_darker")), new TrimMaterial("redstone", 0.4f, Map.of()), new TrimMaterial("copper", 0.5f, Map.of()), new TrimMaterial("gold", 0.6f, Map.of(ArmorMaterials.GOLD, "gold_darker")), new TrimMaterial("emerald", 0.7f, Map.of()), new TrimMaterial("diamond", 0.8f, Map.of(ArmorMaterials.DIAMOND, "diamond_darker")), new TrimMaterial("lapis", 0.9f, Map.of()), new TrimMaterial("amethyst", 1.0f, Map.of()));
    
    record TrimMaterial(String name, float itemModelIndex, Map<ArmorMaterial, String> overrideArmorMaterials) {
        public String getAppliedName(ArmorMaterial armorMaterial) {
            return this.overrideArmorMaterials.getOrDefault(armorMaterial, this.name);
        }
    }
}
