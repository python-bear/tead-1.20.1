package net.pythonbear.tead.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RubyIngotItem extends Item {
    public RubyIngotItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
