package net.cosmo.cosmosmagic.block;

import net.cosmo.cosmosmagic.cosmosmagic;
import net.cosmo.cosmosmagic.fluid.ModFluids;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.Material;
import net.minecraft.block.SlabBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
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

	public static final Block MOMENTUM_CRYSTAL_BLOCK = new Block(FabricBlockSettings
			.of(Material.STONE)
			.requiresTool()
			.strength(5.0f, 10.0f)
			.sounds(BlockSoundGroup.AMETHYST_BLOCK));

	public static Block AMBROSIA = new FluidBlock(ModFluids.AMBROSIA_STILL, FabricBlockSettings.of(Material.WATER)
			.dropsNothing()
			.noCollision()
			.suffocates((state, world, pos) -> false)
			.luminance((state) -> 10)
			.blockVision((state, world, pos) -> true)
			.nonOpaque());

	public static void registerBlocks() {
		Registry.register(Registries.BLOCK, new Identifier(cosmosmagic.MOD_ID, "glowstone_bricks"), GLOWSTONE_BRICKS);
		Registry.register(Registries.BLOCK, new Identifier(cosmosmagic.MOD_ID, "glowstone_brick_stairs"), GLOWSTONE_BRICK_STAIRS);
		Registry.register(Registries.BLOCK, new Identifier(cosmosmagic.MOD_ID, "glowstone_brick_slab"), GLOWSTONE_BRICK_SLAB);
		Registry.register(Registries.BLOCK, new Identifier(cosmosmagic.MOD_ID, "momentum_crystal_ore"), MOMENTUM_CRYSTAL_ORE);
		Registry.register(Registries.BLOCK, new Identifier(cosmosmagic.MOD_ID, "deepslate_momentum_crystal_ore"), DEEPSLATE_MOMENTUM_CRYSTAL_ORE);
		Registry.register(Registries.BLOCK, new Identifier(cosmosmagic.MOD_ID, "momentum_crystal_block"), MOMENTUM_CRYSTAL_BLOCK);
		Registry.register(Registries.BLOCK, new Identifier(cosmosmagic.MOD_ID, "ambrosia"), AMBROSIA);

		System.out.printf("%s: Blocks registered.%n", cosmosmagic.MOD_ID);
	}
}