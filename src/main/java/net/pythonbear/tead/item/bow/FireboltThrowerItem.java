package net.pythonbear.tead.item.bow;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpectralArrowItem;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.pythonbear.tead.entity.arrow.ExplosiveArrowEntity;
import net.pythonbear.tead.entity.arrow.ExplosiveSpectralArrowEntity;
import net.pythonbear.tead.entity.arrow.TNTArrowEntity;
import net.pythonbear.tead.item.arrow.TntArrowItem;

public class FireboltThrowerItem extends CustomCrossbowItem {
    public FireboltThrowerItem(Settings settings) {
        super(settings, 27, 8, 3.15f, 1.9f, stack -> stack.isIn(ItemTags.ARROWS) || stack.getItem() instanceof TntArrowItem);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient == Items.STRING.getDefaultStack() || ingredient == Items.BLAZE_ROD.getDefaultStack()
                || ingredient == Items.GOLD_INGOT.getDefaultStack() || super.canRepair(stack, ingredient);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, LivingEntity entity, ItemStack crossbow, ItemStack arrow) {
        PersistentProjectileEntity arrowEntity;

        if (arrow.getItem() instanceof SpectralArrowItem) {
            arrowEntity = new ExplosiveSpectralArrowEntity(world, entity);
        } else if (arrow.getItem() instanceof TntArrowItem) {
            arrowEntity = new TNTArrowEntity(world, entity);
        } else {
            arrowEntity = new ExplosiveArrowEntity(world, entity);
            ((ExplosiveArrowEntity) arrowEntity).initFromStack(arrow);
        }

        if (entity instanceof PlayerEntity) {
            arrowEntity.setCritical(true);
        }

        arrowEntity.setSound(SoundEvents.ITEM_CROSSBOW_HIT);
        arrowEntity.setShotFromCrossbow(true);
        arrowEntity.setOnFireFor(360);
        int i = EnchantmentHelper.getLevel(Enchantments.PIERCING, crossbow);
        if (i > 0) {
            arrowEntity.setPierceLevel((byte)i);
        }

        return arrowEntity;
    }
}
