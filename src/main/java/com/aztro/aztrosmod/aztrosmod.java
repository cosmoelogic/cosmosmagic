package com.aztro.aztrosmod;

import com.aztro.aztrosmod.registry.ModBlocks;
import com.aztro.aztrosmod.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class aztrosmod implements ModInitializer {

    public static final String MOD_ID = "aztros";

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "general"),
            () -> new ItemStack(ModItems.CUT_DIAMOND_BLOCK)
    );

    @Override
    public void onInitialize() {
        System.out.println("Hello, Minecraft!");
        ModItems.registerItems();
        ModBlocks.registerBlocks();
    }

}
