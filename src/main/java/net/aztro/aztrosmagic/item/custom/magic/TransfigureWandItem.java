package net.aztro.aztrosmagic.item.custom.magic;

import net.aztro.aztrosmagic.item.ModItems;
import net.aztro.aztrosmagic.item.utils.DurabilityManager;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class TransfigureWandItem extends Item{
	public Block transfigureBlock;
	public TransfigureWandItem(Settings settings, Block transfigureBlock) {
		super(settings);
		this.transfigureBlock = transfigureBlock;
	}
	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand)
	{
		assert MinecraftClient.getInstance().crosshairTarget != null;
		Vec3d crosshairTargetPos = MinecraftClient.getInstance().crosshairTarget.getPos();
		BlockPos crosshairBlockPos = new BlockPos(crosshairTargetPos.x, crosshairTargetPos.y, crosshairTargetPos.z);
		if ((player.isHolding(ModItems.EPIC_AQUA_WAND) || player.isHolding(ModItems.EPIC_MAGMA_WAND)) && player.isSneaking()) {
			if (!world.getBlockState(crosshairBlockPos).isOf(transfigureBlock)) return new TypedActionResult<>(ActionResult.FAIL, player.getStackInHand(hand));
			world.setBlockState(crosshairBlockPos, Blocks.AIR.getDefaultState());
			DurabilityManager.damageItem(player, hand, -1);
			return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
		}
		if (world.getBlockState(crosshairBlockPos).getHardness(world, crosshairBlockPos) > 2) return new TypedActionResult<>(ActionResult.FAIL, player.getStackInHand(hand));
		world.setBlockState(crosshairBlockPos, transfigureBlock.getDefaultState());
		DurabilityManager.damageItem(player, hand, 1);
		return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(Text.translatable("Right click to turn the block you're looking at into").formatted(Formatting.DARK_GREEN));
		if (itemStack.getItem() == ModItems.AQUA_WAND) tooltip.add(Text.translatable("WATER").formatted(Formatting.DARK_BLUE));
		if (itemStack.getItem() == ModItems.MAGMA_WAND) tooltip.add(Text.translatable("LAVA").formatted(Formatting.DARK_RED));
		if (itemStack.getRarity() == Rarity.EPIC) tooltip.add(Text.translatable("Epic Enhancement: Right click while sneaking to refill wand").formatted(Formatting.LIGHT_PURPLE));
		DurabilityManager.addMagicDurabilityToolTip(itemStack, tooltip);
	}
}
