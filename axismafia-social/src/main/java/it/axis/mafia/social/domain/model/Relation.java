package it.axis.mafia.social.domain.model;

public class Relation {
    private final RelationId id;
    private RelationType type;

    public Relation(RelationId id, RelationType type) {
        this.id = id;
        this.type = type;
    }

    public void changeType(RelationType newType) {
        this.type = newType;
    }

    public RelationType getType() {
        return type;
    }
}
