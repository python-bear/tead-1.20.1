package net.pythonbear.tead.item.armor;

import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.DyeableItem;

public class RobeArmorItem extends DyeableArmorItem implements DyeableItem {
    public RobeArmorItem(ArmorMaterial armorMaterial, Type type, Settings settings) {
        super(armorMaterial, type, settings);
    }
}
