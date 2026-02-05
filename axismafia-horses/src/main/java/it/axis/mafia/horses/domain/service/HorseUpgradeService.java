package it.axis.mafia.horses.domain.service;

import it.axis.mafia.horses.domain.model.CustomHorse;

public interface HorseUpgradeService {
    CustomHorse upgradeSpeed(CustomHorse horse, double amount);

    CustomHorse upgradeJump(CustomHorse horse, double amount);
}
