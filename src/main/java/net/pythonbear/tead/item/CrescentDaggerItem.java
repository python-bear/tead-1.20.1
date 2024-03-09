package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;

public class CrescentDaggerItem extends BladedWeaponItem {
    public CrescentDaggerItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, toolMaterial.getAttackDamage() + 3.5f, 1.9f, 0,
                0, 0, 0, 1.5f, true,
                settings.maxDamage(toolMaterial.getDurability()));
    }
}
