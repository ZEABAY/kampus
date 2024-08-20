package com.kampus.core.constants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.handler.BusinessErrorCodes.UTILITY_CLASS_ERROR;

public class ExceptionConstants {

    private ExceptionConstants() {
        throw new BusinessException(
                UTILITY_CLASS_ERROR.getCode(),
                UTILITY_CLASS_ERROR.getHttpStatus(),
                UTILITY_CLASS_ERROR.getDescription()
        );
    }


    // Hata mesajları
    public static final String EXCEPTION_CONSTANT_CURRENT_PASSWORD_INCORRECT = "Current password is incorrect";
    public static final String EXCEPTION_CONSTANT_NEW_PASSWORD_DOES_NOT_MATCH = "The new password does not match";
    public static final String EXCEPTION_CONSTANT_BAD_CREDENTIALS = "Login and/or password is incorrect";
    public static final String EXCEPTION_CONSTANT_ACCOUNT_LOCKED = "User account is locked";
    public static final String EXCEPTION_CONSTANT_ACCOUNT_DISABLED = "User account is disabled";
    public static final String EXCEPTION_CONSTANT_USER_NOT_FOUND = "User not found";
    public static final String EXCEPTION_CONSTANT_USERNAME_ALREADY_EXISTS = "Username already exists";
    public static final String EXCEPTION_CONSTANT_EMAIL_ALREADY_EXISTS = "User email already exists";
    public static final String EXCEPTION_CONSTANT_PHONE_NUMBER_ALREADY_EXISTS = "Phone number already exists";
    public static final String EXCEPTION_CONSTANT_NO_CODE_PROVIDED = "No code provided or unknown error";
    public static final String EXCEPTION_CONSTANT_UTILITY_CLASS_CREATION_ERROR = "You can't create a utility class";


}
