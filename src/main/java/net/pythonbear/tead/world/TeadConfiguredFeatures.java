package net.pythonbear.tead.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.pythonbear.tead.Tead;
import net.pythonbear.tead.init.TeadBlocks;

import java.util.List;

public class TeadConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RUBY_DEEPSLATE_ORE_KEY =
            registerKey("ruby_deepslate_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LEAD_ORE_KEY = registerKey("lead_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LEAD_DEEPSLATE_ORE_KEY =
            registerKey("lead_deepslate_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WHITE_GOLD_NETHER_ORE_KEY =
            registerKey("white_gold_nether_ore");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new BlockMatchRuleTest(Blocks.NETHERRACK);

        List<OreFeatureConfig.Target> overworldRubyOres = List.of(OreFeatureConfig.createTarget(stoneReplacables,
                TeadBlocks.RUBY_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldRubyDeepslateOre = List.of(OreFeatureConfig.createTarget(
                deepslateReplacables, TeadBlocks.DEEPSLATE_RUBY_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldLeadOres = List.of(OreFeatureConfig.createTarget(stoneReplacables,
                TeadBlocks.LEAD_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldLeadDeepslateOres = List.of(OreFeatureConfig.createTarget(
                deepslateReplacables, TeadBlocks.LEAD_DEEPSLATE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> netherWhiteGoldOres = List.of(OreFeatureConfig.createTarget(
                netherReplacables, TeadBlocks.WHITE_GOLD_NETHER_ORE.getDefaultState()));

        register(context, RUBY_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldRubyOres, 4));
        register(context, RUBY_DEEPSLATE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldRubyDeepslateOre, 5));
        register(context, LEAD_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldLeadOres, 10));
        register(context, LEAD_DEEPSLATE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldLeadDeepslateOres, 5));
        register(context, WHITE_GOLD_NETHER_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherWhiteGoldOres, 13));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Tead.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature,
            FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
