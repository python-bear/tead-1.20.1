package net.pythonbear.tead.util;

import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.pythonbear.tead.init.TeadEnchantments;

import java.util.List;

public class SummonStorm {
    public static void onPlayerWorldTick(ServerWorld world, PlayerEntity player, List<ItemEntity> allNearbyItems, BlockPos playerPos, Box nearbyBox) {
        List<ItemEntity> enchantedBookItems = allNearbyItems.stream()
                .filter(item -> item.getStack().getItem() == Items.ENCHANTED_BOOK)
                .toList();

        for (ItemEntity enchantedBook : enchantedBookItems) {
            BlockPos pos = enchantedBook.getBlockPos();
            if (world.getBlockState(pos).isOf(Blocks.WATER)) {
                boolean isThunderingBook = false;
                int thunderingLevel = 0;

                NbtList enchantments = enchantedBook.getStack().getNbt().getList("StoredEnchantments", NbtElement.COMPOUND_TYPE);

                for (NbtElement enchantment : enchantments) {
                    if (enchantment instanceof NbtCompound compound) {
                        String id = compound.getString("id");
                        int level = compound.getInt("lvl");

                        if ("tead:thundering".equals(id)) {
                            isThunderingBook = true;
                            thunderingLevel = level;
                            break;
                        }
                    }
                }

                if (isThunderingBook && player.experienceLevel >= 1) {
                    player.addExperienceLevels(-1);
                    world.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP,
                            SoundCategory.PLAYERS, 1.0f, 1.0f);

                    enchantedBook.discard();

                    LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                    lightning.setPosition(pos.getX(), pos.getY(), pos.getZ());
                    world.spawnEntity(lightning);
                    world.setWeather(0, 6000 * thunderingLevel, true, true);
                }
            }
        }
    }

    private static boolean hasThunderingEnchantment(ItemEntity itemEntity) {
        NbtList enchantments = itemEntity.getStack().getEnchantments();
        for (NbtElement enchantment : enchantments) {
            if (EnchantmentHelper.getEnchantmentId(TeadEnchantments.THUNDERING).equals(enchantment)) {
                return true;
            }
        }
        return false;
    }

}
