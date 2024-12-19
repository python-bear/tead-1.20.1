package net.pythonbear.tead.rendering;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.entity.SpearEntity;

public class SpearEntityRenderer extends EntityRenderer<SpearEntity> {
    private final ItemRenderer itemRenderer;

    public SpearEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.itemRenderer = ctx.getItemRenderer();
    }

    @Override
    public void render(SpearEntity spearEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider
            vertexConsumerProvider, int i) {

        ItemStack stackToRender = spearEntity.asItemStack();

        if (stackToRender == null) {
            return;
        }

        matrixStack.push();
        matrixStack.scale(3.0f, 3.0f, 1.5f);
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(g, spearEntity.prevYaw, spearEntity.getYaw()) - 90.0f));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(g, spearEntity.prevPitch, spearEntity.getPitch()) - 45.0f));
        this.itemRenderer.renderItem(stackToRender, ModelTransformationMode.GROUND, i, OverlayTexture.DEFAULT_UV, matrixStack, vertexConsumerProvider, spearEntity.getWorld(), spearEntity.getId());
        matrixStack.pop();
        super.render(spearEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(SpearEntity spearEntity) {
        ItemStack spearStack = spearEntity.asItemStack();
        if (spearStack == null) {
            Tead.LOGGER.error("Missing attribute spearEntity.spearStack for spear entity.");
            return null;
        } else {
            return spearStack.getRegistryEntry().getKey().get().getValue();
        }
    }
}