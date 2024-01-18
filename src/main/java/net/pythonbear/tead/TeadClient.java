package net.pythonbear.tead;

import net.fabricmc.api.ClientModInitializer;
import net.pythonbear.tead.init.TeadModelPredicateProvider;

public class TeadClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TeadModelPredicateProvider.registerTeadModels();

        Tead.LOGGER.info("Client mod for " + Tead.MOD_ID + " fully initialized");
    }
}
