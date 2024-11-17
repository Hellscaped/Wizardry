package dev.hellscaped.wizardry.client;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WizardryClient implements ClientModInitializer {
    public static final String MOD_ID = "wizardry";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("Wizardry initialized on the client.");
    }
}
