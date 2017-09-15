package com.efimchick.springtutorial.core.it5.configurablefactory;

public class CustomStringMessageProvider implements MessageProvider {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
