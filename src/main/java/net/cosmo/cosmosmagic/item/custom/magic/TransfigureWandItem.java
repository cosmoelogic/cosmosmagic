package net.cosmo.cosmosmagic.item.custom.magic;

import net.cosmo.cosmosmagic.item.ModItems;
import net.cosmo.cosmosmagic.item.utils.DurabilityManager;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.List;

import static net.cosmo.cosmosmagic.world.RayTracing.rayCast;

public class TransfigureWandItem extends Item{
	public Block transfigureBlock;
	public TransfigureWandItem(Settings settings, Block transfigureBlock) {
		super(settings);
		this.transfigureBlock = transfigureBlock;
	}
	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand)
	{
		ItemStack itemStack = player.getStackInHand(hand);
		BlockHitResult blockHitResult = (BlockHitResult) player.raycast(5.0, 1, true);
		BlockPos blockPos = blockHitResult.getBlockPos();
		Direction direction = blockHitResult.getSide();
		BlockPos blockPos2 = blockPos.offset(direction);
		if (blockHitResult.getType() == HitResult.Type.MISS) return TypedActionResult.pass(itemStack);
		if (blockHitResult.getType() != HitResult.Type.BLOCK) return TypedActionResult.pass(itemStack);
		if ((player.getMainHandStack().getRarity() == Rarity.EPIC && player.isSneaking())) {
			if (!world.getBlockState(blockPos).isOf(transfigureBlock)) return new TypedActionResult<>(ActionResult.FAIL, player.getStackInHand(hand));
			world.setBlockState(blockPos, Blocks.AIR.getDefaultState());
			DurabilityManager.damageItem(player, hand, -1);
			return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
		}
		if (world.getBlockState(blockPos2).getHardness(world, blockPos2) > 2) return new TypedActionResult<>(ActionResult.FAIL, player.getStackInHand(hand));
		world.setBlockState(blockPos2, transfigureBlock.getDefaultState());
		DurabilityManager.damageItem(player, hand, 1);
		return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(Text.translatable("Right click to turn the block you're looking at into").formatted(Formatting.DARK_GREEN));
		if (itemStack.getItem() == ModItems.AQUA_WAND) tooltip.add(Text.translatable("WATER").formatted(Formatting.DARK_BLUE));
		if (itemStack.getItem() == ModItems.MAGMA_WAND) tooltip.add(Text.translatable("LAVA").formatted(Formatting.DARK_RED));
		if (itemStack.getRarity() == Rarity.EPIC) tooltip.add(Text.translatable("Potency Amplifier: Right click while sneaking to refill wand").formatted(Formatting.LIGHT_PURPLE));
		DurabilityManager.addMagicDurabilityToolTip(itemStack, tooltip);
	}
	@Override
	public boolean hasGlint(ItemStack stack) {
		if (stack.getRarity() == Rarity.EPIC) return true;
		else return stack.hasEnchantments();
	}
}
