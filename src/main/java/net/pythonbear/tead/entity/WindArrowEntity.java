package net.pythonbear.tead.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class WindArrowEntity extends ArrowEntity {
    private Double startingXPos;
    private Double startingZPos;
    public WindArrowEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public WindArrowEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
        this.startingXPos = x;
        this.startingZPos = z;
    }

    public WindArrowEntity(World world, LivingEntity owner) {
        super(world, owner);
    }

    public WindArrowEntity(World world, LivingEntity owner, double x, double y, double z) {
        super(world, owner);
        this.startingXPos = x;
        this.startingZPos = z;
    }

    @Override
    protected void onHit(LivingEntity target) {
        super.onHit(target);
        if (this.startingXPos != null && this.startingZPos != null) {
            double xDelta = this.startingXPos - target.getX();
            double zDelta = this.startingZPos - target.getZ();

            double pullStrength = 0.5;
            double pullX = pullStrength * xDelta;
            double pullZ = pullStrength * zDelta;

            target.move(MovementType.SELF, new Vec3d(pullX, 0.5, pullZ));
        }
    }

}
