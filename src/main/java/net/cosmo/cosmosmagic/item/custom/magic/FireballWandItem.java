package net.cosmo.cosmosmagic.item.custom.magic;

import net.cosmo.cosmosmagic.item.utils.DurabilityManager;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.DragonFireballEntity;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;


import java.util.List;

import static net.cosmo.cosmosmagic.item.ModItems.*;


public class FireballWandItem extends Item {
	public FireballWandItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand)
	{
		ExplosiveProjectileEntity fireball = null;
		Item holding = player.getMainHandStack().getItem();
		DurabilityManager.damageItem(player, hand, 1);
		if (holding == FIREBALL_WAND) {fireball = new FireballEntity(world, player, 0, 0, 0, 0);}
		if (holding == FIREBALL_WAND_POTENT) {fireball = new FireballEntity(world, player, 0, 0, 0, 2);}
		if (holding == DRAGON_FIREBALL_WAND) {fireball = new DragonFireballEntity(world, player, 0, 0, 0);}
		assert fireball != null;
		fireball.setPos(player.getX(), player.getY() + 1, player.getZ());
		fireball.setYaw(player.getYaw());
		fireball.setVelocity(player, player.getPitch(), player.getYaw(), 0, 1, 0);
		world.spawnEntity(fireball);
		return TypedActionResult.success(player.getStackInHand(hand));
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		PlayerEntity player = context.getPlayer();
		if (player == null || !player.canModifyBlocks() || !player.isHolding(FIREBALL_WAND_POTENT)) {
			return ActionResult.FAIL;
		}
		BlockPos blockPos = context.getBlockPos();
		World world = context.getWorld();
		BlockState state = world.getBlockState(blockPos);
		if (state.getBlock() != Blocks.FIRE) {
			return ActionResult.FAIL;
		}
		BlockPos[] fireBlocks = new BlockPos[2];
		int touchingFireCount = 0;
		for (Direction direction : Direction.values()) {
			BlockPos offsetPos = blockPos.offset(direction);
			BlockState offsetState = world.getBlockState(offsetPos);
			if (offsetState.getBlock() == Blocks.FIRE) {
				if (touchingFireCount < 2) fireBlocks[touchingFireCount] = offsetPos;
				touchingFireCount++;
			}
		}
		if (touchingFireCount >= 2) {
			world.breakBlock(blockPos, false);
			world.breakBlock(fireBlocks[0], false);
			world.breakBlock(fireBlocks[1], false);
			DurabilityManager.damageItem(player, context.getHand(), -1);
			return ActionResult.success(world.isClient);

		}
		return ActionResult.FAIL;
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(Text.translatable("Right click to shoot a fireball").formatted(Formatting.DARK_GREEN));
		if (itemStack.getItem() == FIREBALL_WAND_POTENT) tooltip.add(Text.translatable("Right click to absorb fire").formatted(Formatting.LIGHT_PURPLE));
		if (itemStack.getItem() == FIREBALL_WAND_POTENT) tooltip.add(Text.translatable("Requires 3 flames").formatted(Formatting.LIGHT_PURPLE));
		DurabilityManager.addMagicDurabilityToolTip(itemStack, tooltip);
	}
	@Override
	public boolean hasGlint(ItemStack stack) {
		if (stack.getItem().equals(FIREBALL_WAND_POTENT)) return true;
		else return stack.hasEnchantments();
	}
}
