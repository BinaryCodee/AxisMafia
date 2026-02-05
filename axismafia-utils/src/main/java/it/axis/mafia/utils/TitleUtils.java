package it.axis.mafia.utils;

import org.bukkit.entity.Player;

public class TitleUtils {

    public static void sendTitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        if (player == null)
            return;
        player.sendTitle(MessageUtils.color(title), MessageUtils.color(subtitle), fadeIn, stay, fadeOut);
    }

    public static void sendTitle(Player player, String title, String subtitle) {
        sendTitle(player, title, subtitle, 10, 70, 20);
    }
}
