package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tutorials")
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
