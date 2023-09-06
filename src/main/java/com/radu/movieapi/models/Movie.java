package com.radu.movieapi.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Movies")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String genre;
    @ElementCollection
    private List<String> tags;
    private Integer length; // minutes
    private LocalDateTime dateReleased;
    private LocalDateTime dateAvailableUntil;

    @OneToOne
    private Metadata metadata;
}
