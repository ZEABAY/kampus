package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class SeenMessageConstants {
    private SeenMessageConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String SEEN_MESSAGE_TABLE = "SeenMessages";


    /**
     * COLUMN
     */
    public static final String SEEN_MESSAGE_COLUMN_SEEN_MESSAGE_ID = "seen_message_id";
    public static final String SEEN_MESSAGE_COLUMN_SEEN_AT = "seen_at";


    /**
     * INDEX
     */

    public static final String SEEN_MESSAGE_IDX_SEEN_MESSAGE_MESSAGE = "idx_seen_message_message";
    public static final String SEEN_MESSAGE_IDX_SEEN_MESSAGE_USER = "idx_seen_message_user";
    public static final String SEEN_MESSAGE_IDX_SEEN_MESSAGE_SEEN_AT = "idx_seen_message_seen_at";

    /**
     * SEQUENCE
     */
    public static final String SEEN_MESSAGE_SEQ_SEEN_MESSAGE = "seen_msg_seq";
    public static final String SEEN_MESSAGE_SEQ_SEEN_MESSAGE_ID = "seen_msg_id_seq";
    public static final int SEEN_MESSAGE_SEQ_SEEN_MESSAGE_ID_ALLOCATION_SIZE = 1;
}
