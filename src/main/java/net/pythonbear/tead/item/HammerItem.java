package net.pythonbear.tead.item;

import net.minecraft.item.Item;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Vanishable;
import net.pythonbear.tead.init.TeadTags;

public class HammerItem extends MiningToolItem implements Vanishable  {
    public HammerItem(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(attackDamage, attackSpeed, material, TeadTags.Blocks.REFINED_BUILDING_BLOCKS, settings);
    }
}
