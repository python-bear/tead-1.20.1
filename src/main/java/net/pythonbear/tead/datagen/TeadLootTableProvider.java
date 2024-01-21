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
        addDrop(TeadBlocks.BLOCK_OF_GALENA);
        addDrop(TeadBlocks.SPARSE_GRASS);
        addDrop(TeadBlocks.DRY_GRASS);
        addDrop(TeadBlocks.BROWN_DRY_GRASS);
        addDrop(TeadBlocks.VERY_SPARSE_GRASS);
        addDrop(TeadBlocks.DRY_DIRT);
        addDrop(TeadBlocks.DARK_BRICKS);
        addDrop(TeadBlocks.DARK_COBBLESTONE);
        addDrop(TeadBlocks.DIRTY_COBBLESTONE);
        addDrop(TeadBlocks.DIRTY_STONE_PLAQUE);
        addDrop(TeadBlocks.STONE_PLAQUE);
        addDrop(TeadBlocks.SLUDGE);
        addDrop(TeadBlocks.SANDY_COBBLESTONE);
        addDrop(TeadBlocks.VERY_SANDY_COBBLESTONE);
        addDrop(TeadBlocks.EMPTY_BOOKSHELF);

        // Ores that drop more than one resource
        addDrop(TeadBlocks.SICK_PUMPKIN, copperLikeOreDrops(TeadBlocks.SICK_PUMPKIN, Items.PUMPKIN_SEEDS, 0f,
                1f));
        addDrop(TeadBlocks.OLD_BOOKSHELF, copperLikeOreDrops(TeadBlocks.OLD_BOOKSHELF, Items.BOOK, 0f,
                3f));
        addDrop(TeadBlocks.CLAYISH_MUD, copperLikeOreDrops(TeadBlocks.CLAYISH_MUD, TeadItems.MUDDY_CLAY_BALL, 0f,
                4f));

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
