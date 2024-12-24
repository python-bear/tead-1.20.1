package net.pythonbear.tead.item.armor;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;

public class StalwartArmorItem extends ArmorItem {
    private final int protection;

    public StalwartArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
        this.protection = material.getProtection(type) + 1;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }
}
