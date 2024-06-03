package net.pythonbear.tead.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import net.pythonbear.tead.init.TeadEnchantments;

import java.util.List;

public class Shockwave extends Enchantment {
    public Shockwave(Rarity weight, EnchantmentTarget target, EquipmentSlot... slotTypes) {
        super(weight, target, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (!user.getWorld().isClient() && target instanceof LivingEntity) {
            ServerWorld world = (ServerWorld) user.getWorld();

            // Calculate the range based on the enchantment level
            double range = 5.0 + level; // Example range calculation

            // Get all living entities within the range
            List<LivingEntity> entities = world.getEntitiesByClass(
                    LivingEntity.class,
                    target.getBoundingBox().expand(range),
                    e -> e != user && e != target
            );

            for (LivingEntity entity : entities) {
                double dx = target.getX() - entity.getX();
                double dy = target.getY() - entity.getY();
                double dz = target.getZ() - entity.getZ();
                double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

                // Normalize the direction and scale the pulling force by distance
                double strength = (1.0 / (distance + 0.1)) * ((double) level / 5); // Increase pull strength with level

                entity.addVelocity(-dx * strength, -dy * strength, -dz * strength);
            }
        }
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMinPower(int level) {
        return 10 + 21 * (level - 1);
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != TeadEnchantments.GRAVITY;
    }
}
