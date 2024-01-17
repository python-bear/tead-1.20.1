package net.pythonbear.tead.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class StaffItem extends SwordItem {
    private final float knockbackStrength;
    private final float knockbackRadius;
    private final float attackDamage;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    public StaffItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, float knockbackStrength,
                     float knockbackRadius, Settings settings) {
        super(toolMaterial, (int)attackDamage, attackSpeed, settings);
        this.knockbackStrength = knockbackStrength;
        this.knockbackRadius = knockbackRadius;
        this.attackDamage = attackDamage + toolMaterial.getAttackDamage();
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
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target != attacker) {
            World world = attacker.getWorld();

            world.getEntitiesByClass(LivingEntity.class, target.getBoundingBox().expand(this.knockbackRadius),
                            (livingEntity) -> true)
                    .forEach((entity) -> {
                        if (entity != attacker) {
                            entity.takeKnockback(this.knockbackStrength, -(entity.getX() - attacker.getX()),
                                    -(entity.getZ() - attacker.getZ()));
                            if (entity != target) {
                                entity.animateDamage(attacker.getYaw());
                            }
                        }
                    });
        }

        return super.postHit(stack, target, attacker);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return 1.0f;
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {
            return this.attributeModifiers;
        }
        return super.getAttributeModifiers(slot);
    }
}
