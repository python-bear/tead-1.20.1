package net.pythonbear.tead.item.ruby;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.pythonbear.tead.sound.TeadSounds;

import static net.pythonbear.tead.item.ruby.RubyToolTransmuting.hasTransmorphing;

public class RubyPickaxeItem extends PickaxeItem implements TransmutableTool {
    public RubyPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
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