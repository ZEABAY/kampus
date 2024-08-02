package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class StoryConstants {
    private StoryConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String STORY_TABLE = "Stories";


    /**
     * COLUMN
     */
    public static final String STORY_COLUMN_STORY_ID = "story_ıd";
    public static final String STORY_COLUMN_STORY_TYPE = "story_type";
    public static final String STORY_COLUMN_STORY_URL = "story_url";
    public static final String STORY_COLUMN_CREATED_AT = "created_at";


    /**
     * INDEX
     */

    public static final String STORY_IDX_STORY_USER = "idx_story_user";
    public static final String STORY_IDX_STORY_CREATED_AT = "idx_story_created_at";

    /**
     * SEQUENCE
     */
    public static final String STORY_SEQ_STORY = "story_seq";
    public static final String STORY_SEQ_STORY_ID = "story_id_seq";
    public static final int STORY_SEQ_STORY_ID_ALLOCATION_SIZE = 1;
}

