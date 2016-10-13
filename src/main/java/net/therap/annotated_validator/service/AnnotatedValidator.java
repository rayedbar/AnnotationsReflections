package main.java.net.therap.annotated_validator.service;

import main.java.net.therap.annotated_validator.Entity.Person;
import main.java.net.therap.annotated_validator.annotations.Size;

import java.lang.annotation.Annotation;
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

            ValidationError error = new ValidationError();

            String variableType = field.getType().getSimpleName();
            String variableName = field.getName();

            error.setFieldType(variableType);
            error.setFieldName(variableName);

            Annotation[] annotations = field.getDeclaredAnnotations();

            for (Annotation annotation : annotations){
                if (annotation instanceof Size) {
                    Size size = (Size) annotation;
                    try {
                        String variableValue = String.valueOf(field.get(person));
                        if (variableType.equals("String")){
                            if (variableValue.length() > 10){
                                error.setMessage(size.message());
                            } else {
                                error.setMessage(variableValue);
                            }
                        } else {
                            int i = Integer.parseInt(variableValue);
                            if (i < 18){
                                error.setMessage(size.message());
                            } else {
                                error.setFieldName(variableValue);
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
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
