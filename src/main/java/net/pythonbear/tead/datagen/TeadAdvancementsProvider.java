package net.pythonbear.tead.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementManager;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.block.TeadBlocks;
import net.pythonbear.tead.item.TeadItems;

import java.rmi.registry.Registry;
import java.util.function.Consumer;

public class TeadAdvancementsProvider extends FabricAdvancementProvider {
    public TeadAdvancementsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
//        Advancement metalCollectorAdvancement = Advancement.Builder.create()
//                .display(
//                        TeadItems.GALENA, // The display icon
//                        Text.literal("Metal Collector"), // The title
//                        Text.literal("Collect all of the raw Overworld metals"), // The description
//                        new Identifier("textures/gui/advancements/backgrounds/stone.png"), // Background image used
//                        AdvancementFrame.CHALLENGE, // Options: TASK, CHALLENGE, GOAL
//                        true, // Show toast top right
//                        true, // Announce to chat
//                        false // Hidden in the advancement tab
//                )
//                .criterion("has_galena", InventoryChangedCriterion.Conditions.items(TeadItems.GALENA))
//                .criterion("has_raw_gold", InventoryChangedCriterion.Conditions.items(Items.RAW_GOLD))
//                .criterion("has_raw_iron", InventoryChangedCriterion.Conditions.items(Items.RAW_IRON))
//                .criterion("has_raw_copper", InventoryChangedCriterion.Conditions.items(Items.RAW_COPPER))
//                .build(consumer, Tead.MOD_ID + "/metal_collector");
//
//        Advancement pigIronAdvancement = Advancement.Builder.create().parent(metalCollectorAdvancement)
//                .display(
//                        TeadItems.PIG_IRON_INGOT,
//                        Text.literal("When Pigs Smelt"),
//                        Text.literal("Well, no one saw this coming"),
//                        null,
//                        AdvancementFrame.TASK,
//                        true,
//                        true,
//                        false
//                )
//                .criterion("has_pig_iron", InventoryChangedCriterion.Conditions.items(TeadItems.PIG_IRON_INGOT))
//                .build(consumer, Tead.MOD_ID + "/pig_iron");
//
//        Advancement ironAdvancement = Advancement.Builder.create().parent(metalCollectorAdvancement)
//                .display(
//                        TeadItems.PIG_IRON_INGOT,
//                        Text.literal("The Iron Inside"),
//                        Text.literal("Combine coke and pig iron in a smelter"),
//                        null,
//                        AdvancementFrame.TASK,
//                        true,
//                        true,
//                        false
//                )
//                .criterion("has_iron", InventoryChangedCriterion.Conditions.items(Items.IRON_INGOT))
//                .build(consumer, Tead.MOD_ID + "/iron");
//
//        Advancement steelAdvancement = Advancement.Builder.create().parent(ironAdvancement)
//                .display(
//                        TeadItems.PIG_IRON_INGOT,
//                        Text.literal("Tempered Resolve"),
//                        Text.literal("Smelt together two iron ingots"),
//                        null,
//                        AdvancementFrame.TASK,
//                        true,
//                        true,
//                        false
//                )
//                .criterion("has_steel", InventoryChangedCriterion.Conditions.items(TeadItems.STEEL_INGOT))
//                .build(consumer, Tead.MOD_ID + "/steel");
    }
}
