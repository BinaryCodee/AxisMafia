package it.axis.mafia.core.module;

public interface AxisModule {
    String getName();

    void enable();

    void disable();

    boolean isCritical();
}
