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
import net.minecraft.world.World;
import net.pythonbear.tead.item.tool.BladedWeaponItem;
import net.pythonbear.tead.sound.TeadSounds;
import net.pythonbear.tead.util.RewindState;
import net.fabricmc.fabric.api.item.v1.FabricItem;


public class ExcaliburItem extends BladedWeaponItem implements FabricItem {
    public static final int MAX_HOLD_DURATION = RewindState.MAX_HOLD_DURATION;

    public ExcaliburItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, 8, 0.7f, 0.4f,
                1, 0, 0, 2.5f, false,
                settings);
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
        return RewindState.hasGlint(stack);
    }

    @Override
    public boolean allowNbtUpdateAnimation(PlayerEntity player, Hand hand, ItemStack oldStack, ItemStack newStack) {
        // The rewind point / glint lives in NBT; don't replay the equip animation every time it changes.
        return false;
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

        boolean offhandWithExcaliburInMainHand = hand == Hand.OFF_HAND
                && player.getStackInHand(Hand.MAIN_HAND).getItem() instanceof ExcaliburItem;

        if (RewindState.has(itemStack, player, world) && !offhandWithExcaliburInMainHand) {
            RewindState.rewind(itemStack, player, world);
            world.playSound(null, player.getBlockPos(), TeadSounds.TELEPORT, SoundCategory.PLAYERS, 1.0f, 1.0f);
            player.getItemCooldownManager().set(this, MAX_HOLD_DURATION - 200);
        } else {
            RewindState.store(itemStack, player, world);
            world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 1.0f, 1.0f);
        }
        return TypedActionResult.success(itemStack);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        RewindState.tick(stack, world);
    }
}
