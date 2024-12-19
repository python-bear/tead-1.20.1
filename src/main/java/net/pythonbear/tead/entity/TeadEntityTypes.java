package net.pythonbear.tead.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.entity.arrow.*;

public class TeadEntityTypes {
    public static final EntityType<SpearEntity> SPEAR = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Tead.MOD_ID, "spear"),
            FabricEntityTypeBuilder.<SpearEntity>create(SpawnGroup.MISC, SpearEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).trackRangeBlocks(4)
                    .trackedUpdateRate(20).build());
    public static final EntityType<GrenadeProjectileEntity> GRENADE_PROJECTILE = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Tead.MOD_ID, "grenade_projectile"),
            FabricEntityTypeBuilder.<GrenadeProjectileEntity>create(SpawnGroup.MISC, GrenadeProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());
    public static final EntityType<ShurikenProjectileEntity> SHURIKEN_PROJECTILE = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Tead.MOD_ID, "shuriken_projectile"),
            FabricEntityTypeBuilder.<ShurikenProjectileEntity>create(SpawnGroup.MISC, ShurikenProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.25f)).build());
    public static final EntityType<GravityPearlEntity> GRAVITY_PEARL = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Tead.MOD_ID, "gravity_pearl"),
            FabricEntityTypeBuilder.<GravityPearlEntity>create(SpawnGroup.MISC, GravityPearlEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());
    public static final EntityType<BufferedPearlEntity> BUFFERED_PEARL = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Tead.MOD_ID, "buffered_pearl"),
            FabricEntityTypeBuilder.<BufferedPearlEntity>create(SpawnGroup.MISC, BufferedPearlEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());
    public static final EntityType<AmethystArrowEntity> AMETHYST_ARROW = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Tead.MOD_ID, "amethyst_arrow"),
            FabricEntityTypeBuilder.<AmethystArrowEntity>create(SpawnGroup.MISC, AmethystArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());
    public static final EntityType<BoringArrowEntity> BORING_ARROW = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Tead.MOD_ID, "boring_arrow"),
            FabricEntityTypeBuilder.<BoringArrowEntity>create(SpawnGroup.MISC, BoringArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());
    public static final EntityType<CopperArrowEntity> COPPER_ARROW = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Tead.MOD_ID, "copper_arrow"),
            FabricEntityTypeBuilder.<CopperArrowEntity>create(SpawnGroup.MISC, CopperArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());
    public static final EntityType<EnderPearlArrowEntity> ENDER_PEARL_ARROW = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Tead.MOD_ID, "ender_pearl_arrow"),
            FabricEntityTypeBuilder.<EnderPearlArrowEntity>create(SpawnGroup.MISC, EnderPearlArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());
    public static final EntityType<ObsidianArrowEntity> OBSIDIAN_ARROW = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Tead.MOD_ID, "obsidian_arrow"),
            FabricEntityTypeBuilder.<ObsidianArrowEntity>create(SpawnGroup.MISC, ObsidianArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());
    public static final EntityType<RedstoneTorchArrowEntity> REDSTONE_TORCH_ARROW = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Tead.MOD_ID, "redstone_torch_arrow"),
            FabricEntityTypeBuilder.<RedstoneTorchArrowEntity>create(SpawnGroup.MISC, RedstoneTorchArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());
    public static final EntityType<RubyArrowEntity> RUBY_ARROW = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Tead.MOD_ID, "ruby_arrow"),
            FabricEntityTypeBuilder.<RubyArrowEntity>create(SpawnGroup.MISC, RubyArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());
    public static final EntityType<TransmorphingArrowEntity> TRANSMORPHING_ARROW = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Tead.MOD_ID, "transmorphing_arrow"),
            FabricEntityTypeBuilder.<TransmorphingArrowEntity>create(SpawnGroup.MISC, TransmorphingArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());
    public static final EntityType<SoulTorchArrowEntity> SOUL_TORCH_ARROW = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Tead.MOD_ID, "soul_torch_arrow"),
            FabricEntityTypeBuilder.<SoulTorchArrowEntity>create(SpawnGroup.MISC, SoulTorchArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());
    public static final EntityType<TNTArrowEntity> TNT_ARROW = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Tead.MOD_ID, "tnt_arrow"),
            FabricEntityTypeBuilder.<TNTArrowEntity>create(SpawnGroup.MISC, TNTArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());
    public static final EntityType<TorchArrowEntity> TORCH_ARROW = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Tead.MOD_ID, "torch_arrow"),
            FabricEntityTypeBuilder.<TorchArrowEntity>create(SpawnGroup.MISC, TorchArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());
}
