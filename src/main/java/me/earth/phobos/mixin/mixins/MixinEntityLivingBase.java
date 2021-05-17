package me.earth.phobos.mixin.mixins;

import me.earth.phobos.util.Util;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityLivingBase.class)
public abstract class MixinEntityLivingBase extends Entity {

    public MixinEntityLivingBase(World worldIn) {
        super(worldIn);
    }

    @SuppressWarnings("EqualsBetweenInconvertibleTypes")
    @Inject(method = "isElytraFlying", at = @At("HEAD"), cancellable = true)
    private void isElytraFlyingHook(CallbackInfoReturnable<Boolean> info) {
        if (Util.mc.player != null && Util.mc.player.equals(this)) {
             {
                info.setReturnValue(false);
            }
        }
    }
}
