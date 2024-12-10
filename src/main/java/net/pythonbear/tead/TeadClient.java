package net.pythonbear.tead;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.item.DyeableItem;
import net.pythonbear.tead.init.TeadEntityTypes;
import net.pythonbear.tead.init.TeadBlocks;
import net.pythonbear.tead.init.TeadItems;
import net.pythonbear.tead.init.TeadModelPredicateProvider;
import net.pythonbear.tead.init.TeadScreenHandlers;
import net.pythonbear.tead.rendering.CustomArrowEntityRenderer;
import net.pythonbear.tead.rendering.ShurikenProjectileRenderer;
import net.pythonbear.tead.rendering.SpectralWindArrowEntityRenderer;
import net.pythonbear.tead.screen.SmelterScreen;

@Environment(EnvType.CLIENT)
public class TeadClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TeadModelPredicateProvider.registerTeadModels();

        HandledScreens.register(TeadScreenHandlers.SMELTER_SCREEN_HANDLER, SmelterScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.COPPER_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.LEAD_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.BRONZE_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.BRASS_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.GOLD_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.ROSE_GOLD_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.WHITE_GOLD_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.STEEL_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.WEAK_COBWEB, RenderLayer.getCutout());

        EntityRendererRegistry.register(TeadEntityTypes.GRENADE_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(TeadEntityTypes.SHURIKEN_PROJECTILE, ShurikenProjectileRenderer::new);
        EntityRendererRegistry.register(TeadEntityTypes.BUFFERED_PEARL, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(TeadEntityTypes.GRAVITY_PEARL, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(TeadEntityTypes.SPECTRAL_WIND_ARROW, SpectralWindArrowEntityRenderer::new);
        EntityRendererRegistry.register(TeadEntityTypes.AMETHYST_ARROW, CustomArrowEntityRenderer::new);
        EntityRendererRegistry.register(TeadEntityTypes.BORING_ARROW, CustomArrowEntityRenderer::new);
        EntityRendererRegistry.register(TeadEntityTypes.COPPER_ARROW, CustomArrowEntityRenderer::new);
        EntityRendererRegistry.register(TeadEntityTypes.ENDER_PEARL_ARROW, CustomArrowEntityRenderer::new);
        EntityRendererRegistry.register(TeadEntityTypes.OBSIDIAN_ARROW, CustomArrowEntityRenderer::new);
        EntityRendererRegistry.register(TeadEntityTypes.REDSTONE_TORCH_ARROW, CustomArrowEntityRenderer::new);
        EntityRendererRegistry.register(TeadEntityTypes.RUBY_ARROW, CustomArrowEntityRenderer::new);
        EntityRendererRegistry.register(TeadEntityTypes.TRANSMORPHING_ARROW, CustomArrowEntityRenderer::new);
        EntityRendererRegistry.register(TeadEntityTypes.SOUL_TORCH_ARROW, CustomArrowEntityRenderer::new);
        EntityRendererRegistry.register(TeadEntityTypes.TNT_ARROW, CustomArrowEntityRenderer::new);
        EntityRendererRegistry.register(TeadEntityTypes.TORCH_ARROW, CustomArrowEntityRenderer::new);

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex == 0?
                        ((DyeableItem) stack.getItem()).getColor(stack) : 0xFFFFFFF,
                TeadItems.ROBE_BOOTS,
                TeadItems.ROBE_HELMET,
                TeadItems.ROBE_CHESTPLATE,
                TeadItems.COPPER_HIGHLAND_CHESTPLATE,
                TeadItems.COPPER_PLATE_HELMET,
                TeadItems.COPPER_PLATE_CHESTPLATE,
                TeadItems.COPPER_PLATE_BOOTS,
                TeadItems.IRON_HIGHLAND_CHESTPLATE,
                TeadItems.IRON_PLATE_HELMET,
                TeadItems.IRON_PLATE_CHESTPLATE,
                TeadItems.IRON_PLATE_BOOTS,
                TeadItems.DIAMOND_HIGHLAND_CHESTPLATE,
                TeadItems.DIAMOND_PLATE_HELMET,
                TeadItems.DIAMOND_PLATE_CHESTPLATE,
                TeadItems.DIAMOND_PLATE_BOOTS,
                TeadItems.NETHERITE_HIGHLAND_CHESTPLATE,
                TeadItems.NETHERITE_PLATE_HELMET,
                TeadItems.NETHERITE_PLATE_CHESTPLATE,
                TeadItems.NETHERITE_PLATE_BOOTS,
                TeadItems.GOLD_HIGHLAND_CHESTPLATE,
                TeadItems.GOLD_GUARD_CHESTPLATE,
                TeadItems.GOLD_PLATE_HELMET,
                TeadItems.GOLD_PLATE_CHESTPLATE,
                TeadItems.GOLD_PLATE_BOOTS,
                TeadItems.GOLD_THIEF_HELMET,
                TeadItems.GOLD_GHOSTLY_HELMET,
                TeadItems.GOLD_GHOSTLY_CHESTPLATE
        );
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex == 0?
                        ((DyeableItem) stack.getItem()).getColor(stack) : 0xFFFFFFF,
                TeadItems.GOLD_WOOLEN_HELMET,
                TeadItems.GOLD_WOOLEN_CHESTPLATE,
                TeadItems.GOLD_WOOLEN_LEGGINGS,
                TeadItems.GOLD_WOOLEN_BOOTS
        );

        Tead.LOGGER.info("Client mod for " + Tead.MOD_ID + " fully initialized");
    }
}
