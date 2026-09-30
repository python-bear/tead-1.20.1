package net.pythonbear.tead.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.pythonbear.tead.item.ruby.TransmutableTool;

public class Transmorphing extends Enchantment {
    public Transmorphing(Rarity weight, EnchantmentTarget target, EquipmentSlot... slotTypes) {
        super(weight, target, slotTypes);
    }

    public int getMaxLevel() {
        return 3;
    }

    /**
     * Only ever applied by the Transmutation Table, so keep it out of enchanting tables, loot and villager trades.
     */
    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return false;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof TransmutableTool;
    }

}
