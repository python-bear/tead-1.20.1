package net.pythonbear.tead.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.pythonbear.tead.init.TeadItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ZombifiedPiglinEntity.class)
public class ZombiePiglinInitEquipmentMixin {
    @Inject(method = "initEquipment(Lnet/minecraft/util/math/random/Random;Lnet/minecraft/world/LocalDifficulty;)V",
            at = @At("RETURN"))
    private void modifyInitEquipment(Random random, LocalDifficulty localDifficulty, CallbackInfo ci) {
        int i = random.nextInt(10);
        if (i == 2) {
            ((ZombifiedPiglinEntity)(Object)this).equipStack(EquipmentSlot.MAINHAND,
                    new ItemStack(TeadItems.GOLD_DAGGER));
        } else if (i == 1) {
            ((ZombifiedPiglinEntity)(Object)this).equipStack(EquipmentSlot.MAINHAND,
                    new ItemStack(TeadItems.GOLD_CLAYMORE));
        }
    }
}
