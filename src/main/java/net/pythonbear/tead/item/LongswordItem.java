package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;

public class LongswordItem extends BladedWeaponItem {
    public LongswordItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, toolMaterial.getAttackDamage() + 8, 0.7f, 0.4f,
                1, 1, 25, 2.5f, false,
                settings.maxDamage(toolMaterial.getDurability() + 32));
    }
}
