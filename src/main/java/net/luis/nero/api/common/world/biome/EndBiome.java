package net.luis.nero.api.common.world.biome;

import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.common.enums.BiomeEffects;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;

public abstract class EndBiome extends ModBiome {
	
	protected EndBiome() {
		super(BiomeEffects.END);
	}

	@Override
	public Precipitation getPrecipitation() {
		return Precipitation.NONE;
	}

	@Override
	public final MobSpawnSettings getMobSpawnSettings() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
//		DefaultModFeatures.addEndSpawns(mobBuilder);
		this.getMobSpawnOverwrite(mobBuilder);
		return mobBuilder.build();
	}

	@Override
	public final BiomeGenerationSettings getBiomeGenerationSettings() {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> this.getSurfaceBuilder());
//		DefaultModFeatures.addEndFeatures(generationBuilder);
		this.getBiomeGenerationOverwrite(generationBuilder);
		return generationBuilder.build();
	}
	
	@Override
	protected ConfiguredSurfaceBuilder<?> getSurfaceBuilder() {
		return SurfaceBuilders.END;
	}
	
}