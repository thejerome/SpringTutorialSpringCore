package com.efimchick.springtutorial.core.it8.springcollections;

import java.util.Map;

public class CombinedMessageSender implements MessageSender {

    private final Map<String, MessageSender> senders;

    public CombinedMessageSender(Map<String, MessageSender> senders) {
        this.senders = senders;
    }

    @Override
    public void send(String message) {
        senders.entrySet().stream()
                .filter(entry -> message.toLowerCase().contains(entry.getKey()))
                .forEach(entry -> entry.getValue().send(message));
    }
}
