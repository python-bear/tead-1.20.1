package net.pythonbear.tead.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
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
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.DEEPSLATE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(TeadBlocks.RUBY_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(TeadItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(TeadItems.LEAD_INGOT, Models.GENERATED);
        itemModelGenerator.register(TeadItems.GALENA, Models.GENERATED);
        itemModelGenerator.register(TeadItems.LEAD_APPLE, Models.GENERATED);

        itemModelGenerator.register(TeadItems.LIGHTNING_STAFF, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_AXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_HOE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(TeadItems.LEAD_SWORD, Models.HANDHELD);
    }
}
