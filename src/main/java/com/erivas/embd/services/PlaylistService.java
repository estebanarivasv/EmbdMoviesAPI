package com.erivas.embd.services;

import com.erivas.embd.data.dtos.PlaylistDto;
import com.erivas.embd.data.mappers.PlaylistMapper;
import com.erivas.embd.data.models.CommentModel;
import com.erivas.embd.data.models.MovieModel;
import com.erivas.embd.data.models.PlaylistModel;
import com.erivas.embd.data.models.UserModel;
import com.erivas.embd.repositories.PlaylistRepository;
import com.erivas.embd.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final UserRepository userRepository;
    private final PlaylistMapper playlistMapper;

    public PlaylistService(PlaylistRepository playlistRepository, UserRepository userRepository, PlaylistMapper playlistMapper) {
        this.playlistRepository = playlistRepository;
        this.userRepository = userRepository;
        this.playlistMapper = playlistMapper;
    }


    public ResponseEntity<PlaylistModel> create(PlaylistDto playlistDto) throws RuntimeException {
        Optional<UserModel> userModel = userRepository.findById(playlistDto.userId);
        if (userModel.isPresent()) {
            UserModel user = userModel.get();
            PlaylistModel playlistModel = playlistMapper.dtoToPlaylist(playlistDto);
            playlistModel.setUser(user);
            playlistRepository.save(playlistModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(playlistModel);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
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

    public ResponseEntity<?> delete(Long id) throws RuntimeException {
        playlistRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
