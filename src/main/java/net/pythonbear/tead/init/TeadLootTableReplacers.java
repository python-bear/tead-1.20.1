package net.pythonbear.tead.init;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class TeadLootTableReplacers {
//    private static final Identifier STONE_LOOT_TABLE_ID = Blocks.STONE.getLootTableId();
//    private static final Identifier BLACKSTONE_LOOT_TABLE_ID = Blocks.BLACKSTONE.getLootTableId();
//    private static final Identifier DEEPSLATE_LOOT_TABLE_ID = Blocks.DEEPSLATE.getLootTableId();
//
//    public static void replaceLootTables() {
//        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, tableBuilder, source) -> {
//            if (STONE_LOOT_TABLE_ID.equals(id)) {
//                LootPool.Builder poolBuilder = LootPool.builder()
//                        .rolls(ConstantLootNumberProvider.create(1))
//                        .with(ItemEntry.builder(TeadItems.ROCK))
//                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 5.0f))
//                                .build());
//
//                tableBuilder.pool(poolBuilder);
//            }
//            if (BLACKSTONE_LOOT_TABLE_ID.equals(id)) {
//                LootPool.Builder poolBuilder = LootPool.builder()
//                        .rolls(ConstantLootNumberProvider.create(1))
//                        .with(ItemEntry.builder(TeadItems.BLACK_ROCK))
//                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 5.0f))
//                                .build());
//
//                tableBuilder.pool(poolBuilder);
//            }
//            if (DEEPSLATE_LOOT_TABLE_ID.equals(id)) {
//                LootPool.Builder poolBuilder = LootPool.builder()
//                        .rolls(ConstantLootNumberProvider.create(1))
//                        .with(ItemEntry.builder(TeadItems.SLATE))
//                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 5.0f))
//                                .build());
//
//                tableBuilder.pool(poolBuilder);
//            }
//        });
//    }
}
