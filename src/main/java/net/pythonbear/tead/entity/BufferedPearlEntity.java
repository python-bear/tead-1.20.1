package net.pythonbear.tead.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.pythonbear.tead.item.TeadItems;
import org.jetbrains.annotations.Nullable;

public class BufferedPearlEntity
        extends ThrownItemEntity {
    public BufferedPearlEntity(EntityType<? extends BufferedPearlEntity> entityType, World world) {
        super(entityType, world);
    }

    public BufferedPearlEntity(World world, LivingEntity owner) {
        super(TeadEntityTypes.BUFFERED_PEARL, owner, world);
    }

    public BufferedPearlEntity(World world, double x, double y, double z) {
        this(TeadEntityTypes.BUFFERED_PEARL, world);
        this.setPosition(x, y, z);
    }

    @Override
    protected Item getDefaultItem() {
        return TeadItems.BUFFERED_PEARL;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        entityHitResult.getEntity().damage(this.getDamageSources().thrown(this, this.getOwner()), 0.0f);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        for (int i = 0; i < 32; ++i) {
            this.getWorld().addParticle(ParticleTypes.PORTAL, this.getX(),
                    this.getY() + this.random.nextDouble() * 2.0, this.getZ(), this.random.nextGaussian(),
                    0.0, this.random.nextGaussian());
        }
        if (!this.getWorld().isClient && !this.isRemoved()) {
            Entity entity = this.getOwner();
            if (entity instanceof ServerPlayerEntity) {
                ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)entity;
                if (serverPlayerEntity.networkHandler.isConnectionOpen()
                        && serverPlayerEntity.getWorld() == this.getWorld() && !serverPlayerEntity.isSleeping()) {
                    if (entity.hasVehicle()) {
                        serverPlayerEntity.requestTeleportAndDismount(this.getX(), this.getY(), this.getZ());
                    } else {
                        entity.requestTeleport(this.getX(), this.getY(), this.getZ());
                    }
                    entity.onLanding();
                }
            } else if (entity != null) {
                entity.requestTeleport(this.getX(), this.getY(), this.getZ());
                entity.onLanding();
            }
            this.discard();
        }
    }

    @Override
    public void tick() {
        Entity entity = this.getOwner();
        if (entity instanceof PlayerEntity && !entity.isAlive()) {
            this.discard();
        } else {
            super.tick();
        }
    }

    @Override
    @Nullable
    public Entity moveToWorld(ServerWorld destination) {
        Entity entity = this.getOwner();
        if (entity != null && entity.getWorld().getRegistryKey() != destination.getRegistryKey()) {
            this.setOwner(null);
        }
        return super.moveToWorld(destination);
    }
}