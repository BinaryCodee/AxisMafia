package it.axis.mafia.api.domain.user.model;

public abstract class AbstractUserComponent {
    protected final transient Object lock = new Object();

    protected void checkAccess() {

    }
}
