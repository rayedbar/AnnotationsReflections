package net.therap.annotated_validator.app;

import net.therap.annotated_validator.entity.Person;
import net.therap.annotated_validator.service.AnnotatedValidator;
import net.therap.annotated_validator.entity.ValidationError;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Person p = new Person("Abcde Fghijk", 5);
        List<ValidationError> errors = AnnotatedValidator.validate(p);
        AnnotatedValidator.print(errors);
    }
}
