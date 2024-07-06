package net.pythonbear.tead;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.item.DyeableItem;
import net.pythonbear.tead.entity.TeadEntities;
import net.pythonbear.tead.init.TeadBlocks;
import net.pythonbear.tead.init.TeadItems;
import net.pythonbear.tead.init.TeadModelPredicateProvider;
import net.pythonbear.tead.init.TeadScreenHandlers;
import net.pythonbear.tead.rendering.ShurikenProjectileRenderer;
import net.pythonbear.tead.screen.SmelterScreen;

@Environment(EnvType.CLIENT)
public class TeadClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TeadModelPredicateProvider.registerTeadModels();

        ScreenRegistry.register(TeadScreenHandlers.SMELTER_SCREEN_HANDLER, SmelterScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.COPPER_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.LEAD_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.BRONZE_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.BRASS_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.GOLD_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.ROSE_GOLD_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.WHITE_GOLD_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.STEEL_CHAIN, RenderLayer.getCutout());

        EntityRendererRegistry.register(TeadEntities.GRENADE_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(TeadEntities.SHURIKEN_PROJECTILE, ShurikenProjectileRenderer::new);
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
