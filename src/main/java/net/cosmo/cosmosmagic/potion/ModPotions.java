package net.cosmo.cosmosmagic.potion;

import net.cosmo.cosmosmagic.effect.ModEffects;
import net.cosmo.cosmosmagic.item.ModItems;
import net.cosmo.cosmosmagic.mixins.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
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

	private static void registerPotionRecipes() {
		//initial recipes
		BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.MOMENTUM_CRYSTAL,
				ModPotions.MOMENTUM);
		BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.OBSIDIAN,
				ModPotions.DENSITY);

		//duration enhancements
		BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.MOMENTUM, Items.REDSTONE,
				ModPotions.LONG_MOMENTUM);
		BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.FREEZE, Items.REDSTONE,
				ModPotions.LONG_FREEZE);

		//strength enhancements
		BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.DENSITY, Items.GLOWSTONE_DUST,
				ModPotions.STRONG_DENSITY);

		//corruptions
		BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.MOMENTUM, Items.FERMENTED_SPIDER_EYE,
				ModPotions.FREEZE);
		BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.LONG_MOMENTUM, Items.FERMENTED_SPIDER_EYE,
				ModPotions.LONG_FREEZE);
		BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.FREEZE, Items.FERMENTED_SPIDER_EYE,
				ModPotions.MOMENTUM);
		BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.LONG_FREEZE, Items.FERMENTED_SPIDER_EYE,
				ModPotions.LONG_MOMENTUM);
		BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.SLOW_FALLING, Items.FERMENTED_SPIDER_EYE,
				ModPotions.DENSITY);
		BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.LONG_SLOW_FALLING, Items.FERMENTED_SPIDER_EYE,
				ModPotions.STRONG_DENSITY);
		BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.DENSITY, Items.FERMENTED_SPIDER_EYE,
				Potions.SLOW_FALLING);
		BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.STRONG_DENSITY, Items.FERMENTED_SPIDER_EYE,
				Potions.LONG_SLOW_FALLING);
	}
}
