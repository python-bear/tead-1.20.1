package net.pythonbear.tead.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;

public class TeadSounds {
    public static final SoundEvent ICE_SMASH = registerSoundEvent("ice_smash");
    public static final SoundEvent BREEZE = registerSoundEvent("breeze");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Tead.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static void registerSounds() {
        Tead.LOGGER.info("Registering mod sounds for " + Tead.MOD_ID);
    }
}
