package net.aztro.aztrosmagic.potion;

import net.aztro.aztrosmagic.aztrosmagic;
import net.aztro.aztrosmagic.effect.ModEffects;
import net.aztro.aztrosmagic.potion.custom.ModPotionItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.lang.reflect.Field;

public class ModPotions {
	///////AMBROSIA POTION I MADE BEFORE FIGURING OUT A DRINKABLE AND PLACEABLE BUCKET OF AMBROSIA
	/*
	public static ModPotionItem AMBROSIA_BOTTLE = new ModPotionItem(ModEffects.AMBROSIA, 100, 1, new Item.Settings().rarity(Rarity.RARE));
	public static void registerPotions() {
		Registry.register(Registries.ITEM, new Identifier(aztrosmagic.MOD_ID, "ambrosia_bottle"), AMBROSIA_BOTTLE);

		for (Field field : ModPotions.class.getDeclaredFields()) {
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
	 */
}
