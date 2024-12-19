package net.pythonbear.tead.entity.arrow;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.pythonbear.tead.sound.TeadSounds;

import java.util.List;

public class WindSpectralArrowEntity extends SpectralArrowEntity {
    public WindSpectralArrowEntity(EntityType<? extends SpectralArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public WindSpectralArrowEntity(World world, LivingEntity owner) {
        super(world, owner);
    }

    public WindSpectralArrowEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        if (!this.getWorld().isClient) {
            ServerWorld world = (ServerWorld) this.getWorld();
            Vec3d pos = blockHitResult.getPos();

            double range = 2.5;

            List<Entity> entities = world.getEntitiesByClass(
                    Entity.class,
                    this.getBoundingBox().expand(range),
                    e -> !(e instanceof ProjectileEntity)
            );

            summonWindParticles(world, pos);
            world.playSound(null, blockHitResult.getBlockPos(), TeadSounds.BREEZE, SoundCategory.PLAYERS);

            for (Entity entity : entities) {
                double dx = entity.getX() - pos.getX();
                double dy = entity.getY() - pos.getY();
                double dz = entity.getZ() - pos.getZ();
                double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

                double strength = (1.0 / (distance + 0.1)) * ((double) 6 / 3);

                entity.addVelocity(dx * strength, dy * strength, dz * strength);
                entity.velocityModified = true;
            }
        }
    }

    @Override
    protected void onHit(LivingEntity target) {
        super.onHit(target);
        if (!this.getWorld().isClient) {
            ServerWorld world = (ServerWorld) target.getWorld();

            StatusEffectInstance statusEffectInstance = new StatusEffectInstance(StatusEffects.GLOWING, 200, 0);
            target.addStatusEffect(statusEffectInstance, this.getEffectCause());

            double range = 2.5;

            List<Entity> entities = world.getEntitiesByClass(
                    Entity.class,
                    target.getBoundingBox().expand(range),
                    e -> e != target && !(e instanceof ProjectileEntity)
            );

            summonWindParticles(world, target.getPos());
            world.playSound(null, target.getBlockPos(), TeadSounds.BREEZE, SoundCategory.PLAYERS);

            for (Entity entity : entities) {
                double dx = entity.getX() - target.getX();
                double dy = entity.getY() - target.getY();
                double dz = entity.getZ() - target.getZ();
                double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

                double strength = (1.0 / (distance + 0.1)) * ((double) 6 / 3);

                entity.addVelocity(dx * strength, dy * strength, dz * strength);
                entity.velocityModified = true;
            }
        }
    }

    private void summonWindParticles(ServerWorld world, Vec3d targetPos) {
        for (int i = 0; i < 30; i++) {
            double angle = 2 * Math.PI * i / 30;
            double radius = 3;

            double offsetX = MathHelper.cos((float) angle) * radius;
            double offsetZ = MathHelper.sin((float) angle) * radius;

            Vec3d particlePos = new Vec3d(targetPos.x + offsetX, targetPos.y + 0.5, targetPos.z + offsetZ);

            world.spawnParticles(
                    ParticleTypes.EFFECT, particlePos.x, particlePos.y, particlePos.z, 1,
                    -(offsetX / 5), 0.02 + world.getRandom().nextDouble(), -(offsetZ / 5), 0.1
            );
            world.spawnParticles(
                    ParticleTypes.EXPLOSION, particlePos.x, particlePos.y, particlePos.z, 1,
                    -(offsetX / 5), 0.02 + world.getRandom().nextDouble(), -(offsetZ / 5), 0.2
            );
        }
    }
}
