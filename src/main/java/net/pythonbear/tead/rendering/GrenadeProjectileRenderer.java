package net.pythonbear.tead.rendering;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.ItemEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.pythonbear.tead.entity.GrenadeProjectileEntity;
import net.pythonbear.tead.item.TeadItems;

public class GrenadeProjectileRenderer extends EntityRenderer<GrenadeProjectileEntity> {
    private final ItemRenderer itemRenderer;

    public GrenadeProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.itemRenderer = ctx.getItemRenderer();
    }

    @Override
    protected int getBlockLight(GrenadeProjectileEntity entity, BlockPos pos) {
        return super.getBlockLight(entity, pos);
    }

    @Override
    public void render(GrenadeProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        if (entity.age < 2 && this.dispatcher.camera.getFocusedEntity().squaredDistanceTo((Entity)entity) < 12.25) {
            return;
        }
        matrices.push();
        matrices.multiply(this.dispatcher.getRotation());
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0f));
        this.itemRenderer.renderItem(TeadItems.GRENADE_ENTITY.getDefaultStack(), ModelTransformationMode.GROUND, light,
                OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, ((Entity)entity).getWorld(), ((Entity)entity).getId());
        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(GrenadeProjectileEntity entity) {
        return SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE;
    }
}
