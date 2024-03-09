package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;

public class HatchetItem extends BladedWeaponItem {
    public HatchetItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, toolMaterial.getAttackDamage() + 4, 1.5f, 0,
                0, 0, 0, 0, true,
                settings.maxDamage(toolMaterial.getDurability()));
    }
}
