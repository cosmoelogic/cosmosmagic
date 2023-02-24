package net.cosmo.cosmosmagic.potion;

import net.cosmo.cosmosmagic.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.TippedArrowItem;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.potion.Potions;

import static net.cosmo.cosmosmagic.cosmosmagic.MOD_ID;

public class ModPotions {
	public static Potion MOMENTUM, LONG_MOMENTUM, DENSITY, STRONG_DENSITY, FREEZE, LONG_FREEZE;

	private static Potion register(String name, Potion potion) {
		return Registry.register(Registries.POTION, new Identifier(MOD_ID, name), potion);
	}
	public static void registerPotions() {
		MOMENTUM = register("momentum", new Potion(new StatusEffectInstance(ModEffects.MOMENTUM, 600, 0)));
		LONG_MOMENTUM = register("long_momentum", new Potion("momentum", new StatusEffectInstance(ModEffects.MOMENTUM, 1200, 0)));
		DENSITY = register("density", new Potion(new StatusEffectInstance(ModEffects.DENSITY, 200, 0)));
		STRONG_DENSITY = register("strong_density", new Potion("density", new StatusEffectInstance(ModEffects.DENSITY, 160, 1)));
		FREEZE = register("freeze", new Potion(new StatusEffectInstance(ModEffects.FREEZE, 200, 0)));
		LONG_FREEZE = register("long_freeze", new Potion("freeze", new StatusEffectInstance(ModEffects.FREEZE, 400, 0)));
	}
}
