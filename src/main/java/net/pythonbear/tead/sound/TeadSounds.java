package net.pythonbear.tead.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;

public class TeadSounds {
    public static final SoundEvent ICE_SMASH = registerSoundEvent("ice_smash");
    public static final SoundEvent BREEZE = registerSoundEvent("breeze");
    public static final SoundEvent TELEPORT = registerSoundEvent("teleport");
    public static final SoundEvent METALLIC_CLINK = registerSoundEvent("metallic_clink");
    public static final SoundEvent SUMMON_LIGHTNING = registerSoundEvent("summon_lightning");
    public static final SoundEvent SOUL_SCREAM = registerSoundEvent("soul_scream");
    public static final SoundEvent FIERY_COMBUSTION = registerSoundEvent("fiery_combustion");
    public static final SoundEvent BONE_BOW_SHOOT = registerSoundEvent("bone_bow_shoot");
    public static final SoundEvent WIND_BOW_SHOOT = registerSoundEvent("wind_bow_shoot");
    public static final SoundEvent FROST_CLAYMORE_SUMMON = registerSoundEvent("frost_claymore_summon");
    public static final SoundEvent FROSTY_EXPLOSION = registerSoundEvent("frosty_explosion");
    public static final SoundEvent TRANSMUTATION = registerSoundEvent("transmutation");
    public static final SoundEvent TRANSMORPH = registerSoundEvent("transmorph");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Tead.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static void registerSounds() {
        Tead.LOGGER.info("Registering mod sounds for " + Tead.MOD_ID);
    }
}
