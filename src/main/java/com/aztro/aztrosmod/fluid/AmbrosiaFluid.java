package com.aztro.aztrosmod.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;

import java.util.Optional;


public abstract class AmbrosiaFluid extends AbstractAmbrosiaFluid {
	public AmbrosiaFluid() {
	}
	@Override
	public Item getBucketItem() {
		return ModFluids.AMBROSIA_BUCKET;
	}

	@Override
	protected BlockState toBlockState(FluidState fluidState) {
		return ModFluids.AMBROSIA.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
	}
	@Override
	public Fluid getFlowing() {
		return ModFluids.FLOWING_AMBROSIA;
	}

	@Override
	public Fluid getStill() {
		return ModFluids.STILL_AMBROSIA;
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
		public int getLevel(FluidState fluidState) {
			return 8;
		}

		@Override
		public boolean isStill(FluidState fluidState) {
			return true;
		}
	}
}
