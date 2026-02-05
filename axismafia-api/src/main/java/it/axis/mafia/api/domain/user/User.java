package it.axis.mafia.api.domain.user;

import it.axis.mafia.api.domain.user.value.UserId;
import it.axis.mafia.api.domain.user.value.UserName;
import it.axis.mafia.api.domain.user.model.UserFinancials;
import it.axis.mafia.api.domain.user.model.UserStatistics;
import it.axis.mafia.api.domain.user.model.UserReputation;
import java.io.Serializable;

public interface User extends Serializable {
    UserId getId();

    UserName getName();

    UserFinancials getFinancials();

    UserStatistics getStatistics();

    UserReputation getReputation();

    void updateName(UserName newName);
}
