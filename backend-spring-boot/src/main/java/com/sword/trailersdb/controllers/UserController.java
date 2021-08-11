package com.sword.trailersdb.controllers;

import com.sword.trailersdb.data.dtos.user.InputUserDto;
import com.sword.trailersdb.data.dtos.user.UserDto;
import com.sword.trailersdb.services.UserService;
import com.sword.trailersdb.utilities.constants.Endpoints;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(Endpoints.SPECIFIC_USER)
    ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.readUser(id));
    }

    @PutMapping(Endpoints.SPECIFIC_USER)
    ResponseEntity<UserDto> putUser(@RequestBody InputUserDto inputUserDto, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.updateUser(id, inputUserDto));
    }

}
