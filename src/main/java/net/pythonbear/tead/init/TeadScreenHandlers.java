package net.pythonbear.tead.init;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.screen.SmelterScreenHandler;

public class TeadScreenHandlers {
    public static final ScreenHandlerType<SmelterScreenHandler> SMELTER_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(Tead.MOD_ID, "smelter"), SmelterScreenHandler::new);

    public static void registerScreenHandlers() {
        Tead.LOGGER.info("Registering mod screen handlers for " + Tead.MOD_ID);
    }
}
