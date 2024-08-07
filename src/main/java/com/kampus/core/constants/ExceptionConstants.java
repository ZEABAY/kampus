package com.kampus.core.constants;

import com.kampus.core.utilities.exceptions.BusinessException;

public class ExceptionConstants {
    private ExceptionConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }

    public static final String EXCEPTION_CONSTANT_UTILITY_CLASS = "Utility class";

    public static final String EXCEPTION_CONSTANT_STATUS_KEY = "status";
    public static final String EXCEPTION_CONSTANT_STATUS_DESCRIPTION_KEY = "statusDescription";
    public static final String EXCEPTION_CONSTANT_TIMESTAMP_KEY = "timestamp";
    public static final String EXCEPTION_CONSTANT_ERRORS_KEY = "errors";
    public static final String EXCEPTION_CONSTANT_USERNAME_EXIST = "This username is already taken";
    public static final String EXCEPTION_CONSTANT_USER_NOT_FOUND = "User Not Found";
    public static final String EXCEPTION_CONSTANT_AN_UNEXPECTED_ERROR_OCCURED = "An unexpected error occurred: "
            ;
}
