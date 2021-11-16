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

    public static final Block GLOWSTONE_BRICKS = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 1)
            .breakByHand(true)
            .strength(1.5f, 30.0f)
            .sounds(BlockSoundGroup.DEEPSLATE_BRICKS)
            .luminance(14));

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(aztrosmod.MOD_ID, "cut_diamond_block"), CUT_DIAMOND_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(aztrosmod.MOD_ID, "waxed_diamond_block"), WAXED_DIAMOND_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(aztrosmod.MOD_ID, "glowstone_bricks"), GLOWSTONE_BRICKS);
    }
}