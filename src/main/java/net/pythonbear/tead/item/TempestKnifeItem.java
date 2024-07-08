package net.pythonbear.tead.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class TempestKnifeItem extends BladedWeaponItem {
    public TempestKnifeItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, 4, 1.6f, 0, 0, 0,
                0, 1.5f, false,
                settings.maxDamage(toolMaterial.getDurability() + 16));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target instanceof PlayerEntity || target instanceof MobEntity) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 12, 1, true,
                    false, false));
        }

        return super.postHit(stack, target, attacker);
    }
}
