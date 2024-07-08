package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;

public class TruthseekerItem extends BladedWeaponItem {
    public TruthseekerItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, 4.1f, 1.5f, 0, 0, 0,
                0, 1.5f, false,
                settings.maxDamage(toolMaterial.getDurability() + 8));
    }
}
