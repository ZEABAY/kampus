package com.kampus.entities;

import com.kampus.core.utilities.enums.ContentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.kampus.core.constants.entityConstants.PostConstants.POST_COLUMN_POST_ID;
import static com.kampus.core.constants.entityConstants.PostMediaConstants.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = POST_MEDIA_TABLE, indexes = {
        @Index(name = POST_MEDIA_IDX_POST_MEDIA_POST, columnList = POST_COLUMN_POST_ID),
        @Index(name = POST_MEDIA_IDX_POST_MEDIA_CREATED_AT, columnList = POST_MEDIA_COLUMN_CREATED_AT)
})
public class PostMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = POST_MEDIA_SEQ_POST_MEDIA)
    @SequenceGenerator(name = POST_MEDIA_SEQ_POST_MEDIA, sequenceName = POST_MEDIA_SEQ_POST_MEDIA_ID, allocationSize = POST_MEDIA_SEQ_POST_MEDIA_ID_ALLOCATION_SIZE)
    @Column(name = POST_MEDIA_COLUMN_MEDIA_ID, unique = true, nullable = false)
    private Long mediaId;

    @ManyToOne
    @JoinColumn(name = POST_COLUMN_POST_ID, nullable = false, referencedColumnName = POST_COLUMN_POST_ID)
    private Post post;

    @Enumerated(EnumType.STRING)
    @Column(name = POST_MEDIA_COLUMN_MEDIA_TYPE, nullable = false)
    private ContentType mediaType;

    @Column(name = POST_MEDIA_COLUMN_MEDIA_URL, nullable = false)
    private String mediaUrl;

    @Column(name = POST_MEDIA_COLUMN_CREATED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
