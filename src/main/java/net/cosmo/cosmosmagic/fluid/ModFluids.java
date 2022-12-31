package net.cosmo.cosmosmagic.fluid;

import net.cosmo.cosmosmagic.cosmosmagic;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
	public static final FlowableFluid AMBROSIA_STILL = register("ambrosia_still", new AmbrosiaFluid.Still());
	public static final FlowableFluid AMBROSIA_FLOWING = register("ambrosia_flowing", new AmbrosiaFluid.Flowing());
	public static FlowableFluid register(String name, FlowableFluid flowableFluid) {return Registry.register(Registries.FLUID, new Identifier(cosmosmagic.MOD_ID, name), flowableFluid);}
	public static void renderFluids() {
		FluidRenderHandlerRegistry.INSTANCE.register(AMBROSIA_STILL, AMBROSIA_FLOWING, new SimpleFluidRenderHandler(
				new Identifier("minecraft:block/water_still"),
				new Identifier("minecraft:block/water_flow"),
				0xFFD700
		));

		BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), AMBROSIA_STILL, AMBROSIA_FLOWING);


		System.out.printf("%s: Fluids rendered.%n", cosmosmagic.MOD_ID);
	}
}