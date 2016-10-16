package net.therap.annotated_validator.entity;

/**
 * @author rayed
 * @since 10/13/16 1:29 PM
 */

public class ValidationError {

    private String fieldName;
    private Class fieldType;
    private String message;

    public ValidationError(){

    }

    public ValidationError(Class fieldType, String fieldName, String message) {
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

    public String getFieldType() { return fieldType.getSimpleName(); }

    public void setFieldType(Class fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
