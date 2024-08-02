package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class InterestConstants {
    private InterestConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String INTEREST_TABLE = "Interests";


    /**
     * COLUMN
     */
    public static final String INTEREST_COLUMN_INTEREST_ID = "interest_id";
    public static final String INTEREST_COLUMN_INTEREST_NAME = "interest_name";
    public static final String INTEREST_COLUMN_INTEREST_TYPE = "interest_type";

    public static final String INTEREST_MAP_INTERESTS = "interests";


    /**
     * SEQUENCE
     */
    public static final String INTEREST_SEQ_INTEREST = "interest_seq";
    public static final String INTEREST_SEQ_INTEREST_ID = "interest_id_seq";
    public static final int INTEREST_SEQ_INTEREST_ID_ALLOCATION_SIZE = 1;
}
