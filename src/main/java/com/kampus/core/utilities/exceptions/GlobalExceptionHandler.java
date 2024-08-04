package com.kampus.core.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Doğrulama hatalarını yakalar ve yanıt olarak döndürür.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("status", HttpStatus.BAD_REQUEST.value());
        errors.put("statusDescription", HttpStatus.BAD_REQUEST.getReasonPhrase());
        errors.put("timestamp", LocalDateTime.now());
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> fieldErrors.put(error.getField(), error.getDefaultMessage()));
        errors.put("errors", fieldErrors);
        return errors;
    }

    // Kaynak bulunamadığında bu hata işlenir ve yanıt olarak döndürülür.
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetails handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ProblemDetails(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), LocalDateTime.now(), ex.getMessage());
    }

    // İçsel sunucu hatalarında bu hata işlenir ve yanıt olarak döndürülür.
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerErrorException.class)
    public ProblemDetails handleInternalServerErrorException(InternalServerErrorException ex) {
        return new ProblemDetails(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), LocalDateTime.now(), ex.getMessage());
    }

    // İş kuralları hataları yakalanır ve yanıt olarak döndürülür.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessException.class)
    public ProblemDetails handleBusinessException(BusinessException ex) {
        return new ProblemDetails(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), LocalDateTime.now(), ex.getMessage());
    }

    // Beklenmeyen tüm diğer istisnalar bu genel işleyici tarafından ele alınır.
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ProblemDetails handleGlobalException(Exception ex) {
        return new ProblemDetails(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), LocalDateTime.now(), "An unexpected error occurred: " + ex.getMessage());
    }
}