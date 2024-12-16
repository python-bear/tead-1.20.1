package net.pythonbear.tead.rendering;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.entity.*;
import net.pythonbear.tead.entity.arrow.*;

@Environment(value=EnvType.CLIENT)
public class CustomArrowEntityRenderer extends ProjectileEntityRenderer<PersistentProjectileEntity> {
    public static final Identifier AMETHYST = new Identifier(Tead.MOD_ID,
            "textures/entity/projectiles/amethyst_arrow.png");
    public static final Identifier BORING = new Identifier(Tead.MOD_ID,
            "textures/entity/projectiles/boring_arrow.png");
    public static final Identifier COPPER = new Identifier(Tead.MOD_ID,
            "textures/entity/projectiles/copper_arrow.png");
    public static final Identifier ENDER_PEARL = new Identifier(Tead.MOD_ID,
            "textures/entity/projectiles/ender_pearl_arrow.png");
    public static final Identifier OBSIDIAN = new Identifier(Tead.MOD_ID,
            "textures/entity/projectiles/obsidian_arrow.png");
    public static final Identifier REDSTONE_TORCH = new Identifier(Tead.MOD_ID,
            "textures/entity/projectiles/redstone_torch_arrow.png");
    public static final Identifier TORCH = new Identifier(Tead.MOD_ID,
            "textures/entity/projectiles/torch_arrow.png");
    public static final Identifier SOUL_TORCH = new Identifier(Tead.MOD_ID,
            "textures/entity/projectiles/soul_torch_arrow.png");
    public static final Identifier RUBY = new Identifier(Tead.MOD_ID,
            "textures/entity/projectiles/ruby_arrow.png");
    public static final Identifier TRANSMORPHING = new Identifier(Tead.MOD_ID,
            "textures/entity/projectiles/transmorphing_arrow.png");
    public static final Identifier TNT = new Identifier(Tead.MOD_ID,
            "textures/entity/projectiles/tnt_arrow.png");
    public static final Identifier ARROW = new Identifier("minecraft",
            "textures/entity/projectiles/arrow.png");


    public CustomArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(PersistentProjectileEntity arrowEntity) {
        if (arrowEntity instanceof AmethystArrowEntity) {
            return AMETHYST;
        } else if (arrowEntity instanceof BoringArrowEntity) {
            return BORING;
        } else if (arrowEntity instanceof CopperArrowEntity) {
            return COPPER;
        } else if (arrowEntity instanceof EnderPearlArrowEntity) {
            return ENDER_PEARL;
        } else if (arrowEntity instanceof ObsidianArrowEntity) {
            return OBSIDIAN;
        } else if (arrowEntity instanceof RedstoneTorchArrowEntity) {
            return REDSTONE_TORCH;
        } else if (arrowEntity instanceof TorchArrowEntity) {
            return TORCH;
        } else if (arrowEntity instanceof SoulTorchArrowEntity) {
            return SOUL_TORCH;
        } else if (arrowEntity instanceof RubyArrowEntity) {
            return RUBY;
        } else if (arrowEntity instanceof TransmorphingArrowEntity) {
            return TRANSMORPHING;
        } else if (arrowEntity instanceof TNTArrowEntity) {
            return TNT;
        } else {
            return ARROW;
        }
    }
}

