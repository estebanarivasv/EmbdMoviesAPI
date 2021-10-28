package com.erivas.embd.services;

import com.erivas.embd.data.dtos.PlaylistDto;
import com.erivas.embd.data.mappers.PlaylistMapper;
import com.erivas.embd.data.models.PlaylistModel;
import com.erivas.embd.repositories.PlaylistRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final PlaylistMapper playlistMapper;

    public PlaylistService(PlaylistRepository playlistRepository, PlaylistMapper playlistMapper) {
        this.playlistRepository = playlistRepository;
        this.playlistMapper = playlistMapper;
    }

    public ResponseEntity<PlaylistDto> create(@RequestBody PlaylistDto playlistDto) throws RuntimeException {
        PlaylistModel playlistModel = playlistMapper.dtoToPlaylist(playlistDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                playlistMapper.playlistToDto(playlistRepository.save(playlistModel)));
    }

    public ResponseEntity<List<PlaylistDto>> getAll() throws RuntimeException {
        List<PlaylistModel> playlistModels = playlistRepository.findAll();
        List<PlaylistDto> playlistDtoList = playlistMapper.playlistsToDto(playlistModels);
        return ResponseEntity.status(HttpStatus.OK).body(playlistDtoList);
    }

    public ResponseEntity<PlaylistDto> getOne(@PathVariable Long id) throws RuntimeException {

        Optional<PlaylistModel> playlistModel = playlistRepository.findById(id);
        if (playlistModel.isPresent()) {
            PlaylistModel playlist = playlistModel.get();
            return ResponseEntity.status(HttpStatus.OK).body(playlistMapper.playlistToDto(playlist));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }

    public ResponseEntity<PlaylistDto> update(@PathVariable Long id, @RequestBody PlaylistDto playlistDto) throws RuntimeException {

        Optional<PlaylistModel> playlistModel = playlistRepository.findById(id);
        if (playlistModel.isPresent()) {
            PlaylistModel playlist = playlistModel.get();
            playlistMapper.updatePlaylistFromDto(playlistDto, playlist);
            playlistRepository.save(playlist);
            return ResponseEntity.status(HttpStatus.OK).body(playlistMapper.playlistToDto(playlist));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    public ResponseEntity<?> delete(@PathVariable Long id) throws RuntimeException {
        playlistRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
