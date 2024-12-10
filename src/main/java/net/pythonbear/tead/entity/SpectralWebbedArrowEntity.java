package net.pythonbear.tead.entity;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.pythonbear.tead.init.TeadEntityTypes;
import net.pythonbear.tead.sound.TeadSounds;

import java.util.List;

public class SpectralWebbedArrowEntity extends PersistentProjectileEntity {
    public SpectralWebbedArrowEntity(World world, double x, double y, double z) {
        super(TeadEntityTypes.SPECTRAL_WIND_ARROW, x, y, z, world);
    }

    public SpectralWebbedArrowEntity(World world, LivingEntity owner) {
        super(TeadEntityTypes.SPECTRAL_WIND_ARROW, owner, world);
    }

    public SpectralWebbedArrowEntity(World world, LivingEntity owner, double x, double y, double z) {
        super(TeadEntityTypes.SPECTRAL_WIND_ARROW, owner, world);
    }

    public SpectralWebbedArrowEntity(EntityType<SpectralWebbedArrowEntity> spectralWindArrowEntityEntityType, World world) {
        super(spectralWindArrowEntityEntityType, world);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.getWorld().isClient && !this.inGround) {
            ((ServerWorld)this.getWorld()).spawnParticles(ParticleTypes.INSTANT_EFFECT, this.getX(), this.getY(),
                    this.getZ(), 1, 0, 0, 0,0);
        }
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

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(Items.SPECTRAL_ARROW);
    }
}
