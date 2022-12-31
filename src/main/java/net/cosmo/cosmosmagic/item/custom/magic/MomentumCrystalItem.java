package net.cosmo.cosmosmagic.item.custom.magic;

import net.cosmo.cosmosmagic.item.ModItems;
import net.cosmo.cosmosmagic.item.utils.AmmoManager;
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

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;

public class MomentumCrystalItem extends Item {
	public MomentumCrystalItem(Settings settings) {
		super(settings);
	}


	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand)
	{
		if (player.hasVehicle()) {
			player.stopRiding();
		}
		if (!Boost.isPlayerMoving(player) && player.isSneaking()) return new TypedActionResult<>(ActionResult.FAIL, player.getStackInHand(hand));
		Boost.boostPlayer(player);
		AmmoManager.decrementHolding(player, hand);
		return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
	}
	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(Text.translatable("Right click to boost yourself forward").formatted(Formatting.GREEN));
		tooltip.add(Text.translatable("Hold shift and right click to reduce your momentum to 0.").formatted(Formatting.GREEN));
		tooltip.add(Text.translatable("Hit an enemy with this crystal to send them flying.").formatted(Formatting.GREEN));
		tooltip.add(Text.translatable("ONE TIME USE").formatted(Formatting.RED));
	}
	public static class Boost {
		private static Vec3d getBoostVec(PlayerEntity playerEntity) {
			Vec3d playerPos = playerEntity.getPos();
			assert MinecraftClient.getInstance().crosshairTarget != null;
			Vec3d crosshairTarget = MinecraftClient.getInstance().crosshairTarget.getPos();
			Vec3d playerVelocity = playerEntity.getVelocity();
			Vec3d boostVec = new Vec3d((crosshairTarget.x - playerPos.x) * 1.5, -playerEntity.getPitch()/36, (crosshairTarget.z - playerPos.z) * 1.5);
			if (playerEntity.getPitch() < 10 && playerEntity.getPitch() > -5) {
				if (playerEntity.isOnGround()) boostVec = new Vec3d(boostVec.x , 1, boostVec.z); else boostVec = new Vec3d(boostVec.x , boostVec.y*2, boostVec.z);
			}
			if (abs(playerVelocity.x) >= 3) {
				boostVec = new Vec3d(0, boostVec.y, boostVec.z);
			}
			if (abs(playerVelocity.y) >= 3) {
				boostVec = new Vec3d(boostVec.x, 0, boostVec.z);
			}
			if (abs(playerVelocity.z) >= 3) {
				boostVec = new Vec3d(boostVec.x, boostVec.y, 0);
			}
			return boostVec;
		}

		public static void boostPlayer(PlayerEntity player){
			if (!player.isSneaking()) {
				Vec3d boostVec = Boost.getBoostVec(player);
				player.addVelocity(boostVec.x, boostVec.y, boostVec.z);
			} else player.setVelocity(0, 0, 0); player.fallDistance = 0;
		}
		public static void boostEnemy(PlayerEntity player, Entity entity){
			if (player.isSpectator() || player.getMainHandStack().isOf(ModItems.MOMENTUM_CRYSTAL)) return;
			Vec3d boostVec = getBoostVec(player);
			double[] boostVec_sorted = {Math.abs(boostVec.x), Math.abs(boostVec.z)};
			Arrays.sort(boostVec_sorted);
			if (boostVec_sorted[1] < 3) {
				if (Math.abs(boostVec_sorted[0]) >= Math.abs(boostVec_sorted[1])){
					if (boostVec_sorted[0] > 0) boostVec_sorted[0] += boostVec.x - Math.abs(boostVec.z)/2;
					if (boostVec_sorted[0] < 0) boostVec_sorted[0] -= Math.abs(boostVec.x) - Math.abs(boostVec.z)/2;
				} else {
					if (boostVec.z > 0) boostVec = new Vec3d(boostVec.x, boostVec.y, boostVec.z + boostVec.z - Math.abs(boostVec.x)/2);
					else boostVec = new Vec3d(boostVec.x, boostVec.y, boostVec.z - Math.abs(boostVec.z) - Math.abs(boostVec.x)/2);
				}
			}
			if (entity.isOnGround()) boostVec = new Vec3d(boostVec.x, 10, boostVec.z); else boostVec = new Vec3d(boostVec.x, 4, boostVec.z);
			entity.addVelocity(boostVec.x, boostVec.y, boostVec.z);
			AmmoManager.decrementItem(player, ModItems.MOMENTUM_CRYSTAL);
		}
		private static boolean isPlayerMoving(PlayerEntity player) {
			double[] v = {Math.abs(player.getVelocity().x), Math.abs(player.getVelocity().y), Math.abs(player.getVelocity().z)};
			Arrays.sort(v);
			return v[v.length - 1] != 0;
		}
	}
}
