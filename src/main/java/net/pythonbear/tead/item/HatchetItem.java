package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Vanishable;

public class HatchetItem extends BladedWeaponItem implements Vanishable {
    public HatchetItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings, false);
    }
}
