package net.cosmo.cosmosmagic.features;

import net.cosmo.cosmosmagic.cosmosmagic;
import net.minecraft.world.gen.feature.LakeFeature;

public class ModDecoratedFeatures {


	@SuppressWarnings("deprecation")
	public static LakeFeature AMBROSIA_OASIS;

	public void registerDecoratedFeatures() {
//		final Identifier AMBROSIA_OASIS_ID = new Identifier("cosmos", "ambrosia_oasis");
//
//		AMBROSIA_OASIS = Registry.register(Registry.FEATURE, AMBROSIA_OASIS_ID, new LakeFeature((Codec<LakeFeature.Config>) SingleStateFeatureConfig.CODEC.simple()));
//
//		// generate in swamps, similar to water lakes, but with a chance of 40 (the higher the number, the lower the generation chance)
//		BiomeModifications.addFeature(
//				BiomeSelectors.foundInOverworld(),
//				GenerationStep.Feature.LAKES,
//				RegistryKey.of(Registry.PLACED_FEATURE_KEY, AMBROSIA_OASIS_ID)
//		);

		System.out.printf("%s: Decorated features registered.%n", cosmosmagic.MOD_ID);
	}
}
