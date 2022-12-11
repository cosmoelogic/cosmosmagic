package com.aztro.aztrosmod.event;

import com.aztro.aztrosmod.item.ModItems;
import com.aztro.aztrosmod.item.AmmoManager;
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
		if (player.isHolding(ModItems.YOUTH_CRYSTAL)) {
//			if (entity.getType())
//			PassiveEntity babyEntity = (PassiveEntity) entity.getType().create(world);
//			babyEntity.refreshPositionAndAngles(entity.getX(), entity.getY(), entity.getZ(), entity.getYaw(), entity.getPitch());
//			babyEntity.setBaby(true);
//			if (entity.hasCustomName()) {
//				babyEntity.setCustomName(entity.getCustomName());
//				babyEntity.setCustomNameVisible(entity.isCustomNameVisible());
//			}
//
//			babyEntity.setPersistent();
//			world.spawnEntity(babyEntity);
//			entity.discard();
			AmmoManager.decrementItem(player, ModItems.YOUTH_CRYSTAL);
		}
		return ActionResult.PASS;
	}
}