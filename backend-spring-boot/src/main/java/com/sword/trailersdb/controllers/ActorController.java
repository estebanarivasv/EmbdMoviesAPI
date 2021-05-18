package com.sword.trailersdb.controllers;

import com.sword.trailersdb.exceptions.ActorNotFoundException;
import com.sword.trailersdb.models.Actor;
import com.sword.trailersdb.repositories.ActorRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController   //@RestController indicates that the data returned by each method will be written straight into the response body instead of rendering a template.
class ActorController {
    private final ActorRepository repository;
    ActorController(ActorRepository repository) {
        this.repository = repository;
    }

    //GET ALL
    @GetMapping("/actors")
    List<Actor> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    //POST
    @PostMapping("/actors")
    Actor newActor(@RequestBody Actor newActor) {
        return repository.save(newActor);
    }

    //GET 1
    // Single item
    @GetMapping("/actors/{id}")
    Actor one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ActorNotFoundException(id));
    }

    //PUT
    @PutMapping("/actors/{id}")
    Actor replaceActor(@RequestBody Actor newActor, @PathVariable Long
            id) {
        return repository.findById(id)
                .map(actor -> {
                    actor.setName(newActor.getName());
                    // actor.setMovies(newActor.getMovies());
                    return repository.save(actor);
                })
                .orElseGet(() -> {
                    newActor.setId(id);
                    return repository.save(newActor);
                });
    }

    //DELETE
    @DeleteMapping("/employees/{id}")
    void deleteActor(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
