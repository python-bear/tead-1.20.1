package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;

public class DoubleAxeItem extends BladedWeaponItem {
    public DoubleAxeItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, toolMaterial.getAttackDamage() + 8, 0.6f, 0,
                0, 0, 0, 0, false,
                settings.maxDamage(toolMaterial.getDurability()));
    }
}
