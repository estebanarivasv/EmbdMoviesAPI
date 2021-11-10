package com.erivas.embd.services;


import com.erivas.embd.data.dtos.CommentDto;
import com.erivas.embd.data.mappers.CommentMapper;
import com.erivas.embd.data.models.CommentModel;
import com.erivas.embd.data.models.MovieModel;
import com.erivas.embd.repositories.CommentRepository;
import com.erivas.embd.repositories.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final MovieRepository movieRepository;
    private final CommentMapper commentMapper;

    public CommentService(CommentRepository commentRepository, MovieRepository movieRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.movieRepository = movieRepository;
        this.commentMapper = commentMapper;
    }

    public ResponseEntity<CommentDto> create(Long movieId, CommentDto commentDto) throws RuntimeException {
        Optional<MovieModel> movieModel = movieRepository.findById(movieId);
        if (movieModel.isPresent()) {
            MovieModel movie = movieModel.get();
            List<CommentModel> commentModels = movie.getComments();
            CommentModel newComment = commentMapper.dtoToComment(commentDto);
            commentModels.add(newComment);
            movie.setComments(commentModels);
            movieRepository.save(movie);
            CommentDto commentDtoList = commentMapper.commentToDto(newComment);
            return ResponseEntity.status(HttpStatus.OK).body(commentDtoList);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    public ResponseEntity<List<CommentDto>> getAllMovieComments(Long movieId) throws RuntimeException {
        Optional<MovieModel> movieModel = movieRepository.findById(movieId);
        if (movieModel.isPresent()) {
            MovieModel movie = movieModel.get();
            List<CommentModel> commentModels = movie.getComments();
            List<CommentDto> commentDtoList = commentMapper.commentsToDto(commentModels);
            return ResponseEntity.status(HttpStatus.OK).body(commentDtoList);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    public ResponseEntity<CommentDto> getOne(Long id) throws RuntimeException {

        Optional<CommentModel> commentModel = commentRepository.findById(id);
        if (commentModel.isPresent()) {
            CommentModel comment = commentModel.get();
            return ResponseEntity.status(HttpStatus.OK).body(commentMapper.commentToDto(comment));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    public ResponseEntity<?> delete(Long id) throws RuntimeException {
        commentRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
