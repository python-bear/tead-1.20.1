package net.pythonbear.tead.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pythonbear.tead.init.TeadTags;

public class SickleItem extends BladedWeaponItem implements Vanishable {
    private final TagKey<Block> effectiveBlocks;
    protected final float miningSpeed;
    public SickleItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings, true);
        this.effectiveBlocks = BlockTags.HOE_MINEABLE;
        this.miningSpeed = toolMaterial.getMiningSpeedMultiplier();
    }
    @Override
    public boolean isSuitableFor(BlockState state) {
        return state.isIn(BlockTags.HOE_MINEABLE);
    }
    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return state.isIn(this.effectiveBlocks) ? this.miningSpeed * 2 : 1.0f;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (state.isIn(BlockTags.LEAVES)) {
            ItemEntity leafItem = new ItemEntity(EntityType.ITEM, world);
            leafItem.setPosition(pos.toCenterPos());
            leafItem.setStack(state.getBlock().asItem().getDefaultStack());
            world.spawnEntity(leafItem);
        }
        stack.damage(2, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return true;
    }
}
