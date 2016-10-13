package main.java.net.therap.annotated_validator.app;

import main.java.net.therap.annotated_validator.Entity.Person;
import main.java.net.therap.annotated_validator.service.AnnotatedValidator;
import main.java.net.therap.annotated_validator.service.ValidationError;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Person p = new Person("Abcde Fghijk", 5);
        List<ValidationError> errors = null;
        errors = AnnotatedValidator.validate(p);
        AnnotatedValidator.print(errors);

    }
}
