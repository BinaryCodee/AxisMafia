package it.axis.mafia.stafftools.domain.model;

import java.time.Instant;
import java.util.UUID;

public class StaffSession {
    private final UUID staffId;
    private final Instant startTime;
    private boolean vanishEnabled;
    private boolean staffModeEnabled;

    public StaffSession(UUID staffId) {
        this.staffId = staffId;
        this.startTime = Instant.now();
        this.vanishEnabled = false;
        this.staffModeEnabled = false;
    }

    public void enableVanish() {
        this.vanishEnabled = true;
    }

    public void disableVanish() {
        this.vanishEnabled = false;
    }

    public boolean isVanishEnabled() {
        return vanishEnabled;
    }

    public void enableStaffMode() {
        this.staffModeEnabled = true;
    }

    public void disableStaffMode() {
        this.staffModeEnabled = false;
    }

    public boolean isStaffModeEnabled() {
        return staffModeEnabled;
    }
}
