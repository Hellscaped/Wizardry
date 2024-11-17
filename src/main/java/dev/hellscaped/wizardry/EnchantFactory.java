package dev.hellscaped.wizardry;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public final class EnchantFactory {
    public static final RegistryKey<Enchantment> STINGER = of("stinger");
    public static final RegistryKey<Enchantment> FIREBALL = of("fireball");

    private static RegistryKey<Enchantment> of(String name) {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of("wizardry", name));
    }

    public static void initialize() {}
}
