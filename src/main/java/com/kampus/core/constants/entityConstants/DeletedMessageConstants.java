package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class DeletedMessageConstants {

    private DeletedMessageConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String DELETED_MESSAGE_TABLE = "DeletedMessages";


    /**
     * COLUMN
     */
    public static final String DELETED_MESSAGE_COLUMN_DELETED_MESSAGE_ID = "deleted_message_id";
    public static final String DELETED_MESSAGE_COLUMN_ORIGINAL_MESSAGE_ID = "original_message_id";
    public static final String DELETED_MESSAGE_COLUMN_DELETED_AT = "deleted_at";

    /**
     * SEQUENCE
     */
    public static final String DELETED_MESSAGE_SEQ_DELETED_MESSAGE = "deleted_msg_seq";
    public static final String DELETED_MESSAGE_SEQ_DELETED_MESSAGE_ID = "deleted_message_id_seq";

    public static final int DELETED_MESSAGE_SEQ_DELETED_MESSAGE_ID_ALLOCATION_SIZE = 1;
}
