package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;

public class GreatSwordItem extends BladedWeaponItem {
    public GreatSwordItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, toolMaterial.getAttackDamage() + 5, 1.1f, 0,
                0, 0, 0, 2, false,
                settings.maxDamage(toolMaterial.getDurability() + 32));
    }
}
