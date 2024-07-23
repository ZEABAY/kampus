package com.kampus.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//E
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "Comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Posts post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "text_content")
    private String textContent;

    @Column(name = "like_count", nullable = false)
    private Integer likeCount = 0;

}
