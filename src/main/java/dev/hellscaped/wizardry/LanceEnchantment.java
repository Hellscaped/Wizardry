package dev.hellscaped.wizardry;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.TridentItem;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class LanceEnchantment extends InteractiveEnchantment {
    public LanceEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof SwordItem;
    }

    @Override
    public void onEnchantmentUse(PlayerEntity player, World world, Hand hand, int level, ItemStack item) {
        if (player.isOnGround()) {
            Vec3d lookVec = player.getRotationVec(1.0f);
            player.addVelocity(lookVec.multiply(level+0.5));
            player.velocityModified = true;
        }
    }

    @Override
    public int getMinPower(int level) {
        return 5 + (level*5);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}
