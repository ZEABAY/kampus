package com.kampus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.kampus.core.constants.entityConstants.StoryConstants.*;
import static com.kampus.core.constants.entityConstants.UserConstants.USER_COLUMN_USER_ID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = STORY_TABLE, indexes = {
        @Index(name = STORY_IDX_STORY_USER, columnList = USER_COLUMN_USER_ID),
        @Index(name = STORY_IDX_STORY_CREATED_AT, columnList = STORY_COLUMN_CREATED_AT)
})
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = STORY_SEQ_STORY)
    @SequenceGenerator(name = STORY_SEQ_STORY, sequenceName = STORY_SEQ_STORY_ID, allocationSize = STORY_SEQ_STORY_ID_ALLOCATION_SIZE)
    @Column(name = STORY_COLUMN_STORY_ID)
    private Long storiesId;

    @ManyToOne
    @JoinColumn(name = USER_COLUMN_USER_ID, referencedColumnName = USER_COLUMN_USER_ID)
    private User user;

    @Column(name = STORY_COLUMN_STORY_TYPE)
    private String storyType;

    @Column(name = STORY_COLUMN_STORY_URL)
    private String url;

    @Column(name = STORY_COLUMN_CREATED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }


}
