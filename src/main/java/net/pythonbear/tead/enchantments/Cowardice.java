package net.pythonbear.tead.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class Cowardice extends Enchantment {
    public Cowardice(Rarity weight, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(weight, target, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (!user.getWorld().isClient() && target instanceof LivingEntity) {
            StatusEffectInstance statusEffectInstance = new StatusEffectInstance(StatusEffects.SPEED,
                    15, level, false, false, true);
            user.addStatusEffect(statusEffectInstance);
        }
    }

    @Override
    public int getMinPower(int level) {
        return 10 * level;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 30;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
