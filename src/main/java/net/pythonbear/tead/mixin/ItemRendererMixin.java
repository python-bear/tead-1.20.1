package net.pythonbear.tead.mixin;

import net.pythonbear.tead.Tead;
import net.pythonbear.tead.item.TeadItems;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel use3dModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode,
                                 boolean leftHanded, MatrixStack matrices,
                                 VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(TeadItems.WOOD_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "wood_hammer_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.WOOD_MACE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "wood_mace_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.STONE_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "stone_hammer_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.STONE_MACE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "stone_mace_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.GOLD_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "gold_hammer_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.GOLD_MACE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "gold_mace_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.LEAD_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "lead_hammer_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.LEAD_MACE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "lead_mace_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.COPPER_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "copper_hammer_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.COPPER_MACE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "copper_mace_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.ROSE_GOLD_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "rose_gold_hammer_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.ROSE_GOLD_MACE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "rose_gold_mace_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.WHITE_GOLD_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "white_gold_hammer_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.WHITE_GOLD_MACE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "white_gold_mace_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.IRON_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "iron_hammer_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.IRON_MACE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "iron_mace_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.BRASS_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "brass_hammer_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.BRASS_MACE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "brass_mace_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.BRONZE_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "bronze_hammer_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.BRONZE_MACE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "bronze_mace_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.STEEL_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "steel_hammer_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.STEEL_MACE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "steel_mace_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.DIAMOND_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "diamond_hammer_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.DIAMOND_MACE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "diamond_mace_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.NETHERITE_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "netherite_hammer_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.NETHERITE_MACE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "netherite_mace_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.ROSE_NETHERITE_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "rose_netherite_hammer_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.ROSE_NETHERITE_MACE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "rose_netherite_mace_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.WHITE_NETHERITE_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "white_netherite_hammer_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.WHITE_NETHERITE_MACE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "white_netherite_mace_3d", "inventory"));
        }
        if (stack.isOf(TeadItems.GRAVITY_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "gravity_hammer_3d", "inventory"));
        }
        return value;
    }
}