package net.pythonbear.tead;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.pythonbear.tead.init.*;
import net.pythonbear.tead.item.LightningStaffItem;
import net.pythonbear.tead.item.scythe.ScytheSwing;
import net.pythonbear.tead.item.sickle.PlayerBlockBreakHandler;
import net.pythonbear.tead.item.sickle.UseBlockHandler;
import net.pythonbear.tead.sound.TeadSounds;
import net.pythonbear.tead.util.DiedInVoid;
import net.pythonbear.tead.util.OnEntityDeath;
import net.pythonbear.tead.util.OnPlayerWorldTick;
import net.pythonbear.tead.world.gen.TeadWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class Tead implements ModInitializer {
	public static final String MOD_ID = "tead";
	public static final String MINECRAFT_ID = "minecraft";
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

		ServerTickEvents.END_WORLD_TICK.register(LightningStaffItem::tick);
		ServerTickEvents.END_WORLD_TICK.register(OnPlayerWorldTick::onWorldTick);
		ServerLivingEntityEvents.ALLOW_DEATH.register(OnEntityDeath::removeExcalibur);
		ServerLivingEntityEvents.AFTER_DEATH.register(DiedInVoid::craftExcalibur);

		LOGGER.info(MOD_ID + " fully initialized");
	}
}