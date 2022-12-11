package com.aztro.aztrosmod.fluid;

import com.aztro.aztrosmod.aztrosmod;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import static com.aztro.aztrosmod.aztrosmod.MOD_ID;

public class ModFluids {
	public static FlowableFluid STILL_AMBROSIA = new AmbrosiaFluid.Still();
	public static FlowableFluid FLOWING_AMBROSIA = new AmbrosiaFluid.Flowing();
	public static Item AMBROSIA_BUCKET;
	public static Block AMBROSIA = new FluidBlock(STILL_AMBROSIA, FabricBlockSettings.copy(Blocks.WATER).suffocates((state, world, pos) -> false).luminance((state) -> 10).blockVision((state, world, pos) -> true).nonOpaque());
	public static void registerFluids() {
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "ambrosia"), AMBROSIA);
		Registry.register(Registry.FLUID, new Identifier(MOD_ID, "flowing_ambrosia"), FLOWING_AMBROSIA);
		Registry.register(Registry.FLUID, new Identifier(MOD_ID, "still_ambrosia"), STILL_AMBROSIA);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "ambrosia_bucket"),
				new BucketItem(STILL_AMBROSIA, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1).group(aztrosmod.ITEM_GROUP).rarity(Rarity.RARE)));
		System.out.printf("%s: Fluids registered.%n", MOD_ID);
	}
	public static void renderFluids() {
		FluidRenderHandlerRegistry.INSTANCE.register(STILL_AMBROSIA, FLOWING_AMBROSIA, new SimpleFluidRenderHandler(
				new Identifier("aztros:blocks/ambrosia_still"),
				new Identifier("aztros:blocks/ambrosia_flow"),
				0x4CC248
		));

		BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), STILL_AMBROSIA, FLOWING_AMBROSIA);
		ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
			registry.register(new Identifier(MOD_ID, "blocks/ambrosia_still"));
			registry.register(new Identifier(MOD_ID, "blocks/ambrosia_flow"));
		});

			System.out.printf("%s: Fluids rendered.%n", MOD_ID);
	}
}