package com.kampus.entities;

import com.kampus.core.utilities.enums.InboxType;
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
@Table(name = INBOX_TABLE, indexes = {
        @Index(name = INBOX_IDX_INBOX_LAST_UPDATED, columnList = INBOX_COLUMN_UPDATED_AT),
        @Index(name = INBOX_IDX_INBOX_LAST_SEND_USER, columnList = INBOX_COLUMN_LAST_SEND_USER_ID)
})
public class Inbox {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = INBOX_SEQ_INBOX)
    @SequenceGenerator(name = INBOX_SEQ_INBOX, sequenceName = INBOX_SEQ_INBOX_ID, allocationSize = INBOX_SEQ_INBOX_ID_ALLOCATION_SIZE)
    @Column(name = INBOX_COLUMN_INBOX_ID)
    private Long inboxId;

    @Column(name = INBOX_COLUMN_LAST_MESSAGE)
    private String lastMessage;

    @ManyToOne
    @JoinColumn(name = INBOX_COLUMN_LAST_SEND_USER_ID, referencedColumnName = USER_COLUMN_USER_ID)
    private User lastSendUser;

    @Enumerated(EnumType.STRING)
    @Column(name = INBOX_COLUMN_INBOX_TYPE, nullable = false)
    private InboxType inboxType;

    @Column(name = INBOX_COLUMN_CREATED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = INBOX_COLUMN_UPDATED_AT)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedAt;
}
