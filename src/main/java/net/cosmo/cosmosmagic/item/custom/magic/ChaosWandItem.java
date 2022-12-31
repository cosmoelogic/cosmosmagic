package net.cosmo.cosmosmagic.item.custom.magic;

import net.cosmo.cosmosmagic.item.utils.DurabilityManager;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.List;

import static net.minecraft.util.Formatting.*;


public class ChaosWandItem extends Item {
	double maxDistance;
	public ChaosWandItem(double maxDistance, Settings settings) {
		super(settings);
		this.maxDistance = maxDistance;
	}
	@Override
	public boolean hasGlint(ItemStack stack) {
		if (stack.getRarity() == Rarity.EPIC) return true;
		else return stack.hasEnchantments();
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand)
	{
		if (player.hasVehicle()) {
			player.stopRiding();
		}
		ItemStack itemStack = player.getStackInHand(hand);
		BlockHitResult blockHitResult = (BlockHitResult) player.raycast(maxDistance, 1, false);
		BlockPos blockPos = blockHitResult.getBlockPos();
		Direction direction = blockHitResult.getSide();
		BlockPos blockPos2 = blockPos.offset(direction);
		if (itemStack.getRarity() == Rarity.EPIC) {
			if (blockHitResult.getType() == HitResult.Type.MISS) {
				return new TypedActionResult<>(ActionResult.PASS, itemStack);
			} else if (blockHitResult.getType() != HitResult.Type.BLOCK) {
				return new TypedActionResult<>(ActionResult.PASS, itemStack);
			}
		}
		player.teleport(blockPos2.getX(), blockPos2.getY(), blockPos2.getZ());
		player.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
		DurabilityManager.damageItem(player, hand, 1);
		return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(Text.translatable("Teleports the player in the" ).formatted(GREEN));
		tooltip.add(Text.translatable("direction of their crosshair").formatted(GREEN));
		tooltip.add(Text.translatable("").append(Text.translatable("Range: ").formatted(YELLOW)).append(Text.translatable(String.valueOf((int)maxDistance)).formatted(itemStack.getRarity() == Rarity.EPIC ? LIGHT_PURPLE : AQUA).append(Text.translatable(itemStack.getRarity() == Rarity.EPIC ? " (Potency Amplifier Applied)" : "")).formatted(LIGHT_PURPLE)));
		DurabilityManager.addMagicDurabilityToolTip(itemStack, tooltip);
	}
}
