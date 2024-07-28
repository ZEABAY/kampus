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
@Table(name = "DeletedConversations")
public class DeletedConversation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deleted_conv_seq")
    @SequenceGenerator(name = "deleted_conv_seq", sequenceName = "deleted_conversation_id_seq", allocationSize = 1)
    @Column(name = "deleted_conversation_id")
    private Long deletedConversationId;

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