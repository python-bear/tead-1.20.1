package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;

public class TempestKnifeItem extends BladedWeaponItem {
    public TempestKnifeItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, toolMaterial.getAttackDamage() + 4, 1.6f, 0,
                0, 0, 0, 1.5f, false,
                settings.maxDamage(toolMaterial.getDurability() + 16));
    }
    // double speed for one and a half seconds after killing a mob
}
