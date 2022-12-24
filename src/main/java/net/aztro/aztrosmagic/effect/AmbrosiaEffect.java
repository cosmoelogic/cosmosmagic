package net.aztro.aztrosmagic.effect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;

public class AmbrosiaEffect extends StatusEffect {
	public AmbrosiaEffect(StatusEffectCategory statusEffectCategory, int color) {
		super(statusEffectCategory, color);
	}
	int i = 0;
	@Override
	public void applyUpdateEffect(LivingEntity player, int pAmplifier) {
		PlayerEntity playerEntity = (PlayerEntity) player;
		HungerManager hungerManager = playerEntity.getHungerManager();
		if (player.world.isClient()) return;
		if (i == 20) {
			if (hungerManager.isNotFull())hungerManager.add(1, 1);
			else if (player.getHealth() < player.getMaxHealth()) player.heal(1.0f);
			else if (player.getAbsorptionAmount() < 10) player.setAbsorptionAmount(player.getAbsorptionAmount() + pAmplifier);
			i = 0;
		}
		i++;
		super.applyUpdateEffect(player, pAmplifier);
	}

	@Override
	public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
		return true;
	}
}