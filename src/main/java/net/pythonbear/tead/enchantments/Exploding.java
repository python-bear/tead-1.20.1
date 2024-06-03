package net.pythonbear.tead.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.ExplosionBehavior;

import java.util.Collection;

public class Exploding extends Enchantment {
    public Exploding(Rarity weight, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(weight, target, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (!target.isAlive() && !user.getWorld().isClient() && target instanceof LivingEntity) {
            World world = user.getWorld();
            Vec3d pos = target.getPos();
            world.createExplosion(target, null, null, pos.x, pos.y, pos.z, level, false,
                    World.ExplosionSourceType.NONE, true);
            world.addParticle(ParticleTypes.EXPLOSION_EMITTER, pos.x, pos.y, pos.z, 1.0, 0.0, 0.0);
            Collection<StatusEffectInstance> collection = ((LivingEntity) target).getStatusEffects();
            if (!collection.isEmpty()) {
                AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(world, pos.x, pos.y, pos.z);
                areaEffectCloudEntity.setRadius(2.5f);
                areaEffectCloudEntity.setRadiusOnUse(-0.5f);
                areaEffectCloudEntity.setWaitTime(10);
                areaEffectCloudEntity.setDuration(areaEffectCloudEntity.getDuration() / 2);
                areaEffectCloudEntity.setRadiusGrowth(-areaEffectCloudEntity.getRadius() / (float)areaEffectCloudEntity.getDuration());
                for (StatusEffectInstance statusEffectInstance : collection) {
                    areaEffectCloudEntity.addEffect(new StatusEffectInstance(statusEffectInstance));
                }
                world.spawnEntity(areaEffectCloudEntity);
            }
        }
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMinPower(int level) {
        return 20;
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }
}
