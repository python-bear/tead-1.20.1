package net.pythonbear.tead.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class LongswordItem extends BladedWeaponItem {
    public LongswordItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, 8, 0.7f, 0.4f,
                1, 1, 25, 2.5f, false,
                settings.maxDamage(toolMaterial.getDurability() + 32));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addVelocity(attacker.getVelocity());
        target.velocityModified = true;

        return super.postHit(stack, target, attacker);
    }
}
