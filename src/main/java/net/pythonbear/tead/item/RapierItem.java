package net.pythonbear.tead.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class RapierItem extends BladedWeaponItem {
    public RapierItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, toolMaterial.getAttackDamage() + 2, 3, 0,
                0, 0, 0, 1.5f, false,
                settings.maxDamage(toolMaterial.getDurability() - 10));
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setVelocity(target.getVelocity().multiply(0.8, 1, 0.8));

        return super.postHit(stack, target, attacker);
    }
}
