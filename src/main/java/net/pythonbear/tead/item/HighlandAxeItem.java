package net.pythonbear.tead.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class HighlandAxeItem extends AxeItem {
    private final float attackDamage;
    public final float knockbackMagnitude;
    public final float knockbackRadius;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public HighlandAxeItem(ToolMaterial toolMaterial, Item.Settings settings) {
        super(toolMaterial, 7, 0.9f - 4, settings.maxDamage(toolMaterial.getDurability() + 16));
        this.knockbackMagnitude = 0.1f;
        this.knockbackRadius = 0.6f;
        this.attackDamage = toolMaterial.getAttackDamage() + 7;
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID,
                "Weapon modifier", this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID,
                "Weapon modifier", 0.9f - 4, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

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
            World world = attacker.getWorld();

            doAttackKnockback(world, target, attacker, this.knockbackMagnitude, this.knockbackRadius);
        }

        return super.postHit(stack, target, attacker);
    }

    private void doAttackKnockback(World world, LivingEntity target, LivingEntity attacker,
                                   Float knockbackStrength, Float knockbackRadius) {
        world.getEntitiesByClass(LivingEntity.class, target.getBoundingBox().expand(knockbackRadius),
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
