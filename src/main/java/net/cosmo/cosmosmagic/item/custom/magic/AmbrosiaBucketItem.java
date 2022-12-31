package net.cosmo.cosmosmagic.item.custom.magic;

import net.cosmo.cosmosmagic.effect.ModEffects;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidDrainable;
import net.minecraft.block.FluidFillable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class AmbrosiaBucketItem extends BucketItem {
	private static final int MAX_USE_TIME = 48;
	private final Fluid fluid;

	public AmbrosiaBucketItem(Fluid fluid, Item.Settings settings) {
		super(fluid, settings);
		this.fluid = fluid;
	}
	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		PlayerEntity player = context.getPlayer();
		Hand hand = context.getHand();
		World world = context.getWorld();
		assert player != null;
		ItemStack itemStack = player.getStackInHand(hand);
		BlockHitResult blockHitResult = raycast(world, player, this.fluid == Fluids.EMPTY ? RaycastContext.FluidHandling.SOURCE_ONLY : RaycastContext.FluidHandling.NONE);
		if (blockHitResult.getType() == HitResult.Type.MISS) return ActionResult.PASS;
		else if (blockHitResult.getType() != HitResult.Type.BLOCK) return ActionResult.PASS;
		BlockPos blockPos = blockHitResult.getBlockPos();
		Direction direction = blockHitResult.getSide();
		BlockPos blockPos2 = blockPos.offset(direction);
		if (world.canPlayerModifyAt(player, blockPos) && player.canPlaceOn(blockPos2, direction, itemStack)) {
			BlockState blockState;
			if (this.fluid == Fluids.EMPTY) {
				blockState = world.getBlockState(blockPos);
				if (blockState.getBlock() instanceof FluidDrainable fluidDrainable) {
					ItemStack itemStack2 = fluidDrainable.tryDrainFluid(world, blockPos, blockState);
					if (!itemStack2.isEmpty()) {
						player.incrementStat(Stats.USED.getOrCreateStat(this));
						fluidDrainable.getBucketFillSound().ifPresent((sound) -> player.playSound(sound, 1.0F, 1.0F));
						world.emitGameEvent(player, GameEvent.FLUID_PICKUP, blockPos);
						ItemUsage.exchangeStack(itemStack, player, itemStack2);
						if (!world.isClient) {
							Criteria.FILLED_BUCKET.trigger((ServerPlayerEntity)player, itemStack2);
						}

						return ActionResult.success(world.isClient());
					}
				}

				return ActionResult.FAIL;
			} else {
				blockState = world.getBlockState(blockPos);
				BlockPos blockPos3 = blockState.getBlock() instanceof FluidFillable && this.fluid == Fluids.WATER ? blockPos : blockPos2;
				if (this.placeFluid(player, world, blockPos3, blockHitResult)) {
					this.onEmptied(player, world, itemStack, blockPos3);
					if (player instanceof ServerPlayerEntity) {
						Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity)player, blockPos3, itemStack);
					}
					player.setStackInHand(hand, getEmptiedStack(itemStack, player));
					return ActionResult.success(world.isClient());
				} else {
					return ActionResult.FAIL;
				}
			}
		} else {
			return ActionResult.FAIL;
		}
	}
	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity player) {
		if (player instanceof ServerPlayerEntity serverPlayerEntity) {
			Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
			serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
		}

		if (player instanceof PlayerEntity && !((PlayerEntity)player).getAbilities().creativeMode) {
			stack.decrement(1);
		}

		if (!world.isClient) {
			player.addStatusEffect(new StatusEffectInstance(ModEffects.AMBROSIA, 150, 0));
		}

		return stack.isEmpty() ? new ItemStack(Items.BUCKET) : stack;
	}
	@Override
	public int getMaxUseTime(ItemStack stack) {
		return MAX_USE_TIME;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.DRINK;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		return ItemUsage.consumeHeldItem(world, user, hand);
	}
}