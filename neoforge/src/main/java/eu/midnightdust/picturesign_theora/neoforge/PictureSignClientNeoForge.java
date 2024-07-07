package eu.midnightdust.picturesign_theora.neoforge;

import eu.midnightdust.picturesign_theora.PictureSignTheoraClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@SuppressWarnings("all")
@Mod(value = "picturesign-theora", dist = Dist.CLIENT)
public class PictureSignClientNeoForge {
    public PictureSignClientNeoForge() {
        PictureSignTheoraClient.init();
    }
}