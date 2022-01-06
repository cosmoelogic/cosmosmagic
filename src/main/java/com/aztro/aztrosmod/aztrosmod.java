package com.aztro.aztrosmod;

import com.aztro.aztrosmod.registry.ModArmor;
import com.aztro.aztrosmod.registry.ModBlocks;
import com.aztro.aztrosmod.registry.ModItems;
import com.aztro.aztrosmod.registry.ModTools;
import com.aztro.aztrosmod.update.UpdateChecker;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class aztrosmod implements ModInitializer {

    public static final String MOD_ID = "aztros";
    public static final String MOD_VERSION = "0.9.2";

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "general"),
            () -> new ItemStack(ModItems.CUT_DIAMOND_BLOCK)
    );

    @Override
    public void onInitialize() {
        System.out.printf("%s: Thanks for using Aztro's Mod%n", MOD_ID);
        ModItems.registerItems();
        System.out.printf("%s: Items registered.%n", MOD_ID);
        ModBlocks.registerBlocks();
        System.out.printf("%s: Blocks registered.%n", MOD_ID);
        ModArmor.registerArmor();
        System.out.printf("%s: Armor registered.%n", MOD_ID);
        ModTools.registerTools();
        System.out.printf("%s: Tools registered.%n", MOD_ID);
        UpdateChecker.checkForUpdates();
    }
}