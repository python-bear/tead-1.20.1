package net.pythonbear.tead;

import net.fabricmc.api.ModInitializer;

import net.pythonbear.tead.init.TeadItemGroups;
import net.pythonbear.tead.init.TeadItems;
import net.pythonbear.tead.init.TeadBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tead implements ModInitializer {
	public static final String MOD_ID = "tead";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		TeadItemGroups.registerItemGroups();
		TeadItems.registerItems();
		TeadBlocks.registerBlocks();

		LOGGER.info("Hello Fabric world!");
	}
}