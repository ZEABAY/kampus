package com.kampus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.kampus.core.constants.entityConstants.DeletedConversationConstants.*;
import static com.kampus.core.constants.entityConstants.InboxConstants.INBOX_COLUMN_INBOX_ID;
import static com.kampus.core.constants.entityConstants.UserConstants.USER_COLUMN_USER_ID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = DELETED_CONVERSATION_TABLE)
public class DeletedConversation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = DELETED_CONVERSATION_SEQ_DELETED_CONVERSATION)
    @SequenceGenerator(name = DELETED_CONVERSATION_SEQ_DELETED_CONVERSATION, sequenceName = DELETED_CONVERSATION_SEQ_DELETED_CONVERSATION_ID, allocationSize = DELETED_CONVERSATION_SEQ_DELETED_CONVERSATION_ID_ALLOCATION_SIZE)
    @Column(name = DELETED_CONVERSATION_COLUMN_DELETED_CONVERSATION_ID)
    private Long deletedConversationId;

    @ManyToOne
    @JoinColumn(name = INBOX_COLUMN_INBOX_ID, referencedColumnName = INBOX_COLUMN_INBOX_ID, nullable = false)
    private Inbox inbox;

    @ManyToOne
    @JoinColumn(name = USER_COLUMN_USER_ID, referencedColumnName = USER_COLUMN_USER_ID, nullable = false)
    private User user;

    @Column(name = DELETED_CONVERSATION_COLUMN_DELETED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    @PrePersist
    protected void onCreate() {
        this.deletedAt = new Date();
    }
}