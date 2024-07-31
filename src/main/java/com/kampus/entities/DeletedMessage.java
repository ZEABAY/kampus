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
@Table(name = "DeletedMessages")
public class DeletedMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deleted_msg_seq")
    @SequenceGenerator(name = "deleted_msg_seq", sequenceName = "deleted_message_id_seq", allocationSize = 1)
    @Column(name = "delete_message_id")
    private Long deleteMessageId;

    @ManyToOne
    @JoinColumn(name = "original_message_id", referencedColumnName = "message_id", nullable = false)
    private Message originalMessage;

    @ManyToOne
    @JoinColumn(name = "inbox_id", referencedColumnName = "inbox_id", nullable = false)
    private Inbox inbox;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @Column(name = "deleted_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

}
