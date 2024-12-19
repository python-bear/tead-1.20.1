package net.pythonbear.tead.entity.arrow;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pythonbear.tead.entity.TeadEntityTypes;

public class WebbedSpectralArrowEntity extends SpectralArrowEntity {
    public WebbedSpectralArrowEntity(EntityType<? extends SpectralArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public WebbedSpectralArrowEntity(World world, LivingEntity owner) {
        super(world, owner);
    }

    public WebbedSpectralArrowEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        if (!this.getWorld().isClient) {
            ServerWorld world = (ServerWorld) this.getWorld();
            BlockPos blockPos = this.getBlockPos();

            world.setBlockState(blockPos, Blocks.COBWEB.getDefaultState());
        }
    }

    @Override
    protected void onHit(LivingEntity target) {
        super.onHit(target);
        if (!this.getWorld().isClient) {
            ServerWorld world = (ServerWorld) target.getWorld();
            BlockPos blockPos = target.getBlockPos();

            StatusEffectInstance statusEffectInstance = new StatusEffectInstance(StatusEffects.GLOWING, 200, 0);
            target.addStatusEffect(statusEffectInstance, this.getEffectCause());

            world.setBlockState(blockPos, Blocks.COBWEB.getDefaultState());
        }
    }
}
