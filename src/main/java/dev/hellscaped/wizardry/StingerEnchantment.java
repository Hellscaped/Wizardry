package dev.hellscaped.wizardry;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class StingerEnchantment extends Enchantment {
    public StingerEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 5;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof  LivingEntity livingEntity) {
            livingEntity.addStatusEffect(
                new StatusEffectInstance(
                    StatusEffects.POISON, 20 * 2 * level, level - 1
                )
            );
        }
        super.onTargetDamaged(user, target, level);
    }
}
