package net.pythonbear.tead.item.arrow;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.pythonbear.tead.entity.arrow.RedstoneTorchArrowEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RedstoneTorchArrowItem extends ArrowItem {
    public RedstoneTorchArrowItem(Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        RedstoneTorchArrowEntity arrowEntity = new RedstoneTorchArrowEntity(world, shooter);
        arrowEntity.initFromStack(stack);
        return arrowEntity;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.tead.redstone_torch_arrow.tooltip").formatted(Formatting.GRAY));
    }
}
