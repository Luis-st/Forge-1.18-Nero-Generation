package net.luis.nero.client.world;

import java.util.function.BiFunction;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;

public class ModDimensionSpecialEffects extends DimensionSpecialEffects {
	
	public static final BiFunction<Integer, Integer, Boolean> FOGGY_FALSE = (x, z) -> false;
	public static final BiFunction<Integer, Integer, Boolean> FOGGY_TRUE = (x, z) -> true;
	
	public static final DimensionSpecialEffects DEEPSLATE = new ModDimensionSpecialEffects(Float.NaN, true, SkyType.NONE, true, false, (vec, worldTime) -> {
		return vec;
	}, FOGGY_FALSE);
	
	protected final BiFunction<Vec3, Float, Vec3> fogColorBrightness;
	protected final BiFunction<Integer, Integer, Boolean> foggyAtPos;
	
	protected ModDimensionSpecialEffects(float cloudLevel, boolean hasGround, SkyType skyType, boolean brightLightmap, boolean ambientLight, BiFunction<Vec3, Float, Vec3> fogColorBrightness, 
			BiFunction<Integer, Integer, Boolean> foggyAtPos) {
		super(cloudLevel, hasGround, skyType, brightLightmap, ambientLight);
		this.fogColorBrightness = fogColorBrightness;
		this.foggyAtPos = foggyAtPos;
	}

	@Override
	public Vec3 getBrightnessDependentFogColor(Vec3 vector, float worldTime) {
		return this.fogColorBrightness.apply(vector, worldTime);
	}

	@Override
	public boolean isFoggyAt(int x, int z) {
		return this.foggyAtPos.apply(x, z);
	}

}
