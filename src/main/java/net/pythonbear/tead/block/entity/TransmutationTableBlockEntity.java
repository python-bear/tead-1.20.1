package net.pythonbear.tead.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.pythonbear.tead.recipe.TransmutationRecipes;
import net.pythonbear.tead.screen.TransmutationTableScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * The Transmutation Table works like a crafting table: each player who opens it gets their own slots, crafting
 * only happens while their screen is open, and whatever is left is handed back when they close it.
 * <p>
 * The block entity itself holds no items. It only animates the book and ticks the crafting progress of the screens
 * that are currently open on it.
 */
public class TransmutationTableBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory {
    /** Screens currently open on this table (server side only). */
    private final List<TransmutationTableScreenHandler> openHandlers = new ArrayList<>();
    /**
     * Items saved inside tables by older versions of the mod (when the table kept its own inventory). They are
     * dropped on top of the table the first time it ticks so nothing is lost when updating.
     */
    private final DefaultedList<ItemStack> legacyItems = DefaultedList.ofSize(TransmutationRecipes.SIZE, ItemStack.EMPTY);
    private boolean hasLegacyItems = false;

    public int ticks;
    public float nextPageAngle;
    public float pageAngle;
    public float flipRandom;
    public float flipTurn;
    public float nextPageTurningSpeed;
    public float pageTurningSpeed;
    public float bookRotation;
    public float lastBookRotation;
    public float targetBookRotation;
    private static final Random RANDOM = Random.create();

    public TransmutationTableBlockEntity(BlockPos pos, BlockState state) {
        super(TeadBlockEntities.TRANSMUTATION_TABLE_ENTITY, pos, state);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("container.tead.transmutation_table");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        TransmutationTableScreenHandler handler = new TransmutationTableScreenHandler(syncId, playerInventory,
                ScreenHandlerContext.create(this.world, this.pos));
        this.openHandlers.add(handler);
        return handler;
    }

    public void onHandlerClosed(TransmutationTableScreenHandler handler) {
        this.openHandlers.remove(handler);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        if (nbt.contains("Items")) {
            Inventories.readNbt(nbt, this.legacyItems);
            this.hasLegacyItems = this.legacyItems.stream().anyMatch(stack -> !stack.isEmpty());
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (this.hasLegacyItems) {
            Inventories.writeNbt(nbt, this.legacyItems);
        }
    }

    /** Called when the block is broken, in case it is broken before its first tick. */
    public void dropLegacyItems(World world, BlockPos pos) {
        if (this.hasLegacyItems) {
            ItemScatterer.spawn(world, pos, this.legacyItems);
            this.legacyItems.clear();
            this.hasLegacyItems = false;
        }
    }

    public static void tick(World world, BlockPos pos, BlockState state, TransmutationTableBlockEntity blockEntity) {
        updateBook(world, pos, blockEntity);
        if (world.isClient) return;

        if (blockEntity.hasLegacyItems) {
            blockEntity.dropLegacyItems(world, pos.up());
            blockEntity.markDirty();
        }

        // Copy, as a screen can close (and remove itself) while crafting.
        for (TransmutationTableScreenHandler handler : new ArrayList<>(blockEntity.openHandlers)) {
            if (handler.isStillOpen()) {
                handler.tickCrafting(world, pos);
            } else {
                blockEntity.openHandlers.remove(handler);
            }
        }
    }

    public static void updateBook(World world, BlockPos pos, TransmutationTableBlockEntity blockEntity) {
        float g;
        blockEntity.pageTurningSpeed = blockEntity.nextPageTurningSpeed;
        blockEntity.lastBookRotation = blockEntity.bookRotation;
        PlayerEntity playerEntity = world.getClosestPlayer((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, 3.0, false);
        if (playerEntity != null) {
            double d = playerEntity.getX() - ((double)pos.getX() + 0.5);
            double e = playerEntity.getZ() - ((double)pos.getZ() + 0.5);
            blockEntity.targetBookRotation = (float) MathHelper.atan2(e, d);
            blockEntity.nextPageTurningSpeed += 0.1f;
            if (blockEntity.nextPageTurningSpeed < 0.5f || RANDOM.nextInt(40) == 0) {
                float f = blockEntity.flipRandom;
                do {
                    blockEntity.flipRandom += (float)(RANDOM.nextInt(4) - RANDOM.nextInt(4));
                } while (f == blockEntity.flipRandom);
            }
        } else {
            blockEntity.targetBookRotation += 0.02f;
            blockEntity.nextPageTurningSpeed -= 0.1f;
        }
        while (blockEntity.bookRotation >= (float)Math.PI) {
            blockEntity.bookRotation -= (float)Math.PI * 2;
        }
        while (blockEntity.bookRotation < (float)(-Math.PI)) {
            blockEntity.bookRotation += (float)Math.PI * 2;
        }
        while (blockEntity.targetBookRotation >= (float)Math.PI) {
            blockEntity.targetBookRotation -= (float)Math.PI * 2;
        }
        while (blockEntity.targetBookRotation < (float)(-Math.PI)) {
            blockEntity.targetBookRotation += (float)Math.PI * 2;
        }
        for (g = blockEntity.targetBookRotation - blockEntity.bookRotation; g >= (float)Math.PI; g -= (float)Math.PI * 2) {
        }
        while (g < (float)(-Math.PI)) {
            g += (float)Math.PI * 2;
        }
        blockEntity.bookRotation += g * 0.4f;
        blockEntity.nextPageTurningSpeed = MathHelper.clamp(blockEntity.nextPageTurningSpeed, 0.0f, 1.0f);
        ++blockEntity.ticks;
        blockEntity.pageAngle = blockEntity.nextPageAngle;
        float h = (blockEntity.flipRandom - blockEntity.nextPageAngle) * 0.4f;
        h = MathHelper.clamp(h, -0.2f, 0.2f);
        blockEntity.flipTurn += (h - blockEntity.flipTurn) * 0.9f;
        blockEntity.nextPageAngle += blockEntity.flipTurn;
    }
}
