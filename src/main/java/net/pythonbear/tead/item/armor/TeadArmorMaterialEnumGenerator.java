package net.pythonbear.tead.item.armor;


public class TeadArmorMaterialEnumGenerator {
    public static void generateTeadArmorMaterials() {
        ArmorMaterialConstructors.BASE_MATERIALS.forEach((baseName, baseData) -> {
            System.out.printf(
                    "%s(\"%s\", %d, new int[]{%d, %d, %d, %d}, %d, %s, %.1fF, %.1fF, %s),%n",
                    baseName.toUpperCase(),
                    baseName,
                    baseData.durabilityMultiplier(),
                    baseData.protection()[0],
                    baseData.protection()[1],
                    baseData.protection()[2],
                    baseData.protection()[3],
                    baseData.enchantability(),
                    baseData.equipSound(),
                    baseData.toughness(),
                    baseData.knockbackResistance(),
                    baseData.repairIngredient()
            );

            ArmorMaterialConstructors.SUBTYPES.forEach((subtypeName, subtypeData) -> {
                String name = baseName + "_" + subtypeName;
                int durabilityMultiplier = baseData.durabilityMultiplier() + subtypeData.durabilityBonus();
                int[] protectionAmounts = new int[4];
                for (int i = 0; i < 4; i++) {
                    protectionAmounts[i] = baseData.protection()[i] + subtypeData.protectionBonus()[i];
                }
                int enchantability = baseData.enchantability() + subtypeData.enchantabilityBonus();
                float toughness = baseData.toughness() + subtypeData.toughnessBonus();
                float knockbackResistance = baseData.knockbackResistance() + subtypeData.knockbackResistanceBonus();
                String equipSound = baseData.equipSound();
                String repairIngredient = baseData.repairIngredient();

                System.out.printf(
                        "%s(\"%s\", %d, new int[]{%d, %d, %d, %d}, %d, %s, %.1fF, %.1fF, %s),%n",
                        name.toUpperCase(),
                        name,
                        durabilityMultiplier,
                        protectionAmounts[0],
                        protectionAmounts[1],
                        protectionAmounts[2],
                        protectionAmounts[3],
                        enchantability,
                        equipSound,
                        toughness,
                        knockbackResistance,
                        repairIngredient
                );
            });
        });
    }
}
