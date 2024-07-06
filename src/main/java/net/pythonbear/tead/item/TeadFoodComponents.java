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

    public static final FoodComponent WHITE_GOLD_POTATO = new FoodComponent.Builder().alwaysEdible().hunger(1)
            .saturationModifier(0.6f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 660, 1), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 660, 2), 1).build();

    public static final FoodComponent ROSE_GOLD_BEETROOT = new FoodComponent.Builder().alwaysEdible().hunger(1)
            .saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 660, 1), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 660, 1), 1).build();

    public static final FoodComponent JERKY = new FoodComponent.Builder().hunger(1)
            .saturationModifier(1.3f).snack().build();
}
