package eu.midnightdust.picturesign_theora.fabric;

import eu.midnightdust.picturesign_theora.PictureSignTheoraClient;
import net.fabricmc.api.ClientModInitializer;

public class PictureSignTheoraClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PictureSignTheoraClient.init();
    }
}
