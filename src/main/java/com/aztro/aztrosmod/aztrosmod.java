package com.aztro.aztrosmod;

import com.aztro.aztrosmod.event.*;
import com.aztro.aztrosmod.fluid.ModFluids;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import com.aztro.aztrosmod.item.ModArmorMaterials;
import com.aztro.aztrosmod.block.ModBlocks;
import com.aztro.aztrosmod.item.ModItems;
import com.aztro.aztrosmod.item.ModToolMaterials;
import com.aztro.aztrosmod.features.ModConfiguredFeatures;
import com.aztro.aztrosmod.features.ModPlacedFeatures;
import com.aztro.aztrosmod.update.UpdateChecker;
import com.aztro.aztrosmod.event.AttackEntityHandler;



public class aztrosmod implements ModInitializer {

	public static final String MOD_ID = "aztros";
	public static final String MOD_VERSION = "0.9.2";

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "general"),
			() -> new ItemStack(ModItems.POSITIVE_ENERGY_STONE)
	);



	@Override
	public void onInitialize() {
		System.out.printf("%s: Thanks for using Aztro's Mod%n", MOD_ID);
		UpdateChecker.checkForUpdates();
		ModItems.registerItems();
		ModFluids.registerFluids();
		ModBlocks.registerBlocks();
		ModArmorMaterials.registerArmor();
		ModToolMaterials.registerTools();
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModPlacedFeatures.registerPlacedFeatures();
		AttackEntityCallback.EVENT.register(new AttackEntityHandler());
		UseEntityCallback.EVENT.register(new UseEntityHandler());
	}
}