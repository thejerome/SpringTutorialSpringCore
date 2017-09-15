package com.efimchick.springtutorial.core.it5.configurablefactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Properties;

public class ConfigurableFactory {
    private final Properties config;

    public ConfigurableFactory(Properties config) {
        this.config = config;
    }

    public MessageSender getMessageSender() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<? extends MessageSender> senderClass =
                (Class<? extends MessageSender>) Class.forName(config.getProperty("sender"));

        MessageSender target = senderClass.newInstance();
        supplyProperties(target, "sender.");

        return target;
    }

    public MessageProvider getMessageProvider() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<? extends MessageProvider> providerClass =
                (Class<? extends MessageProvider>) Class.forName(config.getProperty("provider"));

        MessageProvider target = providerClass.newInstance();
        supplyProperties(target, "provider.");
        return target;
    }

    private void supplyProperties(Object target, String prefix) {
        config.entrySet().stream()
                .filter(e -> e.getKey().toString().startsWith(prefix))
                .forEach(e -> {
                            String propertyName = e.getKey().toString().substring(prefix.length());
                            String expectedMethodName = "set"
                                    + Character.toUpperCase(propertyName.charAt(0))
                                    + propertyName.substring(1);
                            Arrays.stream(target.getClass().getMethods())
                                    .filter(method -> method.getName().equals(expectedMethodName))
                                    .forEach(
                                            method -> {
                                                try {
                                                    method.invoke(target, new Object[]{e.getValue()});
                                                } catch (IllegalAccessException e1) {
                                                    e1.printStackTrace();
                                                } catch (InvocationTargetException e1) {
                                                    e1.printStackTrace();
                                                }
                                            }
                                    );
                            ;
                        }
                );
    }

}
