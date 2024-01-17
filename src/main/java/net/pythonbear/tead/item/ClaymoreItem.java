package net.pythonbear.tead.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import net.pythonbear.tead.Tead;

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
            Tead.LOGGER.info("rolled: " + attackType);
            World world = attacker.getWorld();

            double knockbackX = target.getX() - attacker.getX();
            double knockbackZ = target.getZ() - attacker.getZ();

            if (attackType == 1) {
                attacker.takeKnockback(0.6, knockbackX, knockbackZ);
            } else if (attackType == 2) {
                attacker.takeKnockback(1.2, knockbackX, knockbackZ);
                doAttackKnockback(world, target, attacker, 0.6f, 0.2f);
            } else {
                doAttackKnockback(world, target, attacker, 0.0f, 0.0f);
            }
        }

        return super.postHit(stack, target, attacker);
    }

    private void doAttackKnockback(World world, LivingEntity target, LivingEntity attacker,
                                   Float knockbackStrengthChange, Float knockbackRadius) {
        world.getEntitiesByClass(LivingEntity.class, target.getBoundingBox().expand(0.5 + knockbackRadius),
                        (livingEntity) -> true)
                .forEach((entity) -> {
                    if (entity != attacker) {
                        entity.takeKnockback(0.9 + knockbackStrengthChange, -(entity.getX() - attacker.getX()),
                               -(entity.getZ() - attacker.getZ()));
                        if (entity != target) {
                            entity.animateDamage(attacker.getYaw());
                        }
                    }
                });
    }

}
