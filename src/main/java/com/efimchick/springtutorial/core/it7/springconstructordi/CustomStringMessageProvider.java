package com.efimchick.springtutorial.core.it7.springconstructordi;

import java.util.Collections;

public class CustomStringMessageProvider implements MessageProvider {

    private final String message;

    public CustomStringMessageProvider(String message, int times, boolean highlighted, char highlightingChar) {
        StringBuilder sb = new StringBuilder();
        if (highlighted){
            int highlightedMessageWidth = 1 + (message.length() + 1) * times + 6;
            final String lineSeparator = System.lineSeparator();

            appendChars(sb, highlightingChar, highlightedMessageWidth);
            sb.append(lineSeparator);

            appendChars(sb, highlightingChar, highlightedMessageWidth);
            sb.append(lineSeparator);

            appendChars(sb, highlightingChar, 3);
            appendChars(sb, ' ', highlightedMessageWidth - 6);
            appendChars(sb, highlightingChar, 3);
            sb.append(lineSeparator);


            appendChars(sb, highlightingChar, 3);
            appendChars(sb, ' ', 1);
            for (int i = 0; i < times; i++) {
                sb.append(message);
                appendChars(sb, ' ', 1);
            }
            appendChars(sb, highlightingChar, 3);
            sb.append(lineSeparator);

            appendChars(sb, highlightingChar, 3);
            appendChars(sb, ' ', highlightedMessageWidth - 6);
            appendChars(sb, highlightingChar, 3);
            sb.append(lineSeparator);

            appendChars(sb, highlightingChar, highlightedMessageWidth);
            sb.append(lineSeparator);

            appendChars(sb, highlightingChar, highlightedMessageWidth);
            sb.append(lineSeparator);

        } else {
            sb.append(String.join(" ", Collections.nCopies(times, message)));
        }

        this.message = sb.toString();

    }

    private static void appendChars(StringBuilder sb, char highlightingChar, int times) {
        for (int i = 0; i < times; i++) {
            sb.append(highlightingChar);
        }
    }

    @Override
    public String getMessage() {
        return message;
    }
}
