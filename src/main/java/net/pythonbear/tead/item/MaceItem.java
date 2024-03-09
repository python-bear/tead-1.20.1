package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;

public class MaceItem extends BladedWeaponItem {
    public MaceItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, toolMaterial.getAttackDamage() + 4, 1.1f, 0,
                0, 0, 0, 1.75f, true,
                settings.maxDamage(toolMaterial.getDurability() + 32));
    }
}
