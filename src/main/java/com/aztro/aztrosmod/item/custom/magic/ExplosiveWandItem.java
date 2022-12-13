package com.aztro.aztrosmod.item.custom.magic;

import com.aztro.aztrosmod.item.utils.DurabilityManager;
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

import com.aztro.aztrosmod.item.utils.AmmoManager;
import java.util.List;

import static java.lang.Math.abs;


public class ExplosiveWandItem extends Item {
	public ExplosiveWandItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		if (player.hasVehicle()) {
			player.stopRiding();
		}
		if (AmmoManager.itemIsNotInInventory(player, Items.TNT)) return new TypedActionResult<>(ActionResult.FAIL, player.getStackInHand(hand));
		AmmoManager.decrementItem(player, Items.TNT);
		player.damage(DamageSource.MAGIC, 2.0f);
		world.createExplosion(player, player.getPos().x, player.getPos().y, player.getPos().z, 2.0f, false, Explosion.DestructionType.NONE);
		double[] knockbackVel = getKnockbackVel(player);
		player.addVelocity(knockbackVel[0], knockbackVel[1], knockbackVel[2]);
		DurabilityManager.damageItem(player, hand, 1);
		return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
	}
	private double[] getKnockbackVel(PlayerEntity playerEntity) {
		Vec3d playerPos = playerEntity.getPos();
		assert MinecraftClient.getInstance().crosshairTarget != null;
		Vec3d crosshairTarget = MinecraftClient.getInstance().crosshairTarget.getPos();
		Vec3d playerVelocity = playerEntity.getVelocity();
		float playerPitch = playerEntity.getPitch();
		double[] knockbackAmount = {Math.min((playerPos.x - crosshairTarget.x) /2, 1.5), playerPitch/60,Math.min((playerPos.z - crosshairTarget.z) /2, 1.5)};
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
		tooltip.add(Text.translatable("Requires TNT as ammo.").formatted(Formatting.RED));
		DurabilityManager.addMagicDurabilityToolTip(itemStack, tooltip);
	}
}
