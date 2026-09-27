package com.campushub.model;

import java.time.LocalDateTime;

public class Announcement {
    private final int id;
    private final String title;
    private final String message;
    private final String createdBy;
    private final LocalDateTime createdAt;

    public Announcement(int id, String title, String message, String createdBy) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.createdBy = createdBy;
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "[" + createdAt + "] " + title + " - " +
                message + " (by " + createdBy + ")";
    }
}
