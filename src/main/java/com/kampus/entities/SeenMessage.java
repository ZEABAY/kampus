package com.kampus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.kampus.core.constants.entityConstants.MessageConstants.MESSAGE_COLUMN_MESSAGE_ID;
import static com.kampus.core.constants.entityConstants.SeenMessageConstants.*;
import static com.kampus.core.constants.entityConstants.UserConstants.USER_COLUMN_USER_ID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = SEEN_MESSAGE_TABLE, indexes = {
        @Index(name = SEEN_MESSAGE_IDX_SEEN_MESSAGE_MESSAGE, columnList = MESSAGE_COLUMN_MESSAGE_ID),
        @Index(name = SEEN_MESSAGE_IDX_SEEN_MESSAGE_USER, columnList = USER_COLUMN_USER_ID),
        @Index(name = SEEN_MESSAGE_IDX_SEEN_MESSAGE_SEEN_AT, columnList = SEEN_MESSAGE_COLUMN_SEEN_AT)
})
public class SeenMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEEN_MESSAGE_SEQ_SEEN_MESSAGE)
    @SequenceGenerator(name = SEEN_MESSAGE_SEQ_SEEN_MESSAGE, sequenceName = SEEN_MESSAGE_SEQ_SEEN_MESSAGE_ID, allocationSize = SEEN_MESSAGE_SEQ_SEEN_MESSAGE_ID_ALLOCATION_SIZE)
    @Column(name = SEEN_MESSAGE_COLUMN_SEEN_MESSAGE_ID)
    private Long seenMessageId;

    @ManyToOne
    @JoinColumn(name = MESSAGE_COLUMN_MESSAGE_ID, referencedColumnName = MESSAGE_COLUMN_MESSAGE_ID, nullable = false)
    private Message message;

    @ManyToOne
    @JoinColumn(name = USER_COLUMN_USER_ID, referencedColumnName = USER_COLUMN_USER_ID, nullable = false)
    private User user;

    @Column(name = SEEN_MESSAGE_COLUMN_SEEN_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date seenAt;
    @PrePersist
    protected void onCreate(){
        this.seenAt=new Date();
    }
}