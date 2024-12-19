package net.pythonbear.tead.entity.arrow;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pythonbear.tead.block.TeadBlocks;

public class WebbedArrowEntity extends ArrowEntity {
    public WebbedArrowEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public WebbedArrowEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    public WebbedArrowEntity(World world, LivingEntity owner) {
        super(world, owner);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        if (!this.getWorld().isClient) {
            ServerWorld world = (ServerWorld) this.getWorld();
            BlockPos blockPos = this.getBlockPos();

            world.setBlockState(blockPos, TeadBlocks.WEAK_COBWEB.getDefaultState());
        }
    }

    @Override
    protected void onHit(LivingEntity target) {
        super.onHit(target);
        if (!this.getWorld().isClient) {
            ServerWorld world = (ServerWorld) target.getWorld();
            BlockPos blockPos = target.getBlockPos();

            world.setBlockState(blockPos, TeadBlocks.WEAK_COBWEB.getDefaultState());
        }
    }
}
