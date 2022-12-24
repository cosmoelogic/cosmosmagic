package net.aztro.aztrosmagic.item;

import net.aztro.aztrosmagic.aztrosmagic;
import net.aztro.aztrosmagic.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.lang.reflect.Field;


public class ModBlockItems {
	public static final Item GLOWSTONE_BRICKS = new BlockItem(ModBlocks.GLOWSTONE_BRICKS, new Item.Settings());
	public static final Item GLOWSTONE_BRICK_STAIRS = new BlockItem(ModBlocks.GLOWSTONE_BRICK_STAIRS, new Item.Settings());
	public static final Item GLOWSTONE_BRICK_SLAB = new BlockItem(ModBlocks.GLOWSTONE_BRICK_SLAB, new Item.Settings());
	public static final Item MOMENTUM_CRYSTAL_ORE = new BlockItem(ModBlocks.MOMENTUM_CRYSTAL_ORE, new Item.Settings());
	public static final Item DEEPSLATE_MOMENTUM_CRYSTAL_ORE = new BlockItem(ModBlocks.DEEPSLATE_MOMENTUM_CRYSTAL_ORE, new Item.Settings());
	public static final Item MOMENTUM_CRYSTAL_BLOCK = new BlockItem(ModBlocks.MOMENTUM_CRYSTAL_BLOCK, new Item.Settings().rarity(Rarity.RARE));

	public static void registerBlockItems() {
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "glowstone_bricks"), GLOWSTONE_BRICKS);
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "glowstone_brick_stairs"), GLOWSTONE_BRICK_STAIRS);
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "glowstone_brick_slab"), GLOWSTONE_BRICK_SLAB);
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "momentum_crystal_ore"), MOMENTUM_CRYSTAL_ORE);
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "deepslate_momentum_crystal_ore"), DEEPSLATE_MOMENTUM_CRYSTAL_ORE);
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "momentum_crystal_block"), MOMENTUM_CRYSTAL_BLOCK);
		for (Field field : ModBlockItems.class.getDeclaredFields()) {
			try {
				Object value = field.get(null);
				if (value instanceof Item item) {
					ItemGroupEvents.modifyEntriesEvent(aztrosmagic.ITEM_GROUP).register(content -> content.add(item));
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}