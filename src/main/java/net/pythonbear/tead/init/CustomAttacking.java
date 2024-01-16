package net.pythonbear.tead.init;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonPart;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.pythonbear.tead.Tead;

import java.util.List;

public class CustomAttacking {
    public static void attack(PlayerEntity user, Entity target, Hand hand, Float attackDamage) {
        Tead.LOGGER.info("hand: " + hand);
        Tead.LOGGER.info("hand stack: " + user.getStackInHand(hand));
        Tead.LOGGER.info("damage source: " + user.getDamageSources().playerAttack(user));
        if (!target.isAttackable()) {
            return;
        }
        if (target.handleAttack(user)) {
            return;
        }
        float f = attackDamage;
        float g = target instanceof LivingEntity ? EnchantmentHelper.getAttackDamage(user.getStackInHand(hand),
                ((LivingEntity)target).getGroup()) : EnchantmentHelper.getAttackDamage(user.getStackInHand(hand),
                EntityGroup.DEFAULT);
        float h = user.getAttackCooldownProgress(0.5f);
        g *= h;
        user.resetLastAttackedTicks();
        if ((f *= 0.2f + h * h * 0.8f) > 0.0f || g > 0.0f) {
            ItemStack itemStack;
            boolean bl = h > 0.9f;
            boolean bl2 = false;
            int i = 0;
            i += EnchantmentHelper.getKnockback(user);
            if (user.isSprinting() && bl) {
                user.getWorld().playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.ENTITY_PLAYER_ATTACK_KNOCKBACK, user.getSoundCategory(), 1.0f, 1.0f);
                ++i;
                bl2 = true;
            }
            boolean bl3 = bl && user.fallDistance > 0.0f && !user.isOnGround() && !user.isClimbing() &&
                    !user.isTouchingWater() && !user.hasStatusEffect(StatusEffects.BLINDNESS) && !user.hasVehicle() &&
                    target instanceof LivingEntity;
            boolean bl4 = bl3 = bl3 && !user.isSprinting();
            if (bl3) {
                f *= 1.5f;
            }
            f += g;
            boolean bl42 = false;
            double d = user.horizontalSpeed - user.prevHorizontalSpeed;
            if (bl && !bl3 && !bl2 && user.isOnGround() && d < (double)user.getMovementSpeed() &&
                    (itemStack = user.getStackInHand(hand)).getItem() instanceof SwordItem) {
                bl42 = true;
            }
            float j = 0.0f;
            boolean bl5 = false;
            int k = EnchantmentHelper.getFireAspect(user);
            if (target instanceof LivingEntity) {
                j = ((LivingEntity)target).getHealth();
                if (k > 0 && !target.isOnFire()) {
                    bl5 = true;
                    target.setOnFireFor(1);
                }
            }
            Vec3d vec3d = target.getVelocity();
            boolean bl6 = target.damage(user.getDamageSources().playerAttack(user), f);
            if (bl6) {
                if (i > 0) {
                    if (target instanceof LivingEntity) {
                        ((LivingEntity)target).takeKnockback((float)i * 0.5f, MathHelper.sin(user.getYaw()
                                * ((float)Math.PI / 180)), -MathHelper.cos(user.getYaw() *
                                ((float)Math.PI / 180)));
                    } else {
                        target.addVelocity(-MathHelper.sin(user.getYaw() * ((float)Math.PI / 180)) *
                                (float)i * 0.5f, 0.1, MathHelper.cos(user.getYaw() *
                                ((float)Math.PI / 180)) * (float)i * 0.5f);
                    }
                    user.setVelocity(user.getVelocity().multiply(0.6, 1.0, 0.6));
                    user.setSprinting(false);
                }
                if (bl42) {
                    float l = 1.0f + EnchantmentHelper.getSweepingMultiplier(user) * f;
                    List<LivingEntity> list = user.getWorld().getNonSpectatingEntities(LivingEntity.class,
                            target.getBoundingBox().expand(1.0, 0.25, 1.0));
                    for (LivingEntity livingEntity : list) {
                        if (livingEntity == user || livingEntity == target || user.isTeammate(livingEntity) ||
                                livingEntity instanceof ArmorStandEntity && ((ArmorStandEntity)livingEntity).isMarker()
                                || !(user.squaredDistanceTo(livingEntity) < 9.0)) continue;
                        livingEntity.takeKnockback(0.4f, MathHelper.sin(user.getYaw() * ((float)Math.PI /
                                180)), -MathHelper.cos(user.getYaw() * ((float)Math.PI / 180)));
                        livingEntity.damage(user.getDamageSources().playerAttack(user), l);
                    }
                    user.getWorld().playSound(null, user.getX(), user.getY(), user.getZ(),
                            SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, user.getSoundCategory(), 1.0f, 1.0f);
                    user.spawnSweepAttackParticles();
                }
                if (target instanceof ServerPlayerEntity && target.velocityModified) {
                    ((ServerPlayerEntity)target).networkHandler.sendPacket(new EntityVelocityUpdateS2CPacket(target));
                    target.velocityModified = false;
                    target.setVelocity(vec3d);
                }
                if (bl3) {
                    user.getWorld().playSound(null, user.getX(), user.getY(), user.getZ(),
                            SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, user.getSoundCategory(), 1.0f, 1.0f);
                    user.addCritParticles(target);
                }
                if (!bl3 && !bl42) {
                    if (bl) {
                        user.getWorld().playSound(null, user.getX(), user.getY(), user.getZ(),
                                SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, user.getSoundCategory(), 1.0f,
                                1.0f);
                    } else {
                        user.getWorld().playSound(null, user.getX(), user.getY(), user.getZ(),
                                SoundEvents.ENTITY_PLAYER_ATTACK_WEAK, user.getSoundCategory(), 1.0f, 1.0f);
                    }
                }
                if (g > 0.0f) {
                    user.addEnchantedHitParticles(target);
                }
                user.onAttacking(target);
                if (target instanceof LivingEntity) {
                    EnchantmentHelper.onUserDamaged((LivingEntity)target, user);
                }
                EnchantmentHelper.onTargetDamaged(user, target);
                ItemStack itemStack2 = user.getStackInHand(hand);
                Entity entity = target;
                if (target instanceof EnderDragonPart) {
                    entity = ((EnderDragonPart)target).owner;
                }
                if (!user.getWorld().isClient && !itemStack2.isEmpty() && entity instanceof LivingEntity) {
                    itemStack2.postHit((LivingEntity)entity, user);
                    if (itemStack2.isEmpty()) {
                        user.setStackInHand(hand, ItemStack.EMPTY);
                    }
                }
                if (target instanceof LivingEntity) {
                    float m = j - ((LivingEntity)target).getHealth();
                    user.increaseStat(Stats.DAMAGE_DEALT, Math.round(m * 10.0f));
                    if (k > 0) {
                        target.setOnFireFor(k * 4);
                    }
                    if (user.getWorld() instanceof ServerWorld && m > 2.0f) {
                        int n = (int)((double)m * 0.5);
                        ((ServerWorld)user.getWorld()).spawnParticles(ParticleTypes.DAMAGE_INDICATOR, target.getX(),
                                target.getBodyY(0.5), target.getZ(), n, 0.1, 0.0, 0.1,
                                0.2);
                    }
                }
                user.addExhaustion(0.1f);
            } else {
                user.getWorld().playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.ENTITY_PLAYER_ATTACK_NODAMAGE, user.getSoundCategory(), 1.0f, 1.0f);
                if (bl5) {
                    target.extinguish();
                }
            }
        }
    }
}
