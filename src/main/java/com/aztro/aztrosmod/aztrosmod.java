package com.aztro.aztrosmod;

import com.aztro.aztrosmod.registry.ModArmor;
import com.aztro.aztrosmod.registry.ModBlocks;
import com.aztro.aztrosmod.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class aztrosmod implements ModInitializer {

    public static final String MOD_ID = "aztros";

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "general"),
            () -> new ItemStack(ModItems.CUT_DIAMOND_BLOCK)
    );

    private static final Identifier DIAMOND_ORE_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/diamond_ore");
    private static final Identifier DEEPSLATE_DIAMOND_ORE_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/deepslate_diamond_ore");
    private static final Identifier CUT_DIAMOND_BLOCK_LOOT_TABLE_ID = new Identifier(MOD_ID, "blocks/cut_diamond_block");

    @Override
    public void onInitialize() {
        System.out.println("Hello, Minecraft!");
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        ModArmor.register();
    }

//THIS IS NOT NEEDED RIGHT NOW BUT MAY HELP COMPATIBILITY LATER ON
//    private void modifyLootTables() {
//        LootTableLoadingCallback.EVENT.register(((resourceManager, manager, id, supplier, setter) -> {
//            if (DIAMOND_ORE_LOOT_TABLE_ID.equals(id)) {
//                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder().rolls(ConstantLootTableRange.create())
//            }
//        }));
//    }

}