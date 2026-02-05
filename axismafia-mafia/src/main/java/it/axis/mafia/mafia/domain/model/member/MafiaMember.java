package it.axis.mafia.mafia.domain.model.member;

import it.axis.mafia.api.domain.user.value.UserId;
import it.axis.mafia.mafia.domain.model.rank.Rank;

public class MafiaMember {
    private final UserId userId;
    private Rank rank;
    private long joinDate;

    public MafiaMember(UserId userId, Rank rank) {
        this.userId = userId;
        this.rank = rank;
        this.joinDate = System.currentTimeMillis();
    }

    public UserId getUserId() {
        return userId;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
