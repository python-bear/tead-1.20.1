package net.pythonbear.tead.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import net.pythonbear.tead.item.TeadItems;

/**
 * "Lady Of The Void": dying in the End's void while carrying a steel sword, a totem of undying and an Excalibur
 * Totem consumes them, and the player respawns holding Excalibur.
 * <p>
 * This used to run on AFTER_DEATH, but by then the inventory has already been dropped into the void, so it only
 * ever worked with keepInventory on (and the Excalibur it gave was lost with the rest of the inventory). Now the
 * ingredients are taken on ALLOW_DEATH, before anything drops, and Excalibur is handed over on respawn. The pending
 * reward is a command tag, so it survives the player logging out on the death screen.
 */
public class DiedInVoid {
    private static final String PENDING_TAG = "tead.pending_excalibur";

    /** ServerLivingEntityEvents.ALLOW_DEATH. Never cancels the death. */
    public static boolean craftExcalibur(LivingEntity livingEntity, DamageSource damageSource, float damageAmount) {
        if (!(livingEntity instanceof ServerPlayerEntity serverPlayer)) return true;
        if (!damageSource.isOf(DamageTypes.OUT_OF_WORLD) || livingEntity.getWorld().getRegistryKey() != World.END) {
            return true;
        }

        PlayerInventory inventory = serverPlayer.getInventory();
        int totemSlot = findSlot(inventory, TeadItems.EXCALIBUR_TOTEM);
        int swordSlot = findSlot(inventory, TeadItems.STEEL_LONGSWORD);
        int totemOfUndyingSlot = findSlot(inventory, Items.TOTEM_OF_UNDYING);

        if (totemSlot >= 0 && swordSlot >= 0 && totemOfUndyingSlot >= 0) {
            // Take exactly one of each (previously every matching stack in the inventory was deleted).
            inventory.removeStack(totemSlot, 1);
            inventory.removeStack(swordSlot, 1);
            inventory.removeStack(totemOfUndyingSlot, 1);
            serverPlayer.addCommandTag(PENDING_TAG);
        }
        return true;
    }

    /** ServerPlayerEvents.COPY_FROM: give the Excalibur to the respawned player. */
    public static void giveOnRespawn(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) {
        if (!oldPlayer.getCommandTags().contains(PENDING_TAG)) return;

        oldPlayer.removeScoreboardTag(PENDING_TAG);
        newPlayer.removeScoreboardTag(PENDING_TAG);
        ItemStack excalibur = new ItemStack(TeadItems.EXCALIBUR);
        if (!newPlayer.getInventory().insertStack(excalibur)) {
            newPlayer.dropItem(excalibur, false);
        }
    }

    private static int findSlot(PlayerInventory inventory, Item item) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.getStack(i).isOf(item)) return i;
        }
        return -1;
    }
}
