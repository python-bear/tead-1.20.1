package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;

public class DaggerItem extends BladedWeaponItem{
    public DaggerItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings, true);
    }
}
