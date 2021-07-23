package com.aztro.aztrosmod.registry;

import com.aztro.aztrosmod.aztrosmod;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item CUT_DIAMOND = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

    public static final Item CUT_DIAMOND_BLOCK = new BlockItem(ModBlocks.CUT_DIAMOND_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "cut_diamond"), CUT_DIAMOND);
        Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "cut_diamond_block"), CUT_DIAMOND_BLOCK);
    }
}
