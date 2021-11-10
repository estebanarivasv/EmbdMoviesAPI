package com.erivas.embd.services;

import com.erivas.embd.data.dtos.MovieDto;
import com.erivas.embd.data.mappers.MovieMapper;
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
    private final MovieMapper movieMapper;

    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public ResponseEntity<List<MovieDto>> getAll() throws RuntimeException {
        List<MovieModel> movieModels = movieRepository.findAll();
        List<MovieDto> movieDtoList = movieMapper.moviesToDto(movieModels);
        return ResponseEntity.status(HttpStatus.OK).body(movieDtoList);
    }

    public ResponseEntity<MovieDto> getOne(Long id) throws RuntimeException {

        Optional<MovieModel> movieModel = movieRepository.findById(id);
        if (movieModel.isPresent()) {
            MovieModel movie = movieModel.get();
            return ResponseEntity.status(HttpStatus.OK).body(movieMapper.movieToDto(movie));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
