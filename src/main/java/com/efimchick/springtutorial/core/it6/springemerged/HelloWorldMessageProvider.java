package com.efimchick.springtutorial.core.it6.springemerged;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello world";
    }
}
