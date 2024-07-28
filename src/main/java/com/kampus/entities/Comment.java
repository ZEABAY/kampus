package com.kampus.entities;

import com.kampus.core.utilities.enums.ContentType;
import com.kampus.core.utilities.enums.MessageType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "comments_seq")
    @SequenceGenerator(name = "comments_seq",sequenceName = "comments_id_seq",allocationSize = 1)
    @Column(name = "comment_id", unique = true, nullable = false)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false,referencedColumnName = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,referencedColumnName = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "textContent", nullable = false)
    private ContentType textContent;


    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CommentLike> likes;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt ;
}
