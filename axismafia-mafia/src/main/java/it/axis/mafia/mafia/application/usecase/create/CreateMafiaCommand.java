package it.axis.mafia.mafia.application.usecase.create;

public class CreateMafiaCommand {
    public final String name;
    public final String color;
    public final String leaderUuid;

    public CreateMafiaCommand(String name, String color, String leaderUuid) {
        this.name = name;
        this.color = color;
        this.leaderUuid = leaderUuid;
    }
}
