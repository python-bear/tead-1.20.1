package net.pythonbear.tead.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.pythonbear.tead.init.TeadItems;

import java.util.concurrent.CompletableFuture;

public class TeadItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public TeadItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(TeadItems.SWIFTNESS_BOOTS);

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
    }
}
