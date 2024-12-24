package net.pythonbear.tead.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.pythonbear.tead.item.TeadItems;

public class TeadCustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 4, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.GOLD_INGOT, 2),
                    new ItemStack(Items.EMERALD, 27),
                    new ItemStack(TeadItems.SMITHING_GUIDE_TEMPEST),
                    1, 30, 0.2f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(TeadItems.FABRIC, 2),
                    new ItemStack(Items.EMERALD, 24),
                    new ItemStack(TeadItems.SMITHING_GUIDE_RAPIER),
                    1, 30, 0.2f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 4, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(TeadItems.BRASS_INGOT, 2),
                    new ItemStack(Items.EMERALD, 23),
                    new ItemStack(TeadItems.SMITHING_GUIDE_RAPIER),
                    1, 30, 0.2f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FLETCHER, 4, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.LAPIS_ORE, 4),
                    new ItemStack(Items.EMERALD, 23),
                    new ItemStack(TeadItems.AZURE_CROSSBOW),
                    1, 25, 0.2f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(TeadItems.ROSE_GOLD_INGOT, 2),
                    new ItemStack(Items.EMERALD, 19),
                    new ItemStack(TeadItems.SMITHING_GUIDE_RITE_DAGGER),
                    1, 25, 0.2f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 5, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.SPIDER_EYE, 15),
                    new ItemStack(Items.EMERALD, 21),
                    new ItemStack(TeadItems.TRANSMUTATION_GRIMOIRE),
                    1, 30, 0.2f
            ));
        });

        TradeOfferHelper.registerWanderingTraderOffers(2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 18),
                    new ItemStack(TeadItems.SMITHING_GUIDE_KATANA),
                    1, 25, 0.2f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 21),
                    new ItemStack(TeadItems.SMITHING_GUIDE_HIGHLAND),
                    1, 25, 0.2f
            ));
        });
    }
}
