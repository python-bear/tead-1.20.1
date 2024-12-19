package net.pythonbear.tead.rendering;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.item.FireboltThrower;
import net.pythonbear.tead.item.TeadItems;

public class TeadModelPredicateProvider {
    public static void registerTeadModels() {
        registerBow(TeadItems.BONE_BOW);
        registerBow(TeadItems.RUBY_POWER_BOW);
        registerBow(TeadItems.TRICK_BOW);
        registerBow(TeadItems.WIND_BOW);
        registerBow(TeadItems.WEBBED_BOW);
        registerBow(TeadItems.SHORT_BOW);
        registerBow(TeadItems.LONG_BOW);

        registerCrossBow(TeadItems.FIREBOLT_THROWER);

        registerSpear(TeadItems.WOOD_SPEAR);
        registerSpear(TeadItems.STONE_SPEAR);
        registerSpear(TeadItems.GOLD_SPEAR);
        registerSpear(TeadItems.LEAD_SPEAR);
        registerSpear(TeadItems.COPPER_SPEAR);
        registerSpear(TeadItems.ROSE_GOLD_SPEAR);
        registerSpear(TeadItems.WHITE_GOLD_SPEAR);
        registerSpear(TeadItems.IRON_SPEAR);
        registerSpear(TeadItems.BRASS_SPEAR);
        registerSpear(TeadItems.BRONZE_SPEAR);
        registerSpear(TeadItems.STEEL_SPEAR);
        registerSpear(TeadItems.DIAMOND_SPEAR);
        registerSpear(TeadItems.NETHERITE_SPEAR);
        registerSpear(TeadItems.ROSE_NETHERITE_SPEAR);
        registerSpear(TeadItems.WHITE_NETHERITE_SPEAR);
    }

    private static void registerSpear(Item spear) {
        ModelPredicateProviderRegistry.register(
                spear,
                new Identifier("throwing"), (stack, world, entity, seed) -> entity != null
                        && entity.isUsingItem()
                        && entity.getActiveItem() == stack ? 1.0f : 0.0f
        );
    }

    private static void registerBow(Item bow) {
        ModelPredicateProviderRegistry.register(bow, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0f;
            }
            if (entity.getActiveItem() != stack) {
                return 0.0f;
            }
            return (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0f;
        });
        ModelPredicateProviderRegistry.register(bow, new Identifier("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() ==
                        stack ? 1.0f : 0.0f);
    }

    private static void registerCrossBow(Item crossBow) {
        ModelPredicateProviderRegistry.register(crossBow, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0f;
            }
            if (FireboltThrower.isCharged(stack)) {
                return 0.0f;
            }
            return (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) /
                    (float)FireboltThrower.getPullTime(stack);
        });
        ModelPredicateProviderRegistry.register(
                crossBow, new Identifier("pulling"), (stack, world, entity, seed)
                        -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack && !CrossbowItem.isCharged(stack) ? 1.0f : 0.0f
        );
        ModelPredicateProviderRegistry.register(
                crossBow, new Identifier("charged"), (stack, world, entity, seed)
                        -> CrossbowItem.isCharged(stack) ? 1.0f : 0.0f)
        ;
        ModelPredicateProviderRegistry.register(
                crossBow, new Identifier("firework"), (stack, world, entity, seed)
                        -> CrossbowItem.isCharged(stack) && CrossbowItem.hasProjectile(stack, Items.FIREWORK_ROCKET) ? 1.0f : 0.0f
        );
    }
}
