package net.pythonbear.tead.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.DrownedEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.pythonbear.tead.init.TeadItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DrownedEntity.class)
public class DrownedInitEquipmentMixin {
    @Inject(method = "initEquipment(Lnet/minecraft/util/math/random/Random;Lnet/minecraft/world/LocalDifficulty;)V",
            at = @At("RETURN"))
    private void modifyInitEquipment(Random random, LocalDifficulty localDifficulty, CallbackInfo ci) {
        if (((DrownedEntity)(Object)this).getStackInHand(Hand.MAIN_HAND) == ItemStack.EMPTY) {
            if (random.nextFloat() < (((DrownedEntity)(Object)this).getWorld().getDifficulty() == Difficulty.HARD ?
                    0.05F : 0.01F)) {
                int i = random.nextInt(2);
                if (i == 0) {
                    ((DrownedEntity)(Object)this).equipStack(EquipmentSlot.MAINHAND,
                            new ItemStack(TeadItems.CORAL_DAGGER));
                }
            }
        }
    }
}
