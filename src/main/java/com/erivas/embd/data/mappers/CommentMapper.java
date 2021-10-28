package com.erivas.embd.data.mappers;

import com.erivas.embd.data.dtos.CommentDto;
import com.erivas.embd.data.models.CommentModel;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(target = "datePosted", dateFormat = "yyyy-MM-dd hh:mm:ss")
    CommentDto commentToDto(CommentModel commentModel);

    List<CommentDto> commentsToDto(List<CommentModel> commentModels);

    @Mapping(target = "datePosted", ignore = true)
    @Mapping(target = "id", ignore = true)         // Ignores the id clause if parsed from a json
    @Mapping(target = "movie", ignore = true)
    @Mapping(target = "user", ignore = true)
    CommentModel dtoToComment(CommentDto commentDto);

}