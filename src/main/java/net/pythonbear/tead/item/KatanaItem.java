package net.pythonbear.tead.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class KatanaItem extends BladedWeaponItem {
    public KatanaItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, 3, 2, 0, 0, 0,
                0, 1.5f, false, settings.maxDamage(toolMaterial.getDurability()));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addVelocity(attacker.getVelocity());
        target.velocityModified = true;

        return super.postHit(stack, target, attacker);
    }
}
