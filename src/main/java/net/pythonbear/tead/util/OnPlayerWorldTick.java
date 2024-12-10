package net.pythonbear.tead.util;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;

import java.util.List;

public class OnPlayerWorldTick {
    public static void onWorldTick(ServerWorld world) {
        for (PlayerEntity player : world.getPlayers()) {
            BlockPos playerPos = player.getBlockPos();
            Box nearbyBox = new Box(playerPos.add(-6, -6, -6), playerPos.add(6, 6, 6));
            List<ItemEntity> allNearbyItems = world.getEntitiesByClass(ItemEntity.class, nearbyBox, ItemEntity::isAlive);

            FrostClaymoreHandler.onPlayerWorldTick(world, player, allNearbyItems, playerPos, nearbyBox);
            SummonStorm.onPlayerWorldTick(world, player, allNearbyItems, playerPos, nearbyBox);
        }
    }
}
