package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;

public class GreatswordItem extends BladedWeaponItem {
    public GreatswordItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, 5, 1.1f, 0, 0, 0,
                0, 2, false, settings.maxDamage(toolMaterial.getDurability() + 32));
    }
}
