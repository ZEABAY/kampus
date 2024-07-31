package com.kampus.entities;

import com.kampus.core.utilities.enums.InboxType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Inboxes", indexes = {
        @Index(name = "idx_inbox_last_updated", columnList = "last_updated"),
        @Index(name = "idx_inbox_last_send_user", columnList = "last_send_user_id")
})
public class Inbox {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inbox_seq")
    @SequenceGenerator(name = "inbox_seq", sequenceName = "inbox_id_seq", allocationSize = 1)
    @Column(name = "inbox_id")
    private Long inboxId;

    @Column(name = "last_message")
    private String lastMessage;

    @ManyToOne
    @JoinColumn(name = "last_send_user_id", referencedColumnName = "user_id")
    private User lastSendUser;

    @Enumerated(EnumType.STRING)
    @Column(name = "inbox_type", nullable = false)
    private InboxType inboxType;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "last_updated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

}
