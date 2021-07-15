package com.sword.trailersdb.services;

import com.sword.trailersdb.data.dtos.comment.CommentDto;
import com.sword.trailersdb.data.dtos.comment.PostCommentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    public CommentDto createComment(PostCommentDto postCommentDto) {
        ;
    }

    // The user can only edit the text and the rating associated with the movie
    // TODO: Restrict only to the user that posted that comment
    public CommentDto updateComment(Long id) {}

    public Void deleteComment(Long id) {}

    public CommentDto readComment(Long id) {}

    // TODO: Finish movie implementation
    // public List<CommentDto> readCommentsFromTrailer(Long commentId, Long movieId) {}


}
