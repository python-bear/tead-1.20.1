package net.pythonbear.tead.rendering;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.*;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.entity.ShotgunProjectileEntity;
import net.pythonbear.tead.init.TeadItems;

public class ShotgunProjectileRenderer extends ProjectileEntityRenderer<ShotgunProjectileEntity> {
    private final ItemRenderer itemRenderer;
    private final float scale;

    public ShotgunProjectileRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
        this.scale = 0.4f;
    }

    @Override
    public void render(ShotgunProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light) {
        if (entity.age >= 2 || !(this.dispatcher.camera.getFocusedEntity().squaredDistanceTo(entity) < 12.25)) {
            matrices.push();
            matrices.scale(this.scale, this.scale, this.scale);
            matrices.multiply(this.dispatcher.getRotation());
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F));
            this.itemRenderer.renderItem(TeadItems.SHOTGUN_PROJECTILE.getDefaultStack(), ModelTransformationMode.GROUND,
                    light, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), entity.getId());
            matrices.pop();
//            super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
        }
    }

    @Override
    public Identifier getTexture(ShotgunProjectileEntity entity) {
        return new Identifier(Tead.MOD_ID, "assets/textures/item/shotgun_projectile.png");
    }
}
