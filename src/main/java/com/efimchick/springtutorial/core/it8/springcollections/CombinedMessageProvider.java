package com.efimchick.springtutorial.core.it8.springcollections;

import java.util.List;
import java.util.stream.Collectors;

public class CombinedMessageProvider implements MessageProvider {

    private final List<MessageProvider> providers;
    private final String delimiter;

    public CombinedMessageProvider(List<MessageProvider> providers, String delimiter) {
        this.providers = providers;
        this.delimiter = delimiter;
    }

    @Override
    public String getMessage() {
        return providers.stream()
                .map(MessageProvider::getMessage)
                .collect(Collectors.joining(delimiter));
    }
}
