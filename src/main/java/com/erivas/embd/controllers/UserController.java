package com.erivas.embd.controllers;

import com.erivas.embd.data.dtos.UserDto;
import com.erivas.embd.services.UserService;
import com.erivas.embd.utilities.constants.Endpoints;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(Endpoints.BASE_USERS)
public class UserController {

    // PUT -                localhost/api/v1/users/{id}
    // GET (individual) -   localhost/api/v1/users/{id}

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(Endpoints.SINGLE_GENERIC)
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        return userService.getOne(id);
    }

    @PutMapping(Endpoints.SINGLE_GENERIC)
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.update(id, userDto);
    }


}
