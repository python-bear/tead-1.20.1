package net.pythonbear.tead.mixin;

import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.pythonbear.tead.init.TeadItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

@Mixin(ZombieEntity.class)
public class ZombieInitEquipmentMixin {
    @Inject(method = "initEquipment(Lnet/minecraft/util/math/random/Random;Lnet/minecraft/world/LocalDifficulty;)V",
            at = @At("RETURN"))
    private void modifyInitEquipment(Random random, LocalDifficulty localDifficulty, CallbackInfo ci) {
        if (((ZombieEntity)(Object)this).getStackInHand(Hand.MAIN_HAND) == ItemStack.EMPTY) {
            if (random.nextFloat() < (((ZombieEntity)(Object)this).getWorld().getDifficulty() == Difficulty.HARD ?
                    0.05F : 0.01F)) {
                int i = random.nextInt(4);
                if (i == 2) {
                    ((ZombieEntity)(Object)this).equipStack(EquipmentSlot.MAINHAND,
                            new ItemStack(TeadItems.IRON_DAGGER));
                } else if (i == 1) {
                    ((ZombieEntity)(Object)this).equipStack(EquipmentSlot.MAINHAND,
                            new ItemStack(TeadItems.LEAD_DAGGER));
                } else if (i == 0) {
                    ((ZombieEntity)(Object)this).equipStack(EquipmentSlot.MAINHAND,
                            new ItemStack(TeadItems.LEAD_SWORD));
                }
            }
        }
    }
}
