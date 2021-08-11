package com.erivas.embd.data.mappers;

import com.erivas.embd.data.dtos.comment.CommentDto;
import com.erivas.embd.data.dtos.comment.EditCommentDto;
import com.erivas.embd.data.dtos.comment.PostCommentDto;
import com.erivas.embd.data.models.CommentModel;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentModel toEntity(PostCommentDto postCommentDto);

    CommentDto toDto(CommentModel commentModel);

    void updateCommentFromDto(EditCommentDto editCommentDto, @MappingTarget CommentModel commentModel);

}