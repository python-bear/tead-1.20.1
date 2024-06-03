package net.pythonbear.tead.init;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum TeadToolMaterials implements ToolMaterial {
    CORAL(MiningLevels.STONE, 235, 6.2f, 1.5f, 13,
            () -> Ingredient.ofItems(Items.BRAIN_CORAL)),
    BONE(MiningLevels.STONE, 115, 4.2f, 1.7f, 16,
            () -> Ingredient.ofItems(Items.BONE)),
    OBSIDIAN(MiningLevels.DIAMOND, 2045, 8.5f, 3f, 3,
            () -> Ingredient.ofItems(Items.OBSIDIAN)),
    LEAD(MiningLevels.STONE, 200, 5.5f, 2.0f, 0,
            () -> Ingredient.ofItems(TeadItems.LEAD_INGOT)),
    COPPER(MiningLevels.IRON, 235, 5.9f, 1.8f, 14,
            () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    ROSE_GOLD(MiningLevels.IRON, 202, 9.0f, 1.0f, 19,
            () -> Ingredient.ofItems(TeadItems.ROSE_GOLD_INGOT)),
    WHITE_GOLD(MiningLevels.IRON, 232, 9.1f, 1.4f, 18,
            () -> Ingredient.ofItems(TeadItems.WHITE_GOLD_INGOT)),
    BRASS(MiningLevels.IRON, 750, 6f, 1.9f, 14,
            () -> Ingredient.ofItems(TeadItems.BRONZE_INGOT)),
    BRONZE(MiningLevels.DIAMOND, 500, 6f, 2.0f, 7,
            () -> Ingredient.ofItems(TeadItems.BRONZE_INGOT)),
    STEEL(MiningLevels.DIAMOND, 1250, 7.0f, 2.5f, 13,
            () -> Ingredient.ofItems(TeadItems.STEEL_INGOT)),
    RUBY(MiningLevels.DIAMOND, 1222, 7.5f, 3.0f, 7,
            () -> Ingredient.ofItems(TeadItems.RUBY)),
    ROSE_NETHERITE(MiningLevels.NETHERITE, 2371, 11.0f, 4.1f, 17,
            () -> Ingredient.ofItems(TeadItems.ROSE_NETHERITE_INGOT)),
    WHITE_NETHERITE(MiningLevels.NETHERITE, 2431, 12.0f, 4.5f, 16,
            () -> Ingredient.ofItems(TeadItems.WHITE_NETHERITE_INGOT));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    TeadToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability,
                      Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
