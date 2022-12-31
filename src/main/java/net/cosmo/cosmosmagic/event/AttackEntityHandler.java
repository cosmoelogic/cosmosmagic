package net.cosmo.cosmosmagic.event;

import net.cosmo.cosmosmagic.item.custom.magic.MomentumCrystalItem;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class AttackEntityHandler implements AttackEntityCallback {
	public ActionResult interact(PlayerEntity player, World world, Hand hand,
								 Entity entity, @Nullable EntityHitResult hitResult) {
		MomentumCrystalItem.Boost.boostEnemy(player, entity);
		return ActionResult.PASS;
	}
}