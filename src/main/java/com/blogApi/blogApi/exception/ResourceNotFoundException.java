package com.blogApi.blogApi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.annotation.HttpConstraint;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue)
    {
        super(String.format("%s not found with %s: '%s' ", resourceName,fieldName,fieldValue));

        this.resourceName=resourceName;
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;

    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Long getFieldValue() {
        return fieldValue;
    }
}
