package net.pythonbear.tead.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Vanishable;
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
import net.minecraft.server.world.ServerWorld;
import net.pythonbear.tead.enchantments.TeadEnchantments;
import net.pythonbear.tead.sound.TeadSounds;
import net.pythonbear.tead.util.LightningTask;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class LightningStaffItem extends ExcaliburItem.StaffItem implements Vanishable {
    private static final Map<ServerWorld, List<LightningTask>> worldTaskMap = new HashMap<>();

    public LightningStaffItem(Settings settings) {
        super(TeadToolMaterials.ROSE_NETHERITE, 2.2f, -2f, 0.5f, 0.4f,
                settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            ItemStack itemStack = user.getStackInHand(hand);
            Map<Enchantment, Integer> itemStackEnchantments =
                    Optional.ofNullable(EnchantmentHelper.get(itemStack)).orElse(Map.of());
            int thunderingLevel = itemStackEnchantments.getOrDefault(TeadEnchantments.THUNDERING, 0);

            if (world.isRaining() && thunderingLevel > 0) {
                user.getItemCooldownManager().set(this, 90);
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        TeadSounds.SUMMON_LIGHTNING, SoundCategory.PLAYERS, 0.5f,
                        0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

                // Perform raycast
                Vec3d playerEyePos = user.getEyePos();
                Vec3d playerLook = user.getRotationVector();
                double rayLength = 100 - ((5 - thunderingLevel) * 10);
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
                            1, 1, false, false, false);
                    StatusEffectInstance magicHealthEffect = new StatusEffectInstance(StatusEffects.RESISTANCE,
                            2, 2, false, false, false);
                    user.addStatusEffect(magicHealthEffect);
                    user.addStatusEffect(magicDamageEffect);
                    user.getStackInHand(hand).damage(1, user,
                            playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
                }

                // Schedule the first strike immediately
                scheduleLightning((ServerWorld) world, strikePos, 0);

                // Schedule additional strikes for each level beyond 1
                for (int i = 1; i < thunderingLevel; i++) {
                    scheduleLightning((ServerWorld) world, strikePos, i * 20); // Delay of 20 ticks per level
                }
            } else {
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE, SoundCategory.PLAYERS, 0.5f,
                        0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
            }
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }

    private void scheduleLightning(ServerWorld world, Vec3d position, int delayTicks) {
        worldTaskMap.computeIfAbsent(world, w -> new ArrayList<>()).add(new LightningTask(position, delayTicks));
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.tead.lightning_staff.tooltip").formatted(Formatting.DARK_GREEN));
        super.appendTooltip(stack, world, tooltip, context);
    }

    public static void tick(ServerWorld world) {
        List<LightningTask> tasks = worldTaskMap.get(world);
        if (tasks == null || tasks.isEmpty()) {
            return;
        }

        List<LightningTask> completedTasks = new ArrayList<>();
        for (LightningTask task : tasks) {
            task.decrementDelay();
            if (task.isReady()) {
                LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                lightning.setPosition(task.getPosition());
                world.spawnEntity(lightning);
                completedTasks.add(task);
            }
        }

        tasks.removeAll(completedTasks);

        if (tasks.isEmpty()) {
            worldTaskMap.remove(world);
        }
    }

}
