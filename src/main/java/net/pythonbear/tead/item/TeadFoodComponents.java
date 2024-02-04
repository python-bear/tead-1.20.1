package net.pythonbear.tead.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class TeadFoodComponents {
    public static final FoodComponent LEAD_APPLE = new FoodComponent.Builder().alwaysEdible().hunger(-2)
            .saturationModifier(-0.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 800, 3), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 800, 2), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 679, 1), 1).build();

    public static final FoodComponent JERKY = new FoodComponent.Builder().hunger(3)
            .saturationModifier(1.8f).snack().build();
}
