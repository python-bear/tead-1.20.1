package net.pythonbear.tead.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.pythonbear.tead.entity.ShotgunProjectileEntity;
import net.pythonbear.tead.entity.TeadEntities;
import net.pythonbear.tead.init.TeadItems;

public class ShotgunItem extends BowItem {

    public ShotgunItem(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(Hand.OFF_HAND);
        boolean bl = itemStack.getItem() == TeadItems.LEAD_BULLET;
        if (!user.getAbilities().creativeMode && !bl) {
            return TypedActionResult.fail(user.getStackInHand(Hand.MAIN_HAND));
        } else {
            user.setCurrentHand(Hand.MAIN_HAND);
            return TypedActionResult.consume(user.getStackInHand(Hand.MAIN_HAND));
        }
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient == Items.IRON_INGOT.getDefaultStack() || ingredient == Items.GOLD_INGOT.getDefaultStack() ||
                super.canRepair(stack, ingredient);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!world.isClient) {
            ((PlayerEntity)user).getItemCooldownManager().set(this, 33);
            if (user instanceof PlayerEntity && (user.getOffHandStack().getItem() == TeadItems.LEAD_BULLET ||
                    ((PlayerEntity) user).isCreative())) {
                shootShotgun(world, (PlayerEntity) user);
            } else {
                world.playSound(user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_CHAIN_PLACE,
                        SoundCategory.PLAYERS, 1, 1, true);
            }
        }
    }

    private void shootShotgun(World world, PlayerEntity player) {
        for (int i = 0; i < 7; i++) {
            createSpreadProjectile(world, player);
        }

        world.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.0F, 1.0F);

        if (!player.isCreative()) {
            player.getOffHandStack().decrement(1);
        }
    }

    private void createSpreadProjectile(World world, PlayerEntity player) {
        ShotgunProjectileEntity projectile = new ShotgunProjectileEntity(TeadEntities.SHOTGUN_PROJECTILE, world,
                player);

        projectile.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 3.0F,
                8.0F);
        world.spawnEntity(projectile);
    }
}
