package net.aztro.aztrosmagic.event;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class UseEntityHandler implements UseEntityCallback {
//	public EntityType[] PassiveEntities = {EntityType.PIG, EntityType.COW, EntityType.SHEEP, EntityType.WOLF, EntityType.};
	public ActionResult interact(PlayerEntity player, World world, Hand hand,
								 Entity entity, @Nullable EntityHitResult hitResult) {
		return ActionResult.PASS;
	}
}