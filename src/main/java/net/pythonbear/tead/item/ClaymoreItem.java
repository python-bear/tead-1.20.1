package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;

public class ClaymoreItem extends BladedWeaponItem {
    public ClaymoreItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, toolMaterial.getAttackDamage() + 8.5f, 0.7f, 0.9f,
                0.8f, 1, 25, 2.5f, false,
                settings.maxDamage(toolMaterial.getDurability() + 32));
    }
}
