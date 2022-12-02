package com.aztro.aztrosmod.registry;

import com.aztro.aztrosmod.aztrosmod;
import com.aztro.aztrosmod.items.ChaosWandItem;
import com.aztro.aztrosmod.items.ExplosiveWandItem;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

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

	public static void registerItems() {
		Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "cut_diamond"), CUT_DIAMOND);
		Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "cut_diamond_block"), CUT_DIAMOND_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "waxed_diamond_block"), WAXED_DIAMOND_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "crude_diamond"), CRUDE_DIAMOND);
		Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "zombie_jerky"), ZOMBIE_JERKY);
		Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "glowstone_bricks"), GLOWSTONE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "glowstone_brick_stairs"), GLOWSTONE_BRICK_STAIRS);
		Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "glowstone_brick_slab"), GLOWSTONE_BRICK_SLAB);
		Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "positive_energy_stone"), POSITIVE_ENERGY_STONE);
		Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "negative_energy_stone"), NEGATIVE_ENERGY_STONE);
		Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "neutral_energy_stone"), NEUTRAL_ENERGY_STONE);
		Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "chaos_wand"), CHAOS_WAND);
		Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "explosive_wand"), EXPLOSIVE_WAND);
		FuelRegistry.INSTANCE.add(Items.MUSHROOM_STEM, 200);
		FuelRegistry.INSTANCE.add(Items.BROWN_MUSHROOM_BLOCK, 200);
		FuelRegistry.INSTANCE.add(Items.RED_MUSHROOM_BLOCK, 200);
	}
}
