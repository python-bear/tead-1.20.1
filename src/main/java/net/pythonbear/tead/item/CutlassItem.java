package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;

public class CutlassItem extends BladedWeaponItem {
    public CutlassItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, toolMaterial.getAttackDamage() + 4, 1.5f, 0,
                0, 0, 0, 2, false,
                settings.maxDamage(toolMaterial.getDurability()));
    }

}
