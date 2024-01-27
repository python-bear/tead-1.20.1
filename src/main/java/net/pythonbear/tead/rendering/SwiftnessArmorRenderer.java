package net.pythonbear.tead.rendering;

import net.pythonbear.tead.item.SwiftnessArmorItem;
import net.pythonbear.tead.item.SwiftnessArmorModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SwiftnessArmorRenderer extends GeoArmorRenderer<SwiftnessArmorItem> {

    public SwiftnessArmorRenderer() {
        super(new SwiftnessArmorModel());
    }
}
