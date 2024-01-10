package net.pythonbear.tead.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.pythonbear.tead.init.TeadBlocks;
import net.pythonbear.tead.init.TeadItems;

public class TeadLootTableProvider extends FabricBlockLootTableProvider {
    public TeadLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        // Blocks that droop themselves
        addDrop(TeadBlocks.BLOCK_OF_LEAD);
        addDrop(TeadBlocks.BLOCK_OF_RUBY);

        // Ores that drop more than one resource
        addDrop(TeadBlocks.LEAD_ORE, copperLikeOreDrops(TeadBlocks.LEAD_ORE, TeadItems.GALENA, 1f, 3f));
        addDrop(TeadBlocks.RUBY_ORE, copperLikeOreDrops(TeadBlocks.RUBY_ORE, TeadItems.RUBY, 1f, 2f));
        addDrop(TeadBlocks.DEEPSLATE_RUBY_ORE, copperLikeOreDrops(TeadBlocks.DEEPSLATE_RUBY_ORE, TeadItems.RUBY,
                1f, 3f));
    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item, Float low, Float high) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder) ItemEntry.builder(item)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(low, high))))
                        .apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE))));
    }
}
