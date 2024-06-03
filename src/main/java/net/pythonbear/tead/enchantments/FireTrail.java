package net.pythonbear.tead.enchantments;

import net.minecraft.block.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class FireTrail extends Enchantment {
    public FireTrail(Rarity weight, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(weight, target, slotTypes);
    }

    public static void setFire(LivingEntity entity, World world, BlockPos blockPos, int level) {
        if (!entity.isOnGround()) {
            return;
        }

        // Get the block position directly beneath the entity
        BlockPos entityPos = entity.getBlockPos();
        Block fireType = Blocks.FIRE;
        if (world.getBlockState(entityPos.down()) == Blocks.SOUL_SAND.getDefaultState() ||
                world.getBlockState(entityPos.down()) == Blocks.SOUL_SOIL.getDefaultState()) {
            fireType = Blocks.SOUL_FIRE;
        }

        BlockState blockState = fireType.getDefaultState();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        mutable.set(entityPos.getX(), entityPos.getY(), entityPos.getZ());

        BlockState blockState2 = world.getBlockState(mutable.up());

        if (world.getBlockState(entityPos).isAir() && blockState2.isAir() && blockState.canPlaceAt(world, entityPos) &&
                world.canPlace(blockState, entityPos, ShapeContext.absent())) {
            world.setBlockState(entityPos, blockState);
            world.scheduleBlockTick(entityPos, fireType, MathHelper.nextInt(entity.getRandom(), 60, 120));
        }
    }

    @Override
    public int getMinPower(int level) {
        return level * 15;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 20;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.DEPTH_STRIDER;
    }
}
