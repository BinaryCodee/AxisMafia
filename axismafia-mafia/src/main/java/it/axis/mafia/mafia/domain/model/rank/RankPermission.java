package it.axis.mafia.mafia.domain.model.rank;

public class RankPermission {
    private final String permissionNode;

    public RankPermission(String node) {
        this.permissionNode = node;
    }

    public boolean matches(String other) {
        return permissionNode.equalsIgnoreCase(other);
    }
}
