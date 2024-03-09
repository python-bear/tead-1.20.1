package net.pythonbear.tead.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class KatanaItem extends BladedWeaponItem {
    public KatanaItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, toolMaterial.getAttackDamage() + 3, 2, 0,
                0, 0, 0, 1.5f, false,
                settings.maxDamage(toolMaterial.getDurability()));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setVelocity(target.getVelocity().multiply(0.6, 0.9, 0.6));

        return super.postHit(stack, target, attacker);
    }
}
