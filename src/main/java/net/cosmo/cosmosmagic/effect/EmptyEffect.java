package net.cosmo.cosmosmagic.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EmptyEffect extends StatusEffect {
	public EmptyEffect(StatusEffectCategory statusEffectCategory, int color) {
		super(statusEffectCategory, color);
	}
	@Override
	public void applyUpdateEffect(LivingEntity entity, int pAmplifier) {
		if (entity.world.isClient()) return;
		super.applyUpdateEffect(entity, pAmplifier);
	}

	@Override
	public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
		return true;
	}
}