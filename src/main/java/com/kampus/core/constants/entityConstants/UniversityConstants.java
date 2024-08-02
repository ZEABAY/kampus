package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class UniversityConstants {
    private UniversityConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String UNIVERSITY_TABLE = "Universities";


    /**
     * COLUMN
     */
    public static final String UNIVERSITY_COLUMN_UNIVERSITY_ID = "university_id";
    public static final String UNIVERSITY_COLUMN_UNIVERSITY_NAME = "university_name";

    /**
     * SEQUENCE
     */
    public static final String UNIVERSITY_SEQ_UNIVERSITY = "university_seq";
    public static final String UNIVERSITY_SEQ_UNIVERSITY_ID = "university_id_seq";
    public static final int UNIVERSITY_SEQ_UNIVERSITY_ID_ALLOCATION_SIZE = 1;
}

