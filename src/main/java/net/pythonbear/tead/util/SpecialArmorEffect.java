package net.pythonbear.tead.util;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.pythonbear.tead.item.armor.TeadArmorMaterials;
import net.pythonbear.tead.item.armor.ThiefArmor;


public class SpecialArmorEffect {
    public static void onPlayerWorldTick(ServerWorld world, PlayerEntity player, BlockPos playerPos) {
        if (world.isNight()) {
            if (player.isSneaking()) {
                int invisibilityDuration = 0;

                ItemStack helmet = player.getInventory().armor.get(3);
                if (helmet.getItem() instanceof ThiefArmor) {
                    invisibilityDuration += 60;
                }

                ItemStack chestplate = player.getInventory().armor.get(2);
                if (chestplate.getItem() instanceof ThiefArmor) {
                    invisibilityDuration += 60;
                }

                if (invisibilityDuration > 0) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, invisibilityDuration, 0, false, true, true));
                }
            }
        }

        if (world.isThundering()) {
            for (ItemStack armorPiece : player.getInventory().armor) {
                if (armorPiece.getItem() instanceof ArmorItem armorItem) {
                    if (armorItem.getMaterial() == TeadArmorMaterials.COPPER) {
                        if (world.getRandom().nextDouble() < 0.0003 && world.isSkyVisibleAllowingSea(playerPos.up())) {
                            LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                            lightning.setPosition(playerPos.getX(), playerPos.getY(), playerPos.getZ());
                            world.spawnEntity(lightning);
                        }

                        break;
                    }
                }
            }
        }
    }
}
