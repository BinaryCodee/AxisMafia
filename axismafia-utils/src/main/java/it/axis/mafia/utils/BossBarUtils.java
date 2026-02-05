package it.axis.mafia.utils;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BossBarUtils {

    private static final Map<UUID, BossBar> activeBars = new HashMap<>();

    public static BossBar createBossBar(String title, BarColor color, BarStyle style) {
        return Bukkit.createBossBar(MessageUtils.color(title), color, style);
    }

    public static void sendBossBar(Player player, String title, BarColor color, BarStyle style, double progress) {
        BossBar bar = activeBars.computeIfAbsent(player.getUniqueId(), k -> createBossBar(title, color, style));
        bar.setTitle(MessageUtils.color(title));
        bar.setColor(color);
        bar.setStyle(style);
        bar.setProgress(progress);
        bar.addPlayer(player);
        bar.setVisible(true);
    }

    public static void removeBossBar(Player player) {
        BossBar bar = activeBars.remove(player.getUniqueId());
        if (bar != null) {
            bar.removePlayer(player);
            bar.setVisible(false);
        }
    }
}
