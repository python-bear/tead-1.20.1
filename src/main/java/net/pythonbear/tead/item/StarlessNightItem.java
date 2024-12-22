package net.pythonbear.tead.item;

import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.pythonbear.tead.enchantments.TeadEnchantments;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class StarlessNightItem extends BroadswordItem {
    public StarlessNightItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity) {
            if (((PlayerEntity) attacker).getItemCooldownManager().getCooldownProgress(stack.getItem(), 0) <= 0) {
                 if (!attacker.getWorld().isClient()) {
                    ((PlayerEntity) attacker).getItemCooldownManager().set(this, 50);

                    Optional<Map<Enchantment, Integer>> optionalEnchantments =
                            Optional.ofNullable(EnchantmentHelper.get(stack));
                    Map<Enchantment, Integer> itemStackEnchantments = optionalEnchantments.orElse(Collections.emptyMap());
                    int enderBufferLevel = 0;

                    Optional<Integer> endBufferEnchantment =
                            Optional.ofNullable(itemStackEnchantments.get(TeadEnchantments.END_BUFFER));
                    enderBufferLevel += endBufferEnchantment.orElse(0);

                    // Switch positions
                    double attackerX = attacker.getX();
                    double attackerY = attacker.getY();
                    double attackerZ = attacker.getZ();

                    attacker.teleport(target.getX(), target.getY(), target.getZ());
                    target.teleport(attackerX, attackerY, attackerZ);

                    attacker.getWorld().playSound(null, attacker.getBlockPos(),
                            SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.AMBIENT);
                     target.getWorld().playSound(null, target.getBlockPos(),
                            SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.AMBIENT);

                    // Make attacker face target
                    attacker.lookAt(EntityAnchorArgumentType.EntityAnchor.FEET, target.getPos());

                    // Deal enderpearl damage to both
                    attacker.damage(attacker.getDamageSources().fall(), 5.0F - enderBufferLevel);
                    target.damage(attacker.getDamageSources().fall(), 5.0F);
                }

                for (int i = 0; i < 32; ++i) {
                    attacker.getWorld().addParticle(ParticleTypes.PORTAL, attacker.getX(),
                            attacker.getY() + attacker.getRandom().nextDouble() * 2.0, attacker.getZ(),
                            attacker.getRandom().nextGaussian(), 0.0, attacker.getRandom().nextGaussian());
                    target.getWorld().addParticle(ParticleTypes.PORTAL, target.getX(),
                            target.getY() + target.getRandom().nextDouble() * 2.0, target.getZ(),
                            target.getRandom().nextGaussian(), 0.0, target.getRandom().nextGaussian());
                }
            }
        }
        super.postHit(stack, target, attacker);
        return true;
    }
}
