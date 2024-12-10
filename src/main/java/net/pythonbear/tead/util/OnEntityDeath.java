package net.pythonbear.tead.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.pythonbear.tead.init.TeadItems;
import net.pythonbear.tead.item.ExcaliburItem;
import net.pythonbear.tead.item.ExcaliburTotemItem;

public class OnEntityDeath {
    public static boolean removeExcalibur(LivingEntity livingEntity, DamageSource damageSource, float damage) {
        if (!(livingEntity instanceof ServerPlayerEntity serverPlayer)) return true;
        if (serverPlayer.isCreative()) return true;

        PlayerInventory playerInventory = serverPlayer.getInventory();
        Item itemInMainHand = playerInventory.getMainHandStack().getItem();
        Item itemInOffHand = playerInventory.offHand.get(0).getItem();
        World world = livingEntity.getWorld();

        if (itemInMainHand instanceof ExcaliburItem || itemInOffHand instanceof ExcaliburItem) {
            if (!world.isClient) {
                if (itemInMainHand instanceof ExcaliburTotemItem) {
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

                MinecraftClient client = MinecraftClient.getInstance();
                client.particleManager.addEmitter(livingEntity, ParticleTypes.TOTEM_OF_UNDYING, 30);

                if (client.player != null && client.player.isMainPlayer()) {
                    client.gameRenderer.showFloatingItem(TeadItems.EXCALIBUR_TOTEM.getDefaultStack());
                }
//                    world.sendEntityStatus(livingEntity, EntityStatuses.USE_TOTEM_OF_UNDYING);

                world.playSound(null, livingEntity.getBlockPos(), SoundEvents.ITEM_TOTEM_USE, SoundCategory.PLAYERS, 1.0f, 1.0f);
            }

            return false;
        }
        return true;
    }
}
