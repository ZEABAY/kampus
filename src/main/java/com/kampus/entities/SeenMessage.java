package com.kampus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SeenMessages", indexes = {
        @Index(name = "idx_seenmessage_message", columnList = "message_id"),
        @Index(name = "idx_seenmessage_user", columnList = "user_id"),
        @Index(name = "idx_seenmessage_seen_at", columnList = "seen_at")
})
public class SeenMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seen_msg_seq")
    @SequenceGenerator(name = "seen_msg_seq", sequenceName = "seen_message_id_seq", allocationSize = 1)
    @Column(name = "seen_message_id")
    private Long seenMessageId;

    @ManyToOne
    @JoinColumn(name = "message_id", referencedColumnName = "message_id", nullable = false)
    private Message message;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @Column(name = "seen_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date seenAt;
}