package com.kampus.core.constants.entityConstants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_UTILITY_CLASS;

public class InboxParticipantsConstants {
    private InboxParticipantsConstants() {
        throw new BusinessException(EXCEPTION_CONSTANT_UTILITY_CLASS);
    }


    /**
     * TABLE
     */
    public static final String INBOX_PARTICIPANT_TABLE = "InboxParticipants";


    /**
     * COLUMN
     */
    public static final String INBOX_PARTICIPANT_COLUMN_INBOX_PARTICIPANT_ID = "inbox_participant_id";


    /**
     * INDEX
     */

    public static final String INBOX_PARTICIPANT_IDX_INBOX_PARTICIPANT_USER = "idx_inbox_participant_user";
    public static final String INBOX_PARTICIPANT_IDX_INBOX_PARTICIPANT_INBOX = "idx_inbox_participant_inbox";

    /**
     * SEQUENCE
     */
    public static final String INBOX_PARTICIPANT_SEQ_INBOX_PARTICIPANT = "inbox_participant_seq";
    public static final String INBOX_PARTICIPANT_SEQ_INBOX_PARTICIPANT_ID = "inbox_participant_id_seq";
    public static final int INBOX_PARTICIPANT_SEQ_INBOX_PARTICIPANT_ID_ALLOCATION_SIZE = 1;

}
