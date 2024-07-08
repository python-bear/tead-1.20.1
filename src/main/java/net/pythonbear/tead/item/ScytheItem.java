package net.pythonbear.tead.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public class ScytheItem extends BladedWeaponItem {
    private final TagKey<Block> effectiveBlocks;
    protected final float miningSpeed;
    public ScytheItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, 3, 0.8f, 0, 0, 0,
                0, -0.2f, false, settings);
        this.effectiveBlocks = BlockTags.HOE_MINEABLE;
        this.miningSpeed = toolMaterial.getMiningSpeedMultiplier() - 0.2f;
    }

    @Override
    public boolean isSuitableFor(BlockState state) {
        return state.isIn(BlockTags.HOE_MINEABLE);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return state.isIn(this.effectiveBlocks) ? this.miningSpeed : 1.0f;
    }
}
