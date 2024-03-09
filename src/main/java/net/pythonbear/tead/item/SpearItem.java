package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;

public class SpearItem extends BladedWeaponItem{
    public SpearItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, toolMaterial.getAttackDamage() + 3, 1.9f, 0,
                0, 0, 0, 1, false,
                settings.maxDamage(toolMaterial.getDurability()));
    }
}
