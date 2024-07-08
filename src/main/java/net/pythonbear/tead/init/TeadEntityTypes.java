package net.pythonbear.tead.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.entity.GravityPearlEntity;
import net.pythonbear.tead.entity.GrenadeProjectileEntity;
import net.pythonbear.tead.entity.ShurikenProjectileEntity;

public class TeadEntityTypes {
    public static final EntityType<GrenadeProjectileEntity> GRENADE_PROJECTILE = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Tead.MOD_ID, "grenade_projectile"),
            FabricEntityTypeBuilder.<GrenadeProjectileEntity>create(SpawnGroup.MISC, GrenadeProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.2f, 0.2f)).build());
    public static final EntityType<ShurikenProjectileEntity> SHURIKEN_PROJECTILE = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Tead.MOD_ID, "shuriken_projectile"),
            FabricEntityTypeBuilder.<ShurikenProjectileEntity>create(SpawnGroup.MISC, ShurikenProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());
    public static final EntityType<GravityPearlEntity> GRAVITY_PEARL = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Tead.MOD_ID, "gravity_pearl"),
            FabricEntityTypeBuilder.<GravityPearlEntity>create(SpawnGroup.MISC, GravityPearlEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());
}
