package net.pythonbear.tead;

import net.fabricmc.api.ModInitializer;

import net.pythonbear.tead.item.TeadItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tead implements ModInitializer {
	public static final String MOD_ID = "tead";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		TeadItems.registerModItems();

		LOGGER.info("Hello Fabric world!");
	}
}