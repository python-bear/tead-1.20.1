package net.pythonbear.tead.item.tool;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;
import net.pythonbear.tead.init.TeadTags;

public class MattockItem extends MiningToolItem {
    protected final float miningSpeed;
    private final TagKey<Block> effectiveBlocks;

    public MattockItem(ToolMaterial material, Item.Settings settings) {
        super(0.5f - 1, 1.1f - 4, material, TeadTags.Blocks.MATTOCK_MINEABLE,
                settings.maxDamage(material.getDurability() + 16));
        this.effectiveBlocks = TeadTags.Blocks.MATTOCK_MINEABLE;
        this.miningSpeed = material.getMiningSpeedMultiplier() - 0.4f;
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return state.isIn(this.effectiveBlocks) ? this.miningSpeed : 1.0f;
    }
}
