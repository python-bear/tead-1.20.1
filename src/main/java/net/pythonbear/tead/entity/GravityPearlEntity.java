package net.pythonbear.tead.entity;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.init.TeadEntityTypes;
import net.pythonbear.tead.init.TeadItems;

import java.util.List;

public class GravityPearlEntity extends Entity implements FlyingItemEntity {
    private static final TrackedData<ItemStack> ITEM = DataTracker.registerData(GravityPearlEntity.class, TrackedDataHandlerRegistry.ITEM_STACK);
    private double targetX;
    private double targetY;
    private double targetZ;
    private int lifespan;
    private boolean dropsItem;

    public GravityPearlEntity(EntityType<? extends GravityPearlEntity> entityType, World world) {
        super(entityType, world);
    }

    public GravityPearlEntity(World world, double x, double y, double z) {
        this(TeadEntityTypes.GRAVITY_PEARL, world);
        this.setPosition(x, y, z);
    }

    public void setItem(ItemStack stack) {
        if (!stack.isOf(TeadItems.GRAVITY_PEARL) || stack.hasNbt()) {
            this.getDataTracker().set(ITEM, stack.copyWithCount(1));
        }
    }

    private ItemStack getTrackedItem() {
        return this.getDataTracker().get(ITEM);
    }

    @Override
    public ItemStack getStack() {
        ItemStack itemStack = this.getTrackedItem();
        return itemStack.isEmpty() ? new ItemStack(TeadItems.GRAVITY_PEARL) : itemStack;
    }

    @Override
    protected void initDataTracker() {
        this.getDataTracker().startTracking(ITEM, ItemStack.EMPTY);
    }

    @Override
    public boolean shouldRender(double distance) {
        double d = this.getBoundingBox().getAverageSideLength() * 4.0;
        if (Double.isNaN(d)) {
            d = 4.0;
        }
        return distance < (d *= 64.0) * d;
    }

    /**
     * Sets where the eye will fly towards.
     * If close enough, it will fly directly towards it, otherwise, it will fly upwards, in the direction of the BlockPos.
     *
     * @param pos the block the eye of ender is drawn towards
     */
    public void initTargetPos(BlockPos pos) {
        double f = pos.getX() - this.getX();
        double g = pos.getZ() - this.getZ();
        double h = pos.getY() - this.getY();
        double distanceHorizontal = Math.sqrt(f * f + g * g);

        this.targetX = this.getX() + f / distanceHorizontal * 12.0;
        this.targetZ = this.getZ() + g / distanceHorizontal * 12.0;
        this.targetY = pos.getY();

        this.lifespan = 0;
        this.dropsItem = this.random.nextInt(5) > 0;
    }

    @Override
    public void setVelocityClient(double x, double y, double z) {
        this.setVelocity(x, y, z);
        if (this.prevPitch == 0.0f && this.prevYaw == 0.0f) {
            double d = Math.sqrt(x * x + z * z);
            this.setYaw((float)(MathHelper.atan2(x, z) * 57.2957763671875));
            this.setPitch((float)(MathHelper.atan2(y, d) * 57.2957763671875));
            this.prevYaw = this.getYaw();
            this.prevPitch = this.getPitch();
        }
    }

    protected static float updateProjectileRotation(float prevRot, float newRot) {
        while (newRot - prevRot < -180.0f) {
            prevRot -= 360.0f;
        }
        while (newRot - prevRot >= 180.0f) {
            prevRot += 360.0f;
        }
        return MathHelper.lerp(0.2f, prevRot, newRot);
    }

