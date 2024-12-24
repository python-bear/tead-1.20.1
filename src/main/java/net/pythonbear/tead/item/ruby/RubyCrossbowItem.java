package net.pythonbear.tead.item.ruby;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.pythonbear.tead.item.TeadItems;
import net.pythonbear.tead.item.bow.CustomCrossbowItem;
import net.pythonbear.tead.sound.TeadSounds;

import static net.pythonbear.tead.item.ruby.RubyToolTransmuting.hasTransmorphing;

public class RubyCrossbowItem extends CustomCrossbowItem implements TransmutableTool{
    public RubyCrossbowItem(Settings settings) {
        super(settings, 25, 8, 3.15f, 1.6f, null);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient == Items.STRING.getDefaultStack()  || ingredient == TeadItems.RUBY.getDefaultStack();
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack handStack = user.getStackInHand(hand);

        if (!world.isClient) {
            ItemStack transmutedTool = RubyToolTransmuting.rotateTransmutation(handStack);
            if (user.isSneaking() && hasTransmorphing(handStack) && transmutedTool != handStack) {
                Vec3d pos = user.getPos();
                user.setStackInHand(hand, transmutedTool);
                world.playSound(null, pos.x, pos.y, pos.z, TeadSounds.TRANSMORPH, SoundCategory.PLAYERS, 1.0f, world.random.nextFloat() * 0.1f + 0.9f);
                return TypedActionResult.fail(transmutedTool);
            } else {
                return super.use(world, user, hand);
            }
        } else {
            return TypedActionResult.pass(handStack);
        }
    }
}
