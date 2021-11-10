package com.erivas.embd.controllers;

import com.erivas.embd.data.dtos.MovieDto;
import com.erivas.embd.services.MovieService;
import com.erivas.embd.utilities.constants.Endpoints;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoints.BASE_MOVIES)
public class MovieController {

    // GET individual - localhost/api/v1/movies/{id}
    // GET todos -      localhost/api/v1/movies

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> findAll() {
        return movieService.getAll();
    }

    @GetMapping(Endpoints.SINGLE_GENERIC)
    public ResponseEntity<MovieDto> findById(
            @ApiParam(value = "movieId")
            @PathVariable Long id) {
        return movieService.getOne(id);
    }

}
