package net.therap.annotated_validator.util;

import net.therap.annotated_validator.entity.Person;
import net.therap.annotated_validator.annotations.Size;

import java.lang.reflect.Field;

/**
 * @author rayed
 * @since 10/13/16 3:43 PM
 */

public class Utils {

    public static String processStringField(Person person, Field field) {
        try {
            String stringFieldValue = (String) field.get(person);
            Size annotation = field.getAnnotation(Size.class);
            if (stringFieldValue.length() > 10){
                String s = annotation.message();
                //System.out.println(annotation.min());
                String s1 = s.replaceAll("\\{min\\}", String.valueOf(annotation.min()));
                String s2 = s1.replaceAll("\\{max\\}", String.valueOf(annotation.max()));
                //System.out.println(s);
                return s2;
            } else {
                return stringFieldValue;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String processIntField(Person person, Field field) {
        try {
            int intFieldValue= (Integer) field.get(person);
            Size annotation = field.getAnnotation(Size.class);
            if (intFieldValue < 18){
                String s = annotation.message();
                String s1 = s.replaceAll("\\{min\\}", String.valueOf(annotation.min()));
                return s1;
            } else{
                return String.valueOf(intFieldValue);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
