package net.pythonbear.tead.rendering;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.entity.arrow.SpectralWindArrowEntity;

@Environment(value=EnvType.CLIENT)
public class SpectralWindArrowEntityRenderer
extends ProjectileEntityRenderer<SpectralWindArrowEntity> {
    public static final Identifier TEXTURE = new Identifier("minecraft",
            "textures/entity/projectiles/spectral_arrow.png");

    public SpectralWindArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(SpectralWindArrowEntity spectralArrowEntity) {
        return TEXTURE;
    }
}

