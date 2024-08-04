package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class InboxConstants {
    private InboxConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String INBOX_TABLE = "Inboxes";


    /**
     * COLUMN
     */
    public static final String INBOX_COLUMN_INBOX_ID = "inbox_id";
    public static final String INBOX_COLUMN_LAST_MESSAGE = "last_message";
    public static final String INBOX_COLUMN_LAST_SEND_USER_ID = "last_send_user_id";
    public static final String INBOX_COLUMN_INBOX_TYPE = "inbox_type";
    public static final String INBOX_COLUMN_CREATED_AT = "created_at";
    public static final String INBOX_COLUMN_UPDATED_AT = "updated_at";


    /**
     * INDEX
     */

    public static final String INBOX_IDX_INBOX_LAST_UPDATED = "idx_inbox_last_updated";
    public static final String INBOX_IDX_INBOX_LAST_SEND_USER = "idx_inbox_last_send_user";

    /**
     * SEQUENCE
     */
    public static final String INBOX_SEQ_INBOX = "inbox_seq";
    public static final String INBOX_SEQ_INBOX_ID = "inbox_id_seq";
    public static final int INBOX_SEQ_INBOX_ID_ALLOCATION_SIZE = 1;

}
