package net.pythonbear.tead.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.pythonbear.tead.network.TeadNetworking;
import net.pythonbear.tead.sound.TeadSounds;
import net.pythonbear.tead.util.RewindState;

public class ExcaliburTotemItem extends Item implements FabricItem {
    private static final int MAX_HOLD_DURATION = RewindState.MAX_HOLD_DURATION;

    public ExcaliburTotemItem(Settings settings) {
        super(settings);
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
        return false;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (world.isClient) return TypedActionResult.pass(itemStack);

        Item offhandItem = player.getStackInHand(Hand.OFF_HAND).getItem();
        Item mainhandItem = player.getStackInHand(Hand.MAIN_HAND).getItem();
        float offhandCooldown = player.getItemCooldownManager().getCooldownProgress(offhandItem, 0);
        float mainhandCooldown = player.getItemCooldownManager().getCooldownProgress(mainhandItem, 0);
        boolean shouldUseExcalibur = (hand == Hand.MAIN_HAND) ?
                (offhandItem instanceof ExcaliburItem && (offhandCooldown > 0.99f || offhandCooldown == 0)) :
                (mainhandItem instanceof ExcaliburItem && (mainhandCooldown > 0.99f || mainhandCooldown == 0));

        if (RewindState.has(itemStack, player, world) && !shouldUseExcalibur) {
            RewindState.rewind(itemStack, player, world);
            player.getItemCooldownManager().set(this, MAX_HOLD_DURATION - 200);

            world.playSound(null, player.getBlockPos(), TeadSounds.TELEPORT, SoundCategory.PLAYERS, 1.0f, 1.0f);
            world.playSound(null, player.getBlockPos(), SoundEvents.ITEM_TOTEM_USE, SoundCategory.PLAYERS, 1.0f, 1.0f);
            TeadNetworking.sendTotemEffect(player, new ItemStack(TeadItems.EXCALIBUR_TOTEM), 20);

            // The totem is used up (previously this also happened in creative, so that is kept).
            itemStack.decrement(1);
            return TypedActionResult.success(itemStack);
        } else {
            RewindState.store(itemStack, player, world);
            world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 1.0f, 1.0f);
            return TypedActionResult.success(itemStack);
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        RewindState.tick(stack, world);
    }
}
