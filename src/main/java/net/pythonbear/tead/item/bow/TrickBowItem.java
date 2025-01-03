package net.pythonbear.tead.item.bow;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.pythonbear.tead.item.TeadItems;
import net.pythonbear.tead.item.arrow.*;

import java.util.function.Predicate;

public class TrickBowItem extends BowItem implements Vanishable {
    public final Predicate<ItemStack> BOW_PROJECTILES = stack ->
            stack.isIn(ItemTags.ARROWS) ||
                    stack.getItem() == TeadItems.AMETHYST_ARROW ||
                    stack.getItem() == TeadItems.COPPER_ARROW ||
                    stack.getItem() == TeadItems.ENDER_PEARL_ARROW ||
                    stack.getItem() == TeadItems.OBSIDIAN_ARROW ||
                    stack.getItem() == TeadItems.RUBY_ARROW ||
                    stack.getItem() == TeadItems.TRANSMORPHING_ARROW ||
                    stack.getItem() == TeadItems.BORING_ARROW ||
                    stack.getItem() == TeadItems.TORCH_ARROW ||
                    stack.getItem() == TeadItems.REDSTONE_TORCH_ARROW ||
                    stack.getItem() == TeadItems.SOUL_TORCH_ARROW ||
                    stack.getItem() == TeadItems.TNT_ARROW;
    public TrickBowItem(Settings settings) {
        super(settings);
    }

    @Override
    public Predicate<ItemStack> getHeldProjectiles() {
        return this.getProjectiles();
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient == Items.STRING.getDefaultStack() || ingredient == TeadItems.ROSE_NETHERITE_INGOT.getDefaultStack() || super.canRepair(stack, ingredient);
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return BOW_PROJECTILES;
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (!world.isClient) {
            int duration = this.getMaxUseTime(stack) - remainingUseTicks;
             if (duration >= 25) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 10, 0,
                        false, false, false));
            }
        }
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        float f;
        if (!(user instanceof PlayerEntity playerEntity)) {
            return;
        }
        boolean bl = playerEntity.getAbilities().creativeMode || EnchantmentHelper.getLevel(Enchantments.INFINITY,
                stack) > 0;
        ItemStack itemStack = getProjectileType(stack, (PlayerEntity) user);
        if (itemStack.isEmpty() && !bl) {
            return;
        }
        if (itemStack.isEmpty()) {
            itemStack = new ItemStack(Items.ARROW);
        }
        if ((double)(f = TrickBowItem.getPullProgress(this.getMaxUseTime(stack) - remainingUseTicks)) < 0.1) {
            return;
        }
        boolean bl2 = bl && BOW_PROJECTILES.test(itemStack);
        if (!world.isClient) {
            int k;
            int j;

            Item item = itemStack.getItem();
            PersistentProjectileEntity persistentProjectileEntity;

            ArrowItem arrowItem = (ArrowItem) item;
            persistentProjectileEntity = arrowItem.createArrow(world, itemStack, playerEntity);

            if (arrowItem instanceof AmethystArrowItem || arrowItem instanceof ObsidianArrowItem) {
                persistentProjectileEntity.setPierceLevel((byte) 2);
            } else if (arrowItem instanceof TransmorphingArrowItem) {
                persistentProjectileEntity.setPierceLevel((byte) 127);
            }


            if (item instanceof TransmorphingArrowItem) {
                persistentProjectileEntity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(),
                        0.0f, f * 1.8f, 0.9f);
            } else {
                persistentProjectileEntity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(),
                        0.0f, f * 2.8f, 1.1f);
            }

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

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        boolean bl = !getProjectileType(itemStack, user).isEmpty();
        if (user.getAbilities().creativeMode || bl) {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(itemStack);
        }
        return TypedActionResult.fail(itemStack);
    }

    public ItemStack getProjectileType(ItemStack stack, PlayerEntity user) {
        if (!(stack.getItem() instanceof RangedWeaponItem)) {
            return ItemStack.EMPTY;
        }

        Predicate<ItemStack> heldPredicate = ((TrickBowItem)stack.getItem()).getHeldProjectiles();
        ItemStack heldProjectile = getHeldProjectile(user, heldPredicate);
        if (!heldProjectile.isEmpty()) {
            return heldProjectile;
        }

        Predicate<ItemStack> inventoryPredicate = ((TrickBowItem)stack.getItem()).getProjectiles();
        for (int i = 0; i < user.getInventory().size(); ++i) {
            ItemStack inventoryProjectile = user.getInventory().getStack(i);
            if (inventoryPredicate.test(inventoryProjectile)) {
                return inventoryProjectile;
            }
        }

        return user.getAbilities().creativeMode ? new ItemStack(stack.getItem()) : ItemStack.EMPTY;
    }
}
