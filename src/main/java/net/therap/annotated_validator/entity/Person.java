package net.therap.annotated_validator.entity;

import net.therap.annotated_validator.annotations.Size;

/**
 * @author rayed
 * @since 10/13/16 1:22 PM
 */

public class Person {

    @Size(max = 10)
    private String name;

    @Size(min = 18, message = "Age cannot be less than {min}")
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
