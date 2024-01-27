package net.pythonbear.tead.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.pythonbear.tead.entity.ShurikenProjectileEntity;
import net.pythonbear.tead.entity.TeadEntities;


public class ShurikenItem extends Item {
    public ShurikenItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.getItemCooldownManager().set(this, 8);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_TRIDENT_THROW,
                SoundCategory.NEUTRAL, 0.4f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        if (!world.isClient) {
            ShurikenProjectileEntity shurikenEntity = new ShurikenProjectileEntity(TeadEntities.SHURIKEN_PROJECTILE,
                    user, world);
            shurikenEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.5f, 0.1f);
            world.spawnEntity(shurikenEntity);
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
