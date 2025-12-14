package org.learn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    // The specific type is being used instead of T in ResponseEntity and ApiError."
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError<Map<String, List<String>>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        Map<String, List<String>> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.computeIfAbsent(fieldName, key -> new ArrayList<>()).add(errorMessage);
        });

        // The type-fixed ApiError object is being created.
        ApiError<Map<String, List<String>>> apiError = createApiError(errors);

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    // The helper method is also being fixed to the Map<String, List<String>> type.
    private ApiError<Map<String, List<String>>> createApiError(Map<String, List<String>> errors) {
        ApiError<Map<String, List<String>>> apiError = new ApiError<>();
        apiError.setTimestamp(new Date());
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());
        apiError.setErrors(errors);
        return apiError;
    }
}