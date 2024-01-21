package net.pythonbear.tead.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
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
