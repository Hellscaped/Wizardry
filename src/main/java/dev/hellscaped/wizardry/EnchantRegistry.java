package dev.hellscaped.wizardry;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public final class EnchantRegistry {
    public static final RegistryKey<Enchantment> STINGER = of("stinger");
    public static final RegistryKey<Enchantment> FIREBALL = of("fireball");
    public static final RegistryKey<Enchantment> FROST = of("frost");

    private static RegistryKey<Enchantment> of(String name) {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of("wizardry", name));
    }

    private static void register(String name, Enchantment ench) {
        Registry.register(Registries.ENCHANTMENT, new Identifier("wizardry", name), ench);
    }

    public static void initialize() {
        register("stinger", new StingerEnchantment());
        register("frost", new FrostEnchantment());
        register("fireball", new FireballEnchantment());
        register("lance", new LanceEnchantment());
    }
}
