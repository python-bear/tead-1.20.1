package net.pythonbear.tead.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class SpearItem extends BladedWeaponItem{
    public SpearItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, 3, 1.9f, 0, 0, 0,
                0, 1, false, settings.maxDamage(toolMaterial.getDurability()));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.addVelocity(attacker.getVelocity());
        attacker.velocityModified = true;

        return super.postHit(stack, target, attacker);
    }
}
