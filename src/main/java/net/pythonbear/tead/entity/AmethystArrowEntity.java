package net.pythonbear.tead.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import net.pythonbear.tead.item.TeadItems;


public class AmethystArrowEntity extends PersistentProjectileEntity {
    public AmethystArrowEntity(World world, LivingEntity owner) {
        super(TeadEntityTypes.AMETHYST_ARROW, owner, world);
    }

    public AmethystArrowEntity(World world, double x, double y, double z) {
        super(TeadEntityTypes.AMETHYST_ARROW, x, y, z, world);
    }

    public AmethystArrowEntity(EntityType<AmethystArrowEntity> arrowEntity, World world) {
        super(arrowEntity, world);
    }

    public void initFromStack(ItemStack stack) {}

    @Override
    protected void onHit(LivingEntity target) {
        super.onHit(target);
        this.playSound(SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, 1.5f, 1.0f);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        this.playSound(SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, 5f, 1.0f);
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(TeadItems.AMETHYST_ARROW);
    }
}
