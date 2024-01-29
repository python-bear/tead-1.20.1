package net.pythonbear.tead.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.pythonbear.tead.init.TeadItems;

public class GrenadeProjectileEntity extends ThrownItemEntity {
    public GrenadeProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public GrenadeProjectileEntity(LivingEntity livingEntity, World world) {
        super(TeadEntities.GRENADE_PROJECTILE, livingEntity, world);
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
