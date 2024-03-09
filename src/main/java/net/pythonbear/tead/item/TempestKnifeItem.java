package net.pythonbear.tead.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Vanishable;

public class TempestKnifeItem extends BladedWeaponItem implements Vanishable {
    public TempestKnifeItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings, false);
    }
}
