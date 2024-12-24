package net.pythonbear.tead.item;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.pythonbear.tead.sound.TeadSounds;

public class SinisterSwordItem extends SwordItem {
    public SinisterSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getWorld();

        if (!world.isClient() && target instanceof LivingEntity) {
            attacker.heal((float) ((LivingEntity) attacker).defaultMaxHealth / 16);

            if (attacker.getRandom().nextFloat() < 0.1) {
                Vec3d pos = target.getPos();
                world.playSound(null, pos.x, pos.y, pos.z, TeadSounds.FIERY_COMBUSTION, SoundCategory.PLAYERS, 0.9f, 1.0f);
                attacker.setOnFireFor(3);
            }
        }

        stack.damage(10, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        super.postHit(stack, target, attacker);
        return true;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (!stack.hasEnchantments() || EnchantmentHelper.getLevel(Enchantments.FIRE_ASPECT, stack) < 2) {
            stack.addEnchantment(Enchantments.FIRE_ASPECT, 2);
        }
    }
}
