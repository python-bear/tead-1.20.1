package net.pythonbear.tead.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.pythonbear.tead.block.entity.SmelterBlockEntity;

public class SmelterOutputSlot
extends Slot {
    private final PlayerEntity player;
    private int amount;

    public SmelterOutputSlot(PlayerEntity player, Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
        this.player = player;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
    }

    @Override
    public ItemStack takeStack(int amount) {
        if (this.hasStack()) {
            this.amount += Math.min(amount, this.getStack().getCount());
        }
        return super.takeStack(amount);
    }

    @Override
    public void onTakeItem(PlayerEntity player, ItemStack stack) {
        this.onCrafted(stack);
        super.onTakeItem(player, stack);
    }

    @Override
    protected void onCrafted(ItemStack stack, int amount) {
        this.amount += amount;
        this.onCrafted(stack);
    }

    @Override
    protected void onCrafted(ItemStack stack) {
        stack.onCraft(this.player.getWorld(), this.player, this.amount);
        Object object = this.player;
        if (object instanceof ServerPlayerEntity serverPlayerEntity) {
            object = this.inventory;
            if (object instanceof SmelterBlockEntity smelterBlockEntity) {
                smelterBlockEntity.dropExperienceForRecipesUsed(serverPlayerEntity);
            }
        }
        this.amount = 0;
    }
}

