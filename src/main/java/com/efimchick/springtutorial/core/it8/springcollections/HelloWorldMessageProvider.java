package com.efimchick.springtutorial.core.it8.springcollections;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello world";
    }
}
