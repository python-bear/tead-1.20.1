package net.pythonbear.tead.item;

import net.minecraft.item.Item;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class MattockItem
        extends MiningToolItem {
    public MattockItem(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(attackDamage, attackSpeed, material, BlockTags.PICKAXE_MINEABLE, settings);
    }
}
