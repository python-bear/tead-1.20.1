package net.pythonbear.tead.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;

public class TeadSounds {
    public static final SoundEvent BATTLE_HYMN = registerSoundEvent("battle_hymn");
    public static final SoundEvent DAY_ONE = registerSoundEvent("day_one");
    public static final SoundEvent HAIL_AND_KILL = registerSoundEvent("hail_and_kill");
    public static final SoundEvent HOMELAND = registerSoundEvent("homeland");
    public static final SoundEvent LORD_GIVE_ME_A_SIGN = registerSoundEvent("lord_give_me_a_sign");
    public static final SoundEvent LOSE_YOURSELF = registerSoundEvent("lose_yourself");
    public static final SoundEvent MUTINY = registerSoundEvent("mutiny");
    public static final SoundEvent NEVER_GONNA_GIVE_YOU_UP = registerSoundEvent("never_gonna_give_you_up");
    public static final SoundEvent NEVER_GONNA_STOP = registerSoundEvent("never_gonna_stop");
    public static final SoundEvent SWORD_IN_THE_WIND = registerSoundEvent("swords_in_the_wind");
    public static final SoundEvent THE_GODFATHER = registerSoundEvent("the_godfather");
    public static final SoundEvent THE_HEART_ASKS_PLEASURE_FIRST =
            registerSoundEvent("the_heart_asks_pleasure_first");
    public static final SoundEvent THE_PHANTOM_OF_THE_OPERA = registerSoundEvent("the_phantom_of_the_opera");
    public static final SoundEvent TILL_I_COLLAPSE = registerSoundEvent("till_i_collapse");
    public static final SoundEvent TIME = registerSoundEvent("time");
    public static final SoundEvent UNTOUCHABLE = registerSoundEvent("untouchable");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Tead.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static void registerSounds() {
        Tead.LOGGER.info("Registering mod sounds for " + Tead.MOD_ID);
    }
}
