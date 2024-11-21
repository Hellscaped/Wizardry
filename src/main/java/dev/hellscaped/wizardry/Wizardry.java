package dev.hellscaped.wizardry;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Wizardry implements ModInitializer {
    public static final String MOD_ID = "wizardry";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Wizardry has initialized on the server.");
        EnchantRegistry.initialize();
        WizardryItems.initialize();
    }
}
