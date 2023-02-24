package net.cosmo.cosmosmagic.effect;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.Arrays;

public class DensityEffect extends StatusEffect {
	public DensityEffect(StatusEffectCategory statusEffectCategory, int color) {
		super(statusEffectCategory, color);
	}
	private int i = 0;
	BlockPos standingPos;
	Block standingBlock;
	@Override
	public void applyUpdateEffect(LivingEntity player, int pAmplifier) {
		if (player.world.isClient()) return;
		int RATE;
		if (pAmplifier > 0) RATE = 4;
		else RATE = 5;
		Block[] blocks = {Blocks.DIRT, Blocks.DIRT_PATH, Blocks.GRASS_BLOCK, Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE,
				Blocks.ANDESITE, Blocks.GRAVEL, Blocks.SAND, Blocks.SANDSTONE, Blocks.RED_SAND, Blocks.RED_SANDSTONE};
		if (i % RATE == 0) {
			standingPos = new BlockPos(player.getBlockX(), player.getBlockY() - 1, player.getBlockZ());
			standingBlock = player.getWorld().getBlockState(standingPos).getBlock();
			if (Arrays.asList(blocks).contains(standingBlock)) player.getWorld().breakBlock(standingPos, false);
			if (pAmplifier > 0) {
				for (Direction direction : Direction.values()) {
					BlockPos offsetPos = standingPos.offset(direction);
					Block offsetBlock = player.getWorld().getBlockState(offsetPos).getBlock();
					if (Arrays.asList(blocks).contains(offsetBlock)) player.getWorld().breakBlock(offsetPos, false);
				}
			}
		}
		i++;
		super.applyUpdateEffect(player, pAmplifier);
	}

	@Override
	public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
		return true;
	}
}
