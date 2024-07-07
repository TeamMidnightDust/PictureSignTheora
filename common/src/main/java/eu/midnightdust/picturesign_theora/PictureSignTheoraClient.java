package eu.midnightdust.picturesign_theora;

import eu.midnightdust.picturesign.util.MediaHandler;
import eu.midnightdust.picturesign_theora.util.TheoraMediaHandler;

public class PictureSignTheoraClient {
    public static void init() {
        MediaHandler.registerHandler(TheoraMediaHandler::new);
    }
}
