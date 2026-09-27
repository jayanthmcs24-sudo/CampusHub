package com.campushub.model;

import java.time.LocalDateTime;

public class PrivateMessage {
    private final String sender;
    private final String receiver;
    private final String message;
    private final LocalDateTime sentAt;

    public PrivateMessage(String sender, String receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.sentAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "[" + sentAt + "] " + sender + " -> " +
                receiver + ": " + message;
    }
}
