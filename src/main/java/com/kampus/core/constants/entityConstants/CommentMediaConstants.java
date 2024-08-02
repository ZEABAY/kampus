package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class CommentMediaConstants {
    private CommentMediaConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String COMMENT_MEDIA_TABLE = "CommentMedias";


    /**
     * COLUMN
     */
    public static final String COMMENT_MEDIA_COLUMN_MEDIA_ID = "media_id";
    public static final String COMMENT_MEDIA_COLUMN_MEDIA_TYPE = "media_type";
    public static final String COMMENT_MEDIA_COLUMN_MEDIA_URL = "media_url";
    public static final String COMMENT_MEDIA_COLUMN_CREATED_AT = "created_at";

    /**
     * SEQUENCE
     */
    public static final String COMMENT_MEDIA_SEQ_COMMENT_MEDIA = "comment_media_seq";
    public static final String COMMENT_MEDIA_SEQ_COMMENT_MEDIA_ID = "comment_media_id_seq";
    public static final int COMMENT_MEDIA_SEQ_COMMENT_MEDIA_ID_ALLOCATION_SIZE = 1;
}
