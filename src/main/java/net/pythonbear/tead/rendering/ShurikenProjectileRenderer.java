package net.pythonbear.tead.rendering;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.pythonbear.tead.entity.ShurikenProjectileEntity;

public class ShurikenProjectileRenderer extends EntityRenderer<ShurikenProjectileEntity> {
    private final ItemRenderer itemRenderer;

    public ShurikenProjectileRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(ShurikenProjectileEntity shurikenEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(g, shurikenEntity.prevYaw, shurikenEntity.getYaw()) - 90.0f));
        this.itemRenderer.renderItem(shurikenEntity.getStack(), ModelTransformationMode.GROUND, i, OverlayTexture.DEFAULT_UV, matrixStack, vertexConsumerProvider, shurikenEntity.getWorld(), shurikenEntity.getId());
        matrixStack.pop();
        super.render(shurikenEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(ShurikenProjectileEntity entity) {
        return SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE;
    }
}