    @Override
    public void tick() {
        super.tick();
        Vec3d vec3d = this.getVelocity();
        double d = this.getX() + vec3d.x;
        double e = this.getY() + vec3d.y;
        double f = this.getZ() + vec3d.z;
        double g = vec3d.horizontalLength();
        this.setPitch(updateProjectileRotation(this.prevPitch, (float)(MathHelper.atan2(vec3d.y, g) * 57.2957763671875)));
        this.setYaw(updateProjectileRotation(this.prevYaw, (float)(MathHelper.atan2(vec3d.x, vec3d.z) * 57.2957763671875)));
        if (!this.getWorld().isClient) {
            double h = this.targetX - d;
            double i = this.targetZ - f;
            double j = this.targetY - e;
            float k = (float)Math.sqrt(h * h + i * i);
            float l = (float)MathHelper.atan2(i, h);
            double m = MathHelper.lerp(0.0025, g, (double)k);
            double n = vec3d.y;
            if (j < 0.0) {
                n += j * 0.015; // Move downward if the target is below
            } else {
                n += ((double)1 - n) * 0.015;
            }
            if (k < 1.0f) {
                m *= 0.8;
                n *= 0.8;
            }
            vec3d = new Vec3d(Math.cos(l) * m, n, Math.sin(l) * m);
            this.setVelocity(vec3d);
        }
        if (this.isTouchingWater()) {
            for (int p = 0; p < 4; ++p) {
                this.getWorld().addParticle(ParticleTypes.BUBBLE, d - vec3d.x * 0.25, e - vec3d.y * 0.25, f - vec3d.z * 0.25, vec3d.x, vec3d.y, vec3d.z);
            }
        } else {
            this.getWorld().addParticle(ParticleTypes.PORTAL, d - vec3d.x * 0.25 + this.random.nextDouble() * 0.6 - 0.3, e - vec3d.y * 0.25 - 0.5, f - vec3d.z * 0.25 + this.random.nextDouble() * 0.6 - 0.3, vec3d.x, vec3d.y, vec3d.z);
            this.getWorld().addParticle(ParticleTypes.PORTAL, d - vec3d.x * 0.45 + this.random.nextDouble() * 0.8 - 0.3, e - vec3d.y * 0.45 - 0.5, f - vec3d.z * 0.45 + this.random.nextDouble() * 0.8 - 0.3, vec3d.x, vec3d.y, vec3d.z);
            this.getWorld().addParticle(ParticleTypes.PORTAL, d - vec3d.x * 0.65 + this.random.nextDouble() * 0.8 - 0.3, e - vec3d.y * 0.65 - 0.5, f - vec3d.z * 0.65 + this.random.nextDouble() * 0.8 - 0.3, vec3d.x, vec3d.y, vec3d.z);
        }
        if (!this.getWorld().isClient) {
            this.setPosition(d, e, f);
            ++this.lifespan;

            MinecraftClient client = MinecraftClient.getInstance();
            ClientWorld world = client.world;

            double gravityDistance = Math.max((int) ((this.lifespan - 20) / 12) * 1.5, 0);
            if (this.getWorld() != null) {
                this.getWorld().getEntitiesByClass(LivingEntity.class, this.getBoundingBox().expand(gravityDistance),
                        livingEntity -> true).forEach((entity) -> {
                    double distance = this.distanceTo(entity);
                    double pullFactor;
                    if (distance <= 0.5) {
                        pullFactor = 0.1;
                    } else if (distance >= gravityDistance) {
                        pullFactor = 0;
                    } else {
                        pullFactor = (1 / (distance - 1)) * 0.3;
                    }

                    Vec3d direction = new Vec3d(this.getX() - entity.getX(), this.getY() - entity.getY(), this.getZ() - entity.getZ()).normalize();
                    double entitySpeed = entity.getVelocity().length() + 0.4;
                    Vec3d pullVelocity = direction.multiply(Math.min(entitySpeed, 3) * pullFactor);

                    // Clamp the pullVelocity to a maximum value
                    double maxPullSpeed = 3.0;
                    if (pullVelocity.length() > maxPullSpeed) {
                        pullVelocity = pullVelocity.normalize().multiply(maxPullSpeed);
                    }

                    entity.addVelocity(pullVelocity.x, pullVelocity.y, pullVelocity.z);
                    entity.velocityModified = true;
                });
            }

        if (this.lifespan > 120 && !this.getWorld().isClient) {
                this.playSound(SoundEvents.ENTITY_ENDER_EYE_DEATH, 1.0f, 1.0f);
                this.discard();
                if (this.dropsItem) {
                    this.getWorld().spawnEntity(new ItemEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), this.getStack()));
                } else {
                    double x_shard = this.getX() + 0.5;
                    double y_shard = this.getY();
                    double z_shard = this.getZ() + 0.5;

                    if (world != null) {
                        for (int t = 0; t < 8; ++t) {
                            world.addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, new ItemStack(TeadItems.GRAVITY_PEARL)),
                                    x_shard, y_shard, z_shard,
                                    client.world.random.nextGaussian() * 0.15,
                                    client.world.random.nextDouble() * 0.2,
                                    client.world.random.nextGaussian() * 0.15);
                        }
                        for (double shard_r = 0.0; shard_r < Math.PI * 2; shard_r += 0.15707963267948966) {
                            world.addParticle(ParticleTypes.PORTAL,
                                    x_shard + Math.cos(shard_r) * 5.0,
                                    y_shard - 0.4,
                                    z_shard + Math.sin(shard_r) * 5.0,
                                    Math.cos(shard_r) * -5.0,
                                    0.0,
                                    Math.sin(shard_r) * -5.0);
                            world.addParticle(ParticleTypes.PORTAL,
                                    x_shard + Math.cos(shard_r) * 5.0,
                                    y_shard - 0.4,
                                    z_shard + Math.sin(shard_r) * 5.0,
                                    Math.cos(shard_r) * -7.0,
                                    0.0,
                                    Math.sin(shard_r) * -7.0);
                        }
                    }
                }
            }
        } else {
            this.setPos(d, e, f);
        }
    }


    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        ItemStack itemStack = this.getTrackedItem();
        if (!itemStack.isEmpty()) {
            nbt.put("Item", itemStack.writeNbt(new NbtCompound()));
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        ItemStack itemStack = ItemStack.fromNbt(nbt.getCompound("Item"));
        this.setItem(itemStack);
    }

    @Override
    public float getBrightnessAtEyes() {
        return 3.0f;
    }

    @Override
    public boolean isAttackable() {
        return false;
    }
}
