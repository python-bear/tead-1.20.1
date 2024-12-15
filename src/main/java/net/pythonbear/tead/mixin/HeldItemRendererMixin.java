package net.pythonbear.tead.mixin;

import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.pythonbear.tead.init.TeadTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(HeldItemRenderer.class)
public abstract class HeldItemRendererMixin {

    @Redirect(
        method = "getHandRenderType",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
        )
    )
    private static boolean redirectIsOfForBowAndCrossbow(ItemStack instance, Item item) {
        if (item == Items.CROSSBOW) {
            return instance.isIn(TeadTags.Items.CROSSBOWS);
        }
        return instance.isOf(item);
    }

    @Redirect(
        method = "getUsingItemHandRenderType",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
        )
    )
    private static boolean redirectIsOfForUsingItem(ItemStack instance, Item item) {
        if (item == Items.CROSSBOW) {
            return instance.isIn(TeadTags.Items.CROSSBOWS);
        }
        return instance.isOf(item);
    }

    @Redirect(
        method = "isChargedCrossbow",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
        )
    )
    private static boolean redirectIsOfForChargedCrossbow(ItemStack instance, Item item) {
        if (item == Items.CROSSBOW) {
            return instance.isIn(TeadTags.Items.CROSSBOWS);
        }
        return instance.isOf(item);
    }

    @Redirect(
            method = "renderFirstPersonItem",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
            )
    )
    private boolean redirectIsOfForRenderFirstPersonItem(ItemStack instance, Item item) {
        if (item == Items.CROSSBOW) {
            return instance.isIn(TeadTags.Items.CROSSBOWS);
        }
        return instance.isOf(item);
    }
}
