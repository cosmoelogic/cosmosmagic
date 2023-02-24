package net.cosmo.cosmosmagic.item.utils;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;

import java.util.List;


public class DurabilityManager {
	public static void damageItem(PlayerEntity player, Hand hand, int damage) {
		ItemStack itemStack = player.getStackInHand(hand);
		itemStack.damage(damage, player, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND)
	);}
	public static void addMagicDurabilityToolTip(ItemStack itemStack, List<Text> tooltip) {
		tooltip.add(Text.translatable("Mana Remaining: " + (itemStack.getMaxDamage()-itemStack.getDamage()) + "/" + itemStack.getMaxDamage()).formatted(Formatting.GOLD));
	}
}