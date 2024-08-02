package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class CommentConstants {

    private CommentConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String COMMENT_TABLE = "Comments";


    /**
     * COLUMN
     */
    public static final String COMMENT_COLUMN_COMMENT_ID = "comment_id";
    public static final String COMMENT_COLUMN_TEXT_CONTENT = "text_content";
    public static final String COMMENT_COLUMN_CREATED_AT = "created_at";

    public static final String COMMENT_MAP_COMMENT = "comment";


    /**
     * INDEX
     */

    public static final String COMMENT_IDX_COMMENT_POST = "idx_comment_post";
    public static final String COMMENT_IDX_COMMENT_USER = "idx_comment_user";
    public static final String COMMENT_IDX_COMMENT_CREATED_AT = "idx_comment_created_at";

    /**
     * SEQUENCE
     */
    public static final String COMMENT_SEQ_COMMENT = "comment_seq";
    public static final String COMMENT_SEQ_COMMENT_ID = "comment_id_seq";
    public static final int COMMENT_SEQ_COMMENT_ID_ALLOCATION_SIZE = 1;
}