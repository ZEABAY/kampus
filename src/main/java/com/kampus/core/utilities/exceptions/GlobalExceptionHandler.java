package com.kampus.core.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Doğrulama hatalarını yakalar ve yanıt olarak döndürür.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }

    // Kaynak bulunamadığında bu hata işlenir ve yanıt olarak döndürülür.
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetails handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ProblemDetails(ex.getMessage());
    }

    // İçsel sunucu hatalarında bu hata işlenir ve yanıt olarak döndürülür.
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerErrorException.class)
    public ProblemDetails handleInternalServerErrorException(InternalServerErrorException ex) {
        return new ProblemDetails(ex.getMessage());
    }

    // İş kuralları hataları yakalanır ve yanıt olarak döndürülür.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessException.class)
    public ProblemDetails handleBusinessException(BusinessException ex) {
        return new ProblemDetails(ex.getMessage());
    }

    // Beklenmeyen tüm diğer istisnalar bu genel işleyici tarafından ele alınır.
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ProblemDetails handleGlobalException(Exception ex) {
        return new ProblemDetails("An unexpected error occurred: " + ex.getMessage());
    }
}