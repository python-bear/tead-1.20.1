package net.pythonbear.tead.entity;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.init.TeadBlocks;
import net.pythonbear.tead.sound.TeadSounds;

import java.util.List;

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

    public WebbedArrowEntity(World world, LivingEntity owner, double x, double y, double z) {
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
