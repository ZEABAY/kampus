package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class CityConstants {

    private CityConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }

    /**
     * TABLE
     */
    public static final String CITY_TABLE = "Cities";


    /**
     * COLUMN
     */
    public static final String CITY_COLUMN_CITY_ID = "city_id";
    public static final String CITY_COLUMN_CITY_NAME = "city_name";


    /**
     * SEQUENCE
     */
    public static final String CITY_SEQ_CITY = "city_seq";
    public static final String CITY_SEQ_CITY_ID = "city_id_seq";
    public static final int CITY_SEQ_CITY_ID_ALLOCATION_SIZE = 1;
}