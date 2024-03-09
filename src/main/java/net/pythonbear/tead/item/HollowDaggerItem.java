package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;

public class HollowDaggerItem extends BladedWeaponItem {
    public HollowDaggerItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, toolMaterial.getAttackDamage() + 3.25f, 1.8f, 0,
                0, 0, 0, 1.5f, true,
                settings.maxDamage(toolMaterial.getDurability() + 8));
    }
}
