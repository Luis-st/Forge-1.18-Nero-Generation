package net.luis.nero.common.world.biome.vanilla.overworld.type;

import net.luis.nero.api.common.world.biome.IBiomeType;
import net.luis.nero.api.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.common.world.biome.util.BiomeSettings;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum BadlandsBiomeType implements IBiomeType {
	
	BADLANDS(null, BiomeSettings.getBadlandsFeatures(false, false, false), true, false),
	WINDSWEPT_BADLANDS(null, BiomeSettings.getBadlandsFeatures(true, false, false), false, true),
	ERODED_BADLANDS(null, BiomeSettings.getBadlandsFeatures(true, false, true), false, false),
	MODIFIED_WINDSWEPT_BADLANDS(null, BiomeSettings.getBadlandsFeatures(true, false, false), false, true),
	WOODED_WINDSWEPT_BADLANDS(null, BiomeSettings.getBadlandsFeatures(true, true, false), false, true),
	MODIFIED_WOODED_WINDSWEPT_BADLANDS(null, BiomeSettings.getBadlandsFeatures(true, true, false), false, true);
	
	private final IBiomeNoise biomeNoise;
	private final BiomeGenerationSettings generationSettings;
	private final boolean island;
	private final boolean windswept;
	
	private BadlandsBiomeType(IBiomeNoise biomeNoise, BiomeGenerationBuilder generationBuilder, boolean island, boolean windswept) {
		this(biomeNoise, generationBuilder.build(), island, windswept);
	}
	
	private BadlandsBiomeType(IBiomeNoise biomeNoise, BiomeGenerationSettings generationSettings, boolean island, boolean windswept) {
		this.biomeNoise = biomeNoise;
		this.generationSettings = generationSettings;
		this.island = island;
		this.windswept = windswept;
	}
	
	@Override
	public float getTemperature() {
		return 2.0F;
	}
	
	@Override
	public IBiomeNoise getBiomeNoise() {
		return this.biomeNoise;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return BiomeSettings.getBadlandsSpawns().build();
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return this.generationSettings;
	}
	
	@Override
	public boolean isOcean() {
		return false;
	}
	
	@Override
	public boolean isIsland() {
		return this.island;
	}
	
	@Override
	public boolean isHilly() {
		return false;
	}

	@Override
	public boolean isWindswept() {
		return this.windswept;
	}
	
}