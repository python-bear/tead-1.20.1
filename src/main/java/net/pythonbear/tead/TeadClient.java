package net.pythonbear.tead;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.item.DyeableItem;
import net.pythonbear.tead.entity.TeadEntityTypes;
import net.pythonbear.tead.block.TeadBlocks;
import net.pythonbear.tead.item.TeadItems;
import net.pythonbear.tead.rendering.TeadModelPredicateProvider;
import net.pythonbear.tead.rendering.GrenadeProjectileRenderer;
import net.pythonbear.tead.rendering.SpearEntityRenderer;
import net.pythonbear.tead.screen.TeadScreenHandlers;
import net.pythonbear.tead.rendering.CustomArrowEntityRenderer;
import net.pythonbear.tead.rendering.ShurikenProjectileRenderer;
import net.pythonbear.tead.screen.SmelterScreen;

@Environment(EnvType.CLIENT)
public class TeadClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TeadModelPredicateProvider.registerTeadModels();

        HandledScreens.register(TeadScreenHandlers.SMELTER_SCREEN_HANDLER, SmelterScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.GOLD_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.LEAD_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.COPPER_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.ROSE_GOLD_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.WHITE_GOLD_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.BRASS_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.BRONZE_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.STEEL_CHAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeadBlocks.WEAK_COBWEB, RenderLayer.getCutout());

        EntityRendererRegistry.register(TeadEntityTypes.SPEAR, SpearEntityRenderer::new);
        EntityRendererRegistry.register(TeadEntityTypes.GRENADE_PROJECTILE, GrenadeProjectileRenderer::new);
        EntityRendererRegistry.register(TeadEntityTypes.SHURIKEN_PROJECTILE, ShurikenProjectileRenderer::new);
        EntityRendererRegistry.register(TeadEntityTypes.BUFFERED_PEARL, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(TeadEntityTypes.GRAVITY_PEARL, FlyingItemEntityRenderer::new);
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

                TeadItems.GOLD_HIGHLAND_HELMET,
                TeadItems.GOLD_HIGHLAND_CHESTPLATE,
                TeadItems.GOLD_GUARD_HELMET,
                TeadItems.GOLD_GUARD_CHESTPLATE,
                TeadItems.GOLD_PLATE_HELMET,
                TeadItems.GOLD_PLATE_CHESTPLATE,
                TeadItems.GOLD_PLATE_BOOTS,
                TeadItems.GOLD_THIEF_HELMET,
                TeadItems.GOLD_THIEF_CHESTPLATE,
                TeadItems.GOLD_GHOSTLY_HELMET,
                TeadItems.GOLD_GHOSTLY_CHESTPLATE,
                TeadItems.GOLD_GHOSTLY_BOOTS,
                TeadItems.GOLD_WOOLEN_HELMET,
                TeadItems.GOLD_WOOLEN_CHESTPLATE,
                TeadItems.GOLD_WOOLEN_LEGGINGS,
                TeadItems.GOLD_WOOLEN_BOOTS,

                TeadItems.LEAD_HIGHLAND_HELMET,
                TeadItems.LEAD_HIGHLAND_CHESTPLATE,
                TeadItems.LEAD_GUARD_HELMET,
                TeadItems.LEAD_GUARD_CHESTPLATE,
                TeadItems.LEAD_PLATE_HELMET,
                TeadItems.LEAD_PLATE_CHESTPLATE,
                TeadItems.LEAD_PLATE_BOOTS,
                TeadItems.LEAD_THIEF_HELMET,
                TeadItems.LEAD_THIEF_CHESTPLATE,
                TeadItems.LEAD_GHOSTLY_HELMET,
                TeadItems.LEAD_GHOSTLY_CHESTPLATE,
                TeadItems.LEAD_GHOSTLY_BOOTS,
                TeadItems.LEAD_WOOLEN_HELMET,
                TeadItems.LEAD_WOOLEN_CHESTPLATE,
                TeadItems.LEAD_WOOLEN_LEGGINGS,
                TeadItems.LEAD_WOOLEN_BOOTS,

                TeadItems.COPPER_HIGHLAND_HELMET,
                TeadItems.COPPER_HIGHLAND_CHESTPLATE,
                TeadItems.COPPER_GUARD_HELMET,
                TeadItems.COPPER_GUARD_CHESTPLATE,
                TeadItems.COPPER_PLATE_HELMET,
                TeadItems.COPPER_PLATE_CHESTPLATE,
                TeadItems.COPPER_PLATE_BOOTS,
                TeadItems.COPPER_THIEF_HELMET,
                TeadItems.COPPER_THIEF_CHESTPLATE,
                TeadItems.COPPER_GHOSTLY_HELMET,
                TeadItems.COPPER_GHOSTLY_CHESTPLATE,
                TeadItems.COPPER_GHOSTLY_BOOTS,
                TeadItems.COPPER_WOOLEN_HELMET,
                TeadItems.COPPER_WOOLEN_CHESTPLATE,
                TeadItems.COPPER_WOOLEN_LEGGINGS,
                TeadItems.COPPER_WOOLEN_BOOTS,

                TeadItems.ROSE_GOLD_HIGHLAND_HELMET,
                TeadItems.ROSE_GOLD_HIGHLAND_CHESTPLATE,
                TeadItems.ROSE_GOLD_GUARD_HELMET,
                TeadItems.ROSE_GOLD_GUARD_CHESTPLATE,
                TeadItems.ROSE_GOLD_PLATE_HELMET,
                TeadItems.ROSE_GOLD_PLATE_CHESTPLATE,
                TeadItems.ROSE_GOLD_PLATE_BOOTS,
                TeadItems.ROSE_GOLD_THIEF_HELMET,
                TeadItems.ROSE_GOLD_THIEF_CHESTPLATE,
                TeadItems.ROSE_GOLD_GHOSTLY_HELMET,
                TeadItems.ROSE_GOLD_GHOSTLY_CHESTPLATE,
                TeadItems.ROSE_GOLD_GHOSTLY_BOOTS,
                TeadItems.ROSE_GOLD_WOOLEN_HELMET,
                TeadItems.ROSE_GOLD_WOOLEN_CHESTPLATE,
                TeadItems.ROSE_GOLD_WOOLEN_LEGGINGS,
                TeadItems.ROSE_GOLD_WOOLEN_BOOTS,

                TeadItems.WHITE_GOLD_HIGHLAND_HELMET,
                TeadItems.WHITE_GOLD_HIGHLAND_CHESTPLATE,
                TeadItems.WHITE_GOLD_GUARD_HELMET,
                TeadItems.WHITE_GOLD_GUARD_CHESTPLATE,
                TeadItems.WHITE_GOLD_PLATE_HELMET,
                TeadItems.WHITE_GOLD_PLATE_CHESTPLATE,
                TeadItems.WHITE_GOLD_PLATE_BOOTS,
                TeadItems.WHITE_GOLD_THIEF_HELMET,
                TeadItems.WHITE_GOLD_THIEF_CHESTPLATE,
                TeadItems.WHITE_GOLD_GHOSTLY_HELMET,
                TeadItems.WHITE_GOLD_GHOSTLY_CHESTPLATE,
                TeadItems.WHITE_GOLD_GHOSTLY_BOOTS,
                TeadItems.WHITE_GOLD_WOOLEN_HELMET,
                TeadItems.WHITE_GOLD_WOOLEN_CHESTPLATE,
                TeadItems.WHITE_GOLD_WOOLEN_LEGGINGS,
                TeadItems.WHITE_GOLD_WOOLEN_BOOTS,

                TeadItems.IRON_HIGHLAND_HELMET,
                TeadItems.IRON_HIGHLAND_CHESTPLATE,
                TeadItems.IRON_GUARD_HELMET,
                TeadItems.IRON_GUARD_CHESTPLATE,
                TeadItems.IRON_PLATE_HELMET,
                TeadItems.IRON_PLATE_CHESTPLATE,
                TeadItems.IRON_PLATE_BOOTS,
                TeadItems.IRON_THIEF_HELMET,
                TeadItems.IRON_THIEF_CHESTPLATE,
                TeadItems.IRON_GHOSTLY_HELMET,
                TeadItems.IRON_GHOSTLY_CHESTPLATE,
                TeadItems.IRON_GHOSTLY_BOOTS,
                TeadItems.IRON_WOOLEN_HELMET,
                TeadItems.IRON_WOOLEN_CHESTPLATE,
                TeadItems.IRON_WOOLEN_LEGGINGS,
                TeadItems.IRON_WOOLEN_BOOTS,

                TeadItems.BRASS_HIGHLAND_HELMET,
                TeadItems.BRASS_HIGHLAND_CHESTPLATE,
                TeadItems.BRASS_GUARD_HELMET,
                TeadItems.BRASS_GUARD_CHESTPLATE,
                TeadItems.BRASS_PLATE_HELMET,
                TeadItems.BRASS_PLATE_CHESTPLATE,
                TeadItems.BRASS_PLATE_BOOTS,
                TeadItems.BRASS_THIEF_HELMET,
                TeadItems.BRASS_THIEF_CHESTPLATE,
                TeadItems.BRASS_GHOSTLY_HELMET,
                TeadItems.BRASS_GHOSTLY_CHESTPLATE,
                TeadItems.BRASS_GHOSTLY_BOOTS,
                TeadItems.BRASS_WOOLEN_HELMET,
                TeadItems.BRASS_WOOLEN_CHESTPLATE,
                TeadItems.BRASS_WOOLEN_LEGGINGS,
                TeadItems.BRASS_WOOLEN_BOOTS,

                TeadItems.BRONZE_HIGHLAND_HELMET,
                TeadItems.BRONZE_HIGHLAND_CHESTPLATE,
                TeadItems.BRONZE_GUARD_HELMET,
                TeadItems.BRONZE_GUARD_CHESTPLATE,
                TeadItems.BRONZE_PLATE_HELMET,
                TeadItems.BRONZE_PLATE_CHESTPLATE,
                TeadItems.BRONZE_PLATE_BOOTS,
                TeadItems.BRONZE_THIEF_HELMET,
                TeadItems.BRONZE_THIEF_CHESTPLATE,
                TeadItems.BRONZE_GHOSTLY_HELMET,
                TeadItems.BRONZE_GHOSTLY_CHESTPLATE,
                TeadItems.BRONZE_GHOSTLY_BOOTS,
                TeadItems.BRONZE_WOOLEN_HELMET,
                TeadItems.BRONZE_WOOLEN_CHESTPLATE,
                TeadItems.BRONZE_WOOLEN_LEGGINGS,
                TeadItems.BRONZE_WOOLEN_BOOTS,

                TeadItems.STEEL_HIGHLAND_HELMET,
                TeadItems.STEEL_HIGHLAND_CHESTPLATE,
                TeadItems.STEEL_GUARD_HELMET,
                TeadItems.STEEL_GUARD_CHESTPLATE,
                TeadItems.STEEL_PLATE_HELMET,
                TeadItems.STEEL_PLATE_CHESTPLATE,
                TeadItems.STEEL_PLATE_BOOTS,
                TeadItems.STEEL_THIEF_HELMET,
                TeadItems.STEEL_THIEF_CHESTPLATE,
                TeadItems.STEEL_GHOSTLY_HELMET,
                TeadItems.STEEL_GHOSTLY_CHESTPLATE,
                TeadItems.STEEL_GHOSTLY_BOOTS,
                TeadItems.STEEL_WOOLEN_HELMET,
                TeadItems.STEEL_WOOLEN_CHESTPLATE,
                TeadItems.STEEL_WOOLEN_LEGGINGS,
                TeadItems.STEEL_WOOLEN_BOOTS,

                TeadItems.DIAMOND_HIGHLAND_HELMET,
                TeadItems.DIAMOND_HIGHLAND_CHESTPLATE,
                TeadItems.DIAMOND_GUARD_HELMET,
                TeadItems.DIAMOND_GUARD_CHESTPLATE,
                TeadItems.DIAMOND_PLATE_HELMET,
                TeadItems.DIAMOND_PLATE_CHESTPLATE,
                TeadItems.DIAMOND_PLATE_BOOTS,
                TeadItems.DIAMOND_THIEF_HELMET,
                TeadItems.DIAMOND_THIEF_CHESTPLATE,
                TeadItems.DIAMOND_GHOSTLY_HELMET,
                TeadItems.DIAMOND_GHOSTLY_CHESTPLATE,
                TeadItems.DIAMOND_GHOSTLY_BOOTS,
                TeadItems.DIAMOND_WOOLEN_HELMET,
                TeadItems.DIAMOND_WOOLEN_CHESTPLATE,
                TeadItems.DIAMOND_WOOLEN_LEGGINGS,
                TeadItems.DIAMOND_WOOLEN_BOOTS,

                TeadItems.NETHERITE_HIGHLAND_HELMET,
                TeadItems.NETHERITE_HIGHLAND_CHESTPLATE,
                TeadItems.NETHERITE_GUARD_HELMET,
                TeadItems.NETHERITE_GUARD_CHESTPLATE,
                TeadItems.NETHERITE_PLATE_HELMET,
                TeadItems.NETHERITE_PLATE_CHESTPLATE,
                TeadItems.NETHERITE_PLATE_BOOTS,
                TeadItems.NETHERITE_THIEF_HELMET,
                TeadItems.NETHERITE_THIEF_CHESTPLATE,
                TeadItems.NETHERITE_GHOSTLY_HELMET,
                TeadItems.NETHERITE_GHOSTLY_CHESTPLATE,
                TeadItems.NETHERITE_GHOSTLY_BOOTS,
                TeadItems.NETHERITE_WOOLEN_HELMET,
                TeadItems.NETHERITE_WOOLEN_CHESTPLATE,
                TeadItems.NETHERITE_WOOLEN_LEGGINGS,
                TeadItems.NETHERITE_WOOLEN_BOOTS,

                TeadItems.ROSE_NETHERITE_HIGHLAND_HELMET,
                TeadItems.ROSE_NETHERITE_HIGHLAND_CHESTPLATE,
                TeadItems.ROSE_NETHERITE_GUARD_HELMET,
                TeadItems.ROSE_NETHERITE_GUARD_CHESTPLATE,
                TeadItems.ROSE_NETHERITE_PLATE_HELMET,
                TeadItems.ROSE_NETHERITE_PLATE_CHESTPLATE,
                TeadItems.ROSE_NETHERITE_PLATE_BOOTS,
                TeadItems.ROSE_NETHERITE_THIEF_HELMET,
                TeadItems.ROSE_NETHERITE_THIEF_CHESTPLATE,
                TeadItems.ROSE_NETHERITE_GHOSTLY_HELMET,
                TeadItems.ROSE_NETHERITE_GHOSTLY_CHESTPLATE,
                TeadItems.ROSE_NETHERITE_GHOSTLY_BOOTS,
                TeadItems.ROSE_NETHERITE_WOOLEN_HELMET,
                TeadItems.ROSE_NETHERITE_WOOLEN_CHESTPLATE,
                TeadItems.ROSE_NETHERITE_WOOLEN_LEGGINGS,
                TeadItems.ROSE_NETHERITE_WOOLEN_BOOTS,

                TeadItems.WHITE_NETHERITE_HIGHLAND_HELMET,
                TeadItems.WHITE_NETHERITE_HIGHLAND_CHESTPLATE,
                TeadItems.WHITE_NETHERITE_GUARD_HELMET,
                TeadItems.WHITE_NETHERITE_GUARD_CHESTPLATE,
                TeadItems.WHITE_NETHERITE_PLATE_HELMET,
                TeadItems.WHITE_NETHERITE_PLATE_CHESTPLATE,
                TeadItems.WHITE_NETHERITE_PLATE_BOOTS,
                TeadItems.WHITE_NETHERITE_THIEF_HELMET,
                TeadItems.WHITE_NETHERITE_THIEF_CHESTPLATE,
                TeadItems.WHITE_NETHERITE_GHOSTLY_HELMET,
                TeadItems.WHITE_NETHERITE_GHOSTLY_CHESTPLATE,
                TeadItems.WHITE_NETHERITE_GHOSTLY_BOOTS,
                TeadItems.WHITE_NETHERITE_WOOLEN_HELMET,
                TeadItems.WHITE_NETHERITE_WOOLEN_CHESTPLATE,
                TeadItems.WHITE_NETHERITE_WOOLEN_LEGGINGS,
                TeadItems.WHITE_NETHERITE_WOOLEN_BOOTS
        );

        Tead.LOGGER.info("Client mod for " + Tead.MOD_ID + " fully initialized");
    }
}
