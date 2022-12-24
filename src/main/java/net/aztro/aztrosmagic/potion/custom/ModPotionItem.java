package net.aztro.aztrosmagic.potion.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModPotionItem extends PotionItem {
	private static final int MAX_USE_TIME = 32;
	public StatusEffect effect;
	public int duration, amplifier;
	public ModPotionItem(StatusEffect effect, int duration, int amplifier, Settings settings) {
		super(settings);
		this.effect = effect;
		this.duration = duration;
		this.amplifier = amplifier;
	}
	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {}
	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity player) {
		player.addStatusEffect(new StatusEffectInstance(effect, duration, amplifier));
		return super.finishUsing(stack, world, player);
	}
}
