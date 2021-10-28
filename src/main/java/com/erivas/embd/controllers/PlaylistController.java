package com.erivas.embd.controllers;

import com.erivas.embd.data.dtos.PlaylistDto;
import com.erivas.embd.services.PlaylistService;
import com.erivas.embd.utilities.constants.Endpoints;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoints.BASE_PLAYLISTS)
public class PlaylistController {

    // GET individual - localhost/api/v1/playlists/{id}
    // PUT -            localhost/api/v1/playlists/{id}
    // DELETE -         localhost/api/v1/playlists/{id}
    // POST -           localhost/api/v1/playlists
    // GET todos -      localhost/api/v1/playlists


    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping
    public ResponseEntity<PlaylistDto> create(@RequestBody PlaylistDto playlistDto) {
        return playlistService.create(playlistDto);
    }

    @GetMapping
    public ResponseEntity<List<PlaylistDto>> findAll() {
        return playlistService.getAll();
    }

    @GetMapping(Endpoints.SINGLE_GENERIC)
    public ResponseEntity<PlaylistDto> findById(@PathVariable Long id) {
        return playlistService.getOne(id);
    }

    @PutMapping(Endpoints.SINGLE_GENERIC)
    public ResponseEntity<PlaylistDto> update(@PathVariable Long id, @RequestBody PlaylistDto playlistDto) {
        return playlistService.update(id, playlistDto);
    }

    @DeleteMapping(Endpoints.SINGLE_GENERIC)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return playlistService.delete(id);
    }



}
