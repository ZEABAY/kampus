package com.kampus.entities;
import com.kampus.core.utilities.enums.InboxType;
import com.kampus.core.utilities.enums.MessageType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SeenMessages")
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