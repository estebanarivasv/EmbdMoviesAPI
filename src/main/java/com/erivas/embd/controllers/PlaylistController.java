package com.erivas.embd.controllers;

import com.erivas.embd.data.dtos.PlaylistDto;
import com.erivas.embd.data.models.PlaylistModel;
import com.erivas.embd.services.PlaylistService;
import com.erivas.embd.utilities.constants.Endpoints;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoints.BASE_PLAYLISTS)
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping
    public ResponseEntity<PlaylistModel> create(@RequestBody PlaylistDto playlistDto) {
        return playlistService.create(playlistDto);
    }

    @GetMapping
    public ResponseEntity<List<PlaylistModel>> findAll() {
        return playlistService.getAll();
    }

    @GetMapping(Endpoints.SINGLE_GENERIC)
    public ResponseEntity<PlaylistModel> findById(
            @ApiParam(value = "playlistId")
            @PathVariable Long id) {
        return playlistService.getOne(id);
    }

    @PutMapping(Endpoints.SINGLE_GENERIC)
    public ResponseEntity<PlaylistModel> update(
            @ApiParam(value = "playlistId")
            @PathVariable Long id,
            @RequestBody PlaylistDto playlistDto) {
        return playlistService.update(id, playlistDto);
    }

    @DeleteMapping(Endpoints.SINGLE_GENERIC)
    public ResponseEntity<?> delete(
            @ApiParam(value = "playlistId")
            @PathVariable Long id) {
        return playlistService.delete(id);
    }



}
