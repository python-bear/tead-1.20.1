package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;

public class BroadswordItem extends BladedWeaponItem{
    public BroadswordItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, 9, 0.6f, 0.7f, 0.8f,
                1, 25, 2.5f, false,
                settings.maxDamage(toolMaterial.getDurability() + 48));
    }
}
