package net.pythonbear.tead.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.pythonbear.tead.item.TeadItems;

public class GrenadeProjectileEntity extends ThrownItemEntity {
    public GrenadeProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public GrenadeProjectileEntity(LivingEntity livingEntity, World world) {
        super(TeadEntityTypes.GRENADE_PROJECTILE, livingEntity, world);
    }

    @Override
    public void tick() {
        super.tick();
        World world = this.getWorld();
        Random random = world.getRandom();

        if (!world.isClient) {
            ((ServerWorld) world).spawnParticles(ParticleTypes.SMALL_FLAME, this.getX(), this.getY() + 0.5, this.getZ(), 1, random.nextFloat() * 0.5 - 0.25, random.nextFloat() * 0.5, random.nextFloat() * 0.5 - 0.25, 0.01);

            if (random.nextFloat() > 0.8) {
                world.playSoundFromEntity(null, this, SoundEvents.ENTITY_CREEPER_PRIMED, SoundCategory.HOSTILE, 0.5f, 1);
            }
        }
    }

    @Override
    protected Item getDefaultItem() {
        return TeadItems.GRENADE;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            TntEntity tnt = new TntEntity(EntityType.TNT, this.getWorld());
            tnt.setPosition(this.getPos());
            tnt.setFuse(1);
            this.getWorld().spawnEntity(tnt);
            this.discard();
        }
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if (!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            TntEntity tnt = new TntEntity(EntityType.TNT, this.getWorld());
            tnt.setPosition(this.getPos());
            tnt.setFuse(1);
            this.getWorld().spawnEntity(tnt);
            this.discard();
        }
        super.onEntityHit(entityHitResult);
    }
}
