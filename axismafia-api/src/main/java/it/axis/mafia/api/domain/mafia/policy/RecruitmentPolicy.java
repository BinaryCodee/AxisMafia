package it.axis.mafia.api.domain.mafia.policy;

import it.axis.mafia.api.domain.mafia.Mafia;
import it.axis.mafia.api.domain.user.User;

public interface RecruitmentPolicy {
    boolean canRecruit(Mafia mafia, User target);
}
