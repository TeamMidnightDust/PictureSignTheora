package eu.midnightdust.picturesign_theora.util;

import eu.midnightdust.picturesign.util.MediaHandler;
import eu.midnightdust.picturesign_theora.ogv.Video;
import eu.midnightdust.picturesign_theora.ogv.VideoManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.opengl.GL11;

public class TheoraMediaHandler extends MediaHandler {
    public static final VideoManager manager = new VideoManager();
    private Video player;
    private String url;

    public TheoraMediaHandler(Identifier id, BlockPos pos) {
        super(id, pos);
        mediaHandlers.put(id, this);
    }
    @Override
    public void setVolume(int volume) {
        player.setVolume((int) (volume * MinecraftClient.getInstance().options.getSoundVolume(SoundCategory.MASTER)));
    }

    @Override
    public void closePlayer() {
        manager.closePlayer(id);
        if (player != null) {
            player.stop();
            player.destroy();
        }
        //mediaPlayers.remove(id);
        player = null;
    }
    @Override
    public void stop() {
        player.stop();
        isDeactivated = true;
    }
    @Override
    public boolean isStopped() {
        return player.isStopped();
    }
    @Override
    public void restart() {
        player.play(url);
    }

    @Override
    public void play(String url, boolean isVideo) {
        System.out.println("Playing: " + url);
        this.player = manager.getOrCreate(id);
        mediaHandlers.put(id, this);
        //if (player.isBroken()) return;
        player.play(url);
        this.url = url;
        this.playbackStarted = true;
    }
    @Override
    public boolean hasMedia() {
        return player != null && player.hasMedia();
    }
    @Override
    public void setRepeat(boolean value) {
        player.setRepeat(true);
    }
    @Override
    public long getTime() {
        return player.getTime();
    }
    @Override
    public void setTime(long value) {
        player.setTime(value);
    }
    @Override
    public int getTexture() {
        if (player != null) {
            int tex = player.getTextureId();
            if (GL11.glIsTexture(tex)) return tex;
        }
        return -1;
    }
    @Override
    public boolean isReady() {
        return true;
    }
    @Override
    public boolean isWorking() {
        return mediaHandlers.containsKey(id) && mediaHandlers.get(id) instanceof TheoraMediaHandler theoraMediaHandler
                && theoraMediaHandler.player != null;
    }
}
