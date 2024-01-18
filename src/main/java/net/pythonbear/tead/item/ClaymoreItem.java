package net.pythonbear.tead.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Vanishable;
import net.minecraft.world.World;

import java.util.Random;

public class ClaymoreItem extends SwordItem implements Vanishable {
    private final float attackDamage;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    public ClaymoreItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, (int)attackDamage, attackSpeed - 1, settings);
        this.attackDamage = attackDamage + toolMaterial.getAttackDamage() + 3.2f;
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID,
                "Weapon modifier", this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID,
                "Weapon modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }
    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {
            return this.attributeModifiers;
        }
        return super.getAttributeModifiers(slot);
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
