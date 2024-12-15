package net.pythonbear.tead.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.pythonbear.tead.enchantments.FireTrail;
import net.pythonbear.tead.enchantments.TeadEnchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class FireTrailMixin {
    @Inject(method = "applyMovementEffects(Lnet/minecraft/util/math/BlockPos;)V",
            at = @At("HEAD"))
    protected void applyMovementEffects(BlockPos pos, CallbackInfo ci) {
        int i = EnchantmentHelper.getEquipmentLevel(TeadEnchantments.FIRE_TRAIL, (((LivingEntity)(Object)this)));
        if (i > 0 && (((LivingEntity)(Object)this)).isSprinting()) {
            FireTrail.setFire((((LivingEntity)(Object)this)), (((LivingEntity)(Object)this)).getWorld(), pos, i);
        }
    }
}
