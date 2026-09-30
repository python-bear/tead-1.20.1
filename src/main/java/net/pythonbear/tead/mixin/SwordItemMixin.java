package net.pythonbear.tead.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.tag.BlockTags;
import net.pythonbear.tead.block.TeadBlocks;
import net.pythonbear.tead.item.TeadToolMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SwordItem.class)
public class SwordItemMixin {

    @Inject(method = "postHit", at = @At("HEAD"), cancellable = true)
    private void addNauseaEffect(ItemStack stack, LivingEntity target, LivingEntity attacker, CallbackInfoReturnable<Boolean> cir) {
        if (!attacker.getWorld().isClient) {
            // Use this item (the one that hit), not whatever is in the main hand: a dual-wielded off-hand hit
            // would otherwise read the main-hand item, which may not be a sword at all.
            if (((SwordItem) (Object) this).getMaterial() == TeadToolMaterials.LEAD) {
                if (attacker.getWorld().getRandom().nextInt(5) == 0) {
                    target.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 1));
                }
            }
        }
    }

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
