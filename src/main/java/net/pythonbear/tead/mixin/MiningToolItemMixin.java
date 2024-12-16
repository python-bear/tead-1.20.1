package net.pythonbear.tead.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.pythonbear.tead.item.TeadToolMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MiningToolItem.class)
public class MiningToolItemMixin {

    @Inject(method = "postHit", at = @At("HEAD"), cancellable = true)
    private void addNauseaEffect(ItemStack stack, LivingEntity target, LivingEntity attacker, CallbackInfoReturnable<Boolean> cir) {
        if (!attacker.getWorld().isClient) {
            ItemStack weapon = attacker.getMainHandStack();
            if (((MiningToolItem) weapon.getItem()).getMaterial() == TeadToolMaterials.LEAD) {
                if (attacker.getWorld().getRandom().nextInt(5) == 0) {
                    target.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 1));
                }
            }
        }
    }
}
