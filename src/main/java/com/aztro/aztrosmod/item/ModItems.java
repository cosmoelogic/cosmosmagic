package com.aztro.aztrosmod.item;

import com.aztro.aztrosmod.aztrosmod;
import com.aztro.aztrosmod.item.custom.magic.ChaosWandItem;
import com.aztro.aztrosmod.item.custom.magic.ExplosiveWandItem;
import com.aztro.aztrosmod.item.custom.magic.MomentumCrystalItem;
import com.aztro.aztrosmod.block.ModBlocks;
import com.aztro.aztrosmod.item.custom.magic.YouthCrystalItem;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import static com.aztro.aztrosmod.aztrosmod.MOD_ID;


public class ModItems {

	//cut diamond stuff
	public static final Item CUT_DIAMOND = new Item(new Item.Settings().group(aztrosmod.ITEM_GROUP));
	public static final Item CUT_DIAMOND_BLOCK = new BlockItem(ModBlocks.CUT_DIAMOND_BLOCK, new Item.Settings().group(aztrosmod.ITEM_GROUP));

	//waxed diamond
	public static final Item WAXED_DIAMOND_BLOCK = new BlockItem(ModBlocks.WAXED_DIAMOND_BLOCK, new Item.Settings().group(aztrosmod.ITEM_GROUP));

	//crude diamond
	public static final Item CRUDE_DIAMOND = new Item(new Item.Settings().group(aztrosmod.ITEM_GROUP));

	//jerky
	public static final Item ZOMBIE_JERKY = new Item(new Item.Settings().group(aztrosmod.ITEM_GROUP).food(new FoodComponent.Builder().hunger(2).saturationModifier(1f).build()));

	//glow stone bricks
	public static final Item GLOWSTONE_BRICKS = new BlockItem(ModBlocks.GLOWSTONE_BRICKS, new Item.Settings().group(aztrosmod.ITEM_GROUP));
	public static final Item GLOWSTONE_BRICK_STAIRS = new BlockItem(ModBlocks.GLOWSTONE_BRICK_STAIRS, new Item.Settings().group(aztrosmod.ITEM_GROUP));
	public static final Item GLOWSTONE_BRICK_SLAB = new BlockItem(ModBlocks.GLOWSTONE_BRICK_SLAB, new Item.Settings().group(aztrosmod.ITEM_GROUP));

	//magic items
	public static final Item POSITIVE_ENERGY_STONE = new Item(new Item.Settings().group(aztrosmod.ITEM_GROUP));
	public static final Item NEGATIVE_ENERGY_STONE = new Item(new Item.Settings().group(aztrosmod.ITEM_GROUP));
	public static final Item NEUTRAL_ENERGY_STONE = new Item(new Item.Settings().group(aztrosmod.ITEM_GROUP));

	public static final ChaosWandItem CHAOS_WAND = new ChaosWandItem(new Item.Settings().group(aztrosmod.ITEM_GROUP).maxCount(1).rarity(Rarity.RARE));
	public static final ExplosiveWandItem EXPLOSIVE_WAND = new ExplosiveWandItem(new Item.Settings().group(aztrosmod.ITEM_GROUP).maxCount(1).rarity(Rarity.RARE));

	public static final MomentumCrystalItem MOMENTUM_CRYSTAL = new MomentumCrystalItem(new Item.Settings().group(aztrosmod.ITEM_GROUP).maxCount(16).rarity(Rarity.RARE));
	public static final Item RAW_MOMENTUM_CRYSTAL = new Item(new Item.Settings().group(aztrosmod.ITEM_GROUP).maxCount(16).rarity(Rarity.UNCOMMON));
	public static final Item MOMENTUM_CRYSTAL_ORE = new BlockItem(ModBlocks.MOMENTUM_CRYSTAL_ORE, new Item.Settings().group(aztrosmod.ITEM_GROUP));
	public static final Item DEEPSLATE_MOMENTUM_CRYSTAL_ORE = new BlockItem(ModBlocks.DEEPSLATE_MOMENTUM_CRYSTAL_ORE, new Item.Settings().group(aztrosmod.ITEM_GROUP));
	public static final Item YOUTH_CRYSTAL = new YouthCrystalItem(new Item.Settings().group(aztrosmod.ITEM_GROUP).maxCount(16).rarity(Rarity.RARE));

	public static final Item UNDEAD_ESSENCE = new Item(new Item.Settings().group(aztrosmod.ITEM_GROUP).maxCount(64).rarity(Rarity.UNCOMMON));



	public static void registerItems() {
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cut_diamond"), CUT_DIAMOND);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cut_diamond_block"), CUT_DIAMOND_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "waxed_diamond_block"), WAXED_DIAMOND_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "crude_diamond"), CRUDE_DIAMOND);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "zombie_jerky"), ZOMBIE_JERKY);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "glowstone_bricks"), GLOWSTONE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "glowstone_brick_stairs"), GLOWSTONE_BRICK_STAIRS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "glowstone_brick_slab"), GLOWSTONE_BRICK_SLAB);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "positive_energy_stone"), POSITIVE_ENERGY_STONE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "negative_energy_stone"), NEGATIVE_ENERGY_STONE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "neutral_energy_stone"), NEUTRAL_ENERGY_STONE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chaos_wand"), CHAOS_WAND);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "explosive_wand"), EXPLOSIVE_WAND);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "momentum_crystal"), MOMENTUM_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "raw_momentum_crystal"), RAW_MOMENTUM_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "momentum_crystal_ore"), MOMENTUM_CRYSTAL_ORE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "deepslate_momentum_crystal_ore"), DEEPSLATE_MOMENTUM_CRYSTAL_ORE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "undead_essence"), UNDEAD_ESSENCE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "youth_crystal"), YOUTH_CRYSTAL);




		FuelRegistry.INSTANCE.add(Items.MUSHROOM_STEM, 200);
		FuelRegistry.INSTANCE.add(Items.BROWN_MUSHROOM_BLOCK, 200);
		FuelRegistry.INSTANCE.add(Items.RED_MUSHROOM_BLOCK, 200);

		System.out.printf("%s: Items registered.%n", MOD_ID);
	}
}
