package net.pythonbear.tead.item;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class HighlandAxeItem extends BladedWeaponItem {
    public HighlandAxeItem(ToolMaterial toolMaterial, Item.Settings settings) {
        super(toolMaterial, toolMaterial.getAttackDamage() + 7, 0.9f, 0.1f,
                0.6f, 0, 0, 0, false,
                settings.maxDamage(toolMaterial.getDurability() + 16));
    }
}
