package net.cosmo.cosmosmagic.world;

import net.minecraft.util.math.*;

public class Distance {
	public static double distance(Vec3d v1, Vec3d v2) {
		double dx = v1.x - v2.x;
		double dy = v1.y - v2.y;
		double dz = v1.z - v2.z;
		return Math.sqrt(dx*dx + dy*dy + dz*dz);
	}
	public static double distance(BlockPos v1, BlockPos v2) {
		double dx = v1.getX() - v2.getX();
		double dy = v1.getY() - v2.getY();
		double dz = v1.getZ() - v2.getZ();
		return Math.sqrt(dx*dx + dy*dy + dz*dz);
	}
	public static double distance(double[] v1, double[] v2) {
		double dx = v1[0] - v2[0];
		double dy = v1[1] - v2[1];
		double dz = v1[2] - v2[2];
		return Math.sqrt(dx*dx + dy*dy + dz*dz);
	}
	public static Vec3d individualDistances(Vec3d v1, Vec3d v2) {
		return new Vec3d(v1.getX() - v2.getX(), v1.getY() - v2.getY(), v1.getZ() - v2.getZ());
	}
	public static double[] individualDistances(double[] v1, double[] v2) {
		double[] returnArray = new double[v1.length];
		for (int i = 0; i < v1.length; i++) {
			returnArray[i] = v1[i] - v2[i];
		}
		return returnArray;
	}
}
