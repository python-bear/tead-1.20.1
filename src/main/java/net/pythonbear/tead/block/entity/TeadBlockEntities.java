package net.pythonbear.tead.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.block.TeadBlocks;

public class TeadBlockEntities {
    public static final BlockEntityType<SmelterBlockEntity> SMELTER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Tead.MOD_ID, "smelter_block_entity"),
                    FabricBlockEntityTypeBuilder.create(SmelterBlockEntity::new, TeadBlocks.SMELTER).build());

    public static void registerBlockEntities() {
        Tead.LOGGER.info("Registering mod block entities for " + Tead.MOD_ID);
    }
}
