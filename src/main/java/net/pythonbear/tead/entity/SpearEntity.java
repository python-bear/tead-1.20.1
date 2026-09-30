package net.pythonbear.tead.entity;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SpearEntity extends PersistentProjectileEntity {
    private static final TrackedData<Boolean> ENCHANTED = DataTracker.registerData(SpearEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<ItemStack> SPEAR_STACK = DataTracker.registerData(SpearEntity.class, TrackedDataHandlerRegistry.ITEM_STACK);
    private ItemStack spearStack = ItemStack.EMPTY;
    private boolean dealtDamage;

    public SpearEntity(World world, LivingEntity owner, ItemStack stack) {
        super(TeadEntityTypes.SPEAR, owner, world);
        this.setSpearStack(stack);
    }

    public SpearEntity(EntityType<? extends SpearEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(SPEAR_STACK, ItemStack.EMPTY);
        this.dataTracker.startTracking(ENCHANTED, false);
    }

    @Override
    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }
        super.tick();
    }

    /**
     * The stack this spear gives back when picked up. On the server {@code spearStack} is the source of truth
     * (it is what gets saved to NBT); the client only has the synced tracked copy.
     */
    @Override
    public ItemStack asItemStack() {
        ItemStack stack = this.spearStack.isEmpty() ? this.dataTracker.get(SPEAR_STACK) : this.spearStack;
        return stack.copy();
    }

    /**
     * The stack used for rendering. Not copied, so do not modify it.
     */
    public ItemStack getRenderStack() {
        return this.dataTracker.get(SPEAR_STACK);
    }

    private void setSpearStack(ItemStack stack) {
        this.spearStack = stack.copy();
        this.dataTracker.set(SPEAR_STACK, stack.copy());
        this.dataTracker.set(ENCHANTED, stack.hasGlint());
    }

    public boolean isEnchanted() {
        return this.dataTracker.get(ENCHANTED);
    }

    @Override
    @Nullable
    protected EntityHitResult getEntityCollision(Vec3d currentPosition, Vec3d nextPosition) {
        if (this.dealtDamage) {
            return null;
        }
        return super.getEntityCollision(currentPosition, nextPosition);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        float f = 8.0f;
        if (entity instanceof LivingEntity livingEntity) {
            f += EnchantmentHelper.getAttackDamage(this.spearStack, livingEntity.getGroup());
        }
        Entity entity2 = this.getOwner();
        DamageSource damageSource = this.getDamageSources().trident(this, entity2 == null ? this : entity2);
        this.dealtDamage = true;
        SoundEvent soundEvent = SoundEvents.ITEM_TRIDENT_HIT;
        if (entity.damage(damageSource, f)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }
            if (entity instanceof LivingEntity livingEntity2) {
                if (entity2 instanceof LivingEntity) {
                    EnchantmentHelper.onUserDamaged(livingEntity2, entity2);
                    EnchantmentHelper.onTargetDamaged((LivingEntity)entity2, livingEntity2);
                }
                this.onHit(livingEntity2);
            }
        }
        this.setVelocity(this.getVelocity().multiply(-0.01, -0.1, -0.01));
        float g = 1.0f;
        if (this.getWorld() instanceof ServerWorld && this.hasFireAspect()) {
            entity.setOnFire(true);
            entity.setOnFireFor(5);
        }
        this.playSound(soundEvent, g, 1.0f);
    }

    public boolean hasFireAspect() {
        return EnchantmentHelper.getLevel(Enchantments.FIRE_ASPECT, this.spearStack) > 0;
    }

    @Override
    protected boolean tryPickup(PlayerEntity player) {
        return super.tryPickup(player) || this.isNoClip() && this.isOwner(player) && player.getInventory().insertStack(this.asItemStack());
    }

    @Override
    protected SoundEvent getHitSound() {
        return SoundEvents.ITEM_TRIDENT_HIT_GROUND;
    }

    @Override
    public void onPlayerCollision(PlayerEntity player) {
        if (this.isOwner(player) || this.getOwner() == null) {
            super.onPlayerCollision(player);
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        // Restore both the server-side stack and the synced copy; previously only the field was restored,
        // so reloaded spears were invisible and could not be picked up.
        if (nbt.contains("SpearStack", NbtElement.COMPOUND_TYPE)) {
            this.setSpearStack(ItemStack.fromNbt(nbt.getCompound("SpearStack")));
        } else {
            this.setSpearStack(ItemStack.EMPTY);
        }
        this.dealtDamage = nbt.getBoolean("DealtDamage");
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.put("SpearStack", this.spearStack.writeNbt(new NbtCompound()));
        nbt.putBoolean("DealtDamage", this.dealtDamage);
    }

    @Override
    public void age() {
        if (this.pickupType != PickupPermission.ALLOWED) {
            super.age();
        }
    }

    @Override
    protected float getDragInWater() {
        return 0.99f;
    }

    @Override
    public boolean shouldRender(double cameraX, double cameraY, double cameraZ) {
        return true;
    }
}

