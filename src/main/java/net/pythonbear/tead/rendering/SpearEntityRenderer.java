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
import net.minecraft.registry.Registries;
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

        ItemStack stackToRender = spearEntity.getRenderStack();

        if (stackToRender.isEmpty()) {
            return;
        }

        float yaw = MathHelper.lerp(g, spearEntity.prevYaw, spearEntity.getYaw());
        float pitch = MathHelper.lerp(g, spearEntity.prevPitch, spearEntity.getPitch());

        matrixStack.push();
        // Point local +X along the direction of travel (same as vanilla arrows).
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(yaw - 90.0f));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(pitch));
        // Draw the sprite twice, rolled 90 degrees around the spear's shaft, like the crossed planes of an arrow,
        // so it doesn't turn paper-thin when seen from behind or in front.
        for (int k = 0; k < 2; k++) {
            matrixStack.push();
            matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(k * 90.0f));
            // The spear is drawn diagonally in its texture (tip at the top right), so turn it to lie along +X.
            matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-45.0f));
            // Scale in the spear's own frame. This used to be applied in world space before rotating, which
            // stretched or squashed the spear depending on which way it was thrown.
            matrixStack.scale(1.5f, 1.5f, 0.75f);
            // NONE rather than GROUND: the ground transform shifts the model upwards, which pushed the spear
            // off its line of flight.
            this.itemRenderer.renderItem(stackToRender, ModelTransformationMode.NONE, i, OverlayTexture.DEFAULT_UV,
                    matrixStack, vertexConsumerProvider, spearEntity.getWorld(), spearEntity.getId());
            matrixStack.pop();
        }
        matrixStack.pop();
        super.render(spearEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(SpearEntity spearEntity) {
        // Unused: the spear is drawn with the item renderer, which uses the item's own model and texture.
        return Registries.ITEM.getId(spearEntity.getRenderStack().getItem());
    }
}