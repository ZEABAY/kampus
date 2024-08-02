package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class CommentLikeConstants {

    private CommentLikeConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String COMMENT_LIKE_TABLE = "CommentLikes";


    /**
     * COLUMN
     */
    public static final String COMMENT_LIKE_COLUMN_LIKE_ID = "like_id";
    public static final String COMMENT_LIKE_COLUMN_CREATED_AT = "created_at";


    /**
     * INDEX
     */

    public static final String COMMENT_LIKE_IDX_COMMENT_LIKE_COMMENT = "idx_comment_like_comment";
    public static final String COMMENT_LIKE_IDX_COMMENT_LIKE_USER = "idx_comment_like_user";

    /**
     * SEQUENCE
     */
    public static final String COMMENT_LIKE_SEQ_COMMENT_LIKE = "comment_like_seq";
    public static final String COMMENT_LIKE_SEQ_COMMENT_LIKE_ID = "comments_like_id_seq";
    public static final int COMMENT_LIKE_SEQ_COMMENT_LIKE_ID_ALLOCATION_SIZE = 1;

}
