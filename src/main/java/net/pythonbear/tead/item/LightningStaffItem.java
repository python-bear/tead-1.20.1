package net.pythonbear.tead.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.pythonbear.tead.init.TeadToolMaterial;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LightningStaffItem extends StaffItem {
    public LightningStaffItem(Settings settings) {
        super(TeadToolMaterial.COPPER, 2.2f, -2f, 0.5f, 0.4f,
                settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            world.playSound(null, user.getX(), user.getY(), user.getZ(),
                    SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE, SoundCategory.NEUTRAL, 0.5f,
                    0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

            if (world.isRaining()) {
                user.getItemCooldownManager().set(this, 90);

                // Do ray stuff
                Vec3d playerEyePos = user.getEyePos();
                Vec3d playerLook = user.getRotationVector();
                double rayLength = 100.0;
                Vec3d rayEnd = playerEyePos.add(playerLook.multiply(rayLength));
                RaycastContext raycastContext = new RaycastContext(playerEyePos, rayEnd, RaycastContext.ShapeType.OUTLINE,
                        RaycastContext.FluidHandling.ANY, user);
                BlockHitResult rayHit = world.raycast(raycastContext);

                Vec3d strikePos;

                // Check if the ray hit something
                if (rayHit.getType() == BlockHitResult.Type.MISS) {
                    // If the ray missed
                    strikePos = user.getPos();
                    user.getStackInHand(hand).damage(8, user,
                            playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

                } else {
                    // If the ray hit something
                    strikePos = rayHit.getBlockPos().toCenterPos();
                    StatusEffectInstance magicDamageEffect = new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE,
                            1, 1);
                    StatusEffectInstance magicHealthEffect = new StatusEffectInstance(StatusEffects.RESISTANCE,
                            2, 2);
                    user.addStatusEffect(magicHealthEffect);
                    user.addStatusEffect(magicDamageEffect);
                    user.getStackInHand(hand).damage(1, user,
                            playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
                }

                LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                lightning.setPosition(strikePos);
                world.spawnEntity(lightning);
            }

        }

        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.tead.lightning_staff.tooltip").formatted(Formatting.DARK_GREEN));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
