package com.sword.trailersdb.controllers;

import com.sword.trailersdb.data.dtos.comment.CommentDto;
import com.sword.trailersdb.data.dtos.comment.PostCommentDto;
import com.sword.trailersdb.data.dtos.user.InputUserDto;
import com.sword.trailersdb.data.dtos.user.UserDto;
import com.sword.trailersdb.services.CommentService;
import com.sword.trailersdb.utilities.constants.Endpoints;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }
    
    @PostMapping(Endpoints.GLOBAL_COMMENTS)
    ResponseEntity<CommentDto> postComment(@RequestBody PostCommentDto postCommentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createComment(postCommentDto));
    }

    @PutMapping(Endpoints.SPECIFIC_COMMENT)
    ResponseEntity<CommentDto> putComment(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.updateComment(id));
    }

    @DeleteMapping(Endpoints.SPECIFIC_COMMENT)
    ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteComment(id));
    }

    @GetMapping(Endpoints.SPECIFIC_COMMENT)
    ResponseEntity<CommentDto> getComment(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.readComment(id));
    }

    //@GetMapping(Endpoints.COMMENTS_IN_MOVIE)
    //ResponseEntity<List<CommentDto>> getCommentsFromTrailer(@PathVariable Long commentId, @PathVariable Long movieId) {
    //    return ResponseEntity.status(HttpStatus.OK).body(service.readCommentsFromTrailer(commentId, movieId));
    //}
}
