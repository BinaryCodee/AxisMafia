package it.axis.mafia.social.manager;

import it.axis.mafia.api.repository.BountyRepository;
import it.axis.mafia.api.model.BountyData;
import java.util.UUID;

public class BountyManager {

    private final BountyRepository repository;

    public BountyManager(BountyRepository repository) {
        this.repository = repository;
    }

    public void placeBounty(UUID target, UUID setter, double amount) {
        BountyData bounty = new BountyData(target, setter, amount);
        repository.save(bounty);
    }
}
