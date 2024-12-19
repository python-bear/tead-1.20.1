package net.pythonbear.tead.util;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.pythonbear.tead.Tead;

import java.util.List;

public class EnchantmentBookSpells {
    public static void onPlayerWorldTick(ServerWorld world, PlayerEntity player, List<ItemEntity> allNearbyItems, BlockPos playerPos, Box nearbyBox) {
        List<ItemEntity> enchantedBookItems = allNearbyItems.stream()
                .filter(item -> item.getStack().getItem() == Items.ENCHANTED_BOOK)
                .toList();

        for (ItemEntity enchantedBook : enchantedBookItems) {
            BlockPos pos = enchantedBook.getBlockPos();
            boolean isThunderingBook = false;
            int thunderingLevel = 0;
            boolean isSmitingBook = false;
            int smitingLevel = 0;
            boolean isArthropodBaneBook = false;
            int arthropodBaneLevel = 0;

            NbtList enchantments = enchantedBook.getStack().getNbt().getList("StoredEnchantments", NbtElement.COMPOUND_TYPE);

            if (enchantments == null) return;

            for (NbtElement enchantment : enchantments) {
                if (enchantment instanceof NbtCompound compound) {
                    String id = compound.getString("id");
                    int level = compound.getInt("lvl");

                    if ("tead:thundering".equals(id) && world.getBlockState(pos).isOf(Blocks.WATER)) {
                        isThunderingBook = true;
                        thunderingLevel = level;
                    }

                    if ("minecraft:smite".equals(id) && !world.getBlockState(pos.down()).isAir()) {
                        isSmitingBook = true;
                        smitingLevel = level;
                    }

                    if ("minecraft:bane_of_arthropods".equals(id) && !world.getBlockState(pos.down()).isAir()) {
                        isArthropodBaneBook = true;
                        arthropodBaneLevel = level;
                    }
                }

                if (player.experienceLevel >= 1) {
                    Random random = world.getRandom();

                    if (isThunderingBook || isSmitingBook || isArthropodBaneBook) {
                        Vec3d bookPos = enchantedBook.getPos();
                        world.spawnParticles(ParticleTypes.ELECTRIC_SPARK, bookPos.x, bookPos.y, bookPos.x, 15, random.nextFloat() - 0.5, random.nextFloat(), random.nextFloat() - 0.5, 0.1);
                        LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                        lightning.setPosition(pos.getX(), pos.getY(), pos.getZ());
                        world.spawnEntity(lightning);
                    }

                    if (isThunderingBook) {
                        player.addExperienceLevels(-1);
                        world.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP,
                                SoundCategory.PLAYERS, 1.0f, 1.0f);
                        enchantedBook.discard();
                        world.setWeather(0, 6000 * thunderingLevel, true, true);
                    }

                    if (isSmitingBook) {
                        List<LivingEntity> allUndeadEntities = world.getEntitiesByClass(LivingEntity.class, nearbyBox, LivingEntity::isUndead);

                        if (!allUndeadEntities.isEmpty()) {
                            player.addExperienceLevels(-1);
                            world.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP,
                                    SoundCategory.PLAYERS, 1.0f, 1.0f);
                            enchantedBook.discard();
                        }

                        for (LivingEntity undeadEntity : allUndeadEntities) {
                            Vec3d entityPos = undeadEntity.getPos();
                            world.spawnParticles(ParticleTypes.SOUL, entityPos.x, entityPos.y, entityPos.z, 1,
                                    0, 0.5, 0, 0.1);
                            for (int i = 0; i < 10; i++) {
                                world.spawnParticles(ParticleTypes.ASH, entityPos.x, entityPos.y, entityPos.z, 1,
                                        random.nextFloat() * 0.5, random.nextFloat() - 0.3,
                                        random.nextFloat() * 0.5, 0.01);
                            }
                            undeadEntity.kill();
                        }
                    }

                    if (isArthropodBaneBook) {
                        List<LivingEntity> allArthropodEntities = world.getEntitiesByClass(LivingEntity.class, nearbyBox, entity -> entity.getGroup() == EntityGroup.ARTHROPOD);

                        if (!allArthropodEntities.isEmpty()) {
                            player.addExperienceLevels(-1);
                            world.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP,
                                    SoundCategory.PLAYERS, 1.0f, 1.0f);
                            enchantedBook.discard();
                        }

                        for (LivingEntity arthropodEntity : allArthropodEntities) {
                            Vec3d entityPos = arthropodEntity.getPos();
                            world.spawnParticles(ParticleTypes.SOUL, entityPos.x, entityPos.y, entityPos.z, 1,
                                    0, 0.5, 0, 0.1);
                            for (int i = 0; i < 10; i++) {
                                world.spawnParticles(ParticleTypes.ASH, entityPos.x, entityPos.y, entityPos.z, 1,
                                        random.nextFloat() * 0.5, random.nextFloat() - 0.3,
                                        random.nextFloat() * 0.5, 0.01);
                            }
                            arthropodEntity.kill();
                        }
                    }
                }
            }
        }
    }
}
