package it.axis.mafia.mafia.domain.model.rank;

import java.util.HashSet;
import java.util.Set;

public class Rank {
    private final RankId id;
    private final RankName name;
    private final int priority;
    private final Set<RankPermission> permissions;

    public Rank(RankId id, RankName name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.permissions = new HashSet<>();
    }

    public void addPermission(RankPermission perm) {
        permissions.add(perm);
    }

    public boolean hasPermission(RankPermission perm) {
        return permissions.contains(perm);
    }

    public int getPriority() {
        return priority;
    }
}
