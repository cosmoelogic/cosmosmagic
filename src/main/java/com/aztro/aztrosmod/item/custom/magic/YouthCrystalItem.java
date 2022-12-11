package com.aztro.aztrosmod.item.custom.magic;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;


public class YouthCrystalItem extends Item {
	public YouthCrystalItem(Settings settings) {
		super(settings);
	}
	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(Text.translatable("Right click a mob to de-age it.").formatted(Formatting.GREEN));
		tooltip.add(Text.translatable("ONE TIME USE").formatted(Formatting.RED));
	}
}