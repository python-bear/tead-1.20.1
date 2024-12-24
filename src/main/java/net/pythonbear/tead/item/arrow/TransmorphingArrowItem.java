package net.pythonbear.tead.item.arrow;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.pythonbear.tead.entity.arrow.TransmorphingArrowEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TransmorphingArrowItem extends ArrowItem {
    public TransmorphingArrowItem(Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        TransmorphingArrowEntity arrowEntity = new TransmorphingArrowEntity(world, shooter);
        arrowEntity.initFromStack(stack);
        return arrowEntity;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.tead.transmorphing_arrow.tooltip").formatted(Formatting.GRAY));
    }
}
