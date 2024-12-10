package net.pythonbear.tead.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.item.*;
import net.pythonbear.tead.item.arrow.*;
import net.pythonbear.tead.sound.TeadSounds;

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
    public static final Item SMITHING_GUIDE_TEMPEST_KNIFE = registerItem("smithing_guide_tempest_knife",
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
    public static final Item OBSIDIAN_SHARD = registerItem("obsidian_shard", new Item(new FabricItemSettings()));
    public static final Item OBSIDIAN_INGOT = registerItem("obsidian_ingot", new Item(new FabricItemSettings()));
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
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RUBY_INGOT = registerItem("ruby_ingot",
            new RubyIngotItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item ROSE_NETHERITE_INGOT = registerItem("rose_netherite_ingot",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item WHITE_NETHERITE_INGOT = registerItem("white_netherite_ingot",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item BUFFERED_PEARL = registerItem("buffered_pearl",
            new BufferedPearl(new FabricItemSettings().maxCount(16)));
    public static final Item GRAVITY_PEARL = registerItem("gravity_pearl",
            new GravityPearl(new FabricItemSettings()));
    public static final Item TRANSMUTATION_GRIMOIRE = registerItem("transmutation_grimoire",
            new GlintedItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item HANDLE = registerItem("handle", new Item(new FabricItemSettings()));
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

    public static final Item LEAD_AXE = registerItem("lead_axe",
            new AxeItem(TeadToolMaterials.LEAD, 5.0f, -3.2f,  new FabricItemSettings()));
    public static final Item LEAD_PICKAXE = registerItem("lead_pickaxe",
            new PickaxeItem(TeadToolMaterials.LEAD, 1, -2.9f,  new FabricItemSettings()));
    public static final Item LEAD_SWORD = registerItem("lead_sword",
            new SwordItem(TeadToolMaterials.LEAD, 3, -2.5f,  new FabricItemSettings()));
    public static final Item LEAD_SHOVEL = registerItem("lead_shovel",
            new ShovelItem(TeadToolMaterials.LEAD, 1.5f, -3.0f,  new FabricItemSettings()));
    public static final Item LEAD_HOE = registerItem("lead_hoe",
            new HoeItem(TeadToolMaterials.LEAD, -2, -1.0f,  new FabricItemSettings()));
    public static final Item LEAD_DOUBLE_AXE = registerItem("lead_double_axe",
            new AxeItem(TeadToolMaterials.LEAD, 6.0f, -3.5f,  new FabricItemSettings()));
    public static final Item LEAD_HAMMER = registerItem("lead_hammer",
            new HammerItem(TeadToolMaterials.LEAD, new FabricItemSettings()));
    public static final Item LEAD_DAGGER = registerItem("lead_dagger",
            new DaggerItem(TeadToolMaterials.LEAD, new FabricItemSettings()));
    public static final Item LEAD_RAPIER = registerItem("lead_rapier",
            new RapierItem(TeadToolMaterials.LEAD, new FabricItemSettings()));
    public static final Item LEAD_GREATSWORD = registerItem("lead_greatsword",
            new GreatswordItem(TeadToolMaterials.LEAD,  new FabricItemSettings()));
    public static final Item LEAD_SCYTHE = registerItem("lead_scythe",
            new ScytheItem(TeadToolMaterials.LEAD,  new FabricItemSettings()));
    public static final Item LEAD_SICKLE = registerItem("lead_sickle",
            new SickleItem(TeadToolMaterials.LEAD,  new FabricItemSettings()));
    public static final Item LEAD_CLAYMORE = registerItem("lead_claymore",
            new ClaymoreItem(TeadToolMaterials.LEAD, new FabricItemSettings()));
    public static final Item STEEL_AXE = registerItem("steel_axe",
            new AxeItem(TeadToolMaterials.STEEL, 5.0f, -3.2f,  new FabricItemSettings()));
    public static final Item STEEL_PICKAXE = registerItem("steel_pickaxe",
            new PickaxeItem(TeadToolMaterials.STEEL, 1, -2.9f,  new FabricItemSettings()));
    public static final Item STEEL_SWORD = registerItem("steel_sword",
            new SwordItem(TeadToolMaterials.STEEL, 3, -2.5f,  new FabricItemSettings()));
    public static final Item STEEL_SHOVEL = registerItem("steel_shovel",
            new ShovelItem(TeadToolMaterials.STEEL, 1.5f, -3.0f,  new FabricItemSettings()));
    public static final Item STEEL_HOE = registerItem("steel_hoe",
            new HoeItem(TeadToolMaterials.STEEL, -2, -1.0f,  new FabricItemSettings()));
    public static final Item STEEL_DOUBLE_AXE = registerItem("steel_double_axe",
            new AxeItem(TeadToolMaterials.STEEL, 6.0f, -3.5f,  new FabricItemSettings()));
    public static final Item STEEL_HAMMER = registerItem("steel_hammer",
            new HammerItem(TeadToolMaterials.STEEL,  new FabricItemSettings()));
    public static final Item STEEL_DAGGER = registerItem("steel_dagger",
            new DaggerItem(TeadToolMaterials.STEEL,  new FabricItemSettings()));
    public static final Item STEEL_RAPIER = registerItem("steel_rapier",
            new RapierItem(TeadToolMaterials.STEEL, new FabricItemSettings()));
    public static final Item STEEL_GREATSWORD = registerItem("steel_greatsword",
            new GreatswordItem(TeadToolMaterials.STEEL, new FabricItemSettings()));
    public static final Item STEEL_SCYTHE = registerItem("steel_scythe",
            new ScytheItem(TeadToolMaterials.STEEL,  new FabricItemSettings()));
    public static final Item STEEL_SICKLE = registerItem("steel_sickle",
            new SickleItem(TeadToolMaterials.STEEL,  new FabricItemSettings()));
    public static final Item STEEL_CLAYMORE = registerItem("steel_claymore",
            new ClaymoreItem(TeadToolMaterials.STEEL, new FabricItemSettings()));
    public static final Item ROSE_GOLD_AXE = registerItem("rose_gold_axe",
            new AxeItem(TeadToolMaterials.ROSE_GOLD, 5.0f, -3.2f,  new FabricItemSettings()));
    public static final Item ROSE_GOLD_PICKAXE = registerItem("rose_gold_pickaxe",
            new PickaxeItem(TeadToolMaterials.ROSE_GOLD, 1, -2.9f,  new FabricItemSettings()));
    public static final Item ROSE_GOLD_SWORD = registerItem("rose_gold_sword",
            new SwordItem(TeadToolMaterials.ROSE_GOLD, 3, -2.5f,  new FabricItemSettings()));
    public static final Item ROSE_GOLD_SHOVEL = registerItem("rose_gold_shovel",
            new ShovelItem(TeadToolMaterials.ROSE_GOLD, 1.5f, -3.0f,  new FabricItemSettings()));
    public static final Item ROSE_GOLD_HOE = registerItem("rose_gold_hoe",
            new HoeItem(TeadToolMaterials.ROSE_GOLD, -2, -1.0f,  new FabricItemSettings()));
    public static final Item ROSE_GOLD_DOUBLE_AXE = registerItem("rose_gold_double_axe",
            new AxeItem(TeadToolMaterials.ROSE_GOLD, 6.0f, -3.5f,  new FabricItemSettings()));
    public static final Item ROSE_GOLD_HAMMER = registerItem("rose_gold_hammer",
            new HammerItem(TeadToolMaterials.ROSE_GOLD,  new FabricItemSettings()));
    public static final Item ROSE_GOLD_DAGGER = registerItem("rose_gold_dagger",
            new DaggerItem(TeadToolMaterials.ROSE_GOLD,  new FabricItemSettings()));
    public static final Item ROSE_GOLD_RAPIER = registerItem("rose_gold_rapier",
            new RapierItem(TeadToolMaterials.ROSE_GOLD, new FabricItemSettings()));
    public static final Item ROSE_GOLD_GREATSWORD = registerItem("rose_gold_greatsword",
            new GreatswordItem(TeadToolMaterials.ROSE_GOLD, new FabricItemSettings()));
    public static final Item ROSE_GOLD_SCYTHE = registerItem("rose_gold_scythe",
            new ScytheItem(TeadToolMaterials.ROSE_GOLD,  new FabricItemSettings()));
    public static final Item ROSE_GOLD_SICKLE = registerItem("rose_gold_sickle",
            new SickleItem(TeadToolMaterials.ROSE_GOLD,  new FabricItemSettings()));
    public static final Item ROSE_GOLD_CLAYMORE = registerItem("rose_gold_claymore",
            new ClaymoreItem(TeadToolMaterials.ROSE_GOLD, new FabricItemSettings()));
    public static final Item BRONZE_AXE = registerItem("bronze_axe",
            new AxeItem(TeadToolMaterials.BRONZE, 5.0f, -3.2f,  new FabricItemSettings()));
    public static final Item BRONZE_PICKAXE = registerItem("bronze_pickaxe",
            new PickaxeItem(TeadToolMaterials.BRONZE, 1, -2.9f,  new FabricItemSettings()));
    public static final Item BRONZE_SWORD = registerItem("bronze_sword",
            new SwordItem(TeadToolMaterials.BRONZE, 3, -2.5f,  new FabricItemSettings()));
    public static final Item BRONZE_SHOVEL = registerItem("bronze_shovel",
            new ShovelItem(TeadToolMaterials.BRONZE, 1.5f, -3.0f,  new FabricItemSettings()));
    public static final Item BRONZE_HOE = registerItem("bronze_hoe",
            new HoeItem(TeadToolMaterials.BRONZE, -2, -1.0f,  new FabricItemSettings()));
    public static final Item BRONZE_DOUBLE_AXE = registerItem("bronze_double_axe",
            new AxeItem(TeadToolMaterials.BRONZE, 6.0f, -3.5f,  new FabricItemSettings()));
    public static final Item BRONZE_HAMMER = registerItem("bronze_hammer",
            new HammerItem(TeadToolMaterials.BRONZE,  new FabricItemSettings()));
    public static final Item BRONZE_DAGGER = registerItem("bronze_dagger",
            new DaggerItem(TeadToolMaterials.BRONZE, new FabricItemSettings()));
    public static final Item BRONZE_RAPIER = registerItem("bronze_rapier",
            new RapierItem(TeadToolMaterials.BRONZE, new FabricItemSettings()));
    public static final Item BRONZE_GREATSWORD = registerItem("bronze_greatsword",
            new GreatswordItem(TeadToolMaterials.BRONZE, new FabricItemSettings()));
    public static final Item BRONZE_SCYTHE = registerItem("bronze_scythe",
            new ScytheItem(TeadToolMaterials.BRONZE,  new FabricItemSettings()));
    public static final Item BRONZE_SICKLE = registerItem("bronze_sickle",
            new SickleItem(TeadToolMaterials.BRONZE,  new FabricItemSettings()));
    public static final Item BRONZE_CLAYMORE = registerItem("bronze_claymore",
            new ClaymoreItem(TeadToolMaterials.BRONZE, new FabricItemSettings()));

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

    public static final Item NETHERITE_DOUBLE_AXE = registerItem("netherite_double_axe",
            new AxeItem(ToolMaterials.NETHERITE, 5, -3.3f,  new FabricItemSettings()));
    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer",
            new HammerItem(ToolMaterials.NETHERITE, new FabricItemSettings()));
    public static final Item NETHERITE_DAGGER = registerItem("netherite_dagger",
            new DaggerItem(ToolMaterials.NETHERITE, new FabricItemSettings()));
    public static final Item NETHERITE_RAPIER = registerItem("netherite_rapier",
            new RapierItem(ToolMaterials.NETHERITE, new FabricItemSettings()));
    public static final Item NETHERITE_GREATSWORD = registerItem("netherite_greatsword",
            new GreatswordItem(ToolMaterials.NETHERITE, new FabricItemSettings()));
    public static final Item NETHERITE_SCYTHE = registerItem("netherite_scythe",
            new ScytheItem(ToolMaterials.NETHERITE,  new FabricItemSettings()));
    public static final Item NETHERITE_SICKLE = registerItem("netherite_sickle",
            new SickleItem(ToolMaterials.NETHERITE,  new FabricItemSettings()));
    public static final Item NETHERITE_CLAYMORE = registerItem("netherite_claymore",
            new ClaymoreItem(ToolMaterials.NETHERITE, new FabricItemSettings()));


    public static final Item SWIFTNESS_BOOTS = registerItem("swiftness_boots",
            new SwiftnessArmorItem(TeadArmorMaterials.SWIFTNESS, ArmorItem.Type.BOOTS,
                    new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item STEEL_CHAINMAIL_HELMET = registerItem("steel_chainmail_helmet",
            new ArmorItem(TeadArmorMaterials.STEEL_CHAIN, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item STEEL_CHAINMAIL_CHESTPLATE = registerItem("steel_chainmail_chestplate",
            new ArmorItem(TeadArmorMaterials.STEEL_CHAIN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item STEEL_CHAINMAIL_LEGGINGS = registerItem("steel_chainmail_leggings",
            new ArmorItem(TeadArmorMaterials.STEEL_CHAIN, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item STEEL_CHAINMAIL_BOOTS = registerItem("steel_chainmail_boots",
            new ArmorItem(TeadArmorMaterials.STEEL_CHAIN, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item ROSE_GOLD_CHAINMAIL_HELMET = registerItem("rose_gold_chainmail_helmet",
            new ArmorItem(TeadArmorMaterials.ROSE_GOLD_CHAIN, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ROSE_GOLD_CHAINMAIL_CHESTPLATE = registerItem("rose_gold_chainmail_chestplate",
            new ArmorItem(TeadArmorMaterials.ROSE_GOLD_CHAIN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ROSE_GOLD_CHAINMAIL_LEGGINGS = registerItem("rose_gold_chainmail_leggings",
            new ArmorItem(TeadArmorMaterials.ROSE_GOLD_CHAIN, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item ROSE_GOLD_CHAINMAIL_BOOTS = registerItem("rose_gold_chainmail_boots",
            new ArmorItem(TeadArmorMaterials.ROSE_GOLD_CHAIN, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item BRONZE_CHAINMAIL_HELMET = registerItem("bronze_chainmail_helmet",
            new ArmorItem(TeadArmorMaterials.BRONZE_CHAIN, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item BRONZE_CHAINMAIL_CHESTPLATE = registerItem("bronze_chainmail_chestplate",
            new ArmorItem(TeadArmorMaterials.BRONZE_CHAIN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item BRONZE_CHAINMAIL_LEGGINGS = registerItem("bronze_chainmail_leggings",
            new ArmorItem(TeadArmorMaterials.BRONZE_CHAIN, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item BRONZE_CHAINMAIL_BOOTS = registerItem("bronze_chainmail_boots",
            new ArmorItem(TeadArmorMaterials.BRONZE_CHAIN, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item ROBE_HELMET = registerItem("robe_helmet",
            new RobeArmorItem(TeadArmorMaterials.ROBE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ROBE_CHESTPLATE = registerItem("robe_chestplate",
            new RobeArmorItem(TeadArmorMaterials.ROBE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ROBE_BOOTS = registerItem("robe_boots",
            new RobeArmorItem(TeadArmorMaterials.ROBE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item IRON_STALWART_HELMET = registerItem("iron_stalwart_helmet",
            new StalwartArmorItem(TeadArmorMaterials.IRON_STALWART, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item IRON_STALWART_CHESTPLATE = registerItem("iron_stalwart_chestplate",
            new StalwartArmorItem(TeadArmorMaterials.IRON_STALWART, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item DIAMOND_STALWART_HELMET = registerItem("diamond_stalwart_helmet",
            new StalwartArmorItem(TeadArmorMaterials.DIAMOND_STALWART, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item DIAMOND_STALWART_CHESTPLATE = registerItem("diamond_stalwart_chestplate",
            new StalwartArmorItem(TeadArmorMaterials.DIAMOND_STALWART, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item NETHERITE_STALWART_HELMET = registerItem("netherite_stalwart_helmet",
            new StalwartArmorItem(TeadArmorMaterials.NETHERITE_STALWART, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item NETHERITE_STALWART_CHESTPLATE = registerItem("netherite_stalwart_chestplate",
            new StalwartArmorItem(TeadArmorMaterials.NETHERITE_STALWART, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item IRON_HIGHLAND_HELMET = registerItem("iron_highland_helmet",
            new HighlandDyableArmorItem(TeadArmorMaterials.IRON_HIGHLAND, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item IRON_HIGHLAND_CHESTPLATE = registerItem("iron_highland_chestplate",
            new HighlandDyableArmorItem(TeadArmorMaterials.IRON_HIGHLAND, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item DIAMOND_HIGHLAND_HELMET = registerItem("diamond_highland_helmet",
            new HighlandDyableArmorItem(TeadArmorMaterials.DIAMOND_HIGHLAND, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item DIAMOND_HIGHLAND_CHESTPLATE = registerItem("diamond_highland_chestplate",
            new HighlandDyableArmorItem(TeadArmorMaterials.DIAMOND_HIGHLAND, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item NETHERITE_HIGHLAND_HELMET = registerItem("netherite_highland_helmet",
            new HighlandDyableArmorItem(TeadArmorMaterials.NETHERITE_HIGHLAND, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item NETHERITE_HIGHLAND_CHESTPLATE = registerItem("netherite_highland_chestplate",
            new HighlandDyableArmorItem(TeadArmorMaterials.NETHERITE_HIGHLAND, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item IRON_ROYAL_HELMET = registerItem("iron_royal_helmet",
            new RoyalArmorItem(TeadArmorMaterials.IRON_ROYAL, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item DIAMOND_ROYAL_HELMET = registerItem("diamond_royal_helmet",
            new RoyalArmorItem(TeadArmorMaterials.DIAMOND_ROYAL, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item NETHERITE_ROYAL_HELMET = registerItem("netherite_royal_helmet",
            new RoyalArmorItem(TeadArmorMaterials.NETHERITE_ROYAL, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item IRON_PLATE_HELMET = registerItem("iron_plate_helmet",
            new PlateDyeableArmorItem(TeadArmorMaterials.IRON_PLATE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item IRON_PLATE_CHESTPLATE = registerItem("iron_plate_chestplate",
            new PlateDyeableArmorItem(TeadArmorMaterials.IRON_PLATE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item IRON_PLATE_BOOTS = registerItem("iron_plate_boots",
            new PlateDyeableArmorItem(TeadArmorMaterials.IRON_PLATE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item DIAMOND_PLATE_HELMET = registerItem("diamond_plate_helmet",
            new PlateDyeableArmorItem(TeadArmorMaterials.DIAMOND_PLATE, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item DIAMOND_PLATE_CHESTPLATE = registerItem("diamond_plate_chestplate",
            new PlateDyeableArmorItem(TeadArmorMaterials.DIAMOND_PLATE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item DIAMOND_PLATE_BOOTS = registerItem("diamond_plate_boots",
            new PlateDyeableArmorItem(TeadArmorMaterials.DIAMOND_PLATE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item NETHERITE_PLATE_HELMET = registerItem("netherite_plate_helmet",
            new PlateDyeableArmorItem(TeadArmorMaterials.NETHERITE_PLATE, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item NETHERITE_PLATE_CHESTPLATE = registerItem("netherite_plate_chestplate",
            new PlateDyeableArmorItem(TeadArmorMaterials.NETHERITE_PLATE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item NETHERITE_PLATE_BOOTS = registerItem("netherite_plate_boots",
            new PlateDyeableArmorItem(TeadArmorMaterials.NETHERITE_PLATE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item GOLD_CHAINMAIL_HELMET = registerItem("gold_chainmail_helmet",
            new ArmorItem(TeadArmorMaterials.GOLD_CHAIN, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item GOLD_CHAINMAIL_CHESTPLATE = registerItem("gold_chainmail_chestplate",
            new ArmorItem(TeadArmorMaterials.GOLD_CHAIN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item GOLD_CHAINMAIL_LEGGINGS = registerItem("gold_chainmail_leggings",
            new ArmorItem(TeadArmorMaterials.GOLD_CHAIN, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item GOLD_CHAINMAIL_BOOTS = registerItem("gold_chainmail_boots",
            new ArmorItem(TeadArmorMaterials.GOLD_CHAIN, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item GOLD_REINFORCED_MAIL_HELMET = registerItem("gold_reinforced_mail_helmet",
            new ReinforcedMailArmorItem(TeadArmorMaterials.GOLD_REINFORCED_MAIL, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item GOLD_REINFORCED_MAIL_CHESTPLATE = registerItem("gold_reinforced_mail_chestplate",
            new ReinforcedMailArmorItem(TeadArmorMaterials.GOLD_REINFORCED_MAIL, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item GOLD_STALWART_HELMET = registerItem("gold_stalwart_helmet",
            new StalwartArmorItem(TeadArmorMaterials.GOLD_STALWART, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item GOLD_STALWART_CHESTPLATE = registerItem("gold_stalwart_chestplate",
            new StalwartArmorItem(TeadArmorMaterials.GOLD_STALWART, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item GOLD_SPANGENHELM_HELMET = registerItem("gold_spangenhelm_helmet",
            new SpangenhelmArmorItem(TeadArmorMaterials.GOLD_SPANGENHELM, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item GOLD_HIGHLAND_HELMET = registerItem("gold_highland_helmet",
            new HighlandArmorItem(TeadArmorMaterials.GOLD_HIGHLAND, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item GOLD_HIGHLAND_CHESTPLATE = registerItem("gold_highland_chestplate",
            new HighlandDyableArmorItem(TeadArmorMaterials.GOLD_HIGHLAND, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item GOLD_ROYAL_HELMET = registerItem("gold_royal_helmet",
            new RoyalArmorItem(TeadArmorMaterials.GOLD_ROYAL, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item GOLD_THIEF_HELMET = registerItem("gold_thief_helmet",
            new ThiefDyableArmorItem(TeadArmorMaterials.GOLD_THIEF, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item GOLD_THIEF_CHESTPLATE = registerItem("gold_thief_chestplate",
            new ThiefDyableArmorItem(TeadArmorMaterials.GOLD_THIEF, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item GOLD_GUARD_HELMET = registerItem("gold_guard_helmet",
            new GuardDyableArmorItem(TeadArmorMaterials.GOLD_GUARD, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item GOLD_GUARD_CHESTPLATE = registerItem("gold_guard_chestplate",
            new GuardDyableArmorItem(TeadArmorMaterials.GOLD_GUARD, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item GOLD_MERCENARY_HELMET = registerItem("gold_mercenary_helmet",
            new MercenaryArmorItem(TeadArmorMaterials.GOLD_MERCENARY, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item GOLD_PLATE_HELMET = registerItem("gold_plate_helmet",
            new PlateDyeableArmorItem(TeadArmorMaterials.GOLD_PLATE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item GOLD_PLATE_CHESTPLATE = registerItem("gold_plate_chestplate",
            new PlateDyeableArmorItem(TeadArmorMaterials.GOLD_PLATE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item GOLD_PLATE_BOOTS = registerItem("gold_plate_boots",
            new PlateDyeableArmorItem(TeadArmorMaterials.GOLD_PLATE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item GOLD_GHOSTLY_HELMET = registerItem("gold_ghostly_helmet",
            new GhostlyDyableArmorItem(TeadArmorMaterials.GOLD_GHOSTLY, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item GOLD_GHOSTLY_CHESTPLATE = registerItem("gold_ghostly_chestplate",
            new GhostlyDyableArmorItem(TeadArmorMaterials.GOLD_GHOSTLY, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item GOLD_GHOSTLY_BOOTS = registerItem("gold_ghostly_boots",
            new GhostlyDyableArmorItem(TeadArmorMaterials.GOLD_GHOSTLY, ArmorItem.Type.BOOTS,
                    new FabricItemSettings()));
    public static final Item GOLD_GARMENT_CHESTPLATE = registerItem("gold_garment_chestplate",
            new GarmentArmorItem(TeadArmorMaterials.GOLD_GARMENT, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item GOLD_GARMENT_BOOTS = registerItem("gold_garment_boots",
            new GarmentArmorItem(TeadArmorMaterials.GOLD_GARMENT, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item GOLD_WOOLEN_HELMET = registerItem("gold_woolen_helmet",
            new WoolenDyableArmorItem(TeadArmorMaterials.GOLD_WOOLEN, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item GOLD_WOOLEN_CHESTPLATE = registerItem("gold_woolen_chestplate",
            new WoolenDyableArmorItem(TeadArmorMaterials.GOLD_WOOLEN, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item GOLD_WOOLEN_LEGGINGS = registerItem("gold_woolen_leggings",
            new WoolenDyableArmorItem(TeadArmorMaterials.GOLD_WOOLEN, ArmorItem.Type.LEGGINGS,
                    new FabricItemSettings()));
    public static final Item GOLD_WOOLEN_BOOTS = registerItem("gold_woolen_boots",
            new WoolenDyableArmorItem(TeadArmorMaterials.GOLD_WOOLEN, ArmorItem.Type.BOOTS,
                    new FabricItemSettings()));
    public static final Item COPPER_AXE = registerItem("copper_axe",
            new AxeItem(TeadToolMaterials.COPPER, 5.0f, -3.2f,  new FabricItemSettings()));
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            new PickaxeItem(TeadToolMaterials.COPPER, 1, -2.9f,  new FabricItemSettings()));
    public static final Item COPPER_SWORD = registerItem("copper_sword",
            new SwordItem(TeadToolMaterials.COPPER, 3, -2.5f,  new FabricItemSettings()));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            new ShovelItem(TeadToolMaterials.COPPER, 1.5f, -3.0f,  new FabricItemSettings()));
    public static final Item COPPER_HOE = registerItem("copper_hoe",
            new HoeItem(TeadToolMaterials.COPPER, -2, -1.0f,  new FabricItemSettings()));
    public static final Item COPPER_DOUBLE_AXE = registerItem("copper_double_axe",
            new AxeItem(TeadToolMaterials.COPPER, 6.0f, -3.5f,  new FabricItemSettings()));
    public static final Item COPPER_HAMMER = registerItem("copper_hammer",
            new HammerItem(TeadToolMaterials.COPPER, new FabricItemSettings()));
    public static final Item COPPER_DAGGER = registerItem("copper_dagger",
            new DaggerItem(TeadToolMaterials.COPPER, new FabricItemSettings()));
    public static final Item COPPER_RAPIER = registerItem("copper_rapier",
            new RapierItem(TeadToolMaterials.COPPER, new FabricItemSettings()));
    public static final Item COPPER_GREATSWORD = registerItem("copper_greatsword",
            new GreatswordItem(TeadToolMaterials.COPPER, new FabricItemSettings()));
    public static final Item COPPER_SCYTHE = registerItem("copper_scythe",
            new ScytheItem(TeadToolMaterials.COPPER,  new FabricItemSettings()));
    public static final Item COPPER_SICKLE = registerItem("copper_sickle",
            new SickleItem(TeadToolMaterials.COPPER,  new FabricItemSettings()));
    public static final Item COPPER_CLAYMORE = registerItem("copper_claymore",
            new ClaymoreItem(TeadToolMaterials.COPPER, new FabricItemSettings()));
    public static final Item COPPER_CHAINMAIL_HELMET = registerItem("copper_chainmail_helmet",
            new ArmorItem(TeadArmorMaterials.COPPER_CHAIN, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item COPPER_CHAINMAIL_CHESTPLATE = registerItem("copper_chainmail_chestplate",
            new ArmorItem(TeadArmorMaterials.COPPER_CHAIN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item COPPER_CHAINMAIL_LEGGINGS = registerItem("copper_chainmail_leggings",
            new ArmorItem(TeadArmorMaterials.COPPER_CHAIN, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item COPPER_CHAINMAIL_BOOTS = registerItem("copper_chainmail_boots",
            new ArmorItem(TeadArmorMaterials.COPPER_CHAIN, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item COPPER_HELMET = registerItem("copper_helmet",
            new ArmorItem(TeadArmorMaterials.COPPER, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate",
            new ArmorItem(TeadArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings",
            new ArmorItem(TeadArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item COPPER_BOOTS = registerItem("copper_boots",
            new ArmorItem(TeadArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item COPPER_STALWART_HELMET = registerItem("copper_stalwart_helmet",
            new StalwartArmorItem(TeadArmorMaterials.COPPER_STALWART, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item COPPER_STALWART_CHESTPLATE = registerItem("copper_stalwart_chestplate",
            new StalwartArmorItem(TeadArmorMaterials.COPPER_STALWART, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item COPPER_HIGHLAND_HELMET = registerItem("copper_highland_helmet",
            new HighlandDyableArmorItem(TeadArmorMaterials.COPPER_HIGHLAND, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item COPPER_HIGHLAND_CHESTPLATE = registerItem("copper_highland_chestplate",
            new HighlandDyableArmorItem(TeadArmorMaterials.COPPER_HIGHLAND, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item COPPER_ROYAL_HELMET = registerItem("copper_royal_helmet",
            new RoyalArmorItem(TeadArmorMaterials.COPPER_ROYAL, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item COPPER_PLATE_HELMET = registerItem("copper_plate_helmet",
            new PlateDyeableArmorItem(TeadArmorMaterials.COPPER_PLATE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item COPPER_PLATE_CHESTPLATE = registerItem("copper_plate_chestplate",
            new PlateDyeableArmorItem(TeadArmorMaterials.COPPER_PLATE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item COPPER_PLATE_BOOTS = registerItem("copper_plate_boots",
            new PlateDyeableArmorItem(TeadArmorMaterials.COPPER_PLATE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

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

    // Music Discs
    public static final Item MUSIC_DISC_BATTLE_HYMN = registerItem("music_disc_battle_hymn",
            new MusicDiscItem(0, TeadSounds.BATTLE_HYMN, new FabricItemSettings().maxCount(1),
                    418));
    public static final Item MUSIC_DISC_DAY_ONE = registerItem("music_disc_day_one",
            new MusicDiscItem(1, TeadSounds.DAY_ONE, new FabricItemSettings().maxCount(1),
                    201));
    public static final Item MUSIC_DISC_HAIL_AND_KILL = registerItem("music_disc_hail_and_kill",
            new MusicDiscItem(2, TeadSounds.HAIL_AND_KILL, new FabricItemSettings().maxCount(1),
                    357));
    public static final Item MUSIC_DISC_HOMELAND = registerItem("music_disc_homeland",
            new MusicDiscItem(3, TeadSounds.HOMELAND, new FabricItemSettings().maxCount(1),
                    221));
    public static final Item MUSIC_DISC_LORD_GIVE_ME_A_SIGN = registerItem("music_disc_lord_give_me_a_sign",
            new MusicDiscItem(4, TeadSounds.LORD_GIVE_ME_A_SIGN, new FabricItemSettings().maxCount(1),
                    212));
    public static final Item MUSIC_DISC_LOSE_YOURSELF = registerItem("music_disc_lose_yourself",
            new MusicDiscItem(5, TeadSounds.LOSE_YOURSELF, new FabricItemSettings().maxCount(1),
                    323));
    public static final Item MUSIC_DISC_MUTINY = registerItem("music_disc_mutiny",
            new MusicDiscItem(6, TeadSounds.MUTINY, new FabricItemSettings().maxCount(1),
                    537));
    public static final Item MUSIC_DISC_NEVER_GONNA_GIVE_YOU_UP = registerItem(
            "music_disc_never_gonna_give_you_up", new MusicDiscItem(7,
                    TeadSounds.NEVER_GONNA_GIVE_YOU_UP, new FabricItemSettings().maxCount(1), 212));
    public static final Item MUSIC_DISC_NEVER_GONNA_STOP = registerItem("music_disc_never_gonna_stop",
            new MusicDiscItem(8, TeadSounds.NEVER_GONNA_STOP, new FabricItemSettings().maxCount(1),
                    200));
    public static final Item MUSIC_DISC_SWORDS_IN_THE_WIND = registerItem("music_disc_swords_in_the_wind",
            new MusicDiscItem(9, TeadSounds.SWORD_IN_THE_WIND, new FabricItemSettings().maxCount(1),
                    349));
    public static final Item MUSIC_DISC_THE_GODFATHER = registerItem("music_disc_the_godfather",
            new MusicDiscItem(10, TeadSounds.THE_GODFATHER, new FabricItemSettings().maxCount(1),
                    165));
    public static final Item MUSIC_DISC_THE_HEART_ASKS_PLEASURE_FIRST =
            registerItem("music_disc_the_heart_asks_pleasure_first", new MusicDiscItem(11,
                    TeadSounds.THE_HEART_ASKS_PLEASURE_FIRST, new FabricItemSettings().maxCount(1), 190));
    public static final Item MUSIC_DISC_THE_PHANTOM_OF_THE_OPERA = registerItem(
            "music_disc_the_phantom_of_the_opera", new MusicDiscItem(12,
                    TeadSounds.THE_PHANTOM_OF_THE_OPERA, new FabricItemSettings().maxCount(1), 216));
    public static final Item MUSIC_DISC_TILL_I_COLLAPSE = registerItem("music_disc_till_i_collapse",
            new MusicDiscItem(13, TeadSounds.TILL_I_COLLAPSE, new FabricItemSettings().maxCount(1),
                    297));
    public static final Item MUSIC_DISC_TIME = registerItem("music_disc_time",
            new MusicDiscItem(14, TeadSounds.TIME, new FabricItemSettings().maxCount(1),
                    275));
    public static final Item MUSIC_DISC_UNTOUCHABLE = registerItem("music_disc_untouchable",
            new MusicDiscItem(15, TeadSounds.UNTOUCHABLE, new FabricItemSettings().maxCount(1),
                    365));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Tead.MOD_ID, name), item);
    }

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

    public static void registerItems() {
        Tead.LOGGER.info("Registering mod items for " + Tead.MOD_ID);
    }
}
