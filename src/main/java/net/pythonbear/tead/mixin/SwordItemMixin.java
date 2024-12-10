package net.pythonbear.tead.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.tag.BlockTags;
import net.pythonbear.tead.init.TeadBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SwordItem.class)
public class SwordItemMixin {

    @Inject(method = "getMiningSpeedMultiplier", at = @At("HEAD"), cancellable = true)
    private void modifyMiningSpeedMultiplier(ItemStack stack, BlockState state, CallbackInfoReturnable<Float> cir) {
        if (state.isOf(Blocks.COBWEB) || state.isOf(TeadBlocks.WEAK_COBWEB)) {
            cir.setReturnValue(15.0f);
        } else if (state.isIn(BlockTags.SWORD_EFFICIENT)) {
            cir.setReturnValue(1.5f);
        } else {
            cir.setReturnValue(1.0f);
        }
    }
}
