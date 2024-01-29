package net.pythonbear.tead.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.*;
import net.minecraft.registry.tag.TagKey;
import net.pythonbear.tead.init.TeadTags;

public class HammerItem extends MiningToolItem implements Vanishable  {
    protected final float miningSpeed;
    private final TagKey<Block> effectiveBlocks;

    public HammerItem(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(attackDamage, attackSpeed, material, TeadTags.Blocks.REFINED_BUILDING_BLOCKS, settings);
        this.miningSpeed = material.getMiningSpeedMultiplier() + 1;
        this.effectiveBlocks = TeadTags.Blocks.REFINED_BUILDING_BLOCKS;
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return state.isIn(this.effectiveBlocks) ? this.miningSpeed : 1.0F;
    }
}
