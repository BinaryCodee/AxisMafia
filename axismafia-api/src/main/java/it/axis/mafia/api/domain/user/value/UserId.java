package it.axis.mafia.api.domain.user.value;

import java.io.Serializable;
import java.util.UUID;

public class UserId implements Serializable {
    private final UUID value;

    public UserId(UUID value) {
        if (value == null)
            throw new IllegalArgumentException("UUID cannot be null");
        this.value = value;
    }

    public UUID getValue() {
        return value;
    }

    public static UserId fromString(String uuid) {
        return new UserId(UUID.fromString(uuid));
    }

    public static UserId random() {
        return new UserId(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserId userId = (UserId) o;
        return value.equals(userId.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
