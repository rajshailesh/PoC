package com.cdfi.group.Error;
public class JsonValidationError extends RuntimeException {
    public JsonValidationError(String message) {
        super(message);
    }
}
