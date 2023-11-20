package org.example.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "tutorials")
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tutorial_id")
    private Long tutorialID;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 250, nullable = false)
    private String description;

    @Column(name = "is_published", nullable = false)
    private boolean isPublished;

    @Column(name = "published_date")
    @Temporal(TemporalType.DATE)
    private Date publishedDate;

}
