package com.erivas.embd.controllers;

import com.erivas.embd.data.dtos.ActorDto;
import com.erivas.embd.data.mappers.ActorMapper;
import com.erivas.embd.data.models.ActorModel;
import com.erivas.embd.services.ActorService;
import com.erivas.embd.utilities.constants.Endpoints;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @ApiOperation(
            value = "Finds all the actors",
            notes = "Provide an id to look up specific contact from the address book",
            response = ActorDto.class
    )
    @GetMapping
    public ResponseEntity<List<ActorDto>> findAll() {
        return actorService.getAll();
    }

    @ApiOperation(
            value = "Finds actors by id",
            notes = "Provide an id to look up specific actor",
            response = ActorDto.class
    )
    @GetMapping(Endpoints.SINGLE_GENERIC)
    public ResponseEntity<ActorDto> findById(
            @ApiParam(value = "actorId")
            @PathVariable Long id) {
        return actorService.getOne(id);
    }

}
