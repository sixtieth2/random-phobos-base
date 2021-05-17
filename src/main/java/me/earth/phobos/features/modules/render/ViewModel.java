package me.earth.phobos.features.modules.render;

import me.earth.phobos.features.modules.Module;
import me.earth.phobos.features.setting.Setting;

public class ViewModel extends Module
{
    public Setting<Float> sizeX;
    public Setting<Float> sizeY;
    public Setting<Float> sizeZ;
    public Setting<Float> rotationX;
    public Setting<Float> rotationY;
    public Setting<Float> rotationZ;
    public Setting<Float> positionX;
    public Setting<Float> positionY;
    public Setting<Float> positionZ;
    public Setting<Float> itemFOV;
    private static ViewModel INSTANCE;

    public ViewModel() {
        super("Viewmodel", "Changes to the viewmodel.", Module.Category.RENDER, false, false, false);
        this.sizeX = (Setting<Float>)this.register(new Setting("SizeX", (Object)1.0f, (Object)0.0f, (Object)2.0f));
        this.sizeY = (Setting<Float>)this.register(new Setting("SizeY", (Object)1.0f, (Object)0.0f, (Object)2.0f));
        this.sizeZ = (Setting<Float>)this.register(new Setting("SizeZ", (Object)1.0f, (Object)0.0f, (Object)2.0f));
        this.rotationX = (Setting<Float>)this.register(new Setting("rotationX", (Object)0.0f, (Object)0.0f, (Object)1.0f));
        this.rotationY = (Setting<Float>)this.register(new Setting("rotationY", (Object)0.0f, (Object)0.0f, (Object)1.0f));
        this.rotationZ = (Setting<Float>)this.register(new Setting("rotationZ", (Object)0.0f, (Object)0.0f, (Object)1.0f));
        this.positionX = (Setting<Float>)this.register(new Setting("positionX", (Object)0.0f, (Object)(-2.0f), (Object)2.0f));
        this.positionY = (Setting<Float>)this.register(new Setting("positionY", (Object)0.0f, (Object)(-2.0f), (Object)2.0f));
        this.positionZ = (Setting<Float>)this.register(new Setting("positionZ", (Object)0.0f, (Object)(-2.0f), (Object)2.0f));
        this.itemFOV = (Setting<Float>)this.register(new Setting("ItemFOV", (Object)1.0f, (Object)0.0f, (Object)2.0f));
        this.setInstance();
    }

    private void setInstance() {
        ViewModel.INSTANCE = this;
    }

    public static ViewModel getINSTANCE() {
        if (ViewModel.INSTANCE == null) {
            ViewModel.INSTANCE = new ViewModel();
        }
        return ViewModel.INSTANCE;
    }

    static {
        ViewModel.INSTANCE = new ViewModel();
    }
}
