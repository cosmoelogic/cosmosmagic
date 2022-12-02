package com.aztro.aztrosmod.items;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
	public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand)
	{
		if (playerEntity.hasVehicle()) {
			playerEntity.stopRiding();
		}
		if (!playerEntity.isCreative()) {
			if (!playerEntity.getInventory().main.stream().anyMatch(stack -> stack.isOf(Items.REDSTONE)))
				return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
			for (int i = 0; i < playerEntity.getInventory().size(); i++) {
				if (playerEntity.getInventory().getStack(i).isOf(Items.REDSTONE)) {
					playerEntity.getInventory().removeStack(i, 1);
					break;
				}
			}
			playerEntity.damage(DamageSource.MAGIC, 3.0f);
		}
		Vec3d crosshairTargetPos = MinecraftClient.getInstance().crosshairTarget.getPos();
		teleport(playerEntity, crosshairTargetPos.x, crosshairTargetPos.y, crosshairTargetPos.z);
		playerEntity.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
		return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
	}

	private static void teleport(PlayerEntity playerEntity, double x, double y, double z) {
		playerEntity.teleport(x, y, z);
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(Text.translatable("Teleports the player up to 5 blocks").formatted(Formatting.GREEN));
		tooltip.add(Text.translatable("in the direction of their crosshair.").formatted(Formatting.GREEN));
		tooltip.add(Text.translatable("Requires redstone dust + health as ammo.").formatted(Formatting.RED));
	}
}
