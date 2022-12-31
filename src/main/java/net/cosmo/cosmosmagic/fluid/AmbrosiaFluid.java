package net.cosmo.cosmosmagic.fluid;

import net.cosmo.cosmosmagic.block.ModBlocks;
import net.cosmo.cosmosmagic.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.world.World;

import java.util.Optional;


public abstract class AmbrosiaFluid extends AbstractAmbrosiaFluid {
	public AmbrosiaFluid() {
	}
	@Override
	public Item getBucketItem() {
		return ModItems.AMBROSIA_BUCKET;
	}

	@Override
	protected BlockState toBlockState(FluidState fluidState) {
		return ModBlocks.AMBROSIA.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
	}
	@Override
	public ParticleEffect getParticle() {
		return ParticleTypes.DRIPPING_HONEY;
	}
	@Override
	public Fluid getFlowing() {
		return ModFluids.AMBROSIA_FLOWING;
	}

	@Override
	public Fluid getStill() {
		return ModFluids.AMBROSIA_STILL;
	}
	public Optional<SoundEvent> getBucketFillSound() {
		return Optional.of(SoundEvents.ITEM_BUCKET_FILL);
	}

	public static class Flowing extends AmbrosiaFluid {
		public Flowing() {
		}
		@Override
		protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
			super.appendProperties(builder);
			builder.add(LEVEL);
		}

		@Override
		protected boolean isInfinite(World world) {
			return false;
		}

		@Override
		public int getLevel(FluidState state) {
			return state.get(LEVEL);
		}

		@Override
		public boolean isStill(FluidState fluidState) {
			return false;
		}
	}

	public static class Still extends AmbrosiaFluid {
		public Still() {
		}

		@Override
		protected boolean isInfinite(World world) {
			return false;
		}


		@Override
		public int getLevel(FluidState fluidState) {
			return 8;
		}

		@Override
		public boolean isStill(FluidState fluidState) {
			return true;
		}
	}
}
