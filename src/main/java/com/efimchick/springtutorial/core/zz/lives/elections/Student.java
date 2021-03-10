package com.efimchick.springtutorial.core.zz.lives.elections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {
    private static int count;
    private String name;

    public Student(@Value("Watermelonoff") final String name) {
        this.name = name + count++;
    }

    public String getName() {
        return name;
    }
}
