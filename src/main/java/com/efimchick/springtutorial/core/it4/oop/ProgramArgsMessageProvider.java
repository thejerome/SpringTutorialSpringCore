package com.efimchick.springtutorial.core.it4.oop;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ProgramArgsMessageProvider implements MessageProvider {

    private final String[] args;
    private final String delimiter;

    public ProgramArgsMessageProvider(String[] args, String delimiter) {
        this.args = args;
        this.delimiter = delimiter;
    }

    @Override
    public String getMessage() {
        return args == null ? "empty message"
                : Arrays.stream(args).collect(Collectors.joining(delimiter));
    }
}
