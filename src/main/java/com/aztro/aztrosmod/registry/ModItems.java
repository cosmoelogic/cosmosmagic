package com.aztro.aztrosmod.registry;

import com.aztro.aztrosmod.aztrosmod;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //cut diamond stuff
    public static final Item CUT_DIAMOND = new Item(new Item.Settings().group(aztrosmod.ITEM_GROUP));
    public static final Item CUT_DIAMOND_BLOCK = new BlockItem(ModBlocks.CUT_DIAMOND_BLOCK, new Item.Settings().group(aztrosmod.ITEM_GROUP));

    //waxed diamond
    public static final Item WAXED_DIAMOND_BLOCK = new BlockItem(ModBlocks.WAXED_DIAMOND_BLOCK, new Item.Settings().group(aztrosmod.ITEM_GROUP));

    //crude diamond
    public static final Item CRUDE_DIAMOND = new Item(new Item.Settings().group(aztrosmod.ITEM_GROUP));

    //jerky
    public static final Item ZOMBIE_JERKY = new Item(new Item.Settings().group(aztrosmod.ITEM_GROUP).food(new FoodComponent.Builder().hunger(2).saturationModifier(1f).build()));

    //glow stone bricks
    public static final Item GLOWSTONE_BRICKS = new BlockItem(ModBlocks.GLOWSTONE_BRICKS, new Item.Settings().group(aztrosmod.ITEM_GROUP));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "cut_diamond"), CUT_DIAMOND);
        Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "cut_diamond_block"), CUT_DIAMOND_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "waxed_diamond_block"), WAXED_DIAMOND_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "crude_diamond"), CRUDE_DIAMOND);
        Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "zombie_jerky"), ZOMBIE_JERKY);
        Registry.register(Registry.ITEM, new Identifier(aztrosmod.MOD_ID, "glowstone_bricks"), GLOWSTONE_BRICKS);
        FuelRegistry.INSTANCE.add(Items.MUSHROOM_STEM, 200);
        FuelRegistry.INSTANCE.add(Items.BROWN_MUSHROOM_BLOCK, 200);
        FuelRegistry.INSTANCE.add(Items.RED_MUSHROOM_BLOCK, 200);
    }
}
