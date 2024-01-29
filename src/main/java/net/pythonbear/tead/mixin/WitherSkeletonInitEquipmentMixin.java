package net.pythonbear.tead.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.pythonbear.tead.init.TeadItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WitherSkeletonEntity.class)
public class WitherSkeletonInitEquipmentMixin {
    @Inject(method = "initEquipment(Lnet/minecraft/util/math/random/Random;Lnet/minecraft/world/LocalDifficulty;)V",
            at = @At("RETURN"))
    private void initEquipment(Random random, LocalDifficulty localDifficulty, CallbackInfo ci) {
        int i = random.nextInt(17);
        if (i == 0) {
            ((WitherSkeletonEntity)(Object)this).equipStack(EquipmentSlot.MAINHAND,
                    new ItemStack(Items.BOW));
        } else if (i == 1 || i == 2 || i == 3 || i == 5 || i == 6 ) {
            ((WitherSkeletonEntity)(Object)this).equipStack(EquipmentSlot.MAINHAND,
                    new ItemStack(TeadItems.STONE_DOUBLE_AXE));
        }
    }
}
