package com.radu.movieapi.repositories;

import com.radu.movieapi.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findMoviesByGenre(String genre);
    @Query("SELECT m FROM Movie m WHERE :tag MEMBER OF m.tags")
    List<Movie> findMoviesByTag(List<String> tag);
}
