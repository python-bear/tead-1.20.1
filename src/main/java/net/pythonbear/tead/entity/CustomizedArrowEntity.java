package net.pythonbear.tead.entity;

import com.google.common.collect.Sets;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import net.pythonbear.tead.item.arrow.*;

import java.util.Set;

public class CustomizedArrowEntity extends ArrowEntity {
    static {
        DataTracker.registerData(CustomizedArrowEntity.class, TrackedDataHandlerRegistry.INTEGER);
    }
    private String customization = "none";
    private Potion potion = Potions.EMPTY;
    private final Set<StatusEffectInstance> effects = Sets.newHashSet();
    private static final TrackedData<Integer> COLOR = DataTracker.registerData(CustomizedArrowEntity.class,
            TrackedDataHandlerRegistry.INTEGER);
    private LivingEntity owner;


    public CustomizedArrowEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public CustomizedArrowEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    public CustomizedArrowEntity(World world, LivingEntity owner) {
        super(world, owner);
        this.owner = owner;
    }

    @Override
    public void initFromStack(ItemStack stack) {
        this.potion = Potions.EMPTY;
        this.effects.clear();
        this.dataTracker.startTracking(COLOR, -1);

        Item item = stack.getItem();
        if (item instanceof AmethystArrowItem) {
            this.customization = "amethyst";
        } else if (item instanceof CopperArrowItem) {
            this.customization = "copper";
        } else if (item instanceof EnderPearlArrowItem) {
            this.customization = "ender pearl";
        } else if (item instanceof ObsidianArrowItem) {
            this.customization = "obsidian";
        } else if (item instanceof RubyArrowItem) {
            this.customization = "ruby";
        } else if (item instanceof TntArrowItem) {
            this.customization = "tnt";
        } else if (item instanceof BoringArrowItem) {
            this.customization = "boring";
        } else {
            this.customization = "none";
        }
    }


    @Override
    protected void onHit(LivingEntity target) {
        super.onHit(target);
        World world = target.getWorld();
        switch (this.customization) {
            case "amethyst":
                for (ItemStack armor : target.getArmorItems()) {
                    armor.damage(5, target, (damagedArmor) -> target.animateDamage(target.getYaw()));
                }
                break;
            case "copper":
                LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                lightning.setPosition(target.getPos());
                world.spawnEntity(lightning);
                this.kill();
                break;
            case "ender pearl":
                this.owner.teleport(this.getX(), this.getY(), this.getZ());
                this.kill();
                break;
            case "obsidian":
                target.damage(this.getDamageSources().arrow(this, this), 4);
                break;
            case "ruby":
                for (ItemStack armor : target.getArmorItems()) {
                    armor.damage(5, target, (damagedArmor) -> target.animateDamage(target.getYaw()));
                }
                target.damage(this.getDamageSources().arrow(this, this), 4);
                target.disablesShield();
                target.stopRiding();
                target.sleep(target.getBlockPos());
                break;
            case "tnt":
                TntEntity tnt = new TntEntity(EntityType.TNT, world);
                tnt.setPosition(target.getPos());
                tnt.setFuse(1);
                world.spawnEntity(tnt);
                this.kill();
                break;
            case "boring":
                TntEntity boringTnt = new TntEntity(EntityType.TNT, world);
                boringTnt.setPosition(target.getPos());
                boringTnt.setFuse(1);
                world.spawnEntity(boringTnt);
                break;
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        World world = this.getWorld();
        switch (this.customization) {
            case "copper":
                LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                lightning.setPosition(this.getPos());
                world.spawnEntity(lightning);
                this.kill();
                break;
            case "ender pearl":
                this.owner.teleport(this.getX(), this.getY(), this.getZ());
                this.kill();
                break;
            case "tnt":
                TntEntity tnt = new TntEntity(EntityType.TNT, world);
                tnt.setPosition(this.getPos());
                tnt.setFuse(1);
                world.spawnEntity(tnt);
                this.kill();
                break;
            case "boring":
                if (world.getBlockState(blockHitResult.getBlockPos()).getBlock() == Blocks.BEDROCK) {
                    this.kill();
                } else {
                    TntEntity boringTnt = new TntEntity(EntityType.TNT, world);
                    boringTnt.setPosition(this.getPos());
                    boringTnt.setFuse(1);
                    world.spawnEntity(boringTnt);
                    break;
                }
        }
    }
}
