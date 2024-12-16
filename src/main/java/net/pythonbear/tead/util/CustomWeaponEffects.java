package net.pythonbear.tead.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.pythonbear.tead.item.TeadToolMaterials;

public class CustomWeaponEffects {
    public static ActionResult onAttackCallback(PlayerEntity playerEntity, World world, Hand hand, Entity entity,
                                                EntityHitResult entityHitResult) {
        if (!world.isClient() && entity instanceof LivingEntity && !playerEntity.isSpectator()) {
            ItemStack weapon = playerEntity.getStackInHand(hand);

            if (weapon.getItem() instanceof ToolItem tool && tool.getMaterial() == TeadToolMaterials.LEAD) {
                if (world.getRandom().nextInt(1) == 0) {
                    ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0));
                }
            }
        }
        return ActionResult.PASS;
    }
}
