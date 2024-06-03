package net.pythonbear.tead.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.pythonbear.tead.init.TeadToolMaterials;

public class FrostClaymoreItem extends ClaymoreItem {
    public FrostClaymoreItem(Settings settings) {
        super(TeadToolMaterials.STEEL, settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient == Items.ICE.getDefaultStack() ||
                ingredient == Items.BLUE_ICE.getDefaultStack() ||
                ingredient == Items.PACKED_ICE.getDefaultStack();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        StatusEffectInstance weaknessStatusEffectInstance = new StatusEffectInstance(StatusEffects.WEAKNESS,
                40, 1, false, false, true);
        StatusEffectInstance slownessStatusEffectInstance = new StatusEffectInstance(StatusEffects.SLOWNESS,
                15, 1, false, false, true);
        target.addStatusEffect(weaknessStatusEffectInstance);
        target.addStatusEffect(slownessStatusEffectInstance);

        return super.postHit(stack, target, attacker);
    }
}
