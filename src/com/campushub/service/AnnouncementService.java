package com.campushub.service;

import com.campushub.model.Announcement;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementService {
    private final List<Announcement> announcements = new ArrayList<>();
    private int nextId = 1;

    public void create(String title, String message, String createdBy) {
        announcements.add(new Announcement(nextId++, title, message, createdBy));
    }

    public List<Announcement> getAll() { return announcements; }
}
