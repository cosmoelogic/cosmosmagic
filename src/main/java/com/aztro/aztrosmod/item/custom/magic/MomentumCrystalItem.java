package com.aztro.aztrosmod.item.custom.magic;

import com.aztro.aztrosmod.item.ModItems;
import com.aztro.aztrosmod.item.AmmoManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.*;

import static java.lang.Math.abs;

public class MomentumCrystalItem extends Item {
	public MomentumCrystalItem(Settings settings) {
		super(settings);
	}


	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand)
	{
		if (playerEntity.hasVehicle()) {
			playerEntity.stopRiding();
		}
		if (!isPlayerMoving(playerEntity) && playerEntity.isSneaking()) return new TypedActionResult<>(ActionResult.FAIL, playerEntity.getStackInHand(hand));
		if (!playerEntity.isSneaking()) {
			double[] boostVel = getBoostVel(playerEntity);
			playerEntity.addVelocity(boostVel[0], boostVel[1], boostVel[2]);
		} else playerEntity.setVelocity(0, 0, 0); playerEntity.fallDistance = 0;
		AmmoManager.decrementItem(playerEntity, ModItems.MOMENTUM_CRYSTAL);
		return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
	}
	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(Text.translatable("Right click to boost yourself forward").formatted(Formatting.GREEN));
		tooltip.add(Text.translatable("Hold shift and right click to reduce your momentum to 0.").formatted(Formatting.GREEN));
		tooltip.add(Text.translatable("Hit an enemy with this crystal to send them flying.").formatted(Formatting.GREEN));
		tooltip.add(Text.translatable("ONE TIME USE").formatted(Formatting.RED));
	}

	public static double[] getBoostVel(PlayerEntity playerEntity) {
		Vec3d playerPos = playerEntity.getPos();
		assert MinecraftClient.getInstance().crosshairTarget != null;
		Vec3d crosshairTarget = MinecraftClient.getInstance().crosshairTarget.getPos();
		Vec3d playerVelocity = playerEntity.getVelocity();
		double[] boostArray = {(crosshairTarget.x - playerPos.x) * 1.5, -playerEntity.getPitch()/36, (crosshairTarget.z - playerPos.z) * 1.5};
		if (playerEntity.getPitch() < 10 && playerEntity.getPitch() > -5) {
			if (playerEntity.isOnGround()) boostArray[1] = 1; else boostArray[1] *= 2;
		}
		if (abs(playerVelocity.x) >= 3) {
			boostArray[0] = 0;
		}
		if (abs(playerVelocity.y) >= 3) {
			boostArray[1] = 0;
		}
		if (abs(playerVelocity.z) >= 3) {
			boostArray[2] = 0;
		}
		return boostArray;
	}

	public static void KnockbackEnemy(PlayerEntity player, Entity enemy) {
		if (!player.isSpectator() && player.getMainHandStack().isOf(ModItems.MOMENTUM_CRYSTAL)) {
			double[] boostVel = MomentumCrystalItem.getBoostVel(player);
			double[] boostVel_sorted = {Math.abs(boostVel[0]), Math.abs(boostVel[1])};
			Arrays.sort(boostVel_sorted);
			if (boostVel_sorted[1] < 3) {
				if (Math.abs(boostVel[0]) >= Math.abs(boostVel[2])){
					if (boostVel[0] > 0) boostVel[0] += boostVel[0] - Math.abs(boostVel[2])/2;
					if (boostVel[0] < 0) boostVel[0] -= Math.abs(boostVel[0]) - Math.abs(boostVel[2])/2;
				} else {
					if (boostVel[2] > 0) boostVel[2] += boostVel[2] - Math.abs(boostVel[0])/2;
					if (boostVel[2] < 0) boostVel[2] -= Math.abs(boostVel[2]) - Math.abs(boostVel[0])/2;
				}
			}
			if (enemy.isOnGround()) boostVel[1] = 10; else boostVel[1] = 4;
			enemy.addVelocity(boostVel[0], boostVel[1], boostVel[2]);
			AmmoManager.decrementItem(player, ModItems.MOMENTUM_CRYSTAL);
		}
	}

	private boolean isPlayerMoving(PlayerEntity player) {
		double[] v = {Math.abs(player.getVelocity().x), Math.abs(player.getVelocity().y), Math.abs(player.getVelocity().z)};
		Arrays.sort(v);
		return v[v.length - 1] != 0;
	}

}
