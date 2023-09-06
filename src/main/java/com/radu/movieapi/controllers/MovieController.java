package com.radu.movieapi.controllers;

import com.radu.movieapi.models.Movie;
import com.radu.movieapi.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @GetMapping("/movies")
    public Iterable<Movie> getAllMovies(){
        return this.movieRepository.findAll();
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> getMoviesByGenre(@PathVariable String genre){
        return this.movieRepository.findMoviesByGenre(genre);
    }
    @GetMapping("/tag/{tag}")
    public List<Movie> getMoviesByTag(@PathVariable List<String> tag){
        return this.movieRepository.findMoviesByTag(tag);
    }


}
