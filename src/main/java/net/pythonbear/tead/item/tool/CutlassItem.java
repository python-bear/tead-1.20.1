package net.pythonbear.tead.item.tool;

import net.minecraft.item.ToolMaterial;

public class CutlassItem extends BladedWeaponItem {
    public CutlassItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, 4, 1.5f, 0, 0, 0,
                0, 2, false, settings.maxDamage(toolMaterial.getDurability()));
    }
}
