package net.pythonbear.tead.item.bow;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.pythonbear.tead.item.TeadItems;

public class AutoCrossbowItem extends CustomCrossbowItem {
    public AutoCrossbowItem(Settings settings) {
        super(settings, 9, 5, 1.9f, 1.1f, null);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient == Items.STRING.getDefaultStack() || ingredient == TeadItems.STEEL_INGOT.getDefaultStack()
                || ingredient == Items.REDSTONE.getDefaultStack() || super.canRepair(stack, ingredient);
    }
}
