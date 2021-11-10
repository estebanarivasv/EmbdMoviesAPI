package com.erivas.embd.controllers;

import com.erivas.embd.data.dtos.CommentDto;
import com.erivas.embd.data.dtos.DirectorDto;

import com.erivas.embd.services.DirectorService;
import com.erivas.embd.utilities.constants.Endpoints;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoints.BASE_DIRECTORS)
class DirectorController {

    // GET individual - localhost/api/v1/directors/{id}
    // GET todos -      localhost/api/v1/directors

    private final DirectorService directorService;

    DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @ApiOperation(
            value = "Deletes comments by id",
            notes = "Provide an id to delete the specific comment",
            response = CommentDto.class
    )
    @GetMapping
    public ResponseEntity<List<DirectorDto>> findAll() {
        return directorService.getAll();
    }

    @ApiOperation(
            value = "Finds director by id",
            notes = "Provide an id to find the specific director",
            response = DirectorDto.class
    )
    @GetMapping(Endpoints.SINGLE_GENERIC)
    public ResponseEntity<DirectorDto> findById(
            @ApiParam(value = "directorId")
            @PathVariable Long id) {
        return directorService.getOne(id);
    }

}
