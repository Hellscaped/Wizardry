package dev.hellscaped.wizardry.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.hellscaped.wizardry.FuckYouDrag;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ExplosiveProjectileEntity.class)
public class ExplosiveProjectileEntityMixin implements FuckYouDrag {
    @Unique
    private boolean fuckYouDrag = false;
    public void wizardry$setDisabled(boolean disabled) {
        fuckYouDrag = true;
    }
    @ModifyReturnValue(method = "getDrag", at = @At("RETURN"))
    protected float getDrag(float original) {
        return fuckYouDrag ? 1F : original;
    }
}
