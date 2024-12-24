package net.pythonbear.tead.item.bow;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.pythonbear.tead.item.TeadItems;

public class HeavyCrossbowItem extends CustomCrossbowItem {
    public HeavyCrossbowItem(Settings settings) {
        super(settings, 50, 15, 4.38f, 2.2f, null);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient == Items.STRING.getDefaultStack() || ingredient == TeadItems.BRONZE_INGOT.getDefaultStack()
                || ingredient == Items.IRON_INGOT.getDefaultStack() || super.canRepair(stack, ingredient);
    }
}
