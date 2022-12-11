package com.aztro.aztrosmod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.aztro.aztrosmod.aztrosmod.MOD_ID;

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

	public static final Block MOMENTUM_CRYSTAL_ORE = new Block(FabricBlockSettings
			.of(Material.STONE)
			.requiresTool()
			.strength(3.0f, 6.0f)
			.sounds(BlockSoundGroup.STONE));

	public static final Block DEEPSLATE_MOMENTUM_CRYSTAL_ORE = new Block(FabricBlockSettings
			.of(Material.STONE)
			.requiresTool()
			.strength(4.5f, 6.0f)
			.sounds(BlockSoundGroup.DEEPSLATE));
	public static void registerBlocks() {
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "cut_diamond_block"), CUT_DIAMOND_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "waxed_diamond_block"), WAXED_DIAMOND_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "glowstone_bricks"), GLOWSTONE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "glowstone_brick_stairs"), GLOWSTONE_BRICK_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "glowstone_brick_slab"), GLOWSTONE_BRICK_SLAB);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "momentum_crystal_ore"), MOMENTUM_CRYSTAL_ORE);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "deepslate_momentum_crystal_ore"), DEEPSLATE_MOMENTUM_CRYSTAL_ORE);

		System.out.printf("%s: Blocks registered.%n", MOD_ID);
	}
}