package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Vanishable;

public class MaceItem extends BladedWeaponItem implements Vanishable {
    public MaceItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings, false);
    }
}
