package net.therap.annotated_validator.service;

import net.therap.annotated_validator.entity.Person;
import net.therap.annotated_validator.entity.ValidationError;
import net.therap.annotated_validator.util.Utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rayed
 * @since 10/13/16 1:27 PM
 */

public class AnnotatedValidator {

    public static List<ValidationError> validate(Person person) {
        List<ValidationError> validationErrors = new ArrayList<ValidationError>();
        Class c = person.getClass();

        Field[] fields = c.getDeclaredFields();

        for (Field field : fields){

            field.setAccessible(true);

            String fieldName = field.getName();
            Class fieldType = field.getType();
            String message;

            if (fieldName.equals("name")){
                message = Utils.processStringField(person, field);
            } else {
                message = Utils.processIntField(person, field);
            }

            ValidationError error = new ValidationError();
            error.setFieldName(fieldName);
            error.setFieldType(fieldType);
            error.setMessage(message);

            validationErrors.add(error);
           }
        return validationErrors;
    }

    public static void print(List<ValidationError> errors) {
        for(ValidationError error : errors){
            System.out.format("%s(%s): %s%n", error.getFieldName(), error.getFieldType(), error.getMessage());
        }
    }
}
