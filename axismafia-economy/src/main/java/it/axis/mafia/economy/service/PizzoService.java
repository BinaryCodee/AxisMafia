package it.axis.mafia.economy.service;

import it.axis.mafia.api.model.PlayerData;
import it.axis.mafia.utils.MessageUtils;
import org.bukkit.entity.Player;
import java.util.concurrent.TimeUnit;

public class PizzoService {

    private static final long COOLDOWN = TimeUnit.DAYS.toMillis(1);

    public boolean canCollectPizzo(PlayerData player) {
        if (player.getMafiaName() == null)
            return false;
        long last = player.getEconomyData().getLastDailyPizzo();
        return (System.currentTimeMillis() - last) >= COOLDOWN;
    }

    public void collectPizzo(PlayerData player) {
        if (!canCollectPizzo(player))
            return;

        // Default pizzo calc (can be dynamic based on mafia level/territories)
        double amount = 1000.0;

        player.getEconomyData().setBalance(player.getEconomyData().getBalance() + amount);
        player.getEconomyData().setLastDailyPizzo(System.currentTimeMillis());
    }
}
