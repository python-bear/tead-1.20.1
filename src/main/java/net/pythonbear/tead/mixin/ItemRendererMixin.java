package net.pythonbear.tead.mixin;

import net.pythonbear.tead.Tead;
import net.pythonbear.tead.init.TeadItems;
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
    public BakedModel useHammerModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode,
                                        boolean leftHanded, MatrixStack matrices,
                                        VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(TeadItems.STONE_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).tead$getModels().getModelManager().getModel(
                    new ModelIdentifier(Tead.MOD_ID, "stone_hammer_3d", "inventory"));
        }
        return value;
    }
}