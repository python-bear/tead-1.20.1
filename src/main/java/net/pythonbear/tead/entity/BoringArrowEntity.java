package net.pythonbear.tead.entity;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import net.pythonbear.tead.item.TeadItems;


public class BoringArrowEntity extends PersistentProjectileEntity {
    private int levelsMined = 0;

    public BoringArrowEntity(World world, LivingEntity owner) {
        super(TeadEntityTypes.BORING_ARROW, owner, world);
    }

    public BoringArrowEntity(World world, double x, double y, double z) {
        super(TeadEntityTypes.BORING_ARROW, x, y, z, world);
    }

    public BoringArrowEntity(EntityType<BoringArrowEntity> arrowEntity, World world) {
        super(arrowEntity, world);
    }

    public void initFromStack(ItemStack stack) {}

    @Override
    public void tick() {
        super.tick();
        if (!this.getWorld().isClient && !this.inGround) {
            ((ServerWorld)this.getWorld()).spawnParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, this.getX(), this.getY(),
                    this.getZ(), 1, 0, 1.5, 0, 0.1);
        }
    }

    @Override
    protected void onHit(LivingEntity target) {
        World world = this.getWorld();

        if (this.levelsMined > 14) {
            this.kill();
        }

        TntEntity boringTnt = new TntEntity(EntityType.TNT, world);
        boringTnt.setPosition(target.getPos());
        boringTnt.setFuse(1);
        world.spawnEntity(boringTnt);
        this.levelsMined += 1;
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);

        if (this.levelsMined > 14) {
            this.kill();
        }

        World world = this.getWorld();
        Block belowBlock = world.getBlockState(blockHitResult.getBlockPos()).getBlock();
        if (belowBlock == Blocks.BEDROCK || belowBlock == Blocks.LAVA || belowBlock == Blocks.WATER
                || world.getBlockState(this.getBlockPos()).isOf(Blocks.WATER)) {
            this.kill();
        } else {
            TntEntity boringTnt = new TntEntity(EntityType.TNT, world);
            boringTnt.setPosition(this.getPos());
            boringTnt.setFuse(1);
            world.spawnEntity(boringTnt);
            this.levelsMined += 1;
        }
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(TeadItems.BORING_ARROW);
    }
}
