package net.pythonbear.tead.rendering;

import net.pythonbear.tead.item.armor.SwiftnessArmorItem;
import net.pythonbear.tead.item.armor.SwiftnessArmorModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SwiftnessArmorRenderer extends GeoArmorRenderer<SwiftnessArmorItem> {

    public SwiftnessArmorRenderer() {
        super(new SwiftnessArmorModel());
    }
}
