package com.erivas.embd.data.mappers;

import com.erivas.embd.data.dtos.ActorDto;
import com.erivas.embd.data.dtos.PlaylistDto;
import com.erivas.embd.data.models.ActorModel;
import com.erivas.embd.data.models.PlaylistModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PlaylistMapper {

    PlaylistMapper INSTANCE = Mappers.getMapper(PlaylistMapper.class);

    PlaylistDto playlistToDto(PlaylistModel playlistModel);

    List<PlaylistDto> playlistsToDto(List<PlaylistModel> playlistModels);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "movies", ignore = true)
    PlaylistModel dtoToPlaylist(PlaylistDto playlistDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "movies", ignore = true)
    void updatePlaylistFromDto(PlaylistDto playlistDto, @MappingTarget PlaylistModel playlistModel);

}