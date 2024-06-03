package net.pythonbear.tead.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class SinisterSwordItem extends SwordItem {
    public SinisterSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed,
                settings.maxDamage(Math.round(toolMaterial.getAttackDamage() / 2)));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.getWorld().isClient() & target instanceof LivingEntity) {
            attacker.heal((float) ((LivingEntity) attacker).defaultMaxHealth / 16);

            if (attacker.getRandom().nextFloat() < 0.1) {
                attacker.setOnFire(true);
            } else if (attacker.getRandom().nextFloat() < 0.1) {
                target.setFireTicks(30);
            }
        }
        super.postHit(stack, target, attacker);
        return true;
    }
}
