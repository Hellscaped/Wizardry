package dev.hellscaped.wizardry;
import net.minecraft.item.Item;

public class StaffItem extends Item {
    public StaffItem(Settings settings) {
		super(settings);
    }

    public int getEnchantability() {
        return 1;
    }
}
