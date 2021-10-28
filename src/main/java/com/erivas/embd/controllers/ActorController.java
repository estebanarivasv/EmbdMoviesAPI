package com.erivas.embd.controllers;

import com.erivas.embd.data.dtos.ActorDto;
import com.erivas.embd.data.mappers.ActorMapper;
import com.erivas.embd.data.models.ActorModel;
import com.erivas.embd.services.ActorService;
import com.erivas.embd.utilities.constants.Endpoints;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Endpoints.BASE_ACTORS)
class ActorController {

    // GET individual -     localhost/api/v1/actors/{id}
    // GET todos -          localhost/api/v1/actors

    private final ActorService actorService;

    ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public ResponseEntity<List<ActorDto>> findAll() {
        return actorService.getAll();
    }

    @GetMapping(Endpoints.SINGLE_GENERIC)
    public ResponseEntity<ActorDto> findById(@PathVariable Long id) {
        return actorService.getOne(id);
    }

}
