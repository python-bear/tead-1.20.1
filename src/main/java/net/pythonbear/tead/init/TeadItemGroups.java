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
                        entries.add(TeadItems.OBSIDIAN_SHARD);
                        entries.add(TeadItems.GALENA);
                        entries.add(TeadItems.LEAD_INGOT);
                        entries.add(TeadItems.LEAD_NUGGET);
                        entries.add(TeadItems.LEAD_BULLET);
                        entries.add(TeadItems.FABRIC);

                        entries.add(TeadItems.AMETHYST_ARROW);
                        entries.add(TeadItems.TNT_ARROW);
                        entries.add(TeadItems.BORING_ARROW);
                        entries.add(TeadItems.COPPER_ARROW);
                        entries.add(TeadItems.ENDER_PEARL_ARROW);
                        entries.add(TeadItems.OBSIDIAN_ARROW);
                        entries.add(TeadItems.RUBY_ARROW);

                        entries.add(TeadItems.JERKY);
                        entries.add(TeadItems.LEAD_APPLE);

                        entries.add(TeadItems.LIGHTNING_STAFF);
                        entries.add(TeadItems.QUARTERSTAFF);
                        entries.add(TeadItems.BATTLE_STAFF);
                        entries.add(TeadItems.BONE_CLUB);

                        entries.add(TeadItems.BONE_BOW);
                        entries.add(TeadItems.TRICK_BOW);
                        entries.add(TeadItems.WIND_BOW);
                        entries.add(TeadItems.SHORT_BOW);
                        entries.add(TeadItems.LONG_BOW);

                        entries.add(TeadItems.FIREBOLT_THROWER);

                        entries.add(TeadItems.HANDLE);

                        entries.add(TeadItems.LEAD_AXE);
                        entries.add(TeadItems.LEAD_HOE);
                        entries.add(TeadItems.LEAD_PICKAXE);
                        entries.add(TeadItems.LEAD_SHOVEL);
                        entries.add(TeadItems.LEAD_SWORD);
                        entries.add(TeadItems.WOOD_HAMMER);
                        entries.add(TeadItems.STONE_HAMMER);
                        entries.add(TeadItems.GOLD_HAMMER);
                        entries.add(TeadItems.LEAD_HAMMER);
                        entries.add(TeadItems.IRON_HAMMER);
                        entries.add(TeadItems.DIAMOND_HAMMER);
                        entries.add(TeadItems.NETHERITE_HAMMER);
                        entries.add(TeadItems.WOOD_DAGGER);
                        entries.add(TeadItems.STONE_DAGGER);
                        entries.add(TeadItems.CORAL_DAGGER);
                        entries.add(TeadItems.GOLD_DAGGER);
                        entries.add(TeadItems.LEAD_DAGGER);
                        entries.add(TeadItems.IRON_DAGGER);
                        entries.add(TeadItems.DIAMOND_DAGGER);
                        entries.add(TeadItems.NETHERITE_DAGGER);
                        entries.add(TeadItems.WOOD_DOUBLE_AXE);
                        entries.add(TeadItems.STONE_DOUBLE_AXE);
                        entries.add(TeadItems.GOLD_DOUBLE_AXE);
                        entries.add(TeadItems.LEAD_DOUBLE_AXE);
                        entries.add(TeadItems.IRON_DOUBLE_AXE);
                        entries.add(TeadItems.DIAMOND_DOUBLE_AXE);
                        entries.add(TeadItems.NETHERITE_DOUBLE_AXE);
                        entries.add(TeadItems.WOOD_SICKLE);
                        entries.add(TeadItems.STONE_SICKLE);
                        entries.add(TeadItems.GOLD_SICKLE);
                        entries.add(TeadItems.LEAD_SICKLE);
                        entries.add(TeadItems.IRON_SICKLE);
                        entries.add(TeadItems.DIAMOND_SICKLE);
                        entries.add(TeadItems.NETHERITE_SICKLE);
                        entries.add(TeadItems.GOLD_CLAYMORE);
                        entries.add(TeadItems.LEAD_CLAYMORE);
                        entries.add(TeadItems.IRON_CLAYMORE);
                        entries.add(TeadItems.DIAMOND_CLAYMORE);
                        entries.add(TeadItems.NETHERITE_CLAYMORE);
                        entries.add(TeadItems.OBSIDIAN_CLAYMORE);
                        entries.add(TeadItems.OBSIDIAN_SWORD);

                        entries.add(TeadItems.SWIFTNESS_BOOTS);

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

                        entries.add(TeadBlocks.BLOCK_OF_RUBY);
                        entries.add(TeadBlocks.BLOCK_OF_GALENA);
                        entries.add(TeadBlocks.BLOCK_OF_LEAD);
                        entries.add(TeadBlocks.LEAD_ORE);
                        entries.add(TeadBlocks.RUBY_ORE);
                        entries.add(TeadBlocks.DEEPSLATE_RUBY_ORE);
                    }).build());
    public static void registerItemGroups() {
        Tead.LOGGER.info("Registering mod items for " + Tead.MOD_ID);
    }
}
