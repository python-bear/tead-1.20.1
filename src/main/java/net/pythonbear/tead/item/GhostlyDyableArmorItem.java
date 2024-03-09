package net.pythonbear.tead.item;

import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.DyeableItem;

public class GhostlyDyableArmorItem extends DyeableArmorItem implements DyeableItem {
    public GhostlyDyableArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
}
