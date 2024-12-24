package net.pythonbear.tead.item.armor;

import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.DyeableItem;

public class GuardDyableArmorItem extends DyeableArmorItem implements DyeableItem {
    public GuardDyableArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
}
