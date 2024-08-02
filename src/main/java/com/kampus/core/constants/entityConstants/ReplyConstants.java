package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class ReplyConstants {
    private ReplyConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String REPLY_TABLE = "Replies";


    /**
     * COLUMN
     */
    public static final String REPLY_COLUMN_REPLY_ID = "reply_id";
    public static final String REPLY_COLUMN_LIKE_COUNT = "like_count";
    public static final String REPLY_COLUMN_CONTENT_TYPE = "content_type";
    public static final String REPLY_COLUMN_CREATED_AT = "created_at";


    /**
     * INDEX
     */

    public static final String REPLY_IDX_REPLY_USER = "idx_reply_user";
    public static final String REPLY_IDX_REPLY_COMMENT = "idx_reply_comment";
    public static final String REPLY_IDX_REPLY_CREATED_AT = "idx_reply_created_at";

    /**
     * SEQUENCE
     */
    public static final String REPLY_SEQ_REPLY = "reply_seq";
    public static final String REPLY_SEQ_REPLY_ID = "reply_id_seq";
    public static final int REPLY_SEQ_REPLY_ID_ALLOCATION_SIZE = 1;
}