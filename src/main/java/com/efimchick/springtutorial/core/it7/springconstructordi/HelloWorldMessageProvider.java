package com.efimchick.springtutorial.core.it7.springconstructordi;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello world";
    }
}
