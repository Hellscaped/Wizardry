package dev.hellscaped.wizardry;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class InteractiveEnchantment extends Enchantment {
    public InteractiveEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
        UseItemCallback.EVENT.register(
            (player, world, hand) -> {
                ItemStack heldItem = player.getStackInHand(hand);
                if(EnchantmentHelper.getLevel(this, heldItem) > 0 && !world.isClient()) {
                    onEnchantmentUse(player, world, hand);
                }
                return TypedActionResult.success(heldItem);
            }
        );
    }

    public void onEnchantmentUse(PlayerEntity player, World world, Hand hand) {

    }
}
