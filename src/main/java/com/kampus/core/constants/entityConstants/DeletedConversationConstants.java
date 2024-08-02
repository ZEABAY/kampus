package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class DeletedConversationConstants {
    private DeletedConversationConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String DELETED_CONVERSATION_TABLE = "DeletedConversations";


    /**
     * COLUMN
     */
    public static final String DELETED_CONVERSATION_COLUMN_DELETED_CONVERSATION_ID = "deleted_conversation_id";
    public static final String DELETED_CONVERSATION_COLUMN_DELETED_AT = "deleted_at";

    /**
     * SEQUENCE
     */
    public static final String DELETED_CONVERSATION_SEQ_DELETED_CONVERSATION = "deleted_conversation_seq";
    public static final String DELETED_CONVERSATION_SEQ_DELETED_CONVERSATION_ID = "deleted_conversation_id_seq";
    public static final int DELETED_CONVERSATION_SEQ_DELETED_CONVERSATION_ID_ALLOCATION_SIZE = 1;
}
