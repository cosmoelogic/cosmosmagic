package com.aztro.aztrosmod.item;

import com.aztro.aztrosmod.aztrosmod;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.aztro.aztrosmod.aztrosmod.MOD_ID;

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
		public static final ToolItem DIAMOND_TIPPED_PICKAXE = new DiamondTippedPickaxe(DiamondTippedMaterial.INSTANCE, 1, -2.8F, new Item.Settings().group(aztrosmod.ITEM_GROUP));
	}
	public static class DiamondTippedPickaxe extends PickaxeItem {
		public DiamondTippedPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
			super(material, attackDamage, attackSpeed, settings);
		}
	}
	public static void registerTools() {
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "diamond_tipped_iron_pickaxe"), DiamondTippedItems.DIAMOND_TIPPED_PICKAXE);

		System.out.printf("%s: Tools registered.%n", MOD_ID);
	}
}
