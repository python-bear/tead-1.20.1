package net.pythonbear.tead;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.pythonbear.tead.init.*;
import net.pythonbear.tead.item.scythe.ScytheSwing;
import net.pythonbear.tead.item.sickle.PlayerBlockBreakHandler;
import net.pythonbear.tead.item.sickle.UseBlockHandler;
import net.pythonbear.tead.sound.TeadSounds;
import net.pythonbear.tead.world.gen.TeadWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class Tead implements ModInitializer {
	public static final String MOD_ID = "tead";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		GeckoLib.initialize();

		UseBlockCallback.EVENT.register(UseBlockHandler::handle);
		PlayerBlockBreakEvents.AFTER.register(PlayerBlockBreakHandler::handle);

		ScytheSwing.register();

		TeadSounds.registerSounds();
		TeadEnchantments.registerModEnchantments();
		TeadItemGroups.registerItemGroups();
		TeadItems.registerItems();
		TeadRecipeTypes.registerRecipeTypes();
		TeadRecipeSerializers.registerRecipeSerializers();
		TeadScreenHandlers.registerScreenHandlers();
		TeadBlocks.registerBlocks();
		TeadBlockEntities.registerBlockEntities();
		TeadLootTableModifiers.modifyLootTables();

		TeadWorldGeneration.generateTeadWorldGen();

		LOGGER.info("Hello Fabric world! - " + MOD_ID + " fully initialized");
	}
}