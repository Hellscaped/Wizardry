package dev.hellscaped.wizardry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class WizardryItems {
    public static Item STAFF_ITEM = register(
        new StaffItem(new Item.Settings().rarity(Rarity.RARE).maxDamage(512)),
        "staff"
    );
    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(Wizardry.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
            .register((itemGroup) -> itemGroup.add(STAFF_ITEM));
    }
}
