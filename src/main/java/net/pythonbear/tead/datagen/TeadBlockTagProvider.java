package net.pythonbear.tead.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.init.TeadBlocks;

import java.util.concurrent.CompletableFuture;

public class TeadBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public TeadBlockTagProvider(FabricDataOutput output,
                                CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(TeadBlocks.BLOCK_OF_LEAD)
                .add(TeadBlocks.RUBY_ORE)
                .add(TeadBlocks.DEEPSLATE_RUBY_ORE)
                .add(TeadBlocks.LEAD_ORE)
                .add(TeadBlocks.BLOCK_OF_RUBY);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK,
                new Identifier("fabric", "needs_tool_level_4")));

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(TeadBlocks.RUBY_ORE)
                .add(TeadBlocks.DEEPSLATE_RUBY_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(TeadBlocks.BLOCK_OF_RUBY);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(TeadBlocks.LEAD_ORE);
    }
}
