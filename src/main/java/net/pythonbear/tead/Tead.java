package net.pythonbear.tead;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.pythonbear.tead.init.*;
import net.pythonbear.tead.item.sickle.PlayerBlockBreakHandler;
import net.pythonbear.tead.item.sickle.UseBlockHandler;
import net.pythonbear.tead.sound.TeadSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tead implements ModInitializer {
	public static final String MOD_ID = "tead";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		UseBlockCallback.EVENT.register(UseBlockHandler::handle);
		PlayerBlockBreakEvents.AFTER.register(PlayerBlockBreakHandler::handle);
		TeadSounds.registerSounds();
		TeadItemGroups.registerItemGroups();
		TeadItems.registerItems();
		TeadBlocks.registerBlocks();

		LOGGER.info("Hello Fabric world!");
	}
}