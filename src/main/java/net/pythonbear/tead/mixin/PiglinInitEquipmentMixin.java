package net.pythonbear.tead.mixin;

import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.pythonbear.tead.init.TeadItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinEntity.class)
public class PiglinInitEquipmentMixin {
    @Inject(method = "makeInitialWeapon", at = @At("RETURN"), cancellable = true)
    private void makeInitialWeapon(CallbackInfoReturnable<ItemStack> cir) {
        if (((PiglinEntity)(Object)this).getStackInHand(Hand.MAIN_HAND).isEmpty()) {
            int i = ((PiglinEntity)(Object)this).getRandom().nextInt(6);
            if (i == 2) {
                cir.setReturnValue(new ItemStack(TeadItems.GOLD_HAMMER));
            } else if (i == 1) {
                cir.setReturnValue(new ItemStack(TeadItems.GOLD_DAGGER));
            }
        }
    }
}
