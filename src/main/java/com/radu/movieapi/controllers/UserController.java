package com.radu.movieapi.controllers;

import com.radu.movieapi.models.Movie;
import com.radu.movieapi.models.User;
import com.radu.movieapi.repositories.MovieRepository;
import com.radu.movieapi.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UserController {
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    @Autowired
    public UserController(UserRepository userRepository, MovieRepository movieRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
    }

    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id){
        Optional<User> optionalUser = this.userRepository.findById(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            List<Long> moviesIds = user.getFavouriteMovies();
            List<String> movieNames = getMovieNamesByIds(moviesIds);
            user.setFavouriteMoviesNames(movieNames);

            return user;
        }
        else {
            throw new EntityNotFoundException("User doesn't exist");
        }
    }

    public List<String> getMovieNamesByIds(List<Long> movieIds) {
        List<Movie> movies = movieRepository.findAllById(movieIds);
        return movies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
    }


}
