package net.pythonbear.tead.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.damage.DamageEffects;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class LightningStaffItem extends Item {
    public LightningStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            world.playSound(null, user.getX(), user.getY(), user.getZ(),
                    SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE, SoundCategory.NEUTRAL, 0.5f,
                    0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
            user.getItemCooldownManager().set(this, 90);

            Vec3d playerEyePos = user.getEyePos();
            Vec3d playerLook = user.getRotationVector();

            // Set the ray length
            double rayLength = 100.0;
            Vec3d rayEnd = playerEyePos.add(playerLook.multiply(rayLength));
            RaycastContext raycastContext = new RaycastContext(playerEyePos, rayEnd, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.ANY, user);
            BlockHitResult rayHit = world.raycast(raycastContext);

            // Check if the ray hit something
            if (rayHit.getType() == BlockHitResult.Type.MISS) {
                // If the ray missed
                LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                lightning.setPosition(user.getPos());
                world.spawnEntity(lightning);
                user.getStackInHand(hand).damage(8, user,
                        playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

            } else {
                // If the ray hit something
                BlockPos hitPos = rayHit.getBlockPos();
                LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                lightning.setPosition(hitPos.toCenterPos());
                world.spawnEntity(lightning);
                StatusEffectInstance magicDamageEffect = new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE,
                        1, 1);
                StatusEffectInstance magicHealthEffect = new StatusEffectInstance(StatusEffects.RESISTANCE,
                        2, 2);
                user.addStatusEffect(magicHealthEffect);
                user.addStatusEffect(magicDamageEffect);
                user.getStackInHand(hand).damage(1, user,
                        playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
            }
        }

        return TypedActionResult.pass(user.getStackInHand(hand));
    }
}
