package net.pythonbear.tead.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public class PainCycle extends Enchantment {
    private static final String DAMAGE_TAKEN_KEY = "DamageTaken";

    public PainCycle(Rarity weight, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(weight, target, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (!user.getWorld().isClient() && target instanceof LivingEntity) {
            // 1 in 2 chance of losing half a heart
            if (user.getRandom().nextFloat() < 0.5) {
                user.damage(user.getDamageSources().magic(), 1.0F);
            }

            // 1 in 2 chance to deal extra damage
            if (user.getRandom().nextFloat() < 0.5) {
                float extraDamage = (float) level / 2;
                target.damage(user.getDamageSources().magic(), extraDamage);
            }
        }
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMinPower(int level) {
        return 20;
    }

    @Override
    public int getMaxPower(int level) {
        return 45;
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof SwordItem || stack.getItem() instanceof AxeItem;
    }
}
