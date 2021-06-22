package net.luis.nero.event.fml;


import net.luis.nero.client.render.entity.SoulBlazeRenderer;
import net.luis.nero.client.render.entity.SoulFireballRenderer;
import net.luis.nero.client.render.tileentity.BloodAltarTileEntityRenderer;
import net.luis.nero.init.block.util.ModTileEntityTypes;
import net.luis.nero.init.entity.ModEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(bus = Bus.MOD, value = Dist.CLIENT)
public class OnClientSetupEvent {
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		registerEntityRenderer(event);
		registerTileEntityRenderer(event);
	}
	
	protected static void registerTileEntityRenderer(FMLClientSetupEvent event) {
//		ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.MILESTONE.get(), MilestoneTileEntityRenderer::new);
		ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.BLOOD_ALTAR.get(), BloodAltarTileEntityRenderer::new);
	}
	
	protected static void registerEntityRenderer(FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SOUL_BLAZE.get(), SoulBlazeRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SOUL_FIREBALL.get(), SoulFireballRenderer::new);
	}

}
