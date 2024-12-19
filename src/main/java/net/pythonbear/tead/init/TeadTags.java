package net.pythonbear.tead.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;

public class TeadTags {
    public static class Blocks {
        public static final TagKey<Block> REFINED_BUILDING_BLOCKS = createTag("refined_building_blocks");
        public static final TagKey<Block> SCYTHE_BLOCKS = createTag("scythe_blocks");
        public static final TagKey<Block> MATTOCK_MINEABLE = createTag("mattock_mineable");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Tead.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> ROCKS = createTag("rocks");
        public static final TagKey<Item> CROSSBOWS = createTag("crossbows");
        public static final TagKey<Item> ALLOYABLE_ITEMS = createTag("alloyable_items");
        public static final TagKey<Item> SMITHING_GUIDES = createTag("smithing_guides");
        public static final TagKey<Item> REFINED_METAL_INGOTS = createTag("refined_metal_ingots");
        public static final TagKey<Item> METAL_INGOTS = createTag("metal_ingots");
        public static final TagKey<Item> METAL_NUGGETS = createTag("metal_nuggets");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Tead.MOD_ID, name));
        }
    }
}
