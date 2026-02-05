package it.axis.mafia.social.manager;

import java.util.HashSet;
import java.util.Set;

public class AllianceManager {

    private final Set<String> alliances = new HashSet<>();

    public void createAlliance(String mafia1, String mafia2) {
        if (mafia1.compareTo(mafia2) > 0) {
            String temp = mafia1;
            mafia1 = mafia2;
            mafia2 = temp;
        }
        alliances.add(mafia1 + ":" + mafia2);
    }

    public boolean areAllied(String mafia1, String mafia2) {
        if (mafia1.equals(mafia2))
            return true;
        if (mafia1.compareTo(mafia2) > 0) {
            String temp = mafia1;
            mafia1 = mafia2;
            mafia2 = temp;
        }
        return alliances.contains(mafia1 + ":" + mafia2);
    }
}
