package net.pythonbear.tead.item;

import net.minecraft.item.Item;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.pythonbear.tead.init.TeadTags;

public class MattockItem
        extends MiningToolItem {
    protected final float miningSpeed;
    public MattockItem(ToolMaterial material, Item.Settings settings) {
        super(material.getAttackDamage() + 0.5f, 1.1f, material, TeadTags.Blocks.MATTOCK_MINEABLE,
                settings.maxDamage(material.getDurability() + 16));
        this.miningSpeed = material.getMiningSpeedMultiplier() - 0.4f;
    }
}
