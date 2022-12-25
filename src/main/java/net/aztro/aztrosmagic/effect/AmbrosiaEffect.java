package net.aztro.aztrosmagic.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;

public class AmbrosiaEffect extends StatusEffect {
	public AmbrosiaEffect(StatusEffectCategory statusEffectCategory, int color) {
		super(statusEffectCategory, color);
	}
	private int i = 0;

	@Override
	public void applyUpdateEffect(LivingEntity player, int pAmplifier) {
		float strength = 0.5f;
		PlayerEntity playerEntity = (PlayerEntity) player;
		HungerManager hungerManager = playerEntity.getHungerManager();
		if (player.world.isClient()) return;
		final int HEAL_RATE = 25;
		final int ABSORPTION_RATE = 30;
		final int ABSORPTION_CAP = 10;
		final int HUNGER_RATE = 30;
		if (player.getHealth() >= player.getMaxHealth() && i % ABSORPTION_RATE == 0 && player.getAbsorptionAmount() < ABSORPTION_CAP) player.setAbsorptionAmount(player.getAbsorptionAmount() + strength);
		else if (i % HEAL_RATE == 0) player.heal(strength);
		if (i % HUNGER_RATE == 0 && hungerManager.isNotFull()) hungerManager.add(1, 1);
		i++;
		super.applyUpdateEffect(player, pAmplifier);
	}

	@Override
	public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
		return true;
	}
}