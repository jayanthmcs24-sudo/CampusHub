package com.campushub.model;

public class Lobby {
    private final int id;
    private final String name;
    private final String type;
    private final String description;

    public Lobby(int id, String name, String type, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    @Override
    public String toString() {
        return id + " - " + name + " [" + type + "] - " + description;
    }
}
