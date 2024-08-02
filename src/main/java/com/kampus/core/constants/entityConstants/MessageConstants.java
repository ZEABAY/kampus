package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;
import static com.kampus.core.constants.entityConstants.InboxConstants.INBOX_COLUMN_INBOX_ID;

public class MessageConstants {
    private MessageConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String MESSAGE_TABLE = "Messages";


    /**
     * COLUMN
     */
    public static final String MESSAGE_COLUMN_MESSAGE_ID = "message_id";
    public static final String MESSAGE_COLUMN_MESSAGE_CONTENT = "message_content";
    public static final String MESSAGE_COLUMN_MEDIA_URL = "media_url";
    public static final String MESSAGE_COLUMN_MESSAGE_TYPE = "message_type";
    public static final String MESSAGE_COLUMN_CREATED_AT = "created_at";
    public static final String MESSAGE_COLUMN_UPDATED_AT = "updated_at";
    public static final String MESSAGE_COLUMN_IS_DELETED = "is_deleted";


    /**
     * INDEX
     */

    public static final String MESSAGE_IDX_MESSAGE_INBOX_CREATED_AT = "idx_message_inbox_created_at";
    public static final String MESSAGE_COLUMN_LIST = INBOX_COLUMN_INBOX_ID + ", " + MESSAGE_COLUMN_CREATED_AT;
    /**
     * SEQUENCE
     */
    public static final String MESSAGE_SEQ_MESSAGE = "message_seq";
    public static final String MESSAGE_SEQ_MESSAGE_ID = "message_id_seq";
    public static final int MESSAGE_SEQ_MESSAGE_ID_ALLOCATION_SIZE = 1;
}
