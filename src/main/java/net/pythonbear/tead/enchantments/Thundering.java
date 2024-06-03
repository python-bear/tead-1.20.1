package net.pythonbear.tead.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class Thundering extends Enchantment {
    public Thundering(Rarity weight, EnchantmentTarget target, EquipmentSlot... slotTypes) {
        super(weight, target, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }
}
