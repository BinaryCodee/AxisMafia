package it.axis.mafia.api.domain.user.model;

import java.util.concurrent.atomic.AtomicInteger;

public class UserStatisticsImpl extends AbstractUserComponent implements UserStatistics {

    private final AtomicInteger kills = new AtomicInteger(0);
    private final AtomicInteger deaths = new AtomicInteger(0);
    private long playTime = 0;

    @Override
    public int getKills() {
        return kills.get();
    }

    @Override
    public int getDeaths() {
        return deaths.get();
    }

    @Override
    public double getKdr() {
        int d = deaths.get();
        return d == 0 ? kills.get() : (double) kills.get() / d;
    }

    @Override
    public void incrementKills() {
        kills.incrementAndGet();
    }

    @Override
    public void incrementDeaths() {
        deaths.incrementAndGet();
    }

    @Override
    public long getPlayTimeMillis() {
        return playTime;
    }
}
