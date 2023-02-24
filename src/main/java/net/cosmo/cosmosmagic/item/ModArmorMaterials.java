package net.cosmo.cosmosmagic.item;

import net.cosmo.cosmosmagic.cosmosmagic;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.lang.reflect.Field;

public class ModArmorMaterials {

//	public static class StuddedLeather implements ArmorMaterial {
//		private static final int[] BASE_DURABILITY = new int[]{76, 88, 82, 60}; //boots, leggings, chestplate, helmet ---- divided by 2
//		private static final int[] PROTECTION_VALUES = new int[]{2, 4, 5, 1}; //boots, leggings, chestplate, helmet
//
//		@Override
//		public int getDurability(EquipmentSlot slot) {
//			return BASE_DURABILITY[slot.getEntitySlotId()] * 2;
//		}
//
//		@Override
//		public int getProtectionAmount(EquipmentSlot slot) {
//			return PROTECTION_VALUES[slot.getEntitySlotId()];
//		}
//
//		@Override
//		public int getEnchantability() {
//			return 1;
//		}
//
//		@Override
//		public SoundEvent getEquipSound() {
//			return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
//		}
//
//		@Override
//		public Ingredient getRepairIngredient() {
//			return Ingredient.ofItems(StuddedLeatherItems.STUDDED_LEATHER_HELMET);
//		}
//
//		@Override
//		public String getName() {
//			return "studded_leather";
//		}
//
//		@Override
//		public float getToughness() {
//			return 0.0F;
//		}
//
//		@Override
//		public float getKnockbackResistance() {
//			return 0.0F;
//		}
//	}
//
//	public static class StuddedLeatherItems {
//
//		public static final ArmorMaterial CUSTOM_ARMOR_MATERIAL = new StuddedLeather();
//		// If you made a new material, this is where you would note it.
//		public static final Item STUDDED_LEATHER_HELMET = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings());
//		public static final Item STUDDED_LEATHER_CHESTPLATE = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings());
//		public static final Item STUDDED_LEATHER_LEGGINGS = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings());
//		public static final Item STUDDED_LEATHER_BOOTS = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings());
//
//	}
//	public static void registerArmor() {
//		Registry.register(Registries.ITEM, new Identifier(cosmosmagic.MOD_ID, "studded_leather_helmet"), StuddedLeatherItems.STUDDED_LEATHER_HELMET);
//		Registry.register(Registries.ITEM, new Identifier(cosmosmagic.MOD_ID, "studded_leather_chestplate"), StuddedLeatherItems.STUDDED_LEATHER_CHESTPLATE);
//		Registry.register(Registries.ITEM, new Identifier(cosmosmagic.MOD_ID, "studded_leather_leggings"), StuddedLeatherItems.STUDDED_LEATHER_LEGGINGS);
//		Registry.register(Registries.ITEM, new Identifier(cosmosmagic.MOD_ID, "studded_leather_boots"), StuddedLeatherItems.STUDDED_LEATHER_BOOTS);
//
//		for (Field field : StuddedLeatherItems.class.getDeclaredFields()) {
//			try {
//				Object value = field.get(null);
//				if (value instanceof Item item) {
//					ItemGroupEvents.modifyEntriesEvent(cosmosmagic.ITEM_GROUP).register(content -> content.add(item));
//				}
//			} catch (IllegalAccessException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.printf("%s: Armor registered.%n", cosmosmagic.MOD_ID);
//	}
}