package net.pythonbear.tead.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;


public class ExplosiveSpectralArrowEntity extends SpectralArrowEntity {
    public ExplosiveSpectralArrowEntity(EntityType<? extends SpectralArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public ExplosiveSpectralArrowEntity(World world, LivingEntity owner) {
        super(world, owner);
    }

    public ExplosiveSpectralArrowEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    @Override
    protected void onHit(LivingEntity target) {
        super.onHit(target);
        World world = this.getWorld();
        world.createExplosion(null, this.getX(), this.getY(), this.getZ(), 2.0f, false, World.ExplosionSourceType.NONE);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        World world = this.getWorld();
        world.createExplosion(null, this.getX(), this.getY(), this.getZ(), 2.0f, false, World.ExplosionSourceType.NONE);
        this.kill();
    }
}
