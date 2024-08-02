package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class UserBanConstants {
    private UserBanConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String USER_BAN_TABLE = "UserBans";


    /**
     * COLUMN
     */
    public static final String USER_BAN_COLUMN_BAN_ID = "ban_id";
    public static final String USER_BAN_COLUMN_REASON = "reason";
    public static final String USER_BAN_COLUMN_BANNED_AT = "banned_at";

    public static final String USER_BAN_COLUMN_BANNED_USER_ID = "banned_user_id";
    public static final String USER_BAN_COLUMN_BANNED_BY_USER_ID = "banned_by_user_id";


    /**
     * SEQUENCE
     */
    public static final String USER_BAN_SEQ_USER_BAN = "user_ban_seq";
    public static final String USER_BAN_SEQ_USER_BAN_ID = "user_ban_id_seq";
    public static final int USER_BAN_SEQ_USER_BAN_ID_ALLOCATION_SIZE = 1;
}