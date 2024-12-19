package net.pythonbear.tead.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.pythonbear.tead.block.TeadBlocks;
import net.pythonbear.tead.item.TeadItems;

public class TeadLootTableProvider extends FabricBlockLootTableProvider {
    public TeadLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        // Blocks that drop themselves
        addDrop(TeadBlocks.RAW_LEAD_BLOCK);
        addDrop(TeadBlocks.LEAD_BLOCK);
        addDrop(TeadBlocks.LEAD_CUT_BLOCK);
        addDrop(TeadBlocks.LEAD_CUT_SLAB, slabDrops(TeadBlocks.LEAD_CUT_SLAB));
        addDrop(TeadBlocks.LEAD_CUT_STAIRS);
        addDrop(TeadBlocks.LEAD_TILED_BLOCK);
        addDrop(TeadBlocks.LEAD_CHISELED_BLOCK);
        addDrop(TeadBlocks.ROSE_GOLD_BLOCK);
        addDrop(TeadBlocks.WHITE_GOLD_BLOCK);
        addDrop(TeadBlocks.BRASS_BLOCK);
        addDrop(TeadBlocks.BRASS_CUT_BLOCK);
        addDrop(TeadBlocks.BRASS_CUT_SLAB, slabDrops(TeadBlocks.BRASS_CUT_SLAB));
        addDrop(TeadBlocks.BRASS_CUT_STAIRS);
        addDrop(TeadBlocks.BRONZE_BLOCK);
        addDrop(TeadBlocks.BRONZE_CUT_BLOCK);
        addDrop(TeadBlocks.BRONZE_CUT_SLAB, slabDrops(TeadBlocks.BRONZE_CUT_SLAB));
        addDrop(TeadBlocks.BRONZE_CUT_STAIRS);
        addDrop(TeadBlocks.STEEL_BLOCK);
        addDrop(TeadBlocks.RUBY_BLOCK);
        addDrop(TeadBlocks.ROSE_NETHERITE_BLOCK);
        addDrop(TeadBlocks.WHITE_NETHERITE_BLOCK);
        addDrop(TeadBlocks.EMPTY_BOOKSHELF);

        // Ores that drop more than one resource
        addDrop(TeadBlocks.SICK_PUMPKIN, copperLikeOreDrops(TeadBlocks.SICK_PUMPKIN, Items.PUMPKIN_SEEDS, 0f,
                1f));
        addDrop(TeadBlocks.OLD_BOOKSHELF, copperLikeOreDrops(TeadBlocks.OLD_BOOKSHELF, Items.BOOK, 0f,
                3f));
        addDrop(TeadBlocks.CLAYISH_MUD, copperLikeOreDrops(TeadBlocks.CLAYISH_MUD, TeadItems.MUDDY_CLAY_BALL, 0f,
                4f));

        addDrop(TeadBlocks.LEAD_ORE, copperLikeOreDrops(TeadBlocks.LEAD_ORE, TeadItems.GALENA, 1f, 3f));
        addDrop(TeadBlocks.LEAD_DEEPSLATE_ORE, copperLikeOreDrops(TeadBlocks.LEAD_ORE, TeadItems.GALENA, 2f,
                3f));
        addDrop(TeadBlocks.WHITE_GOLD_NETHER_ORE, copperLikeOreDrops(TeadBlocks.WHITE_GOLD_NETHER_ORE,
                TeadItems.WHITE_GOLD_NUGGET, 3f, 7f));
        addDrop(TeadBlocks.RUBY_ORE, copperLikeOreDrops(TeadBlocks.RUBY_ORE, TeadItems.ROUGH_RUBY, 1f, 2f));
        addDrop(TeadBlocks.DEEPSLATE_RUBY_ORE, copperLikeOreDrops(TeadBlocks.DEEPSLATE_RUBY_ORE, TeadItems.ROUGH_RUBY,
                1f, 3f));
    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item, Float low, Float high) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder) ItemEntry.builder(item)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(low, high))))
                        .apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE))));
    }
}
