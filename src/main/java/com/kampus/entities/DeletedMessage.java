package com.kampus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

import static com.kampus.core.constants.EntityConstants.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = DELETED_MESSAGE_TABLE)
public class DeletedMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = DELETED_MESSAGE_SEQ_DELETED_MESSAGE)
    @SequenceGenerator(name = DELETED_MESSAGE_SEQ_DELETED_MESSAGE, sequenceName = DELETED_MESSAGE_SEQ_DELETED_MESSAGE_ID, allocationSize = DELETED_MESSAGE_SEQ_DELETED_MESSAGE_ID_ALLOCATION_SIZE)
    @Column(name = DELETED_MESSAGE_COLUMN_DELETED_MESSAGE_ID, nullable = false)
    private Long deleteMessageId;

    @ManyToOne
    @JoinColumn(name = DELETED_MESSAGE_COLUMN_ORIGINAL_MESSAGE_ID, referencedColumnName = MESSAGE_COLUMN_MESSAGE_ID, nullable = false)
    private Message originalMessage;

    @ManyToOne
    @JoinColumn(name = INBOX_COLUMN_INBOX_ID, referencedColumnName = INBOX_COLUMN_INBOX_ID, nullable = false)
    private Inbox inbox;

    @ManyToOne
    @JoinColumn(name = USER_COLUMN_USER_ID, referencedColumnName = USER_COLUMN_USER_ID, nullable = false)
    private User user;

    @CreationTimestamp
    @Column(name = DELETED_MESSAGE_COLUMN_DELETED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

}
