package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class MajorConstants {
    private MajorConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String MAJOR_TABLE = "Majors";


    /**
     * COLUMN
     */
    public static final String MAJOR_COLUMN_MAJOR_ID = "major_id";
    public static final String MAJOR_COLUMN_MAJOR_NAME = "major_name";


    /**
     * SEQUENCE
     */
    public static final String MAJOR_SEQ_MAJOR = "major_seq";
    public static final String MAJOR_SEQ_MAJOR_ID = "major_id_seq";
    public static final int MAJOR_SEQ_MAJOR_ID_ALLOCATION_SIZE = 1;
}

