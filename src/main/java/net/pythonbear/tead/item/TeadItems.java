package net.pythonbear.tead.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.item.arrow.*;

public class TeadItems {
    // Custom Smithing Guides
    public static final Item SMITHING_GUIDE_STURDY = registerItem("smithing_guide_sturdy",
            new Item(new FabricItemSettings()));
    public static final Item SMITHING_GUIDE_SPOOKY = registerItem("smithing_guide_spooky",
            new Item(new FabricItemSettings()));
    public static final Item SMITHING_GUIDE_GLAIVE = registerItem("smithing_guide_glaive",
            new Item(new FabricItemSettings()));
    public static final Item SMITHING_GUIDE_HIGHLAND = registerItem("smithing_guide_highland",
            new Item(new FabricItemSettings()));
    public static final Item SMITHING_GUIDE_HOLLOW_DAGGER = registerItem("smithing_guide_hollow_dagger",
            new Item(new FabricItemSettings()));
    public static final Item SMITHING_GUIDE_MOUNTAINEER_PICK = registerItem("smithing_guide_mountaineer_pick",
            new Item(new FabricItemSettings()));
    public static final Item SMITHING_GUIDE_RANSEUR = registerItem("smithing_guide_ranseur",
            new Item(new FabricItemSettings()));
    public static final Item SMITHING_GUIDE_RAPIER = registerItem("smithing_guide_rapier",
            new Item(new FabricItemSettings()));
    public static final Item SMITHING_GUIDE_RITE_DAGGER = registerItem("smithing_guide_rite_dagger",
            new Item(new FabricItemSettings()));
    public static final Item SMITHING_GUIDE_TEMPEST = registerItem("smithing_guide_tempest",
            new Item(new FabricItemSettings()));
    public static final Item SMITHING_GUIDE_TRUTHSEEKER = registerItem("smithing_guide_truthseeker",
            new Item(new FabricItemSettings()));
    public static final Item SMITHING_GUIDE_MERCENARY = registerItem("smithing_guide_mercenary",
            new Item(new FabricItemSettings()));
    public static final Item SMITHING_GUIDE_KATANA = registerItem("smithing_guide_katana",
            new Item(new FabricItemSettings()));

