package com.erivas.embd.services;

import com.erivas.embd.data.models.MovieModel;
import com.erivas.embd.repositories.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public ResponseEntity<List<MovieModel>> getAll() throws RuntimeException {
        return ResponseEntity.status(HttpStatus.OK).body(movieRepository.findAll());
    }

    public ResponseEntity<MovieModel> getOne(Long id) throws RuntimeException {

        Optional<MovieModel> movieModel = movieRepository.findById(id);
        if (movieModel.isPresent()) {
            MovieModel movie = movieModel.get();
            return ResponseEntity.status(HttpStatus.OK).body(movie);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
