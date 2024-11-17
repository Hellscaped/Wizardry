package dev.hellscaped.wizardry;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FireballEnchantment extends InteractiveEnchantment {
    public FireballEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.isOf(Items.STICK);
    }

    @Override
    public void onEnchantmentUse(PlayerEntity player, World world, Hand hand) {
        if (player.experienceLevel >= 2) {
            player.experienceLevel -= 2;
            Vec3d lookVec = player.getRotationVec(1.0f);
            Entity fireball = new SmallFireballEntity(
                EntityType.SMALL_FIREBALL,
                world
            );

            fireball.setPosition(player.getEyePos());
            fireball.setVelocity(lookVec.multiply(2.5));

            world.spawnEntity(fireball);
        }
    }

    @Override
    public int getMinPower(int level) {
        return 15;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}
