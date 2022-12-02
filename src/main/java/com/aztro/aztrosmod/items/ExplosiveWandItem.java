package com.aztro.aztrosmod.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;
import net.minecraft.client.MinecraftClient;
import net.minecraft.world.explosion.Explosion;

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
		if (!playerEntity.isCreative()) {
			if (!playerEntity.getInventory().main.stream().anyMatch(stack -> stack.isOf(Items.REDSTONE_BLOCK)))
				return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
			for (int i = 0; i < playerEntity.getInventory().size(); i++) {
				if (playerEntity.getInventory().getStack(i).isOf(Items.REDSTONE_BLOCK)) {
					playerEntity.getInventory().removeStack(i, 1);
					break;
				}
			}
			playerEntity.damage(DamageSource.MAGIC, 2.0f);
		}
		world.createExplosion(playerEntity, playerEntity.getPos().x, playerEntity.getPos().y, playerEntity.getPos().z, 2.0f, false, Explosion.DestructionType.NONE);
		Vec3d crosshairTarget = MinecraftClient.getInstance().crosshairTarget.getPos();
		double[] knockbackAmount = {Math.min((playerEntity.getPos().x - crosshairTarget.x) /2, 1.5), playerEntity.getPitch()/60,Math.min((playerEntity.getPos().z - crosshairTarget.z) /2, 1.5)};
		if (abs(playerEntity.getVelocity().x) >= 3) {
			knockbackAmount[0] = 0;
		}
		if (abs(playerEntity.getVelocity().y) >= 3) {
			knockbackAmount[1] = 0;
		}
		if (abs(playerEntity.getVelocity().z) >= 3) {
			knockbackAmount[2] = 0;
		}
		playerEntity.addVelocity(knockbackAmount[0], knockbackAmount[1], knockbackAmount[2]);
		return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
	}




	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(Text.translatable("Generates an explosion at the player.").formatted(Formatting.GREEN));
		tooltip.add(Text.translatable("Blasts the player away from their crosshair.").formatted(Formatting.BLUE));
		tooltip.add(Text.translatable("Requires redstone blocks as ammo.").formatted(Formatting.RED));
	}
}
