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

//    private static final Identifier DIAMOND_ORE_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/diamond_ore");
//    private static final Identifier DEEPSLATE_DIAMOND_ORE_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/deepslate_diamond_ore");
//    private static final Identifier CUT_DIAMOND_BLOCK_LOOT_TABLE_ID = new Identifier(MOD_ID, "blocks/cut_diamond_block");

//    MinecraftClient mc = MinecraftClient.getInstance();

    @Override
    public void onInitialize() {
        System.out.printf("%s: Thanks for using Aztro's Mod%n", MOD_ID);
        ModItems.registerItems();
        System.out.printf("%s: Items registered.%n", MOD_ID);
        ModBlocks.registerBlocks();
        System.out.printf("%s: Blocks registered.%n", MOD_ID);
        ModArmor.register();
        System.out.printf("%s: Armor registered.%n", MOD_ID);
        ModTools.register();
        System.out.printf("%s: Tools registered.%n", MOD_ID);
        UpdateChecker.checkForUpdates();
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