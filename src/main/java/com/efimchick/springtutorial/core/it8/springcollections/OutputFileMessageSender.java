package com.efimchick.springtutorial.core.it8.springcollections;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

public class OutputFileMessageSender implements MessageSender {
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public void send(String message) {
        Objects.requireNonNull(message);
        try {
            FileUtils.writeStringToFile(
                    new File(filename),
                    message,
                    Charset.defaultCharset(),
                    true
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
