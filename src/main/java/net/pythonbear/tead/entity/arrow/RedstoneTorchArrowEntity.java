package net.pythonbear.tead.entity.arrow;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TntBlock;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.pythonbear.tead.entity.TeadEntityTypes;
import net.pythonbear.tead.item.TeadItems;


public class RedstoneTorchArrowEntity extends PersistentProjectileEntity {
    public RedstoneTorchArrowEntity(World world, LivingEntity owner) {
        super(TeadEntityTypes.REDSTONE_TORCH_ARROW, owner, world);
    }

    public RedstoneTorchArrowEntity(World world, double x, double y, double z) {
        super(TeadEntityTypes.REDSTONE_TORCH_ARROW, x, y, z, world);
    }

    public RedstoneTorchArrowEntity(EntityType<RedstoneTorchArrowEntity> arrowEntity, World world) {
        super(arrowEntity, world);
    }

    public void initFromStack(ItemStack stack) {}

    @Override
    public void tick() {
        super.tick();
        if (!this.getWorld().isClient && !this.inGround) {
            DustParticleEffect dustParticle = new DustParticleEffect(DustParticleEffect.RED, 1.0f);
            ((ServerWorld)this.getWorld()).spawnParticles(dustParticle, this.getX(), this.getY(),
                    this.getZ(), 1, 0, 0, 0,0);
        }
    }

    @Override
    protected void onHit(LivingEntity target) {
        if (target instanceof CreeperEntity) {
            ((CreeperEntity) target).ignite();
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);

        World world = this.getWorld();
        BlockPos hitPos = blockHitResult.getBlockPos();
        BlockState hitState = world.getBlockState(hitPos);

        if (hitState.getBlock() instanceof TntBlock) {
            world.removeBlock(hitPos, false);
            TntEntity tnt = new TntEntity(EntityType.TNT, world);
            tnt.setPosition(this.getPos());
            tnt.setFuse(1);
            world.spawnEntity(tnt);
        } else {
            BlockPos placePos;
            BlockState torchState;

            switch (blockHitResult.getSide()) {
                case UP:
                    placePos = hitPos.up();
                    torchState = Blocks.REDSTONE_TORCH.getDefaultState();
                    break;
                case NORTH:
                    placePos = hitPos.north();
                    torchState = Blocks.REDSTONE_WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, Direction.NORTH);
                    break;
                case SOUTH:
                    placePos = hitPos.south();
                    torchState = Blocks.REDSTONE_WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, Direction.SOUTH);
                    break;
                case WEST:
                    placePos = hitPos.west();
                    torchState = Blocks.REDSTONE_WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, Direction.WEST);
                    break;
                case EAST:
                    placePos = hitPos.east();
                    torchState = Blocks.REDSTONE_WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, Direction.EAST);
                    break;
                case DOWN:
                    placePos = null;
                    torchState = null;

                    for (Direction direction : Direction.values()) {
                        if (direction == Direction.UP || direction == Direction.DOWN) continue;
                        BlockPos adjacentPos = hitPos.down().offset(direction);
                        if (world.getBlockState(adjacentPos).isSolidBlock(world, adjacentPos)) {
                            placePos = hitPos.down();
                            torchState = Blocks.REDSTONE_WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, direction.getOpposite());
                            break;
                        }
                    }

                    if (placePos == null) {
                        this.kill();
                        return;
                    }
                    break;
                default:
                    return;
            }

            if (placePos != null && world.getBlockState(placePos).isReplaceable()) {
                world.setBlockState(placePos, torchState);
            }
        }
        this.kill();
    }


    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(TeadItems.REDSTONE_TORCH_ARROW);
    }
}
