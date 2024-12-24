package net.pythonbear.tead.item.tool;

import net.minecraft.item.ToolMaterial;

public class RanseurItem extends BladedWeaponItem {
    public RanseurItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, 3.5f, 1.8f, 0, 0, 0,
                0, 1, false, settings.maxDamage(toolMaterial.getDurability() + 8));
    }
}
