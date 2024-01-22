package net.runelite.client.plugins.playericons;

import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayUtil;

import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerIconsOverlay extends Overlay {

    private final PlayerIconsService playerIconsService;

    @Inject
    private PlayerIconsOverlay(PlayerIconsService playerIconsService) {
        this.playerIconsService = playerIconsService;
    }


    @Override
    public Dimension render(Graphics2D graphics) {
        renderIconPosition(graphics, playerIconsService.getLocalPlayer());
        return null;
    }

    private void renderIconPosition(Graphics2D graphics, Player player) {
        /*Point point = player.getCanvasImageLocation(playerIconsService.getProfileIcon(), player.getLogicalHeight() + 50);

        OverlayUtil.renderImageLocation(graphics, point, playerIconsService.getProfileIcon());*/

        Point point = player.getCanvasTextLocation(graphics, player.getName(), player.getLogicalHeight() + 40);

        OverlayUtil.renderTextLocation(graphics, point, player.getName(), Color.CYAN);
    }
}
