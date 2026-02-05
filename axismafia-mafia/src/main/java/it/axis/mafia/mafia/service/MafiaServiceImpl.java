package it.axis.mafia.mafia.service;

import it.axis.mafia.api.enums.MafiaRank;
import it.axis.mafia.api.model.MafiaData;
import it.axis.mafia.api.model.PlayerData;
import it.axis.mafia.api.service.MafiaService;
import it.axis.mafia.mafia.manager.MafiaManager;
import it.axis.mafia.mafia.manager.RankManager;
import it.axis.mafia.utils.MessageUtils;
import org.bukkit.Bukkit;

public class MafiaServiceImpl implements MafiaService {

    private final MafiaManager mafiaManager;
    private final RankManager rankManager;

    public MafiaServiceImpl(MafiaManager mafiaManager, RankManager rankManager) {
        this.mafiaManager = mafiaManager;
        this.rankManager = rankManager;
    }

    @Override
    public void createMafia(String name, String color, String baseLocation) {
        if (mafiaManager.getMafia(name) != null)
            return;
        mafiaManager.createMafia(name, color);
        MafiaData mafia = mafiaManager.getMafia(name);
        mafia.setBaseLocation(baseLocation);
        mafiaManager.save(mafia);
    }

    @Override
    public void disbandMafia(String name) {
        MafiaData mafia = mafiaManager.getMafia(name);
        if (mafia == null)
            return;

        // Logic to kick all members would go here (update PlayerData)
        // Since PlayerData update is dependent on Core/Other services, we assume event
        // listeners handle complex detachment

        mafiaManager.deleteMafia(name);
    }

    @Override
    public void addMember(String mafiaName, PlayerData player, MafiaRank rank) {
        MafiaData mafia = mafiaManager.getMafia(mafiaName);
        if (mafia == null)
            return;

        mafia.getMembers().put(player.getUuid(), rank);
        player.setMafiaName(mafiaName);

        mafiaManager.save(mafia);
        // PlayerData save happens in Core's PlayerManager separately or via event
    }

    @Override
    public void removeMember(String mafiaName, PlayerData player) {
        MafiaData mafia = mafiaManager.getMafia(mafiaName);
        if (mafia == null)
            return;

        mafia.getMembers().remove(player.getUuid());
        player.setMafiaName(null);

        mafiaManager.save(mafia);
    }

    @Override
    public void promoteMember(String mafiaName, PlayerData player) {
        MafiaData mafia = mafiaManager.getMafia(mafiaName);
        if (mafia == null)
            return;

        MafiaRank current = mafia.getMembers().get(player.getUuid());
        if (current == null || current.getNext() == null)
            return;

        mafia.getMembers().put(player.getUuid(), current.getNext());
        mafiaManager.save(mafia);
    }

    @Override
    public void demoteMember(String mafiaName, PlayerData player) {
        // Logic similar to promote but backwards
    }

    @Override
    public MafiaData getMafia(String name) {
        return mafiaManager.getMafia(name);
    }

    @Override
    public MafiaData getPlayerMafia(PlayerData player) {
        if (player.getMafiaName() == null)
            return null;
        return mafiaManager.getMafia(player.getMafiaName());
    }
}
