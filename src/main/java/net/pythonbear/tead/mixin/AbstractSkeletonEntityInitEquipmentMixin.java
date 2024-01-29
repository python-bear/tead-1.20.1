package net.pythonbear.tead.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.pythonbear.tead.init.TeadItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractSkeletonEntity.class)
public class AbstractSkeletonEntityInitEquipmentMixin {
    @Inject(method = "initEquipment(Lnet/minecraft/util/math/random/Random;Lnet/minecraft/world/LocalDifficulty;)V",
            at = @At("RETURN"))
    private void modifyInitEquipment(Random random, LocalDifficulty localDifficulty, CallbackInfo ci) {
        int i = random.nextInt(4);
        if (i == 0) {
            ((AbstractSkeletonEntity)(Object)this).equipStack(EquipmentSlot.MAINHAND,
                    new ItemStack(TeadItems.BONE_CLUB));
        }
    }
}
