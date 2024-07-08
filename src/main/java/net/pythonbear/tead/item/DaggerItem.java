package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;

public class DaggerItem extends BladedWeaponItem {
    public DaggerItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, 3, 2, 0,
                0, 0, 0, 1.5f, true,
                settings.maxDamage(toolMaterial.getDurability()));
    }
}
