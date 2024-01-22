package net.runelite.client.plugins.playericons;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@Slf4j
@PluginDescriptor(
        name = "IconsTest"
)
public class PlayerIcons extends Plugin {
    @Inject
    private Client client;

    @Inject
    private PlayerIconsConfig config;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private PlayerIconsOverlay playerIconsOverlay;

    @Inject
    private PlayerIconsService playerIconsService;

    @Override
    protected void startUp() throws Exception
    {
        overlayManager.add(playerIconsOverlay);
    }

    @Override
    protected void shutDown() throws Exception
    {
        log.info("IconsTest stopped!");
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged)
    {
        if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
        {
            System.out.println(client.getLocalPlayer().getLogicalHeight());
        }
    }

    @Subscribe
    public void onClientTick(ClientTick clientTick) {

    }

    @Provides
    PlayerIconsConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(PlayerIconsConfig.class);
    }
}
