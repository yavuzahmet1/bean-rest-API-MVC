package org.learn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        
        // Hataları dön ve Map'e ekle
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField(); // Hatanın olduğu alan (örn: "email")
            String errorMessage = error.getDefaultMessage();    // Hata mesajı (örn: "Email formatı geçersiz")
            errors.put(fieldName, errorMessage);
        });
        
        // Kullanıcıya 400 Bad Request ile birlikte hataları dön
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}

private ApiError createApiError(Map<String,List<String>> errors) {
    ApiError apiError = new ApiError();
    apiError.setId(java.util.UUID.randomUUID().toString());
    apiError.setTimestamp(new Date());
    apiError.setErrors(errors);
    return apiError;
}