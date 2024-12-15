package net.pythonbear.tead.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import net.pythonbear.tead.item.TeadItems;


public class TNTArrowEntity extends PersistentProjectileEntity {
    public TNTArrowEntity(World world, LivingEntity owner) {
        super(TeadEntityTypes.TNT_ARROW, owner, world);
    }

    public TNTArrowEntity(World world, double x, double y, double z) {
        super(TeadEntityTypes.TNT_ARROW, x, y, z, world);
    }

    public TNTArrowEntity(EntityType<TNTArrowEntity> arrowEntity, World world) {
        super(arrowEntity, world);
    }

    public void initFromStack(ItemStack stack) {}

    @Override
    protected void onHit(LivingEntity target) {
        World world = this.getWorld();
        TntEntity tnt = new TntEntity(EntityType.TNT, world);
        tnt.setPosition(target.getPos());
        tnt.setFuse(1);
        world.spawnEntity(tnt);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);

        World world = this.getWorld();
        TntEntity tnt = new TntEntity(EntityType.TNT, world);
        tnt.setPosition(this.getPos());
        tnt.setFuse(1);
        world.spawnEntity(tnt);
        this.kill();
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(TeadItems.TNT_ARROW);
    }
}
