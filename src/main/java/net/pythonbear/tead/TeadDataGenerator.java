package net.pythonbear.tead;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.pythonbear.tead.datagen.*;
import net.pythonbear.tead.world.TeadConfiguredFeatures;
import net.pythonbear.tead.world.TeadPlacedFeatures;

public class TeadDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(TeadBlockTagProvider::new);
		pack.addProvider(TeadItemTagProvider::new);
		pack.addProvider(TeadLootTableProvider::new);
		pack.addProvider(TeadModelProvider::new);
		pack.addProvider(TeadRecipeProvider::new);
		pack.addProvider(TeadWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, TeadConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, TeadPlacedFeatures::bootstrap);
	}
}
