package net.pythonbear.tead.util;

import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.biome.Biome;

import net.pythonbear.tead.item.TeadItems;
import net.pythonbear.tead.sound.TeadSounds;

import java.util.List;

public class FrostClaymoreHandler {
    public static void onPlayerWorldTick(ServerWorld world, PlayerEntity player, List<ItemEntity> allNearbyItems, BlockPos playerPos, Box nearbyBox) {
        List<ItemEntity> frigidHiltItems = allNearbyItems.stream()
                .filter(item -> item.getStack().getItem() == TeadItems.FRIGID_HILT)
                .toList();

        for (ItemEntity frigidHilt : frigidHiltItems) {
            BlockPos pos = frigidHilt.getBlockPos();

            if (world.getBlockState(pos).isOf(Blocks.WATER)) {

                Biome biome = world.getBiome(pos).value();
                if (biome.getTemperature() <= 0.0f) {

                    List<ItemEntity> diamondEntities = world.getEntitiesByClass(ItemEntity.class,
                            new Box(pos.add(-3, -3, -3), pos.add(3, 3, 3)),
                            entity -> entity.getStack().getItem() == Items.DIAMOND);

                    int totalDiamonds = 0;

                    for (ItemEntity diamondEntity : diamondEntities) {
                        totalDiamonds += diamondEntity.getStack().getCount();
                    }

                    if (totalDiamonds >= 4 && player.experienceLevel >= 1) {
                        player.addExperienceLevels(-1);
                        world.playSound(null, pos, TeadSounds.FROST_CLAYMORE_SUMMON, SoundCategory.PLAYERS, 1.0f, 1.0f);

                        spawnIcyParticles(world, pos);
                        spawnIcyParticles(world, pos);

                        frigidHilt.discard();

                        int diamondsToRemove = 4;

                        for (ItemEntity diamondEntity : diamondEntities) {
                            ItemStack diamondStack = diamondEntity.getStack();
                            int stackCount = diamondStack.getCount();

                            if (stackCount <= diamondsToRemove) {
                                diamondsToRemove -= stackCount;
                                diamondEntity.discard();
                            } else {
                                diamondStack.decrement(diamondsToRemove);
                                diamondsToRemove = 0;
                                break;
                            }
                        }

                        ItemEntity frostClaymoreItem = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(),
                                TeadItems.FROST_CLAYMORE.getDefaultStack());
                        world.spawnEntity(frostClaymoreItem);
                    }

                }
            }
        }
    }

    private static void spawnIcyParticles(ServerWorld world, BlockPos pos) {
        for (int i = 0; i < 50; i++) {
            double offsetX = world.random.nextGaussian() * 0.5;
            double offsetY = world.random.nextGaussian() * 0.5;
            double offsetZ = world.random.nextGaussian() * 0.5;

            world.spawnParticles(
                    net.minecraft.particle.ParticleTypes.SNOWFLAKE,
                    pos.getX() + 0.5 + offsetX,
                    pos.getY() + 0.5 + offsetY,
                    pos.getZ() + 0.5 + offsetZ,
                    1,
                    offsetX,
                    offsetY,
                    offsetZ,
                    0.05
            );
        }
    }
}
