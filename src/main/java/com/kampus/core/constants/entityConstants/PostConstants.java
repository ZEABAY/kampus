package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class PostConstants {
    private PostConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String POST_TABLE = "Posts";


    /**
     * COLUMN
     */
    public static final String POST_COLUMN_POST_ID = "post_id";
    public static final String POST_COLUMN_CONTENT_TYPE = "content_type";
    public static final String POST_COLUMN_TEXT_CONTENT = "text_content";
    public static final String POST_COLUMN_LIKE_COUNT = "like_count";
    public static final String POST_COLUMN_COMMENT_COUNT = "comment_count";
    public static final String POST_COLUMN_CREATED_AT = "created_at";
    public static final String POST_COLUMN_UPDATED_AT = "updated_at";

    public static final String POST_MAP_POSTS = "post";


    /**
     * INDEX
     */

    public static final String POST_IDX_POST_USER = "idx_post_user";
    public static final String POST_IDX_POST_CREATED_AT = "idx_post_created_at";
    public static final String POST_IDX_POST_UPDATED_AT = "idx_post_updated_at";

    /**
     * SEQUENCE
     */
    public static final String POST_SEQ_POST = "post_seq";
    public static final String POST_SEQ_POST_ID = "post_id_seq";
    public static final int POST_SEQ_POST_ID_ALLOCATION_SIZE = 1;
}
