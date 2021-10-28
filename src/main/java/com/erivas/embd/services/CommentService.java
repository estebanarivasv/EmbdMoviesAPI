package com.erivas.embd.services;


import com.erivas.embd.data.dtos.CommentDto;
import com.erivas.embd.data.mappers.CommentMapper;
import com.erivas.embd.data.models.CommentModel;
import com.erivas.embd.repositories.CommentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    public ResponseEntity<CommentDto> create(@RequestBody CommentDto commentDto) throws RuntimeException {
        CommentModel commentModel = commentMapper.dtoToComment(commentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                commentMapper.commentToDto(commentRepository.save(commentModel)));
    }

    public ResponseEntity<List<CommentDto>> getAll() throws RuntimeException {
        List<CommentModel> commentModels = commentRepository.findAll();
        List<CommentDto> commentDtoList = commentMapper.commentsToDto(commentModels);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoList);
    }

    public ResponseEntity<CommentDto> getOne(@PathVariable Long id) throws RuntimeException {

        Optional<CommentModel> commentModel = commentRepository.findById(id);
        if (commentModel.isPresent()) {
            CommentModel comment = commentModel.get();
            return ResponseEntity.status(HttpStatus.OK).body(commentMapper.commentToDto(comment));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    public ResponseEntity<?> delete(@PathVariable Long id) throws RuntimeException {
        commentRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
