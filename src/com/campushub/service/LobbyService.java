package com.campushub.service;

import com.campushub.model.Lobby;
import java.util.ArrayList;
import java.util.List;

public class LobbyService {
    private final List<Lobby> lobbies = new ArrayList<>();

    public void createLobby(Lobby lobby) { lobbies.add(lobby); }
    public List<Lobby> getAllLobbies() { return lobbies; }
}
