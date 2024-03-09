package net.pythonbear.tead.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MountaineerPickItem
        extends MiningToolItem {
    protected final float miningSpeed;
    public MountaineerPickItem(ToolMaterial material, Item.Settings settings) {
        super(material.getAttackDamage() + 2, 1.3f, material, BlockTags.PICKAXE_MINEABLE,
                settings.maxDamage(material.getDurability() + 32));
        this.miningSpeed = material.getMiningSpeedMultiplier();
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity user = context.getPlayer();
        World world = context.getWorld();
        if (user.fallDistance == 0) {
            return ActionResult.FAIL;
        } else {
            BlockPos blockPos = context.getBlockPos();
            if (world.getBlockState(blockPos).isIn(BlockTags.PICKAXE_MINEABLE)) {
                user.fallDistance *= 0.7f;
                user.setVelocity(user.getVelocity().multiply(1, 0.6, 1));
            }
            return ActionResult.SUCCESS;
        }
    }
}

