package com.erivas.embd.controllers;

import com.erivas.embd.data.models.DirectorModel;
import com.erivas.embd.exceptions.ElementNotFoundException;
import com.erivas.embd.repositories.DirectorRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   //@RestController indicates that the data returned by each method will be written straight into the response body instead of rendering a template.
class DirectorController {

    // TODO: Refactor to services
    private final DirectorRepository repository;
    DirectorController(DirectorRepository repository) {
        this.repository = repository;
    }

    //GET ALL
    @GetMapping("/directors")
    List<DirectorModel> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    //POST
    @PostMapping("/directors")
    DirectorModel newDirector(@RequestBody DirectorModel newDirector) {
        return repository.save(newDirector);
    }

    //GET 1
    // Single item
    @GetMapping("/directors/{id}")
    DirectorModel one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id));
    }

    //PUT
    @PutMapping("/directors/{id}")
    DirectorModel replaceDirector(@RequestBody DirectorModel newDirector, @PathVariable Long
            id) {
        return repository.findById(id)
                .map(director -> {
                    director.setName(newActor.getName());
                    // director.setMovies(newActor.getMovies());
                    return repository.save(director);
                })
                .orElseGet(() -> {
                    newDirector.setId(id);
                    return repository.save(newDirector);
                });
    }

    //DELETE
    @DeleteMapping("/directors/{id}")
    void deleteDirector(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
