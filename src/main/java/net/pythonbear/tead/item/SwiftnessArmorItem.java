package net.pythonbear.tead.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.world.World;
import net.pythonbear.tead.init.TeadArmorMaterials;

public class SwiftnessArmorItem extends ArmorItem {
    public SwiftnessArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity player && hasBootsOn(player)) {
                evaluateArmorEffects(player);
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        if (hasCorrectArmorOn(player)) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 60,
                    1, false, false, true));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 60,
                    1, false, false, true));
        }
    }

    private boolean hasBootsOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);

        return !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(PlayerEntity player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmorStack(0).getItem());

        return boots.getMaterial() == TeadArmorMaterials.SWIFTNESS;
    }
}
