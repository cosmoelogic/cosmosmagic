package net.cosmo.cosmosmagic.mixins;

import net.cosmo.cosmosmagic.block.ModBlocks;
import net.cosmo.cosmosmagic.effect.ModEffects;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class MomentumMixin {
	LivingEntity entity = ((LivingEntity) (Object) this);
	Block standingOnBlock;
	@Inject(method = "jump", at = @At("HEAD"))
	private void jump(CallbackInfo ci) {
		BlockPos entityBlockPos = entity.getBlockPos();
		standingOnBlock = entity.getWorld().getBlockState(new BlockPos(entityBlockPos.getX(), entityBlockPos.getY() - 1, entityBlockPos.getZ())).getBlock();
	}
	@Inject(method = "jump", at = @At("TAIL"))
	private void onJump(CallbackInfo ci) {
		if (standingOnBlock == ModBlocks.MOMENTUM_CRYSTAL_BLOCK || entity.hasStatusEffect(ModEffects.MOMENTUM)) {
			Vec3d boostVec = getBoostVec((LivingEntity) (Object) this);
			entity.addVelocity(boostVec.x, boostVec.y, boostVec.z);
		}
	}

	private static Vec3d getBoostVec(LivingEntity entity) {
		Vec3d entityPos = entity.getPos();
		assert MinecraftClient.getInstance().crosshairTarget != null;
		Vec3d crosshairTarget = MinecraftClient.getInstance().crosshairTarget.getPos();
		Vec3d boostVec = new Vec3d(crosshairTarget.x - entityPos.x, 1, crosshairTarget.z - entityPos.z);
		if (Math.abs(crosshairTarget.x - entityPos.x) <= 2 && Math.abs(crosshairTarget.z - entityPos.z) <= 2) boostVec = new Vec3d(boostVec.x * 0.3, boostVec.y * 1.5, boostVec.z * 0.3 );
		if (entity.hasStatusEffect(ModEffects.MOMENTUM)) boostVec = new Vec3d(boostVec.x * .5, boostVec.y / .5, boostVec.z * .5);
		return boostVec;

	}
	@Inject(method = "damage", at = @At("HEAD"), cancellable = true)
	public void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
		if (source.isFromFalling()) {
			if (entity.hasStatusEffect(ModEffects.MOMENTUM)) cir.setReturnValue(false);
			BlockPos standingOnBlockPos = new BlockPos(entity.getBlockPos().getX(), entity.getBlockPos().getY() - 1, entity.getBlockPos().getZ());
			if (entity.getWorld().getBlockState(standingOnBlockPos).getBlock() == ModBlocks.MOMENTUM_CRYSTAL_BLOCK) cir.setReturnValue(false);
			for (Direction direction : Direction.values()) {
				BlockPos offsetPos = standingOnBlockPos.offset(direction);
				if (entity.getWorld().getBlockState(offsetPos).getBlock() == ModBlocks.MOMENTUM_CRYSTAL_BLOCK) {
					cir.setReturnValue(false);
				}
			}
		}
	}
}