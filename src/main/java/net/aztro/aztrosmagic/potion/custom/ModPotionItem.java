package net.aztro.aztrosmagic.potion.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModPotionItem extends PotionItem {
	public StatusEffect effect;
	public int duration, amplifier;
	public ModPotionItem(StatusEffect effect, int duration, int amplifier, Settings settings) {
		super(settings);
		this.effect = effect;
		this.duration = duration;
		this.amplifier = amplifier;
	}
	public ModPotionItem(StatusEffect effect, int duration, Settings settings) {
		super(settings);
		this.effect = effect;
		this.duration = duration;
		this.amplifier = 0;
	}
	public ModPotionItem(StatusEffect effect, Settings settings) {
		super(settings);
		this.effect = effect;
		this.duration = 160;
		this.amplifier = 0;
	}
	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {}
	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity player) {
		player.addStatusEffect(new StatusEffectInstance(effect, duration, amplifier));
		return super.finishUsing(stack, world, player);
	}
}
