package net.pythonbear.tead.item.bow;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;
import net.pythonbear.tead.item.TeadItems;

import java.util.function.Predicate;

public class TwinBowItem extends BowItem implements Vanishable {
    public TwinBowItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(Items.STRING) || ingredient.isOf(TeadItems.BRASS_INGOT);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!(user instanceof PlayerEntity)) {
            return;
        }
        PlayerEntity playerEntity = (PlayerEntity) user;
        boolean hasInfinity = playerEntity.getAbilities().creativeMode || EnchantmentHelper.getLevel(Enchantments.INFINITY, stack) > 0;
        ItemStack itemStack = playerEntity.getProjectileType(stack);

        if (itemStack.isEmpty() && !hasInfinity) {
            return;
        }
        if (itemStack.isEmpty()) {
            itemStack = new ItemStack(Items.ARROW);
        }

        float pullProgress = BowItem.getPullProgress(this.getMaxUseTime(stack) - remainingUseTicks);
        if ((double) pullProgress < 0.1) {
            return;
        }

        boolean isCreativeArrow = hasInfinity && itemStack.isOf(Items.ARROW);
        boolean twoArrows = true;
        if (!world.isClient) {
            ArrowItem arrowItem = (ArrowItem) (itemStack.getItem() instanceof ArrowItem ? itemStack.getItem() : Items.ARROW);
            if (user instanceof PlayerEntity) {
                twoArrows = getProjectileType(stack, (PlayerEntity)user).getCount() > 1 || playerEntity.getAbilities().creativeMode;
            }

            PersistentProjectileEntity mainArrow = arrowItem.createArrow(world, itemStack, playerEntity);
            mainArrow.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0f, pullProgress * 3.0f, 1.0f);
            if (pullProgress == 1.0f) {
                mainArrow.setCritical(true);
            }
            applyEnchantments(stack, mainArrow);
            world.spawnEntity(mainArrow);

            if (twoArrows) {
                PersistentProjectileEntity secondArrow = arrowItem.createArrow(world, itemStack, playerEntity);
                secondArrow.setVelocity(playerEntity, playerEntity.getPitch() - 10.0f, playerEntity.getYaw(), 0.0f, pullProgress * 3.0f, 1.0f);
                if (pullProgress == 1.0f) {
                    secondArrow.setCritical(true);
                }
                applyEnchantments(stack, secondArrow);
                world.spawnEntity(secondArrow);
            }
        }

        world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0f, 1.0f / (world.getRandom().nextFloat() * 0.4f + 1.2f) + pullProgress * 0.5f);

        if (!isCreativeArrow && !playerEntity.getAbilities().creativeMode) {
            itemStack.decrement((twoArrows) ? 2 : 1);
            if (itemStack.isEmpty()) {
                playerEntity.getInventory().removeOne(itemStack);
            }
        }

        playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        stack.damage(1, playerEntity, p -> p.sendToolBreakStatus(playerEntity.getActiveHand()));
    }

    private void applyEnchantments(ItemStack stack, PersistentProjectileEntity arrow) {
        int powerLevel = EnchantmentHelper.getLevel(Enchantments.POWER, stack);
        if (powerLevel > 0) {
            arrow.setDamage(arrow.getDamage() + (double) powerLevel * 0.5 + 0.5);
        }
        int punchLevel = EnchantmentHelper.getLevel(Enchantments.PUNCH, stack);
        if (punchLevel > 0) {
            arrow.setPunch(punchLevel);
        }
        if (EnchantmentHelper.getLevel(Enchantments.FLAME, stack) > 0) {
            arrow.setOnFireFor(100);
        }
    }

    public ItemStack getProjectileType(ItemStack stack, PlayerEntity user) {
        if (!(stack.getItem() instanceof RangedWeaponItem)) {
            return ItemStack.EMPTY;
        }

        Predicate<ItemStack> heldPredicate = ((TwinBowItem)stack.getItem()).getHeldProjectiles();
        ItemStack heldProjectile = getHeldProjectile(user, heldPredicate);
        if (!heldProjectile.isEmpty()) {
            return heldProjectile;
        }

        Predicate<ItemStack> inventoryPredicate = ((TwinBowItem)stack.getItem()).getProjectiles();
        for (int i = 0; i < user.getInventory().size(); ++i) {
            ItemStack inventoryProjectile = user.getInventory().getStack(i);
            if (inventoryPredicate.test(inventoryProjectile)) {
                return inventoryProjectile;
            }
        }

        return user.getAbilities().creativeMode ? new ItemStack(stack.getItem()) : ItemStack.EMPTY;
    }
}