    // Misc Items
    public static final Item FABRIC = registerItem("fabric", new Item(new FabricItemSettings()));
    public static final Item ROCK = registerItem("rock", new Item(new FabricItemSettings()));
    public static final Item SLATE = registerItem("slate", new Item(new FabricItemSettings()));
    public static final Item BLACK_ROCK = registerItem("black_rock", new Item(new FabricItemSettings()));
    public static final Item MUDDY_CLAY_BALL = registerItem("muddy_clay_ball",
            new Item(new FabricItemSettings()));
    public static final Item DARK_BRICK = registerItem("dark_brick", new Item(new FabricItemSettings()));
    public static final Item ROUGH_DIAMOND = registerItem("rough_diamond", new Item(new FabricItemSettings()));
    public static final Item ROUGH_RUBY = registerItem("rough_ruby", new Item(new FabricItemSettings()));
    public static final Item DIAMOND_CHIP = registerItem("diamond_chip", new Item(new FabricItemSettings()));
    public static final Item OBSIDIAN_SHARD = registerItem("obsidian_shard", new Item(new FabricItemSettings()));
    public static final Item OBSIDIAN_INGOT = registerItem("obsidian_ingot", new Item(new FabricItemSettings()));
    public static final Item PIG_IRON_INGOT = registerItem("pig_iron_ingot", new Item(new FabricItemSettings()));
    public static final Item PIG_IRON_NUGGET = registerItem("pig_iron_nugget", new Item(new FabricItemSettings()));
    public static final Item GALENA = registerItem("galena", new Item(new FabricItemSettings()));
    public static final Item LEAD_INGOT = registerItem("lead_ingot", new Item(new FabricItemSettings()));
    public static final Item LEAD_NUGGET = registerItem("lead_nugget", new Item(new FabricItemSettings()));
    public static final Item COPPER_NUGGET = registerItem("copper_nugget", new Item(new FabricItemSettings()));
    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot", new Item(new FabricItemSettings()));
    public static final Item ROSE_GOLD_NUGGET = registerItem("rose_gold_nugget", new Item(new FabricItemSettings()));
    public static final Item WHITE_GOLD_INGOT = registerItem("white_gold_ingot", new Item(new FabricItemSettings()));
    public static final Item WHITE_GOLD_NUGGET = registerItem("white_gold_nugget", new Item(new FabricItemSettings()));
    public static final Item BRASS_INGOT = registerItem("brass_ingot", new Item(new FabricItemSettings()));
    public static final Item BRASS_NUGGET = registerItem("brass_nugget", new Item(new FabricItemSettings()));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot", new Item(new FabricItemSettings()));
    public static final Item BRONZE_NUGGET = registerItem("bronze_nugget", new Item(new FabricItemSettings()));
    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new FabricItemSettings()));
    public static final Item STEEL_NUGGET = registerItem("steel_nugget", new Item(new FabricItemSettings()));
    public static final Item NETHERITE_NUGGET = registerItem("netherite_nugget", new Item(new FabricItemSettings().fireproof()));
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RUBY_INGOT = registerItem("ruby_ingot",
            new RubyIngotItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item ROSE_NETHERITE_INGOT = registerItem("rose_netherite_ingot",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item ROSE_NETHERITE_NUGGET = registerItem("rose_netherite_nugget", new Item(new FabricItemSettings().fireproof()));
    public static final Item WHITE_NETHERITE_INGOT = registerItem("white_netherite_ingot",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item WHITE_NETHERITE_NUGGET = registerItem("white_netherite_nugget", new Item(new FabricItemSettings().fireproof()));
    public static final Item BUFFERED_PEARL = registerItem("buffered_pearl",
            new BufferedPearl(new FabricItemSettings().maxCount(16)));
    public static final Item GRAVITY_PEARL = registerItem("gravity_pearl",
            new GravityPearl(new FabricItemSettings()));
    public static final Item TRANSMUTATION_GRIMOIRE = registerItem("transmutation_grimoire",
            new GlintedItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item HANDLE = registerItem("handle", new Item(new FabricItemSettings()));
    public static final Item GRENADE_ENTITY = registerItem("entity_grenade", new Item(new FabricItemSettings()));
    public static final Item GRENADE = registerItem("grenade", new GrenadeItem(new FabricItemSettings()));
    public static final Item SHURIKEN = registerItem("shuriken", new ShurikenItem(new FabricItemSettings()));
    public static final Item LIGHTNING_STAFF = registerItem("lightning_staff",
            new LightningStaffItem(new FabricItemSettings().maxCount(1).maxDamage(64).rarity(Rarity.EPIC).fireproof()));
    public static final Item FRIGID_HILT = registerItem("frigid_hilt",
            new Item(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item FROST_CLAYMORE = registerItem("frost_claymore",
            new FrostClaymoreItem(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item GRAVITY_HAMMER = registerItem("gravity_hammer",
            new GravityHammerItem(new Item.Settings().fireproof().rarity(Rarity.UNCOMMON)));
    public static final Item SINISTER_SWORD = registerItem("sinister_sword",
            new SinisterSwordItem(TeadToolMaterials.WHITE_NETHERITE, 3, -2.4f,
                    new Item.Settings().fireproof().rarity(Rarity.EPIC)));
    public static final Item SOUL = registerItem("soul", new Item(new Item.Settings()));
    public static final Item SOUL_BOTTLE = registerItem("soul_bottle", new Item(new Item.Settings().rarity(Rarity.UNCOMMON)));
    public static final Item EXCALIBUR = registerItem("excalibur",
            new ExcaliburItem(TeadToolMaterials.STEEL, new Item.Settings().fireproof().rarity(Rarity.EPIC).maxDamage(0)));
    public static final Item EXCALIBUR_TOTEM = registerItem("excalibur_totem",
            new ExcaliburTotemItem(new Item.Settings().fireproof().rarity(Rarity.UNCOMMON).maxDamage(0)));
    public static final Item OBSIDIAN_BLADE = registerItem("obsidian_blade",
            new BroadswordItem(TeadToolMaterials.OBSIDIAN, new FabricItemSettings()));
    public static final Item STARLESS_NIGHT = registerItem("starless_night",
            new StarlessNightItem(TeadToolMaterials.OBSIDIAN, new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item CORAL_DAGGER = registerItem("coral_dagger",
            new DaggerItem(TeadToolMaterials.CORAL, new FabricItemSettings()));

    // Food And Consumables
    public static final Item JERKY = registerItem("jerky", new Item(new FabricItemSettings()
            .food(TeadFoodComponents.JERKY)));
    public static final Item WHITE_GOLD_POTATO = registerItem("white_gold_potato", new Item(new FabricItemSettings()
            .food(TeadFoodComponents.WHITE_GOLD_POTATO).rarity(Rarity.UNCOMMON)));
    public static final Item ROSE_GOLD_BEETROOT = registerItem("rose_gold_beetroot", new Item(new FabricItemSettings()
            .food(TeadFoodComponents.ROSE_GOLD_BEETROOT).rarity(Rarity.UNCOMMON)));
    public static final Item LEAD_APPLE = registerItem("lead_apple", new Item(new FabricItemSettings()
            .food(TeadFoodComponents.LEAD_APPLE).rarity(Rarity.UNCOMMON)));

    // Staffs
    public static final Item BATTLE_STAFF = registerItem("battle_staff",
            new StaffItem(ToolMaterials.WOOD, 4.5f, -1.8f, 1, 0.9f,
                    new FabricItemSettings()));
    public static final Item BONE_CLUB = registerItem("bone_club",
            new StaffItem(TeadToolMaterials.BONE, 1.8f, -2.4f, 1.3f,
                    0.5f, new FabricItemSettings()));
    public static final Item QUARTERSTAFF = registerItem("quarterstaff",
            new StaffItem(ToolMaterials.WOOD, 3, -1.9f, 0.7f, 0.7f,
                    new FabricItemSettings()));

    // Wood Tools
    public static final Item WOOD_HATCHET = registerHatchetItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_HAMMER = registerHammerItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_MACE = registerMaceItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_DAGGER = registerDaggerItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_HOLLOW_DAGGER = registerHollowDaggerItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_RITE_DAGGER = registerRiteDaggerItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_CRESCENT_DAGGER = registerCrescentDaggerItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_TRUTHSEEKER = registerTruthseekerItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_TEMPEST_KNIFE = registerTempestKnifeItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_CUTLASS = registerCutlassItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_RAPIER = registerRapierItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_KATANA = registerKatanaItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_HIGHLAND_AXE = registerHighlandAxeItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_DOUBLE_AXE = registerDoubleAxeItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_DOUBLE_HIGHLAND_AXE = registerDoubleHighlandAxeItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_SICKLE = registerSickleItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_SCYTHE = registerScytheItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_GREATSWORD = registerGreatswordItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_LONGSWORD = registerLongswordItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_BROADSWORD = registerBroadswordItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_CLAYMORE = registerClaymoreItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_SPEAR = registerSpearItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_RANSEUR = registerRanseurItem(ToolMaterials.WOOD, "wood");
    public static final Item WOOD_GLAIVE = registerGlaiveItem(ToolMaterials.WOOD, "wood");

    // Stone Tools
    public static final Item STONE_HATCHET = registerHatchetItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_HAMMER = registerHammerItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_MATTOCK = registerMattockItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_MACE = registerMaceItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_DAGGER = registerDaggerItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_HOLLOW_DAGGER = registerHollowDaggerItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_RITE_DAGGER = registerRiteDaggerItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_CRESCENT_DAGGER = registerCrescentDaggerItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_TRUTHSEEKER = registerTruthseekerItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_TEMPEST_KNIFE = registerTempestKnifeItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_CUTLASS = registerCutlassItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_RAPIER = registerRapierItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_KATANA = registerKatanaItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_HIGHLAND_AXE = registerHighlandAxeItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_DOUBLE_AXE = registerDoubleAxeItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_DOUBLE_HIGHLAND_AXE = registerDoubleHighlandAxeItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_SICKLE = registerSickleItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_SCYTHE = registerScytheItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_GREATSWORD = registerGreatswordItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_LONGSWORD = registerLongswordItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_BROADSWORD = registerBroadswordItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_CLAYMORE = registerClaymoreItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_SPEAR = registerSpearItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_RANSEUR = registerRanseurItem(ToolMaterials.STONE, "stone");
    public static final Item STONE_GLAIVE = registerGlaiveItem(ToolMaterials.STONE, "stone");

    // Gold Tools
    public static final Item GOLD_HATCHET = registerHatchetItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_HAMMER = registerHammerItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_MOUNTAINEER_PICK = registerMountaineerPickItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_MATTOCK = registerMattockItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_MACE = registerMaceItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_DAGGER = registerDaggerItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_HOLLOW_DAGGER = registerHollowDaggerItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_RITE_DAGGER = registerRiteDaggerItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_CRESCENT_DAGGER = registerCrescentDaggerItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_TRUTHSEEKER = registerTruthseekerItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_TEMPEST_KNIFE = registerTempestKnifeItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_CUTLASS = registerCutlassItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_RAPIER = registerRapierItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_KATANA = registerKatanaItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_HIGHLAND_AXE = registerHighlandAxeItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_DOUBLE_AXE = registerDoubleAxeItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_DOUBLE_HIGHLAND_AXE = registerDoubleHighlandAxeItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_SICKLE = registerSickleItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_SCYTHE = registerScytheItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_GREATSWORD = registerGreatswordItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_LONGSWORD = registerLongswordItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_BROADSWORD = registerBroadswordItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_CLAYMORE = registerClaymoreItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_SPEAR = registerSpearItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_RANSEUR = registerRanseurItem(ToolMaterials.GOLD, "gold");
    public static final Item GOLD_GLAIVE = registerGlaiveItem(ToolMaterials.GOLD, "gold");

    // Lead Tools
    public static final Item LEAD_SHOVEL = registerShovelItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_HOE = registerHoeItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_AXE = registerAxeItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_PICKAXE = registerPickaxeItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_SWORD = registerSwordItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_HATCHET = registerHatchetItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_HAMMER = registerHammerItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_MOUNTAINEER_PICK = registerMountaineerPickItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_MATTOCK = registerMattockItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_MACE = registerMaceItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_DAGGER = registerDaggerItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_HOLLOW_DAGGER = registerHollowDaggerItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_RITE_DAGGER = registerRiteDaggerItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_CRESCENT_DAGGER = registerCrescentDaggerItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_TRUTHSEEKER = registerTruthseekerItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_TEMPEST_KNIFE = registerTempestKnifeItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_CUTLASS = registerCutlassItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_RAPIER = registerRapierItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_KATANA = registerKatanaItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_HIGHLAND_AXE = registerHighlandAxeItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_DOUBLE_AXE = registerDoubleAxeItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_DOUBLE_HIGHLAND_AXE = registerDoubleHighlandAxeItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_SICKLE = registerSickleItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_SCYTHE = registerScytheItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_GREATSWORD = registerGreatswordItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_LONGSWORD = registerLongswordItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_BROADSWORD = registerBroadswordItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_CLAYMORE = registerClaymoreItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_SPEAR = registerSpearItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_RANSEUR = registerRanseurItem(TeadToolMaterials.LEAD, "lead");
    public static final Item LEAD_GLAIVE = registerGlaiveItem(TeadToolMaterials.LEAD, "lead");

    // Copper Tools
    public static final Item COPPER_SHOVEL = registerShovelItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_HOE = registerHoeItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_AXE = registerAxeItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_PICKAXE = registerPickaxeItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_SWORD = registerSwordItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_HATCHET = registerHatchetItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_HAMMER = registerHammerItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_MOUNTAINEER_PICK = registerMountaineerPickItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_MATTOCK = registerMattockItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_MACE = registerMaceItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_DAGGER = registerDaggerItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_HOLLOW_DAGGER = registerHollowDaggerItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_RITE_DAGGER = registerRiteDaggerItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_CRESCENT_DAGGER = registerCrescentDaggerItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_TRUTHSEEKER = registerTruthseekerItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_TEMPEST_KNIFE = registerTempestKnifeItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_CUTLASS = registerCutlassItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_RAPIER = registerRapierItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_KATANA = registerKatanaItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_HIGHLAND_AXE = registerHighlandAxeItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_DOUBLE_AXE = registerDoubleAxeItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_DOUBLE_HIGHLAND_AXE = registerDoubleHighlandAxeItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_SICKLE = registerSickleItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_SCYTHE = registerScytheItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_GREATSWORD = registerGreatswordItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_LONGSWORD = registerLongswordItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_BROADSWORD = registerBroadswordItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_CLAYMORE = registerClaymoreItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_SPEAR = registerSpearItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_RANSEUR = registerRanseurItem(TeadToolMaterials.COPPER, "copper");
    public static final Item COPPER_GLAIVE = registerGlaiveItem(TeadToolMaterials.COPPER, "copper");

    // Rose Gold Tools
    public static final Item ROSE_GOLD_SHOVEL = registerShovelItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_HOE = registerHoeItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_AXE = registerAxeItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_PICKAXE = registerPickaxeItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_SWORD = registerSwordItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_HATCHET = registerHatchetItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_HAMMER = registerHammerItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_MOUNTAINEER_PICK = registerMountaineerPickItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_MATTOCK = registerMattockItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_MACE = registerMaceItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_DAGGER = registerDaggerItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_HOLLOW_DAGGER = registerHollowDaggerItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_RITE_DAGGER = registerRiteDaggerItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_CRESCENT_DAGGER = registerCrescentDaggerItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_TRUTHSEEKER = registerTruthseekerItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_TEMPEST_KNIFE = registerTempestKnifeItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_CUTLASS = registerCutlassItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_RAPIER = registerRapierItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_KATANA = registerKatanaItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_HIGHLAND_AXE = registerHighlandAxeItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_DOUBLE_AXE = registerDoubleAxeItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_DOUBLE_HIGHLAND_AXE = registerDoubleHighlandAxeItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_SICKLE = registerSickleItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_SCYTHE = registerScytheItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_GREATSWORD = registerGreatswordItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_LONGSWORD = registerLongswordItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_BROADSWORD = registerBroadswordItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_CLAYMORE = registerClaymoreItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_SPEAR = registerSpearItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_RANSEUR = registerRanseurItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");
    public static final Item ROSE_GOLD_GLAIVE = registerGlaiveItem(TeadToolMaterials.ROSE_GOLD, "rose_gold");

    // White Gold Tools
    public static final Item WHITE_GOLD_SHOVEL = registerShovelItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_HOE = registerHoeItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_AXE = registerAxeItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_PICKAXE = registerPickaxeItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_SWORD = registerSwordItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_HATCHET = registerHatchetItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_HAMMER = registerHammerItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_MOUNTAINEER_PICK = registerMountaineerPickItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_MATTOCK = registerMattockItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_MACE = registerMaceItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_DAGGER = registerDaggerItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_HOLLOW_DAGGER = registerHollowDaggerItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_RITE_DAGGER = registerRiteDaggerItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_CRESCENT_DAGGER = registerCrescentDaggerItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_TRUTHSEEKER = registerTruthseekerItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_TEMPEST_KNIFE = registerTempestKnifeItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_CUTLASS = registerCutlassItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_RAPIER = registerRapierItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_KATANA = registerKatanaItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_HIGHLAND_AXE = registerHighlandAxeItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_DOUBLE_AXE = registerDoubleAxeItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_DOUBLE_HIGHLAND_AXE = registerDoubleHighlandAxeItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_SICKLE = registerSickleItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_SCYTHE = registerScytheItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_GREATSWORD = registerGreatswordItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_LONGSWORD = registerLongswordItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_BROADSWORD = registerBroadswordItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_CLAYMORE = registerClaymoreItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_SPEAR = registerSpearItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_RANSEUR = registerRanseurItem(TeadToolMaterials.WHITE_GOLD, "white_gold");
    public static final Item WHITE_GOLD_GLAIVE = registerGlaiveItem(TeadToolMaterials.WHITE_GOLD, "white_gold");

    // Iron Tools
    public static final Item IRON_HATCHET = registerHatchetItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_HAMMER = registerHammerItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_MOUNTAINEER_PICK = registerMountaineerPickItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_MATTOCK = registerMattockItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_MACE = registerMaceItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_DAGGER = registerDaggerItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_HOLLOW_DAGGER = registerHollowDaggerItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_RITE_DAGGER = registerRiteDaggerItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_CRESCENT_DAGGER = registerCrescentDaggerItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_TRUTHSEEKER = registerTruthseekerItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_TEMPEST_KNIFE = registerTempestKnifeItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_CUTLASS = registerCutlassItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_RAPIER = registerRapierItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_KATANA = registerKatanaItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_HIGHLAND_AXE = registerHighlandAxeItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_DOUBLE_AXE = registerDoubleAxeItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_DOUBLE_HIGHLAND_AXE = registerDoubleHighlandAxeItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_SICKLE = registerSickleItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_SCYTHE = registerScytheItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_GREATSWORD = registerGreatswordItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_LONGSWORD = registerLongswordItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_BROADSWORD = registerBroadswordItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_CLAYMORE = registerClaymoreItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_SPEAR = registerSpearItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_RANSEUR = registerRanseurItem(ToolMaterials.IRON, "iron");
    public static final Item IRON_GLAIVE = registerGlaiveItem(ToolMaterials.IRON, "iron");

    // Brass Tools
    public static final Item BRASS_SHOVEL = registerShovelItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_HOE = registerHoeItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_AXE = registerAxeItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_PICKAXE = registerPickaxeItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_SWORD = registerSwordItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_HATCHET = registerHatchetItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_HAMMER = registerHammerItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_MOUNTAINEER_PICK = registerMountaineerPickItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_MATTOCK = registerMattockItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_MACE = registerMaceItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_DAGGER = registerDaggerItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_HOLLOW_DAGGER = registerHollowDaggerItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_RITE_DAGGER = registerRiteDaggerItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_CRESCENT_DAGGER = registerCrescentDaggerItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_TRUTHSEEKER = registerTruthseekerItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_TEMPEST_KNIFE = registerTempestKnifeItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_CUTLASS = registerCutlassItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_RAPIER = registerRapierItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_KATANA = registerKatanaItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_HIGHLAND_AXE = registerHighlandAxeItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_DOUBLE_AXE = registerDoubleAxeItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_DOUBLE_HIGHLAND_AXE = registerDoubleHighlandAxeItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_SICKLE = registerSickleItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_SCYTHE = registerScytheItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_GREATSWORD = registerGreatswordItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_LONGSWORD = registerLongswordItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_BROADSWORD = registerBroadswordItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_CLAYMORE = registerClaymoreItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_SPEAR = registerSpearItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_RANSEUR = registerRanseurItem(TeadToolMaterials.BRASS, "brass");
    public static final Item BRASS_GLAIVE = registerGlaiveItem(TeadToolMaterials.BRASS, "brass");

    // Bronze Tools
    public static final Item BRONZE_SHOVEL = registerShovelItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_HOE = registerHoeItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_AXE = registerAxeItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_PICKAXE = registerPickaxeItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_SWORD = registerSwordItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_HATCHET = registerHatchetItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_HAMMER = registerHammerItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_MOUNTAINEER_PICK = registerMountaineerPickItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_MATTOCK = registerMattockItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_MACE = registerMaceItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_DAGGER = registerDaggerItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_HOLLOW_DAGGER = registerHollowDaggerItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_RITE_DAGGER = registerRiteDaggerItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_CRESCENT_DAGGER = registerCrescentDaggerItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_TRUTHSEEKER = registerTruthseekerItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_TEMPEST_KNIFE = registerTempestKnifeItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_CUTLASS = registerCutlassItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_RAPIER = registerRapierItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_KATANA = registerKatanaItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_HIGHLAND_AXE = registerHighlandAxeItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_DOUBLE_AXE = registerDoubleAxeItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_DOUBLE_HIGHLAND_AXE = registerDoubleHighlandAxeItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_SICKLE = registerSickleItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_SCYTHE = registerScytheItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_GREATSWORD = registerGreatswordItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_LONGSWORD = registerLongswordItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_BROADSWORD = registerBroadswordItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_CLAYMORE = registerClaymoreItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_SPEAR = registerSpearItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_RANSEUR = registerRanseurItem(TeadToolMaterials.BRONZE, "bronze");
    public static final Item BRONZE_GLAIVE = registerGlaiveItem(TeadToolMaterials.BRONZE, "bronze");

    // Steel Tools
    public static final Item STEEL_SHOVEL = registerShovelItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_HOE = registerHoeItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_AXE = registerAxeItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_PICKAXE = registerPickaxeItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_SWORD = registerSwordItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_HATCHET = registerHatchetItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_HAMMER = registerHammerItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_MOUNTAINEER_PICK = registerMountaineerPickItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_MATTOCK = registerMattockItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_MACE = registerMaceItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_DAGGER = registerDaggerItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_HOLLOW_DAGGER = registerHollowDaggerItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_RITE_DAGGER = registerRiteDaggerItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_CRESCENT_DAGGER = registerCrescentDaggerItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_TRUTHSEEKER = registerTruthseekerItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_TEMPEST_KNIFE = registerTempestKnifeItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_CUTLASS = registerCutlassItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_RAPIER = registerRapierItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_KATANA = registerKatanaItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_HIGHLAND_AXE = registerHighlandAxeItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_DOUBLE_AXE = registerDoubleAxeItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_DOUBLE_HIGHLAND_AXE = registerDoubleHighlandAxeItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_SICKLE = registerSickleItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_SCYTHE = registerScytheItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_GREATSWORD = registerGreatswordItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_LONGSWORD = registerLongswordItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_BROADSWORD = registerBroadswordItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_CLAYMORE = registerClaymoreItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_SPEAR = registerSpearItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_RANSEUR = registerRanseurItem(TeadToolMaterials.STEEL, "steel");
    public static final Item STEEL_GLAIVE = registerGlaiveItem(TeadToolMaterials.STEEL, "steel");

    // Diamond Tools
    public static final Item DIAMOND_HATCHET = registerHatchetItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_HAMMER = registerHammerItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_MOUNTAINEER_PICK = registerMountaineerPickItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_MATTOCK = registerMattockItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_MACE = registerMaceItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_DAGGER = registerDaggerItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_HOLLOW_DAGGER = registerHollowDaggerItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_RITE_DAGGER = registerRiteDaggerItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_CRESCENT_DAGGER = registerCrescentDaggerItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_TRUTHSEEKER = registerTruthseekerItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_TEMPEST_KNIFE = registerTempestKnifeItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_CUTLASS = registerCutlassItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_RAPIER = registerRapierItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_KATANA = registerKatanaItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_HIGHLAND_AXE = registerHighlandAxeItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_DOUBLE_AXE = registerDoubleAxeItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_DOUBLE_HIGHLAND_AXE = registerDoubleHighlandAxeItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_SICKLE = registerSickleItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_SCYTHE = registerScytheItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_GREATSWORD = registerGreatswordItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_LONGSWORD = registerLongswordItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_BROADSWORD = registerBroadswordItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_CLAYMORE = registerClaymoreItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_SPEAR = registerSpearItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_RANSEUR = registerRanseurItem(ToolMaterials.DIAMOND, "diamond");
    public static final Item DIAMOND_GLAIVE = registerGlaiveItem(ToolMaterials.DIAMOND, "diamond");

    // Netherite Tools
    public static final Item NETHERITE_HATCHET = registerHatchetItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_HAMMER = registerHammerItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_MOUNTAINEER_PICK = registerMountaineerPickItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_MATTOCK = registerMattockItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_MACE = registerMaceItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_DAGGER = registerDaggerItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_HOLLOW_DAGGER = registerHollowDaggerItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_RITE_DAGGER = registerRiteDaggerItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_CRESCENT_DAGGER = registerCrescentDaggerItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_TRUTHSEEKER = registerTruthseekerItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_TEMPEST_KNIFE = registerTempestKnifeItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_CUTLASS = registerCutlassItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_RAPIER = registerRapierItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_KATANA = registerKatanaItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_HIGHLAND_AXE = registerHighlandAxeItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_DOUBLE_AXE = registerDoubleAxeItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_DOUBLE_HIGHLAND_AXE = registerDoubleHighlandAxeItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_SICKLE = registerSickleItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_SCYTHE = registerScytheItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_GREATSWORD = registerGreatswordItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_LONGSWORD = registerLongswordItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_BROADSWORD = registerBroadswordItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_CLAYMORE = registerClaymoreItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_SPEAR = registerSpearItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_RANSEUR = registerRanseurItem(ToolMaterials.NETHERITE, "netherite");
    public static final Item NETHERITE_GLAIVE = registerGlaiveItem(ToolMaterials.NETHERITE, "netherite");

    // Rose Netherite Tools
    public static final Item ROSE_NETHERITE_SHOVEL = registerShovelItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_HOE = registerHoeItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_AXE = registerAxeItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_PICKAXE = registerPickaxeItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_SWORD = registerSwordItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_HATCHET = registerHatchetItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_HAMMER = registerHammerItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_MOUNTAINEER_PICK = registerMountaineerPickItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_MATTOCK = registerMattockItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_MACE = registerMaceItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_DAGGER = registerDaggerItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_HOLLOW_DAGGER = registerHollowDaggerItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_RITE_DAGGER = registerRiteDaggerItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_CRESCENT_DAGGER = registerCrescentDaggerItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_TRUTHSEEKER = registerTruthseekerItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_TEMPEST_KNIFE = registerTempestKnifeItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_CUTLASS = registerCutlassItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_RAPIER = registerRapierItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_KATANA = registerKatanaItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_HIGHLAND_AXE = registerHighlandAxeItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_DOUBLE_AXE = registerDoubleAxeItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_DOUBLE_HIGHLAND_AXE = registerDoubleHighlandAxeItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_SICKLE = registerSickleItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_SCYTHE = registerScytheItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_GREATSWORD = registerGreatswordItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_LONGSWORD = registerLongswordItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_BROADSWORD = registerBroadswordItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_CLAYMORE = registerClaymoreItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_SPEAR = registerSpearItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_RANSEUR = registerRanseurItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");
    public static final Item ROSE_NETHERITE_GLAIVE = registerGlaiveItem(TeadToolMaterials.ROSE_NETHERITE, "rose_netherite");

    // White Netherite Tools
    public static final Item WHITE_NETHERITE_SHOVEL = registerShovelItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_HOE = registerHoeItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_AXE = registerAxeItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_PICKAXE = registerPickaxeItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_SWORD = registerSwordItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_HATCHET = registerHatchetItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_HAMMER = registerHammerItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_MOUNTAINEER_PICK = registerMountaineerPickItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_MATTOCK = registerMattockItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_MACE = registerMaceItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_DAGGER = registerDaggerItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_HOLLOW_DAGGER = registerHollowDaggerItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_RITE_DAGGER = registerRiteDaggerItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_CRESCENT_DAGGER = registerCrescentDaggerItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_TRUTHSEEKER = registerTruthseekerItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_TEMPEST_KNIFE = registerTempestKnifeItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_CUTLASS = registerCutlassItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_RAPIER = registerRapierItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_KATANA = registerKatanaItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_HIGHLAND_AXE = registerHighlandAxeItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_DOUBLE_AXE = registerDoubleAxeItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_DOUBLE_HIGHLAND_AXE = registerDoubleHighlandAxeItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_SICKLE = registerSickleItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_SCYTHE = registerScytheItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_GREATSWORD = registerGreatswordItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_LONGSWORD = registerLongswordItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_BROADSWORD = registerBroadswordItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_CLAYMORE = registerClaymoreItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_SPEAR = registerSpearItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_RANSEUR = registerRanseurItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");
    public static final Item WHITE_NETHERITE_GLAIVE = registerGlaiveItem(TeadToolMaterials.WHITE_NETHERITE, "white_netherite");

    // Misc Armor
    public static final Item SWIFTNESS_BOOTS = registerItem("swiftness_boots",
            new SwiftnessArmorItem(TeadArmorMaterials.SWIFTNESS, ArmorItem.Type.BOOTS,
                    new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item ROBE_HELMET = registerItem("robe_helmet",
            new RobeArmorItem(TeadArmorMaterials.ROBE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ROBE_CHESTPLATE = registerItem("robe_chestplate",
            new RobeArmorItem(TeadArmorMaterials.ROBE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ROBE_BOOTS = registerItem("robe_boots",
            new RobeArmorItem(TeadArmorMaterials.ROBE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item GARMENT_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.GARMENT);
    public static final Item GARMENT_BOOTS = registerBootsItem(TeadArmorMaterials.GARMENT);

    // Underlay Armor
    public static final Item HIGHLAND_HELMET = registerItem("highland_helmet", new Item(new FabricItemSettings()));
    public static final Item HIGHLAND_CHESTPLATE = registerItem("highland_chestplate", new Item(new FabricItemSettings()));
    public static final Item GUARD_HELMET = registerItem("guard_helmet", new Item(new FabricItemSettings()));
    public static final Item GUARD_CHESTPLATE = registerItem("guard_chestplate", new Item(new FabricItemSettings()));
    public static final Item PLATE_HELMET = registerItem("plate_helmet", new Item(new FabricItemSettings()));
    public static final Item PLATE_CHESTPLATE = registerItem("plate_chestplate", new Item(new FabricItemSettings()));
    public static final Item PLATE_BOOTS = registerItem("plate_boots", new Item(new FabricItemSettings()));
    public static final Item THIEF_HELMET = registerItem("thief_helmet", new Item(new FabricItemSettings()));
    public static final Item THIEF_CHESTPLATE = registerItem("thief_chestplate", new Item(new FabricItemSettings()));
    public static final Item GHOSTLY_HELMET = registerItem("ghostly_helmet", new Item(new FabricItemSettings()));
    public static final Item GHOSTLY_CHESTPLATE = registerItem("ghostly_chestplate", new Item(new FabricItemSettings()));
    public static final Item GHOSTLY_BOOTS = registerItem("ghostly_boots", new Item(new FabricItemSettings()));
    public static final Item WOOLEN_HELMET = registerItem("woolen_helmet", new Item(new FabricItemSettings()));
    public static final Item WOOLEN_CHESTPLATE = registerItem("woolen_chestplate", new Item(new FabricItemSettings()));
    public static final Item WOOLEN_LEGGINGS = registerItem("woolen_leggings", new Item(new FabricItemSettings()));
    public static final Item WOOLEN_BOOTS = registerItem("woolen_boots", new Item(new FabricItemSettings()));

    // Gold Armor
    public static final Item GOLD_CHAINMAIL_HELMET = registerHelmetItem(TeadArmorMaterials.GOLD_CHAIN);
    public static final Item GOLD_CHAINMAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.GOLD_CHAIN);
    public static final Item GOLD_CHAINMAIL_LEGGINGS = registerLeggingsItem(TeadArmorMaterials.GOLD_CHAIN);
    public static final Item GOLD_CHAINMAIL_BOOTS = registerBootsItem(TeadArmorMaterials.GOLD_CHAIN);
    public static final Item GOLD_GHOSTLY_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.GOLD_GHOSTLY);
    public static final Item GOLD_GHOSTLY_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.GOLD_GHOSTLY);
    public static final Item GOLD_GHOSTLY_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.GOLD_GHOSTLY);
    public static final Item GOLD_GUARD_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.GOLD_GUARD);
    public static final Item GOLD_GUARD_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.GOLD_GUARD);
    public static final Item GOLD_HIGHLAND_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.GOLD_HIGHLAND);
    public static final Item GOLD_HIGHLAND_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.GOLD_HIGHLAND);
    public static final Item GOLD_MERCENARY_HELMET = registerHelmetItem(TeadArmorMaterials.GOLD_MERCENARY);
    public static final Item GOLD_PLATE_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.GOLD_PLATE);
    public static final Item GOLD_PLATE_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.GOLD_PLATE);
    public static final Item GOLD_PLATE_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.GOLD_PLATE);
    public static final Item GOLD_REINFORCED_MAIL_HELMET = registerHelmetItem(TeadArmorMaterials.GOLD_REINFORCED_MAIL);
    public static final Item GOLD_REINFORCED_MAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.GOLD_REINFORCED_MAIL);
    public static final Item GOLD_ROYAL_HELMET = registerHelmetItem(TeadArmorMaterials.GOLD_ROYAL);
    public static final Item GOLD_SPANGENHELM_HELMET = registerHelmetItem(TeadArmorMaterials.GOLD_SPANGENHELM);
    public static final Item GOLD_STALWART_HELMET = registerHelmetItem(TeadArmorMaterials.GOLD_STALWART);
    public static final Item GOLD_STALWART_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.GOLD_STALWART);
    public static final Item GOLD_THIEF_HELMET = registerThiefHelmetItem(TeadArmorMaterials.GOLD_THIEF);
    public static final Item GOLD_THIEF_CHESTPLATE = registerThiefChestplateItem(TeadArmorMaterials.GOLD_THIEF);
    public static final Item GOLD_WOOLEN_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.GOLD_WOOLEN);
    public static final Item GOLD_WOOLEN_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.GOLD_WOOLEN);
    public static final Item GOLD_WOOLEN_LEGGINGS = registerDyeableLeggingsItem(TeadArmorMaterials.GOLD_WOOLEN);
    public static final Item GOLD_WOOLEN_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.GOLD_WOOLEN);

    // Lead Armor
    public static final Item LEAD_HELMET = registerHelmetItem(TeadArmorMaterials.LEAD);
    public static final Item LEAD_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.LEAD);
    public static final Item LEAD_LEGGINGS = registerLeggingsItem(TeadArmorMaterials.LEAD);
    public static final Item LEAD_BOOTS = registerBootsItem(TeadArmorMaterials.LEAD);
    public static final Item LEAD_CHAINMAIL_HELMET = registerHelmetItem(TeadArmorMaterials.LEAD_CHAIN);
    public static final Item LEAD_CHAINMAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.LEAD_CHAIN);
    public static final Item LEAD_CHAINMAIL_LEGGINGS = registerLeggingsItem(TeadArmorMaterials.LEAD_CHAIN);
    public static final Item LEAD_CHAINMAIL_BOOTS = registerBootsItem(TeadArmorMaterials.LEAD_CHAIN);
    public static final Item LEAD_GHOSTLY_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.LEAD_GHOSTLY);
    public static final Item LEAD_GHOSTLY_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.LEAD_GHOSTLY);
    public static final Item LEAD_GHOSTLY_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.LEAD_GHOSTLY);
    public static final Item LEAD_GUARD_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.LEAD_GUARD);
    public static final Item LEAD_GUARD_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.LEAD_GUARD);
    public static final Item LEAD_HIGHLAND_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.LEAD_HIGHLAND);
    public static final Item LEAD_HIGHLAND_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.LEAD_HIGHLAND);
    public static final Item LEAD_MERCENARY_HELMET = registerHelmetItem(TeadArmorMaterials.LEAD_MERCENARY);
    public static final Item LEAD_PLATE_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.LEAD_PLATE);
    public static final Item LEAD_PLATE_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.LEAD_PLATE);
    public static final Item LEAD_PLATE_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.LEAD_PLATE);
    public static final Item LEAD_REINFORCED_MAIL_HELMET = registerHelmetItem(TeadArmorMaterials.LEAD_REINFORCED_MAIL);
    public static final Item LEAD_REINFORCED_MAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.LEAD_REINFORCED_MAIL);
    public static final Item LEAD_ROYAL_HELMET = registerHelmetItem(TeadArmorMaterials.LEAD_ROYAL);
    public static final Item LEAD_SPANGENHELM_HELMET = registerHelmetItem(TeadArmorMaterials.LEAD_SPANGENHELM);
    public static final Item LEAD_STALWART_HELMET = registerHelmetItem(TeadArmorMaterials.LEAD_STALWART);
    public static final Item LEAD_STALWART_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.LEAD_STALWART);
    public static final Item LEAD_THIEF_HELMET = registerThiefHelmetItem(TeadArmorMaterials.LEAD_THIEF);
    public static final Item LEAD_THIEF_CHESTPLATE = registerThiefChestplateItem(TeadArmorMaterials.LEAD_THIEF);
    public static final Item LEAD_WOOLEN_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.LEAD_WOOLEN);
    public static final Item LEAD_WOOLEN_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.LEAD_WOOLEN);
    public static final Item LEAD_WOOLEN_LEGGINGS = registerDyeableLeggingsItem(TeadArmorMaterials.LEAD_WOOLEN);
    public static final Item LEAD_WOOLEN_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.LEAD_WOOLEN);

    // Copper Armor
    public static final Item COPPER_HELMET = registerHelmetItem(TeadArmorMaterials.COPPER);
    public static final Item COPPER_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.COPPER);
    public static final Item COPPER_LEGGINGS = registerLeggingsItem(TeadArmorMaterials.COPPER);
    public static final Item COPPER_BOOTS = registerBootsItem(TeadArmorMaterials.COPPER);
    public static final Item COPPER_CHAINMAIL_HELMET = registerHelmetItem(TeadArmorMaterials.COPPER_CHAIN);
    public static final Item COPPER_CHAINMAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.COPPER_CHAIN);
    public static final Item COPPER_CHAINMAIL_LEGGINGS = registerLeggingsItem(TeadArmorMaterials.COPPER_CHAIN);
    public static final Item COPPER_CHAINMAIL_BOOTS = registerBootsItem(TeadArmorMaterials.COPPER_CHAIN);
    public static final Item COPPER_GHOSTLY_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.COPPER_GHOSTLY);
    public static final Item COPPER_GHOSTLY_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.COPPER_GHOSTLY);
    public static final Item COPPER_GHOSTLY_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.COPPER_GHOSTLY);
    public static final Item COPPER_GUARD_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.COPPER_GUARD);
    public static final Item COPPER_GUARD_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.COPPER_GUARD);
    public static final Item COPPER_HIGHLAND_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.COPPER_HIGHLAND);
    public static final Item COPPER_HIGHLAND_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.COPPER_HIGHLAND);
    public static final Item COPPER_MERCENARY_HELMET = registerHelmetItem(TeadArmorMaterials.COPPER_MERCENARY);
    public static final Item COPPER_PLATE_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.COPPER_PLATE);
    public static final Item COPPER_PLATE_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.COPPER_PLATE);
    public static final Item COPPER_PLATE_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.COPPER_PLATE);
    public static final Item COPPER_REINFORCED_MAIL_HELMET = registerHelmetItem(TeadArmorMaterials.COPPER_REINFORCED_MAIL);
    public static final Item COPPER_REINFORCED_MAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.COPPER_REINFORCED_MAIL);
    public static final Item COPPER_ROYAL_HELMET = registerHelmetItem(TeadArmorMaterials.COPPER_ROYAL);
    public static final Item COPPER_SPANGENHELM_HELMET = registerHelmetItem(TeadArmorMaterials.COPPER_SPANGENHELM);
    public static final Item COPPER_STALWART_HELMET = registerHelmetItem(TeadArmorMaterials.COPPER_STALWART);
    public static final Item COPPER_STALWART_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.COPPER_STALWART);
    public static final Item COPPER_THIEF_HELMET = registerThiefHelmetItem(TeadArmorMaterials.COPPER_THIEF);
    public static final Item COPPER_THIEF_CHESTPLATE = registerThiefChestplateItem(TeadArmorMaterials.COPPER_THIEF);
    public static final Item COPPER_WOOLEN_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.COPPER_WOOLEN);
    public static final Item COPPER_WOOLEN_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.COPPER_WOOLEN);
    public static final Item COPPER_WOOLEN_LEGGINGS = registerDyeableLeggingsItem(TeadArmorMaterials.COPPER_WOOLEN);
    public static final Item COPPER_WOOLEN_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.COPPER_WOOLEN);

    // Rose Gold Armor
    public static final Item ROSE_GOLD_HELMET = registerHelmetItem(TeadArmorMaterials.ROSE_GOLD);
    public static final Item ROSE_GOLD_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.ROSE_GOLD);
    public static final Item ROSE_GOLD_LEGGINGS = registerLeggingsItem(TeadArmorMaterials.ROSE_GOLD);
    public static final Item ROSE_GOLD_BOOTS = registerBootsItem(TeadArmorMaterials.ROSE_GOLD);
    public static final Item ROSE_GOLD_CHAINMAIL_HELMET = registerHelmetItem(TeadArmorMaterials.ROSE_GOLD_CHAIN);
    public static final Item ROSE_GOLD_CHAINMAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.ROSE_GOLD_CHAIN);
    public static final Item ROSE_GOLD_CHAINMAIL_LEGGINGS = registerLeggingsItem(TeadArmorMaterials.ROSE_GOLD_CHAIN);
    public static final Item ROSE_GOLD_CHAINMAIL_BOOTS = registerBootsItem(TeadArmorMaterials.ROSE_GOLD_CHAIN);
    public static final Item ROSE_GOLD_GHOSTLY_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.ROSE_GOLD_GHOSTLY);
    public static final Item ROSE_GOLD_GHOSTLY_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.ROSE_GOLD_GHOSTLY);
    public static final Item ROSE_GOLD_GHOSTLY_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.ROSE_GOLD_GHOSTLY);
    public static final Item ROSE_GOLD_GUARD_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.ROSE_GOLD_GUARD);
    public static final Item ROSE_GOLD_GUARD_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.ROSE_GOLD_GUARD);
    public static final Item ROSE_GOLD_HIGHLAND_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.ROSE_GOLD_HIGHLAND);
    public static final Item ROSE_GOLD_HIGHLAND_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.ROSE_GOLD_HIGHLAND);
    public static final Item ROSE_GOLD_MERCENARY_HELMET = registerHelmetItem(TeadArmorMaterials.ROSE_GOLD_MERCENARY);
    public static final Item ROSE_GOLD_PLATE_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.ROSE_GOLD_PLATE);
    public static final Item ROSE_GOLD_PLATE_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.ROSE_GOLD_PLATE);
    public static final Item ROSE_GOLD_PLATE_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.ROSE_GOLD_PLATE);
    public static final Item ROSE_GOLD_REINFORCED_MAIL_HELMET = registerHelmetItem(TeadArmorMaterials.ROSE_GOLD_REINFORCED_MAIL);
    public static final Item ROSE_GOLD_REINFORCED_MAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.ROSE_GOLD_REINFORCED_MAIL);
    public static final Item ROSE_GOLD_ROYAL_HELMET = registerHelmetItem(TeadArmorMaterials.ROSE_GOLD_ROYAL);
    public static final Item ROSE_GOLD_SPANGENHELM_HELMET = registerHelmetItem(TeadArmorMaterials.ROSE_GOLD_SPANGENHELM);
    public static final Item ROSE_GOLD_STALWART_HELMET = registerHelmetItem(TeadArmorMaterials.ROSE_GOLD_STALWART);
    public static final Item ROSE_GOLD_STALWART_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.ROSE_GOLD_STALWART);
    public static final Item ROSE_GOLD_THIEF_HELMET = registerThiefHelmetItem(TeadArmorMaterials.ROSE_GOLD_THIEF);
    public static final Item ROSE_GOLD_THIEF_CHESTPLATE = registerThiefChestplateItem(TeadArmorMaterials.ROSE_GOLD_THIEF);
    public static final Item ROSE_GOLD_WOOLEN_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.ROSE_GOLD_WOOLEN);
    public static final Item ROSE_GOLD_WOOLEN_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.ROSE_GOLD_WOOLEN);
    public static final Item ROSE_GOLD_WOOLEN_LEGGINGS = registerDyeableLeggingsItem(TeadArmorMaterials.ROSE_GOLD_WOOLEN);
    public static final Item ROSE_GOLD_WOOLEN_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.ROSE_GOLD_WOOLEN);

    // White Gold Armor
    public static final Item WHITE_GOLD_HELMET = registerHelmetItem(TeadArmorMaterials.WHITE_GOLD);
    public static final Item WHITE_GOLD_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.WHITE_GOLD);
    public static final Item WHITE_GOLD_LEGGINGS = registerLeggingsItem(TeadArmorMaterials.WHITE_GOLD);
    public static final Item WHITE_GOLD_BOOTS = registerBootsItem(TeadArmorMaterials.WHITE_GOLD);
    public static final Item WHITE_GOLD_CHAINMAIL_HELMET = registerHelmetItem(TeadArmorMaterials.WHITE_GOLD_CHAIN);
    public static final Item WHITE_GOLD_CHAINMAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.WHITE_GOLD_CHAIN);
    public static final Item WHITE_GOLD_CHAINMAIL_LEGGINGS = registerLeggingsItem(TeadArmorMaterials.WHITE_GOLD_CHAIN);
    public static final Item WHITE_GOLD_CHAINMAIL_BOOTS = registerBootsItem(TeadArmorMaterials.WHITE_GOLD_CHAIN);
    public static final Item WHITE_GOLD_GHOSTLY_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.WHITE_GOLD_GHOSTLY);
    public static final Item WHITE_GOLD_GHOSTLY_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.WHITE_GOLD_GHOSTLY);
    public static final Item WHITE_GOLD_GHOSTLY_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.WHITE_GOLD_GHOSTLY);
    public static final Item WHITE_GOLD_GUARD_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.WHITE_GOLD_GUARD);
    public static final Item WHITE_GOLD_GUARD_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.WHITE_GOLD_GUARD);
    public static final Item WHITE_GOLD_HIGHLAND_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.WHITE_GOLD_HIGHLAND);
    public static final Item WHITE_GOLD_HIGHLAND_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.WHITE_GOLD_HIGHLAND);
    public static final Item WHITE_GOLD_MERCENARY_HELMET = registerHelmetItem(TeadArmorMaterials.WHITE_GOLD_MERCENARY);
    public static final Item WHITE_GOLD_PLATE_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.WHITE_GOLD_PLATE);
    public static final Item WHITE_GOLD_PLATE_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.WHITE_GOLD_PLATE);
    public static final Item WHITE_GOLD_PLATE_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.WHITE_GOLD_PLATE);
    public static final Item WHITE_GOLD_REINFORCED_MAIL_HELMET = registerHelmetItem(TeadArmorMaterials.WHITE_GOLD_REINFORCED_MAIL);
    public static final Item WHITE_GOLD_REINFORCED_MAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.WHITE_GOLD_REINFORCED_MAIL);
    public static final Item WHITE_GOLD_ROYAL_HELMET = registerHelmetItem(TeadArmorMaterials.WHITE_GOLD_ROYAL);
    public static final Item WHITE_GOLD_SPANGENHELM_HELMET = registerHelmetItem(TeadArmorMaterials.WHITE_GOLD_SPANGENHELM);
    public static final Item WHITE_GOLD_STALWART_HELMET = registerHelmetItem(TeadArmorMaterials.WHITE_GOLD_STALWART);
    public static final Item WHITE_GOLD_STALWART_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.WHITE_GOLD_STALWART);
    public static final Item WHITE_GOLD_THIEF_HELMET = registerThiefHelmetItem(TeadArmorMaterials.WHITE_GOLD_THIEF);
    public static final Item WHITE_GOLD_THIEF_CHESTPLATE = registerThiefChestplateItem(TeadArmorMaterials.WHITE_GOLD_THIEF);
    public static final Item WHITE_GOLD_WOOLEN_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.WHITE_GOLD_WOOLEN);
    public static final Item WHITE_GOLD_WOOLEN_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.WHITE_GOLD_WOOLEN);
    public static final Item WHITE_GOLD_WOOLEN_LEGGINGS = registerDyeableLeggingsItem(TeadArmorMaterials.WHITE_GOLD_WOOLEN);
    public static final Item WHITE_GOLD_WOOLEN_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.WHITE_GOLD_WOOLEN);

    // Iron Armor
    public static final Item IRON_GHOSTLY_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.IRON_GHOSTLY);
    public static final Item IRON_GHOSTLY_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.IRON_GHOSTLY);
    public static final Item IRON_GHOSTLY_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.IRON_GHOSTLY);
    public static final Item IRON_GUARD_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.IRON_GUARD);
    public static final Item IRON_GUARD_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.IRON_GUARD);
    public static final Item IRON_HIGHLAND_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.IRON_HIGHLAND);
    public static final Item IRON_HIGHLAND_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.IRON_HIGHLAND);
    public static final Item IRON_MERCENARY_HELMET = registerHelmetItem(TeadArmorMaterials.IRON_MERCENARY);
    public static final Item IRON_PLATE_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.IRON_PLATE);
    public static final Item IRON_PLATE_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.IRON_PLATE);
    public static final Item IRON_PLATE_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.IRON_PLATE);
    public static final Item IRON_REINFORCED_MAIL_HELMET = registerHelmetItem(TeadArmorMaterials.IRON_REINFORCED_MAIL);
    public static final Item IRON_REINFORCED_MAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.IRON_REINFORCED_MAIL);
    public static final Item IRON_ROYAL_HELMET = registerHelmetItem(TeadArmorMaterials.IRON_ROYAL);
    public static final Item IRON_SPANGENHELM_HELMET = registerHelmetItem(TeadArmorMaterials.IRON_SPANGENHELM);
    public static final Item IRON_STALWART_HELMET = registerHelmetItem(TeadArmorMaterials.IRON_STALWART);
    public static final Item IRON_STALWART_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.IRON_STALWART);
    public static final Item IRON_THIEF_HELMET = registerThiefHelmetItem(TeadArmorMaterials.IRON_THIEF);
    public static final Item IRON_THIEF_CHESTPLATE = registerThiefChestplateItem(TeadArmorMaterials.IRON_THIEF);
    public static final Item IRON_WOOLEN_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.IRON_WOOLEN);
    public static final Item IRON_WOOLEN_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.IRON_WOOLEN);
    public static final Item IRON_WOOLEN_LEGGINGS = registerDyeableLeggingsItem(TeadArmorMaterials.IRON_WOOLEN);
    public static final Item IRON_WOOLEN_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.IRON_WOOLEN);

    // Brass Armor
    public static final Item BRASS_HELMET = registerHelmetItem(TeadArmorMaterials.BRASS);
    public static final Item BRASS_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.BRASS);
    public static final Item BRASS_LEGGINGS = registerLeggingsItem(TeadArmorMaterials.BRASS);
    public static final Item BRASS_BOOTS = registerBootsItem(TeadArmorMaterials.BRASS);
    public static final Item BRASS_CHAINMAIL_HELMET = registerHelmetItem(TeadArmorMaterials.BRASS_CHAIN);
    public static final Item BRASS_CHAINMAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.BRASS_CHAIN);
    public static final Item BRASS_CHAINMAIL_LEGGINGS = registerLeggingsItem(TeadArmorMaterials.BRASS_CHAIN);
    public static final Item BRASS_CHAINMAIL_BOOTS = registerBootsItem(TeadArmorMaterials.BRASS_CHAIN);
    public static final Item BRASS_GHOSTLY_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.BRASS_GHOSTLY);
    public static final Item BRASS_GHOSTLY_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.BRASS_GHOSTLY);
    public static final Item BRASS_GHOSTLY_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.BRASS_GHOSTLY);
    public static final Item BRASS_GUARD_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.BRASS_GUARD);
    public static final Item BRASS_GUARD_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.BRASS_GUARD);
    public static final Item BRASS_HIGHLAND_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.BRASS_HIGHLAND);
    public static final Item BRASS_HIGHLAND_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.BRASS_HIGHLAND);
    public static final Item BRASS_MERCENARY_HELMET = registerHelmetItem(TeadArmorMaterials.BRASS_MERCENARY);
    public static final Item BRASS_PLATE_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.BRASS_PLATE);
    public static final Item BRASS_PLATE_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.BRASS_PLATE);
    public static final Item BRASS_PLATE_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.BRASS_PLATE);
    public static final Item BRASS_REINFORCED_MAIL_HELMET = registerHelmetItem(TeadArmorMaterials.BRASS_REINFORCED_MAIL);
    public static final Item BRASS_REINFORCED_MAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.BRASS_REINFORCED_MAIL);
    public static final Item BRASS_ROYAL_HELMET = registerHelmetItem(TeadArmorMaterials.BRASS_ROYAL);
    public static final Item BRASS_SPANGENHELM_HELMET = registerHelmetItem(TeadArmorMaterials.BRASS_SPANGENHELM);
    public static final Item BRASS_STALWART_HELMET = registerHelmetItem(TeadArmorMaterials.BRASS_STALWART);
    public static final Item BRASS_STALWART_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.BRASS_STALWART);
    public static final Item BRASS_THIEF_HELMET = registerThiefHelmetItem(TeadArmorMaterials.BRASS_THIEF);
    public static final Item BRASS_THIEF_CHESTPLATE = registerThiefChestplateItem(TeadArmorMaterials.BRASS_THIEF);
    public static final Item BRASS_WOOLEN_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.BRASS_WOOLEN);
    public static final Item BRASS_WOOLEN_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.BRASS_WOOLEN);
    public static final Item BRASS_WOOLEN_LEGGINGS = registerDyeableLeggingsItem(TeadArmorMaterials.BRASS_WOOLEN);
    public static final Item BRASS_WOOLEN_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.BRASS_WOOLEN);

    // Bronze Armor
    public static final Item BRONZE_HELMET = registerHelmetItem(TeadArmorMaterials.BRONZE);
    public static final Item BRONZE_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.BRONZE);
    public static final Item BRONZE_LEGGINGS = registerLeggingsItem(TeadArmorMaterials.BRONZE);
    public static final Item BRONZE_BOOTS = registerBootsItem(TeadArmorMaterials.BRONZE);
    public static final Item BRONZE_CHAINMAIL_HELMET = registerHelmetItem(TeadArmorMaterials.BRONZE_CHAIN);
    public static final Item BRONZE_CHAINMAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.BRONZE_CHAIN);
    public static final Item BRONZE_CHAINMAIL_LEGGINGS = registerLeggingsItem(TeadArmorMaterials.BRONZE_CHAIN);
    public static final Item BRONZE_CHAINMAIL_BOOTS = registerBootsItem(TeadArmorMaterials.BRONZE_CHAIN);
    public static final Item BRONZE_GHOSTLY_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.BRONZE_GHOSTLY);
    public static final Item BRONZE_GHOSTLY_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.BRONZE_GHOSTLY);
    public static final Item BRONZE_GHOSTLY_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.BRONZE_GHOSTLY);
    public static final Item BRONZE_GUARD_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.BRONZE_GUARD);
    public static final Item BRONZE_GUARD_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.BRONZE_GUARD);
    public static final Item BRONZE_HIGHLAND_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.BRONZE_HIGHLAND);
    public static final Item BRONZE_HIGHLAND_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.BRONZE_HIGHLAND);
    public static final Item BRONZE_MERCENARY_HELMET = registerHelmetItem(TeadArmorMaterials.BRONZE_MERCENARY);
    public static final Item BRONZE_PLATE_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.BRONZE_PLATE);
    public static final Item BRONZE_PLATE_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.BRONZE_PLATE);
    public static final Item BRONZE_PLATE_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.BRONZE_PLATE);
    public static final Item BRONZE_REINFORCED_MAIL_HELMET = registerHelmetItem(TeadArmorMaterials.BRONZE_REINFORCED_MAIL);
    public static final Item BRONZE_REINFORCED_MAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.BRONZE_REINFORCED_MAIL);
    public static final Item BRONZE_ROYAL_HELMET = registerHelmetItem(TeadArmorMaterials.BRONZE_ROYAL);
    public static final Item BRONZE_SPANGENHELM_HELMET = registerHelmetItem(TeadArmorMaterials.BRONZE_SPANGENHELM);
    public static final Item BRONZE_STALWART_HELMET = registerHelmetItem(TeadArmorMaterials.BRONZE_STALWART);
    public static final Item BRONZE_STALWART_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.BRONZE_STALWART);
    public static final Item BRONZE_THIEF_HELMET = registerThiefHelmetItem(TeadArmorMaterials.BRONZE_THIEF);
    public static final Item BRONZE_THIEF_CHESTPLATE = registerThiefChestplateItem(TeadArmorMaterials.BRONZE_THIEF);
    public static final Item BRONZE_WOOLEN_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.BRONZE_WOOLEN);
    public static final Item BRONZE_WOOLEN_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.BRONZE_WOOLEN);
    public static final Item BRONZE_WOOLEN_LEGGINGS = registerDyeableLeggingsItem(TeadArmorMaterials.BRONZE_WOOLEN);
    public static final Item BRONZE_WOOLEN_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.BRONZE_WOOLEN);

    // Steel Armor
    public static final Item STEEL_HELMET = registerHelmetItem(TeadArmorMaterials.STEEL);
    public static final Item STEEL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.STEEL);
    public static final Item STEEL_LEGGINGS = registerLeggingsItem(TeadArmorMaterials.STEEL);
    public static final Item STEEL_BOOTS = registerBootsItem(TeadArmorMaterials.STEEL);
    public static final Item STEEL_CHAINMAIL_HELMET = registerHelmetItem(TeadArmorMaterials.STEEL_CHAIN);
    public static final Item STEEL_CHAINMAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.STEEL_CHAIN);
    public static final Item STEEL_CHAINMAIL_LEGGINGS = registerLeggingsItem(TeadArmorMaterials.STEEL_CHAIN);
    public static final Item STEEL_CHAINMAIL_BOOTS = registerBootsItem(TeadArmorMaterials.STEEL_CHAIN);
    public static final Item STEEL_GHOSTLY_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.STEEL_GHOSTLY);
    public static final Item STEEL_GHOSTLY_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.STEEL_GHOSTLY);
    public static final Item STEEL_GHOSTLY_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.STEEL_GHOSTLY);
    public static final Item STEEL_GUARD_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.STEEL_GUARD);
    public static final Item STEEL_GUARD_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.STEEL_GUARD);
    public static final Item STEEL_HIGHLAND_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.STEEL_HIGHLAND);
    public static final Item STEEL_HIGHLAND_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.STEEL_HIGHLAND);
    public static final Item STEEL_MERCENARY_HELMET = registerHelmetItem(TeadArmorMaterials.STEEL_MERCENARY);
    public static final Item STEEL_PLATE_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.STEEL_PLATE);
    public static final Item STEEL_PLATE_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.STEEL_PLATE);
    public static final Item STEEL_PLATE_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.STEEL_PLATE);
    public static final Item STEEL_REINFORCED_MAIL_HELMET = registerHelmetItem(TeadArmorMaterials.STEEL_REINFORCED_MAIL);
    public static final Item STEEL_REINFORCED_MAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.STEEL_REINFORCED_MAIL);
    public static final Item STEEL_ROYAL_HELMET = registerHelmetItem(TeadArmorMaterials.STEEL_ROYAL);
    public static final Item STEEL_SPANGENHELM_HELMET = registerHelmetItem(TeadArmorMaterials.STEEL_SPANGENHELM);
    public static final Item STEEL_STALWART_HELMET = registerHelmetItem(TeadArmorMaterials.STEEL_STALWART);
    public static final Item STEEL_STALWART_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.STEEL_STALWART);
    public static final Item STEEL_THIEF_HELMET = registerThiefHelmetItem(TeadArmorMaterials.STEEL_THIEF);
    public static final Item STEEL_THIEF_CHESTPLATE = registerThiefChestplateItem(TeadArmorMaterials.STEEL_THIEF);
    public static final Item STEEL_WOOLEN_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.STEEL_WOOLEN);
    public static final Item STEEL_WOOLEN_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.STEEL_WOOLEN);
    public static final Item STEEL_WOOLEN_LEGGINGS = registerDyeableLeggingsItem(TeadArmorMaterials.STEEL_WOOLEN);
    public static final Item STEEL_WOOLEN_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.STEEL_WOOLEN);

    // Diamond Armor
    public static final Item DIAMOND_GHOSTLY_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.DIAMOND_GHOSTLY);
    public static final Item DIAMOND_GHOSTLY_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.DIAMOND_GHOSTLY);
    public static final Item DIAMOND_GHOSTLY_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.DIAMOND_GHOSTLY);
    public static final Item DIAMOND_GUARD_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.DIAMOND_GUARD);
    public static final Item DIAMOND_GUARD_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.DIAMOND_GUARD);
    public static final Item DIAMOND_HIGHLAND_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.DIAMOND_HIGHLAND);
    public static final Item DIAMOND_HIGHLAND_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.DIAMOND_HIGHLAND);
    public static final Item DIAMOND_MERCENARY_HELMET = registerHelmetItem(TeadArmorMaterials.DIAMOND_MERCENARY);
    public static final Item DIAMOND_PLATE_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.DIAMOND_PLATE);
    public static final Item DIAMOND_PLATE_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.DIAMOND_PLATE);
    public static final Item DIAMOND_PLATE_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.DIAMOND_PLATE);
    public static final Item DIAMOND_REINFORCED_MAIL_HELMET = registerHelmetItem(TeadArmorMaterials.DIAMOND_REINFORCED_MAIL);
    public static final Item DIAMOND_REINFORCED_MAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.DIAMOND_REINFORCED_MAIL);
    public static final Item DIAMOND_ROYAL_HELMET = registerHelmetItem(TeadArmorMaterials.DIAMOND_ROYAL);
    public static final Item DIAMOND_SPANGENHELM_HELMET = registerHelmetItem(TeadArmorMaterials.DIAMOND_SPANGENHELM);
    public static final Item DIAMOND_STALWART_HELMET = registerHelmetItem(TeadArmorMaterials.DIAMOND_STALWART);
    public static final Item DIAMOND_STALWART_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.DIAMOND_STALWART);
    public static final Item DIAMOND_THIEF_HELMET = registerThiefHelmetItem(TeadArmorMaterials.DIAMOND_THIEF);
    public static final Item DIAMOND_THIEF_CHESTPLATE = registerThiefChestplateItem(TeadArmorMaterials.DIAMOND_THIEF);
    public static final Item DIAMOND_WOOLEN_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.DIAMOND_WOOLEN);
    public static final Item DIAMOND_WOOLEN_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.DIAMOND_WOOLEN);
    public static final Item DIAMOND_WOOLEN_LEGGINGS = registerDyeableLeggingsItem(TeadArmorMaterials.DIAMOND_WOOLEN);
    public static final Item DIAMOND_WOOLEN_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.DIAMOND_WOOLEN);

    // Netherite Armor
    public static final Item NETHERITE_GHOSTLY_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.NETHERITE_GHOSTLY);
    public static final Item NETHERITE_GHOSTLY_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.NETHERITE_GHOSTLY);
    public static final Item NETHERITE_GHOSTLY_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.NETHERITE_GHOSTLY);
    public static final Item NETHERITE_GUARD_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.NETHERITE_GUARD);
    public static final Item NETHERITE_GUARD_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.NETHERITE_GUARD);
    public static final Item NETHERITE_HIGHLAND_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.NETHERITE_HIGHLAND);
    public static final Item NETHERITE_HIGHLAND_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.NETHERITE_HIGHLAND);
    public static final Item NETHERITE_MERCENARY_HELMET = registerHelmetItem(TeadArmorMaterials.NETHERITE_MERCENARY);
    public static final Item NETHERITE_PLATE_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.NETHERITE_PLATE);
    public static final Item NETHERITE_PLATE_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.NETHERITE_PLATE);
    public static final Item NETHERITE_PLATE_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.NETHERITE_PLATE);
    public static final Item NETHERITE_REINFORCED_MAIL_HELMET = registerHelmetItem(TeadArmorMaterials.NETHERITE_REINFORCED_MAIL);
    public static final Item NETHERITE_REINFORCED_MAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.NETHERITE_REINFORCED_MAIL);
    public static final Item NETHERITE_ROYAL_HELMET = registerHelmetItem(TeadArmorMaterials.NETHERITE_ROYAL);
    public static final Item NETHERITE_SPANGENHELM_HELMET = registerHelmetItem(TeadArmorMaterials.NETHERITE_SPANGENHELM);
    public static final Item NETHERITE_STALWART_HELMET = registerHelmetItem(TeadArmorMaterials.NETHERITE_STALWART);
    public static final Item NETHERITE_STALWART_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.NETHERITE_STALWART);
    public static final Item NETHERITE_THIEF_HELMET = registerThiefHelmetItem(TeadArmorMaterials.NETHERITE_THIEF);
    public static final Item NETHERITE_THIEF_CHESTPLATE = registerThiefChestplateItem(TeadArmorMaterials.NETHERITE_THIEF);
    public static final Item NETHERITE_WOOLEN_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.NETHERITE_WOOLEN);
    public static final Item NETHERITE_WOOLEN_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.NETHERITE_WOOLEN);
    public static final Item NETHERITE_WOOLEN_LEGGINGS = registerDyeableLeggingsItem(TeadArmorMaterials.NETHERITE_WOOLEN);
    public static final Item NETHERITE_WOOLEN_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.NETHERITE_WOOLEN);

    // Rose Netherite Armor
    public static final Item ROSE_NETHERITE_HELMET = registerHelmetItem(TeadArmorMaterials.ROSE_NETHERITE);
    public static final Item ROSE_NETHERITE_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.ROSE_NETHERITE);
    public static final Item ROSE_NETHERITE_LEGGINGS = registerLeggingsItem(TeadArmorMaterials.ROSE_NETHERITE);
    public static final Item ROSE_NETHERITE_BOOTS = registerBootsItem(TeadArmorMaterials.ROSE_NETHERITE);
    public static final Item ROSE_NETHERITE_GHOSTLY_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.ROSE_NETHERITE_GHOSTLY);
    public static final Item ROSE_NETHERITE_GHOSTLY_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.ROSE_NETHERITE_GHOSTLY);
    public static final Item ROSE_NETHERITE_GHOSTLY_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.ROSE_NETHERITE_GHOSTLY);
    public static final Item ROSE_NETHERITE_GUARD_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.ROSE_NETHERITE_GUARD);
    public static final Item ROSE_NETHERITE_GUARD_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.ROSE_NETHERITE_GUARD);
    public static final Item ROSE_NETHERITE_HIGHLAND_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.ROSE_NETHERITE_HIGHLAND);
    public static final Item ROSE_NETHERITE_HIGHLAND_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.ROSE_NETHERITE_HIGHLAND);
    public static final Item ROSE_NETHERITE_MERCENARY_HELMET = registerHelmetItem(TeadArmorMaterials.ROSE_NETHERITE_MERCENARY);
    public static final Item ROSE_NETHERITE_PLATE_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.ROSE_NETHERITE_PLATE);
    public static final Item ROSE_NETHERITE_PLATE_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.ROSE_NETHERITE_PLATE);
    public static final Item ROSE_NETHERITE_PLATE_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.ROSE_NETHERITE_PLATE);
    public static final Item ROSE_NETHERITE_REINFORCED_MAIL_HELMET = registerHelmetItem(TeadArmorMaterials.ROSE_NETHERITE_REINFORCED_MAIL);
    public static final Item ROSE_NETHERITE_REINFORCED_MAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.ROSE_NETHERITE_REINFORCED_MAIL);
    public static final Item ROSE_NETHERITE_ROYAL_HELMET = registerHelmetItem(TeadArmorMaterials.ROSE_NETHERITE_ROYAL);
    public static final Item ROSE_NETHERITE_SPANGENHELM_HELMET = registerHelmetItem(TeadArmorMaterials.ROSE_NETHERITE_SPANGENHELM);
    public static final Item ROSE_NETHERITE_STALWART_HELMET = registerHelmetItem(TeadArmorMaterials.ROSE_NETHERITE_STALWART);
    public static final Item ROSE_NETHERITE_STALWART_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.ROSE_NETHERITE_STALWART);
    public static final Item ROSE_NETHERITE_THIEF_HELMET = registerThiefHelmetItem(TeadArmorMaterials.ROSE_NETHERITE_THIEF);
    public static final Item ROSE_NETHERITE_THIEF_CHESTPLATE = registerThiefChestplateItem(TeadArmorMaterials.ROSE_NETHERITE_THIEF);
    public static final Item ROSE_NETHERITE_WOOLEN_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.ROSE_NETHERITE_WOOLEN);
    public static final Item ROSE_NETHERITE_WOOLEN_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.ROSE_NETHERITE_WOOLEN);
    public static final Item ROSE_NETHERITE_WOOLEN_LEGGINGS = registerDyeableLeggingsItem(TeadArmorMaterials.ROSE_NETHERITE_WOOLEN);
    public static final Item ROSE_NETHERITE_WOOLEN_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.ROSE_NETHERITE_WOOLEN);

    // White Netherite Armor
    public static final Item WHITE_NETHERITE_HELMET = registerHelmetItem(TeadArmorMaterials.WHITE_NETHERITE);
    public static final Item WHITE_NETHERITE_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.WHITE_NETHERITE);
    public static final Item WHITE_NETHERITE_LEGGINGS = registerLeggingsItem(TeadArmorMaterials.WHITE_NETHERITE);
    public static final Item WHITE_NETHERITE_BOOTS = registerBootsItem(TeadArmorMaterials.WHITE_NETHERITE);
    public static final Item WHITE_NETHERITE_GHOSTLY_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.WHITE_NETHERITE_GHOSTLY);
    public static final Item WHITE_NETHERITE_GHOSTLY_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.WHITE_NETHERITE_GHOSTLY);
    public static final Item WHITE_NETHERITE_GHOSTLY_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.WHITE_NETHERITE_GHOSTLY);
    public static final Item WHITE_NETHERITE_GUARD_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.WHITE_NETHERITE_GUARD);
    public static final Item WHITE_NETHERITE_GUARD_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.WHITE_NETHERITE_GUARD);
    public static final Item WHITE_NETHERITE_HIGHLAND_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.WHITE_NETHERITE_HIGHLAND);
    public static final Item WHITE_NETHERITE_HIGHLAND_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.WHITE_NETHERITE_HIGHLAND);
    public static final Item WHITE_NETHERITE_MERCENARY_HELMET = registerHelmetItem(TeadArmorMaterials.WHITE_NETHERITE_MERCENARY);
    public static final Item WHITE_NETHERITE_PLATE_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.WHITE_NETHERITE_PLATE);
    public static final Item WHITE_NETHERITE_PLATE_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.WHITE_NETHERITE_PLATE);
    public static final Item WHITE_NETHERITE_PLATE_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.WHITE_NETHERITE_PLATE);
    public static final Item WHITE_NETHERITE_REINFORCED_MAIL_HELMET = registerHelmetItem(TeadArmorMaterials.WHITE_NETHERITE_REINFORCED_MAIL);
    public static final Item WHITE_NETHERITE_REINFORCED_MAIL_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.WHITE_NETHERITE_REINFORCED_MAIL);
    public static final Item WHITE_NETHERITE_ROYAL_HELMET = registerHelmetItem(TeadArmorMaterials.WHITE_NETHERITE_ROYAL);
    public static final Item WHITE_NETHERITE_SPANGENHELM_HELMET = registerHelmetItem(TeadArmorMaterials.WHITE_NETHERITE_SPANGENHELM);
    public static final Item WHITE_NETHERITE_STALWART_HELMET = registerHelmetItem(TeadArmorMaterials.WHITE_NETHERITE_STALWART);
    public static final Item WHITE_NETHERITE_STALWART_CHESTPLATE = registerChestplateItem(TeadArmorMaterials.WHITE_NETHERITE_STALWART);
    public static final Item WHITE_NETHERITE_THIEF_HELMET = registerThiefHelmetItem(TeadArmorMaterials.WHITE_NETHERITE_THIEF);
    public static final Item WHITE_NETHERITE_THIEF_CHESTPLATE = registerThiefChestplateItem(TeadArmorMaterials.WHITE_NETHERITE_THIEF);
    public static final Item WHITE_NETHERITE_WOOLEN_HELMET = registerDyeableHelmetItem(TeadArmorMaterials.WHITE_NETHERITE_WOOLEN);
    public static final Item WHITE_NETHERITE_WOOLEN_CHESTPLATE = registerDyeableChestplateItem(TeadArmorMaterials.WHITE_NETHERITE_WOOLEN);
    public static final Item WHITE_NETHERITE_WOOLEN_LEGGINGS = registerDyeableLeggingsItem(TeadArmorMaterials.WHITE_NETHERITE_WOOLEN);
    public static final Item WHITE_NETHERITE_WOOLEN_BOOTS = registerDyeableBootsItem(TeadArmorMaterials.WHITE_NETHERITE_WOOLEN);

    // Custom Arrows And Bows
    public static final Item RUBY_POWER_BOW = registerItem("ruby_power_bow",
            new PowerBowItem(TeadToolMaterials.RUBY, new FabricItemSettings()));
    public static final Item BONE_BOW = registerItem("bone_bow",
            new BoneBowItem(new FabricItemSettings().maxDamage(415)));
    public static final Item WIND_BOW = registerItem("wind_bow",
            new WindBowItem(new FabricItemSettings().maxDamage(432)));
    public static final Item WEBBED_BOW = registerItem("webbed_bow",
            new WebbedBowItem(new FabricItemSettings().maxDamage(432)));
    public static final Item TRICK_BOW = registerItem("trick_bow",
            new TrickBowItem(new FabricItemSettings().maxDamage(632).rarity(Rarity.UNCOMMON)));
    public static final Item SHORT_BOW = registerItem("short_bow",
            new ShortBowItem(new FabricItemSettings().maxDamage(384)));
    public static final Item LONG_BOW = registerItem("long_bow",
            new LongBowItem(new FabricItemSettings().maxDamage(384)));
    public static final Item FIREBOLT_THROWER = registerItem("firebolt_thrower",
            new FireboltThrower(new FabricItemSettings().maxDamage(427)));

    public static final Item AMETHYST_ARROW = registerItem("amethyst_arrow",
            new AmethystArrowItem(new FabricItemSettings()));
    public static final Item COPPER_ARROW = registerItem("copper_arrow",
            new CopperArrowItem(new FabricItemSettings()));
    public static final Item ENDER_PEARL_ARROW = registerItem("ender_pearl_arrow",
            new EnderPearlArrowItem(new FabricItemSettings()));
    public static final Item OBSIDIAN_ARROW = registerItem("obsidian_arrow",
            new ObsidianArrowItem(new FabricItemSettings()));
    public static final Item RUBY_ARROW = registerItem("ruby_arrow",
            new RubyArrowItem(new FabricItemSettings()));
    public static final Item TRANSMORPHING_ARROW = registerItem("transmorphing_arrow",
            new TransmorphingArrowItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item TNT_ARROW = registerItem("tnt_arrow",
            new TntArrowItem(new FabricItemSettings()));
    public static final Item TORCH_ARROW = registerItem("torch_arrow",
            new TorchArrowItem(new FabricItemSettings()));
    public static final Item REDSTONE_TORCH_ARROW = registerItem("redstone_torch_arrow",
            new RedstoneTorchArrowItem(new FabricItemSettings()));
    public static final Item SOUL_TORCH_ARROW = registerItem("soul_torch_arrow",
            new SoulTorchArrowItem(new FabricItemSettings()));
    public static final Item BORING_ARROW = registerItem("boring_arrow",
            new BoringArrowItem(new FabricItemSettings()));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Tead.MOD_ID, name), item);
    }

    // Tool And Weapon Constructors
    private static Item registerShovelItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_shovel",
                new ShovelItem(toolMaterial, 1.5f, -3.0f, new FabricItemSettings()));
    }

    private static Item registerHoeItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_hoe",
                new HoeItem(toolMaterial, -2, -1.0f, new FabricItemSettings()));
    }

    private static Item registerScytheItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_scythe", new ScytheItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerSickleItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_sickle", new SickleItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerPickaxeItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_pickaxe",
                new PickaxeItem(toolMaterial, 1, -2.9f, new FabricItemSettings()));
    }

    private static Item registerMountaineerPickItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_mountaineer_pick",
                new MountaineerPickItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerMattockItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_mattock", new MattockItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerAxeItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_axe",
                new AxeItem(toolMaterial, 5.0f, -3.2f, new FabricItemSettings()));
    }

    private static Item registerHighlandAxeItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_highland_axe",
                new HighlandAxeItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerDoubleAxeItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_double_axe",
                new AxeItem(toolMaterial, 6.0f, -3.5f, new FabricItemSettings()));
    }

    private static Item registerDoubleHighlandAxeItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_double_highland_axe",
                new DoubleHighlandAxe(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerHatchetItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_hatchet", new HatchetItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerHammerItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_hammer", new HammerItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerMaceItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_mace", new MaceItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerDaggerItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_dagger", new DaggerItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerHollowDaggerItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_hollow_dagger",
                new HollowDaggerItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerRiteDaggerItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_rite_dagger",
                new RiteDaggerItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerCrescentDaggerItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_crescent_dagger",
                new CrescentDaggerItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerTruthseekerItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_truthseeker",
                new TruthseekerItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerTempestKnifeItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_tempest_knife",
                new TempestKnifeItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerGreatswordItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_greatsword",
                new GreatswordItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerSwordItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_sword",
                new SwordItem(toolMaterial, 3, -2.5f, new FabricItemSettings()));
    }

    private static Item registerRapierItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_rapier", new RapierItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerCutlassItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_cutlass", new CutlassItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerKatanaItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_katana", new KatanaItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerLongswordItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_longsword",
                new LongswordItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerBroadswordItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_broadsword",
                new BroadswordItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerClaymoreItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_claymore", new ClaymoreItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerSpearItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_spear", new SpearItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerRanseurItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_ranseur", new RanseurItem(toolMaterial, new FabricItemSettings()));
    }

    private static Item registerGlaiveItem(ToolMaterial toolMaterial, String materialName) {
        return registerItem(materialName + "_glaive", new GlaiveItem(toolMaterial, new FabricItemSettings()));
    }

    // Armor Constructors
    private static Item registerArmorItem(String typeName, ArmorItem armorItem) {
        String fullName = armorItem.getMaterial().getName().toLowerCase();
        int colonIndex = fullName.indexOf(':');
        String materialName = colonIndex != -1 ? fullName.substring(colonIndex + 1) : fullName;

        return registerItem( materialName + "_" + typeName, armorItem);
    }

    private static Item registerHelmetItem(ArmorMaterial armorMaterial) {
        return registerArmorItem( "helmet", new ArmorItem(armorMaterial, ArmorItem.Type.HELMET, new FabricItemSettings()));
    }

    private static Item registerChestplateItem(ArmorMaterial armorMaterial) {
        return registerArmorItem( "chestplate", new ArmorItem(armorMaterial, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    }

    private static Item registerLeggingsItem(ArmorMaterial armorMaterial) {
        return registerArmorItem( "leggings", new ArmorItem(armorMaterial, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    }

    private static Item registerBootsItem(ArmorMaterial armorMaterial) {
        return registerArmorItem( "boots", new ArmorItem(armorMaterial, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    }

    private static Item registerDyeableHelmetItem(ArmorMaterial armorMaterial) {
        return registerArmorItem( "helmet", new DyeableArmorItem(armorMaterial, ArmorItem.Type.HELMET, new FabricItemSettings()));
    }

    private static Item registerDyeableChestplateItem(ArmorMaterial armorMaterial) {
        return registerArmorItem( "chestplate", new DyeableArmorItem(armorMaterial, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    }

    private static Item registerDyeableLeggingsItem(ArmorMaterial armorMaterial) {
        return registerArmorItem( "leggings", new DyeableArmorItem(armorMaterial, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    }

    private static Item registerDyeableBootsItem(ArmorMaterial armorMaterial) {
        return registerArmorItem( "boots", new DyeableArmorItem(armorMaterial, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    }

    private static Item registerThiefHelmetItem(ArmorMaterial armorMaterial) {
        return registerArmorItem( "helmet", new ThiefArmor(armorMaterial, ArmorItem.Type.HELMET, new FabricItemSettings()));
    }

    private static Item registerThiefChestplateItem(ArmorMaterial armorMaterial) {
        return registerArmorItem( "chestplate", new ThiefArmor(armorMaterial, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    }

    public static void registerItems() {
        Tead.LOGGER.info("Registering mod items for " + Tead.MOD_ID);
    }
}
