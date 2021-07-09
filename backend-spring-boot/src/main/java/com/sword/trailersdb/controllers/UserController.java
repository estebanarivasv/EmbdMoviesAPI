package com.sword.trailersdb.controllers;

import com.sword.trailersdb.models.UserModel;
import com.sword.trailersdb.repositories.UserRepository;
import com.sword.trailersdb.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class UserController {

    private final UserRepository repository;
    private final UserService service;

    public UserController(UserRepository repository, UserService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/users/{id}")
    Optional<UserModel> getById(@PathVariable Long id) {
        // TODO: Return element not found exception
        return repository.findById(id);
    }

    @PutMapping("/users/{id}")
    UserModel editUser(@RequestBody UserModel editedUser, @PathVariable Long id) {
        // TODO: Define DTOs and mappers
        return repository.findById(id)
                .map(user -> {
                    user.setName(editedUser.getName());
                    user.setEmail(editedUser.getEmail());
                    user.setComments(editedUser.getComments());
                    user.setPassword(editedUser.getPassword());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    editedUser.setId(id);
                    return repository.save(editedUser);
                });
    }

}
