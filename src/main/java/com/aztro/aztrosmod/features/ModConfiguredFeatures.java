package com.aztro.aztrosmod.features;

import com.aztro.aztrosmod.block.ModBlocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;

import static com.aztro.aztrosmod.aztrosmod.MOD_ID;

public class ModConfiguredFeatures {

	public static ConfiguredFeature<?, ?> OVERWORLD_MOMENTUM_CRYSTAL_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
			(Feature.ORE, new OreFeatureConfig(
					OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
					ModBlocks.MOMENTUM_CRYSTAL_ORE.getDefaultState(),
					8)); // vein size

	public static ConfiguredFeature<?, ?> OVERWORLD_DEEPSLATE_MOMENTUM_CRYSTAL_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
			(Feature.ORE, new OreFeatureConfig(
					OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
					ModBlocks.DEEPSLATE_MOMENTUM_CRYSTAL_ORE.getDefaultState(),
					8)); // vein size

	public static void registerConfiguredFeatures() {
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("aztros", "overworld_momentum_crystal_ore"), OVERWORLD_MOMENTUM_CRYSTAL_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("aztros", "overworld_deepslate_momentum_crystal_ore"), OVERWORLD_DEEPSLATE_MOMENTUM_CRYSTAL_ORE_CONFIGURED_FEATURE);
		System.out.printf("%s: Configured features registered.%n", MOD_ID);

	}
}
