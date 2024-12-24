package net.pythonbear.tead.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;

public class TeadEnchantments {
    public static Enchantment COWARDICE = register("cowardice",
            new Cowardice(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.ARMOR_LEGS,
                    new EquipmentSlot[] {EquipmentSlot.LEGS}));
    public static Enchantment RUSH = register("rush",
            new Rush(Enchantment.Rarity.COMMON, EnchantmentTarget.ARMOR_LEGS,
                    new EquipmentSlot[] {EquipmentSlot.LEGS}));
    public static Enchantment FIRE_TRAIL = register("fire_trail",
            new FireTrail(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.ARMOR_FEET,
                    new EquipmentSlot[] {EquipmentSlot.FEET}));
    public static Enchantment END_BUFFER = register("end_buffer",
            new EndBuffer(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON,
                    new EquipmentSlot[] {EquipmentSlot.MAINHAND}));
    public static Enchantment EXPLODING = register("exploding",
            new Exploding(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON,
                    new EquipmentSlot[] {EquipmentSlot.MAINHAND}));
    public static Enchantment SHOCKWAVE = register("shockwave",
            new Shockwave(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON,
                    new EquipmentSlot[] {EquipmentSlot.MAINHAND}));
    public static Enchantment LEECHING = register("leeching",
            new Leeching(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON,
                    new EquipmentSlot[] {EquipmentSlot.MAINHAND}));
    public static Enchantment PAIN_CYCLE = register("pain_cycle",
            new PainCycle(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON,
                    new EquipmentSlot[] {EquipmentSlot.MAINHAND}));
    public static Enchantment THUNDERING = register("thundering",
            new Thundering(Enchantment.Rarity.COMMON, EnchantmentTarget.WEAPON,
                    new EquipmentSlot[] {EquipmentSlot.MAINHAND}));
    public static Enchantment TRANSMORPHING = register("transmorphing",
            new Thundering(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON,
                    new EquipmentSlot[] {EquipmentSlot.MAINHAND}));
    public static Enchantment WEAKENING = register("weakening",
            new Weakening(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON,
                    new EquipmentSlot[] {EquipmentSlot.MAINHAND}));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(Tead.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {Tead.LOGGER.info("Registering mod enchantments for " + Tead.MOD_ID);}
}
