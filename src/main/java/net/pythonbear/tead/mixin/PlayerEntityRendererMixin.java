package net.pythonbear.tead.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.UseAction;
import net.pythonbear.tead.init.TeadTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerEntityRendererMixin {

    /**
     * @author Python-Bear
     * @reason Replace specific CROSSBOW item check with TeadTags.Items.CROSSBOWS tag check.
     */
    @Overwrite
    private static BipedEntityModel.ArmPose getArmPose(AbstractClientPlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isEmpty()) {
            return BipedEntityModel.ArmPose.EMPTY;
        }
        if (player.getActiveHand() == hand && player.getItemUseTimeLeft() > 0) {
            UseAction useAction = itemStack.getUseAction();
            if (useAction == UseAction.BLOCK) {
                return BipedEntityModel.ArmPose.BLOCK;
            }
            if (useAction == UseAction.BOW) {
                return BipedEntityModel.ArmPose.BOW_AND_ARROW;
            }
            if (useAction == UseAction.SPEAR) {
                return BipedEntityModel.ArmPose.THROW_SPEAR;
            }
            if (useAction == UseAction.CROSSBOW && hand == player.getActiveHand()) {
                return BipedEntityModel.ArmPose.CROSSBOW_CHARGE;
            }
            if (useAction == UseAction.SPYGLASS) {
                return BipedEntityModel.ArmPose.SPYGLASS;
            }
            if (useAction == UseAction.TOOT_HORN) {
                return BipedEntityModel.ArmPose.TOOT_HORN;
            }
            if (useAction == UseAction.BRUSH) {
                return BipedEntityModel.ArmPose.BRUSH;
            }
        } else if (!player.handSwinging && itemStack.isIn(TeadTags.Items.CROSSBOWS) && CrossbowItem.isCharged(itemStack)) {
            return BipedEntityModel.ArmPose.CROSSBOW_HOLD;
        }
        return BipedEntityModel.ArmPose.ITEM;
    }
}
