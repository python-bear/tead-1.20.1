package net.pythonbear.tead.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterials;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.pythonbear.tead.init.TeadToolMaterials;
import net.pythonbear.tead.sound.TeadSounds;

public class FrostClaymoreItem extends ClaymoreItem {
    public FrostClaymoreItem(Settings settings) {
        super(ToolMaterials.DIAMOND, settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient == Items.ICE.getDefaultStack() ||
                ingredient == Items.BLUE_ICE.getDefaultStack() ||
                ingredient == Items.PACKED_ICE.getDefaultStack() ||
                ingredient == Items.DIAMOND.getDefaultStack();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.getWorld().isClient) {
            ServerWorld world = (ServerWorld) attacker.getWorld();

            StatusEffectInstance weaknessStatusEffectInstance = new StatusEffectInstance(StatusEffects.WEAKNESS,
                    40, 1, false, false, true);
            StatusEffectInstance slownessStatusEffectInstance = new StatusEffectInstance(StatusEffects.SLOWNESS,
                    15, 1, false, false, true);
            target.addStatusEffect(weaknessStatusEffectInstance);
            target.addStatusEffect(slownessStatusEffectInstance);
            target.setOnFire(false);
            world.playSound(null, target.getBlockPos(), TeadSounds.ICE_SMASH,
                    SoundCategory.PLAYERS, 1.0f, 0.8f + (world.getRandom().nextFloat() / 5));
            summonFrostyParticles(world, target);

            boolean isCritical = attacker.fallDistance > 0.0f && !attacker.isOnGround() && !attacker.isClimbing() &&
                    !attacker.isTouchingWater() && !attacker.hasStatusEffect(StatusEffects.BLINDNESS) && !attacker.hasVehicle() &&
                    target instanceof LivingEntity;

            if (world.getRandom().nextFloat() < 0.6 && isCritical) {
                summonFrostyParticles(world, target);
                int nearbyMobsCount = world.getEntitiesByClass(LivingEntity.class,
                        attacker.getBoundingBox().expand(3.0),
                        entity -> entity != attacker && entity != target
                ).size();

                int snowballs = 6 + (2 * nearbyMobsCount);

                for (int i = 0; i < snowballs; i++) {
                    double angle = 2 * Math.PI * i / snowballs;
                    double radius = 1.5;

                    double offsetX = MathHelper.cos((float) angle) * radius;
                    double offsetZ = MathHelper.sin((float) angle) * radius;

                    SnowballEntity snowball = new SnowballEntity(world, attacker);
                    snowball.setPosition(attacker.getX() + offsetX, attacker.getY() + 0.5, attacker.getZ() + offsetZ);
                    snowball.setVelocity(snowball.getX() - attacker.getX(),
                            snowball.getY() - attacker.getY(),
                            snowball.getZ() - attacker.getZ(),
                            1.0f, 1.0f);
                    world.spawnEntity(snowball);
                }
                world.playSound(null, target.getBlockPos(), SoundEvents.BLOCK_SNOW_BREAK, SoundCategory.PLAYERS, 1.0f, 1.0f);

                summonFrostyParticles(world, target);
            }
        }

        return super.postHit(stack, target, attacker);
    }

    private void summonFrostyParticles(ServerWorld world, LivingEntity target) {
        Vec3d targetPos = target.getPos();

        for (int i = 0; i < 15; i++) {
            double angle = 2 * Math.PI * i / 30;
            double radius = 1.5;

            double offsetX = MathHelper.cos((float) angle) * radius;
            double offsetZ = MathHelper.sin((float) angle) * radius;

            Vec3d particlePos = new Vec3d(targetPos.x, targetPos.y + 0.5, targetPos.z);

            world.spawnParticles(
                    ParticleTypes.SNOWFLAKE, particlePos.x, particlePos.y, particlePos.z, 1,
                    -(offsetX / 6), -0.02, -(offsetZ / 6), 0.1
            );
        }

        for (int i = 0; i < 7; i++) {
            double angle = 2 * Math.PI * i / 30;
            double radius = 1.5;

            double offsetX = MathHelper.cos((float) angle) * radius;
            double offsetZ = MathHelper.sin((float) angle) * radius;

            Vec3d particlePos = new Vec3d(targetPos.x, targetPos.y + 0.5, targetPos.z);

            world.spawnParticles(
                    ParticleTypes.SPLASH, particlePos.x, particlePos.y, particlePos.z, 1,
                    -(offsetX / 7), -0.02, -(offsetZ / 7), 0.1
            );
        }
    }
}
