package it.axis.mafia.api.domain.mafia.model;

import it.axis.mafia.api.domain.user.value.UserId;
import it.axis.mafia.api.enums.MafiaRank;
import java.util.Map;

public interface MafiaHierarchy {
    MafiaRank getRank(UserId member);

    void promote(UserId member);

    void demote(UserId member);

    Map<UserId, MafiaRank> getMembers();
}
