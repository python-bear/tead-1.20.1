package net.pythonbear.tead;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.item.DyeableItem;
import net.pythonbear.tead.entity.TeadEntities;
import net.pythonbear.tead.init.TeadBlocks;
import net.pythonbear.tead.init.TeadItems;
import net.pythonbear.tead.init.TeadModelPredicateProvider;
import net.pythonbear.tead.rendering.ShurikenProjectileRenderer;
import net.pythonbear.tead.rendering.ShotgunProjectileRenderer;

public class TeadClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TeadModelPredicateProvider.registerTeadModels();

        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.GOLD_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.STEEL_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.ROSE_GOLD_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.BRONZE_CHAIN, RenderLayer.getCutout());

        EntityRendererRegistry.register(TeadEntities.GRENADE_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(TeadEntities.SHURIKEN_PROJECTILE, ShurikenProjectileRenderer::new);
        EntityRendererRegistry.register(TeadEntities.SHOTGUN_PROJECTILE, ShotgunProjectileRenderer::new);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex == 0?
                        ((DyeableItem) stack.getItem()).getColor(stack) : 0xFFFFFFF,
                TeadItems.ROBE_BOOTS,
                TeadItems.ROBE_HELMET,
                TeadItems.ROBE_CHESTPLATE,
                TeadItems.GOLD_HIGHLAND_CHESTPLATE,
                TeadItems.GOLD_PLATE_HELMET,
                TeadItems.GOLD_PLATE_CHESTPLATE,
                TeadItems.GOLD_PLATE_BOOTS,
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
                TeadItems.NETHERITE_PLATE_BOOTS
        );

        Tead.LOGGER.info("Client mod for " + Tead.MOD_ID + " fully initialized");
    }
}
