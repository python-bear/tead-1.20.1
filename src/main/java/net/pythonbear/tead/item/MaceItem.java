package net.pythonbear.tead.item;

import com.google.common.collect.ImmutableMap;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Map;
import java.util.Optional;

public class MaceItem extends BladedWeaponItem {
    protected static final Map<Block, Block> CRACKED_BLOCKS = new ImmutableMap.Builder<Block, Block>()
            .put(Blocks.STONE, Blocks.COBBLESTONE)
            .put(Blocks.SMOOTH_STONE, Blocks.STONE)
            .put(Blocks.STONE_SLAB, Blocks.COBBLESTONE_SLAB)
            .put(Blocks.SMOOTH_STONE_SLAB, Blocks.STONE_SLAB)
            .put(Blocks.STONE_STAIRS, Blocks.COBBLESTONE_STAIRS)
            .put(Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS)
            .put(Blocks.INFESTED_STONE_BRICKS, Blocks.INFESTED_CRACKED_STONE_BRICKS)
            .put(Blocks.INFESTED_STONE, Blocks.INFESTED_COBBLESTONE)
            .put(Blocks.DEEPSLATE_BRICK_SLAB, Blocks.COBBLED_DEEPSLATE_SLAB)
            .put(Blocks.DEEPSLATE_TILE_SLAB, Blocks.COBBLED_DEEPSLATE_SLAB)
            .put(Blocks.POLISHED_DEEPSLATE_SLAB, Blocks.COBBLED_DEEPSLATE_SLAB)
            .put(Blocks.DEEPSLATE_BRICK_STAIRS, Blocks.COBBLED_DEEPSLATE_STAIRS)
            .put(Blocks.DEEPSLATE_TILE_STAIRS, Blocks.COBBLED_DEEPSLATE_STAIRS)
            .put(Blocks.POLISHED_DEEPSLATE_STAIRS, Blocks.COBBLED_DEEPSLATE_STAIRS)
            .put(Blocks.DEEPSLATE_BRICK_WALL, Blocks.COBBLED_DEEPSLATE_WALL)
            .put(Blocks.DEEPSLATE_TILE_WALL, Blocks.COBBLED_DEEPSLATE_WALL)
            .put(Blocks.POLISHED_DEEPSLATE_WALL, Blocks.COBBLED_DEEPSLATE_WALL)
            .put(Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE)
            .put(Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS)
            .put(Blocks.CRACKED_DEEPSLATE_BRICKS, Blocks.COBBLED_DEEPSLATE)
            .put(Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES)
            .put(Blocks.CRACKED_DEEPSLATE_TILES, Blocks.COBBLED_DEEPSLATE)
            .put(Blocks.POLISHED_DEEPSLATE, Blocks.COBBLED_DEEPSLATE)
            .put(Blocks.POLISHED_ANDESITE, Blocks.ANDESITE)
            .put(Blocks.POLISHED_ANDESITE_SLAB, Blocks.ANDESITE_SLAB)
            .put(Blocks.POLISHED_ANDESITE_STAIRS, Blocks.ANDESITE_STAIRS)
            .put(Blocks.POLISHED_DIORITE, Blocks.DIORITE)
            .put(Blocks.POLISHED_DIORITE_SLAB, Blocks.DIORITE_SLAB)
            .put(Blocks.POLISHED_DIORITE_STAIRS, Blocks.DIORITE_STAIRS)
            .put(Blocks.POLISHED_GRANITE, Blocks.GRANITE)
            .put(Blocks.POLISHED_GRANITE_SLAB, Blocks.GRANITE_SLAB)
            .put(Blocks.POLISHED_GRANITE_STAIRS, Blocks.GRANITE_STAIRS)
            .put(Blocks.SMOOTH_SANDSTONE, Blocks.SANDSTONE)
            .put(Blocks.SMOOTH_RED_SANDSTONE, Blocks.RED_SANDSTONE)
            .put(Blocks.CUT_SANDSTONE, Blocks.SANDSTONE)
            .put(Blocks.CUT_RED_SANDSTONE, Blocks.RED_SANDSTONE)
            .put(Blocks.SMOOTH_SANDSTONE_SLAB, Blocks.SANDSTONE_SLAB)
            .put(Blocks.SMOOTH_RED_SANDSTONE_SLAB, Blocks.RED_SANDSTONE_SLAB)
            .put(Blocks.CUT_SANDSTONE_SLAB, Blocks.SANDSTONE_SLAB)
            .put(Blocks.CUT_RED_SANDSTONE_SLAB, Blocks.RED_SANDSTONE_SLAB)
            .put(Blocks.SMOOTH_SANDSTONE_STAIRS, Blocks.SANDSTONE_STAIRS)
            .put(Blocks.SMOOTH_RED_SANDSTONE_STAIRS, Blocks.RED_SANDSTONE_STAIRS)
            .put(Blocks.ANVIL, Blocks.CHIPPED_ANVIL)
            .put(Blocks.CHIPPED_ANVIL, Blocks.DAMAGED_ANVIL)
            .put(Blocks.POLISHED_BASALT, Blocks.BASALT)
            .put(Blocks.SMOOTH_BASALT, Blocks.BASALT)
            .put(Blocks.SMOOTH_QUARTZ, Blocks.QUARTZ_BLOCK)
            .put(Blocks.SMOOTH_QUARTZ_SLAB, Blocks.QUARTZ_SLAB)
            .put(Blocks.SMOOTH_QUARTZ_STAIRS, Blocks.QUARTZ_STAIRS)
            .put(Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS)
            .put(Blocks.POLISHED_BLACKSTONE, Blocks.BLACKSTONE)
            .put(Blocks.POLISHED_BLACKSTONE_SLAB, Blocks.BLACKSTONE_SLAB)
            .put(Blocks.POLISHED_BLACKSTONE_STAIRS, Blocks.BLACKSTONE_STAIRS)
            .put(Blocks.POLISHED_BLACKSTONE_WALL, Blocks.BLACKSTONE_WALL)
            .put(Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)
            .put(Blocks.POLISHED_BLACKSTONE_BRICK_SLAB, Blocks.BLACKSTONE_SLAB)
            .put(Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS, Blocks.BLACKSTONE_STAIRS)
            .put(Blocks.POLISHED_BLACKSTONE_BRICK_WALL, Blocks.BLACKSTONE_WALL)
            .put(Blocks.GILDED_BLACKSTONE, Blocks.BLACKSTONE)
            .build();
    
    public MaceItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, 4, 1.1f, 0, 0, 0,
                0, 1.75f, true,
                settings.maxDamage(toolMaterial.getDurability() + 32));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();
        BlockState blockState = world.getBlockState(blockPos);
        Optional<BlockState> optional = this.getCrackedState(blockState);
        ItemStack itemStack = context.getStack();

        if (optional.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1.0f,
                    1.0f);
            if (playerEntity instanceof ServerPlayerEntity) {
                Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity)playerEntity, blockPos, itemStack);
            }
            world.setBlockState(blockPos, optional.get(),
                    Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(playerEntity,
                    optional.get()));
            if (playerEntity != null) {
                itemStack.damage(1, playerEntity, p -> p.sendToolBreakStatus(context.getHand()));
            }
            return ActionResult.success(world.isClient);
        }
        return ActionResult.PASS;
    }

    private Optional<BlockState> getCrackedState(BlockState state) {
        return Optional.ofNullable(CRACKED_BLOCKS.get(state.getBlock())).map(Block::getDefaultState);
    }
}
