package com.campushub.model;

public class Club {
    private int id;
    private String name;
    private String description;
    private String coordinator;

    public Club(int id, String name, String description, String coordinator) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.coordinator = coordinator;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - Coordinator: " + coordinator;
    }
}
