package it.axis.mafia.social.domain.model;

public class RelationId {
    private final String compositeId;

    public RelationId(String mafia1, String mafia2) {

        if (mafia1.compareTo(mafia2) > 0) {
            this.compositeId = mafia2 + ":" + mafia1;
        } else {
            this.compositeId = mafia1 + ":" + mafia2;
        }
    }
}
