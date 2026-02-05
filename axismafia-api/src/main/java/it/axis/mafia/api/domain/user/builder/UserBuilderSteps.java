package it.axis.mafia.api.domain.user.builder;

import it.axis.mafia.api.domain.user.User;
import it.axis.mafia.api.domain.user.value.UserId;
import it.axis.mafia.api.domain.user.value.UserName;

public interface BuildStep {
    NameStep withId(UserId id);
}

public interface NameStep {
    FinalStep withName(UserName name);
}

public interface FinalStep {
    User build();
}
