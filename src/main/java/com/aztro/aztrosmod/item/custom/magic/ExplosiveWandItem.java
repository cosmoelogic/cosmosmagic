package com.aztro.aztrosmod.item.custom.magic;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.client.MinecraftClient;
import net.minecraft.world.explosion.Explosion;

import com.aztro.aztrosmod.item.AmmoManager;
import java.util.List;

import static java.lang.Math.abs;


public class ExplosiveWandItem extends Item {
	public ExplosiveWandItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
		if (playerEntity.hasVehicle()) {
			playerEntity.stopRiding();
		}
		if (AmmoManager.itemIsNotInInventory(playerEntity, Items.REDSTONE_BLOCK)) return new TypedActionResult<>(ActionResult.FAIL, playerEntity.getStackInHand(hand));
		AmmoManager.decrementItem(playerEntity, Items.REDSTONE_BLOCK);
		playerEntity.damage(DamageSource.MAGIC, 2.0f);
		world.createExplosion(playerEntity, playerEntity.getPos().x, playerEntity.getPos().y, playerEntity.getPos().z, 2.0f, false, Explosion.DestructionType.NONE);
		double[] knockbackVel = getKnockbackVel(playerEntity);
		playerEntity.addVelocity(knockbackVel[0], knockbackVel[1], knockbackVel[2]);
		return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
	}
	private double[] getKnockbackVel(PlayerEntity playerEntity) {
		Vec3d playerPos = playerEntity.getPos();
		assert MinecraftClient.getInstance().crosshairTarget != null;
		Vec3d crosshairTarget = MinecraftClient.getInstance().crosshairTarget.getPos();
		Vec3d playerVelocity = playerEntity.getVelocity();
		double[] knockbackAmount = {Math.min((playerPos.x - crosshairTarget.x) /2, 1.5), playerEntity.getPitch()/60,Math.min((playerPos.z - crosshairTarget.z) /2, 1.5)};
		if (abs(playerVelocity.x) >= 3) {
			knockbackAmount[0] = 0;
		}
		if (abs(playerVelocity.y) >= 3) {
			knockbackAmount[1] = 0;
		}
		if (abs(playerVelocity.z) >= 3) {
			knockbackAmount[2] = 0;
		}
		return knockbackAmount;
	}


	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(Text.translatable("Generates an explosion at the player.").formatted(Formatting.GREEN));
		tooltip.add(Text.translatable("Blasts the player away from their crosshair.").formatted(Formatting.BLUE));
		tooltip.add(Text.translatable("Requires redstone blocks as ammo.").formatted(Formatting.RED));
	}
}
