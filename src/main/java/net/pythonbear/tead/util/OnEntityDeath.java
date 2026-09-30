package net.pythonbear.tead.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.pythonbear.tead.item.TeadItems;
import net.pythonbear.tead.item.ExcaliburItem;
import net.pythonbear.tead.network.TeadNetworking;

public class OnEntityDeath {
    /**
     * Excalibur acts like a totem of undying: when a player holding it would die, it is consumed and they survive.
     * Registered on ServerLivingEntityEvents.ALLOW_DEATH (server only).
     */
    public static boolean removeExcalibur(LivingEntity livingEntity, DamageSource damageSource, float damage) {
        if (!(livingEntity instanceof ServerPlayerEntity serverPlayer)) return true;
        if (serverPlayer.isCreative()) return true;

        PlayerInventory playerInventory = serverPlayer.getInventory();
        Item itemInMainHand = playerInventory.getMainHandStack().getItem();
        Item itemInOffHand = playerInventory.offHand.get(0).getItem();
        World world = livingEntity.getWorld();

        if (itemInMainHand instanceof ExcaliburItem || itemInOffHand instanceof ExcaliburItem) {
            if (itemInMainHand instanceof ExcaliburItem) {
                playerInventory.setStack(playerInventory.selectedSlot, ItemStack.EMPTY);
            } else {
                playerInventory.offHand.set(0, ItemStack.EMPTY);
            }

            serverPlayer.playerScreenHandler.sendContentUpdates();

            livingEntity.setHealth(2.0f);
            livingEntity.clearStatusEffects();
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 900, 1));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 1));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 800, 0));

            // Client-side effects are sent as a packet; this used to call MinecraftClient directly, which crashes a
            // dedicated server and showed the effect to the host instead of the dying player on LAN.
            TeadNetworking.sendTotemEffect(serverPlayer, new ItemStack(TeadItems.EXCALIBUR_TOTEM), 30);
            world.playSound(null, livingEntity.getBlockPos(), SoundEvents.ITEM_TOTEM_USE, SoundCategory.PLAYERS, 1.0f, 1.0f);

            return false;
        }
        return true;
    }
}
