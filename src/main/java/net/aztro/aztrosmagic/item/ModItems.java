package net.aztro.aztrosmagic.item;

import net.aztro.aztrosmagic.aztrosmagic;
import net.aztro.aztrosmagic.fluid.ModFluids;
import net.aztro.aztrosmagic.item.custom.magic.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.lang.reflect.Field;


public class ModItems {

	//jerky
	public static final Item ZOMBIE_JERKY = new Item(new Item.Settings()
			.food(new FoodComponent.Builder().hunger(2).saturationModifier(1f).build()));


	//magic items
	public static final Item POSITIVE_ENERGY_STONE = new Item(new Item.Settings());
	public static final Item NEGATIVE_ENERGY_STONE = new Item(new Item.Settings());
	public static final Item NEUTRAL_ENERGY_STONE = new Item(new Item.Settings());

	public static final Item RAW_MOMENTUM_CRYSTAL = new Item(new Item.Settings().maxCount(16).rarity(Rarity.UNCOMMON));
	public static final Item UNDEAD_ESSENCE = new Item(new Item.Settings().maxCount(64).rarity(Rarity.UNCOMMON));
	public static final Item CREEPY_ESSENCE = new Item(new Item.Settings().maxCount(64).rarity(Rarity.UNCOMMON));

	public static final AmbrosiaBucketItem AMBROSIA_BUCKET = new AmbrosiaBucketItem(ModFluids.AMBROSIA_STILL, new Item.Settings().maxCount(1).rarity(Rarity.EPIC));

	public static final ChaosWandItem CHAOS_WAND = new ChaosWandItem(10, new Item.Settings()
			.maxCount(1).rarity(Rarity.RARE).maxDamage(15));
	public static final ChaosWandItem CHAOS_WAND_POTENT = new ChaosWandItem(200, new Item.Settings()
			.maxCount(1).rarity(Rarity.EPIC).maxDamage(30));
	public static final ExplosiveWandItem EXPLOSIVE_WAND = new ExplosiveWandItem(new Item.Settings()
			.maxCount(1).rarity(Rarity.RARE).maxDamage(20));

	public static final TransfigureWandItem MAGMA_WAND = new TransfigureWandItem(new Item.Settings()
			.maxCount(1).rarity(Rarity.RARE).maxDamage(15), Blocks.LAVA);
	public static final TransfigureWandItem AQUA_WAND = new TransfigureWandItem(new Item.Settings()
			.maxCount(1).rarity(Rarity.RARE).maxDamage(15), Blocks.WATER);
	public static final TransfigureWandItem MAGMA_WAND_POTENT = new TransfigureWandItem(new Item.Settings()
			.maxCount(1).rarity(Rarity.EPIC).maxDamage(15), Blocks.LAVA);
	public static final TransfigureWandItem AQUA_WAND_POTENT = new TransfigureWandItem(new Item.Settings()
			.maxCount(1).rarity(Rarity.EPIC).maxDamage(15), Blocks.WATER);

	public static final MomentumCrystalItem MOMENTUM_CRYSTAL = new MomentumCrystalItem(new Item.Settings()
			.maxCount(16).rarity(Rarity.RARE));

	public static void registerItems() {
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "zombie_jerky"), ZOMBIE_JERKY);
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "positive_energy_stone"), POSITIVE_ENERGY_STONE);
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "negative_energy_stone"), NEGATIVE_ENERGY_STONE);
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "neutral_energy_stone"), NEUTRAL_ENERGY_STONE);
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "chaos_wand"), CHAOS_WAND);
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "chaos_wand_potent"), CHAOS_WAND_POTENT);
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "explosive_wand"), EXPLOSIVE_WAND);
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "momentum_crystal"), MOMENTUM_CRYSTAL);
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "raw_momentum_crystal"), RAW_MOMENTUM_CRYSTAL);
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "undead_essence"), UNDEAD_ESSENCE);
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "creepy_essence"), CREEPY_ESSENCE);
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "ambrosia_bucket"), AMBROSIA_BUCKET);
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "magma_wand"), MAGMA_WAND);
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "aqua_wand"), AQUA_WAND);
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "magma_wand_potent"), MAGMA_WAND_POTENT);
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "aqua_wand_potent"), AQUA_WAND_POTENT);

		FuelRegistry.INSTANCE.add(Items.MUSHROOM_STEM, 200);
		FuelRegistry.INSTANCE.add(Items.BROWN_MUSHROOM_BLOCK, 200);
		FuelRegistry.INSTANCE.add(Items.RED_MUSHROOM_BLOCK, 200);
		for (Field field : ModItems.class.getDeclaredFields()) {
			try {
				Object value = field.get(null);
				if (value instanceof Item item) {
					ItemGroupEvents.modifyEntriesEvent(aztrosmagic.ITEM_GROUP).register(content -> content.add(item));
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("%s: Items registered.%n", aztrosmagic.MOD_ID);
	}
}
