package com.erivas.embd.controllers;

import com.erivas.embd.data.models.ActorModel;
import com.erivas.embd.services.ActorService;
import com.erivas.embd.utilities.constants.Endpoints;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoints.BASE_ACTORS)
class ActorController {

    private final ActorService actorService;

    ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @ApiOperation(
            value = "Finds all the actors",
            notes = "Provide an id to look up specific contact from the address book",
            response = ActorModel.class
    )
    @GetMapping
    public ResponseEntity<List<ActorModel>> findAll() {
        return actorService.getAll();
    }

    @ApiOperation(
            value = "Finds actors by id",
            notes = "Provide an id to look up specific actor",
            response = ActorModel.class
    )
    @GetMapping(Endpoints.SINGLE_GENERIC)
    public ResponseEntity<ActorModel> findById(
            @ApiParam(value = "actorId")
            @PathVariable Long id) {
        return actorService.getOne(id);
    }

}
