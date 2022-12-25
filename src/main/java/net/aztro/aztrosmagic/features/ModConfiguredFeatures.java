package net.aztro.aztrosmagic.features;

import net.aztro.aztrosmagic.block.ModBlocks;
import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import static net.aztro.aztrosmagic.aztrosmagic.MOD_ID;
import static net.minecraft.registry.tag.BlockTags.*;

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
//				new Identifier("aztros", "overworld_momentum_crystal_ore"), OVERWORLD_MOMENTUM_CRYSTAL_ORE_CONFIGURED_FEATURE);
//		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
//				new Identifier("aztros", "overworld_deepslate_momentum_crystal_ore"), OVERWORLD_DEEPSLATE_MOMENTUM_CRYSTAL_ORE_CONFIGURED_FEATURE);
//		System.out.printf("%s: Configured features registered.%n", MOD_ID);
	}
}
