package com.campushub.service;

import com.campushub.model.PrivateMessage;
import java.util.ArrayList;
import java.util.List;

public class ChatService {
    private final List<PrivateMessage> messages = new ArrayList<>();

    public void send(String sender, String receiver, String message) {
        messages.add(new PrivateMessage(sender, receiver, message));
    }

    public List<PrivateMessage> getAllMessages() { return messages; }
}
