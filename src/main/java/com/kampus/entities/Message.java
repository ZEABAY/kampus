package com.kampus.entities;

import com.kampus.core.utilities.enums.MessageType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.kampus.core.constants.entityConstants.InboxConstants.INBOX_COLUMN_INBOX_ID;
import static com.kampus.core.constants.entityConstants.MessageConstants.*;
import static com.kampus.core.constants.entityConstants.UserConstants.USER_COLUMN_USER_ID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = MESSAGE_TABLE, indexes = {
        @Index(name = MESSAGE_IDX_MESSAGE_INBOX_CREATED_AT, columnList = MESSAGE_COLUMN_LIST)
})
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = MESSAGE_SEQ_MESSAGE)
    @SequenceGenerator(name = MESSAGE_SEQ_MESSAGE, sequenceName = MESSAGE_SEQ_MESSAGE_ID, allocationSize = MESSAGE_SEQ_MESSAGE_ID_ALLOCATION_SIZE)
    @Column(name = MESSAGE_COLUMN_MESSAGE_ID, unique = true, nullable = false)
    private Long messageId;


    @ManyToOne
    @JoinColumn(name = INBOX_COLUMN_INBOX_ID, referencedColumnName = INBOX_COLUMN_INBOX_ID, nullable = false)
    private Inbox inbox;

    @ManyToOne
    @JoinColumn(name = USER_COLUMN_USER_ID, referencedColumnName = USER_COLUMN_USER_ID, nullable = false)
    private User user;

    @Column(name = MESSAGE_COLUMN_MESSAGE_CONTENT)
    private String messageContent;

    @Column(name = MESSAGE_COLUMN_MEDIA_URL)
    private String mediaUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = MESSAGE_COLUMN_MESSAGE_TYPE, nullable = false)
    private MessageType messageType;

    @Column(name = MESSAGE_COLUMN_CREATED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = MESSAGE_COLUMN_UPDATED_AT)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = MESSAGE_COLUMN_IS_DELETED, nullable = false)
    private Boolean isDeleted;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}

