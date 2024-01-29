package net.pythonbear.tead.init;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class TeadLootTableModifiers {
    private static final Identifier VILLAGE_TANNERY_ID = new Identifier("minecraft",
            "chests/village/village_tannery");
    private static final Identifier VILLAGE_MASON_ID = new Identifier("minecraft",
            "chests/village/village_mason");
    private static final Identifier VILLAGE_TOOLSMITH_ID = new Identifier("minecraft",
            "chests/village/village_toolsmith");
    private static final Identifier VILLAGE_WEAPONSMITH_ID = new Identifier("minecraft",
            "chests/village/village_weaponsmith");
    private static final Identifier BASTION_TREASURE_ID = new Identifier("minecraft",
            "chests/bastion_treasure");
    private static final Identifier BASTION_HOGLIN_STABLE_ID = new Identifier("minecraft",
            "chests/bastion_hoglin_stable");
    private static final Identifier SHIPWRECK_TREASURE_ID = new Identifier("minecraft",
            "chests/shipwreck_treasure");
    private static final Identifier BURIED_TREASURE_ID = new Identifier("minecraft",
            "chests/buried_treasure");
    private static final Identifier RUINED_PORTAL_ID = new Identifier("minecraft",
            "chests/portal_portal");
    private static final Identifier WOODLAND_MANSION_ID = new Identifier("minecraft",
            "chests/woodland_mansion");
    private static final Identifier BIG_WATER_RUIN_ID = new Identifier("minecraft",
            "chests/underwater_ruin_big");
    private static final Identifier SMALL_WATER_RUIN_ID = new Identifier("minecraft",
            "chests/underwater_ruin_small");
    private static final Identifier STRONGHOLD_LIBRARY_ID = new Identifier("minecraft",
            "chests/stronghold_library");
    private static final Identifier STRONGHOLD_CORRIDOR_ID = new Identifier("minecraft",
            "chests/stronghold_corridor");
    private static final Identifier STRONGHOLD_CROSSING_ID = new Identifier("minecraft",
            "chests/stronghold_crossing");
    private static final Identifier SIMPLE_DUNGEON_ID = new Identifier("minecraft",
            "chests/simple_dungeon");
    private static final Identifier PILLAGER_OUTPOST_ID = new Identifier("minecraft",
            "chests/pillager_outpost");
    private static final Identifier NETHER_BRIDGE_ID = new Identifier("minecraft",
            "chests/nether_bridge");
    private static final Identifier JUNGLE_TEMPLE_DISPENSER_ID = new Identifier("minecraft",
            "chests/jungle_temple_dispenser");
    private static final Identifier JUNGLE_TEMPLE_ID = new Identifier("minecraft",
            "chests/jungle_temple");
    private static final Identifier IGLOO_CHEST_ID = new Identifier("minecraft",
            "chests/igloo_chest");
    private static final Identifier END_CITY_ID = new Identifier("minecraft",
            "chests/end_city_treasure");
    private static final Identifier DESERT_PYRAMID_ID = new Identifier("minecraft",
            "chests/desert_pyramid");
    private static final Identifier BASTION_OTHER_ID = new Identifier("minecraft",
            "chests/bastion_other");
    private static final Identifier ANCIENT_CITY_ID = new Identifier("minecraft",
            "chests/ancient_city");
    private static final Identifier MINESHAFT_ID = new Identifier("minecraft",
            "chests/abandoned_mineshaft");


    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (MINESHAFT_ID.equals(id)) {
                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.LEAD_APPLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)));
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(TeadItems.LEAD_PICKAXE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)));
                LootPool.Builder poolBuilder3 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.TNT_ARROW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)));
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(TeadItems.JERKY))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 7.0f)));

                tableBuilder.pool(poolBuilder1);
                tableBuilder.pool(poolBuilder2);
                tableBuilder.pool(poolBuilder3);
                tableBuilder.pool(poolBuilder4);
            }
            if (ANCIENT_CITY_ID.equals(id)) {
                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.DIAMOND_HAMMER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));

                tableBuilder.pool(poolBuilder1);
            }
            if (BASTION_OTHER_ID.equals(id)) {
                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.GOLD_CHAINMAIL_HELMET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.GOLD_CHAINMAIL_CHESTPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder3 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.GOLD_CHAINMAIL_LEGGINGS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.GOLD_CHAINMAIL_BOOTS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder5 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(TeadBlocks.GOLD_CHAIN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)));

                tableBuilder.pool(poolBuilder1);
                tableBuilder.pool(poolBuilder2);
                tableBuilder.pool(poolBuilder3);
                tableBuilder.pool(poolBuilder4);
                tableBuilder.pool(poolBuilder5);
            }
            if (DESERT_PYRAMID_ID.equals(id)) {
                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(TeadItems.JERKY))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 32.0f)));
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(TeadItems.GRENADE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 12.0f)));

                tableBuilder.pool(poolBuilder1);
                tableBuilder.pool(poolBuilder2);
            }
            if (END_CITY_ID.equals(id)) {
                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.OBSIDIAN_CLAYMORE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(TeadItems.OBSIDIAN_SWORD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder3 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(TeadItems.DIAMOND_HAMMER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(TeadItems.OBSIDIAN_SHARD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 24.0f)));

                tableBuilder.pool(poolBuilder1);
                tableBuilder.pool(poolBuilder2);
                tableBuilder.pool(poolBuilder3);
                tableBuilder.pool(poolBuilder4);
            }
            if (IGLOO_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(TeadItems.LEAD_APPLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)));

                tableBuilder.pool(poolBuilder1);
            }
            if (JUNGLE_TEMPLE_ID.equals(id)) {
                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.6f))
                        .with(ItemEntry.builder(TeadItems.WIND_BOW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)));
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.RUBY))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)));
                LootPool.Builder poolBuilder3 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.4f))
                        .with(ItemEntry.builder(TeadItems.LEAD_AXE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)));

                tableBuilder.pool(poolBuilder1);
                tableBuilder.pool(poolBuilder2);
                tableBuilder.pool(poolBuilder3);
            }
            if (JUNGLE_TEMPLE_DISPENSER_ID.equals(id)) {
                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(TeadItems.AMETHYST_ARROW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 9.0f)));
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(TeadItems.OBSIDIAN_ARROW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 9.0f)));

                tableBuilder.pool(poolBuilder1);
                tableBuilder.pool(poolBuilder2);
            }
            if (NETHER_BRIDGE_ID.equals(id)) {
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.DIAMOND_HAMMER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)));
                LootPool.Builder poolBuilder5 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(TeadItems.BORING_ARROW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder6 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(TeadItems.TNT_ARROW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 12.0f)));
                LootPool.Builder poolBuilder7 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(TeadItems.DIAMOND_PLATE_CHESTPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));

                tableBuilder.pool(poolBuilder4);
                tableBuilder.pool(poolBuilder5);
                tableBuilder.pool(poolBuilder6);
                tableBuilder.pool(poolBuilder7);
            }
            if (PILLAGER_OUTPOST_ID.equals(id)) {
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(TeadItems.TRICK_BOW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder5 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(TeadItems.MUSIC_DISC_HOMELAND))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder6 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.4f))
                        .with(ItemEntry.builder(TeadItems.TNT_ARROW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 12.0f)));
                LootPool.Builder poolBuilder7 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(TeadItems.IRON_PLATE_BOOTS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 1.0f)));

                tableBuilder.pool(poolBuilder4);
                tableBuilder.pool(poolBuilder5);
                tableBuilder.pool(poolBuilder6);
                tableBuilder.pool(poolBuilder7);
            }
            if (SIMPLE_DUNGEON_ID.equals(id)) {
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(TeadItems.SHORT_BOW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder5 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(TeadItems.LEAD_SICKLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)));
                LootPool.Builder poolBuilder6 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(TeadItems.MUSIC_DISC_THE_HEART_ASKS_PLEASURE_FIRST))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder7 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(TeadItems.LEAD_APPLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)));

                tableBuilder.pool(poolBuilder4);
                tableBuilder.pool(poolBuilder5);
                tableBuilder.pool(poolBuilder6);
                tableBuilder.pool(poolBuilder7);
            }
            if (STRONGHOLD_CROSSING_ID.equals(id)) {
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.08f))
                        .with(ItemEntry.builder(TeadItems.OBSIDIAN_SWORD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder5 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.DIAMOND_CLAYMORE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder6 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(TeadItems.IRON_HAMMER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));

                tableBuilder.pool(poolBuilder4);
                tableBuilder.pool(poolBuilder5);
                tableBuilder.pool(poolBuilder6);
            }
            if (STRONGHOLD_CORRIDOR_ID.equals(id)) {
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.4f))
                        .with(ItemEntry.builder(TeadItems.OBSIDIAN_ARROW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 32.0f)));
                LootPool.Builder poolBuilder5 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.DIAMOND_STALWART_HELMET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f)));
                LootPool.Builder poolBuilder6 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(TeadItems.IRON_STALWART_CHESTPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 1.0f)));

                tableBuilder.pool(poolBuilder4);
                tableBuilder.pool(poolBuilder5);
                tableBuilder.pool(poolBuilder6);
            }
            if (STRONGHOLD_LIBRARY_ID.equals(id)) {
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.9f))
                        .with(ItemEntry.builder(TeadItems.FABRIC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 22.0f)));
                LootPool.Builder poolBuilder5 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.DIAMOND_STALWART_HELMET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder6 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.06f))
                        .with(ItemEntry.builder(TeadItems.MUSIC_DISC_TIME))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));

                tableBuilder.pool(poolBuilder4);
                tableBuilder.pool(poolBuilder5);
                tableBuilder.pool(poolBuilder6);
            }
            if (SMALL_WATER_RUIN_ID.equals(id)) {
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.7f))
                        .with(ItemEntry.builder(TeadItems.CORAL_DAGGER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder5 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(TeadItems.COPPER_ARROW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 16.0f)));

                tableBuilder.pool(poolBuilder4);
                tableBuilder.pool(poolBuilder5);
            }
            if (BIG_WATER_RUIN_ID.equals(id)) {
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(TeadItems.WIND_BOW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.9f))
                        .with(ItemEntry.builder(TeadItems.CORAL_DAGGER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f)));
                LootPool.Builder poolBuilder5 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(TeadItems.COPPER_ARROW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 32.0f)));

                tableBuilder.pool(poolBuilder2);
                tableBuilder.pool(poolBuilder4);
                tableBuilder.pool(poolBuilder5);
            }
            if (WOODLAND_MANSION_ID.equals(id)) {
                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.LEAD_INGOT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 32.0f)));
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.LEAD_AXE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 1.0f)));
                LootPool.Builder poolBuilder3 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.06f))
                        .with(ItemEntry.builder(TeadItems.DIAMOND_CLAYMORE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.02f))
                        .with(ItemEntry.builder(TeadItems.MUSIC_DISC_HAIL_AND_KILL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder5 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.LEAD_NUGGET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 32.0f)));

                tableBuilder.pool(poolBuilder1);
                tableBuilder.pool(poolBuilder2);
                tableBuilder.pool(poolBuilder3);
                tableBuilder.pool(poolBuilder4);
                tableBuilder.pool(poolBuilder5);
            }
            if (RUINED_PORTAL_ID.equals(id)) {
                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(TeadItems.GOLD_DOUBLE_AXE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.TRICK_BOW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder3 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(TeadItems.GOLD_HAMMER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f)));
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.6f))
                        .with(ItemEntry.builder(TeadItems.OBSIDIAN_SHARD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 12.0f)));

                tableBuilder.pool(poolBuilder1);
                tableBuilder.pool(poolBuilder2);
                tableBuilder.pool(poolBuilder3);
                tableBuilder.pool(poolBuilder4);
            }
            if (BURIED_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.SWIFTNESS_BOOTS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.7f))
                        .with(ItemEntry.builder(TeadItems.WIND_BOW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.4f))
                        .with(ItemEntry.builder(TeadItems.CORAL_DAGGER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)));
                LootPool.Builder poolBuilder5 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.9f))
                        .with(ItemEntry.builder(TeadItems.COPPER_ARROW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 32.0f)));

                tableBuilder.pool(poolBuilder1);
                tableBuilder.pool(poolBuilder2);
                tableBuilder.pool(poolBuilder4);
                tableBuilder.pool(poolBuilder5);
            }
            if (SHIPWRECK_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(TeadItems.SWIFTNESS_BOOTS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.WIND_BOW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder3 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(TeadItems.TRICK_BOW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)));
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.4f))
                        .with(ItemEntry.builder(TeadItems.CORAL_DAGGER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder5 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.MUSIC_DISC_MUTINY))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 1.0f)));
                LootPool.Builder poolBuilder6 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.8f))
                        .with(ItemEntry.builder(TeadItems.JERKY))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 16.0f)));

                tableBuilder.pool(poolBuilder1);
                tableBuilder.pool(poolBuilder2);
                tableBuilder.pool(poolBuilder3);
                tableBuilder.pool(poolBuilder4);
                tableBuilder.pool(poolBuilder5);
                tableBuilder.pool(poolBuilder6);
            }
            if (BASTION_HOGLIN_STABLE_ID.equals(id)) {
                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.6f))
                        .with(ItemEntry.builder(TeadItems.FIREBOLT_THROWER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.9f))
                        .with(ItemEntry.builder(TeadItems.FABRIC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 3.0f)));
                LootPool.Builder poolBuilder3 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(TeadItems.GOLD_CHAINMAIL_CHESTPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.GOLD_CHAINMAIL_HELMET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder5 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.06f))
                        .with(ItemEntry.builder(TeadItems.GOLD_CHAINMAIL_BOOTS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)));

                tableBuilder.pool(poolBuilder1);
                tableBuilder.pool(poolBuilder2);
                tableBuilder.pool(poolBuilder3);
                tableBuilder.pool(poolBuilder4);
                tableBuilder.pool(poolBuilder5);
            }
            if (BASTION_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.BONE_CLUB))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 1.0f)));
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.GOLD_HAMMER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 1.0f)));
                LootPool.Builder poolBuilder3 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.02f))
                        .with(ItemEntry.builder(TeadItems.GOLD_HIGHLAND_CHESTPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 1.0f)));
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(TeadItems.GOLD_HIGHLAND_HELMET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 1.0f)));
                LootPool.Builder poolBuilder5 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(TeadItems.GOLD_CHAINMAIL_LEGGINGS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 1.0f)));

                tableBuilder.pool(poolBuilder1);
                tableBuilder.pool(poolBuilder2);
                tableBuilder.pool(poolBuilder3);
                tableBuilder.pool(poolBuilder4);
                tableBuilder.pool(poolBuilder5);
            }
            if (VILLAGE_TANNERY_ID.equals(id)) {
                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(TeadItems.SWIFTNESS_BOOTS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.9f))
                        .with(ItemEntry.builder(TeadItems.HANDLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)));

                tableBuilder.pool(poolBuilder1);
                tableBuilder.pool(poolBuilder2);
            }
            if (VILLAGE_MASON_ID.equals(id)) {
                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.70f))
                        .with(ItemEntry.builder(TeadItems.STONE_HAMMER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.20f))
                        .with(ItemEntry.builder(TeadItems.IRON_HAMMER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder3 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(TeadItems.LEAD_HAMMER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(TeadItems.DIAMOND_HAMMER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));

                tableBuilder.pool(poolBuilder1);
                tableBuilder.pool(poolBuilder2);
                tableBuilder.pool(poolBuilder3);
                tableBuilder.pool(poolBuilder4);
            }
            if (VILLAGE_WEAPONSMITH_ID.equals(id)) {
                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.40f))
                        .with(ItemEntry.builder(TeadItems.LEAD_SWORD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.18f))
                        .with(ItemEntry.builder(TeadItems.IRON_CLAYMORE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder3 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.23f))
                        .with(ItemEntry.builder(TeadItems.LEAD_CLAYMORE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(TeadItems.DIAMOND_CLAYMORE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));

                tableBuilder.pool(poolBuilder1);
                tableBuilder.pool(poolBuilder2);
                tableBuilder.pool(poolBuilder3);
                tableBuilder.pool(poolBuilder4);
            }
            if (VILLAGE_TOOLSMITH_ID.equals(id)) {
                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.70f))
                        .with(ItemEntry.builder(TeadItems.LEAD_SICKLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.18f))
                        .with(ItemEntry.builder(TeadItems.IRON_SICKLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder3 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TeadItems.DIAMOND_SICKLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(TeadItems.OBSIDIAN_ARROW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 32.0f)));

                tableBuilder.pool(poolBuilder1);
                tableBuilder.pool(poolBuilder2);
                tableBuilder.pool(poolBuilder3);
                tableBuilder.pool(poolBuilder4);
            }
        });
    }
}
