package net.aztro.aztrosmagic.item;

import net.aztro.aztrosmagic.aztrosmagic;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.lang.reflect.Field;

public class ModToolMaterials {
	public static class DiamondTippedMaterial implements ToolMaterial {
		public static final DiamondTippedMaterial INSTANCE = new DiamondTippedMaterial();
		@Override
		public int getDurability() {
			return 300;
		}
		@Override
		public float getAttackDamage() {
			return 2.0F;
		}
		@Override
		public int getMiningLevel() {
			return 3;
		}
		@Override
		public int getEnchantability() {
			return 14;
		}
		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.ofItems(Items.IRON_INGOT);
		}
		@Override
		public float getMiningSpeedMultiplier() {
			return 7.0f;
		}

	}

	public static class  DiamondTippedItems {
		public static final ToolItem DIAMOND_TIPPED_PICKAXE = new DiamondTippedPickaxe(DiamondTippedMaterial.INSTANCE, 1, -2.8F, new Item.Settings());
	}
	public static class DiamondTippedPickaxe extends PickaxeItem {
		public DiamondTippedPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
			super(material, attackDamage, attackSpeed, settings);
		}
	}
	public static void registerTools() {
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "diamond_tipped_iron_pickaxe"), DiamondTippedItems.DIAMOND_TIPPED_PICKAXE);
		for (Field field : DiamondTippedItems.class.getDeclaredFields()) {
			try {
				Object value = field.get(null);
				if (value instanceof Item item) {
					ItemGroupEvents.modifyEntriesEvent(aztrosmagic.ITEM_GROUP).register(content -> content.add(item));
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("%s: Tools registered.%n", aztrosmagic.MOD_ID);
	}
}
