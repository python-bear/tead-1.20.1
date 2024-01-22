package net.pythonbear.tead.item.client;

import net.pythonbear.tead.item.SwiftnessArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SwiftnessArmorRenderer extends GeoArmorRenderer<SwiftnessArmorItem> {

    public SwiftnessArmorRenderer() {
        super(new SwiftnessArmorModel());
    }
}
