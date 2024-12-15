package net.pythonbear.tead.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class ExcaliburItem extends BladedWeaponItem {
    private static final int MAX_HOLD_DURATION = 400;
    private PlayerState storedState;
    private long activationStartTime;
    private long timeElapsed;

    public ExcaliburItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, 8, 0.7f, 0.4f,
                1, 0, 0, 2.5f, false,
                settings);
        this.storedState = null;
        this.activationStartTime = -1;
        this.timeElapsed = 0;
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return false;
    }

    @Override
    public boolean damage(DamageSource source) {
        return false;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return (this.timeElapsed > 390 && this.timeElapsed < 400) ||
                (this.timeElapsed > 370 && this.timeElapsed < 380) ||
                (this.timeElapsed > 350 && this.timeElapsed < 360) ||
                (this.timeElapsed > 320 && this.timeElapsed < 340) ||
                (this.timeElapsed > 290 && this.timeElapsed < 310) ||
                (this.timeElapsed > 0 && this.timeElapsed < 300);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if ((target instanceof PlayerEntity || target instanceof MobEntity) && this.knockbackMagnitude > 0) {
            World world = attacker.getWorld();

            this.doAttackKnockback(world, target, attacker, this.knockbackMagnitude, this.knockbackRadius);
        }

        target.addVelocity(attacker.getVelocity());
        target.velocityModified = true;

        return true;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (world.isClient) return TypedActionResult.pass(itemStack);

        if (this.storedState != null && !(hand == Hand.OFF_HAND && player.getStackInHand(Hand.MAIN_HAND).getItem() instanceof ExcaliburItem)) {
            triggerRewind(world, player);
            player.getItemCooldownManager().set(this, MAX_HOLD_DURATION - 200);
            return TypedActionResult.success(itemStack);
        } else {
            this.storedState = new ExcaliburItem.PlayerState(player.getPos(), player.getVelocity(), player.getHealth(), player.fallDistance);
            this.activationStartTime = world.getTime();

            world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 1.0f, 1.0f);
            return TypedActionResult.success(itemStack);
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!(entity instanceof PlayerEntity)) return;
        if (world.isClient || this.storedState == null) return;

        long currentTime = world.getTime();
        this.timeElapsed = currentTime - this.activationStartTime;

        if (this.activationStartTime != -1 && this.timeElapsed >= MAX_HOLD_DURATION) {
            this.storedState = null;
            this.activationStartTime = -1;
            this.timeElapsed = 0;
        }
    }

    private void triggerRewind(World world, PlayerEntity player) {
        if (this.storedState == null) return;

        player.teleport(this.storedState.position.x, this.storedState.position.y, this.storedState.position.z);
        player.setVelocity(this.storedState.velocity);
        player.setHealth(this.storedState.health);
        player.fallDistance = this.storedState.fallDistance;
        player.velocityModified = true;

        world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0f, 1.0f);

        this.storedState = null;
        this.activationStartTime = -1;
        this.timeElapsed = 0;
    }

    private static class PlayerState {
        final Vec3d position;
        final Vec3d velocity;
        final float health;
        final float fallDistance;

        public PlayerState(Vec3d position, Vec3d velocity, float health, float fallDistance) {
            this.position = position;
            this.velocity = velocity;
            this.health = health;
            this.fallDistance = fallDistance;
        }
    }
}
