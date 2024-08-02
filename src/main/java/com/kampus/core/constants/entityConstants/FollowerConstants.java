package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class FollowerConstants {
    private FollowerConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String FOLLOWER_TABLE = "Followers";


    /**
     * COLUMN
     */
    public static final String FOLLOWER_COLUMN_FOLLOWER_ID = "follower_id";
    public static final String FOLLOWER_COLUMN_STATUS = "status";
    public static final String FOLLOWER_COLUMN_CREATED_AT = "created_at";

    public static final String FOLLOWER_COLUMN_FOLLOWED_USER_ID = "followed_user_id";
    public static final String FOLLOWER_COLUMN_FOLLOWER_USER_ID = "follower_user_id";


    /**
     * INDEX
     */

    public static final String FOLLOWER_IDX_FOLLOWER = "idx_follower";
    public static final String FOLLOWER_IDX_FOLLOWED = "idx_followed";
    public static final String FOLLOWER_IDX_STATUS = "idx_status";

    /**
     * SEQUENCE
     */
    public static final String FOLLOWER_SEQ_FOLLOWER = "follower_seq";
    public static final String FOLLOWER_SEQ_FOLLOWER_ID = "follower_id_seq";
    public static final int FOLLOWER_SEQ_FOLLOWER_ID_ALLOCATION_SIZE = 1;

}