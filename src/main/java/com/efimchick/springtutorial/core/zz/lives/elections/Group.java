package com.efimchick.springtutorial.core.zz.lives.elections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Group {

    private String name;
    private Student student;

    public Group(@Value("P3999") final String name, final Student student) {
        this.name = name;
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public Student getStudent() {
        return student;
    }
}
