package net.pythonbear.tead.item.arrow;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.pythonbear.tead.entity.arrow.ObsidianArrowEntity;

public class ObsidianArrowItem extends ArrowItem {
    public ObsidianArrowItem(Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        ObsidianArrowEntity arrowEntity = new ObsidianArrowEntity(world, shooter);
        arrowEntity.initFromStack(stack);
        return arrowEntity;
    }
}
