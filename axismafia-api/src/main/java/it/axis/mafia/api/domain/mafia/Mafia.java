package it.axis.mafia.api.domain.mafia;

import it.axis.mafia.api.domain.mafia.value.MafiaId;
import it.axis.mafia.api.domain.mafia.value.MafiaName;
import it.axis.mafia.api.domain.mafia.model.MafiaHierarchy;

public interface Mafia {
    MafiaId getId();

    MafiaName getName();

    MafiaHierarchy getHierarchy();
}
