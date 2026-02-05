package it.axis.mafia.utils.string;

import org.bukkit.ChatColor;

public class ColorUtils {
    public static String colorize(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String strip(String text) {
        return ChatColor.stripColor(text);
    }
}
