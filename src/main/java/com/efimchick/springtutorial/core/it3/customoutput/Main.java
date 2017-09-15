package com.efimchick.springtutorial.core.it3.customoutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        String outputMode = args[0];

        switch (outputMode) {
            case "file":{
                String fileName = args[1];
                Path path = Paths.get(fileName);
                String message = Arrays.stream(args)
                        .skip(2)
                        .collect(Collectors.joining(" "));

                if (!Files.isWritable(path)){
                    Files.createFile(path);
                }
                Files.write(path, Arrays.asList(message));
                break;
            } default: {
                String message = Arrays.stream(args)
                        .skip(1)
                        .collect(Collectors.joining(" "));
                System.out.println(message);
            }
        }

    }
}
