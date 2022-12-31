package net.cosmo.cosmosmagic;

import net.cosmo.cosmosmagic.block.ModBlocks;
import net.cosmo.cosmosmagic.effect.ModEffects;
import net.cosmo.cosmosmagic.event.AttackEntityHandler;
import net.cosmo.cosmosmagic.event.UseEntityHandler;
import net.cosmo.cosmosmagic.features.ModConfiguredFeatures;
import net.cosmo.cosmosmagic.features.ModPlacedFeatures;
import net.cosmo.cosmosmagic.item.ModArmorMaterials;
import net.cosmo.cosmosmagic.item.ModBlockItems;
import net.cosmo.cosmosmagic.item.ModItems;
import net.cosmo.cosmosmagic.item.ModToolMaterials;
import net.cosmo.cosmosmagic.update.UpdateChecker;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class cosmosmagic implements ModInitializer {
	public static final String MOD_ID = "cosmos";
	public static final String MOD_VERSION = "0.9.2";

	public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier(MOD_ID, "general"))
			.icon(() -> new ItemStack(ModItems.RAW_MOMENTUM_CRYSTAL))
			.build();
	public static final ItemGroup BLOCK_ITEM_GROUP = FabricItemGroup.builder(new Identifier(MOD_ID, "blocks"))
			.icon(() -> new ItemStack(ModBlockItems.MOMENTUM_CRYSTAL_BLOCK))
			.build();

	@Override
	public void onInitialize() {
		System.out.printf("%s: Thanks for using cosmo's Mod%n", MOD_ID);
		UpdateChecker.checkForUpdates();
		ModBlocks.registerBlocks();
		ModItems.registerItems();
		ModEffects.registerEffects();
		ModBlockItems.registerBlockItems();
		ModArmorMaterials.registerArmor();
		ModToolMaterials.registerTools();
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModPlacedFeatures.registerPlacedFeatures();
		AttackEntityCallback.EVENT.register(new AttackEntityHandler());
		UseEntityCallback.EVENT.register(new UseEntityHandler());
	}
}