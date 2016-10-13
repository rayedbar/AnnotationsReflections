package main.java.net.therap.annotated_validator.service;

/**
 * @author rayed
 * @since 10/13/16 1:29 PM
 */

public class ValidationError {

    private String fieldName;
    private String fieldType;
    private String message;

    public ValidationError(){

    }

    public ValidationError(String fieldType, String fieldName, String message) {
        this.fieldType = fieldType;
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
