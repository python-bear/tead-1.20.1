package net.pythonbear.tead.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.entity.custom.GrenadeProjectileEntity;

public class TeadEntities {
    public static final EntityType<GrenadeProjectileEntity> GRENADE_PROJECTILE = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Tead.MOD_ID, "grenade_projectile"),
            FabricEntityTypeBuilder.<GrenadeProjectileEntity>create(SpawnGroup.MISC, GrenadeProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.2f, 0.2f)).build());
}
