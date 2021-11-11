package com.erivas.embd.controllers;

import com.erivas.embd.data.dtos.CommentDto;
import com.erivas.embd.data.models.DirectorModel;

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
    public ResponseEntity<List<DirectorModel>> findAll() {
        return directorService.getAll();
    }

    @ApiOperation(
            value = "Finds director by id",
            notes = "Provide an id to find the specific director",
            response = DirectorModel.class
    )
    @GetMapping(Endpoints.SINGLE_GENERIC)
    public ResponseEntity<DirectorModel> findById(
            @ApiParam(value = "directorId")
            @PathVariable Long id) {
        return directorService.getOne(id);
    }

}
