package net.pythonbear.tead.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.pythonbear.tead.init.TeadItems;
import net.pythonbear.tead.init.TeadTags;

import java.util.concurrent.CompletableFuture;

public class TeadItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public TeadItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(TeadItems.COPPER_HELMET)
                .add(TeadItems.COPPER_CHESTPLATE)
                .add(TeadItems.COPPER_LEGGINGS)
                .add(TeadItems.COPPER_BOOTS)
                .add(TeadItems.COPPER_CHAINMAIL_HELMET)
                .add(TeadItems.COPPER_CHAINMAIL_CHESTPLATE)
                .add(TeadItems.COPPER_CHAINMAIL_LEGGINGS)
                .add(TeadItems.COPPER_CHAINMAIL_BOOTS)
                .add(TeadItems.STEEL_CHAINMAIL_HELMET)
                .add(TeadItems.STEEL_CHAINMAIL_CHESTPLATE)
                .add(TeadItems.STEEL_CHAINMAIL_LEGGINGS)
                .add(TeadItems.STEEL_CHAINMAIL_BOOTS)
                .add(TeadItems.ROSE_GOLD_CHAINMAIL_HELMET)
                .add(TeadItems.ROSE_GOLD_CHAINMAIL_CHESTPLATE)
                .add(TeadItems.ROSE_GOLD_CHAINMAIL_LEGGINGS)
                .add(TeadItems.ROSE_GOLD_CHAINMAIL_BOOTS)
                .add(TeadItems.BRONZE_CHAINMAIL_HELMET)
                .add(TeadItems.BRONZE_CHAINMAIL_CHESTPLATE)
                .add(TeadItems.BRONZE_CHAINMAIL_LEGGINGS)
                .add(TeadItems.BRONZE_CHAINMAIL_BOOTS)
                .add(TeadItems.ROBE_HELMET)
                .add(TeadItems.ROBE_CHESTPLATE)
                .add(TeadItems.ROBE_BOOTS)
                .add(TeadItems.COPPER_STALWART_HELMET)
                .add(TeadItems.COPPER_STALWART_CHESTPLATE)
                .add(TeadItems.IRON_STALWART_HELMET)
                .add(TeadItems.IRON_STALWART_CHESTPLATE)
                .add(TeadItems.DIAMOND_STALWART_HELMET)
                .add(TeadItems.DIAMOND_STALWART_CHESTPLATE)
                .add(TeadItems.NETHERITE_STALWART_HELMET)
                .add(TeadItems.NETHERITE_STALWART_CHESTPLATE)
                .add(TeadItems.COPPER_HIGHLAND_HELMET)
                .add(TeadItems.COPPER_HIGHLAND_CHESTPLATE)
                .add(TeadItems.IRON_HIGHLAND_HELMET)
                .add(TeadItems.IRON_HIGHLAND_CHESTPLATE)
                .add(TeadItems.DIAMOND_HIGHLAND_HELMET)
                .add(TeadItems.DIAMOND_HIGHLAND_CHESTPLATE)
                .add(TeadItems.NETHERITE_HIGHLAND_HELMET)
                .add(TeadItems.NETHERITE_HIGHLAND_CHESTPLATE)
                .add(TeadItems.COPPER_PLATE_HELMET)
                .add(TeadItems.COPPER_PLATE_CHESTPLATE)
                .add(TeadItems.COPPER_PLATE_BOOTS)
                .add(TeadItems.IRON_PLATE_HELMET)
                .add(TeadItems.IRON_PLATE_CHESTPLATE)
                .add(TeadItems.IRON_PLATE_BOOTS)
                .add(TeadItems.DIAMOND_PLATE_HELMET)
                .add(TeadItems.DIAMOND_PLATE_CHESTPLATE)
                .add(TeadItems.DIAMOND_PLATE_BOOTS)
                .add(TeadItems.NETHERITE_PLATE_HELMET)
                .add(TeadItems.NETHERITE_PLATE_CHESTPLATE)
                .add(TeadItems.NETHERITE_PLATE_BOOTS)

                .add(TeadItems.GOLD_GARMENT_CHESTPLATE)
                .add(TeadItems.GOLD_GARMENT_BOOTS)
                .add(TeadItems.GOLD_CHAINMAIL_HELMET)
                .add(TeadItems.GOLD_CHAINMAIL_CHESTPLATE)
                .add(TeadItems.GOLD_CHAINMAIL_LEGGINGS)
                .add(TeadItems.GOLD_CHAINMAIL_BOOTS)
                .add(TeadItems.GOLD_GUARD_HELMET)
                .add(TeadItems.GOLD_GUARD_CHESTPLATE)
                .add(TeadItems.GOLD_WOOLEN_HELMET)
                .add(TeadItems.GOLD_WOOLEN_CHESTPLATE)
                .add(TeadItems.GOLD_WOOLEN_LEGGINGS)
                .add(TeadItems.GOLD_WOOLEN_BOOTS)
                .add(TeadItems.GOLD_THIEF_HELMET)
                .add(TeadItems.GOLD_THIEF_CHESTPLATE)
                .add(TeadItems.GOLD_REINFORCED_MAIL_HELMET)
                .add(TeadItems.GOLD_REINFORCED_MAIL_CHESTPLATE)
                .add(TeadItems.GOLD_STALWART_HELMET)
                .add(TeadItems.GOLD_STALWART_CHESTPLATE)
                .add(TeadItems.GOLD_SPANGENHELM_HELMET)
                .add(TeadItems.GOLD_HIGHLAND_HELMET)
                .add(TeadItems.GOLD_HIGHLAND_CHESTPLATE)
                .add(TeadItems.GOLD_ROYAL_HELMET)
                .add(TeadItems.GOLD_MERCENARY_HELMET)
                .add(TeadItems.GOLD_PLATE_HELMET)
                .add(TeadItems.GOLD_PLATE_CHESTPLATE)
                .add(TeadItems.GOLD_PLATE_BOOTS)
                .add(TeadItems.GOLD_GHOSTLY_HELMET)
                .add(TeadItems.GOLD_GHOSTLY_CHESTPLATE)
                .add(TeadItems.GOLD_GHOSTLY_BOOTS);

        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(TeadItems.MUSIC_DISC_BATTLE_HYMN)
                .add(TeadItems.MUSIC_DISC_DAY_ONE)
                .add(TeadItems.MUSIC_DISC_HAIL_AND_KILL)
                .add(TeadItems.MUSIC_DISC_HOMELAND)
                .add(TeadItems.MUSIC_DISC_LORD_GIVE_ME_A_SIGN)
                .add(TeadItems.MUSIC_DISC_LOSE_YOURSELF)
                .add(TeadItems.MUSIC_DISC_MUTINY)
                .add(TeadItems.MUSIC_DISC_NEVER_GONNA_GIVE_YOU_UP)
                .add(TeadItems.MUSIC_DISC_NEVER_GONNA_STOP)
                .add(TeadItems.MUSIC_DISC_SWORDS_IN_THE_WIND)
                .add(TeadItems.MUSIC_DISC_THE_GODFATHER)
                .add(TeadItems.MUSIC_DISC_THE_HEART_ASKS_PLEASURE_FIRST)
                .add(TeadItems.MUSIC_DISC_THE_PHANTOM_OF_THE_OPERA)
                .add(TeadItems.MUSIC_DISC_TILL_I_COLLAPSE)
                .add(TeadItems.MUSIC_DISC_TIME)
                .add(TeadItems.MUSIC_DISC_UNTOUCHABLE);

        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(TeadItems.MUSIC_DISC_BATTLE_HYMN)
                .add(TeadItems.MUSIC_DISC_DAY_ONE)
                .add(TeadItems.MUSIC_DISC_HAIL_AND_KILL)
                .add(TeadItems.MUSIC_DISC_HOMELAND)
                .add(TeadItems.MUSIC_DISC_LORD_GIVE_ME_A_SIGN)
                .add(TeadItems.MUSIC_DISC_LOSE_YOURSELF)
                .add(TeadItems.MUSIC_DISC_MUTINY)
                .add(TeadItems.MUSIC_DISC_NEVER_GONNA_GIVE_YOU_UP)
                .add(TeadItems.MUSIC_DISC_NEVER_GONNA_STOP)
                .add(TeadItems.MUSIC_DISC_SWORDS_IN_THE_WIND)
                .add(TeadItems.MUSIC_DISC_THE_GODFATHER)
                .add(TeadItems.MUSIC_DISC_THE_HEART_ASKS_PLEASURE_FIRST)
                .add(TeadItems.MUSIC_DISC_THE_PHANTOM_OF_THE_OPERA)
                .add(TeadItems.MUSIC_DISC_TILL_I_COLLAPSE)
                .add(TeadItems.MUSIC_DISC_TIME)
                .add(TeadItems.MUSIC_DISC_UNTOUCHABLE);

        getOrCreateTagBuilder(TeadTags.Items.ROCKS)
                .add(TeadItems.ROCK)
                .add(TeadItems.SLATE)
                .add(TeadItems.BLACK_ROCK);
    }
}
