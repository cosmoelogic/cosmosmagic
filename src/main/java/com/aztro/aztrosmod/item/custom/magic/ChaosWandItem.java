package com.aztro.aztrosmod.item.custom.magic;
import com.aztro.aztrosmod.item.AmmoManager;
import net.minecraft.client.item.TooltipContext;
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
		if (AmmoManager.itemIsNotInInventory(playerEntity, Items.REDSTONE)) return new TypedActionResult<>(ActionResult.FAIL, playerEntity.getStackInHand(hand));
		AmmoManager.decrementItem(playerEntity, Items.REDSTONE);
		playerEntity.damage(DamageSource.MAGIC, 3.0f);
		assert MinecraftClient.getInstance().crosshairTarget != null;
		Vec3d crosshairTargetPos = MinecraftClient.getInstance().crosshairTarget.getPos();
		playerEntity.teleport(crosshairTargetPos.x, crosshairTargetPos.y, crosshairTargetPos.z);
		playerEntity.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
		return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(Text.translatable("Teleports the player up to 5 blocks").formatted(Formatting.GREEN));
		tooltip.add(Text.translatable("in the direction of their crosshair.").formatted(Formatting.GREEN));
		tooltip.add(Text.translatable("Requires redstone dust + health as ammo.").formatted(Formatting.RED));
	}
}
