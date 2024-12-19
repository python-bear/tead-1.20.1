package net.pythonbear.tead.item;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Vanishable;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;
import net.pythonbear.tead.entity.arrow.WebbedSpectralArrowEntity;
import net.pythonbear.tead.entity.arrow.WebbedArrowEntity;

public class WebbedBowItem extends BowItem implements Vanishable {
    public WebbedBowItem(Settings settings) {
        super(settings);
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (!world.isClient) {
            int duration = this.getMaxUseTime(stack) - remainingUseTicks;
             if (duration >= 20) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 10, 0,
                        false, false, false));
            }
        }
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient == Items.STRING.getDefaultStack() || ingredient == TeadItems.BRASS_INGOT.getDefaultStack();
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        float f;
        if (!(user instanceof PlayerEntity playerEntity)) {
            return;
        }
        boolean bl = playerEntity.getAbilities().creativeMode || EnchantmentHelper.getLevel(Enchantments.INFINITY,
                stack) > 0;
        ItemStack itemStack = playerEntity.getProjectileType(stack);
        if (itemStack.isEmpty() && !bl) {
            return;
        }
        if (itemStack.isEmpty()) {
            itemStack = new ItemStack(Items.ARROW);
        }
        if ((double)(f = BowItem.getPullProgress(this.getMaxUseTime(stack) - remainingUseTicks)) < 0.1) {
            return;
        }
        boolean bl2 = bl && itemStack.isOf(Items.ARROW);
        if (!world.isClient) {
            int k;
            int j;

            PersistentProjectileEntity persistentProjectileEntity = createWebbedArrow(world, itemStack, playerEntity);
            persistentProjectileEntity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(),
                    0.0f, f * 3.0f, 0.9f);
            if (f == 1.0f) {
                persistentProjectileEntity.setCritical(true);
            }
            if ((j = EnchantmentHelper.getLevel(Enchantments.POWER, stack)) > 0) {
                persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() + (double)j * 0.5 + 0.5);
            }
            if ((k = EnchantmentHelper.getLevel(Enchantments.PUNCH, stack)) > 0) {
                persistentProjectileEntity.setPunch(k);
            }
            if (EnchantmentHelper.getLevel(Enchantments.FLAME, stack) > 0) {
                persistentProjectileEntity.setOnFireFor(100);
            }

            stack.damage(1, playerEntity, p -> p.sendToolBreakStatus(playerEntity.getActiveHand()));
            if (bl2 || playerEntity.getAbilities().creativeMode && (itemStack.isOf(Items.SPECTRAL_ARROW) ||
                    itemStack.isOf(Items.TIPPED_ARROW))) {
                persistentProjectileEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
            }
            world.spawnEntity(persistentProjectileEntity);
        }
        world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(),
                SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0f, 1.0f /
                        (world.getRandom().nextFloat() * 0.4f + 1.2f) + f * 0.5f);
        if (!bl2 && !playerEntity.getAbilities().creativeMode) {
            itemStack.decrement(1);
            if (itemStack.isEmpty()) {
                playerEntity.getInventory().removeOne(itemStack);
            }
        }
        playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        user.removeStatusEffect(StatusEffects.SLOWNESS);
    }

    private PersistentProjectileEntity createWebbedArrow(World world, ItemStack stack, LivingEntity shooter) {
        if (stack.getItem() == Items.SPECTRAL_ARROW) {
            return new WebbedSpectralArrowEntity(world, shooter);
        } else {
            WebbedArrowEntity arrowEntity = new WebbedArrowEntity(world, shooter);
            arrowEntity.initFromStack(stack);
            return arrowEntity;
        }
    }
}
