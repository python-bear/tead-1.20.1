package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;

public class RiteDaggerItem extends BladedWeaponItem {
    public RiteDaggerItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, toolMaterial.getAttackDamage() + 2.5f, 2.1f, 0,
                0, 0, 0, 1.5f, true,
                settings.maxDamage(toolMaterial.getDurability()));
    }
}
