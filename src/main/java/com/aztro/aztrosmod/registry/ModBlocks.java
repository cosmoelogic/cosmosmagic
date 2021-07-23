package com.aztro.aztrosmod.registry;

import com.aztro.aztrosmod.aztrosmod;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.sound.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block CUT_DIAMOND_BLOCK = new Block(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .breakByHand(false)
            .requiresTool()
            .strength(5.0f, 30.0f)
            .sounds(BlockSoundGroup.METAL));

    public static final Block WAXED_DIAMOND_BLOCK = new Block(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .breakByHand(false)
            .requiresTool()
            .strength(5.0f, 30.0f)
            .sounds(BlockSoundGroup.METAL)
            .slipperiness(0.9f));

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(aztrosmod.MOD_ID, "cut_diamond_block"), CUT_DIAMOND_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(aztrosmod.MOD_ID, "waxed_diamond_block"), WAXED_DIAMOND_BLOCK);
    }
}
