package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class UserVerificationConstants {
    private UserVerificationConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String USER_VERIFICATION_TABLE = "UserVerifications";


    /**
     * COLUMN
     */
    public static final String USER_VERIFICATION_COLUMN_VERIFICATION_ID = "verification_id";
    public static final String USER_VERIFICATION_COLUMN_VERIFICATION_CODE = "verification_code";
    public static final String USER_VERIFICATION_COLUMN_CREATED_AT = "created_at";
    public static final String USER_VERIFICATION_COLUMN_HAVE_USED = "have_used";

    /**
     * SEQUENCE
     */
    public static final String USER_VERIFICATION_SEQ_USER_VERIFICATION = "user_verification_seq";
    public static final String USER_VERIFICATION_SEQ_USER_VERIFICATION_ID = "user_verification_id_seq";
    public static final int USER_VERIFICATION_SEQ_USER_VERIFICATION_ID_ALLOCATION_SIZE = 1;

}
