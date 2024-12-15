package net.pythonbear.tead.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.pythonbear.tead.util.CustomAttacking;

public class HatchetItem extends AxeItem {
    private final float attackDamage;
    public final boolean dualWielded = true;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public HatchetItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, 4 - 1, 1.5f - 4, settings.maxDamage(toolMaterial.getDurability()));
        this.attackDamage = toolMaterial.getAttackDamage() + 4 - 1;
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID,
                "Weapon modifier", this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID,
                "Weapon modifier", 1.5f - 4, EntityAttributeModifier.Operation.ADDITION));
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

        if (hand == Hand.OFF_HAND && stack.getItem() instanceof HatchetItem && ((HatchetItem)stack.getItem()).dualWielded
                && (((mainHandItem instanceof BladedWeaponItem && ((BladedWeaponItem)mainHandItem).dualWielded))
                || (mainHandItem instanceof HatchetItem && ((HatchetItem)mainHandItem).dualWielded))
                || user.getStackInHand(Hand.MAIN_HAND).isEmpty()) {
            if (!user.getWorld().isClient()) {
                if (user.getItemCooldownManager().isCoolingDown(this)) {
                    return ActionResult.FAIL;
                } else {
                    user.getStackInHand(Hand.OFF_HAND).damage(1, user,
                            playerEntity -> playerEntity.sendToolBreakStatus(Hand.OFF_HAND));
                    user.getItemCooldownManager().set(this, 20);
                    CustomAttacking.attack(user, entity, Hand.OFF_HAND, ((HatchetItem) stack.getItem()).getAttackDamage());
                    return ActionResult.SUCCESS;
                }
            }
            return ActionResult.PASS;
        } else {
            return ActionResult.PASS;
        }
    }
}
