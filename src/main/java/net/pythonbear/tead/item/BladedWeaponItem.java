package net.pythonbear.tead.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

import net.minecraft.world.World;
import net.pythonbear.tead.util.CustomAttacking;
import net.pythonbear.tead.block.TeadBlocks;

public class BladedWeaponItem extends SwordItem implements Vanishable {
    private final float attackDamage;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    public final boolean dualWielded;
    public final float knockbackMagnitude;
    public final float knockbackRadius;
    public final int slownessAmplifier;
    public final int slownessDuration;
    public final float miningSpeed;

    public BladedWeaponItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, float knockbackMagnitude,
                            float knockbackRadius, int slownessAmplifier, int slownessDuration, float miningSpeed,
                            boolean dualWielded, Item.Settings settings) {
        super(toolMaterial, (int)attackDamage - 1, attackSpeed - 4, settings);
        this.knockbackMagnitude = knockbackMagnitude;
        this.knockbackRadius = knockbackRadius;
        this.slownessAmplifier = slownessAmplifier;
        this.slownessDuration = slownessDuration;
        this.miningSpeed = miningSpeed;
        this.dualWielded = dualWielded;
        this.attackDamage = attackDamage + toolMaterial.getAttackDamage() - 1;
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID,
                "Weapon modifier", this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID,
                "Weapon modifier", attackSpeed - 4, EntityAttributeModifier.Operation.ADDITION));
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
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        Item mainHandItem = user.getStackInHand(Hand.MAIN_HAND).getItem();

        if (hand == Hand.OFF_HAND && stack.getItem() instanceof BladedWeaponItem && ((BladedWeaponItem)stack.getItem()).dualWielded
                && (((mainHandItem instanceof BladedWeaponItem && ((BladedWeaponItem)mainHandItem).dualWielded))
                || ((mainHandItem instanceof HatchetItem && ((HatchetItem)mainHandItem).dualWielded)))
                || user.getStackInHand(Hand.MAIN_HAND).isEmpty()) {
            if (!user.getWorld().isClient()) {
                if (user.getItemCooldownManager().isCoolingDown(this)) {
                    return ActionResult.FAIL;
                } else {
                    user.getStackInHand(Hand.OFF_HAND).damage(1, user,
                            playerEntity -> playerEntity.sendToolBreakStatus(Hand.OFF_HAND));
                    user.getItemCooldownManager().set(this, 20);
                    if (stack.getItem() instanceof BladedWeaponItem) {
                        CustomAttacking.attack(user, entity, Hand.OFF_HAND, ((BladedWeaponItem) stack.getItem()).getAttackDamage());
                    } else {
                        CustomAttacking.attack(user, entity, Hand.OFF_HAND, ((HatchetItem) stack.getItem()).getAttackDamage());
                    }
                    return ActionResult.SUCCESS;
                }
            }
            return ActionResult.PASS;
        } else {
            return ActionResult.PASS;
        }
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if ((target instanceof PlayerEntity || target instanceof MobEntity) &&
                (this.knockbackMagnitude > 0  || this.slownessDuration > 0)) {
            World world = attacker.getWorld();

            doAttackKnockback(world, target, attacker, this.knockbackMagnitude, this.knockbackRadius);
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, this.slownessDuration,
                    slownessAmplifier, false, false, false));
        }

        return super.postHit(stack, target, attacker);
    }

    public void doAttackKnockback(World world, LivingEntity target, LivingEntity attacker,
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

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.isOf(Blocks.COBWEB) || state.isOf(TeadBlocks.WEAK_COBWEB)) {
            return 13.5f + this.miningSpeed;
        }
        return state.isIn(BlockTags.SWORD_EFFICIENT) ? this.miningSpeed : 1.0f;
    }
}
