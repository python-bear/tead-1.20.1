package net.pythonbear.tead.item;

import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

import java.util.HashMap;
import java.util.Map;

public class StaffItem extends SwordItem {
    public StaffItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        Map<Enchantment, Integer> enchantments = new HashMap<>();
        enchantments.put(Enchantments.KNOCKBACK, 2);
        EnchantmentHelper.set(enchantments, new ItemStack(this));
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return 1.0f;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        if (stack.getEnchantments().size() == 1 && stack.getEnchantments().contains(Enchantments.KNOCKBACK)) {
            return false;
        }
        return stack.hasEnchantments();
    }
}
