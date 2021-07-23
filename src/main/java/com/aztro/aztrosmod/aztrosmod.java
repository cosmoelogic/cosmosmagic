package com.aztro.aztrosmod;

import com.aztro.aztrosmod.registry.ModBlocks;
import com.aztro.aztrosmod.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class aztrosmod implements ModInitializer {

    public static final String MOD_ID = "aztros";

    @Override
    public void onInitialize() {
        System.out.println("Hello, Minecraft!");
        ModItems.registerItems();
        ModBlocks.registerBlocks();
    }

}
