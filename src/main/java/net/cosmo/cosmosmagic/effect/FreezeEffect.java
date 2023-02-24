package net.cosmo.cosmosmagic.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class FreezeEffect extends StatusEffect {
	public FreezeEffect(StatusEffectCategory statusEffectCategory, int color) {
		super(statusEffectCategory, color);
	}
	@Override
	public void applyUpdateEffect(LivingEntity entity, int pAmplifier) {
		if (entity.world.isClient()) return;
		if (entity instanceof PlayerEntity) entity.teleport(entity.getX(), entity.getY(), entity.getZ(), false);
		entity.setVelocity(0d, 0d, 0d);
		super.applyUpdateEffect(entity, pAmplifier);
	}

	@Override
	public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
		return true;
	}
}