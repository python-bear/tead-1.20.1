package net.pythonbear.tead.item.sickle;

import java.util.NoSuchElementException;

import net.minecraft.util.Hand;
import net.minecraft.util.math.random.Random;
import net.pythonbear.tead.Tead;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.pythonbear.tead.item.tool.SickleItem;

/**
 * {@link PlayerBlockBreakEvents#AFTER} event handler.
 * Handles the {@link PlayerBlockBreakEvents#AFTER} event to break-harvest and drop xp when possible.
 * See {@link #handle(World, PlayerEntity, BlockPos, BlockState, BlockEntity)} for more details.
 */
public final class PlayerBlockBreakHandler {
    /**
     * handles the {@link PlayerBlockBreakEvents#AFTER} event.
     * If configured to do so, drops xp when breaking a mature crop.
     *
     * @param world
     * @param player
     * @param pos
     * @param state
     * @param blockEntity
     */
    public static void handle(World world, PlayerEntity player, BlockPos pos, BlockState state,
                              BlockEntity blockEntity) {
        try {
            if (!world.isClient() && SickleHarvesting.isCrop(state.getBlock()) && SickleHarvesting.isMature(state)
                    && world.getGameRules().getBoolean(GameRules.DO_TILE_DROPS) &&
                    player.getStackInHand(Hand.MAIN_HAND).getItem() instanceof SickleItem) {
                Random random = world.getRandom();
                int experienceAmount = random.nextInt(2);

                ExperienceOrbEntity.spawn((ServerWorld) world, Vec3d.ofCenter(pos), experienceAmount);
            }
        } catch (NullPointerException | NoSuchElementException | ClassCastException e) {
            Tead.LOGGER.debug("Exception generated by block at [" + pos.toShortString() + "]");
            Tead.LOGGER.debug("This is a non blocking error, but can result in incorrect behavior for mod " +
                    Tead.MOD_ID);
            Tead.LOGGER.debug("Most probably the cause of this issue was that a non-crop ID was added in the " +
                    "configuration and its age property could not be retrieved, see stack trace for more details", e);
        }
    }
}