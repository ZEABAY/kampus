package com.kampus.core.constants;

import com.kampus.core.utilities.exceptions.BusinessException;

public class ExceptionConstants {
    private ExceptionConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }

    public static final String EXCEPTION_CONSTANT_UTILITY_CLASS = "Utility class";


}
