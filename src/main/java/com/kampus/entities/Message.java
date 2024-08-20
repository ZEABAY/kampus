package com.kampus.entities;

import com.kampus.core.utilities.enums.MessageType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

import static com.kampus.core.constants.EntityConstants.*;


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
    @CreationTimestamp
    private Date createdAt;

    @Column(name = MESSAGE_COLUMN_UPDATED_AT)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedAt;
}

