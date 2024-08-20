package com.kampus.core.constants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.handler.BusinessErrorCodes.UTILITY_CLASS_ERROR;

public class InterestConstant {
    private InterestConstant() {
        throw new BusinessException(
                UTILITY_CLASS_ERROR.getCode(),
                UTILITY_CLASS_ERROR.getHttpStatus(),
                UTILITY_CLASS_ERROR.getDescription()
        );
    }

    /**
     * Interest Name
     */
    public static final String INTEREST_CONSTANT_NAME_SPORT = "Sport";
    public static final String INTEREST_CONSTANT_NAME_MUSIC = "Music";
    public static final String INTEREST_CONSTANT_NAME_TECHNOLOGY = "Technology";


    /**
     * Interest Type
     */
    public static final String INTEREST_CONSTANT_TYPE_PHYSICAL_ACTIVITY = "Physical Activity";
    public static final String INTEREST_CONSTANT_TYPE_ARTISTIC_EXPRESSION = "Artistic Expression";
    public static final String INTEREST_CONSTANT_TYPE_INNOVATIVE_THINKING = "Physical Activity";


}
