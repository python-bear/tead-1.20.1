package net.pythonbear.tead.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;

public class TeadItemGroups {
    public static final ItemGroup TEAD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Tead.MOD_ID, "tead"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.tead"))
                    .icon(() -> new ItemStack(TeadItems.RUBY)).entries((displayContext, entries) -> {
                        entries.add(TeadItems.RUBY);
                        entries.add(TeadItems.ROCK);
                        entries.add(TeadItems.BLACK_ROCK);
                        entries.add(TeadItems.SLATE);
                        entries.add(TeadItems.OBSIDIAN_SHARD);
                        entries.add(TeadItems.GALENA);
                        entries.add(TeadItems.LEAD_INGOT);
                        entries.add(TeadItems.LEAD_NUGGET);
                        entries.add(TeadItems.STEEL_INGOT);
                        entries.add(TeadItems.STEEL_NUGGET);
                        entries.add(TeadItems.ROSE_GOLD_INGOT);
                        entries.add(TeadItems.ROSE_GOLD_NUGGET);
                        entries.add(TeadItems.BRONZE_INGOT);
                        entries.add(TeadItems.BRONZE_NUGGET);
                        entries.add(TeadItems.COPPER_NUGGET);
                        entries.add(TeadItems.LEAD_BULLET);
                        entries.add(TeadItems.FABRIC);
                        entries.add(TeadItems.HANDLE);
                        entries.add(TeadItems.MUDDY_CLAY_BALL);
                        entries.add(TeadItems.DARK_BRICK);

                        entries.add(TeadItems.AMETHYST_ARROW);
                        entries.add(TeadItems.TORCH_ARROW);
                        entries.add(TeadItems.REDSTONE_TORCH_ARROW);
                        entries.add(TeadItems.SOUL_TORCH_ARROW);
                        entries.add(TeadItems.TNT_ARROW);
                        entries.add(TeadItems.BORING_ARROW);
                        entries.add(TeadItems.COPPER_ARROW);
                        entries.add(TeadItems.ENDER_PEARL_ARROW);
                        entries.add(TeadItems.OBSIDIAN_ARROW);
                        entries.add(TeadItems.RUBY_ARROW);

                        entries.add(TeadItems.JERKY);
                        entries.add(TeadItems.LEAD_APPLE);

                        entries.add(TeadItems.GRENADE);
                        entries.add(TeadItems.SHURIKEN);

                        entries.add(TeadItems.LIGHTNING_STAFF);
                        entries.add(TeadItems.QUARTERSTAFF);
                        entries.add(TeadItems.BATTLE_STAFF);
                        entries.add(TeadItems.BONE_CLUB);

                        entries.add(TeadItems.SHOTGUN);

                        entries.add(TeadItems.BONE_BOW);
                        entries.add(TeadItems.TRICK_BOW);
                        entries.add(TeadItems.WIND_BOW);
                        entries.add(TeadItems.SHORT_BOW);
                        entries.add(TeadItems.LONG_BOW);

                        entries.add(TeadItems.FIREBOLT_THROWER);

                        entries.add(TeadItems.WOOD_HAMMER);
                        entries.add(TeadItems.WOOD_DAGGER);
                        entries.add(TeadItems.WOOD_RAPIER);
                        entries.add(TeadItems.WOOD_DOUBLE_AXE);
                        entries.add(TeadItems.WOOD_SICKLE);
                        entries.add(TeadItems.WOOD_SCYTHE);

                        entries.add(TeadItems.STONE_HAMMER);
                        entries.add(TeadItems.STONE_DAGGER);
                        entries.add(TeadItems.STONE_RAPIER);
                        entries.add(TeadItems.STONE_DOUBLE_AXE);
                        entries.add(TeadItems.STONE_SICKLE);
                        entries.add(TeadItems.STONE_SCYTHE);
                        entries.add(TeadItems.STONE_GREATSWORD);

                        entries.add(TeadItems.LEAD_AXE);
                        entries.add(TeadItems.LEAD_HOE);
                        entries.add(TeadItems.LEAD_PICKAXE);
                        entries.add(TeadItems.LEAD_SHOVEL);
                        entries.add(TeadItems.LEAD_SWORD);
                        entries.add(TeadItems.LEAD_HAMMER);
                        entries.add(TeadItems.LEAD_DAGGER);
                        entries.add(TeadItems.LEAD_RAPIER);
                        entries.add(TeadItems.LEAD_DOUBLE_AXE);
                        entries.add(TeadItems.LEAD_SICKLE);
                        entries.add(TeadItems.LEAD_SCYTHE);
                        entries.add(TeadItems.LEAD_GREATSWORD);
                        entries.add(TeadItems.LEAD_CLAYMORE);

                        entries.add(TeadItems.GOLD_HAMMER);
                        entries.add(TeadItems.GOLD_DAGGER);
                        entries.add(TeadItems.GOLD_RAPIER);
                        entries.add(TeadItems.GOLD_DOUBLE_AXE);
                        entries.add(TeadItems.GOLD_SICKLE);
                        entries.add(TeadItems.GOLD_SCYTHE);
                        entries.add(TeadItems.GOLD_GREATSWORD);
                        entries.add(TeadItems.GOLD_CLAYMORE);

                        entries.add(TeadItems.IRON_HAMMER);
                        entries.add(TeadItems.IRON_DAGGER);
                        entries.add(TeadItems.IRON_RAPIER);
                        entries.add(TeadItems.IRON_DOUBLE_AXE);
                        entries.add(TeadItems.IRON_SICKLE);
                        entries.add(TeadItems.IRON_SCYTHE);
                        entries.add(TeadItems.IRON_TEMPEST_KNIFE);
                        entries.add(TeadItems.IRON_GREATSWORD);
                        entries.add(TeadItems.IRON_CLAYMORE);

                        entries.add(TeadItems.ROSE_GOLD_AXE);
                        entries.add(TeadItems.ROSE_GOLD_PICKAXE);
                        entries.add(TeadItems.ROSE_GOLD_SHOVEL);
                        entries.add(TeadItems.ROSE_GOLD_HOE);
                        entries.add(TeadItems.ROSE_GOLD_SWORD);
                        entries.add(TeadItems.ROSE_GOLD_HAMMER);
                        entries.add(TeadItems.ROSE_GOLD_DAGGER);
                        entries.add(TeadItems.ROSE_GOLD_RAPIER);
                        entries.add(TeadItems.ROSE_GOLD_DOUBLE_AXE);
                        entries.add(TeadItems.ROSE_GOLD_SICKLE);
                        entries.add(TeadItems.ROSE_GOLD_SCYTHE);
                        entries.add(TeadItems.ROSE_GOLD_GREATSWORD);
                        entries.add(TeadItems.ROSE_GOLD_CLAYMORE);

                        entries.add(TeadItems.BRONZE_AXE);
                        entries.add(TeadItems.BRONZE_PICKAXE);
                        entries.add(TeadItems.BRONZE_SHOVEL);
                        entries.add(TeadItems.BRONZE_HOE);
                        entries.add(TeadItems.BRONZE_SWORD);
                        entries.add(TeadItems.BRONZE_HAMMER);
                        entries.add(TeadItems.BRONZE_DAGGER);
                        entries.add(TeadItems.BRONZE_RAPIER);
                        entries.add(TeadItems.BRONZE_DOUBLE_AXE);
                        entries.add(TeadItems.BRONZE_SICKLE);
                        entries.add(TeadItems.BRONZE_SCYTHE);
                        entries.add(TeadItems.BRONZE_GREATSWORD);
                        entries.add(TeadItems.BRONZE_CLAYMORE);

                        entries.add(TeadItems.STEEL_AXE);
                        entries.add(TeadItems.STEEL_PICKAXE);
                        entries.add(TeadItems.STEEL_SHOVEL);
                        entries.add(TeadItems.STEEL_HOE);
                        entries.add(TeadItems.STEEL_SWORD);
                        entries.add(TeadItems.STEEL_HAMMER);
                        entries.add(TeadItems.STEEL_DAGGER);
                        entries.add(TeadItems.STEEL_RAPIER);
                        entries.add(TeadItems.STEEL_DOUBLE_AXE);
                        entries.add(TeadItems.STEEL_SICKLE);
                        entries.add(TeadItems.STEEL_SCYTHE);
                        entries.add(TeadItems.STEEL_GREATSWORD);
                        entries.add(TeadItems.STEEL_CLAYMORE);

                        entries.add(TeadItems.DIAMOND_HAMMER);
                        entries.add(TeadItems.DIAMOND_DAGGER);
                        entries.add(TeadItems.DIAMOND_RAPIER);
                        entries.add(TeadItems.DIAMOND_DOUBLE_AXE);
                        entries.add(TeadItems.DIAMOND_SICKLE);
                        entries.add(TeadItems.DIAMOND_SCYTHE);
                        entries.add(TeadItems.DIAMOND_GREATSWORD);
                        entries.add(TeadItems.DIAMOND_CLAYMORE);

                        entries.add(TeadItems.NETHERITE_HAMMER);
                        entries.add(TeadItems.NETHERITE_DAGGER);
                        entries.add(TeadItems.NETHERITE_RAPIER);
                        entries.add(TeadItems.NETHERITE_DOUBLE_AXE);
                        entries.add(TeadItems.NETHERITE_SICKLE);
                        entries.add(TeadItems.NETHERITE_SCYTHE);
                        entries.add(TeadItems.NETHERITE_GREATSWORD);
                        entries.add(TeadItems.NETHERITE_CLAYMORE);

                        entries.add(TeadItems.CORAL_DAGGER);
                        entries.add(TeadItems.OBSIDIAN_CLAYMORE);
                        entries.add(TeadItems.OBSIDIAN_SWORD);

                        entries.add(TeadItems.SWIFTNESS_BOOTS);
                        entries.add(TeadItems.ROBE_HELMET);
                        entries.add(TeadItems.ROBE_CHESTPLATE);
                        entries.add(TeadItems.ROBE_BOOTS);
                        entries.add(TeadItems.GOLD_CHAINMAIL_HELMET);
                        entries.add(TeadItems.GOLD_CHAINMAIL_CHESTPLATE);
                        entries.add(TeadItems.GOLD_CHAINMAIL_LEGGINGS);
                        entries.add(TeadItems.GOLD_CHAINMAIL_BOOTS);
                        entries.add(TeadItems.GOLD_STALWART_HELMET);
                        entries.add(TeadItems.GOLD_STALWART_CHESTPLATE);
                        entries.add(TeadItems.GOLD_HIGHLAND_HELMET);
                        entries.add(TeadItems.GOLD_HIGHLAND_CHESTPLATE);
                        entries.add(TeadItems.GOLD_ROYAL_HELMET);
                        entries.add(TeadItems.GOLD_PLATE_HELMET);
                        entries.add(TeadItems.GOLD_PLATE_CHESTPLATE);
                        entries.add(TeadItems.GOLD_PLATE_BOOTS);
                        entries.add(TeadItems.ROSE_GOLD_CHAINMAIL_HELMET);
                        entries.add(TeadItems.ROSE_GOLD_CHAINMAIL_CHESTPLATE);
                        entries.add(TeadItems.ROSE_GOLD_CHAINMAIL_LEGGINGS);
                        entries.add(TeadItems.ROSE_GOLD_CHAINMAIL_BOOTS);
                        entries.add(TeadItems.IRON_STALWART_HELMET);
                        entries.add(TeadItems.IRON_STALWART_CHESTPLATE);
                        entries.add(TeadItems.IRON_HIGHLAND_HELMET);
                        entries.add(TeadItems.IRON_HIGHLAND_CHESTPLATE);
                        entries.add(TeadItems.IRON_ROYAL_HELMET);
                        entries.add(TeadItems.IRON_PLATE_HELMET);
                        entries.add(TeadItems.IRON_PLATE_CHESTPLATE);
                        entries.add(TeadItems.IRON_PLATE_BOOTS);
                        entries.add(TeadItems.BRONZE_CHAINMAIL_HELMET);
                        entries.add(TeadItems.BRONZE_CHAINMAIL_CHESTPLATE);
                        entries.add(TeadItems.BRONZE_CHAINMAIL_LEGGINGS);
                        entries.add(TeadItems.BRONZE_CHAINMAIL_BOOTS);
                        entries.add(TeadItems.STEEL_CHAINMAIL_HELMET);
                        entries.add(TeadItems.STEEL_CHAINMAIL_CHESTPLATE);
                        entries.add(TeadItems.STEEL_CHAINMAIL_LEGGINGS);
                        entries.add(TeadItems.STEEL_CHAINMAIL_BOOTS);
                        entries.add(TeadItems.DIAMOND_STALWART_HELMET);
                        entries.add(TeadItems.DIAMOND_STALWART_CHESTPLATE);
                        entries.add(TeadItems.DIAMOND_HIGHLAND_HELMET);
                        entries.add(TeadItems.DIAMOND_HIGHLAND_CHESTPLATE);
                        entries.add(TeadItems.DIAMOND_ROYAL_HELMET);
                        entries.add(TeadItems.DIAMOND_PLATE_HELMET);
                        entries.add(TeadItems.DIAMOND_PLATE_CHESTPLATE);
                        entries.add(TeadItems.DIAMOND_PLATE_BOOTS);
                        entries.add(TeadItems.NETHERITE_STALWART_HELMET);
                        entries.add(TeadItems.NETHERITE_STALWART_CHESTPLATE);
                        entries.add(TeadItems.NETHERITE_HIGHLAND_HELMET);
                        entries.add(TeadItems.NETHERITE_HIGHLAND_CHESTPLATE);
                        entries.add(TeadItems.NETHERITE_ROYAL_HELMET);
                        entries.add(TeadItems.NETHERITE_PLATE_HELMET);
                        entries.add(TeadItems.NETHERITE_PLATE_CHESTPLATE);
                        entries.add(TeadItems.NETHERITE_PLATE_BOOTS);

                        entries.add(TeadBlocks.GOLD_CHAIN);
                        entries.add(TeadBlocks.BRONZE_CHAIN);
                        entries.add(TeadBlocks.ROSE_GOLD_CHAIN);
                        entries.add(TeadBlocks.STEEL_CHAIN);
                        entries.add(TeadBlocks.BLOCK_OF_RUBY);
                        entries.add(TeadBlocks.BLOCK_OF_GALENA);
                        entries.add(TeadBlocks.BLOCK_OF_LEAD);

                        entries.add(TeadBlocks.LEAD_ORE);
                        entries.add(TeadBlocks.RUBY_ORE);
                        entries.add(TeadBlocks.DEEPSLATE_RUBY_ORE);

                        entries.add(TeadBlocks.SICK_PUMPKIN);

                        entries.add(TeadBlocks.CLAYISH_MUD);
                        entries.add(TeadBlocks.SLUDGE);
                        entries.add(TeadBlocks.DRY_DIRT);
                        entries.add(TeadBlocks.VERY_SPARSE_GRASS);
                        entries.add(TeadBlocks.SPARSE_GRASS);
                        entries.add(TeadBlocks.DRY_GRASS);
                        entries.add(TeadBlocks.BROWN_DRY_GRASS);
                        entries.add(TeadBlocks.DARK_BRICKS);
                        entries.add(TeadBlocks.DARK_COBBLESTONE);
                        entries.add(TeadBlocks.DIRTY_COBBLESTONE);
                        entries.add(TeadBlocks.DIRTY_STONE_PLAQUE);
                        entries.add(TeadBlocks.SANDY_COBBLESTONE);
                        entries.add(TeadBlocks.VERY_SANDY_COBBLESTONE);
                        entries.add(TeadBlocks.STONE_PLAQUE);
                        entries.add(TeadBlocks.EMPTY_BOOKSHELF);
                        entries.add(TeadBlocks.OLD_BOOKSHELF);

                        entries.add(TeadItems.MUSIC_DISC_BATTLE_HYMN);
                        entries.add(TeadItems.MUSIC_DISC_DAY_ONE);
                        entries.add(TeadItems.MUSIC_DISC_HAIL_AND_KILL);
                        entries.add(TeadItems.MUSIC_DISC_HOMELAND);
                        entries.add(TeadItems.MUSIC_DISC_LORD_GIVE_ME_A_SIGN);
                        entries.add(TeadItems.MUSIC_DISC_LOSE_YOURSELF);
                        entries.add(TeadItems.MUSIC_DISC_MUTINY);
                        entries.add(TeadItems.MUSIC_DISC_NEVER_GONNA_GIVE_YOU_UP);
                        entries.add(TeadItems.MUSIC_DISC_NEVER_GONNA_STOP);
                        entries.add(TeadItems.MUSIC_DISC_SWORDS_IN_THE_WIND);
                        entries.add(TeadItems.MUSIC_DISC_THE_GODFATHER);
                        entries.add(TeadItems.MUSIC_DISC_THE_HEART_ASKS_PLEASURE_FIRST);
                        entries.add(TeadItems.MUSIC_DISC_THE_PHANTOM_OF_THE_OPERA);
                        entries.add(TeadItems.MUSIC_DISC_TILL_I_COLLAPSE);
                        entries.add(TeadItems.MUSIC_DISC_TIME);
                        entries.add(TeadItems.MUSIC_DISC_UNTOUCHABLE);
                    }).build());
    public static void registerItemGroups() {
        Tead.LOGGER.info("Registering mod items for " + Tead.MOD_ID);
    }
}
