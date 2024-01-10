package net.pythonbear.tead.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.item.LightningStaffItem;
import net.pythonbear.tead.item.TeadFoodComponents;

public class TeadItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item GALENA = registerItem("galena", new Item(new FabricItemSettings()));
    public static final Item LEAD_INGOT = registerItem("lead_ingot", new Item(new FabricItemSettings()));
    public static final Item LIGHTNING_STAFF = registerItem("lightning_staff",
            new LightningStaffItem(new FabricItemSettings().maxCount(1).maxDamage(64)));
    public static final Item LEAD_APPLE = registerItem("lead_apple", new Item(new FabricItemSettings()
            .food(TeadFoodComponents.LEAD_APPLE)));

    static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(GALENA);
        entries.add(LEAD_INGOT);
        entries.add(LIGHTNING_STAFF);
        entries.add(LEAD_APPLE);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Tead.MOD_ID, name), item);
    }
    public static void registerItems() {
        Tead.LOGGER.info("Registering mod items for " + Tead.MOD_ID);

//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(TeadItems::addItemsToIngredientItemGroup);
    }
}
