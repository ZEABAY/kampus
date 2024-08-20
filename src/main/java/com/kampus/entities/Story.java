package com.kampus.entities;

import com.kampus.core.utilities.enums.ContentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

import static com.kampus.core.constants.EntityConstants.*;


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
    @Column(name = STORY_COLUMN_STORY_ID, nullable = false)
    private Long storyId;

    @ManyToOne
    @JoinColumn(name = USER_COLUMN_USER_ID, referencedColumnName = USER_COLUMN_USER_ID, nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = STORY_COLUMN_STORY_TYPE, nullable = false)
    private ContentType storyType;

    @Column(name = STORY_COLUMN_STORY_URL, nullable = false)
    private String url;

    @Column(name = STORY_COLUMN_CREATED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;
}
