package net.pythonbear.tead.item.armor;

import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;
import software.bernie.geckolib.model.GeoModel;

public class SwiftnessArmorModel extends GeoModel<SwiftnessArmorItem> {
    @Override
    public Identifier getModelResource(SwiftnessArmorItem animatable) {
        return new Identifier(Tead.MOD_ID, "geo/swiftness_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(SwiftnessArmorItem animatable) {
        return new Identifier(Tead.MOD_ID, "textures/models/armor/swiftness_armor.png");
    }

    @Override
    public Identifier getAnimationResource(SwiftnessArmorItem animatable) {
        return new Identifier(Tead.MOD_ID, "animations/swiftness_armor.animation.json");
    }
}
