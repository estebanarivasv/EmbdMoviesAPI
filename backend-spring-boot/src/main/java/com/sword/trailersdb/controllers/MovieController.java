package com.sword.trailersdb.controllers;

import com.sword.trailersdb.exceptions.ActorNotFoundException;
import com.sword.trailersdb.models.MovieModel;
import com.sword.trailersdb.repositories.ActorRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    // TODO: Refactor to services
}
