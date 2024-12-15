package net.pythonbear.tead.block;

import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class WeakCobwebBlock extends CobwebBlock {
    public static final IntProperty AGE = Properties.AGE_3;

    public WeakCobwebBlock(Settings settings) {
        super(settings.ticksRandomly());
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0));
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.scheduledTick(state, world, pos, random);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i = state.get(AGE);
        if (i < 3) {
            world.setBlockState(pos, state.with(AGE, i + 1), Block.NOTIFY_LISTENERS);
            world.scheduleBlockTick(pos, this, MathHelper.nextInt(random, 50, 80));
        } else {
            this.destroy(world, pos);
        }
    }

    protected void destroy(World world, BlockPos pos) {
        world.setBlockState(pos, Blocks.AIR.getDefaultState());
        world.updateNeighbor(pos, Blocks.AIR.getDefaultState().getBlock(), pos);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return Items.COBWEB.getDefaultStack();
    }
}
