package it.axis.mafia.economy.service;

import it.axis.mafia.api.model.PlayerData;
import it.axis.mafia.utils.MessageUtils;
import it.axis.mafia.utils.TitleUtils;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RapinaService {

    private static final int MAX_DAILY = 2;
    private static final int MIN_LEVEL = 5;

    public boolean canRob(PlayerData robber, PlayerData victim) {
        if (robber.getMafiaName() == null)
            return false; // Must be in Mafia
        if (robber.getGlobalLevel() < MIN_LEVEL)
            return false; // Level check
        if (robber.getDailyRobberyCount() >= MAX_DAILY)
            return false; // Daily limit

        // Reset daily logic should be in task/login, simpler check here:
        if (System.currentTimeMillis() - robber.getLastDailyReset() > 86400000) {
            robber.setDailyRobberyCount(0);
            robber.setLastDailyReset(System.currentTimeMillis());
        }

        return true;
    }

    public void startRobbery(Player attacker, Player victim, PlayerData attackerData) {
        // Freeze victim
        victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 255)); // 10s stop
        victim.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 1));

        // Notify
        TitleUtils.sendTitle(victim, "&cRAPINA IN CORSO!", "&7Non puoi muoverti per 10 secondi!");
        TitleUtils.sendTitle(attacker, "&aRAPINA INIZIATA", "&7Hai 10 secondi per rubare tutto!");

        attacker.openInventory(victim.getInventory());

        // Update stats
        attackerData.setDailyRobberyCount(attackerData.getDailyRobberyCount() + 1);
        attackerData.setLastRobberyTime(System.currentTimeMillis());
    }
}
