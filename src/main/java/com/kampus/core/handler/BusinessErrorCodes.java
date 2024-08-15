package com.kampus.core.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static com.kampus.core.constants.ExceptionConstants.*;
import static org.springframework.http.HttpStatus.*;

@Getter
public enum BusinessErrorCodes {

    INCORRECT_CURRENT_PASSWORD(400, BAD_REQUEST, EXCEPTION_CONSTANT_CURRENT_PASSWORD_INCORRECT),
    NEW_PASSWORD_DOES_NOT_MATCH(400, BAD_REQUEST, EXCEPTION_CONSTANT_NEW_PASSWORD_DOES_NOT_MATCH),
    BAD_CREDENTIALS(401, UNAUTHORIZED, EXCEPTION_CONSTANT_BAD_CREDENTIALS),
    ACCOUNT_LOCKED(403, FORBIDDEN, EXCEPTION_CONSTANT_ACCOUNT_LOCKED),
    ACCOUNT_DISABLED(403, FORBIDDEN, EXCEPTION_CONSTANT_ACCOUNT_DISABLED),
    USER_NOT_FOUND(404, NOT_FOUND, EXCEPTION_CONSTANT_USER_NOT_FOUND),
    USERNAME_ALREADY_EXISTS(409, CONFLICT, EXCEPTION_CONSTANT_USERNAME_ALREADY_EXISTS),
    NO_CODE(501, NOT_IMPLEMENTED, EXCEPTION_CONSTANT_NO_CODE_PROVIDED),
    UTILITY_CLASS_ERROR(501, NOT_IMPLEMENTED, EXCEPTION_CONSTANT_UTILITY_CLASS_CREATION_ERROR);

    private final int code;
    private final String description;
    private final HttpStatus httpStatus;

    BusinessErrorCodes(int code, HttpStatus status, String description) {
        this.code = code;
        this.description = description;
        this.httpStatus = status;
    }
}