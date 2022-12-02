package com.aztro.aztrosmod.registry;

import com.aztro.aztrosmod.aztrosmod;
import com.aztro.aztrosmod.registry.utils.ModStairsBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

	public static final Block CUT_DIAMOND_BLOCK = new Block(FabricBlockSettings
			.of(Material.METAL)
			.requiresTool()
			.strength(5.0f, 30.0f)
			.sounds(BlockSoundGroup.METAL));

	public static final Block WAXED_DIAMOND_BLOCK = new Block(FabricBlockSettings
			.of(Material.METAL)
			.requiresTool()
			.strength(5.0f, 30.0f)
			.sounds(BlockSoundGroup.METAL)
			.slipperiness(0.9f));

	public static final Block GLOWSTONE_BRICKS = new Block(FabricBlockSettings
			.of(Material.STONE)
			.requiresTool()
			.strength(1.5f, 30.0f)
			.sounds(BlockSoundGroup.DEEPSLATE_BRICKS)
			.luminance(10));
	public static final ModStairsBlock GLOWSTONE_BRICK_STAIRS = new ModStairsBlock(GLOWSTONE_BRICKS.getDefaultState(), FabricBlockSettings
			.of(Material.STONE)
			.requiresTool()
			.strength(1.5f, 30.0f)
			.sounds(BlockSoundGroup.DEEPSLATE_BRICKS)
			.luminance(10));
	public static final SlabBlock GLOWSTONE_BRICK_SLAB = new SlabBlock(FabricBlockSettings
			.of(Material.STONE)
			.requiresTool()
			.strength(1.5f, 30.0f)
			.sounds(BlockSoundGroup.DEEPSLATE_BRICKS)
			.luminance(5));

	public static void registerBlocks() {
		Registry.register(Registry.BLOCK, new Identifier(aztrosmod.MOD_ID, "cut_diamond_block"), CUT_DIAMOND_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(aztrosmod.MOD_ID, "waxed_diamond_block"), WAXED_DIAMOND_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(aztrosmod.MOD_ID, "glowstone_bricks"), GLOWSTONE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(aztrosmod.MOD_ID, "glowstone_brick_stairs"), GLOWSTONE_BRICK_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier(aztrosmod.MOD_ID, "glowstone_brick_slab"), GLOWSTONE_BRICK_SLAB);
	}
}