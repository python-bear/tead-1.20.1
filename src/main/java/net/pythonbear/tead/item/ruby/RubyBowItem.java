package net.pythonbear.tead.item.ruby;

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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.item.TeadItems;
import net.pythonbear.tead.item.arrow.AmethystArrowItem;
import net.pythonbear.tead.item.arrow.ObsidianArrowItem;
import net.pythonbear.tead.item.arrow.TransmorphingArrowItem;
import net.pythonbear.tead.sound.TeadSounds;

import java.util.function.Predicate;

import static net.pythonbear.tead.item.ruby.RubyToolTransmuting.hasTransmorphing;

public class RubyBowItem extends BowItem implements Vanishable, TransmutableTool {
    public final Predicate<ItemStack> BOW_PROJECTILES = stack ->
            stack.isIn(ItemTags.ARROWS) || stack.getItem() == TeadItems.RUBY_ARROW ||
                    stack.getItem() == TeadItems.TRANSMORPHING_ARROW;

    public RubyBowItem(ToolMaterial toolMaterial, Settings settings) {
        super(settings);
    }

    @Override
    public Predicate<ItemStack> getHeldProjectiles() {
        return this.getProjectiles();
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return BOW_PROJECTILES;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack handStack = user.getStackInHand(hand);

        if (!world.isClient) {
            ItemStack transmutedTool = RubyToolTransmuting.rotateTransmutation(handStack);
            if (user.isSneaking() && hasTransmorphing(handStack) && transmutedTool != handStack) {
                Vec3d pos = user.getPos();
                user.setStackInHand(hand, transmutedTool);
                world.playSound(null, pos.x, pos.y, pos.z, TeadSounds.TRANSMORPH, SoundCategory.PLAYERS, 1.0f, world.random.nextFloat() * 0.1f + 0.9f);
                return TypedActionResult.fail(transmutedTool);
            } else {
                return super.use(world, user, hand);
            }
        } else {
            return TypedActionResult.pass(handStack);
        }
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
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient == TeadItems.RUBY.getDefaultStack() || ingredient == Items.STRING.getDefaultStack();
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        boolean bl2;
        int i;
        float f;
        if (!(user instanceof PlayerEntity)) {
            return;
        }
        PlayerEntity playerEntity = (PlayerEntity)user;
        boolean bl = playerEntity.getAbilities().creativeMode || EnchantmentHelper.getLevel(Enchantments.INFINITY, stack) > 0;
        ItemStack itemStack = playerEntity.getProjectileType(stack);
        if (itemStack.isEmpty() && !bl) {
            return;
        }
        if (itemStack.isEmpty()) {
            itemStack = new ItemStack(Items.ARROW);
        }
        if ((double)(f = BowItem.getPullProgress(i = this.getMaxUseTime(stack) - remainingUseTicks)) < 0.1) {
            return;
        }
        bl2 = bl && itemStack.isOf(Items.ARROW);
        if (!world.isClient) {
            int k;
            int j;

            Item item = itemStack.getItem();
            PersistentProjectileEntity persistentProjectileEntity;

            ArrowItem arrowItem = (ArrowItem) item;
            persistentProjectileEntity = arrowItem.createArrow(world, itemStack, playerEntity);

            if (arrowItem instanceof TransmorphingArrowItem) {
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
            if (bl2 || playerEntity.getAbilities().creativeMode && (itemStack.isOf(Items.SPECTRAL_ARROW) || itemStack.isOf(Items.TIPPED_ARROW))) {
                persistentProjectileEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
            }
            world.spawnEntity(persistentProjectileEntity);
        }
        world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0f, 1.0f / (world.getRandom().nextFloat() * 0.4f + 1.2f) + f * 0.5f);
        if (!bl2 && !playerEntity.getAbilities().creativeMode) {
            itemStack.decrement(1);
            if (itemStack.isEmpty()) {
                playerEntity.getInventory().removeOne(itemStack);
            }
        }
        playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
    }

    public ItemStack getProjectileType(ItemStack stack, PlayerEntity user) {
        if (!(stack.getItem() instanceof RangedWeaponItem)) {
            return ItemStack.EMPTY;
        }

        Predicate<ItemStack> heldPredicate = ((RubyBowItem)stack.getItem()).getHeldProjectiles();
        ItemStack heldProjectile = getHeldProjectile(user, heldPredicate);
        if (!heldProjectile.isEmpty()) {
            return heldProjectile;
        }

        Predicate<ItemStack> inventoryPredicate = ((RubyBowItem)stack.getItem()).getProjectiles();
        for (int i = 0; i < user.getInventory().size(); ++i) {
            ItemStack inventoryProjectile = user.getInventory().getStack(i);
            if (inventoryPredicate.test(inventoryProjectile)) {
                return inventoryProjectile;
            }
        }

        return user.getAbilities().creativeMode ? new ItemStack(stack.getItem()) : ItemStack.EMPTY;
    }
}
