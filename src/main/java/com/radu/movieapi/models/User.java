package com.radu.movieapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String number;
    @ElementCollection
    private List<Long> favouriteMovies;
    @Transient
    private List<String> favouriteMoviesNames;
    @OneToOne
    private Preference preference;

}
