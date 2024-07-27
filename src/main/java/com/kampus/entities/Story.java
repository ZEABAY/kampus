package com.kampus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Stories")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "stories_seq")
    @SequenceGenerator(name = "stories_seq", sequenceName = "stories_id_seq", allocationSize = 1)
    @Column(name = "stories_id")
    private Long storiesId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Column(name = "story_type")
    private String storyType;

    @Column(name = "story_url")
    private String url;


}
