package it.axis.mafia.api.repository;

import it.axis.mafia.api.model.HorseData;
import java.util.UUID;

public interface HorseRepository extends Repository<UUID, HorseData> {
    // UUID is the Horse Entity UUID? Or Owner UUID? Usually Entity UUID.
}
