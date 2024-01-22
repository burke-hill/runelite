package net.runelite.client.plugins.playericons;

import net.runelite.api.Client;
import net.runelite.api.Player;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

@Singleton
public class PlayerIconsService {

    private final Client client;

    private final PlayerIconsConfig config;

    @Inject
    private PlayerIconsService(Client client, PlayerIconsConfig config) {
        this.client = client;
        this.config = config;
    }


    public Player getLocalPlayer() {
        return client.getLocalPlayer();
    }

    public BufferedImage getProfileIcon() {
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\burke\\Desktop\\Code\\runelite-master\\runelite-client\\src\\main\\java\\net\\runelite\\client\\plugins\\playericons\\woody.jpg"));
            BufferedImage newImage = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);

            Graphics g = newImage.createGraphics();
            g.drawImage(image, 0, 0, 20, 20, null);
            g.dispose();

            return newImage;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
