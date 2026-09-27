package com.campushub.service;

import com.campushub.model.Club;
import java.util.ArrayList;
import java.util.List;

public class ClubService {
    private final List<Club> clubs = new ArrayList<>();

    public void addClub(Club club) { clubs.add(club); }
    public List<Club> getAllClubs() { return clubs; }
}
