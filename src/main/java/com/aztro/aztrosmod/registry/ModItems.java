package com.aztro.aztrosmod.registry;

import com.aztro.aztrosmod.aztrosmod;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //cut diamond stuff
    public static final Item CUT_DIAMOND = new Item(new Item.Settings().group(aztrosmod.ITEM_GROUP));
    public static final Item CUT_DIAMOND_BLOCK = new BlockItem(ModBlocks.CUT_DIAMOND_BLOCK, new Item.Settings().group(aztrosmod.ITEM_GROUP));

    //crude diamond
    public static final Item CRUDE_DIAMOND = new Item(new Item.Settings().group(aztrosmod.ITEM_GROUP));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "cut_diamond"), CUT_DIAMOND);
        Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "cut_diamond_block"), CUT_DIAMOND_BLOCK);

        Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "crude_diamond"), CRUDE_DIAMOND);
    }
}
