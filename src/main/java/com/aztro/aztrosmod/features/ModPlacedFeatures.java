package com.aztro.aztrosmod.features;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.Arrays;

import static com.aztro.aztrosmod.aztrosmod.MOD_ID;
import static com.aztro.aztrosmod.features.ModConfiguredFeatures.*;

public class ModPlacedFeatures {
	public static PlacedFeature OVERWORLD_MOMENTUM_CRYSTAL_ORE_PLACED_FEATURE = new PlacedFeature(
			RegistryEntry.of(OVERWORLD_MOMENTUM_CRYSTAL_ORE_CONFIGURED_FEATURE),
			Arrays.asList(
					CountPlacementModifier.of(2), // number of veins per chunk
					SquarePlacementModifier.of(), // spreading horizontally
					HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(24))
			)); // height

	public static PlacedFeature OVERWORLD_DEEPSLATE_MOMENTUM_CRYSTAL_ORE_PLACED_FEATURE = new PlacedFeature(
			RegistryEntry.of(OVERWORLD_DEEPSLATE_MOMENTUM_CRYSTAL_ORE_CONFIGURED_FEATURE),
			Arrays.asList(
					CountPlacementModifier.of(2), // number of veins per chunk
					SquarePlacementModifier.of(), // spreading horizontally
					HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(8))
			)); // height

	public static void registerPlacedFeatures() {
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("aztros", "overworld_momentum_crystal_ore"),
				OVERWORLD_MOMENTUM_CRYSTAL_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("aztros", "overworld_momentum_crystal_ore")));
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("aztros", "overworld_deepslate_momentum_crystal_ore"),
				OVERWORLD_DEEPSLATE_MOMENTUM_CRYSTAL_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("aztros", "overworld_deepslate_momentum_crystal_ore")));
		System.out.printf("%s: Placed features registered.%n", MOD_ID);
	}
}
