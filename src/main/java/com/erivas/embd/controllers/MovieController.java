package com.erivas.embd.controllers;

import com.erivas.embd.data.models.MovieModel;
import com.erivas.embd.services.MovieService;
import com.erivas.embd.utilities.constants.Endpoints;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoints.BASE_MOVIES)
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieModel>> findAll() {
        return movieService.getAll();
    }

    @GetMapping(Endpoints.SINGLE_GENERIC)
    public ResponseEntity<MovieModel> findById(
            @ApiParam(value = "movieId")
            @PathVariable Long id) {
        return movieService.getOne(id);
    }

}
