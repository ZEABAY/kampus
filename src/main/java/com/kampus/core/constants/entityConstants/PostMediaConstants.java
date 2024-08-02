package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class PostMediaConstants {
    private PostMediaConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String POST_MEDIA_TABLE = "PostMedias";


    /**
     * COLUMN
     */
    public static final String POST_MEDIA_COLUMN_MEDIA_ID = "media_id";
    public static final String POST_MEDIA_COLUMN_MEDIA_TYPE = "media_type";
    public static final String POST_MEDIA_COLUMN_MEDIA_URL = "media_url";
    public static final String POST_MEDIA_COLUMN_CREATED_AT = "created_at";


    /**
     * INDEX
     */

    public static final String POST_MEDIA_IDX_POST_MEDIA_POST = "idx_post_media_post";
    public static final String POST_MEDIA_IDX_POST_MEDIA_CREATED_AT = "idx_post_media_created_at";

    /**
     * SEQUENCE
     */
    public static final String POST_MEDIA_SEQ_POST_MEDIA = "post_media_seq";
    public static final String POST_MEDIA_SEQ_POST_MEDIA_ID = "post_media_id_seq";
    public static final int POST_MEDIA_SEQ_POST_MEDIA_ID_ALLOCATION_SIZE = 1;
}

