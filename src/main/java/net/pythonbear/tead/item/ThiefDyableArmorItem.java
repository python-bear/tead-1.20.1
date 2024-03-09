package net.pythonbear.tead.item;

import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.DyeableItem;

public class ThiefDyableArmorItem extends DyeableArmorItem implements DyeableItem {
    public ThiefDyableArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
}
