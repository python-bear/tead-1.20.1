package net.pythonbear.tead.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.pythonbear.tead.init.TeadEntityTypes;
import net.pythonbear.tead.init.TeadItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class RubyArrowEntity extends PersistentProjectileEntity {
    @Nullable
    private Entity currentTarget;

    public RubyArrowEntity(World world, LivingEntity owner) {
        super(TeadEntityTypes.RUBY_ARROW, owner, world);
    }

    public RubyArrowEntity(World world, double x, double y, double z) {
        super(TeadEntityTypes.RUBY_ARROW, x, y, z, world);
    }

    public RubyArrowEntity(EntityType<RubyArrowEntity> arrowEntity, World world) {
        super(arrowEntity, world);
    }

    public void initFromStack(ItemStack stack) {}

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient) return;
        ServerWorld world = ((ServerWorld) this.getWorld());

        if (!this.inGround) {
            DustParticleEffect dustParticle = new DustParticleEffect(Vec3d.unpackRgb(0xC71836).toVector3f(), 1.0f);
            world.spawnParticles(dustParticle, this.getX(), this.getY(), this.getZ(), 1, 0, 0, 0, 0.1);

            LivingEntity owner = (LivingEntity) this.getOwner();

            if (this.currentTarget == null || !this.currentTarget.isAlive()
                    || !this.canSeeTarget(this.currentTarget, world) || !this.canHit(this.currentTarget)) {
                this.currentTarget = this.findClosestTarget(owner, world);
            }

            Vec3d currentVelocity = this.getVelocity();

            if (this.currentTarget != null) {
                Vec3d targetPos = this.currentTarget.getPos().add(0, this.currentTarget.getHeight() / 1.5f, 0);
                Vec3d targetDirection = targetPos.subtract(this.getPos()).normalize();

                double dotProduct = currentVelocity.dotProduct(targetDirection);
                double angle = Math.acos(dotProduct);
                double angleInDegrees = Math.toDegrees(angle);
                Vec3d smoothVelocity = currentVelocity.add(targetDirection.multiply(0.8));

                if (angleInDegrees > 30) {
                    smoothVelocity = smoothVelocity.multiply(0.5);
                } else if (angleInDegrees < 15) {
                    smoothVelocity = smoothVelocity.multiply(1.5);
                }

                if (smoothVelocity.length() < 0.9f) {
                    smoothVelocity = smoothVelocity.multiply(0.9f / smoothVelocity.length());  // Minimum speed
                } else if (smoothVelocity.length() > 10.0f) {
                    smoothVelocity = smoothVelocity.multiply(10.0f / smoothVelocity.length());  // Maximum speed
                }

                smoothVelocity = this.adjustForBlockAvoidance(smoothVelocity, world);

                this.setVelocity(smoothVelocity.x, smoothVelocity.y, smoothVelocity.z);

            } else {
                Vec3d smoothVelocity = this.adjustForBlockAvoidance(currentVelocity, world);

                this.setVelocity(smoothVelocity.x, smoothVelocity.y, smoothVelocity.z);
            }

        }
    }

    private Vec3d adjustForBlockAvoidance(Vec3d velocity, ServerWorld world) {
        Vec3d start = this.getPos();
        Vec3d end = start.add(velocity);

        RaycastContext context = new RaycastContext(
                start,
                end,
                RaycastContext.ShapeType.COLLIDER,
                RaycastContext.FluidHandling.NONE,
                this
        );
        BlockHitResult hitResult = world.raycast(context);

        if (hitResult.getType() == HitResult.Type.BLOCK) {
            Vec3d hitPos = hitResult.getPos();
            BlockPos blockHitPos = hitResult.getBlockPos();

            double originalSpeed = velocity.length();

            if (velocity.y < 0 && hitPos.getY() < this.getY() && !(blockHitPos.getY() == this.getBlockY())) {
                double adjustedY = 0;

                Vec3d horizontalVelocity = new Vec3d(velocity.x, 0, velocity.z);
                double horizontalSpeed = horizontalVelocity.length();
                if (horizontalSpeed > 0) {
                    double scale = Math.sqrt(originalSpeed * originalSpeed - adjustedY * adjustedY) / horizontalSpeed;
                    velocity = horizontalVelocity.multiply(scale).add(0, adjustedY, 0);
                } else {
                    velocity = new Vec3d(0, adjustedY, 0);
                }
            } else {
                Vec3d blockCenter = Vec3d.ofCenter(blockHitPos);
                Vec3d directionToBlock = blockCenter.subtract(this.getPos()).normalize();

                if (Math.abs(directionToBlock.x) > 0 || Math.abs(directionToBlock.z) > 0) {
                    double adjustedY = velocity.y + 5;
                    Vec3d horizontalVelocity = new Vec3d(velocity.x, 0, velocity.z).normalize();

                    velocity = horizontalVelocity.multiply(originalSpeed).add(0, adjustedY, 0).normalize().multiply(originalSpeed);
                }
            }
        }

        return velocity;
    }

    private Entity findClosestTarget(LivingEntity owner, World world) {
        boolean arrowInWater = this.isSubmergedInWater();

        List<LivingEntity> nearbyEntities = world.getEntitiesByClass(LivingEntity.class,
                this.getBoundingBox().expand(20.0), entity -> {
                    boolean entityInWater = entity.isSubmergedInWater();
                    if (entityInWater && !arrowInWater) return false;
                    return entity != owner && entity != this.currentTarget && this.canHit(entity) && entity.isAlive()
                            && this.canSeeTarget(entity, world);
                });

        Entity closestTarget = null;
        double closestDistance = Double.MAX_VALUE;

        for (LivingEntity entity : nearbyEntities) {
            double distance = this.squaredDistanceTo(entity);
            if (distance < closestDistance) {
                closestDistance = distance;
                closestTarget = entity;
            }
        }

        return closestTarget;
    }

    private boolean canSeeTarget(Entity target, World world) {
        Vec3d start = this.getPos();
        Vec3d end = target.getPos().add(0, target.getHeight() / 1.5f, 0);
        RaycastContext context = new RaycastContext(
                start,
                end,
                RaycastContext.ShapeType.COLLIDER,
                RaycastContext.FluidHandling.NONE,
                this
        );
        HitResult hitResult = world.raycast(context);
        return hitResult.getType() == HitResult.Type.MISS || (hitResult instanceof BlockHitResult
                && ((BlockHitResult) hitResult).getBlockPos().equals(target.getBlockPos()));
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        World world = this.getWorld();
        Vec3d pos = this.getPos();

        if (!world.isClient()) {
            ItemEntity arrow = new ItemEntity(world, pos.x, pos.y, pos.z, TeadItems.RUBY_ARROW.getDefaultStack());
            DustParticleEffect dustParticle = new DustParticleEffect(Vec3d.unpackRgb(0xC71836).toVector3f(), 1.0f);
            ((ServerWorld) world).spawnParticles(dustParticle, this.getX(), this.getY(), this.getZ(), 1, 0, 0, 0, 0.1);
            this.kill();
            world.spawnEntity(arrow);
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        if (this.currentTarget != null) {
            nbt.putUuid("currentTarget", this.currentTarget.getUuid());
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("currentTarget")) {
            UUID targetUuid = nbt.getUuid("currentTarget");
            this.currentTarget = ((ServerWorld) this.getWorld()).getEntity(targetUuid);
        }
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(TeadItems.RUBY_ARROW);
    }

    @Override
    protected float getDragInWater() {
        return 0.5f;
    }
}
