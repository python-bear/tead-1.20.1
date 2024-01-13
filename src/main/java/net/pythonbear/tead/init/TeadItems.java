package net.pythonbear.tead.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.item.LightningStaffItem;
import net.pythonbear.tead.item.TeadFoodComponents;
import net.pythonbear.tead.sound.TeadSounds;

public class TeadItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item OBSIDIAN_SHARD = registerItem("obsidian_shard", new Item(new FabricItemSettings()));
    public static final Item GALENA = registerItem("galena", new Item(new FabricItemSettings()));
    public static final Item LEAD_INGOT = registerItem("lead_ingot", new Item(new FabricItemSettings()));
    public static final Item LEAD_NUGGET = registerItem("lead_nugget", new Item(new FabricItemSettings()));
    public static final Item LEAD_BULLET = registerItem("lead_bullet", new Item(new FabricItemSettings()));
    public static final Item AMETHYST_ARROW = registerItem("amethyst_arrow", new Item(new FabricItemSettings()));
    public static final Item EXPLOSIVE_ARROW = registerItem("explosive_arrow", new Item(new FabricItemSettings()));
    public static final Item LIGHTNING_ARROW = registerItem("lightning_arrow", new Item(new FabricItemSettings()));
    public static final Item OBSIDIAN_ARROW = registerItem("obsidian_arrow", new Item(new FabricItemSettings()));
    public static final Item RUBY_ARROW = registerItem("ruby_arrow", new Item(new FabricItemSettings()));
    public static final Item LIGHTNING_STAFF = registerItem("lightning_staff",
            new LightningStaffItem(new FabricItemSettings().maxCount(1).maxDamage(64)));
    public static final Item LEAD_APPLE = registerItem("lead_apple", new Item(new FabricItemSettings()
            .food(TeadFoodComponents.LEAD_APPLE)));
    public static final Item LEAD_AXE = registerItem("lead_axe",
            new AxeItem(TeadToolMaterial.LEAD, 5.0f, -3.2f,  new FabricItemSettings()));
    public static final Item LEAD_PICKAXE = registerItem("lead_pickaxe",
            new PickaxeItem(TeadToolMaterial.LEAD, 1, -2.9f,  new FabricItemSettings()));
    public static final Item LEAD_SWORD = registerItem("lead_sword",
            new SwordItem(TeadToolMaterial.LEAD, 3, -2.5f,  new FabricItemSettings()));
    public static final Item LEAD_SHOVEL = registerItem("lead_shovel",
            new ShovelItem(TeadToolMaterial.LEAD, 1.5f, -3.0f,  new FabricItemSettings()));
    public static final Item LEAD_HOE = registerItem("lead_hoe",
            new HoeItem(TeadToolMaterial.LEAD, -2, -1.0f,  new FabricItemSettings()));
    public static final Item WOOD_DOUBLE_AXE = registerItem("wood_double_axe",
            new AxeItem(ToolMaterials.WOOD, 6.2f, -3.4f,  new FabricItemSettings()));
    public static final Item STONE_DOUBLE_AXE = registerItem("stone_double_axe",
            new AxeItem(ToolMaterials.STONE, 7.2f, -3.4f,  new FabricItemSettings()));
    public static final Item GOLD_DOUBLE_AXE = registerItem("gold_double_axe",
            new AxeItem(ToolMaterials.GOLD, 6.5f, -3.2f,  new FabricItemSettings()));
    public static final Item LEAD_DOUBLE_AXE = registerItem("lead_double_axe",
            new AxeItem(TeadToolMaterial.LEAD, 6.0f, -3.4f,  new FabricItemSettings()));
    public static final Item IRON_DOUBLE_AXE = registerItem("iron_double_axe",
            new AxeItem(ToolMaterials.IRON, 6.5f, -3.3f,  new FabricItemSettings()));
    public static final Item DIAMOND_DOUBLE_AXE = registerItem("diamond_double_axe",
            new AxeItem(ToolMaterials.DIAMOND, 5.7f, -3.2f,  new FabricItemSettings()));
    public static final Item NETHERITE_DOUBLE_AXE = registerItem("netherite_double_axe",
            new AxeItem(ToolMaterials.NETHERITE, 6.0f, -3.2f,  new FabricItemSettings()));
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
