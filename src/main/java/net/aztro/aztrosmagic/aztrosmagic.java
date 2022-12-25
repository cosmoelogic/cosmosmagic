package net.aztro.aztrosmagic;

import net.aztro.aztrosmagic.block.ModBlocks;
import net.aztro.aztrosmagic.effect.ModEffects;
import net.aztro.aztrosmagic.event.AttackEntityHandler;
import net.aztro.aztrosmagic.event.UseEntityHandler;
import net.aztro.aztrosmagic.features.ModConfiguredFeatures;
import net.aztro.aztrosmagic.features.ModPlacedFeatures;
import net.aztro.aztrosmagic.item.ModArmorMaterials;
import net.aztro.aztrosmagic.item.ModBlockItems;
import net.aztro.aztrosmagic.item.ModItems;
import net.aztro.aztrosmagic.item.ModToolMaterials;
import net.aztro.aztrosmagic.potion.ModPotions;
import net.aztro.aztrosmagic.update.UpdateChecker;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class aztrosmagic implements ModInitializer {
	public static final String MOD_ID = "aztros";
	public static final String MOD_VERSION = "0.9.2";

	public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier(MOD_ID, "general"))
			.icon(() -> new ItemStack(ModItems.RAW_MOMENTUM_CRYSTAL))
			.build();
	public static final ItemGroup BLOCK_ITEM_GROUP = FabricItemGroup.builder(new Identifier(MOD_ID, "blocks"))
			.icon(() -> new ItemStack(ModBlockItems.MOMENTUM_CRYSTAL_BLOCK))
			.build();

	@Override
	public void onInitialize() {
		System.out.printf("%s: Thanks for using Aztro's Mod%n", MOD_ID);
		UpdateChecker.checkForUpdates();
		ModBlocks.registerBlocks();
		ModItems.registerItems();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModBlockItems.registerBlockItems();
		ModArmorMaterials.registerArmor();
		ModToolMaterials.registerTools();
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModPlacedFeatures.registerPlacedFeatures();
		AttackEntityCallback.EVENT.register(new AttackEntityHandler());
		UseEntityCallback.EVENT.register(new UseEntityHandler());
	}
}