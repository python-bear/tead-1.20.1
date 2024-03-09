package net.pythonbear.tead.init;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.pythonbear.tead.Tead;

import java.util.function.Supplier;

public enum TeadArmorMaterials implements ArmorMaterial {
    SWIFTNESS("swiftness", 10, new int[] {1, 3, 2, 1}, 17,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0, 0,
            () -> Ingredient.ofItems(Items.LEATHER)),
    ROBE("robe", 5, new int[] {1, 3, 2, 1}, 16,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0, 0,
            () -> Ingredient.ofItems(Items.LEATHER)),
    GOLD("gold", 7, new int[] {2, 5, 3, 1}, 25,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0, 0,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_STALWART("gold_stalwart", 9, new int[] {4, 7, 5, 3}, 25,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0, 0.2f,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_ROYAL("gold_royal", 4, new int[] {1, 5, 3, 1}, 30,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0, 0,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_HIGHLAND("gold_highland", 8, new int[] {2, 5, 3, 1}, 26,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3, 0.1f,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_SPANGENHELM("gold_spangenhelm", 9, new int[] {4, 6, 4, 3}, 28,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1, 0,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_PLATE("gold_plate", 7, new int[] {2, 5, 3, 1}, 25,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0, 0,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_MERCENARY("gold_mercenary", 11, new int[] {3, 6, 4, 2}, 25,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2, 0.5f,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_GHOSTLY("gold_ghostly", 9, new int[] {2, 5, 3, 1}, 31,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1, 0,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_GUARD("gold_guard", 6, new int[] {2, 6, 3, 1}, 28,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 4, 0.1f,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_GARMENT("gold_garment", 3, new int[] {1, 3, 1, 1}, 25,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0, 0,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_WOOLEN("gold_woolen", 4, new int[] {1, 4, 2, 1}, 26,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0, 0,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_THIEF("gold_thief", 5, new int[] {2, 5, 3, 1}, 28,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 4, 0,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_CHAIN("gold_chain", 7, new int[] {1, 4, 2, 1}, 25,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0, 0,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD_REINFORCED_MAIL("gold_reinforced_mail", 9, new int[] {3, 6, 4, 2}, 25,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 5, 0.1f,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    COPPER("copper", 14, new int[] {2, 6, 5, 2}, 9,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0, 0,
            () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    COPPER_STALWART("copper_stalwart", 16, new int[] {3, 7, 6, 3}, 9,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0, 0.3f,
            () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    IRON_STALWART("iron_stalwart", 17, new int[] {3, 7, 6, 3}, 9,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0, 0.3f,
            () -> Ingredient.ofItems(Items.IRON_INGOT)),
    DIAMOND_STALWART("diamond_stalwart", 35, new int[] {4, 9, 7, 4}, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2, 0.3f,
            () -> Ingredient.ofItems(Items.DIAMOND)),
    NETHERITE_STALWART("netherite_stalwart", 39, new int[] {4, 9, 7, 4}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3, 0.4f,
            () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    COPPER_ROYAL("copper_royal", 11, new int[] {2, 6, 5, 2}, 14,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0, 0,
            () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    IRON_ROYAL("iron_royal", 12, new int[] {2, 6, 5, 2}, 14,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0, 0f,
            () -> Ingredient.ofItems(Items.IRON_INGOT)),
    DIAMOND_ROYAL("diamond_royal", 30, new int[] {3, 8, 6, 3}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2, 0,
            () -> Ingredient.ofItems(Items.DIAMOND)),
    NETHERITE_ROYAL("netherite_royal", 34, new int[] {3, 8, 6, 3}, 20,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3, 0.1f,
            () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    COPPER_HIGHLAND("copper_highland", 14, new int[] {2, 6, 5, 2}, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3, 0.1f,
            () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    IRON_HIGHLAND("iron_highland", 15, new int[] {2, 6, 5, 2}, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3, 0.1f,
            () -> Ingredient.ofItems(Items.IRON_INGOT)),
    DIAMOND_HIGHLAND("diamond_highland", 33, new int[] {3, 8, 6, 3}, 11,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5, 0.1f,
            () -> Ingredient.ofItems(Items.DIAMOND)),
    NETHERITE_HIGHLAND("netherite_highland", 37, new int[] {3, 8, 6, 3}, 16,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 6, 0.2f,
            () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    COPPER_PLATE("copper_plate", 18, new int[] {2, 6, 5, 2}, 9,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2, 0.5f,
            () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    IRON_PLATE("iron_plate", 19, new int[] {2, 6, 5, 2}, 9,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2, 0.5f,
            () -> Ingredient.ofItems(Items.IRON_INGOT)),
    DIAMOND_PLATE("diamond_plate", 37, new int[] {3, 8, 6, 3}, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4, 0.5f,
            () -> Ingredient.ofItems(Items.DIAMOND)),
    NETHERITE_PLATE("netherite_plate", 41, new int[] {3, 8, 6, 3}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 5, 0.6f,
            () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    STEEL_CHAIN("steel_chain", 7, new int[] {1, 4, 2, 1}, 25,
    SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0, 0,
            () -> Ingredient.ofItems(TeadBlocks.GOLD_CHAIN)),
    ROSE_GOLD_CHAIN("rose_gold_chain", 7, new int[] {1, 4, 2, 1}, 25,
    SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0, 0,
            () -> Ingredient.ofItems(TeadBlocks.GOLD_CHAIN)),
    BRONZE_CHAIN("bronze_chain", 7, new int[] {1, 4, 2, 1}, 25,
    SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0, 0,
            () -> Ingredient.ofItems(TeadBlocks.GOLD_CHAIN)),
    COPPER_CHAIN("copper_chain", 14, new int[] {1, 5, 4, 2}, 9,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0, 0,
            () -> Ingredient.ofItems(TeadBlocks.COPPER_CHAIN));

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
