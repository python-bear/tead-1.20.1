package net.pythonbear.tead.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.item.*;
import net.pythonbear.tead.item.arrow.*;
import net.pythonbear.tead.sound.TeadSounds;

public class TeadItems {
    public static final Item FABRIC = registerItem("fabric", new Item(new FabricItemSettings()));
    public static final Item ROCK = registerItem("rock", new Item(new FabricItemSettings()));
    public static final Item SLATE = registerItem("slate", new Item(new FabricItemSettings()));
    public static final Item BLACK_ROCK = registerItem("black_rock", new Item(new FabricItemSettings()));
    public static final Item MUDDY_CLAY_BALL = registerItem("muddy_clay_ball",
            new Item(new FabricItemSettings()));
    public static final Item DARK_BRICK = registerItem("dark_brick", new Item(new FabricItemSettings()));
    public static final Item JERKY = registerItem("jerky", new Item(new FabricItemSettings()
            .food(TeadFoodComponents.JERKY)));
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item HANDLE = registerItem("handle", new Item(new FabricItemSettings()));
    public static final Item OBSIDIAN_SHARD = registerItem("obsidian_shard", new Item(new FabricItemSettings()));
    public static final Item GALENA = registerItem("galena", new Item(new FabricItemSettings()));
    public static final Item LEAD_INGOT = registerItem("lead_ingot", new Item(new FabricItemSettings()));
    public static final Item LEAD_NUGGET = registerItem("lead_nugget", new Item(new FabricItemSettings()));
    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new FabricItemSettings()));
    public static final Item STEEL_NUGGET = registerItem("steel_nugget", new Item(new FabricItemSettings()));
    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot", new Item(new FabricItemSettings()));
    public static final Item ROSE_GOLD_NUGGET = registerItem("rose_gold_nugget", new Item(new FabricItemSettings()));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot", new Item(new FabricItemSettings()));
    public static final Item BRONZE_NUGGET = registerItem("bronze_nugget", new Item(new FabricItemSettings()));
    public static final Item COPPER_NUGGET = registerItem("copper_nugget", new Item(new FabricItemSettings()));
    public static final Item LEAD_BULLET = registerItem("lead_bullet", new Item(new FabricItemSettings()));
    public static final Item SHOTGUN_PROJECTILE = registerItem("shotgun_projectile",
            new Item(new FabricItemSettings()));
    public static final Item GRENADE = registerItem("grenade", new GrenadeItem(new FabricItemSettings()));
    public static final Item SHURIKEN = registerItem("shuriken", new ShurikenItem(new FabricItemSettings()));
    public static final Item LIGHTNING_STAFF = registerItem("lightning_staff",
            new LightningStaffItem(new FabricItemSettings().maxCount(1).maxDamage(64)));
    public static final Item LEAD_APPLE = registerItem("lead_apple", new Item(new FabricItemSettings()
            .food(TeadFoodComponents.LEAD_APPLE)));
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
            new GreatSwordItem(TeadToolMaterials.LEAD,  new FabricItemSettings()));
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
            new GreatSwordItem(TeadToolMaterials.STEEL, new FabricItemSettings()));
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
            new GreatSwordItem(TeadToolMaterials.ROSE_GOLD, new FabricItemSettings()));
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
            new GreatSwordItem(TeadToolMaterials.BRONZE, new FabricItemSettings()));
    public static final Item BRONZE_SCYTHE = registerItem("bronze_scythe",
            new ScytheItem(TeadToolMaterials.BRONZE,  new FabricItemSettings()));
    public static final Item BRONZE_SICKLE = registerItem("bronze_sickle",
            new SickleItem(TeadToolMaterials.BRONZE,  new FabricItemSettings()));
    public static final Item BRONZE_CLAYMORE = registerItem("bronze_claymore",
            new ClaymoreItem(TeadToolMaterials.BRONZE, new FabricItemSettings()));
    public static final Item WOOD_DOUBLE_AXE = registerItem("wood_double_axe",
            new AxeItem(ToolMaterials.WOOD, 6.2f, -3.5f,  new FabricItemSettings()));
    public static final Item WOOD_HAMMER = registerItem("wood_hammer",
            new HammerItem(ToolMaterials.WOOD,  new FabricItemSettings()));
    public static final Item WOOD_DAGGER = registerItem("wood_dagger",
            new DaggerItem(ToolMaterials.WOOD, new FabricItemSettings()));
    public static final Item WOOD_RAPIER = registerItem("wood_rapier",
            new RapierItem(ToolMaterials.WOOD, new FabricItemSettings()));
    public static final Item WOOD_SCYTHE = registerItem("wood_scythe",
            new ScytheItem(ToolMaterials.WOOD,  new FabricItemSettings()));
    public static final Item WOOD_SICKLE = registerItem("wood_sickle",
            new SickleItem(ToolMaterials.WOOD,  new FabricItemSettings()));
    public static final Item STONE_DOUBLE_AXE = registerItem("stone_double_axe",
            new AxeItem(ToolMaterials.STONE, 7.2f, -3.5f,  new FabricItemSettings()));
    public static final Item STONE_HAMMER = registerItem("stone_hammer",
            new HammerItem(ToolMaterials.STONE,  new FabricItemSettings()));
    public static final Item STONE_DAGGER = registerItem("stone_dagger",
            new DaggerItem(ToolMaterials.STONE, new FabricItemSettings()));
    public static final Item STONE_RAPIER = registerItem("stone_rapier",
            new RapierItem(ToolMaterials.STONE, new FabricItemSettings()));
    public static final Item STONE_GREATSWORD = registerItem("stone_greatsword",
            new GreatSwordItem(ToolMaterials.STONE, new FabricItemSettings()));
    public static final Item STONE_SCYTHE = registerItem("stone_scythe",
            new ScytheItem(ToolMaterials.STONE, new FabricItemSettings()));
    public static final Item STONE_SICKLE = registerItem("stone_sickle",
            new SickleItem(ToolMaterials.STONE, new FabricItemSettings()));
    public static final Item GOLD_HATCHET = registerItem("gold_hatchet",
            new HatchetItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_DOUBLE_AXE = registerItem("gold_double_axe",
            new DoubleAxeItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_DOUBLE_HIGHLAND_AXE = registerItem("gold_double_highland_axe",
            new HighlandDoubleAxeItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_HIGHLAND_AXE = registerItem("gold_highland_axe",
            new HighlandAxeItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_HAMMER = registerItem("gold_hammer",
            new HammerItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_MOUNTAINEER_PICK = registerItem("gold_mountaineer_pick",
            new MountaineerPickItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_MATTOCK = registerItem("gold_mattock",
            new MattockItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_MACE = registerItem("gold_mace",
            new MaceItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_DAGGER = registerItem("gold_dagger",
            new DaggerItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_HOLLOW_DAGGER = registerItem("gold_hollow_dagger",
            new HollowDaggerItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_RITE_DAGGER = registerItem("gold_rite_dagger",
            new RiteDaggerItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_CRESCENT_DAGGER = registerItem("gold_crescent_dagger",
            new CrescentDaggerItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_TRUTHSEEKER = registerItem("gold_truthseeker",
            new TruthseekerItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_TEMPEST_KNIFE = registerItem("gold_tempest_knife",
            new TempestKnifeItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_CUTLASS = registerItem("gold_cutlass",
            new CutlassItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_RAPIER = registerItem("gold_rapier",
            new RapierItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_KATANA = registerItem("gold_katana",
            new KatanaItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_GREATSWORD = registerItem("gold_greatsword",
            new GreatSwordItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_BROADSWORD = registerItem("gold_broadsword",
            new BroadswordItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_LONGSWORD = registerItem("gold_longsword",
            new LongswordItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_CLAYMORE = registerItem("gold_claymore",
            new ClaymoreItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_SCYTHE = registerItem("gold_scythe",
            new ScytheItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_SICKLE = registerItem("gold_sickle",
            new SickleItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_SPEAR = registerItem("gold_spear",
            new SpearItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_RANSEUR = registerItem("gold_ranseur",
            new RanseurItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_GLAIVE = registerItem("gold_glaive",
            new GlaiveItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item GOLD_POWER_BOW = registerItem("gold_power_bow",
            new PowerBowItem(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item IRON_DOUBLE_AXE = registerItem("iron_double_axe",
            new AxeItem(ToolMaterials.IRON, 6.5f, -3.4f,  new FabricItemSettings()));
    public static final Item IRON_HAMMER = registerItem("iron_hammer",
            new HammerItem(ToolMaterials.IRON,  new FabricItemSettings()));
    public static final Item IRON_DAGGER = registerItem("iron_dagger",
            new DaggerItem(ToolMaterials.IRON, new FabricItemSettings()));
    public static final Item IRON_RAPIER = registerItem("iron_rapier",
            new RapierItem(ToolMaterials.IRON, new FabricItemSettings()));
    public static final Item IRON_GREATSWORD = registerItem("iron_greatsword",
            new GreatSwordItem(ToolMaterials.IRON, new FabricItemSettings()));
    public static final Item IRON_SCYTHE = registerItem("iron_scythe",
            new ScytheItem(ToolMaterials.IRON,  new FabricItemSettings()));
    public static final Item IRON_SICKLE = registerItem("iron_sickle",
            new SickleItem(ToolMaterials.IRON,  new FabricItemSettings()));
    public static final Item IRON_TEMPEST_KNIFE = registerItem("iron_tempest_knife",
            new BladedWeaponItem(ToolMaterials.IRON, 2.7f, -1.6f, 0,
                    0, 0, 0,  1.5f, false,
                    new FabricItemSettings()));
    public static final Item IRON_CLAYMORE = registerItem("iron_claymore",
            new ClaymoreItem(ToolMaterials.IRON, new FabricItemSettings()));
    public static final Item DIAMOND_DOUBLE_AXE = registerItem("diamond_double_axe",
            new AxeItem(ToolMaterials.DIAMOND, 5.7f, -3.3f,  new FabricItemSettings()));
    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer",
            new HammerItem(ToolMaterials.DIAMOND, new FabricItemSettings()));
    public static final Item DIAMOND_DAGGER = registerItem("diamond_dagger",
            new DaggerItem(ToolMaterials.DIAMOND, new FabricItemSettings()));
    public static final Item DIAMOND_RAPIER = registerItem("diamond_rapier",
            new RapierItem(ToolMaterials.DIAMOND, new FabricItemSettings()));
    public static final Item DIAMOND_GREATSWORD = registerItem("diamond_greatsword",
            new GreatSwordItem(ToolMaterials.DIAMOND, new FabricItemSettings()));
    public static final Item DIAMOND_SCYTHE = registerItem("diamond_scythe",
            new ScytheItem(ToolMaterials.DIAMOND,  new FabricItemSettings()));
    public static final Item DIAMOND_SICKLE = registerItem("diamond_sickle",
            new SickleItem(ToolMaterials.DIAMOND,  new FabricItemSettings()));
    public static final Item DIAMOND_CLAYMORE = registerItem("diamond_claymore",
            new ClaymoreItem(ToolMaterials.DIAMOND, new FabricItemSettings()));
    public static final Item NETHERITE_DOUBLE_AXE = registerItem("netherite_double_axe",
            new AxeItem(ToolMaterials.NETHERITE, 5, -3.3f,  new FabricItemSettings()));
    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer",
            new HammerItem(ToolMaterials.NETHERITE, new FabricItemSettings()));
    public static final Item NETHERITE_DAGGER = registerItem("netherite_dagger",
            new DaggerItem(ToolMaterials.NETHERITE, new FabricItemSettings()));
    public static final Item NETHERITE_RAPIER = registerItem("netherite_rapier",
            new RapierItem(ToolMaterials.NETHERITE, new FabricItemSettings()));
    public static final Item NETHERITE_GREATSWORD = registerItem("netherite_greatsword",
            new GreatSwordItem(ToolMaterials.NETHERITE, new FabricItemSettings()));
    public static final Item NETHERITE_SCYTHE = registerItem("netherite_scythe",
            new ScytheItem(ToolMaterials.NETHERITE,  new FabricItemSettings()));
    public static final Item NETHERITE_SICKLE = registerItem("netherite_sickle",
            new SickleItem(ToolMaterials.NETHERITE,  new FabricItemSettings()));
    public static final Item NETHERITE_CLAYMORE = registerItem("netherite_claymore",
            new ClaymoreItem(ToolMaterials.NETHERITE, new FabricItemSettings()));
    public static final Item CORAL_DAGGER = registerItem("coral_dagger",
            new DaggerItem(TeadToolMaterials.CORAL, new FabricItemSettings()));
    public static final Item OBSIDIAN_SWORD = registerItem("obsidian_sword",
            new SwordItem(TeadToolMaterials.OBSIDIAN, 4, -2.5f,  new FabricItemSettings()));
    public static final Item OBSIDIAN_CLAYMORE = registerItem("obsidian_claymore",
            new ClaymoreItem(TeadToolMaterials.OBSIDIAN, new FabricItemSettings()));
    public static final Item BATTLE_STAFF = registerItem("battle_staff",
            new StaffItem(ToolMaterials.WOOD, 4.5f, -1.8f, 1, 0.9f,
                    new FabricItemSettings()));
    public static final Item BONE_CLUB = registerItem("bone_club",
            new StaffItem(TeadToolMaterials.BONE, 1.8f, -2.4f, 1.3f,
                    0.5f, new FabricItemSettings()));
    public static final Item QUARTERSTAFF = registerItem("quarterstaff",
            new StaffItem(ToolMaterials.WOOD, 3, -1.9f, 0.7f, 0.7f,
                    new FabricItemSettings()));
    public static final Item SHOTGUN = registerItem("shotgun",
            new ShotgunItem(new FabricItemSettings().maxDamage(325)));
    public static final Item BONE_BOW = registerItem("bone_bow",
            new BoneBowItem(new FabricItemSettings().maxDamage(415)));
    public static final Item WIND_BOW = registerItem("wind_bow",
            new WindBowItem(new FabricItemSettings().maxDamage(432)));
    public static final Item TRICK_BOW = registerItem("trick_bow",
            new TrickBowItem(new FabricItemSettings().maxDamage(432)));
    public static final Item SHORT_BOW = registerItem("short_bow",
            new ShortBowItem(new FabricItemSettings().maxDamage(384)));
    public static final Item LONG_BOW = registerItem("long_bow",
            new LongBowItem(new FabricItemSettings().maxDamage(384)));
    public static final Item FIREBOLT_THROWER = registerItem("firebolt_thrower",
            new FireboltThrower(new FabricItemSettings().maxDamage(427)));
    public static final Item SWIFTNESS_BOOTS = registerItem("swiftness_boots",
            new SwiftnessArmorItem(TeadArmorMaterials.SWIFTNESS, ArmorItem.Type.BOOTS, new FabricItemSettings()));
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
            new GreatSwordItem(TeadToolMaterials.COPPER, new FabricItemSettings()));
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
    public static void registerItems() {
        Tead.LOGGER.info("Registering mod items for " + Tead.MOD_ID);

//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(TeadItems::addItemsToIngredientItemGroup);
    }
}
