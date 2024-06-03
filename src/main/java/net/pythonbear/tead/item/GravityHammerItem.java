package net.pythonbear.tead.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.pythonbear.tead.init.TeadItems;
import net.pythonbear.tead.init.TeadToolMaterials;

import java.util.List;

public class GravityHammerItem extends HammerItem  {
    public GravityHammerItem(Settings settings) {
        super(TeadToolMaterials.ROSE_NETHERITE, settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient == TeadItems.ROSE_NETHERITE_INGOT.getDefaultStack();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.getWorld().isClient()) {
            ServerWorld world = (ServerWorld) attacker.getWorld();

            // Calculate the range based on the enchantment level
            double range = 9.0; // Example range calculation

            // Get all living entities within the range
            List<LivingEntity> entities = world.getEntitiesByClass(
                    LivingEntity.class,
                    target.getBoundingBox().expand(range),
                    e -> e != attacker && e != target
            );

            attacker.getWorld().playSound(null, attacker.getBlockPos(), SoundEvents.BLOCK_ANVIL_HIT,
                    SoundCategory.PLAYERS);

            for (LivingEntity entity : entities) {
                double dx = target.getX() - entity.getX();
                double dy = target.getY() - entity.getY();
                double dz = target.getZ() - entity.getZ();
                double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

                // Normalize the direction and scale the pulling force by distance
                double strength = (1.0 / (distance + 0.1)) * ((double) 4 / 3); // Increase pull strength with level

                entity.addVelocity(dx * strength, dy * strength, dz * strength);
            }
        }

        return super.postHit(stack, target, attacker);
    }
}
