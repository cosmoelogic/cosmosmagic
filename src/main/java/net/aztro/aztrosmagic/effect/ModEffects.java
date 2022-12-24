package net.aztro.aztrosmagic.effect;

import net.aztro.aztrosmagic.aztrosmagic;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
	public static StatusEffect AMBROSIA;

	public static StatusEffect registerStatusEffect(String name) {
		return Registry.register(Registries.STATUS_EFFECT, new Identifier(aztrosmagic.MOD_ID, name),
				new AmbrosiaEffect(StatusEffectCategory.BENEFICIAL, 16766720));
	}

	public static void registerEffects() {
		AMBROSIA = registerStatusEffect("ambrosia");
	}
}