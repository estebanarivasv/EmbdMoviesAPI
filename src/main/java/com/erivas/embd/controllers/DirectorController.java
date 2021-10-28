package com.erivas.embd.controllers;

import com.erivas.embd.data.dtos.DirectorDto;

import com.erivas.embd.services.DirectorService;
import com.erivas.embd.utilities.constants.Endpoints;
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

    @GetMapping
    public ResponseEntity<List<DirectorDto>> findAll() {
        return directorService.getAll();
    }

    @GetMapping(Endpoints.SINGLE_GENERIC)
    public ResponseEntity<DirectorDto> findById(@PathVariable Long id) {
        return directorService.getOne(id);
    }

}
