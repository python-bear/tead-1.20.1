package net.pythonbear.tead.recipe;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.pythonbear.tead.item.TeadItems;

@Environment(value=EnvType.CLIENT)
public enum TeadRecipeBookGroup {
    ALLOY_SMELTING_SEARCH(new ItemStack(Items.COMPASS)),
    ALLOY_SMELTING_NUGGETS(new ItemStack(TeadItems.BRONZE_INGOT)),
    ALLOY_SMELTING_INGOTS(new ItemStack(TeadItems.STEEL_NUGGET)),
    GEM_CUTTING_SEARCH(new ItemStack(Items.COMPASS)),
    GEM_CUTTING_FACETING(new ItemStack(Items.DIAMOND)),
    TRANSMORPHING_SEARCH(new ItemStack(Items.COMPASS)),
    TRANSMORPHING_ALCHEMY(new ItemStack(TeadItems.RUBY_INGOT)),
    UNKNOWN(new ItemStack(Items.BARRIER));

    public static final List<TeadRecipeBookGroup> SMELTER;
    public static final List<TeadRecipeBookGroup> GEM_CUTTER;
    public static final List<TeadRecipeBookGroup> TRANSMORPHING_TABLE;
    public static final Map<TeadRecipeBookGroup, List<TeadRecipeBookGroup>> SEARCH_MAP;
    private final List<ItemStack> icons;

    private TeadRecipeBookGroup(ItemStack ... entries) {
        this.icons = ImmutableList.copyOf(entries);
    }

    public static List<TeadRecipeBookGroup> getGroups(TeadRecipeBookCategory category) {
        return switch (category) {
            default -> throw new IncompatibleClassChangeError();
            case ALLOY_SMELTING -> SMELTER;
            case GEM_CUTTING -> GEM_CUTTER;
            case ALCHEMY -> TRANSMORPHING_TABLE;
        };
    }

    public List<ItemStack> getIcons() {
        return this.icons;
    }

    static {
        SMELTER = ImmutableList.of(ALLOY_SMELTING_SEARCH, ALLOY_SMELTING_NUGGETS, ALLOY_SMELTING_INGOTS);
        GEM_CUTTER = ImmutableList.of(GEM_CUTTING_SEARCH, GEM_CUTTING_FACETING);
        TRANSMORPHING_TABLE = ImmutableList.of(TRANSMORPHING_SEARCH, TRANSMORPHING_ALCHEMY);
        SEARCH_MAP = ImmutableMap.of(ALLOY_SMELTING_SEARCH, ImmutableList.of(ALLOY_SMELTING_NUGGETS, ALLOY_SMELTING_INGOTS),
                GEM_CUTTING_SEARCH, ImmutableList.of(GEM_CUTTING_FACETING),
                TRANSMORPHING_SEARCH, ImmutableList.of(TRANSMORPHING_ALCHEMY));
    }
}

