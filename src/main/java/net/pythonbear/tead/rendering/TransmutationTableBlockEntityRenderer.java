package net.pythonbear.tead.rendering;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.BookModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.pythonbear.tead.block.entity.TransmutationTableBlockEntity;

@Environment(value=EnvType.CLIENT)
public class TransmutationTableBlockEntityRenderer implements BlockEntityRenderer<TransmutationTableBlockEntity> {
    public static final SpriteIdentifier BOOK_TEXTURE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("entity/enchanting_table_book"));
    private final BookModel book;

    public TransmutationTableBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.book = new BookModel(ctx.getLayerModelPart(EntityModelLayers.BOOK));
    }

    @Override
    public void render(TransmutationTableBlockEntity transmutationTableBlockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
        float h;
        matrixStack.push();
        matrixStack.translate(0.5f, 0.75f, 0.5f);
        float g = (float)transmutationTableBlockEntity.ticks + f;
        matrixStack.translate(0.0f, 0.1f + MathHelper.sin(g * 0.1f) * 0.01f, 0.0f);
        for (h = transmutationTableBlockEntity.bookRotation - transmutationTableBlockEntity.lastBookRotation; h >= (float)Math.PI; h -= (float)Math.PI * 2) {
        }
        while (h < (float)(-Math.PI)) {
            h += (float)Math.PI * 2;
        }
        float k = transmutationTableBlockEntity.lastBookRotation + h * f;
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotation(-k));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(80.0f));
        float l = MathHelper.lerp(f, transmutationTableBlockEntity.pageAngle, transmutationTableBlockEntity.nextPageAngle);
        float m = MathHelper.fractionalPart(l + 0.25f) * 1.6f - 0.3f;
        float n = MathHelper.fractionalPart(l + 0.75f) * 1.6f - 0.3f;
        float o = MathHelper.lerp(f, transmutationTableBlockEntity.pageTurningSpeed, transmutationTableBlockEntity.nextPageTurningSpeed);
        this.book.setPageAngles(g, MathHelper.clamp(m, 0.0f, 1.0f), MathHelper.clamp(n, 0.0f, 1.0f), o);
        VertexConsumer vertexConsumer = BOOK_TEXTURE.getVertexConsumer(vertexConsumerProvider, RenderLayer::getEntitySolid);
        this.book.renderBook(matrixStack, vertexConsumer, i, j, 1.0f, 1.0f, 1.0f, 1.0f);
        matrixStack.pop();
    }
}

