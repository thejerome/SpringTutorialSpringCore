package com.efimchick.springtutorial.core.it6.springemerged;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Run with Execute Maven goal
 * exec:java -Dexec.mainClass="com.efimchick.springtutorial.core.it4.oop.Main" -Dexec.arguments="it is a message"
 */

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        ApplicationContext context = new ClassPathXmlApplicationContext("it6.xml");

        MessageProvider messageProvider = (MessageProvider) context.getBean("provider");
        MessageSender messageSender = context.getBean("sender", MessageSender.class);

        messageSender.send(messageProvider.getMessage());

    }
}
