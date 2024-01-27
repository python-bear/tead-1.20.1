package net.pythonbear.tead.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.pythonbear.tead.entity.ShotgunProjectileEntity;
import net.pythonbear.tead.entity.TeadEntities;

public class ShotgunItem extends BowItem {

    public ShotgunItem(Settings settings) {
        super(settings);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity player) {
            int useDuration = this.getMaxUseTime(stack) - remainingUseTicks;

            if (useDuration >= 10) {
                shootShotgun(world, player, stack);
            }
        }
    }

    private void shootShotgun(World world, PlayerEntity player, ItemStack stack) {
        if (!world.isClient) {
            for (int i = 0; i < 5; i++) {
                ShotgunProjectileEntity projectile = createSpreadProjectile(world, player, stack, i);
                world.spawnEntity(projectile);
            }

            world.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.0F, 1.0F);

            if (!player.isCreative()) {
                player.getInventory().removeOne(stack);
            }
        }
    }

    private ShotgunProjectileEntity createSpreadProjectile(World world, PlayerEntity player, ItemStack stack, int index) {
        ShotgunProjectileEntity projectile = new ShotgunProjectileEntity(TeadEntities.SHOTGUN_PROJECTILE, world);

        // Adjust the spread angle based on the index (spread pattern)
        float spreadAngle = 10.0F; // Adjust the base spread angle as needed
        float randomOffset = (world.random.nextFloat() - 0.5F) * 2.0F * 5.0F; // Random offset within -5 to 5 degrees

        float angleOffset = index * spreadAngle + randomOffset;

        projectile.setVelocity(player, player.getPitch() + angleOffset, player.getYaw(), 0.0F, 3.0F,
                3.0F);
        return projectile;
    }
}
