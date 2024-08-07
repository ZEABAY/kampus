package com.kampus.core.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.kampus.core.constants.ExceptionConstants.*;

//@RestControllerAdvice
public class GlobalExceptionHandler {

    // 400 Bad Request
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleValidationExceptions(MethodArgumentNotValidException exc) {
        Map<String, Object> errors = new HashMap<>();
        errors.put(EXCEPTION_CONSTANT_STATUS_KEY, HttpStatus.BAD_REQUEST.value());
        errors.put(EXCEPTION_CONSTANT_STATUS_DESCRIPTION_KEY, HttpStatus.BAD_REQUEST.getReasonPhrase());
        errors.put(EXCEPTION_CONSTANT_TIMESTAMP_KEY, LocalDateTime.now());
        Map<String, String> fieldErrors = new HashMap<>();
        exc.getBindingResult()
                .getFieldErrors()
                .forEach(error -> fieldErrors.put(error.getField(), error.getDefaultMessage()));
        errors.put(EXCEPTION_CONSTANT_ERRORS_KEY, fieldErrors);
        return errors;
    }

    // 404 Not Found
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetails handleResourceNotFoundException(ResourceNotFoundException exc) {
        return new ProblemDetails(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), LocalDateTime.now(), exc.getMessage());
    }

    // 500 Internal Server Error
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerErrorException.class)
    public ProblemDetails handleInternalServerErrorException(InternalServerErrorException exc) {
        return new ProblemDetails(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), LocalDateTime.now(), exc.getMessage());
    }

    // 403 Forbidden
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public ProblemDetails handleAccessDeniedException(AccessDeniedException exc) {
        return new ProblemDetails(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase(), LocalDateTime.now(), exc.getMessage());
    }

    // 401 UNAUTHORIZED
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(BadCredentialsException.class)
    public ProblemDetails handleBadCredentialsException(BadCredentialsException exc) {
        return new ProblemDetails(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase(), LocalDateTime.now(), exc.getMessage());
    }

    // 422 UNPROCESSABLE_ENTITY (Business Exceptions)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(BusinessException.class)
    public ProblemDetails handleBusinessException(BusinessException exc) {
        return new ProblemDetails(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase(), LocalDateTime.now(), exc.getMessage());
    }

    /* Beklenmeyenleri görmek için kapattım
    // Beklenmeyen tüm diğer istisnalar bu genel işleyici tarafından ele alınır.
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ProblemDetails handleGlobalException(Exception exc) {
        return new ProblemDetails(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), LocalDateTime.now(), EXCEPTION_CONSTANT_AN_UNEXPECTED_ERROR_OCCURED + exc.getMessage());
    }
    */
}