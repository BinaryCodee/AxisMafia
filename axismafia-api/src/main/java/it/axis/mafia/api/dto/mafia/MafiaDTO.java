package it.axis.mafia.api.dto.mafia;

import java.io.Serializable;

public class MafiaDTO implements Serializable {
    private String name;
    private String color;
    private String baseLocation;

    public MafiaDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public void setBaseLocation(String baseLocation) {
        this.baseLocation = baseLocation;
    }
}
