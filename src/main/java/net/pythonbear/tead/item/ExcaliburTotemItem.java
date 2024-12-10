package net.pythonbear.tead.item;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.pythonbear.tead.init.TeadItems;

public class ExcaliburTotemItem extends Item {
    private static final int MAX_HOLD_DURATION = 400;
    private ExcaliburTotemItem.PlayerState storedState;
    private long activationStartTime;
    private long timeElapsed;

    public ExcaliburTotemItem(Settings settings) {
        super(settings);
        this.storedState = null;
        this.activationStartTime = -1;
        this.timeElapsed = 0;
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
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (world.isClient) return TypedActionResult.pass(itemStack);

        if (this.storedState != null) {
            triggerRewind(world, player);
            player.getItemCooldownManager().set(this, MAX_HOLD_DURATION - 200);
            return TypedActionResult.success(itemStack);
        } else {
            this.storedState = new ExcaliburTotemItem.PlayerState(player.getPos(), player.getVelocity(), player.getHealth(), player.fallDistance);
            this.activationStartTime = world.getTime();

            world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 1.0f, 1.0f);
            return TypedActionResult.success(itemStack);
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!(entity instanceof PlayerEntity player)) return;
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
        if (this.storedState == null || world.isClient) return;

        PlayerInventory playerInventory = player.getInventory();
        Item itemInMainHand = playerInventory.getMainHandStack().getItem();

        if (itemInMainHand instanceof ExcaliburTotemItem) {
            playerInventory.setStack(playerInventory.selectedSlot, ItemStack.EMPTY);
        } else {
            playerInventory.offHand.set(0, ItemStack.EMPTY);
        }
        player.playerScreenHandler.sendContentUpdates();

        player.teleport(this.storedState.position.x, this.storedState.position.y, this.storedState.position.z);
        player.setVelocity(this.storedState.velocity);
        player.setHealth(this.storedState.health);
        player.fallDistance = this.storedState.fallDistance;
        player.velocityModified = true;

        this.storedState = null;
        this.activationStartTime = -1;
        this.timeElapsed = 0;

        world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0f, 1.0f);

        MinecraftClient client = MinecraftClient.getInstance();
        client.particleManager.addEmitter(player, ParticleTypes.TOTEM_OF_UNDYING, 20);

        if (client.player != null && client.player.isMainPlayer()) {
            client.gameRenderer.showFloatingItem(TeadItems.EXCALIBUR_TOTEM.getDefaultStack());
        }

        world.playSound(null, player.getBlockPos(), SoundEvents.ITEM_TOTEM_USE, SoundCategory.PLAYERS, 1.0f, 1.0f);
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
