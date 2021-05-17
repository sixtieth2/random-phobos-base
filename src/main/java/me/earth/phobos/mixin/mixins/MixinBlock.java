package me.earth.phobos.mixin.mixins;

import me.earth.phobos.features.modules.movement.Phase;
import me.earth.phobos.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;
import java.util.List;

@Mixin(Block.class)
public class MixinBlock {

    //TODO: WTF PLS USE AN EVENT
    @Inject(method = "addCollisionBoxToList(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/AxisAlignedBB;Ljava/util/List;Lnet/minecraft/entity/Entity;Z)V", at = @At("HEAD"), cancellable = true)
    public void addCollisionBoxToListHook(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState, CallbackInfo info) {
        if ((entityIn != null && Util.mc.player != null && (entityIn.equals(Util.mc.player) || (Util.mc.player.getRidingEntity() != null && entityIn.equals(Util.mc.player.getRidingEntity()))))) {
            info.cancel();
        }
    }

    @Inject(method = "isFullCube", at = { @At("HEAD") }, cancellable = true)
    public void isFullCubeHook(IBlockState blockState, CallbackInfoReturnable<Boolean> info) {
        try {
        } catch (Exception ignored) {}
    }

}
