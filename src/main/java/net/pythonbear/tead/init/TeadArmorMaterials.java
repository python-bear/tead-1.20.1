package net.pythonbear.tead.init;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.pythonbear.tead.Tead;

import java.util.function.Supplier;

public enum TeadArmorMaterials implements ArmorMaterial {
    SWIFTNESS("swiftness", 10, new int[] {1, 2, 3, 1}, 4,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0, 0,
            () -> Ingredient.ofItems(Items.LEATHER)),
    ROBE("robe", 5, new int[] {1, 2, 3, 1}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0, 0,
            () -> Ingredient.ofItems(Items.LEATHER)),
    GOLD_STALWART("gold_stalwart", 8, new int[] {1, 3, 5, 2}, 25,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0, 0.5f,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    IRON_STALWART("iron_stalwart", 16, new int[] {2, 5, 6, 2}, 9,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0, 0.5f,
            () -> Ingredient.ofItems(Items.IRON_INGOT)),
    DIAMOND_STALWART("diamond_stalwart", 34, new int[] {3, 6, 8, 3}, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2, 0.6f,
            () -> Ingredient.ofItems(Items.DIAMOND)),
    NETHERITE_STALWART("netherite_stalwart", 38, new int[] {3, 6, 8, 3}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3, 0.7f,
            () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    GOLD_ROYAL("gold_royal", 6, new int[] {1, 3, 5, 2}, 30,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0, 0,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    IRON_ROYAL("iron_royal", 12, new int[] {2, 5, 6, 2}, 14,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0, 0,
            () -> Ingredient.ofItems(Items.IRON_INGOT)),
    DIAMOND_ROYAL("diamond_royal", 31, new int[] {3, 6, 8, 3}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2, 0,
            () -> Ingredient.ofItems(Items.DIAMOND)),
    NETHERITE_ROYAL("netherite_royal", 35, new int[] {3, 6, 8, 3}, 20,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3, 0.1f,
            () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    GOLD_HIGHLAND("gold_highland", 7, new int[] {1, 3, 5, 2}, 26,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1, 0,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    IRON_HIGHLAND("iron_highland", 15, new int[] {2, 5, 6, 2}, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2, 0,
            () -> Ingredient.ofItems(Items.IRON_INGOT)),
    DIAMOND_HIGHLAND("diamond_highland", 33, new int[] {3, 6, 8, 3}, 11,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3, 0,
            () -> Ingredient.ofItems(Items.DIAMOND)),
    NETHERITE_HIGHLAND("netherite_highland", 37, new int[] {3, 6, 8, 3}, 16,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4, 0.1f,
            () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    GOLD_PLATE("gold_plate", 10, new int[] {1, 3, 5, 2}, 25,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1, 0.1f,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    IRON_PLATE("iron_plate", 18, new int[] {2, 5, 6, 2}, 9,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1, 0.1f,
            () -> Ingredient.ofItems(Items.IRON_INGOT)),
    DIAMOND_PLATE("diamond_plate", 36, new int[] {3, 6, 8, 3}, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3, 0.1f,
            () -> Ingredient.ofItems(Items.DIAMOND)),
    NETHERITE_PLATE("netherite_plate", 40, new int[] {3, 6, 8, 3}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4, 0.2f,
            () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    GOLD_CHAIN("gold_chain", 7, new int[] {1, 2, 4, 1}, 25,
    SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0, 0,
            () -> Ingredient.ofItems(TeadBlocks.GOLD_CHAIN));

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
