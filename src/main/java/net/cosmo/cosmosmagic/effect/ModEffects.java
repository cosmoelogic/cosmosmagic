package net.cosmo.cosmosmagic.effect;

import net.cosmo.cosmosmagic.cosmosmagic;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
	public static StatusEffect AMBROSIA = new AmbrosiaEffect(StatusEffectCategory.BENEFICIAL, 0xe8a600);
	public static StatusEffect MOMENTUM = new EmptyEffect(StatusEffectCategory.BENEFICIAL, 0x3495eb);
	public static StatusEffect DENSITY = new DensityEffect(StatusEffectCategory.HARMFUL, 0x8a5c00);
	public static StatusEffect FREEZE = new FreezeEffect(StatusEffectCategory.HARMFUL, 0x6effee);


	public static void registerEffects() {
		Registry.register(Registries.STATUS_EFFECT, new Identifier(cosmosmagic.MOD_ID, "ambrosia"), AMBROSIA);
		Registry.register(Registries.STATUS_EFFECT, new Identifier(cosmosmagic.MOD_ID, "momentum"), MOMENTUM);
		Registry.register(Registries.STATUS_EFFECT, new Identifier(cosmosmagic.MOD_ID, "density"), DENSITY);
		Registry.register(Registries.STATUS_EFFECT, new Identifier(cosmosmagic.MOD_ID, "freeze"), FREEZE);
		System.out.printf("%s: Effects registered.%n", cosmosmagic.MOD_ID);
	}
}