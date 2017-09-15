package com.efimchick.springtutorial.core.it4.oop;

import java.io.IOException;

/**
 * Run with Execute Maven goal
 * exec:java -Dexec.mainClass="com.efimchick.springtutorial.core.it4.oop.Main" -Dexec.arguments="it is a message"
 */

public class Main {
    public static void main(String[] args) throws IOException {

        MessageProvider messageProvider = new ProgramArgsMessageProvider(args, " ");
        MessageSender messageSender = new OutputFileMessageSender("log.log");

        messageSender.send(messageProvider.getMessage());

    }
}
