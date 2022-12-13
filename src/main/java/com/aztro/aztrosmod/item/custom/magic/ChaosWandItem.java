package com.aztro.aztrosmod.item.custom.magic;
import com.aztro.aztrosmod.item.utils.DurabilityManager;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.client.MinecraftClient;

import java.util.List;


public class ChaosWandItem extends Item {
	public ChaosWandItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand)
	{
		if (player.hasVehicle()) {
			player.stopRiding();
		}
		assert MinecraftClient.getInstance().crosshairTarget != null;
		Vec3d crosshairTargetPos = MinecraftClient.getInstance().crosshairTarget.getPos();
		player.teleport(crosshairTargetPos.x, crosshairTargetPos.y, crosshairTargetPos.z);
		player.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
		DurabilityManager.damageItem(player, hand, 1);
		return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(Text.translatable("Teleports the player up to 5 blocks").formatted(Formatting.GREEN));
		tooltip.add(Text.translatable("in the direction of their crosshair.").formatted(Formatting.GREEN));
		DurabilityManager.addMagicDurabilityToolTip(itemStack, tooltip);
	}
}
