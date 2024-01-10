package net.pythonbear.tead.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;

public class TeadItemGroups {
    public static final ItemGroup TEAD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Tead.MOD_ID, "tead"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.tead"))
                    .icon(() -> new ItemStack(TeadItems.RUBY)).entries((displayContext, entries) -> {
                        entries.add(TeadItems.RUBY);
                        entries.add(TeadItems.GALENA);
                        entries.add(TeadItems.LEAD_INGOT);

                        entries.add(TeadItems.LEAD_APPLE);

                        entries.add(TeadItems.LIGHTNING_STAFF);

                        entries.add(TeadItems.LEAD_AXE);
                        entries.add(TeadItems.LEAD_HOE);
                        entries.add(TeadItems.LEAD_PICKAXE);
                        entries.add(TeadItems.LEAD_SHOVEL);
                        entries.add(TeadItems.LEAD_SWORD);

                        entries.add(TeadBlocks.BLOCK_OF_RUBY);
                        entries.add(TeadBlocks.BLOCK_OF_LEAD);
                        entries.add(TeadBlocks.LEAD_ORE);
                        entries.add(TeadBlocks.RUBY_ORE);
                        entries.add(TeadBlocks.DEEPSLATE_RUBY_ORE);
                    }).build());
    public static void registerItemGroups() {
        Tead.LOGGER.info("Registering mod items for " + Tead.MOD_ID);
    }
}
