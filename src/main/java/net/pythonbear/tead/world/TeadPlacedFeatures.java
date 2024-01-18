package net.pythonbear.tead.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.pythonbear.tead.Tead;

import java.util.List;

public class TeadPlacedFeatures {
    public static final RegistryKey<PlacedFeature> RUBY_ORE_PLACED_KEY = registryKey("ruby_ore_placed");
    public static final RegistryKey<PlacedFeature> DEEPSLATE_RUBY_ORE_PLACED_KEY =
            registryKey("deepslate_ruby_ore_placed");
    public static final RegistryKey<PlacedFeature> LEAD_ORE_PLACED_KEY = registryKey("lead_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configureFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, RUBY_ORE_PLACED_KEY,
                configureFeatureRegistryEntryLookup.getOrThrow(TeadConfiguredFeatures.RUBY_ORE_KEY),
                TeadOrePlacement.modifiersWithCount(1, // veins per chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(232))));
        register(context, DEEPSLATE_RUBY_ORE_PLACED_KEY,
                configureFeatureRegistryEntryLookup.getOrThrow(TeadConfiguredFeatures.DEEPSLATE_RUBY_ORE_KEY),
                TeadOrePlacement.modifiersWithCount(1, // veins per chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(0))));
        register(context, LEAD_ORE_PLACED_KEY,
                configureFeatureRegistryEntryLookup.getOrThrow(TeadConfiguredFeatures.LEAD_ORE_KEY),
                TeadOrePlacement.modifiersWithCount(8, // veins per chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(64))));
    }

    public static RegistryKey<PlacedFeature> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Tead.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> config, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }
}
