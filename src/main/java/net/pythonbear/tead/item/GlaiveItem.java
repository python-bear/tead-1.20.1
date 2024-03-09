package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;

public class GlaiveItem extends BladedWeaponItem {
    public GlaiveItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, toolMaterial.getAttackDamage() + 4, 1.7f, 0.1f,
                0.7f, 0, 0, 1, false,
                settings.maxDamage(toolMaterial.getDurability() + 8));
    }
}
