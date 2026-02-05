package it.axis.mafia.utils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class ActionBarUtils {

    public static void sendActionBar(Player player, String message) {
        if (player == null)
            return;
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageUtils.color(message)));
    }
}
