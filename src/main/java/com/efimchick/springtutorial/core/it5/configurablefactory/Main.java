package com.efimchick.springtutorial.core.it5.configurablefactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Run with Execute Maven goal
 * exec:java -Dexec.mainClass="com.efimchick.springtutorial.core.it4.oop.Main" -Dexec.arguments="it is a message"
 */

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Properties config = new Properties();
        config.load(new FileReader("it5.config.properties"));

        ConfigurableFactory factory = new ConfigurableFactory(config);

        MessageProvider messageProvider = factory.getMessageProvider();
        MessageSender messageSender = factory.getMessageSender();

        messageSender.send(messageProvider.getMessage());

    }
}
