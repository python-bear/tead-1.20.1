package net.pythonbear.tead.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.VindicatorEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.pythonbear.tead.init.TeadItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VindicatorEntity.class)
public class VindicatorInitEquipmentMixin {
    @Inject(method = "initEquipment", at = @At("RETURN"))
    private void makeInitialWeapon(Random random, LocalDifficulty localDifficulty, CallbackInfo ci) {
        int i = ((VindicatorEntity)(Object)this).getRandom().nextInt(7);
        if (i == 0) {
            ((VindicatorEntity)(Object)this).equipStack(EquipmentSlot.MAINHAND,
                    new ItemStack(TeadItems.IRON_DOUBLE_AXE));
        }
    }
}
