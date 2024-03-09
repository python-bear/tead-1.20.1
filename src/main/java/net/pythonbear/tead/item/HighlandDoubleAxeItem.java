package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;

public class HighlandDoubleAxeItem extends BladedWeaponItem {
    public HighlandDoubleAxeItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, toolMaterial.getAttackDamage() + 8, 0.7f, 0.2f,
                0.6f, 0, 0, 0, false,
                settings.maxDamage(toolMaterial.getDurability() + 16));
    }
}
