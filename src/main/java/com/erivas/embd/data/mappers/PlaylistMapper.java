package com.erivas.embd.data.mappers;

import com.erivas.embd.data.dtos.PlaylistDto;
import com.erivas.embd.data.models.PlaylistModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PlaylistMapper {

    PlaylistMapper INSTANCE = Mappers.getMapper(PlaylistMapper.class);

    PlaylistModel dtoToPlaylist(PlaylistDto playlistDto);

    void updatePlaylistFromDto(PlaylistDto playlistDto, @MappingTarget PlaylistModel playlistModel);

}