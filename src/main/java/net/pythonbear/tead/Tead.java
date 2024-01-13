package net.pythonbear.tead;

import net.fabricmc.api.ModInitializer;

import net.pythonbear.tead.init.TeadItemGroups;
import net.pythonbear.tead.init.TeadItems;
import net.pythonbear.tead.init.TeadBlocks;
import net.pythonbear.tead.sound.TeadSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tead implements ModInitializer {
	public static final String MOD_ID = "tead";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		TeadSounds.registerSounds();
		TeadItemGroups.registerItemGroups();
		TeadItems.registerItems();
		TeadBlocks.registerBlocks();

		LOGGER.info("Hello Fabric world!");
	}
}