package net.pythonbear.tead.item;

import java.util.HashMap;
import java.util.Map;

public class ArmorMaterialConstructors {
    public static final Map<String, MaterialData> BASE_MATERIALS = new HashMap<>();
    public static final Map<String, SubtypeModifier> SUBTYPES = new HashMap<>();

    static {
        BASE_MATERIALS.put("gold", new MaterialData(7, new int[]{2, 5, 3, 1}, 25, 0, 0.0f, "SoundEvents.ITEM_ARMOR_EQUIP_GOLD", "() -> Ingredient.ofItems(Items.GOLD_INGOT)"));
        BASE_MATERIALS.put("iron", new MaterialData(15, new int[]{3, 6, 5, 2}, 9, 0, 0.0f, "SoundEvents.ITEM_ARMOR_EQUIP_IRON", "() -> Ingredient.ofItems(Items.IRON_INGOT)"));
        BASE_MATERIALS.put("diamond", new MaterialData(33, new int[]{3, 8, 6, 3}, 10, 2.0f, 0, "SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND", "() -> Ingredient.ofItems(Items.DIAMOND)"));
        BASE_MATERIALS.put("netherite", new MaterialData(37, new int[]{3, 8, 6, 3}, 15, 3.0f, 0.1f, "SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE", "() -> Ingredient.ofItems(Items.NETHERITE_INGOT)"));

        BASE_MATERIALS.put("lead", new MaterialData(12, new int[]{1, 5, 4, 2}, 0, 0, 0.0f, "SoundEvents.ITEM_ARMOR_EQUIP_IRON", "() -> Ingredient.ofItems(TeadItems.LEAD_INGOT)"));
        BASE_MATERIALS.put("copper", new MaterialData(14, new int[]{2, 6, 5, 2}, 10, 0, 0.0f, "SoundEvents.ITEM_ARMOR_EQUIP_IRON", "() -> Ingredient.ofItems(Items.COPPER_INGOT)"));
        BASE_MATERIALS.put("rose_gold", new MaterialData(12, new int[]{2, 5, 4, 2}, 21, 0, 0.0f, "SoundEvents.ITEM_ARMOR_EQUIP_GOLD", "() -> Ingredient.ofItems(TeadItems.ROSE_GOLD_INGOT)"));
        BASE_MATERIALS.put("white_gold", new MaterialData(13, new int[]{2, 6, 4, 2}, 18, 0, 0.0f, "SoundEvents.ITEM_ARMOR_EQUIP_GOLD", "() -> Ingredient.ofItems(TeadItems.WHITE_GOLD_INGOT)"));
        BASE_MATERIALS.put("brass", new MaterialData(25, new int[]{2, 6, 5, 2}, 10, 0, 0.0f, "SoundEvents.ITEM_ARMOR_EQUIP_IRON", "() -> Ingredient.ofItems(TeadItems.BRASS_INGOT)"));
        BASE_MATERIALS.put("bronze", new MaterialData(19, new int[]{2, 6, 5, 3}, 6, 0, 0.0f, "SoundEvents.ITEM_ARMOR_EQUIP_IRON", "() -> Ingredient.ofItems(TeadItems.BRONZE_INGOT)"));
        BASE_MATERIALS.put("steel", new MaterialData(30, new int[]{3, 7, 6, 3}, 8, 0, 0.0f, "SoundEvents.ITEM_ARMOR_EQUIP_IRON", "() -> Ingredient.ofItems(TeadItems.STEEL_INGOT)"));
        BASE_MATERIALS.put("rose_netherite", new MaterialData(38, new int[]{4, 9, 7, 3}, 20, 3, 0.1f, "SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE", "() -> Ingredient.ofItems(TeadItems.ROSE_NETHERITE_INGOT)"));
        BASE_MATERIALS.put("white_netherite", new MaterialData(39, new int[]{4, 9, 7, 3}, 16, 3.5f, 0.1f, "SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE", "() -> Ingredient.ofItems(TeadItems.WHITE_NETHERITE_INGOT)"));

        SUBTYPES.put("woolen", new SubtypeModifier(-3, new int[]{-1, -1, -1, -1}, 1, 0, 0.1f));
        SUBTYPES.put("chain", new SubtypeModifier(0, new int[]{-1, -1, -1, 0}, 0, 0, 0));
        SUBTYPES.put("thief", new SubtypeModifier(-2, new int[]{0, -1, 0, 0}, 3, 2, 0));
        SUBTYPES.put("royal", new SubtypeModifier(-3, new int[]{-1, 0, 0, 0}, 5, 0, 0));
        SUBTYPES.put("guard", new SubtypeModifier(-1, new int[]{0, 1, 0, 0}, 3, 3, 0.1f));
        SUBTYPES.put("highland", new SubtypeModifier(1, new int[]{0, 0, 1, 0}, 2, 1, 0.1f));
        SUBTYPES.put("reinforced_mail", new SubtypeModifier(2, new int[]{1, 1, 1, 1}, 0, 3, 0.1f));
        SUBTYPES.put("ghostly", new SubtypeModifier(2, new int[]{0, 0, 0, 0}, 6, 1, 0));
        SUBTYPES.put("plate", new SubtypeModifier(4, new int[]{1, 1, 1, 1}, 0, 1, 0.5f));
        SUBTYPES.put("mercenary", new SubtypeModifier(3, new int[]{1, 1, 1, 1}, 1, 0, 0.3f));
        SUBTYPES.put("spangenhelm", new SubtypeModifier(2, new int[]{2, 1, 1, 2}, 3, 1, 0));
        SUBTYPES.put("stalwart", new SubtypeModifier(2, new int[]{2, 2, 2, 2}, 0, 0, 0.2f));
    }

    public record MaterialData(int durabilityMultiplier, int[] protection, int enchantability,
                               float toughness, float knockbackResistance, String equipSound,
                               String repairIngredient) {}

    public record SubtypeModifier(int durabilityBonus, int[] protectionBonus, int enchantabilityBonus,
                                  float toughnessBonus, float knockbackResistanceBonus) {}
}
