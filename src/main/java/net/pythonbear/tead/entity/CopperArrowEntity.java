package net.pythonbear.tead.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pythonbear.tead.init.TeadEntityTypes;
import net.pythonbear.tead.init.TeadItems;


public class CopperArrowEntity extends PersistentProjectileEntity {
    public CopperArrowEntity(World world, LivingEntity owner) {
        super(TeadEntityTypes.COPPER_ARROW, owner, world);
    }

    public CopperArrowEntity(World world, double x, double y, double z) {
        super(TeadEntityTypes.COPPER_ARROW, x, y, z, world);
    }

    public CopperArrowEntity(EntityType<CopperArrowEntity> arrowEntity, World world) {
        super(arrowEntity, world);
    }

    public void initFromStack(ItemStack stack) {}

    @Override
    protected void onHit(LivingEntity target) {
        World world = target.getWorld();
        if (!world.isClient()) {
            if (world.isRaining()) {
                spawnElectricParticles(((ServerWorld) world), this.getBlockPos());
                LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                lightning.setPosition(target.getPos());
                world.spawnEntity(lightning);
            }
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);

        World world = this.getWorld();
        if (!world.isClient()) {
            if (world.isRaining()) {
                spawnElectricParticles(((ServerWorld) world), this.getBlockPos());
                LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                lightning.setPosition(blockHitResult.getPos());
                world.spawnEntity(lightning);
                this.kill();
            }
        }
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(TeadItems.COPPER_ARROW);
    }

    private static void spawnElectricParticles(ServerWorld world, BlockPos pos) {
        for (int i = 0; i < 10; i++) {
            double offsetX = world.random.nextGaussian() * 0.5;
            double offsetY = world.random.nextGaussian() * 0.5;
            double offsetZ = world.random.nextGaussian() * 0.5;

            world.spawnParticles(
                    ParticleTypes.ELECTRIC_SPARK,
                    pos.getX() + 0.5 + offsetX,
                    pos.getY() + 0.5 + offsetY,
                    pos.getZ() + 0.5 + offsetZ,
                    1,
                    offsetX,
                    offsetY,
                    offsetZ,
                    0.05
            );
        }
    }
}
