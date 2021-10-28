package com.erivas.embd.data.mappers;

import com.erivas.embd.data.dtos.ActorDto;
import com.erivas.embd.data.dtos.MovieDto;
import com.erivas.embd.data.models.ActorModel;
import com.erivas.embd.data.models.MovieModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieDto movieToDto(MovieModel movieModel);

    List<MovieDto> moviesToDto(List<MovieModel> movieModels);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "directors", ignore = true)
    @Mapping(target = "actors", ignore = true)
    @Mapping(target = "playlists", ignore = true)
    MovieModel dtoToMovie(MovieDto movieDto);

}