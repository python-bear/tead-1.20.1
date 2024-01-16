package net.pythonbear.tead.item;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class StaffItem extends SwordItem {
    public StaffItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target instanceof PlayerEntity || target instanceof MobEntity) {
            // Calculate knockback direction
            double deltaX = attacker.getX() - target.getX();
            double deltaZ = attacker.getZ() - target.getZ();
            double distance = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);

            // Normalize the direction
            if (distance > 0) {
                double knockbackX = deltaX / distance;
                double knockbackZ = deltaZ / distance;

                // Apply knockback with adjusted values
                target.takeKnockback(1, knockbackX, knockbackZ);
            }
        }

        return super.postHit(stack, target, attacker);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return 1.0f;
    }
}
