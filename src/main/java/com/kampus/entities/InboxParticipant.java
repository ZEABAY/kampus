package com.kampus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.kampus.core.constants.EntityConstants.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = INBOX_PARTICIPANT_TABLE, indexes = {
        @Index(name = INBOX_PARTICIPANT_IDX_INBOX_PARTICIPANT_USER, columnList = USER_COLUMN_USER_ID),
        @Index(name = INBOX_PARTICIPANT_IDX_INBOX_PARTICIPANT_INBOX, columnList = INBOX_COLUMN_INBOX_ID)
})
public class InboxParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = INBOX_PARTICIPANT_SEQ_INBOX_PARTICIPANT)
    @SequenceGenerator(name = INBOX_PARTICIPANT_SEQ_INBOX_PARTICIPANT, sequenceName = INBOX_PARTICIPANT_SEQ_INBOX_PARTICIPANT_ID, allocationSize = INBOX_PARTICIPANT_SEQ_INBOX_PARTICIPANT_ID_ALLOCATION_SIZE)
    @Column(name = INBOX_PARTICIPANT_COLUMN_INBOX_PARTICIPANT_ID,nullable = false)
    private Long inboxPartId;

    @ManyToOne
    @JoinColumn(name = USER_COLUMN_USER_ID, referencedColumnName = USER_COLUMN_USER_ID, nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = INBOX_COLUMN_INBOX_ID, referencedColumnName = INBOX_COLUMN_INBOX_ID, nullable = false)
    private Inbox inbox;

}
