package net.cosmo.cosmosmagic.potion;

public class ModPotions {
	///////AMBROSIA POTION I MADE BEFORE FIGURING OUT A DRINKABLE AND PLACEABLE BUCKET OF AMBROSIA
	/*
	public static ModPotionItem AMBROSIA_BOTTLE = new ModPotionItem(ModEffects.AMBROSIA, 100, 1, new Item.Settings().rarity(Rarity.RARE));
	public static void registerPotions() {
		Registry.register(Registries.ITEM, new Identifier(cosmosmagic.MOD_ID, "ambrosia_bottle"), AMBROSIA_BOTTLE);

		for (Field field : ModPotions.class.getDeclaredFields()) {
			try {
				Object value = field.get(null);
				if (value instanceof Item item) {
					ItemGroupEvents.modifyEntriesEvent(cosmosmagic.ITEM_GROUP).register(content -> content.add(item));
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	 */
}
