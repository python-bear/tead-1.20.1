package net.pythonbear.tead.init;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum TeadToolMaterials implements ToolMaterial {
    LEAD(MiningLevels.STONE, 200, 5.5f, 2.0f, 19,
            () -> Ingredient.ofItems(TeadItems.LEAD_INGOT)),
    COPPER(MiningLevels.IRON, 235, 5.9f, 2.0f, 16,
            () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    CORAL(MiningLevels.STONE, 235, 6.5f, 2.0f, 13,
            () -> Ingredient.ofItems(Items.BRAIN_CORAL)),
    BONE(MiningLevels.STONE, 115, 4.2f, 2.0f, 5,
            () -> Ingredient.ofItems(Items.BONE)),
    OBSIDIAN(MiningLevels.NETHERITE, 2031, 13.0f, 4.0f, 3,
            () -> Ingredient.ofItems(Items.OBSIDIAN));

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
