package net.cosmo.cosmosmagic.features;

import net.cosmo.cosmosmagic.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.*;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import static net.cosmo.cosmosmagic.cosmosmagic.MOD_ID;
import static net.minecraft.registry.tag.BlockTags.DEEPSLATE_ORE_REPLACEABLES;
import static net.minecraft.registry.tag.BlockTags.STONE_ORE_REPLACEABLES;


public class ModConfiguredFeatures {
/*
	public static ConfiguredFeature<?, ?> OVERWORLD_MOMENTUM_CRYSTAL_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
			(Feature.ORE, new OreFeatureConfig(
					new TagMatchRuleTest(STONE_ORE_REPLACEABLES),
					ModBlocks.MOMENTUM_CRYSTAL_ORE.getDefaultState(),
					8)
			); // vein size

	OreFeatureConfig oreConfig = new OreFeatureConfig(
			new TagMatchRuleTest(STONE_ORE_REPLACEABLES), // target block
			ModBlocks.MOMENTUM_CRYSTAL_ORE.getDefaultState(), // ore block to generate
			8); // vein size

	// Create the configured feature
	ConfiguredFeature<?, ?> oreFeature = Feature.ORE.configure(oreConfig)
			.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
					0, // bottom offset
					0, // top offset
					64))) // maximum generation height
			.spreadHorizontally()
			.repeat(6); // number of veins per chunk

	private static final ConfiguredFeature<?, ?> MY_ORE = Feature.ORE
			.generate(new OreFeatureConfig(
					OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					Blocks.MY_ORE.getDefaultState(),
					8)) // vein size
			.range(new RangeDecoratorConfig(
					20, // bottom offset
					0, // min y level
					64)) // max y level
			.spreadHorizontally()
			.repeat(10); // number of veins per chunk
	public static ConfiguredFeature<?, ?> OVERWORLD_DEEPSLATE_MOMENTUM_CRYSTAL_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
			(Feature.ORE, new OreFeatureConfig(
					new TagMatchRuleTest(DEEPSLATE_ORE_REPLACEABLES),
					ModBlocks.DEEPSLATE_MOMENTUM_CRYSTAL_ORE.getDefaultState(),
					8)); // vein size

	public static void registerConfiguredFeatures() {
		RegistryKey<ConfiguredFeature<?, ?>> OVERWORLD_MOMENTUM_CRYSTAL_ORE_CONFIGURED_FEATURE = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(MOD_ID, "overworld_momentum_crystal_ore"));
		RegistryKey<ConfiguredFeature<?, ?>> OVERWORLD_DEEPSLATE_MOMENTUM_CRYSTAL_ORE_CONFIGURED_FEATURE = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(MOD_ID, "overworld_deepslate_momentum_crystal_ore"));
		System.out.printf("%s: Configured features registered.%n", MOD_ID);
	}

	COMMENTED OUT BECAUSE IT DOESNT WORK*/
}