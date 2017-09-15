package com.efimchick.springtutorial.core.it7.springconstructordi;

import java.util.Objects;

public class SystemOutMessageSender implements MessageSender {
    @Override
    public void send(String message) {
        Objects.requireNonNull(message);
        System.out.println(message);
    }
}
