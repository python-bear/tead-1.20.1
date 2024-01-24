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
    public static final Item LEAD_BULLET = registerItem("lead_bullet", new Item(new FabricItemSettings()));
    public static final Item GRENADE = registerItem("grenade", new GrenadeItem(new FabricItemSettings()));
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
    public static final Item WOOD_DOUBLE_AXE = registerItem("wood_double_axe",
            new AxeItem(ToolMaterials.WOOD, 6.2f, -3.5f,  new FabricItemSettings()));
    public static final Item WOOD_HAMMER = registerItem("wood_hammer",
            new HammerItem(ToolMaterials.WOOD, 1, -2.7f,  new FabricItemSettings()));
    public static final Item WOOD_DAGGER = registerItem("wood_dagger",
            new DaggerItem(ToolMaterials.WOOD, 1.5f, -2.4f,  new FabricItemSettings()));
    public static final Item WOOD_SICKLE = registerItem("wood_sickle",
            new SickleItem(ToolMaterials.WOOD, 1.5f, -2.4f,  new FabricItemSettings()));
    public static final Item STONE_DOUBLE_AXE = registerItem("stone_double_axe",
            new AxeItem(ToolMaterials.STONE, 7.2f, -3.5f,  new FabricItemSettings()));
    public static final Item STONE_HAMMER = registerItem("stone_hammer",
            new HammerItem(ToolMaterials.STONE, 2, -3.1f,  new FabricItemSettings()));
    public static final Item STONE_DAGGER = registerItem("stone_dagger",
            new DaggerItem(ToolMaterials.STONE, 1.5f, -1f,  new FabricItemSettings()));
    public static final Item STONE_SICKLE = registerItem("stone_sickle",
            new SickleItem(ToolMaterials.STONE, 0.5f, -1f,  new FabricItemSettings()));
    public static final Item GOLD_DOUBLE_AXE = registerItem("gold_double_axe",
            new AxeItem(ToolMaterials.GOLD, 6.5f, -3.3f,  new FabricItemSettings()));
    public static final Item GOLD_HAMMER = registerItem("gold_hammer",
            new HammerItem(ToolMaterials.GOLD, 2, -3.1f,  new FabricItemSettings()));
    public static final Item GOLD_DAGGER = registerItem("gold_dagger",
            new DaggerItem(ToolMaterials.GOLD, 2.5f, -1f,  new FabricItemSettings()));
    public static final Item GOLD_SICKLE = registerItem("gold_sickle",
            new SickleItem(ToolMaterials.GOLD, 1.5f, -1f,  new FabricItemSettings()));
    public static final Item GOLD_CLAYMORE = registerItem("gold_claymore",
            new ClaymoreItem(ToolMaterials.GOLD, 3, -2.4f,  new FabricItemSettings()));
    public static final Item LEAD_DOUBLE_AXE = registerItem("lead_double_axe",
            new AxeItem(TeadToolMaterials.LEAD, 6.0f, -3.5f,  new FabricItemSettings()));
    public static final Item LEAD_HAMMER = registerItem("lead_hammer",
            new HammerItem(TeadToolMaterials.LEAD, 1, -3.2f,  new FabricItemSettings()));
    public static final Item LEAD_DAGGER = registerItem("lead_dagger",
            new DaggerItem(TeadToolMaterials.LEAD, 1.5f, -1f,  new FabricItemSettings()));
    public static final Item LEAD_SICKLE = registerItem("lead_sickle",
            new SickleItem(TeadToolMaterials.LEAD, 1.5f, -1f,  new FabricItemSettings()));
    public static final Item LEAD_CLAYMORE = registerItem("lead_claymore",
            new ClaymoreItem(TeadToolMaterials.LEAD, 3, -2.5f,  new FabricItemSettings()));
    public static final Item IRON_DOUBLE_AXE = registerItem("iron_double_axe",
            new AxeItem(ToolMaterials.IRON, 6.5f, -3.4f,  new FabricItemSettings()));
    public static final Item IRON_HAMMER = registerItem("iron_hammer",
            new HammerItem(ToolMaterials.IRON, 2, -3.1f,  new FabricItemSettings()));
    public static final Item IRON_DAGGER = registerItem("iron_dagger",
            new DaggerItem(ToolMaterials.IRON, 1.5f, -1f,  new FabricItemSettings()));
    public static final Item IRON_SICKLE = registerItem("iron_sickle",
            new SickleItem(ToolMaterials.IRON, 1.5f, -1f,  new FabricItemSettings()));
    public static final Item IRON_TEMPEST_KNIFE = registerItem("iron_tempest_knife",
            new BladedWeaponItem(ToolMaterials.IRON, 2.7f, -1.6f,  new FabricItemSettings(),
                    false));
    public static final Item IRON_CLAYMORE = registerItem("iron_claymore",
            new ClaymoreItem(ToolMaterials.IRON, 3, -2.4f,  new FabricItemSettings()));
    public static final Item DIAMOND_DOUBLE_AXE = registerItem("diamond_double_axe",
            new AxeItem(ToolMaterials.DIAMOND, 5.7f, -3.3f,  new FabricItemSettings()));
    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer",
            new HammerItem(ToolMaterials.DIAMOND, 2, -3.1f,  new FabricItemSettings()));
    public static final Item DIAMOND_DAGGER = registerItem("diamond_dagger",
            new DaggerItem(ToolMaterials.DIAMOND, 1.5f, -1f,  new FabricItemSettings()));
    public static final Item DIAMOND_SICKLE = registerItem("diamond_sickle",
            new SickleItem(ToolMaterials.DIAMOND, 1.5f, -1f,  new FabricItemSettings()));
    public static final Item DIAMOND_CLAYMORE = registerItem("diamond_claymore",
            new ClaymoreItem(ToolMaterials.DIAMOND, 3, -2.4f,  new FabricItemSettings()));
    public static final Item NETHERITE_DOUBLE_AXE = registerItem("netherite_double_axe",
            new AxeItem(ToolMaterials.NETHERITE, 5, -3.3f,  new FabricItemSettings()));
    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer",
            new HammerItem(ToolMaterials.DIAMOND, 2, -3.1f,  new FabricItemSettings()));
    public static final Item NETHERITE_DAGGER = registerItem("netherite_dagger",
            new DaggerItem(ToolMaterials.DIAMOND, 1.5f, -1f,  new FabricItemSettings()));
    public static final Item NETHERITE_SICKLE = registerItem("netherite_sickle",
            new SickleItem(ToolMaterials.DIAMOND, 1.5f, -1f,  new FabricItemSettings()));
    public static final Item NETHERITE_CLAYMORE = registerItem("netherite_claymore",
            new ClaymoreItem(ToolMaterials.NETHERITE, 4, -2.4f,  new FabricItemSettings()));
    public static final Item CORAL_DAGGER = registerItem("coral_dagger",
            new DaggerItem(TeadToolMaterials.CORAL, 1.5f, -1f,  new FabricItemSettings()));
    public static final Item OBSIDIAN_SWORD = registerItem("obsidian_sword",
            new SwordItem(TeadToolMaterials.OBSIDIAN, 4, -2.5f,  new FabricItemSettings()));
    public static final Item OBSIDIAN_CLAYMORE = registerItem("obsidian_claymore",
            new ClaymoreItem(TeadToolMaterials.OBSIDIAN, 4, -2.5f,  new FabricItemSettings()));
    public static final Item BATTLE_STAFF = registerItem("battle_staff",
            new StaffItem(ToolMaterials.WOOD, 4.5f, -1.8f, 1, 0.9f,
                    new FabricItemSettings()));
    public static final Item BONE_CLUB = registerItem("bone_club",
            new StaffItem(TeadToolMaterials.BONE, 3.8f, -2.4f, 1.3f,
                    0.5f, new FabricItemSettings()));
    public static final Item QUARTERSTAFF = registerItem("quarterstaff",
            new StaffItem(ToolMaterials.WOOD, 4, -1.9f, 0.7f, 0.7f,
                    new FabricItemSettings()));
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
    public static final Item GOLD_CHAINMAIL_HELMET = registerItem("gold_chainmail_helmet",
            new ArmorItem(TeadArmorMaterials.GOLD_CHAIN, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item GOLD_CHAINMAIL_CHESTPLATE = registerItem("gold_chainmail_chestplate",
            new ArmorItem(TeadArmorMaterials.GOLD_CHAIN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item GOLD_CHAINMAIL_LEGGINGS = registerItem("gold_chainmail_leggings",
            new ArmorItem(TeadArmorMaterials.GOLD_CHAIN, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item GOLD_CHAINMAIL_BOOTS = registerItem("gold_chainmail_boots",
            new ArmorItem(TeadArmorMaterials.GOLD_CHAIN, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item ROBE_HELMET = registerItem("robe_helmet",
            new RobeArmorItem(TeadArmorMaterials.ROBE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ROBE_CHESTPLATE = registerItem("robe_chestplate",
            new RobeArmorItem(TeadArmorMaterials.ROBE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ROBE_BOOTS = registerItem("robe_boots",
            new RobeArmorItem(TeadArmorMaterials.ROBE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item GOLD_STALWART_HELMET = registerItem("gold_stalwart_helmet",
            new StalwartArmorItem(TeadArmorMaterials.GOLD_STALWART, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item IRON_STALWART_HELMET = registerItem("iron_stalwart_helmet",
            new StalwartArmorItem(TeadArmorMaterials.IRON_STALWART, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item DIAMOND_STALWART_HELMET = registerItem("diamond_stalwart_helmet",
            new StalwartArmorItem(TeadArmorMaterials.DIAMOND_STALWART, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item NETHERITE_STALWART_HELMET = registerItem("netherite_stalwart_helmet",
            new StalwartArmorItem(TeadArmorMaterials.NETHERITE_STALWART, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item GOLD_HIGHLAND_HELMET = registerItem("gold_highland_helmet",
            new HighlandArmorItem(TeadArmorMaterials.GOLD_HIGHLAND, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item IRON_HIGHLAND_HELMET = registerItem("iron_highland_helmet",
            new HighlandArmorItem(TeadArmorMaterials.IRON_HIGHLAND, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item DIAMOND_HIGHLAND_HELMET = registerItem("diamond_highland_helmet",
            new HighlandArmorItem(TeadArmorMaterials.DIAMOND_HIGHLAND, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item NETHERITE_HIGHLAND_HELMET = registerItem("netherite_highland_helmet",
            new HighlandArmorItem(TeadArmorMaterials.NETHERITE_HIGHLAND, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item GOLD_ROYAL_HELMET = registerItem("gold_royal_helmet",
            new RoyalArmorItem(TeadArmorMaterials.GOLD_ROYAL, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item IRON_ROYAL_HELMET = registerItem("iron_royal_helmet",
            new RoyalArmorItem(TeadArmorMaterials.IRON_ROYAL, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item DIAMOND_ROYAL_HELMET = registerItem("diamond_royal_helmet",
            new RoyalArmorItem(TeadArmorMaterials.DIAMOND_ROYAL, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item NETHERITE_ROYAL_HELMET = registerItem("netherite_royal_helmet",
            new RoyalArmorItem(TeadArmorMaterials.NETHERITE_ROYAL, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item GOLD_PLATE_HELMET = registerItem("gold_plate_helmet",
            new PlateArmorItem(TeadArmorMaterials.GOLD_PLATE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item GOLD_PLATE_CHESTPLATE = registerItem("gold_plate_chestplate",
            new PlateArmorItem(TeadArmorMaterials.GOLD_PLATE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item GOLD_PLATE_BOOTS = registerItem("gold_plate_boots",
            new PlateArmorItem(TeadArmorMaterials.GOLD_PLATE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item IRON_PLATE_HELMET = registerItem("iron_plate_helmet",
            new PlateArmorItem(TeadArmorMaterials.IRON_PLATE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item IRON_PLATE_CHESTPLATE = registerItem("iron_plate_chestplate",
            new PlateArmorItem(TeadArmorMaterials.IRON_PLATE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item IRON_PLATE_BOOTS = registerItem("iron_plate_boots",
            new PlateArmorItem(TeadArmorMaterials.IRON_PLATE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item DIAMOND_PLATE_HELMET = registerItem("diamond_plate_helmet",
            new PlateArmorItem(TeadArmorMaterials.DIAMOND_PLATE, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item DIAMOND_PLATE_CHESTPLATE = registerItem("diamond_plate_chestplate",
            new PlateArmorItem(TeadArmorMaterials.DIAMOND_PLATE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item DIAMOND_PLATE_BOOTS = registerItem("diamond_plate_boots",
            new PlateArmorItem(TeadArmorMaterials.DIAMOND_PLATE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item NETHERITE_PLATE_HELMET = registerItem("netherite_plate_helmet",
            new PlateArmorItem(TeadArmorMaterials.NETHERITE_PLATE, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item NETHERITE_PLATE_CHESTPLATE = registerItem("netherite_plate_chestplate",
            new PlateArmorItem(TeadArmorMaterials.NETHERITE_PLATE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item NETHERITE_PLATE_BOOTS = registerItem("netherite_plate_boots",
            new PlateArmorItem(TeadArmorMaterials.NETHERITE_PLATE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
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
