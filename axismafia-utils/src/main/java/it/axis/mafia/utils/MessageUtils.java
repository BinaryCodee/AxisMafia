package it.axis.mafia.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.List;
import java.util.stream.Collectors;

public class MessageUtils {

    private static final String PREFIX = "&8[&5Axis&dMafia&8] &r";

    public static String color(String message) {
        if (message == null)
            return "";
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> color(List<String> messages) {
        if (messages == null)
            return null;
        return messages.stream().map(MessageUtils::color).collect(Collectors.toList());
    }

    public static void send(CommandSender sender, String message) {
        if (sender != null && message != null && !message.isEmpty()) {
            sender.sendMessage(color(message));
        }
    }

    public static void sendWithPrefix(CommandSender sender, String message) {
        send(sender, PREFIX + message);
    }

    public static Component parse(String message) {
        return MiniMessage.miniMessage().deserialize(message);
    }
}
