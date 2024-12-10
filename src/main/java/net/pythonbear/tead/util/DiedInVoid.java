package net.pythonbear.tead.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import net.pythonbear.tead.init.TeadItems;

public class DiedInVoid {
    public static void craftExcalibur(LivingEntity livingEntity, DamageSource damageSource) {
        if (damageSource.isOf(DamageTypes.OUT_OF_WORLD) && livingEntity.getWorld().getRegistryKey() == World.END) {
            if (livingEntity instanceof ServerPlayerEntity serverPlayer) {
                Inventory inventory = serverPlayer.getInventory();

                boolean hasTotem = false;
                boolean hasSword = false;
                boolean hasExcaliburTotem = false;

                for (int i = 0; i < inventory.size(); i++) {
                    Item item = inventory.getStack(i).getItem();
                    if (item == TeadItems.EXCALIBUR_TOTEM) hasExcaliburTotem = true;
                    if (item == TeadItems.STEEL_SWORD) hasSword = true;
                    if (item == Items.TOTEM_OF_UNDYING) hasTotem = true;
                }

                if (hasTotem && hasSword && hasExcaliburTotem) {
                    for (int i = 0; i < inventory.size(); i++) {
                        Item item = inventory.getStack(i).getItem();
                        if (item == TeadItems.EXCALIBUR_TOTEM || item == TeadItems.STEEL_SWORD || item == Items.TOTEM_OF_UNDYING) {
                            inventory.removeStack(i);
                        }
                    }

                    ItemStack excalibur = new ItemStack(TeadItems.EXCALIBUR);
                    serverPlayer.getInventory().insertStack(excalibur);
                }
            }
        }
    }
}
