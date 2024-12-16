package net.pythonbear.tead.entity.arrow;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.pythonbear.tead.entity.TeadEntityTypes;
import net.pythonbear.tead.item.TeadItems;


public class ObsidianArrowEntity extends PersistentProjectileEntity {
    public ObsidianArrowEntity(World world, LivingEntity owner) {
        super(TeadEntityTypes.OBSIDIAN_ARROW, owner, world);
    }

    public ObsidianArrowEntity(World world, double x, double y, double z) {
        super(TeadEntityTypes.OBSIDIAN_ARROW, x, y, z, world);
    }

    public ObsidianArrowEntity(EntityType<ObsidianArrowEntity> arrowEntity, World world) {
        super(arrowEntity, world);
    }

    public void initFromStack(ItemStack stack) {}

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(TeadItems.OBSIDIAN_ARROW);
    }
}
