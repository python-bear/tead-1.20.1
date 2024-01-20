package net.pythonbear.tead.item.arrow;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.pythonbear.tead.entity.CustomizedArrowEntity;

public class EnderPearlArrowItem extends ArrowItem {
    public EnderPearlArrowItem(Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        CustomizedArrowEntity arrowEntity = new CustomizedArrowEntity(world, shooter);
        arrowEntity.initFromStack(stack);
        return arrowEntity;
    }
}
