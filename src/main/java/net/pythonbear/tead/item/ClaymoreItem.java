package net.pythonbear.tead.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

import java.util.Random;

public class ClaymoreItem extends SwordItem {
    private final float floatAttackDamage;
    public ClaymoreItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, (int)attackDamage, attackSpeed - 1, settings);
        this.floatAttackDamage = attackDamage + toolMaterial.getAttackDamage() + 1;
    }
    @Override
    public float getAttackDamage() {
        return this.floatAttackDamage;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target instanceof PlayerEntity || target instanceof MobEntity) {
            Random random = new Random();
            int attackType = random.nextInt(3);
            World world = attacker.getWorld();

            if (attackType == 1) {
                doAttackKnockback(world, target, attacker, 0.5f, 0.0f);
                attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20,
                        1, false, false, false));
            } else if (attackType == 2) {
                doAttackKnockback(world, target, attacker, 0.9f, 0.2f);
                attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 60,
                        2, false, false, false));
            } else {
                attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20,
                        1, false, false, false));
            }
        }

        return super.postHit(stack, target, attacker);
    }

    private void doAttackKnockback(World world, LivingEntity target, LivingEntity attacker,
                                   Float knockbackStrength, Float knockbackRadius) {
        world.getEntitiesByClass(LivingEntity.class, target.getBoundingBox().expand(0.5 + knockbackRadius),
                        (livingEntity) -> true)
                .forEach((entity) -> {
                    if (entity != attacker) {
                        entity.takeKnockback(knockbackStrength, -(entity.getX() - attacker.getX()),
                               -(entity.getZ() - attacker.getZ()));
                        if (entity != target) {
                            entity.animateDamage(attacker.getYaw());
                        }
                    }
                });
    }

}
