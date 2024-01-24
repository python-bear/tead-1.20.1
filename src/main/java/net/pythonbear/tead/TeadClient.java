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

public class TeadClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TeadModelPredicateProvider.registerTeadModels();

        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.GOLD_CHAIN, RenderLayer.getCutout());

        EntityRendererRegistry.register(TeadEntities.GRENADE_PROJECTILE, FlyingItemEntityRenderer::new);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex == 0?
                        ((DyeableItem) stack.getItem()).getColor(stack) : 0xFFFFFFF,
                TeadItems.ROBE_BOOTS,
                TeadItems.ROBE_LEGGINGS,
                TeadItems.ROBE_HELMET,
                TeadItems.ROBE_CHESTPLATE,
                TeadItems.GOLD_PLATE_HELMET,
                TeadItems.GOLD_PLATE_CHESTPLATE,
                TeadItems.GOLD_PLATE_BOOTS,
                TeadItems.IRON_PLATE_HELMET,
                TeadItems.IRON_PLATE_CHESTPLATE,
                TeadItems.IRON_PLATE_BOOTS,
                TeadItems.DIAMOND_PLATE_HELMET,
                TeadItems.DIAMOND_PLATE_CHESTPLATE,
                TeadItems.DIAMOND_PLATE_BOOTS,
                TeadItems.NETHERITE_PLATE_HELMET,
                TeadItems.NETHERITE_PLATE_CHESTPLATE,
                TeadItems.NETHERITE_PLATE_BOOTS
        );

        Tead.LOGGER.info("Client mod for " + Tead.MOD_ID + " fully initialized");
    }
}
