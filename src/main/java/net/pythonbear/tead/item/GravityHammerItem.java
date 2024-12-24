package net.pythonbear.tead.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.pythonbear.tead.item.tool.HammerItem;
import net.pythonbear.tead.sound.TeadSounds;

import java.util.List;

public class GravityHammerItem extends HammerItem {
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

            world.playSound(null, target.getBlockPos(), TeadSounds.TELEPORT, SoundCategory.PLAYERS, 1.0f, 1.0f);

            summonPullParticles(world, target);

            double range = 9.0;

            List<LivingEntity> entities = world.getEntitiesByClass(
                    LivingEntity.class,
                    target.getBoundingBox().expand(range),
                    e -> e != attacker && e != target
            );

            world.playSound(null, attacker.getBlockPos(), SoundEvents.BLOCK_ANVIL_HIT, SoundCategory.PLAYERS);

            for (LivingEntity entity : entities) {
                double dx = target.getX() - entity.getX();
                double dy = target.getY() - entity.getY();
                double dz = target.getZ() - entity.getZ();
                double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

                double strength = (1.0 / (distance + 0.1)) * ((double) 4 / 3);

                entity.addVelocity(dx * strength, dy * strength, dz * strength);
                entity.velocityModified = true;
            }

            double dx = target.getX() - attacker.getX();
            double dy = target.getY() - attacker.getY();
            double dz = target.getZ() - attacker.getZ();
            double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

            double strength = (1.0 / (distance + 0.1)) * ((double) 4 / 3);

            attacker.addVelocity(dx * -strength, dy * -strength, dz * -strength);
            attacker.velocityModified = true;
        }

        return super.postHit(stack, target, attacker);
    }

    private void summonPullParticles(ServerWorld world, LivingEntity target) {
        Vec3d targetPos = target.getPos();

        for (int i = 0; i < 30; i++) {
            double angle = 2 * Math.PI * i / 30;
            double radius = 1.5;

            double offsetX = MathHelper.cos((float) angle) * radius;
            double offsetZ = MathHelper.sin((float) angle) * radius;

            Vec3d particlePos = new Vec3d(targetPos.x + offsetX, targetPos.y + 0.5, targetPos.z + offsetZ);

            world.spawnParticles(
                    net.minecraft.particle.ParticleTypes.PORTAL, particlePos.x, particlePos.y, particlePos.z, 1,
                    -(offsetX / 5), -0.02, -(offsetZ / 5), 0.2
            );
        }
    }
}
