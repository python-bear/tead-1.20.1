package net.pythonbear.tead.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class RapierItem extends BladedWeaponItem {
    public RapierItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, 2, 3, 0,
                0, 0, 0, 1.5f, false,
                settings.maxDamage(toolMaterial.getDurability() - 10));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.addVelocity(attacker.getVelocity());
        attacker.velocityModified = true;

        return super.postHit(stack, target, attacker);
    }
}
