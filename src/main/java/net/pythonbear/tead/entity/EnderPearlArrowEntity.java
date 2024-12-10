package net.pythonbear.tead.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import net.pythonbear.tead.init.TeadEntityTypes;
import net.pythonbear.tead.init.TeadItems;


public class EnderPearlArrowEntity extends PersistentProjectileEntity {
    public EnderPearlArrowEntity(World world, LivingEntity owner) {
        super(TeadEntityTypes.ENDER_PEARL_ARROW, owner, world);
    }

    public EnderPearlArrowEntity(World world, double x, double y, double z) {
        super(TeadEntityTypes.ENDER_PEARL_ARROW, x, y, z, world);
    }

    public EnderPearlArrowEntity(EntityType<EnderPearlArrowEntity> arrowEntity, World world) {
        super(arrowEntity, world);
    }

    public void initFromStack(ItemStack stack) {}

    @Override
    public void tick() {
        super.tick();
        if (!this.getWorld().isClient && !this.inGround) {
            ((ServerWorld)this.getWorld()).spawnParticles(ParticleTypes.PORTAL, this.getX(), this.getY(),
                    this.getZ(), 1, 0, 0, 0,0);
        }
    }


    @Override
    protected void onHit(LivingEntity target) {
        Entity owner = this.getOwner();
        if (target == owner || owner == null){
            this.kill();
        } else {
            owner.teleport(target.getX(), target.getY(), target.getZ());
            this.kill();
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        Entity owner = this.getOwner();
        if (owner != null) {
            owner.teleport(blockHitResult.getPos().x, blockHitResult.getPos().y, blockHitResult.getPos().z);
        }
        this.kill();
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(TeadItems.ENDER_PEARL_ARROW);
    }
}
