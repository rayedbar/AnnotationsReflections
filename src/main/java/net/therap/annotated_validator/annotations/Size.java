package main.java.net.therap.annotated_validator.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author rayed
 * @since 10/13/16 1:18 PM
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Size {
    public int min() default 1;
    public int max() default 10;
    public String message() default "Length must be {min}-{max}";
}
