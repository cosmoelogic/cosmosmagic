package net.aztro.aztrosmagic.event;


public class GlassBottleHandler {

//	public static class UseItemHandler implements UseItemCallback{
//		@Override
//		public TypedActionResult<ItemStack> interact(PlayerEntity player, World world, Hand hand) {
//			ItemStack itemStack = player.getStackInHand(hand);
//			BlockHitResult hitResult = raycast(world, player, RaycastContext.FluidHandling.SOURCE_ONLY);
//			if (hitResult.getType() == HitResult.Type.MISS) {
//				return TypedActionResult.pass(itemStack);
//			} else {
//				if (hitResult.getType() == HitResult.Type.BLOCK) {
//					BlockPos blockPos = hitResult.getBlockPos();
//					if (!world.canPlayerModifyAt(player, blockPos)) {
//						return TypedActionResult.pass(itemStack);
//					}
//
//					if (world.getFluidState(blockPos).isIn(AMBROSIA)) {
//						world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
//						world.emitGameEvent(player, GameEvent.FLUID_PICKUP, blockPos);
//						return TypedActionResult.success(fill(itemStack, player, PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER)), world.isClient());
//					}
//				}
//
//				return TypedActionResult.pass(itemStack);
//			}
//			TypedActionResult.pass(itemStack);
//			return null;
//		}
//	}
//	protected static ItemStack fill(ItemStack stack, PlayerEntity player, ItemStack outputStack) {
//		return ItemUsage.exchangeStack(stack, player, outputStack);
//	}
//	protected static BlockHitResult raycast(World world, PlayerEntity player, RaycastContext.FluidHandling fluidHandling) {
//		float f = player.getPitch();
//		float g = player.getYaw();
//		Vec3d vec3d = player.getEyePos();
//		float h = MathHelper.cos(-g * 0.017453292F - 3.1415927F);
//		float i = MathHelper.sin(-g * 0.017453292F - 3.1415927F);
//		float j = -MathHelper.cos(-f * 0.017453292F);
//		float k = MathHelper.sin(-f * 0.017453292F);
//		float l = i * j;
//		float n = h * j;
//		double d = 5.0;
//		Vec3d vec3d2 = vec3d.add((double)l * 5.0, (double)k * 5.0, (double)n * 5.0);
//		return world.raycast(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.OUTLINE, fluidHandling, player));
//	}
//	public static final TagKey<Fluid> AMBROSIA = of("ambrosia");
//
//	private static TagKey<Fluid> of(String id) {
//		return TagKey.of(Registry.FLUID_KEY, new Identifier(id));
//	}
}