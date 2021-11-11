package com.erivas.embd.services;

import com.erivas.embd.data.dtos.PlaylistDto;
import com.erivas.embd.data.mappers.PlaylistMapper;
import com.erivas.embd.data.models.PlaylistModel;
import com.erivas.embd.repositories.PlaylistRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public ResponseEntity<PlaylistModel> create(PlaylistDto playlistDto) throws RuntimeException {
        PlaylistModel playlistModel = playlistMapper.dtoToPlaylist(playlistDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(playlistModel);
    }

    public ResponseEntity<List<PlaylistModel>> getAll() throws RuntimeException {
        List<PlaylistModel> playlistModels = playlistRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(playlistModels);
    }

    public ResponseEntity<PlaylistModel> getOne(Long id) throws RuntimeException {

        Optional<PlaylistModel> playlistModel = playlistRepository.findById(id);
        return playlistModel.map(model -> ResponseEntity.status(HttpStatus.OK).body(model))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));

    }

    public ResponseEntity<PlaylistModel> update(Long id, PlaylistDto playlistDto) throws RuntimeException {

        Optional<PlaylistModel> playlistModel = playlistRepository.findById(id);
        if (playlistModel.isPresent()) {
            PlaylistModel playlist = playlistModel.get();
            playlistMapper.updatePlaylistFromDto(playlistDto, playlist);
            playlistRepository.save(playlist);
            return ResponseEntity.status(HttpStatus.OK).body(playlist);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    public ResponseEntity<?> delete(Long id) throws RuntimeException {
        playlistRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
