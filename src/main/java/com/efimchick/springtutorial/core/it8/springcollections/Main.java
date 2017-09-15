package com.efimchick.springtutorial.core.it8.springcollections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Run with Execute Maven goal
 * exec:java -Dexec.mainClass="com.efimchick.springtutorial.core.it4.oop.Main" -Dexec.arguments="it is a message"
 */

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        ApplicationContext context1 = new ClassPathXmlApplicationContext("it8-1.xml");
        ApplicationContext context2 = new ClassPathXmlApplicationContext("it8-2.xml");


        {
            MessageProvider messageProvider = (MessageProvider) context1.getBean("provider");
            MessageSender messageSender = context1.getBean("sender", MessageSender.class);

            messageSender.send(messageProvider.getMessage());
        }
        {
            MessageProvider messageProvider = (MessageProvider) context2.getBean("provider");
            MessageSender messageSender = context2.getBean("sender", MessageSender.class);

            messageSender.send(messageProvider.getMessage());
        }

    }
}
