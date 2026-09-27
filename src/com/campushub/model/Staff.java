package com.campushub.model;

public class Staff {
    private int id;
    private String name;
    private String email;
    private String department;
    private String designation;
    private boolean teaching;

    public Staff(int id, String name, String email, String department,
                 String designation, boolean teaching) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.designation = designation;
        this.teaching = teaching;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + department + " - " +
                designation + " - " + (teaching ? "Teaching" : "Non-teaching");
    }
}
