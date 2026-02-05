package it.axis.mafia.api.domain.mafia.policy;

import it.axis.mafia.api.domain.mafia.Mafia;

public interface PromotionPolicy {
    boolean canPromote(Mafia mafia);
}
