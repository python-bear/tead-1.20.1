package net.pythonbear.tead.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.pythonbear.tead.init.TeadItems;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class ShotgunProjectileEntity extends ProjectileEntity implements Ownable, FlyingItemEntity {
    @Nullable
    private UUID ownerUuid;
    @Nullable
    private Entity owner;

    public ShotgunProjectileEntity(EntityType<? extends ShotgunProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public void setOwner(@Nullable Entity entity) {
        if (entity != null) {
            this.ownerUuid = entity.getUuid();
            this.owner = entity;
        }
    }

    @Override
    public void onSpawnPacket(EntitySpawnS2CPacket packet) {
        super.onSpawnPacket(packet);
        Entity entity = this.getWorld().getEntityById(packet.getEntityData());
        if (entity != null) {
            this.setOwner(entity);
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if (!this.getWorld().isClient() && entityHitResult.getEntity().isLiving()) {
            Entity owner = this.getOwner();
            DamageSource damageSource;
            if (owner == null) {
                damageSource = this.getDamageSources().thrown(this, this);
            } else {
                damageSource = this.getDamageSources().thrown(this, owner);
                if (owner instanceof LivingEntity) {
                    ((LivingEntity)owner).onAttacking(owner);
                }
            }
            entityHitResult.getEntity().damage(damageSource, 1);
        }
    }

    @Override
    protected void initDataTracker() {

    }

    @Override
    public ItemStack getStack() {
        return TeadItems.LEAD_BULLET.getDefaultStack();
    }
}
