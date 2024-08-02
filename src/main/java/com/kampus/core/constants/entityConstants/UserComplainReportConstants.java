package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class UserComplainReportConstants {
    private UserComplainReportConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String USER_COMPLAIN_REPORT_TABLE = "UserComplainReports";


    /**
     * COLUMN
     */
    public static final String USER_COMPLAIN_REPORT_COLUMN_REPORT_ID = "report_id";
    public static final String USER_COMPLAIN_REPORT_COLUMN_REPORT_TYPE = "report_type";
    public static final String USER_COMPLAIN_REPORT_COLUMN_CREATED_AT = "created_at";
    public static final String USER_COMPLAIN_REPORT_COLUMN_REPORTER_ID = "reporter_id";
    public static final String USER_COMPLAIN_REPORT_COLUMN_REPORTED_ID = "reported_id";

    /**
     * SEQUENCE
     */
    public static final String USER_COMPLAIN_REPORT_SEQ_USER_COMPLAIN_REPORT = "user_complain_report_seq";
    public static final String USER_COMPLAIN_REPORT_SEQ_USER_COMPLAIN_REPORT_ID = "user_complain_report_id_seq";
    public static final int USER_COMPLAIN_REPORT_SEQ_USER_COMPLAIN_REPORT_ID_ALLOCATION_SIZE = 1;
}
