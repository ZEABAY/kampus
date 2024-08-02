package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class PostLikeConstants {
    private PostLikeConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String POST_LIKE_TABLE = "PostLikes";


    /**
     * COLUMN
     */
    public static final String POST_LIKE_COLUMN_LIKE_ID = "like_id";
    public static final String POST_LIKE_COLUMN_CREATED_AT = "created_at";


    /**
     * INDEX
     */

    public static final String POST_LIKE_IDX_POST_LIKE_POST = "idx_post_like_post";
    public static final String POST_LIKE_IDX_POST_LIKE_USER = "idx_post_like_user";

    /**
     * SEQUENCE
     */
    public static final String POST_LIKE_SEQ_POST_LIKE = "post_like_seq";
    public static final String POST_LIKE_SEQ_POST_LIKE_ID = "post_like_id_seq";
    public static final int POST_LIKE_SEQ_POST_LIKE_ID_ALLOCATION_SIZE = 1;
}
