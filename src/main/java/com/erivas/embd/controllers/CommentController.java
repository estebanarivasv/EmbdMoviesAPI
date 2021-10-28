package com.erivas.embd.controllers;

import com.erivas.embd.data.dtos.CommentDto;
import com.erivas.embd.services.CommentService;
import com.erivas.embd.utilities.constants.Endpoints;
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


    @PostMapping
    public ResponseEntity<CommentDto> create(@RequestBody CommentDto commentDto) {
        return commentService.create(commentDto);
    }

    @GetMapping
    public ResponseEntity<List<CommentDto>> findAll() {
        return commentService.getAll();
    }

    @GetMapping(Endpoints.SINGLE_GENERIC)
    public ResponseEntity<CommentDto> findById(@PathVariable Long id) {
        return commentService.getOne(id);
    }

    @DeleteMapping(Endpoints.SINGLE_GENERIC)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return commentService.delete(id);
    }

}
