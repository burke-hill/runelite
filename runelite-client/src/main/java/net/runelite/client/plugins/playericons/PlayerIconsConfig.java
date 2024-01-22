package net.runelite.client.plugins.playericons;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("IconsTest")
public interface PlayerIconsConfig extends Config {
    @ConfigItem(
            keyName = "showIcon",
            name = "Show icons on",
            description = "Configures which players should display their icons above the character model"
    )
    default IconSettings showIconSettings()
    {
        return IconSettings.DISABLED;
    }


    enum IconSettings {
        DISABLED,
        SELF,
        ALL
    }
}
