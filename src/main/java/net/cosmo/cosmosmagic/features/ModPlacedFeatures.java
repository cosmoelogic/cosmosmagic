package net.cosmo.cosmosmagic.features;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.Arrays;

import static net.cosmo.cosmosmagic.cosmosmagic.MOD_ID;
//import static net.cosmo.cosmosmagic.features.ModConfiguredFeatures.OVERWORLD_DEEPSLATE_MOMENTUM_CRYSTAL_ORE_CONFIGURED_FEATURE;
//import static net.cosmo.cosmosmagic.features.ModConfiguredFeatures.OVERWORLD_MOMENTUM_CRYSTAL_ORE_CONFIGURED_FEATURE;

public class ModPlacedFeatures {
	/* commented cuz broken
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
		RegistryKey<PlacedFeature> OVERWORLD_MOMENTUM_CRYSTAL_ORE_PLACED_FEATURE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID, "overworld_momentum_crystal_ore"));
		RegistryKey<PlacedFeature> OVERWORLD_DEEPSLATE_MOMENTUM_CRYSTAL_ORE_PLACED_FEATURE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID, "overworld_deepslate_momentum_crystal_ore"));
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				OVERWORLD_MOMENTUM_CRYSTAL_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				OVERWORLD_DEEPSLATE_MOMENTUM_CRYSTAL_ORE_PLACED_FEATURE);
		System.out.printf("%s: Placed features registered.%n", MOD_ID);
	}
	*/

}
