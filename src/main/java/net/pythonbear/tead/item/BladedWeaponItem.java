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
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.pythonbear.tead.init.CustomAttacking;

public class BladedWeaponItem extends ToolItem implements Vanishable {
    private final float attackDamage;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    public final boolean dualWielded;

    public BladedWeaponItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Item.Settings settings,
                            boolean dualWielded) {
        super(toolMaterial, settings);
        this.dualWielded = dualWielded;
        this.attackDamage = attackDamage + toolMaterial.getAttackDamage();
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID,
                "Weapon modifier", this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID,
                "Weapon modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.isOf(Blocks.COBWEB)) {
            return 15.0f;
        }
        return state.isIn(BlockTags.SWORD_EFFICIENT) ? 1.5f : 1.0f;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (state.getHardness(world, pos) != 0.0f) {
            stack.damage(2, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }
        return true;
    }

    @Override
    public boolean isSuitableFor(BlockState state) {
        return state.isOf(Blocks.COBWEB);
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

        if (hand == Hand.OFF_HAND && stack.getItem() instanceof BladedWeaponItem && ((BladedWeaponItem)
                stack.getItem()).dualWielded && ((mainHandItem instanceof BladedWeaponItem && ((BladedWeaponItem)
                mainHandItem).dualWielded)) || user.getStackInHand(Hand.MAIN_HAND).isEmpty()) {
            if (!user.getWorld().isClient()) {
                if (user.getItemCooldownManager().isCoolingDown(this)) {
                    return ActionResult.FAIL;
                } else {
                    user.getStackInHand(Hand.OFF_HAND).damage(1, user,
                            playerEntity -> playerEntity.sendToolBreakStatus(Hand.OFF_HAND));
                    user.getItemCooldownManager().set(this, 20);
                    CustomAttacking.attack(user, entity, Hand.OFF_HAND,
                            ((BladedWeaponItem) stack.getItem()).getAttackDamage());
                    return ActionResult.SUCCESS;
                }
            }
            return ActionResult.PASS;
        } else {
            return ActionResult.PASS;
        }
    }
}
