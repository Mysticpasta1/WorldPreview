package me.voidxwalker.worldpreview.forge;

import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.platform.forge.EventBuses;
import me.voidxwalker.worldpreview.WorldPreview;

import net.minecraft.client.MinecraftClient;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(WorldPreview.MOD_ID)
public class WorldPreviewForge {
    public WorldPreviewForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(WorldPreview.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        ClientLifecycleEvent.CLIENT_SETUP.register(new ClientLifecycleEvent.ClientState() {
            @Override
            public void stateChanged(MinecraftClient instance) {
                WorldPreview.init();
            }
        });
    }
}
