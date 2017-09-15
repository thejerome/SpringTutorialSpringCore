package com.efimchick.springtutorial.core.it7.springconstructordi;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ProgramArgsMessageProvider implements MessageProvider {

    private String[] args;
    private String delimiter;

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public String getMessage() {
        return args == null ? "empty message"
                : Arrays.stream(args).collect(Collectors.joining(delimiter));
    }
}
