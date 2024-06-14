package me.voidxwalker.worldpreview.client.fabric;

import me.voidxwalker.worldpreview.WorldPreview;
import net.fabricmc.api.ClientModInitializer;

public class WorldPreviewFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        WorldPreview.init();
    }
}
