package com.erivas.embd.services;


import com.erivas.embd.data.dtos.CommentDto;
import com.erivas.embd.data.mappers.CommentMapper;
import com.erivas.embd.data.models.CommentModel;
import com.erivas.embd.data.models.MovieModel;
import com.erivas.embd.data.models.UserModel;
import com.erivas.embd.repositories.CommentRepository;
import com.erivas.embd.repositories.MovieRepository;
import com.erivas.embd.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final CommentMapper commentMapper;

    public CommentService(CommentRepository commentRepository, MovieRepository movieRepository, UserRepository userRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
        this.commentMapper = commentMapper;
    }

    public ResponseEntity<CommentModel> create(Long movieId, CommentDto commentDto) throws RuntimeException {
        Optional<MovieModel> movieModel = movieRepository.findById(movieId);
        Optional<UserModel> userModel = userRepository.findById(commentDto.userId);
        if (movieModel.isPresent() && userModel.isPresent()) {
            MovieModel movie = movieModel.get();
            UserModel user = userModel.get();
            CommentModel newComment = commentMapper.dtoToComment(commentDto);
            newComment.setUser(user);
            newComment.setMovie(movie);
            commentRepository.save(newComment);
            return ResponseEntity.status(HttpStatus.OK).body(newComment);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    public ResponseEntity<List<CommentModel>> getAllMovieComments(Long movieId) throws RuntimeException {
        Optional<MovieModel> movieModel = movieRepository.findById(movieId);
        if (movieModel.isPresent()) {
            MovieModel movie = movieModel.get();
            return ResponseEntity.status(HttpStatus.OK).body(movie.getComments());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    public ResponseEntity<CommentModel> getOne(Long id) throws RuntimeException {

        Optional<CommentModel> commentModel = commentRepository.findById(id);
        if (commentModel.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(commentModel.get());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    public ResponseEntity<?> delete(Long id) throws RuntimeException {
        commentRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
