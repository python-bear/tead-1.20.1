package net.pythonbear.tead.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class Rush extends Enchantment {
    public Rush(Rarity weight, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(weight, target, slotTypes);
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if (!user.getWorld().isClient) {
            StatusEffectInstance statusEffectInstance = new StatusEffectInstance(StatusEffects.SPEED,
                    15, level, false, false, true);
            user.addStatusEffect(statusEffectInstance);
        }

        super.onUserDamaged(user, attacker, level);
    }

    @Override
    public int getMinPower(int level) {
        return level * 11;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 16;
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }
}
