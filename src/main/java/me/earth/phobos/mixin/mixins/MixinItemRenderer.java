package me.earth.phobos.mixin.mixins;

import me.earth.phobos.features.Feature;
import me.earth.phobos.features.modules.render.ViewModel;
import org.spongepowered.asm.mixin.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.block.model.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ RenderItem.class })
public abstract class MixinItemRenderer
{
    public MixinItemRenderer() {
        super();
    }

    @Inject(method = { "renderItemModel" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/RenderItem;renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/renderer/block/model/IBakedModel;)V", shift = At.Shift.BEFORE) })
    private void test(final ItemStack stack, final IBakedModel bakedmodel, final ItemCameraTransforms.TransformType transform, final boolean leftHanded, final CallbackInfo ci) {
        if ((boolean) ViewModel.getINSTANCE().enabled.getValue() && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && !Feature.fullNullCheck()) {
            GlStateManager.scale((float)ViewModel.getINSTANCE().sizeX.getValue(), (float)ViewModel.getINSTANCE().sizeY.getValue(), (float)ViewModel.getINSTANCE().sizeZ.getValue());
            GlStateManager.rotate((float)ViewModel.getINSTANCE().rotationX.getValue() * 360.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate((float)ViewModel.getINSTANCE().rotationY.getValue() * 360.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate((float)ViewModel.getINSTANCE().rotationZ.getValue() * 360.0f, 0.0f, 0.0f, 1.0f);
            GlStateManager.translate((float)ViewModel.getINSTANCE().positionX.getValue(), (float)ViewModel.getINSTANCE().positionY.getValue(), (float)ViewModel.getINSTANCE().positionZ.getValue());
        }
    }
}

