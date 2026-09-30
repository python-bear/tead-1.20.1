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
            // Use this item (the one that hit), not whatever is in the main hand.
            if (((MiningToolItem) (Object) this).getMaterial() == TeadToolMaterials.LEAD) {
                if (attacker.getWorld().getRandom().nextInt(5) == 0) {
                    target.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 1));
                }
            }
        }
    }
}
