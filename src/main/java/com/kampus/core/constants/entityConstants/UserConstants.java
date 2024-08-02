package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class UserConstants {
    private UserConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String USER_TABLE = "Users";
    public static final String USER_INTEREST_TABLE = "UserInterests";


    /**
     * COLUMN
     */
    public static final String USER_COLUMN_USER_ID = "user_id";
    public static final String USER_COLUMN_USERNAME = "username";
    public static final String USER_COLUMN_PASSWORD = "password";
    public static final String USER_COLUMN_MAIL = "mail";
    public static final String USER_COLUMN_FIRST_NAME = "first_name";
    public static final String USER_COLUMN_LAST_NAME = "last_name";
    public static final String USER_COLUMN_PHONE_NUMBER = "phone_number";
    public static final String USER_COLUMN_BIRTH_DATE = "birth_date";
    public static final String USER_COLUMN_BIOGRAPHY = "biography";
    public static final String USER_COLUMN_PROFILE_PIC_URL = "profile_pic_url";
    public static final String USER_COLUMN_AVATAR_URL = "avatar_url";
    public static final String USER_COLUMN_ROLE = "role";
    public static final String USER_COLUMN_PERMISSION = "permission";
    public static final String USER_COLUMN_IS_PRIVATE = "is_private";
    public static final String USER_COLUMN_CREATED_AT = "created_at";
    public static final String USER_COLUMN_UPDATED_AT = "updated_at";
    public static final String USER_COLUMN_CURRENT_SITUATION = "current_situation";
    public static final String USER_COLUMN_STATUS = "status";

    public static final String USER_MAP_USER = "user";

    /**
     * INDEX
     */

    public static final String USER_IDX_USER_MAIL = "idx_user_mail";
    public static final String USER_IDX_USER_USERNAME = "idx_user_username";

    /**
     * SEQUENCE
     */
    public static final String USER_SEQ_USER = "user_seq";
    public static final String USER_SEQ_USER_ID = "user_id_seq";
    public static final int USER_SEQ_USER_ID_ALLOCATION_SIZE = 1;
}
