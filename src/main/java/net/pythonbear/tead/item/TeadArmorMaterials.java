package net.pythonbear.tead.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.pythonbear.tead.Tead;

import java.util.function.Supplier;

public enum TeadArmorMaterials implements ArmorMaterial {
    SWIFTNESS("swiftness", 10, new int[] {1, 3, 2, 1}, 17, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0, 0, () -> Ingredient.ofItems(Items.LEATHER)),
    ROBE("robe", 5, new int[] {1, 3, 2, 1}, 16, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0, 0, () -> Ingredient.ofItems(Items.LEATHER)),
    GARMENT("garment", 2, new int[] {0, 0, 0, 0}, 11, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0, 0, () -> Ingredient.ofItems(Items.LEATHER)),

    STEEL("steel", 30, new int[]{3, 7, 6, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.STEEL_INGOT)),
    STEEL_REINFORCED_MAIL("steel_reinforced_mail", 32, new int[]{4, 8, 7, 4}, 8, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.STEEL_INGOT)),
    STEEL_GHOSTLY("steel_ghostly", 32, new int[]{3, 7, 6, 3}, 14, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.STEEL_INGOT)),
    STEEL_STALWART("steel_stalwart", 32, new int[]{5, 9, 8, 5}, 8, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.2F, () -> Ingredient.ofItems(TeadItems.STEEL_INGOT)),
    STEEL_CHAIN("steel_chain", 30, new int[]{2, 6, 5, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.STEEL_INGOT)),
    STEEL_SPANGENHELM("steel_spangenhelm", 32, new int[]{5, 8, 7, 5}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.STEEL_INGOT)),
    STEEL_MERCENARY("steel_mercenary", 33, new int[]{4, 8, 7, 4}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.3F, () -> Ingredient.ofItems(TeadItems.STEEL_INGOT)),
    STEEL_THIEF("steel_thief", 28, new int[]{3, 6, 6, 3}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.STEEL_INGOT)),
    STEEL_GUARD("steel_guard", 29, new int[]{3, 8, 6, 3}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.STEEL_INGOT)),
    STEEL_HIGHLAND("steel_highland", 31, new int[]{3, 7, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.STEEL_INGOT)),
    STEEL_PLATE("steel_plate", 34, new int[]{4, 8, 7, 4}, 8, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.5F, () -> Ingredient.ofItems(TeadItems.STEEL_INGOT)),
    STEEL_ROYAL("steel_royal", 27, new int[]{2, 7, 6, 3}, 13, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.STEEL_INGOT)),
    STEEL_WOOLEN("steel_woolen", 27, new int[]{2, 6, 5, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.STEEL_INGOT)),
    BRASS("brass", 25, new int[]{2, 6, 5, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.BRASS_INGOT)),
    BRASS_REINFORCED_MAIL("brass_reinforced_mail", 27, new int[]{3, 7, 6, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.BRASS_INGOT)),
    BRASS_GHOSTLY("brass_ghostly", 27, new int[]{2, 6, 5, 2}, 16, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.BRASS_INGOT)),
    BRASS_STALWART("brass_stalwart", 27, new int[]{4, 8, 7, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.2F, () -> Ingredient.ofItems(TeadItems.BRASS_INGOT)),
    BRASS_CHAIN("brass_chain", 25, new int[]{1, 5, 4, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.BRASS_INGOT)),
    BRASS_SPANGENHELM("brass_spangenhelm", 27, new int[]{4, 7, 6, 4}, 13, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.BRASS_INGOT)),
    BRASS_MERCENARY("brass_mercenary", 28, new int[]{3, 7, 6, 3}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.3F, () -> Ingredient.ofItems(TeadItems.BRASS_INGOT)),
    BRASS_THIEF("brass_thief", 23, new int[]{2, 5, 5, 2}, 13, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.BRASS_INGOT)),
    BRASS_GUARD("brass_guard", 24, new int[]{2, 7, 5, 2}, 13, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.BRASS_INGOT)),
    BRASS_HIGHLAND("brass_highland", 26, new int[]{2, 6, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.BRASS_INGOT)),
    BRASS_PLATE("brass_plate", 29, new int[]{3, 7, 6, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.5F, () -> Ingredient.ofItems(TeadItems.BRASS_INGOT)),
    BRASS_ROYAL("brass_royal", 22, new int[]{1, 6, 5, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.BRASS_INGOT)),
    BRASS_WOOLEN("brass_woolen", 22, new int[]{1, 5, 4, 1}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.BRASS_INGOT)),
    LEAD("lead", 12, new int[]{1, 5, 4, 2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.LEAD_INGOT)),
    LEAD_REINFORCED_MAIL("lead_reinforced_mail", 14, new int[]{2, 6, 5, 3}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.LEAD_INGOT)),
    LEAD_GHOSTLY("lead_ghostly", 14, new int[]{1, 5, 4, 2}, 6, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.LEAD_INGOT)),
    LEAD_STALWART("lead_stalwart", 14, new int[]{3, 7, 6, 4}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.2F, () -> Ingredient.ofItems(TeadItems.LEAD_INGOT)),
    LEAD_CHAIN("lead_chain", 12, new int[]{0, 4, 3, 2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.LEAD_INGOT)),
    LEAD_SPANGENHELM("lead_spangenhelm", 14, new int[]{3, 6, 5, 4}, 3, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.LEAD_INGOT)),
    LEAD_MERCENARY("lead_mercenary", 15, new int[]{2, 6, 5, 3}, 1, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.3F, () -> Ingredient.ofItems(TeadItems.LEAD_INGOT)),
    LEAD_THIEF("lead_thief", 10, new int[]{1, 4, 4, 2}, 3, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.LEAD_INGOT)),
    LEAD_GUARD("lead_guard", 11, new int[]{1, 6, 4, 2}, 3, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.LEAD_INGOT)),
    LEAD_HIGHLAND("lead_highland", 13, new int[]{1, 5, 5, 2}, 2, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.LEAD_INGOT)),
    LEAD_PLATE("lead_plate", 16, new int[]{2, 6, 5, 3}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.5F, () -> Ingredient.ofItems(TeadItems.LEAD_INGOT)),
    LEAD_ROYAL("lead_royal", 9, new int[]{0, 5, 4, 2}, 5, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.LEAD_INGOT)),
    LEAD_WOOLEN("lead_woolen", 9, new int[]{0, 4, 3, 1}, 1, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.LEAD_INGOT)),
    NETHERITE("netherite", 37, new int[]{3, 8, 6, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    NETHERITE_REINFORCED_MAIL("netherite_reinforced_mail", 39, new int[]{4, 9, 7, 4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 6.0F, 0.2F, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    NETHERITE_GHOSTLY("netherite_ghostly", 39, new int[]{3, 8, 6, 3}, 21, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.1F, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    NETHERITE_STALWART("netherite_stalwart", 39, new int[]{5, 10, 8, 5}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.3F, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    NETHERITE_CHAIN("netherite_chain", 37, new int[]{2, 7, 5, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    NETHERITE_SPANGENHELM("netherite_spangenhelm", 39, new int[]{5, 9, 7, 5}, 18, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.1F, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    NETHERITE_MERCENARY("netherite_mercenary", 40, new int[]{4, 9, 7, 4}, 16, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.4F, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    NETHERITE_THIEF("netherite_thief", 35, new int[]{3, 7, 6, 3}, 18, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 5.0F, 0.1F, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    NETHERITE_GUARD("netherite_guard", 36, new int[]{3, 9, 6, 3}, 18, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 6.0F, 0.2F, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    NETHERITE_HIGHLAND("netherite_highland", 38, new int[]{3, 8, 7, 3}, 17, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.2F, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    NETHERITE_PLATE("netherite_plate", 41, new int[]{4, 9, 7, 4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.6F, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    NETHERITE_ROYAL("netherite_royal", 34, new int[]{2, 8, 6, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    NETHERITE_WOOLEN("netherite_woolen", 34, new int[]{2, 7, 5, 2}, 16, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.2F, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    BRONZE("bronze", 19, new int[]{2, 6, 5, 3}, 6, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.BRONZE_INGOT)),
    BRONZE_REINFORCED_MAIL("bronze_reinforced_mail", 21, new int[]{3, 7, 6, 4}, 6, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.BRONZE_INGOT)),
    BRONZE_GHOSTLY("bronze_ghostly", 21, new int[]{2, 6, 5, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.BRONZE_INGOT)),
    BRONZE_STALWART("bronze_stalwart", 21, new int[]{4, 8, 7, 5}, 6, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.2F, () -> Ingredient.ofItems(TeadItems.BRONZE_INGOT)),
    BRONZE_CHAIN("bronze_chain", 19, new int[]{1, 5, 4, 3}, 6, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.BRONZE_INGOT)),
    BRONZE_SPANGENHELM("bronze_spangenhelm", 21, new int[]{4, 7, 6, 5}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.BRONZE_INGOT)),
    BRONZE_MERCENARY("bronze_mercenary", 22, new int[]{3, 7, 6, 4}, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.3F, () -> Ingredient.ofItems(TeadItems.BRONZE_INGOT)),
    BRONZE_THIEF("bronze_thief", 17, new int[]{2, 5, 5, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.BRONZE_INGOT)),
    BRONZE_GUARD("bronze_guard", 18, new int[]{2, 7, 5, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.BRONZE_INGOT)),
    BRONZE_HIGHLAND("bronze_highland", 20, new int[]{2, 6, 6, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.BRONZE_INGOT)),
    BRONZE_PLATE("bronze_plate", 23, new int[]{3, 7, 6, 4}, 6, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.5F, () -> Ingredient.ofItems(TeadItems.BRONZE_INGOT)),
    BRONZE_ROYAL("bronze_royal", 16, new int[]{1, 6, 5, 3}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.BRONZE_INGOT)),
    BRONZE_WOOLEN("bronze_woolen", 16, new int[]{1, 5, 4, 2}, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.BRONZE_INGOT)),
    GOLD("gold", 7, new int[]{2, 5, 3, 1}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_REINFORCED_MAIL("gold_reinforced_mail", 9, new int[]{3, 6, 4, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3.0F, 0.1F, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_GHOSTLY("gold_ghostly", 9, new int[]{2, 5, 3, 1}, 31, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F, 0.0F, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_STALWART("gold_stalwart", 9, new int[]{4, 7, 5, 3}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.2F, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_CHAIN("gold_chain", 7, new int[]{1, 4, 2, 1}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_SPANGENHELM("gold_spangenhelm", 9, new int[]{4, 6, 4, 3}, 28, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F, 0.0F, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_MERCENARY("gold_mercenary", 10, new int[]{3, 6, 4, 2}, 26, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.3F, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_THIEF("gold_thief", 5, new int[]{2, 4, 3, 1}, 28, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.0F, 0.0F, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_GUARD("gold_guard", 6, new int[]{2, 6, 3, 1}, 28, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3.0F, 0.1F, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_HIGHLAND("gold_highland", 8, new int[]{2, 5, 4, 1}, 27, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F, 0.1F, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_PLATE("gold_plate", 11, new int[]{3, 6, 4, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F, 0.5F, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_ROYAL("gold_royal", 4, new int[]{1, 5, 3, 1}, 30, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_WOOLEN("gold_woolen", 4, new int[]{1, 4, 2, 0}, 26, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.1F, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    DIAMOND("diamond", 33, new int[]{3, 8, 6, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.ofItems(Items.DIAMOND)),
    DIAMOND_REINFORCED_MAIL("diamond_reinforced_mail", 35, new int[]{4, 9, 7, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F, 0.1F, () -> Ingredient.ofItems(Items.DIAMOND)),
    DIAMOND_GHOSTLY("diamond_ghostly", 35, new int[]{3, 8, 6, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F, 0.0F, () -> Ingredient.ofItems(Items.DIAMOND)),
    DIAMOND_STALWART("diamond_stalwart", 35, new int[]{5, 10, 8, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.2F, () -> Ingredient.ofItems(Items.DIAMOND)),
    DIAMOND_CHAIN("diamond_chain", 33, new int[]{2, 7, 5, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.ofItems(Items.DIAMOND)),
    DIAMOND_SPANGENHELM("diamond_spangenhelm", 35, new int[]{5, 9, 7, 5}, 13, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F, 0.0F, () -> Ingredient.ofItems(Items.DIAMOND)),
    DIAMOND_MERCENARY("diamond_mercenary", 36, new int[]{4, 9, 7, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.3F, () -> Ingredient.ofItems(Items.DIAMOND)),
    DIAMOND_THIEF("diamond_thief", 31, new int[]{3, 7, 6, 3}, 13, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F, 0.0F, () -> Ingredient.ofItems(Items.DIAMOND)),
    DIAMOND_GUARD("diamond_guard", 32, new int[]{3, 9, 6, 3}, 13, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F, 0.1F, () -> Ingredient.ofItems(Items.DIAMOND)),
    DIAMOND_HIGHLAND("diamond_highland", 34, new int[]{3, 8, 7, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F, 0.1F, () -> Ingredient.ofItems(Items.DIAMOND)),
    DIAMOND_PLATE("diamond_plate", 37, new int[]{4, 9, 7, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F, 0.5F, () -> Ingredient.ofItems(Items.DIAMOND)),
    DIAMOND_ROYAL("diamond_royal", 30, new int[]{2, 8, 6, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.ofItems(Items.DIAMOND)),
    DIAMOND_WOOLEN("diamond_woolen", 30, new int[]{2, 7, 5, 2}, 11, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.1F, () -> Ingredient.ofItems(Items.DIAMOND)),
    WHITE_NETHERITE("white_netherite", 39, new int[]{4, 9, 7, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5F, 0.1F, () -> Ingredient.ofItems(TeadItems.WHITE_NETHERITE_INGOT)),
    WHITE_NETHERITE_REINFORCED_MAIL("white_netherite_reinforced_mail", 41, new int[]{5, 10, 8, 4}, 16, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 6.5F, 0.2F, () -> Ingredient.ofItems(TeadItems.WHITE_NETHERITE_INGOT)),
    WHITE_NETHERITE_GHOSTLY("white_netherite_ghostly", 41, new int[]{4, 9, 7, 3}, 22, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.5F, 0.1F, () -> Ingredient.ofItems(TeadItems.WHITE_NETHERITE_INGOT)),
    WHITE_NETHERITE_STALWART("white_netherite_stalwart", 41, new int[]{6, 11, 9, 5}, 16, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5F, 0.3F, () -> Ingredient.ofItems(TeadItems.WHITE_NETHERITE_INGOT)),
    WHITE_NETHERITE_CHAIN("white_netherite_chain", 39, new int[]{3, 8, 6, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5F, 0.1F, () -> Ingredient.ofItems(TeadItems.WHITE_NETHERITE_INGOT)),
    WHITE_NETHERITE_SPANGENHELM("white_netherite_spangenhelm", 41, new int[]{6, 10, 8, 5}, 19, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.5F, 0.1F, () -> Ingredient.ofItems(TeadItems.WHITE_NETHERITE_INGOT)),
    WHITE_NETHERITE_MERCENARY("white_netherite_mercenary", 42, new int[]{5, 10, 8, 4}, 17, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5F, 0.4F, () -> Ingredient.ofItems(TeadItems.WHITE_NETHERITE_INGOT)),
    WHITE_NETHERITE_THIEF("white_netherite_thief", 37, new int[]{4, 8, 7, 3}, 19, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 5.5F, 0.1F, () -> Ingredient.ofItems(TeadItems.WHITE_NETHERITE_INGOT)),
    WHITE_NETHERITE_GUARD("white_netherite_guard", 38, new int[]{4, 10, 7, 3}, 19, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 6.5F, 0.2F, () -> Ingredient.ofItems(TeadItems.WHITE_NETHERITE_INGOT)),
    WHITE_NETHERITE_HIGHLAND("white_netherite_highland", 40, new int[]{4, 9, 8, 3}, 18, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.5F, 0.2F, () -> Ingredient.ofItems(TeadItems.WHITE_NETHERITE_INGOT)),
    WHITE_NETHERITE_PLATE("white_netherite_plate", 43, new int[]{5, 10, 8, 4}, 16, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.5F, 0.6F, () -> Ingredient.ofItems(TeadItems.WHITE_NETHERITE_INGOT)),
    WHITE_NETHERITE_ROYAL("white_netherite_royal", 36, new int[]{3, 9, 7, 3}, 21, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5F, 0.1F, () -> Ingredient.ofItems(TeadItems.WHITE_NETHERITE_INGOT)),
    WHITE_NETHERITE_WOOLEN("white_netherite_woolen", 36, new int[]{3, 8, 6, 2}, 17, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5F, 0.2F, () -> Ingredient.ofItems(TeadItems.WHITE_NETHERITE_INGOT)),
    WHITE_GOLD("white_gold", 13, new int[]{2, 6, 4, 2}, 18, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.WHITE_GOLD_INGOT)),
    WHITE_GOLD_REINFORCED_MAIL("white_gold_reinforced_mail", 15, new int[]{3, 7, 5, 3}, 18, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.WHITE_GOLD_INGOT)),
    WHITE_GOLD_GHOSTLY("white_gold_ghostly", 15, new int[]{2, 6, 4, 2}, 24, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.WHITE_GOLD_INGOT)),
    WHITE_GOLD_STALWART("white_gold_stalwart", 15, new int[]{4, 8, 6, 4}, 18, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.2F, () -> Ingredient.ofItems(TeadItems.WHITE_GOLD_INGOT)),
    WHITE_GOLD_CHAIN("white_gold_chain", 13, new int[]{1, 5, 3, 2}, 18, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.WHITE_GOLD_INGOT)),
    WHITE_GOLD_SPANGENHELM("white_gold_spangenhelm", 15, new int[]{4, 7, 5, 4}, 21, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.WHITE_GOLD_INGOT)),
    WHITE_GOLD_MERCENARY("white_gold_mercenary", 16, new int[]{3, 7, 5, 3}, 19, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.3F, () -> Ingredient.ofItems(TeadItems.WHITE_GOLD_INGOT)),
    WHITE_GOLD_THIEF("white_gold_thief", 11, new int[]{2, 5, 4, 2}, 21, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.WHITE_GOLD_INGOT)),
    WHITE_GOLD_GUARD("white_gold_guard", 12, new int[]{2, 7, 4, 2}, 21, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.WHITE_GOLD_INGOT)),
    WHITE_GOLD_HIGHLAND("white_gold_highland", 14, new int[]{2, 6, 5, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.WHITE_GOLD_INGOT)),
    WHITE_GOLD_PLATE("white_gold_plate", 17, new int[]{3, 7, 5, 3}, 18, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F, 0.5F, () -> Ingredient.ofItems(TeadItems.WHITE_GOLD_INGOT)),
    WHITE_GOLD_ROYAL("white_gold_royal", 10, new int[]{1, 6, 4, 2}, 23, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.WHITE_GOLD_INGOT)),
    WHITE_GOLD_WOOLEN("white_gold_woolen", 10, new int[]{1, 5, 3, 1}, 19, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.WHITE_GOLD_INGOT)),
    ROSE_NETHERITE("rose_netherite", 38, new int[]{4, 9, 7, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.ROSE_NETHERITE_INGOT)),
    ROSE_NETHERITE_REINFORCED_MAIL("rose_netherite_reinforced_mail", 40, new int[]{5, 10, 8, 4}, 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 6.0F, 0.2F, () -> Ingredient.ofItems(TeadItems.ROSE_NETHERITE_INGOT)),
    ROSE_NETHERITE_GHOSTLY("rose_netherite_ghostly", 40, new int[]{4, 9, 7, 3}, 26, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.ROSE_NETHERITE_INGOT)),
    ROSE_NETHERITE_STALWART("rose_netherite_stalwart", 40, new int[]{6, 11, 9, 5}, 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.3F, () -> Ingredient.ofItems(TeadItems.ROSE_NETHERITE_INGOT)),
    ROSE_NETHERITE_CHAIN("rose_netherite_chain", 38, new int[]{3, 8, 6, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.ROSE_NETHERITE_INGOT)),
    ROSE_NETHERITE_SPANGENHELM("rose_netherite_spangenhelm", 40, new int[]{6, 10, 8, 5}, 23, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.ROSE_NETHERITE_INGOT)),
    ROSE_NETHERITE_MERCENARY("rose_netherite_mercenary", 41, new int[]{5, 10, 8, 4}, 21, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.4F, () -> Ingredient.ofItems(TeadItems.ROSE_NETHERITE_INGOT)),
    ROSE_NETHERITE_THIEF("rose_netherite_thief", 36, new int[]{4, 8, 7, 3}, 23, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 5.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.ROSE_NETHERITE_INGOT)),
    ROSE_NETHERITE_GUARD("rose_netherite_guard", 37, new int[]{4, 10, 7, 3}, 23, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 6.0F, 0.2F, () -> Ingredient.ofItems(TeadItems.ROSE_NETHERITE_INGOT)),
    ROSE_NETHERITE_HIGHLAND("rose_netherite_highland", 39, new int[]{4, 9, 8, 3}, 22, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.2F, () -> Ingredient.ofItems(TeadItems.ROSE_NETHERITE_INGOT)),
    ROSE_NETHERITE_PLATE("rose_netherite_plate", 42, new int[]{5, 10, 8, 4}, 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.6F, () -> Ingredient.ofItems(TeadItems.ROSE_NETHERITE_INGOT)),
    ROSE_NETHERITE_ROYAL("rose_netherite_royal", 35, new int[]{3, 9, 7, 3}, 25, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.ROSE_NETHERITE_INGOT)),
    ROSE_NETHERITE_WOOLEN("rose_netherite_woolen", 35, new int[]{3, 8, 6, 2}, 21, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.2F, () -> Ingredient.ofItems(TeadItems.ROSE_NETHERITE_INGOT)),
    IRON("iron", 15, new int[]{3, 6, 5, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    IRON_REINFORCED_MAIL("iron_reinforced_mail", 17, new int[]{4, 7, 6, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F, 0.1F, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    IRON_GHOSTLY("iron_ghostly", 17, new int[]{3, 6, 5, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    IRON_STALWART("iron_stalwart", 17, new int[]{5, 8, 7, 4}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.2F, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    IRON_CHAIN("iron_chain", 15, new int[]{2, 5, 4, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    IRON_SPANGENHELM("iron_spangenhelm", 17, new int[]{5, 7, 6, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    IRON_MERCENARY("iron_mercenary", 18, new int[]{4, 7, 6, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.3F, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    IRON_THIEF("iron_thief", 13, new int[]{3, 5, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F, 0.0F, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    IRON_GUARD("iron_guard", 14, new int[]{3, 7, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F, 0.1F, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    IRON_HIGHLAND("iron_highland", 16, new int[]{3, 6, 6, 2}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.1F, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    IRON_PLATE("iron_plate", 19, new int[]{4, 7, 6, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.5F, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    IRON_ROYAL("iron_royal", 12, new int[]{2, 6, 5, 2}, 14, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    IRON_WOOLEN("iron_woolen", 12, new int[]{2, 5, 4, 1}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.1F, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    COPPER("copper", 14, new int[]{2, 6, 5, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    COPPER_REINFORCED_MAIL("copper_reinforced_mail", 16, new int[]{3, 7, 6, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F, 0.1F, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    COPPER_GHOSTLY("copper_ghostly", 16, new int[]{2, 6, 5, 2}, 16, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    COPPER_STALWART("copper_stalwart", 16, new int[]{4, 8, 7, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.2F, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    COPPER_CHAIN("copper_chain", 14, new int[]{1, 5, 4, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    COPPER_SPANGENHELM("copper_spangenhelm", 16, new int[]{4, 7, 6, 4}, 13, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    COPPER_MERCENARY("copper_mercenary", 17, new int[]{3, 7, 6, 3}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.3F, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    COPPER_THIEF("copper_thief", 12, new int[]{2, 5, 5, 2}, 13, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F, 0.0F, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    COPPER_GUARD("copper_guard", 13, new int[]{2, 7, 5, 2}, 13, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F, 0.1F, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    COPPER_HIGHLAND("copper_highland", 15, new int[]{2, 6, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.1F, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    COPPER_PLATE("copper_plate", 18, new int[]{3, 7, 6, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.5F, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    COPPER_ROYAL("copper_royal", 11, new int[]{1, 6, 5, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    COPPER_WOOLEN("copper_woolen", 11, new int[]{1, 5, 4, 1}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.1F, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    ROSE_GOLD("rose_gold", 12, new int[]{2, 5, 4, 2}, 21, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.ROSE_GOLD_INGOT)),
    ROSE_GOLD_REINFORCED_MAIL("rose_gold_reinforced_mail", 14, new int[]{3, 6, 5, 3}, 21, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.ROSE_GOLD_INGOT)),
    ROSE_GOLD_GHOSTLY("rose_gold_ghostly", 14, new int[]{2, 5, 4, 2}, 27, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.ROSE_GOLD_INGOT)),
    ROSE_GOLD_STALWART("rose_gold_stalwart", 14, new int[]{4, 7, 6, 4}, 21, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.2F, () -> Ingredient.ofItems(TeadItems.ROSE_GOLD_INGOT)),
    ROSE_GOLD_CHAIN("rose_gold_chain", 12, new int[]{1, 4, 3, 2}, 21, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.ROSE_GOLD_INGOT)),
    ROSE_GOLD_SPANGENHELM("rose_gold_spangenhelm", 14, new int[]{4, 6, 5, 4}, 24, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.ROSE_GOLD_INGOT)),
    ROSE_GOLD_MERCENARY("rose_gold_mercenary", 15, new int[]{3, 6, 5, 3}, 22, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.3F, () -> Ingredient.ofItems(TeadItems.ROSE_GOLD_INGOT)),
    ROSE_GOLD_THIEF("rose_gold_thief", 10, new int[]{2, 4, 4, 2}, 24, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.ROSE_GOLD_INGOT)),
    ROSE_GOLD_GUARD("rose_gold_guard", 11, new int[]{2, 6, 4, 2}, 24, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.ROSE_GOLD_INGOT)),
    ROSE_GOLD_HIGHLAND("rose_gold_highland", 13, new int[]{2, 5, 5, 2}, 23, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.ROSE_GOLD_INGOT)),
    ROSE_GOLD_PLATE("rose_gold_plate", 16, new int[]{3, 6, 5, 3}, 21, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F, 0.5F, () -> Ingredient.ofItems(TeadItems.ROSE_GOLD_INGOT)),
    ROSE_GOLD_ROYAL("rose_gold_royal", 9, new int[]{1, 5, 4, 2}, 26, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> Ingredient.ofItems(TeadItems.ROSE_GOLD_INGOT)),
    ROSE_GOLD_WOOLEN("rose_gold_woolen", 9, new int[]{1, 4, 3, 1}, 22, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.1F, () -> Ingredient.ofItems(TeadItems.ROSE_GOLD_INGOT));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;
    private static final int[] BASE_DURABILITY = {11, 16, 15, 13};

    TeadArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability,
                          SoundEvent equipSound, float toughness, float knockbackResistance,
                          Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return Tead.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}