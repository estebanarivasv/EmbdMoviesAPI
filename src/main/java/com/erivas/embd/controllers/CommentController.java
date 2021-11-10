package com.erivas.embd.controllers;

import com.erivas.embd.data.dtos.ActorDto;
import com.erivas.embd.data.dtos.CommentDto;
import com.erivas.embd.services.CommentService;
import com.erivas.embd.utilities.constants.Endpoints;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoints.BASE_COMMENTS)
public class CommentController {

    // POST -                   localhost/api/v1/comments
    // DELETE -                 localhost/api/v1/comments/{id}
    // GET (individual) -       localhost/api/v1/comments/{id}
    // GET (movie comments) -   localhost/api/v1/movies/{id}/comments

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ApiOperation(
            value = "Creates a new comment",
            notes = "Provide comment parameters in the body",
            response = CommentDto.class
    )
    @PostMapping(Endpoints.COMMENTS_FROM_MOVIE)
    public ResponseEntity<CommentDto> create(
            @ApiParam(value = "movieId")
            @PathVariable Long movieId, @RequestBody CommentDto commentDto) {
        return commentService.create(movieId, commentDto);
    }

    // TODO: ALL COMMENTS FOR A MOVIE
    @ApiOperation(
            value = "Finds all the comments in a movie",
            notes = "Provide an id to find up specific movie",
            response = CommentDto.class
    )
    @GetMapping(Endpoints.COMMENTS_FROM_MOVIE)
    public ResponseEntity<List<CommentDto>> findAll(
            @ApiParam(value = "movieId")
            @PathVariable Long movieId) {
        return commentService.getAllMovieComments(movieId);
    }

    @ApiOperation(
            value = "Finds comments by id",
            notes = "Provide an id to look up specific comment",
            response = CommentDto.class
    )
    @GetMapping(Endpoints.SINGLE_GENERIC)
    public ResponseEntity<CommentDto> findById(
            @ApiParam(value = "commentId")
            @PathVariable Long id) {
        return commentService.getOne(id);
    }

    @ApiOperation(
            value = "Deletes comments by id",
            notes = "Provide an id to delete the specific comment",
            response = CommentDto.class
    )
    @DeleteMapping(Endpoints.SINGLE_GENERIC)
    public ResponseEntity<?> delete(
            @ApiParam(value = "commentId")
            @PathVariable Long id) {
        return commentService.delete(id);
    }

}
