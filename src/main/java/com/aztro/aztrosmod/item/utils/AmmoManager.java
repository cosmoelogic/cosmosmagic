package com.aztro.aztrosmod.item.utils;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.jetbrains.annotations.Nullable;

public class AmmoManager {
	public static boolean itemIsInInventory(PlayerEntity player, Item item, boolean ignoreCreative) {
		if (player.isCreative() && !ignoreCreative) return true;
		return player.getInventory().main.stream().anyMatch(stack -> stack.isOf(item));
	}
	public static boolean itemIsInInventory(PlayerEntity player, Item item) {
		if (player.isCreative()) return true;
		return player.getInventory().main.stream().anyMatch(stack -> stack.isOf(item));
	}

	public static boolean itemIsNotInInventory(PlayerEntity player, Item item, boolean ignoreCreative) {
		if (player.isCreative() && !ignoreCreative) return false;
		return player.getInventory().main.stream().noneMatch(stack -> stack.isOf(item));
	}
	public static boolean itemIsNotInInventory(PlayerEntity player, Item item) {
		if (player.isCreative()) return false;
		return player.getInventory().main.stream().noneMatch(stack -> stack.isOf(item));
	}

	public static void decrementItem(PlayerEntity player, Item item, boolean ignoreCreative) {
		if (player.isCreative() && !ignoreCreative) return;
		for (int i = 0; i < player.getInventory().size(); i++) {
			if (player.getInventory().getStack(i).isOf(item)) {
				player.getInventory().removeStack(i, 1);
				break;
			}
		}
	}
	public static void decrementItem(PlayerEntity player, Item item) {
		if (player.isCreative()) return;
		for (int i = 0; i < player.getInventory().size(); i++) {
			if (player.getInventory().getStack(i).isOf(item)) {
				player.getInventory().removeStack(i, 1);
				break;
			}
		}
	}
}
