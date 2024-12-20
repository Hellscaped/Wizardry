package dev.hellscaped.wizardry;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FireballEnchantment extends InteractiveEnchantment {
    public FireballEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.isOf(WizardryItems.STAFF_ITEM);
    }

    @Override
    public void onEnchantmentUse(PlayerEntity player, World world, Hand hand, int level, ItemStack item) {
        if (player.experienceLevel >= 2 || player.isCreative()) {
            player.experienceLevel -= player.isCreative() ? 0 : 2;
            Vec3d lookVec = player.getRotationVec(1.0f);
            Entity fireball = EntityType.SMALL_FIREBALL.create(world);
            assert fireball != null;
            ((FuckYouDrag)fireball).wizardry$setDisabled(true);
            fireball.setPosition(player.getEyePos());
            fireball.setVelocity(lookVec.multiply(2.5));
            fireball.setNoGravity(false);
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
