package net.cosmo.cosmosmagic.features;

import net.cosmo.cosmosmagic.block.ModBlocks;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import static net.minecraft.registry.tag.BlockTags.DEEPSLATE_ORE_REPLACEABLES;
import static net.minecraft.registry.tag.BlockTags.STONE_ORE_REPLACEABLES;

public class ModConfiguredFeatures {

	public static ConfiguredFeature<?, ?> OVERWORLD_MOMENTUM_CRYSTAL_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
			(Feature.ORE, new OreFeatureConfig(
					new TagMatchRuleTest(STONE_ORE_REPLACEABLES),
					ModBlocks.MOMENTUM_CRYSTAL_ORE.getDefaultState(),
					8)); // vein size

	public static ConfiguredFeature<?, ?> OVERWORLD_DEEPSLATE_MOMENTUM_CRYSTAL_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
			(Feature.ORE, new OreFeatureConfig(
					new TagMatchRuleTest(DEEPSLATE_ORE_REPLACEABLES),
					ModBlocks.DEEPSLATE_MOMENTUM_CRYSTAL_ORE.getDefaultState(),
					8)); // vein size

	public static void registerConfiguredFeatures() {
//		Registry.register(Registries.CONFIGURED_FEATURE,
//				new Identifier("cosmos", "overworld_momentum_crystal_ore"), OVERWORLD_MOMENTUM_CRYSTAL_ORE_CONFIGURED_FEATURE);
//		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
//				new Identifier("cosmos", "overworld_deepslate_momentum_crystal_ore"), OVERWORLD_DEEPSLATE_MOMENTUM_CRYSTAL_ORE_CONFIGURED_FEATURE);
//		System.out.printf("%s: Configured features registered.%n", MOD_ID);
	}
}
