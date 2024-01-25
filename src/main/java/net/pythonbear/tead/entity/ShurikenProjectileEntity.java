package net.pythonbear.tead.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.pythonbear.tead.init.TeadItems;

public class ShurikenProjectileEntity extends ThrownItemEntity {
    public ShurikenProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ShurikenProjectileEntity(LivingEntity livingEntity, World world) {
        super(TeadEntities.SHURIKEN_PROJECTILE, livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return TeadItems.SHURIKEN;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }
    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!this.getWorld().isClient()) {
            if (this.getWorld().getBlockState(blockHitResult.getBlockPos()).isTransparent(this.getWorld(),
                    blockHitResult.getBlockPos())) {
                this.discard();
            }
        }
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if (!this.getWorld().isClient()) {
            entityHitResult.getEntity().damage(this.getDamageSources().thrown(this, this.getOwner()), 6);
            this.discard();
        }
        super.onEntityHit(entityHitResult);
    }
}
