package net.pythonbear.tead;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.pythonbear.tead.datagen.*;

public class TeadDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(TeadBlockTagProvider::new);
		pack.addProvider(TeadItemTagProvider::new);
		pack.addProvider(TeadLootTableProvider::new);
		pack.addProvider(TeadModelProvider::new);
		pack.addProvider(TeadRecipeProvider::new);
	}
}
