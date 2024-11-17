package dev.hellscaped.wizardry;

import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Wizardry implements ModInitializer {
    public static final String MOD_ID = "wizardry";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Enchantment STINGER = new StingerEnchantment();
    public static Enchantment FIREBALL = new FireballEnchantment();

    @Override
    public void onInitialize() {
        LOGGER.info("Wizardry has initialized on the server.");
        EnchantFactory.initialize();
        Registry.register(Registries.ENCHANTMENT, new Identifier("wizardry", "stinger"), STINGER);
        Registry.register(Registries.ENCHANTMENT, new Identifier("wizardry", "fireball"), FIREBALL);
    }
}
