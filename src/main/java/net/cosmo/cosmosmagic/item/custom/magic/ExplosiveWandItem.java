package net.cosmo.cosmosmagic.item.custom.magic;

import net.cosmo.cosmosmagic.item.utils.AmmoManager;
import net.cosmo.cosmosmagic.item.utils.DurabilityManager;
import net.minecraft.client.MinecraftClient;
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
		assert MinecraftClient.getInstance().crosshairTarget != null;
		Vec3d crosshairTarget = MinecraftClient.getInstance().crosshairTarget.getPos();
		player.damage(DamageSource.MAGIC, 2.0f);
		world.createExplosion(player, crosshairTarget.x, crosshairTarget.y, crosshairTarget.z, 2.0f, false, World.ExplosionSourceType.NONE);
		double[] knockbackVel = getKnockbackVel(player, crosshairTarget);
		player.addVelocity(knockbackVel[0], knockbackVel[1], knockbackVel[2]);
		DurabilityManager.damageItem(player, hand, 1);
		return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
	}
	private double[] getKnockbackVel(PlayerEntity playerEntity, Vec3d crosshairTarget) {
		Vec3d playerPos = playerEntity.getPos();
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
