package net.pythonbear.tead;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.pythonbear.tead.entity.TeadEntities;
import net.pythonbear.tead.init.TeadBlocks;
import net.pythonbear.tead.init.TeadModelPredicateProvider;

public class TeadClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TeadModelPredicateProvider.registerTeadModels();

        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.GOLD_CHAIN, RenderLayer.getCutout());

        EntityRendererRegistry.register(TeadEntities.GRENADE_PROJECTILE, FlyingItemEntityRenderer::new);

        Tead.LOGGER.info("Client mod for " + Tead.MOD_ID + " fully initialized");
    }
}
