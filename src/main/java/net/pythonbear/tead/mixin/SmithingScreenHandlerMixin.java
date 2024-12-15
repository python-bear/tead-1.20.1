package net.pythonbear.tead.mixin;

import net.pythonbear.tead.Tead;
import net.pythonbear.tead.init.TeadTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ForgingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.SmithingScreenHandler;

@Mixin(SmithingScreenHandler.class)
public abstract class SmithingScreenHandlerMixin extends ForgingScreenHandler {

    public SmithingScreenHandlerMixin(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(type, syncId, playerInventory, context);
    }

    @Inject(at = @At("HEAD"), method = "decrementStack", cancellable = true)
    private void cancelDecrementStack(int slot, CallbackInfo ci) {
        ItemStack stack = input.getStack(slot);
        if(stack != null) {
            Tead.LOGGER.info("itemstack: {}", stack);
            if(stack.isIn(TeadTags.Items.SMITHING_GUIDES)) {
                Tead.LOGGER.info("cancelled");
                ci.cancel();
            }
        }
    }
}