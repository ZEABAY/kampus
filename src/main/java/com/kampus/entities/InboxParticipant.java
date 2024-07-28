package com.kampus.entities;
import com.kampus.core.utilities.enums.InboxType;
import com.kampus.core.utilities.enums.MessageType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "InboxParticipants")
public class InboxParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inbox_part_seq")
    @SequenceGenerator(name = "inbox_part_seq", sequenceName = "inbox_part_id_seq", allocationSize = 1)
    @Column(name = "inbox_part_id")
    private Long inboxPartId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "inbox_id", referencedColumnName = "inbox_id", nullable = false)
    private Inbox inbox;

}
